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
   <th>Type</th><th>Size</th></th><th>Default Value</th><th>Range</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>byte</td><td>-R</td><td></td><td></td>
  </tr>
  <tr>
   <td>short</td><td>-R or -r</td><td></td><td></td>
  </tr>
  <tr>
   <td></td><td>-R or -r</td><td>-R follows symlinks</td><td></td>
  </tr>
  <tr>
   <td>find</td><td>NA</td><td>recurses by default</td><td></td>
  </tr>
  <tr>
   <td>ls</td><td>-R/td><td></td><td></td>
  </tr>
  <tr>
   <td>mkdir</td><td>-p</td><td>p = parent dirs</td><td></td>
  </tr>
  <tr>
   <td>rm</td><td>-R or -r</td><td></td><td></td>
  </tr>
  <tr>
   <td>zip</td><td>-r</td><td></td><td></td>
  </tr>
 </tbody>
</table>
