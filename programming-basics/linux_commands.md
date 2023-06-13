# Linux Commands 
source: 
## Basic Linux Commands
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
1. Listing files & directories in long format inside current directory (better readability)
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
8. Generate tree representation of file system starting from current directory
``` bash
tree
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
