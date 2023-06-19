# Bash Scripting and Shell Programming

## Shell Programming Part I
Source: https://tldp.org/LDP/abs/html/comparison-ops.html

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
if [ condition-is-true]
then
  command 1
  command 2
  command N
fi
```
