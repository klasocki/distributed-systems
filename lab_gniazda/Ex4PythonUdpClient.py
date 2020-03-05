import socket;

serverIP = "127.0.0.1"
serverPort = 9009
clientPort = 7008
msg = "Python:Hey"

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.bind(('', clientPort))
client.sendto(msg.encode('utf-8'), (serverIP, serverPort))

buff, address = client.recvfrom(1024)
print('Received msg:', str(buff, 'cp1250'))



