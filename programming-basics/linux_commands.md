# Linux Commands 
source: 
1. https://man7.org/linux/man-pages/dir_all_alphabetic.html
2. https://books.goalkicker.com/LinuxBook/
3. https://sourabhbajaj.com/mac-setup/iTerm/tree.html
4. https://www.freecodecamp.org/news/file-permissions-in-linux-chmod-command-explained/
5. https://www.geeksforgeeks.org/soft-hard-links-unixlinux/
6. https://clubmate.fi/symbolic-links-and-hard-links-creating-updating-deleting-and-all-that
7. https://devconnected.com/understanding-hard-and-soft-links-on-linux/

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
4. List files and Appends symbol at the end of a filename to indicate its type\
(* -- executable; / -- directory; @ -- symbolic link; = -- socket; | -- pipe; > -- door)
``` bash
ls -F
```
5. Print the index number of each file (inode number is on the column located at the extreme left)
``` bash
ls -li
```
6. Listing files sorted by last modified time in long format (top -- most recently modified files)
``` bash
ls -lt
```
7. Listing files in human readable format (sizes like 1K 234M 2G etc)
``` bash
ls -lh
```
8. Display all subdirectories recursively (long format)
``` bash
ls -lR
```
9. Generate tree representation of file system starting from current directory\
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
2. Change file permissions of directory (and ALL contents within directory) recursively (Specifications: u -- user; g -- group; o -- other; a -- all of the above(equivalent to "ugo"); + -- add permissions; - remove; r -- read; w -- write; x -- execute)
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

First character refers to type of input
   - "-" refers to file
   - "d" refers to directory
   - "i" refers to symlink, which is a shortcut for a file or directory
 
Group next set of letters (rwx maximum 3 per group) refers to permissions for user, group and others

### Linux Links

#### Inode
Every file in the system has an inode (index node)\
It is an object that stores information (metadata) about any file within your filesystem in Linux operating system except its name and data (file contents)\
They are independent of filenames
- You can copy a single file, rename it, and still have it point to the same inode as the original

Inodes are specific to the file system, storage device, the partition\
Inodes are one-to-one match to a file
 - Every file has an inode
 - Every directory has an inode

Information contained in an inode:
- Inode number
- File size
- Owner information (User and group IDs associated with the file)
- Permissions needed to access the file
- File Type
- Number of links
- Device on which the file is stored 
- Creation, read, and write timestamps
- Location of the data (though not the filepath)

#### Soft link (Symbolic link) vs Hard link
Soft link is a pointer(file) to the original file (similar to windows shortcut)\
Smaller file size compared to the original file\
Link across file systems: If you want to link files across the file systems, you can only use symlinks/soft links\
Inode number of soft link is different from that of the original file
<div style="width:1399px; height:661px; background-color: #FFFFFF">
<img src="https://devconnected.com/wp-content/uploads/2019/08/sooft-links.png" title="Understanding Soft links">
</div>

``` bash
   inode #100 <------ originalfile
   inode #200 <------ softlink1
   inode #300 <------ softlink2  
```
If we delete or move the original file, softlinks will not work properly (AKA Hanging links)!\
If we change the name of the original file, all the soft links for that file become dangling i.e. they are worthless now.

Hard link is different name of the original file (Like a duplicate copy of the original file)\
Having same file size as original file\
We cannot create a hard link for a directory to avoid recursive loops\
Inode number of hardlink is the EXACTLY SAME as the original file
<div style="width:1399px; height:661px; background-color: #FFFFFF">
<img src="https://devconnected.com/wp-content/uploads/2019/08/hard-soft-links-768x499.png" title="Understanding Hard links">
</div>

``` bash
  inode #100 <------ originalfile
  inode #100 <------ hardlink1
  inode #100 <------ hardlink2
 ```
 If we delete the original file, the hard links will still contain data that were in original file\
 Removing hard link, just reduces the link count, but doesn’t affect other links
 
### Create Soft link (Symlink) to a file/directory
1. Create symlink for the files (-s flag specify symbolic link)
``` bash
$ ln  -s <original filename> <link name>
```
2. Create links for the directory (-s flag specify symbolic link)
``` bash
$ ln -s <target_directory> <link_name>
```
### Remove Soft link (Symlink) to a file/directory
#### 2 main commands when removing Symbolic links
i. rm (removes given files and directories, accepts multiple arguments)\
ii. unlink (deletes a given file, only accepts single argument)\

1. Remove symlinks for the file (on success, command exits with zero and displays no output)
``` bash
$ rm symlink_name
```
2. Receive prompting prior to removing symlinks for the file (to confirm type y and press Enter)
``` bash
$ rm -i symlink_name
```
``` bash
# Output
rm: remove symbolic link 'symlink_name'?
```

3. Remove symlinks for multiple files (pass names of symlinks as arguments separated by space)
``` bash
$ rm symlink1 symlink2
```
4. Remove symbolic link that points to a directory
``` bash
$ rm -r symlink_to_dir/
```
``` bash
$ rm -d symlink_to_dir/
```
``` bash
# -f flag (forcefully removes the symlink from directory)
$ rm -f symlink_to_dir/
```
### Create Hard link to a file/directory
``` bash
┌──The link command
│
│                          ┌──Path to the intended link, can use . or ~
│                          │
│                    ┌─────┴──────┐
ln /path/to/original /path/to/link
    └───────┬───────┘
            └──Path to the original file/folder can
               use . or ~ or other relative paths
```
   a. Display all the attributes stored into the inode
``` bash
# stat - get file status; -x Display information in a more verbose way as known from some Linux distributions
$ stat -x File_A
```
``` bash
# Output
    File: "File_A"
    Size: 7            FileType: Regular File
    Mode: (0644/-rw-r--r--)         Uid: (  501/   bob)  Gid: (   20/   staff)
Device: 1,4   Inode: 51882811    Links: 1
Access: Tue Jan 20 09:14:04 2015
Modify: Tue Jan 20 09:14:04 2015
Change: Tue Jan 20 09:14:04 2015
 Birth: Tue Jan 20 09:14:04 2015
```
