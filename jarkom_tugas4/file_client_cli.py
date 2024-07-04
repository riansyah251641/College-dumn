import socket
import json
import base64
import logging
import sys

server_address = ('172.16.16.101', 8080)

def send_command(command_str=""):
    global server_address
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect(server_address)
    logging.warning(f"connecting to {server_address}")
    try:
        logging.warning(f"sending message ")
        sock.sendall(command_str.encode())
        # Look for the response, waiting until socket is done (no more data)
        data_received = ""  # empty string
        while True:
            data = sock.recv(8192)
            if data:
                data_received += data.decode()
                if "\r\n\r\n" in data_received:
                    break
            else:
                break
        hasil = json.loads(data_received)
        logging.warning("data received from server:")
        return hasil
    except Exception as e:
        logging.warning(f"error during data receiving: {str(e)}")
        return False
    finally:
        sock.close()

def remote_list():
    command_str = "LIST"
    hasil = send_command(command_str)
    if hasil and hasil['status'] == 'OK':
        print("Daftar file:")
        for nmfile in hasil['data']:
            print(f"- {nmfile}")
        return True
    else:
        print("Gagal")
        return False

def remote_get(filename=""):
    command_str = f"GET {filename}"
    hasil = send_command(command_str)
    if hasil and hasil['status'] == 'OK':
        namafile = hasil['data_namafile']
        isifile = base64.b64decode(hasil['data_file'])
        with open(namafile, 'wb') as fp:
            fp.write(isifile)
        print(f"File '{namafile}' berhasil diunduh.")
        return True
    else:
        print("Gagal")
        return False

def remote_upload(filename=""):
    try:
        with open(filename, 'rb') as f:
            file_content = base64.b64encode(f.read()).decode()
        command_str = f"UPLOAD {filename} {file_content}"
        hasil = send_command(command_str)
        if hasil and hasil['status'] == 'OK':
            print(hasil['data'])
            return True
        else:
            print("Gagal")
            return False
          
    except FileNotFoundError:
        print(f"File '{filename}' tidak ditemukan.")
        return False
    except Exception as e:
        print(f"Terjadi kesalahan: {str(e)}")
        return False

def remote_delete(filename=""):
    command_str = f"DELETE {filename}"
    hasil = send_command(command_str)
    if hasil and hasil['status'] == 'OK':
        print(hasil['data'])
        return True
    else:
        print("Gagal")
        return False

if __name__ == '__main__':
    if len(sys.argv) < 2:
        remote_list()
        print("Usage: python script.py <command> <filename>")
        sys.exit(1)
    
    command = sys.argv[1]
    filename = sys.argv[2] if len(sys.argv) > 2 else ''

    if command == 'upload':
        if filename:
            remote_upload(filename)
        else:
            print("Mohon berikan nama file untuk diupload.")
    elif command == 'delete':
        if filename:
            remote_delete(filename)
        else:
            print("Mohon berikan nama file untuk dihapus.")
    else:
        print(f"Perintah tidak dikenali '{command}'. Perintah yang didukung: 'upload', 'delete'")
        sys.exit(1)

