# 09.01.2023
Установил сервер Ubuntu 20.04 Focal Fossa.

https://releases.ubuntu.com/20.04/

Все команды используются от имени пользователя root в самыми высокими правами.

### Далее первичная настройка сервера: 

    # apt update
    # apt upgrade -y

    # apt install mariadb-server mariadb-client -y
    # apt install net-tools -y

### Первичная настройка сервера MariaDB:

    # mysql_secure_installation

    > Enter current password for root (enter for none): 
    просто жмем Enter, т.к. это первый запуск и пароль пользователя root пустой.

    > Set root password? [Y/n]
    выбираем [y] и жмём Enter. Далее попросит ввести пароль и подтвердить.

    > Remove anonymous users? [Y/n]
    Выбираем [y], ведь нам не нужен анонимный пользователь.

    > Disallow root login remotely? [Y/n]
    Выбираем [y], т.к. мы не будем давать разрешение на подключение пользователя root удаленно.

    > Remove test database and access to it? [Y/n]
    Выбираем [y] для удаления тестовой базы данных.

    > Reload privilege tables now? [Y/n]
    Выбираем [y] для перезагрузки привелегий пользователей.

    На этом первичная настройка завершается и мы можем подключаться к БД.

### Поправим конфигурацию сервера MariaDB, что-бы были доступны подключения с любого внешнего адреса:

    # nano /etc/mysql/mariadb.conf.d/50-server.cnf

    Нас интересует секция => [mysqld]
    Найдем строку (если есть) => bind-address = 127.0.0.1
    Заменим (или добавим, если не нашли ранее) на => bind-address = 0.0.0.0

Таким образом мы говорим серверу о том, что нужно слушать порт 3306 (он по умолчанию и его не меняли) с любых сетевых адресов.

    # systemctl restart mariadb.service 
    Перезапускаем сервис для применения настроек.

    # netstat -ntlp | grep mysql
    Проверим, прослушивает ли сервер БД нужный порт и адресацию.

    tcp        0      0 0.0.0.0:3306            0.0.0.0:*               LISTEN      23894/mysqld
    Так выглядит верный вывод команды.

### Подключение к серверу БД и дальнейшая настройка для проекта:
    # mysql -u root -p
    Вводим пароль пользователя root который указали при автоматической настройке БД.

    MariaDB [(none)]> USE mysql;
    MariaDB [(none)]> CREATE DATABASE accident_panel;
    MariaDB [(none)]> CREATE USER 'ac_panel' IDENTIFIED BY 'kehrvjfh';
    MariaDB [(none)]> GRANT ALL ON accident_panel.* TO 'ac_panel'@'%' IDENTIFIED BY 'kehrvjfh';

---

    После всех приведенных выше манипуляций проверяем:


    MariaDB [mysql]> SHOW DATABASES;

    Вывод должен быть таким:
    +--------------------+
    | Database           |
    +--------------------+
    | accident_panel     |
    | information_schema |
    | mysql              |
    | performance_schema |
    +--------------------+
    4 rows in set (0.001 sec)


    MariaDB [mysql]> SELECT host,user,plugin,Grant_priv FROM mysql.user;

    Вывод должен быть таким:
    +-----------+----------+-------------+------------+
    | host      | user     | plugin      | Grant_priv |
    +-----------+----------+-------------+------------+
    | localhost | root     | unix_socket | Y          |
    | %         | ac_panel |             | N          |
    +-----------+----------+-------------+------------+
    2 rows in set (0.000 sec)

    MariaDB [mysql]> exit

    На этом пока всё!