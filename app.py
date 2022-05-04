from cgitb import grey
from datetime import datetime
import firebase_admin
from firebase_admin import credentials

PROJECT_ID = "viewcloset-7c705"
cred = credentials.Certificate('/home/pi/viewcloset-7c705-firebase-adminsdk-cgpg9-0545623412.json')
default_app = firebase_admin.initialize_app(cred, {'storageBucket':f"{PROJECT_ID}.appspot.com"})


import cv2
from PIL import Image
from io import BytesIO
from flask import Flask, Response,  send_file
from CameraService import CameraService
from bluetooth import *
import json
from threading import Timer
import os
from firebase_admin import storage
from uuid import uuid4
from recog import get_lables
from firebase_admin import firestore


client_socket=BluetoothSocket(RFCOMM)
client_socket.connect(("7C:9E:BD:4B:69:B2",1))

save_path = 'recode'

app = Flask(__name__)
cap = CameraService(0)
cap.start()

PAGE = """\
<html>
<head>
<title>Raspberry Pi - MATCH & FIX Camera</title>
</head>
<body>
<center><h1>Raspberry Pi - Viewcloset Camera</h1></center>
<center><img src="stream.mjpg" width="640" height="480"></center>
</body>
</html>
"""


light_value = None
tag_value = None
global cnt 
cnt = 1
cntu = 0


bucket = storage.bucket()


def fileUpload(file):
    blob = bucket.blob('image_store/'+ os.path.basename(file))
    new_token = uuid4()
    metadata = {"firebaseStorageDownloadTokens": new_token}
    blob.metadata = metadata

    blob.upload_from_filename(filename=file, content_type='image/jpg')


def sensor_update():
    #os.system("./start_assistant.sh")
    
    
    global cnt 
    global cntu
    msg = client_socket.recv(1024)
    result = msg.decode('utf-8')
    try:
        
        dic2 = json.loads(result)

        light_value = dic2['value1']
        tag_value = dic2['value2']
        print('light_value: ', light_value)
        print('tag: ', tag_value)

        if tag_value != '':
            frame = cap.read()
            if frame is not None:
                imgRGB = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
                jpg = Image.fromarray(imgRGB)
                filename = f'/home/pi/work/pi-camera-demo/image/{str(cnt)}.jpg'
                #filename = f'/home/pi/Downloads/static/{str(cnt)}.jpg'
                f = open(filename, 'wb')
                jpg.save(f, 'JPEG')
                f.close()
                cnt += 1
                fileUpload(filename) 
                print(get_lables(filename))
                print(hsv(frame))

                cntu += 1
                db = firestore.client()
                doc_ref = db.collection('view_closet').document('member').collection("id").document("BcM7JhCT6nMJ3zfVcDAi3bwOp592")
                doc_ref.update({
                "tag{}".format(cntu) : tag_value,
                "color{}".format(cntu) : hsv(frame),
                "type{}".format(cntu) : "hood"            
                })
                
       
               
    except Exception as err:
        print(err)
    
    Timer(0.2, sensor_update).start()
    # Timer(0.3, os.system("./start_assistant.sh")).start()
    
sensor_update()

@app.route("/")
def hello_world():
    return PAGE


def cameraRead(camera):
    while True:
        frame = camera.read()
        if frame is not None:
            imgRGB = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            jpg = Image.fromarray(imgRGB)
            content = BytesIO()
            jpg.save(content, 'JPEG')
            yield (b'--frame\r\n'
                   b'Content-Type: image/jpeg\r\n\r\n' + content.getvalue() + b'\r\n')


@app.route('/stream.mjpg')
def stream():
    response = Response(cameraRead(cap),
                        mimetype='multipart/x-mixed-replace; boundary=frame')
    return response


@app.route('/recode/<name>')
def recode(name):
    cap.recode(f'{name}.mp4')
    return ('', 204)

@app.route('/save')
def save():
    cap.save()
    return ('', 204)

@app.route('/download/<name>')
def download(name):
    return send_file(f'{save_path}/{name}.mp4', as_attachment=True)

@app.route('/snapshot')
def snapshot():
    frame = cap.read()
    imgRGB = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    jpg = Image.fromarray(imgRGB)
    content = BytesIO()
    jpg.save(content, 'JPEG')
    return Response(content.getvalue(), mimetype='image/jpeg')


def hsv(frame):
    hsv_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    height,width, _ = frame.shape
    
    cx = int(width / 2)
    cy = int(height / 2)
    
    pixel_center = hsv_frame[cy,cx]
    hue_value = pixel_center[0]
    h, s, v = pixel_center
    s_per = s / 255
    v_per = v / 255
    color = None
    if s_per < 0.1:
        if v_per >= 0.5:
            color = "white"
        
        elif v_per > 0.62:
            color = "gray"
                      
        elif v_per < 0.5 :
            color = "black"
        
            
    else:
        if v_per >= 0.47 and v_per < 0.5:
            color = "brown"
            

        elif hue_value < 5:
            color = "RED"
                
        elif hue_value < 22:
            color = "ORANGE"
                
        elif hue_value < 33:
            color = "YELLOW"
                
        elif hue_value < 78:
            color = "GREEN"
                
        elif hue_value < 131:
            color = "BLUE"
                
        elif hue_value < 170:
            color = "VIOLET"
    
    return color.lower() 

if __name__ == '__main__':
    app.run(host="0.0.0.0", threaded=True)
