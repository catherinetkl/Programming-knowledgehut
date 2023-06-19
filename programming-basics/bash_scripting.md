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

# e.g 1. True if file is a directory
[ -d /etc/passwd ] 

# e.g 2. True if file exists
[ -e /etc/passwd ] 

# e.g 3. True if file exists and is a regular file
[ -f /etc/passwd ] 

# e.g 4. True if file is readable by you
[ -r /etc/passwd ] 

# e.g 5. True if file exists and is not empty
[ -s /etc/passwd ] 

# e.g 6. True if file is writable by you
[ -w /etc/passwd ] 

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
fi     # $String is null.
```
```bash
# -n STRING: True if string is not empty
if [ -n "$string1" ]  
# This time, $string1 is quoted.
then
  echo "String \"string1\" is not null."
else  
  echo "String \"string1\" is null."
  # Quote strings within test brackets!
fi                    

