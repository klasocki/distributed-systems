import socket
from concurrent.futures import ThreadPoolExecutor


class ChatServer:
    server_port = 10011
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    clients = {}
    max_clients = 128

    def __init__(self):
        self.udp_socket.bind(('', self.server_port))
        self.tcp_socket.bind(('', self.server_port))
        self.tcp_socket.listen()
        print('CHAT SERVER STARTING')

    def serve(self):
        with ThreadPoolExecutor(max_workers=self.max_clients) as executor:
            executor.submit(self._handle_udp)
            try:
                while True:
                    client, address = self.tcp_socket.accept()
                    executor.submit(self._handle_client, client, address)
            except KeyboardInterrupt:
                print('Quiting...')
                self.tcp_socket.close()

    def _handle_udp(self):
        try:
            buff, sender_addr = self.udp_socket.recvfrom(65536)
            if not buff:
                return
            msg = str(buff, 'utf-8').strip()
            print(f'Server received UDP message from {sender_addr}: {msg}')
            for recipient_addr in self.clients.keys():
                if recipient_addr != sender_addr:
                    self._send_udp_message(msg, recipient_addr)
            self._handle_udp()
        except KeyboardInterrupt:
            self.udp_socket.close()
            return
        except socket.timeout:
            self._handle_udp()

    def _handle_client(self, client: socket.socket, sender_addr):
        try:
            buff = client.recv(65536)
            if not buff:
                return
            msg = str(buff, 'utf-8').strip()
            print(f'Server received TCP message from {sender_addr}: {msg}')
            if msg.startswith('REGISTER'):
                nick = msg.split(maxsplit=1)[1]
                self.clients[sender_addr] = nick, client
                self._send_tcp_message(f'{nick} registered successfully', client)
            elif msg.startswith('UNREGISTER'):
                nick, _ = self.clients.pop(sender_addr)
                self._send_tcp_message(f'{nick} unregistered successfully', client)
                client.close()
                return
            else:
                for recipient_addr in self.clients.keys():
                    if recipient_addr != sender_addr:
                        self._send_tcp_message(msg, self.clients[recipient_addr][1])
            self._handle_client(client, sender_addr)
        except KeyboardInterrupt:
            client.close()
            return
        except socket.timeout:
            self._handle_client(client, sender_addr)

    @staticmethod
    def _send_tcp_message(msg, client: socket.socket):
        client.send(msg.encode('utf-8'))

    def _send_udp_message(self, msg, address):
        self.udp_socket.sendto(msg.encode('utf-8'), address)


if __name__ == '__main__':
    server = ChatServer()
    server.serve()
