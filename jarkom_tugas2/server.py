import socket
import threading
import logging
import time
import sys

class ClientHandler(threading.Thread):
    def __init__(self, conn, addr):
        super().__init__()
        self.conn = conn
        self.addr = addr

    def run(self):
        buffer = ""
        while True:
            data = self.conn.recv(32).decode('utf-8')
            if data:
                buffer += data
                while "\r\n" in buffer:
                    command, buffer = buffer.split("\r\n", 1)
                    logging.warning(f"[SERVER] received {command}")
                    if command == "TIME":
                        current_time = time.strftime("%H:%M:%S")
                        response = f"TIME {current_time}\r\n"
                        self.conn.sendall(response.encode('utf-8'))
                    elif command == "QUIT":
                        self.conn.sendall("Exiting...\r\n".encode('utf-8'))
                        self.conn.close()
                        return
                    else:
                        self.conn.sendall("Unknown request\r\n".encode('utf-8'))
            else:
                break
        self.conn.close()

class ThreadedServer(threading.Thread):
    def __init__(self):
        super().__init__()
        self.clients = []
        self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

    def run(self):
        self.server_socket.bind(('0.0.0.0', 45000))
        self.server_socket.listen(1)
        logging.warning("Server running and listening on port 45000")
        while True:
            conn, addr = self.server_socket.accept()
            logging.warning(f"Connection from {addr}")
            client_thread = ClientHandler(conn, addr)
            client_thread.start()
            self.clients.append(client_thread)

def main():
    server = ThreadedServer()
    server.start()

if __name__ == "__main__":
    logging.basicConfig(level=logging.WARNING, format='%(asctime)s - %(levelname)s - %(message)s')
    main()
