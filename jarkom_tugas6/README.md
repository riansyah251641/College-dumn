### Server Mesin1
Lokasi Port      : 8889
Lokasi Program   : .ChatAppWithFlet/Mesin1 (Chat App)/ChatServer.py

### Client Mesin1
Ip Destination    : 172.16.16.101
Port Destination  : 8889

### Server Mesin2
Lokasi Port      : 8890
Lokasi Program   : .ChatAppWithFlet/Mesin1 (Chat App)/ChatServer.py

### Client Mesin1
Ip Destination    : 172.16.16.102
Port Destination  : 8890

## Komunikasi dalam satu server

1. Login: `auth [username] [password]` contoh `auth messi surabaya`

2. Register: `register [username] [password] [nama (gunakan "_" untuk seperator) ] [negara]` contoh `register joni admin joni_perkasa Indonesia`

3. Buat group: `addgroup [nama_group]` contoh `addgroup jarkom3`

4. Join group: `joingroup [nama_group]` contoh `joingroup jarkom3`

5. Mengirim pesan private: `send [username to] [message]` contoh `send messi hello world`

6. Mengirim file private: `sendfile [username to] [filename]` contoh `sendfile messi file.txt`

7. Mengirim pesan ke group: `sendgroup [nama_group] [message]` contoh `sendgroup jarkom3 hallo guys welcome`

8. Mengirim file ke group: `sendgroupfile [usernames to] [filename]` contoh `sendgroupfile jarkom3 file.txt`

9. Melihat pesan: `inbox`

10. Logout: `logout`

11. Melihat user yang aktif: `info`

## Komunikasi dengan server lain
  Digunakan command MultiRealm Server agar dapat terkoneksi dengan berbeda server disini kita menggunakan Mesin1 dan Mesin2 dengan layanan yang sama.

  Berikut merupakan beberapa command yang dpat diakses dengan format sebagai berikut:
  
1. Menambah realm                 : `addrealm [nama_realm] [address] [port]` 
2. Mengirim pesan ke realm        : `sendprivaterealm [name_realm] [username to] [message]`
3. Mengirim pesan ke group realm  : `sendgrouprealm [name_realm] [usernames to]/[group:][group_name] [message]`
4. Melihat pesan realm            : `getrealminbox [nama_realm]`
5. Mengirim file ke realm         : `sendfilerealm [name_realm] [username to] [filename]`
6. Mengirim file ke group realm   : `sendgroupfilerealm [name_realm] [usernames to] [filename]`


## Default Information
### Users
- messi        : surabaya (pw)
- henderson    : surabaya (pw)
- lineker      : surabaya (pw)


