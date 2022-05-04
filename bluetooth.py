from bluetooth import *
import json
import socketserver

client_socket=BluetoothSocket(RFCOMM)
client_socket.connect(("7C:9E:BD:4B:69:B2",1))


try:
    while True:
        msg = client_socket.recv(1024)
        result = msg.decode('utf-8')
        dic2 = json.loads(result)
        value1 = dic2['value1']
        value2 = dic2['value2']
        print(value1)
        print(value2)
        #print("recived message : {}".format(msg))
        
        if int(value1) >= 1500:
            print(value1)
            
            
        else:
            
            print('bye')
except KeyboardInterrupt:
    print("Finished")
    client_socket.close()

