import socket
import threading
import sys
import struct


class ChatClient:
    server_addr = ("127.0.0.1", 10010)
    multicast_group = '224.1.1.1', 10001
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    multicast_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
    multicast_ttl = 2
    using_udp = False
    using_multicast = False
    buff = []
    running = False

    def __init__(self):
        self.nick = input('Client starting, what is your nick?\n')
        self.connect()

        self.multicast_socket.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, self.multicast_ttl)
        self.multicast_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        self.multicast_socket.bind(('', self.multicast_group[1]))
        group = socket.inet_aton(self.multicast_group[0])
        mreq = struct.pack('4sL', group, socket.INADDR_ANY)
        self.multicast_socket.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)

        self.udp_socket.bind(self.tcp_socket.getsockname())  # ensure same port for UDP/TCP

        self.receive_tcp = threading.Thread(target=self.wait_for_tcp_messages)
        self.receive_udp = threading.Thread(target=self.wait_for_udp_messages)
        self.reveive_multicast = threading.Thread(target=self.wait_for_multicast_messages)

    def start(self):
        self.running = True
        self.receive_tcp.start()
        self.receive_udp.start()
        self.reveive_multicast.start()
        self.send_messages()

    def connect(self):
        self.tcp_socket.connect(self.server_addr)
        self.tcp_socket.send(f'REGISTER {self.nick}'.encode('utf-8'))

    def send_messages(self):
        while True:
            msg = input('Your message to others:\n')
            if msg == 'M':
                self.using_multicast = True
                print('Switched communication mode to multicast (UDP)')
            elif msg == 'U':
                self.using_udp = not self.using_udp
                self.using_multicast = False
                print('Switched communication mode, now using', 'UDP' if self.using_udp else 'TCP')
            else:
                self._send_message_with_nick(msg)

    def quit(self):
        self.running = False
        self.tcp_socket.send('UNREGISTER'.encode('utf-8'))
        self.udp_socket.close()
        self.tcp_socket.close()
        self.multicast_socket.close()

    def wait_for_tcp_messages(self):
        while self.running:
            buff = self.tcp_socket.recv(4096)
            # if not buff:
            #     return
            self._log_message(buff)

    def wait_for_udp_messages(self):
        while self.running:
            buff = self.udp_socket.recv(4096)
            # if not buff:
            #     return
            self._log_message(buff)

    def wait_for_multicast_messages(self):
        while self.running:
            buff = self.multicast_socket.recv(4096)
            # if not buff:
            #     return
            self._log_message(buff)

    @staticmethod
    def _log_message(buff):
        received = str(buff, 'utf-8')
        print('-' * 50)
        print(received)
        print('-' * 50)

    def _send_message_with_nick(self, msg):
        msg = f"From {self.nick}: {msg}".encode('utf-8')
        if self.using_multicast:
            self.multicast_socket.sendto(msg, self.multicast_group)
        elif self.using_udp:
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
