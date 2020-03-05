import socket
import threading
import sys


class ChatClient:
    server_addr = ("127.0.0.1", 10010)
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    using_udp = False
    buff = []
    running = False

    def __init__(self):
        nick = input('Client starting, what is your nick?\n')
        self.connect(nick)
        print(self.tcp_socket.getsockname())
        self.udp_socket.bind(self.tcp_socket.getsockname())  # ensure same port for UDP/TCP
        self.receive_tcp = threading.Thread(target=self.wait_for_tcp_messages)
        self.receive_udp = threading.Thread(target=self.wait_for_udp_messages)

    def start(self):
        self.running = True
        self.receive_tcp.start()
        self.receive_udp.start()
        self.send_messages()

    def connect(self, nick: str):
        self.tcp_socket.connect(self.server_addr)
        self._send_message(f'REGISTER {nick}')

    def send_messages(self):
        while True:
            msg = input('Your message to others:\n')
            if msg == 'U':
                self.using_udp = not self.using_udp
                print('Switched communication mode, now using', 'UDP' if self.using_udp else 'TCP')
            else:
                self._send_message(msg)

    def quit(self):
        self.running = False
        self.tcp_socket.send('UNREGISTER'.encode('utf-8'))
        self.udp_socket.close()
        self.tcp_socket.close()

    def wait_for_tcp_messages(self):
        while self.running:
            buff = self.tcp_socket.recv(4096)
            self._log_message(buff)

    def wait_for_udp_messages(self):
        while self.running:
            buff = self.udp_socket.recv(4096)
            self._log_message(buff)

    @staticmethod
    def _log_message(buff):
        received = str(buff, 'utf-8')
        print('-' * 50)
        print(received)
        print('-' * 50)

    def _send_message(self, msg):
        msg = msg.encode('utf-8')
        if self.using_udp:
            self.udp_socket.sendto(msg, self.server_addr)
        else:
            self.tcp_socket.send(msg)


if __name__ == '__main__':
    client = ChatClient()
    try:
        client.start()
    except KeyboardInterrupt:
        client.quit()
        sys.exit(0)
