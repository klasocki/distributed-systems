import socket;

serverPort = 9009
serverSocket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
serverSocket.bind(('', serverPort))
buff = []

print('PYTHON UDP SERVER')

while True:

    buff, address = serverSocket.recvfrom(1024)
    received = str(buff, 'cp1250').split(':')
    print("python udp server received msg: " + received[1])
    msg = "Pong " + received[0]
    serverSocket.sendto(msg.encode('utf-8'), address)





