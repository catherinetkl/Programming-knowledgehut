# Python

## Big O

### Time complexity
a function that measures how long an algorithm takes in terms of the quantity of input it receives\
Measured in the number of operations that it takes to complete something

### Space complexity
a function that measures how much memory (space) an algorithm requires to the quantity of input to the method\
if preserving space is the main priority and time taken for the operations to complete is not held with as much importance

### 3 Letters for Time & Space complexity
Ω (omega), θ (theta) and O (omicron)
example: a list of 7 integers, need to build a for loop to iterate through list to find specific number

best case scenario (denoted by Ω): 
> if target integer: 1
  - find 1 in one operation
average case scenario (denoted by θ):
> if target integer: 4
  - iterate through four integers to get to 4
worst case scenario (denoted by O): 
> if target integer: 7
  - iterate through the entire list to get to 7

### O(n)
1. Create a function named, print_items
2. Pass it a number, n 
3. Have a <b>for loop</b> that runs for n times
4. Print <b>i</b> from <b>for loop</b>
5. Call print_items function again, for 10 times
```python
def print_items(n)
    for i in range(n):
        print(i)
print_items(10)
```
Output is 0 through 9 (10 items)\
n - number of operations\
O(n) - straight line graph cutting origin diagonally (proportional)
> x-axis: n\
> y-axis: number of operations

### Drop constants
```python
def print_items(n)
    for i in range(n):
        print(i)
        
    for j in range(n):
        print(j)
print_items(10)
```
Output is 0 through 9\
          0 through 9 (20 items)\
The above function ran n+n times = 2n\
O(2n) can be simplified into O(n) by dropping the constant\
regardless whether is it 2n, 100n 10000n, we can simplify by dropping the constant

### O(n^2)
```python
def print_items(n):
    for i in range(n):
        for j in range(n):
            print(i,j)
            
 print_items(10)
 ```
 Output is 0 through 99 (100 items)\
 The above function ran n*n times = n<sup>2</sup><br>

 O(n<sup>2</sup>) is much steeper than O(n)
 - O(n<sup>2</sup>) is much less efficient from time complexity standpoint

### Drop Non-dominants
```python
def print_items(n):
    for i in range(n):
        for j in range(n):
            print(i,j)
    for k in range(n):
        print(k)
 print_items(10)
 ```
Output is 0 through 99 (100 items)\
           0 through 9 (10 items)
           
The above function printed 110 items
O(n<sup>2</sup> + n), where n<sup>2</sup> is the dominant term<br>
n is the non-dominant term, hence we drop it
- O(n<sup>2</sup>)

### O(1) -- Constant time
```python
def add_items(n):
    return n + n + n
 ```
as n gets bigger, number of operations increases\
in this case, the only operation is addition, n is 1, you have one operation\
n is 100, you still have one operation
as n increases, the number of operations still remains constant (not increasing number of operations)\
Graph of O(1) is a horizontal straight line\
- Most efficient Big 0, most optimal as you can make it

### O(log n)
You have a list of integers, 1 to 8 (you have to have sorted data)
- Objective: find the most efficient way of finding any number in this list
- Target: 1
- Take the list, cut into half (1st half: 1 through 4, 2nd half: 5 through 8)
- Is it in the 1st or 2nd half?
  - 1st half
    - Search through 1st half
      - by splitting the 4 numbers again into 2 halves
        - Is it in the 1st or 2nd half?
          - 1st half (locate the number 1)
 - Total number of steps: 3
2<sup>3</sup> = 8 <br>
log<sub>2</sub>8 = 3
