# Java
source: 
1. https://www.baeldung.com/java-primitive-conversions

## How is a Java Program executed?
- A java program is written and saved in a java file known as a source code (.java file)
- Source code is then passed to the compiler, where it is compiled into byte code.
  - It cannot be directly executed by the machine.
  - Byte code must first be translated into machine code by the Java Virtual Machine (JVM).
  - Then executed by the machine.
    
### What is JVM?
It is platform specific/independent. It means that every platform has its own Java virtual machine.

### How is Java platform independent?
- It means that the code can be written once and run anywhere.
- This is achieved because of Java compiler, which converts the source code into byte code.
  - For example, if the program is written and compiled on a windows platform, the program's byte code is first 

## Introduction to Java
Java is a typed language. \
There are two distinct type groups:
1. primitive data types
2. abstract data types

## What is the difference between signed and unsigned variables?
- Signed variables, such as signed integers will allow you to represent numbers both in the positive and negative ranges.
- Unsigned variables, such as unsigned integers, will only allow you to represent numbers in the positive.
- Unsigned and signed variables of the same type (such as int and byte) both have the same range (range of 65,536 and 256 numbers, respectively), but unsigned can represent a larger magnitude number than the corresponding signed variable.
(Adding 128 + 127 = 255)
- To reiterate, the main differences between Signed & Unsigned data type or variable in java is:
  Unsigned can hold larger positive values, but no negative values.
  Signed can hold -128 to 127.
## Primitive datatypes
<table>
 <thead>
  <tr>
   <th>Type</th><th>Size</th><th>Default Value</th><th>Range</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>byte</td><td>8</td><td>0</td><td>-128 to 127</td>
  </tr>
  <tr>
   <td>short</td><td>16</td><td>0</td><td>-32,768 to 32,767</td>
  </tr>
  <tr>
   <td>int</td><td>32</td><td>0</td><td>-2,147,483,648 to 2,147,483,647</td>
  </tr>
  <tr>
   <td>long</td><td>64</td><td>0L</td><td>-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807</td>
  </tr>
  <tr>
   <td>float</td><td>32</td><td>0.0f</td><td>Approximately ±3.40282347E+38F (6-7 significant decimal digits)</td>
  </tr>
  <tr>
   <td>double</td><td>64</td><td>0.0</td><td>Approximately ±1.7976931348623157E+308 (15 significant decimal digits)</td>
  </tr>
  <tr>
   <td>char</td><td>16</td><td>'\u0000'</td><td>0 to 65,535 (unsigned)</td>
  </tr>
  <tr>
   <td>boolean</td><td>-</td><td>false</td><td>true or false</td>
  </tr>
 </tbody>
</table>

## What are generics?
Two main bugs:
- Compile Time errors
- Runtime errors

<table>
 <thead>
  <tr>
   <th>Runtime Errors</th><th>Compile Time Errors</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>More problematic</td><td>Easy to detect them as the application will not compile</td>
  </tr>
  <tr>
   <td>Don't always surface immediately and it may be at a point in the program that is far from the actual cause of the problem</td><td>Compiler's error messages help to figure out what the problem is</td>
  </tr>
  <tr>
    <td>-</td><td>Compile time errors can be fixed easily</td>
  </tr>
 </tbody>
</table>

If we use Generics, we can transform most of the runtime errors into compile time errors.

### Why do we use Generics?
- Added stability to your code
- Makes most of the bugs and errors to be detectable at compile time and not at runtime.

We prefer compile time errors to runtime errors.

- Generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods

Generics in programming languages like Java allow you to create classes, interfaces, and methods that can work with different data types while maintaining type safety. Here's what it means in more detail:

1. Parameterized Types: With generics, you can define classes, interfaces, and methods with one or more type parameters (generics). These type parameters act as placeholders for specific data types that will be provided when the class or method is used. For example, you can create a generic class like `List<T>` or a generic method like `public <T> T process(T input)`.

2. Reusability: Generics enable you to write code that can be reused with different data types without duplicating the code for each type. This promotes code reusability and reduces redundancy. You can create a single generic class or method to handle a wide range of data types.

3. Type Safety: Generics ensure type safety by allowing the compiler to enforce type constraints. This means that the compiler will catch type-related errors at compile-time, preventing runtime errors. It helps prevent data type mismatches and improves code reliability.

4. Flexibility: Generics make your code more flexible and adaptable to different use cases. You can create collections, algorithms, and data structures that work with different data types without modifying the code.

5. Code Optimization: Generics can lead to more efficient code by avoiding unnecessary type casting or boxing/unboxing operations. This can result in improved performance.

For example, you can create a generic List class that can hold elements of any data type. You specify the data type when creating an instance of the List. This allows you to have a List of integers, a List of strings, or a List of custom objects, all with type safety and code reusability.

```java
List<Integer> integerList = new ArrayList<Integer>();
List<String> stringList = new ArrayList<String>();
```


```java
public void draw(Car car)
```
If we have a public void draw method that's waiting for a parameter (in this case, the car parameter is the value), in this case, our application is able to draw on the canvas. But it is highly inefficient and not a good approach if we have to draw other vehicles like bus or bicycle instead of a car, we cannot possibly create multiple draw methods for it.

```java
public void draw(T t)
```
Thus, instead of using values, we can use generic types. We can draw multiple types with a generic method.
Hence, it's absolutely crucial that generics enable types such as classes and interfaces to be parameters when defining classes, methods and interfaces, so that <b>we can reuse the same code with different inputs</b>.
