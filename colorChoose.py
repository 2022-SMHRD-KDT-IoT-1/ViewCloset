import cv2
import time

cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 1280)
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 720)


while True:
    ret, frame = cap.read()
    if not ret:
        print("Warnning caemrea can't read")
        break
    
    hsv_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    height,width, _ = frame.shape
    
    cx = int(width / 2)
    cy = int(height / 2)
    
    pixel_center = hsv_frame[cy,cx]
    hue_value = pixel_center[0]
    h, s, v = pixel_center
    s_per = s / 255
    v_per = v / 255
    print("s is %f" %s_per)
    time.sleep(1)
    print(v_per)
    time.sleep(1)
    color = "Undefined"
    time.sleep(1)
    if s_per < 0.1:
        if v_per > 0.5:
            color = "white"
            print("white")
            time.sleep(1)
        elif v_per > 0.62:
            color = "gray"
            print("gray")       
        
        elif v_per < 0.5 :
            color = "black"
            print("black")
            time.sleep(1)
    elif s_per >= 0.1:
        if v_per >= 0.47 and v_per < 0.5:
            color = "brown"
            print("brown")
        elif v_per > 0.45 and v_per < 0.65:
            color = "grey"
            print("grey")
        
        elif hue_value < 5:
            color = "RED"
            print("red")
            time.sleep(1)
                
        elif hue_value < 22:
            color = "ORANGE"
            print("orange")
            time.sleep(1)
                
        elif hue_value < 33:
            color = "YELLOW"
            print("yellow")
            time.sleep(1)
            
                
        elif hue_value < 78:
            color = "GREEN"
            print('green')
            time.sleep(1)
            
                
        elif hue_value < 131:
            color = "BLUE"
            print('blue')
            time.sleep(1)
                
        elif hue_value < 170:
            color = "VIOLET"
            print('violet')
            time.sleep(1)
                
    
    
    
    pixel_center_bgr = frame[cy,cx]
    b, g, r = int(pixel_center_bgr[0]), int(pixel_center_bgr[1]), int(pixel_center_bgr[2])
    cv2.putText(frame, color, (10, 70), 0, 1.5, (b, g, r), 2)
    cv2.circle(frame, (cx, cy), 5, (25, 25, 25), 3)
    
    cv2.imshow("Frame",frame)
    key = cv2.waitKey(1)            
    if key == 27:
        break
    
cap.release()
cv2.destroyAllWindows()
    