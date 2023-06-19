# Bash Scripting and Shell Programming
Source: 
1. https://tldp.org/LDP/abs/html/comparison-ops.html
2. https://www.shell-tips.com/linux/how-to-format-date-and-time-in-linux-macos-and-bash/#gsc.tab=0

## Shell Programming Part I

### Valid variable names
Variable Names contains letters, digits and underscores\
Valid: FIRST3LETTERS="ABC"\
       FIRST_THREE_LETTERS="ABC"\
       firstThreeLetters="ABC"    

### File Operator Tests
```bash
# Syntax
[ condition-to-test-for ]
```
```bash
# e.g 1. True if file is a directory
[ -d /etc/passwd ] 
```
```bash
# e.g 2. True if file exists
[ -e /etc/passwd ] 
```
```bash
# e.g 3. True if file exists and is a regular file
[ -f /etc/passwd ] 
```
```bash
# e.g 4. True if file is readable by you
[ -r /etc/passwd ] 
```
```bash
# e.g 5. True if file exists and is not empty
[ -s /etc/passwd ] 
```
```bash
# e.g 6. True if file is writable by you
[ -w /etc/passwd ] 
```
```bash
# e.g 7. True if file is executable by you
[ -x /etc/passwd ] 
```

### String Operator Tests
```bash
# e.g 1: -z STRING : True if string is empty
# Zero-length ("null") string variable.
String=''
if [ -z "$String" ] 
then
  echo "\$String is null."
else
  echo "\$String is NOT null."
fi     
# $String is null.
```
```bash
# -n STRING: True if string is not empty
if [ -n "$string1" ]  
# This time, $string1 is quoted.
then
  echo "String \"string1\" is not null."
else  
  echo "String \"string1\" is null."
fi 
 # Quote strings within test brackets!
 ```
```bash
# e.g 3:  True if the two strings are equal
if [ "$a" == "$b" ]  
```
```bash
# e.g. 4: True if the strings are not equal
if [ "$a" != "$b" ]  
```

### Arithmetic Operator Tests
```bash
# e.g 1:  True if arg1 is equal to arg2
[ arg1 -eq arg2 ]  
```
```bash
# e.g 2:  True if arg1 is not equal to arg2
[ arg1 -ne arg2 ]  
```
```bash
# e.g 3:  True if arg1 is less than arg2
[ arg1 -lt arg2 ]  
```
```bash
# e.g 4:  True if arg1 is less than or equal to arg2
[ arg1 -le arg2 ]  
```
```bash
# e.g 5:  True if arg1 is greater than arg2
[ arg1 -gt arg2 ]  
```
```bash
# e.g 6:  True if arg1 is greater than or equal to arg2
[ arg1 -ge arg2 ]  
```

## Shell Programming Part II

### Making Decisions - The if statement
```bash
# Sample format
if [ condition-is-true ]
then
  command 1
  command 2
  command N
fi
```
```bash
# Sample script 1
#!/bin/bash
MY_SHELL="bash"

if [ "$MY_SHELL" = "bash" ]
then
   echo "You seem to like the bash shell."
fi
```
```bash
# if/elif/else
if [ condition-is-true ]
then
  command N
elif [ condition-is-true ]
then
  command N
else
  command N
fi
```
```bash
# Sample script 2
#!/bin/bash
MY_SHELL="csh"
if [ "$MY_SHELL" = "bash" ]
then
   echo "You seem to like the bash shell."
elif [ "$MY_SHELL" = "csh" ]
then
   echo "You seem to like the csh shell."
else
   echo "You seem to like the bash or csh shell."
fi
```

### For loop
```bash
# Sample script 3
#!/bin/bash
for COLOUR in red green blue
do
  echo "COLOUR: $COLOUR"
done
```
```bash
# Output:
COLOUR: red
COLOUR: green
COLOUR: blue
```
```bash
# Sample script 4: Rename files that ends with .jpg
#!/bin/bash
PICTURES=$(ls *jpg)
# %F option is alias for %Y-%m-%d (Bash Date format YYYY-MM-DD
DATE=$(date +%F)

for PICTURE in $PICTURES
do
  echo "Renaming ${PICTURE} to ${DATE}-${PICTURE}"
  mv ${PICTURE} ${DATE}-${PICTURE}
done
```
```bash
$ ls
bear.jpg  man.jpg  pig.jpg  rename-pics.sh
$ ./rename-pics.sh
Renaming bear.jpg to 2015-03-06-bear.jpg
Renaming man.jpg to 2015-03-06-man.jpg
Renaming pig.jpg to 2015-03-06-pig.jpg
$ ls
2015-03-06-bear.jpg  2015-03-06-man.jpg  2015-03-06-pig.jpg  rename-pics.sh
$
```
