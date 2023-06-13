# Linux Commands 
source: 
1. https://man7.org/linux/man-pages/dir_all_alphabetic.html
2. https://books.goalkicker.com/LinuxBook/
3. https://sourabhbajaj.com/mac-setup/iTerm/tree.html
4. https://www.freecodecamp.org/news/file-permissions-in-linux-chmod-command-explained/

## Basic Linux Commands
Note: after the command e.g. ls, the options are called command flags (such as -a -R)

### Directory navigation
1. Full path of current working directory
``` bash
pwd
```
2. Navigate to the last directory that you are working in
``` bash
cd -
```
3. Navigate to current user's home directory
``` bash
cd ~ or cd
```
4. Navigate to the parent directory of current directory
``` bash
cd ..
```

## Listing files inside a directory
1. Listing files & directories in long format inside current directory (better readability)\
   Finding existing permissions of a file
``` bash
ls -l
```
2. Listing information about directories (not contents)
``` bash
ls -ld
```
3. Listing all files (including hidden ones -- files starting with a .)
``` bash
ls -a
```
4. Appends symbol at the end of a filename to indicate its type\
(* -- executable; / -- directory; @ -- symbolic link; = -- socket; | -- pipe; > -- door)
``` bash
ls -F
```
5. Listing files sorted by last modified time in long format (top -- most recently modified files)
``` bash
ls -lt
```
6. Listing files in human readable format
``` bash
ls -lh
```
7. Display all subdirectories recursively (long format)
``` bash
ls -lR
```
8. Generate tree representation of file system starting from current directory\
Tree is a recursive directory listing command that produces a depth indented listing of files
``` bash
tree
```
### Installation of Tree on Mac
``` bash
brew install tree
```
#### To limit the recursion you can pass an -L flag and specify the maximum depth tree will use when searching
``` bash
tree -L 1
```
will output:
``` bash
.
├── Apps
├── CONTRIBUTING.md
├── Cpp
├── Docker
├── Git
└── Go

5 directories, 1 files
```
### Create, copy and remove file/directory
1. Copy file from source to destination, preserve original attributes of file (-p) while copying ie. file owner, timestamp, group, permissions
``` bash
cp -p source destination
```
2. Copy source directory to specified destination recursively
``` bash
cp -R source_dir
```
3. Move or Rename file (from file1 to file2)
``` bash
mv file1 file2
```
4. For new users to linux command line, prompts you for confirmation before removal of file
``` bash
rm -i filename
```
5. Remove directory recursively, without prompt forcefully, ignoring non-existent files
``` bash
rm -rf dir-name
```
6. Remove directory recursively
``` bash
rm -R dir-name
```
7. Remove empty directories
``` bash
rmdir dir-name
```
8. Create a new directory
``` bash
mkdir dir-name
```
9. Create a directory hierarchy, create parent directories as needed if they don't exist (can specify multiple directories)
``` bash
mkdir -p dir-name/sub-dir-name
```
10. Create a new file, if file does not exist, otherwise modify the timestamp of file to the current time
``` bash
touch filename
```

### Permissions and Groups for Files/Directory
#### 3 main commands when managing file permissions
i. chmod (Change mode)\
ii. chown (Change ownership)\
iii. chgrp (Change group)

1. Change file permissions (Specifications: u -- user; g -- group; o -- other; + -- add permissions; - remove; r -- read; w -- write; x -- execute)
``` bash
chmod <specifications> filename
```
2. Change file permissions of directory (and ALL contents within directory) recursively (Specifications: u -- user; g -- group; o -- other; + -- add permissions; - remove; r -- read; w -- write; x -- execute)
``` bash
chmod -R <specifications> dir-name
```
<table>
 <thead>
  <tr>
   <th>Access</th><th>Symbolic Mode</th><th>Octal Mode</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>Read</td><td>r</td><td>4</td>
  </tr>
  <tr>
   <td>Write</td><td>w</td><td>2</td>
  </tr>
  <tr>
   <td>Execute</td><td>x</td><td>1</td>
  </tr>
 </tbody>
</table>

<table>
 <thead>
  <tr>
   <th>Access</th><th>Symbolic Mode<br>(u+rwx,g+rw,o+r)</th><th>Octal Mode<br> (764 -- user, group, others)</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>User</td><td>u</td><td>main priority</td>
  </tr>
  <tr>
   <td>Group</td><td>g</td><td>middle priority</td>
  </tr>
  <tr>
   <td>Others</td><td>o</td><td>least priority</td>
  </tr>
 </tbody>
</table>

### How to manage permissions in symbolic mode (more powerful than octal because we can mask out permission bits)
3. Add read, write or execute permissions for owner/user for file, install.sh
``` bash
chmod u+rwx install.sh
```
4. Add read permissions for owner and group for myfile
``` bash
chmod go+r myfile
```
5. Allow all users to read, write or execute permissions myfile
``` bash
chmod a +rwx myfile
```
6. Remove/revoke read permissions from group and others for myfile
``` bash
chmod go -r myfile
```
7. Change ownership of a file to user owner1
``` bash
chown owner1 filename
```

### How to manage permissions in octal mode (permission modes are absolute, cannot be used to change individual bits)
``` bash
chmod 744 install.sh
```
First number (7) represents permission for user: 7 = 4(read) + 2(write) + 1(execute)\
Second number (4) represents permission for group: 4 = 4(read)\
Third number (4) represents permission for others: 4 = 4(read)

<div style="width:253px; height:222px; background-color: #FFFFFF">
<img src="https://www.freecodecamp.org/news/content/images/2022/12/permissions-1.png" alt="output of ls -l" title="Existing permissions output description">
</div>
