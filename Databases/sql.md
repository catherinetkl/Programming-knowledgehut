# SQL

- [Table of contents]

# MAC Installation of MySQL
Pre-requisites:\
Ensure that have downloaded and installed MySQL on your Mac.

You'll likely need to run the following commands to be able to execute the mysql program from the command line.
1. Open up the terminal app
2. Test if the mysql installation is running properly, run the command\
   $ mysql
3. Run $ open ~/.bash_profile
   a. If file does not exist, then create the bash profile file by running the following command: $ touch ~/.bash_profile
   b. Run $ open ~/.bash_profile
   c. Paste the line at the end of the file: export PATH=${PATH}:/usr/local/mysql/bin
   d. Save the changes of the file
4. Run $ mysql -u root -p
5. You'll be prompted to input your password set for the root user
6. If you successfully logged in, you'll be greeted by the message:\
   Welcome to the MySQL monitor.  Commands end with ; or \g.\
   Your MySQL connection id is 12\
   Server version: 8.0.30 MySQL Community Server - GPL

   Copyright (c) 2000, 2022, Oracle and/or its affiliates.

   Oracle is a registered trademark of Oracle Corporation and/or its\
   affiliates. Other names may be trademarks of their respective\
   owners.

   Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
