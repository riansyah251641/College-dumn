import sys
import socket
import logging
import time

def send_data(message):
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # logging.warning("opening socket")
    # IP address and port for mesin-1 (server)
    server_info = ('172.16.16.101', 45000)
    logging.warning(f"opening socket {server_info}")
    client_socket.connect(server_info)

    try:
        # Send the message
        logging.warning(f"[CLIENT] sending {message}")
        client_socket.sendall(message.encode('utf-8'))
        # Wait for the response
        response = client_socket.recv(32)
        logging.warning(f"[RECEIVED FROM SERVER] {response.decode('utf-8')}")
    finally:
        logging.warning("closing socket")
        client_socket.close()
    return

if __name__ == '__main__':
    send_data("TIME\r\n")
    send_data("HELLO\r\n")
    send_data("QUIT\r\n")
