# Java
source: 
1. https://www.baeldung.com/java-primitive-conversions
2. https://nlbsg.udemy.com/course/introduction-to-generics-in-java
3. https://nlbsg.udemy.com/course/software-architecture-learnit/

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

3. Type Safety: Generics ensure type safety by allowing the compiler to enforce type constraints. This means that the compiler will catch type-related errors at compile-time, preventing runtime errors. It helps prevent data type mismatches and improves code reliability. If our code violates type safety then the compiler warns us and this is exactly why we prefer compile time errors.

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

- We can eliminate type castings
It is not a good programming practice to do type castings because we should use generics instead.

```java
List list = new ArrayList();
String name = (String) list.get(0);
```
We can instantiate an array list, that is the concrete implementation.
List is the interface. Array List is a concrete implementation with an underlying one-dimensional array data structure.
We can use an array list and a list interface in order to store strings.
If we do not use generics, then we have to cast the given items one by one.
Whenever we get the first item with index zero, then we have to cast it to a string. It is quite expensive.
In this case, we don't use generics which implies that we have to cast the objects into Strings(the JVM must test type casting at runtime).

What if we used generics?

```java
List<String> list = new ArrayList<>();
String name = (String) list.get(0);
```
We are going to notify java that we are going to store strings in the underlying array list, then we can get these strings, for example, with index zero without the need for casting. So in this case, we use generics which means that we do not have to cast the objects into strings and the compiler knows the types, so no need to check them.

Main key difference, when using generics, we are dealing with the compiler. As far as the non-generic implementation is concerned, here we are dealing with the java virtual machine at runtime.

If we used generics, then we can transform most of the errors from runtime to compile time.

- Generic Algorithms
For example, we can implement a sorting algorithm. But what if we have integers, floats, doubles and strings?
So what if we are dealing with different types? A bad practice would be to have a sorting algorithm to handle each data type. But this is a highly naive appraoch. The better approach would be: We can implement generic algorithms and methods and we can reuse them whenever we want.

It is easier to read generic code.

Review:
1. Which error type is preferred?
Compile time errors

2. What is the main problem with type casting?
The problem is that the JVM must test type casting at runtime.

So we have a given class, the App.java. We would like to construct a method that is able to sum up two integer values.
```java
package com.globalsoftwaresupport;

public class App {
	
	public static void add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("Result is " + result)
	}

	// Method overloading - create the same method with different arguments
	public static void add(double num1, double num2) {
		double result = num1 + num2;
		System.out.println("Result is " + result)
	}

	public static void main(String[] args) {
		add(10,28);
	}
}
```

If we want to avoid method overloading and usually this is the case, then we should use generics.
So we can define generic types and we will be able to use this add method with integers, floating point numbers, doubles, etc.
```java
package com.globalsoftwaresupport;

public class App {

    public static <T> T add(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            Integer result = (Integer) num1 + (Integer) num2;
            System.out.println("Result is " + result);
            return (T) result;
        } else if (num1 instanceof Double && num2 instanceof Double) {
            Double result = (Double) num1 + (Double) num2;
            System.out.println("Result is " + result);
            return (T) result;
        } else if (num1 instanceof Float && num2 instanceof Float) {
            Float result = (Float) num1 + (Float) num2;
            System.out.println("Result is " + result);
            return (T) result;
        } else {
            // Handle other data types or throw an exception
            System.out.println("Unsupported data types");
            return null;
        }
    }

    public static void main(String[] args) {
        add(10, 28); // This will call the method for integers
        add(5.5, 2.3); // This will call the method for doubles
        // add("Hello", "World"); // Uncommenting this line would result in an "Unsupported data types" message
    }
}
```
```java
package com.globalsoftwaresupport;

class Store {
	
	private Object item;

	private void setItem(Object item){
		this.item = item;
	}
	
	public Object getItem(){
		return this.item;
	}
}

public class App {
	public static void main(String[] args) {
		// Instantiate a new store
		Store store = new Store();

		// Call the setItem method to store integers
		store.setItem(45);

		// Call the setItem method to store double or float
		store.setItem(45.5);

		// get the given item that we set earlier?
		// getItem is going to return an object, so we cannot just do int item = store.getItem();
		// Cast the given object into an integer - Type casting
		Integer item = (Integer) store.getItem();
		// If we want to set the item as floating point numbers, we need to cast into double or float
		Double item = (Double) store.getItem();

		// print out the item
		System.out.println(item);
	}
}
```
the above example is a demonstration of poor programming design due to type casting.


we can create a generic store. But what does it exactly mean?
```java
package com.globalsoftwaresupport;

// Define the name of the generic type (can use T, E or V) ; <> - diamond operator
class Store<T> {
	
	private T item;

	private void setItem(T item){
		this.item = item;
	}
	
	public T getItem(){
		return this.item;
	}
}

public class App {
	public static void main(String[] args) {
		// Instantiate a new store - Store is a Raw type
		// Store store = new Store();
		// whenever we instantiate the store, we have to notify java that we are going to store strings
		// convert runtime exceptions to compile time exceptions
		Store<String> store = new Store<>();

		// if we want to call the setItem method to store double or float, java is returning a compile-time error
		// store.setItem(45.5);
		// the method setItem string in the type Store<String> is not applicable for the type double
		store.setItem("Hello World!");

		// get the given item that we set earlier? can get rid of type casting, just store a given string
		String item = store.getItem();

		// print out the item
		System.out.println(item);
	}
}
```

Conclusion: Under the hood, whenever we use generics, Java is going to use the Object super type.

### Using multiple generic types
```java
import java.util.ArrayList; // import the ArrayList class

package com.globalsoftwaresupport;

class Store<T> {
	
	private T item;

	private void setItem(T item){
		this.item = item;
	}
	
	public T getItem(){
		return this.item;
	}
}

public class App {
	public static void main(String[] args) {
		// Raw type
		// <> diamond operator
		Store<String> store = new Store<>();

		// use collections framework related classes such as list interface or array list without generic types
		// Use raw types for ArrayList
		ArrayList list = new ArrayList();
        
        // Add an integer to the list
        list.add(23);
        
        // Now, add a double to the list (works with raw types)
        list.add(45.5);

        // Access elements (need to cast to appropriate types)
        int intValue = (int) list.get(0);
        double doubleValue = (double) list.get(1);
        
        // Print values
        System.out.println("Integer Value: " + intValue);
        System.out.println("Double Value: " + doubleValue);
    }
}
```

A better solution would be to use Generics

```java
import java.util.ArrayList; // import the ArrayList class

package com.globalsoftwaresupport;

class Store<T> {
	
	private T item;

	private void setItem(T item){
		this.item = item;
	}
	
	public T getItem(){
		return this.item;
	}
}

public class App {
	public static void main(String[] args) {
		// Raw type
		// <> diamond operator
		Store<Integer> store = new Store<>();

        store.setItem(45);

        // we can cast Object into any other object
        Integer item = store.getItem();
        
        // Print values
        System.out.println("Integer Value: " + item);
    }
}
```

Hash table data structures - store values with associated with a given key
```java
package com.globalsoftwaresupport;

class Store<T> {
	
	private T item;

	private void setItem(T item){
		this.item = item;
	}
	
	public T getItem(){
		return this.item;
	}
}

class Hashtable<K,V> {
	private K key;
	private V value;

	public hashtable(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Hashtable [key=" + key ", value=" + value + "]";
	}
}

public class App {
	public static void main(String[] args) {
		// Instantiate a hashtable
		// whenever we instantiate a new generic class, then we have to define the generic types
		Hashtable<String, Integer> hashTable = new Hashtable<>("Hello", 23);
		System.out.println(hashTable)
    }
}
```

## What are Logs & Logging?
- A log is a file that records the events that occur in an operating system or application.
- Logging is the action of keeping the logs.
- Automatically produced and timestamped documentation of events relevant to a particular system or application.
- Most software applications and systems produce log files.
- There are also separate libraries (log management applications) for logging and applications that helps to gather, analyze and navigate in logs.

## Why do we need logs and goals to achieve with logging?
4 main target uses of logs:
- Problem diagnosis by end users and system administrators
	- This consists of simple logging of common problems that can be fixed or tracked locally, such as running out of resources, security failures and simple configuration errors.
- Problem Diagnosis by field service engineers
	- The logging information used by field service engineers may be considerably more complex and verbose than that required by system administrators. Typically, such information will require extra logging within particular subsystems.
 - Problem Diagnosis by the Development Organization
 	- When a problem occurs in the field, it may be necessary to return the captured logging information to the original development team for diagnosis. This logging information may be extremely detailed and fairly inscrutable. Such information might include detailed tracing on the internal execution of particular subsystems.
  - Problem diagnosis by developers
  - The logging APIs may also be used to help debug an application under development. This may include logging information generated by the target application as well as logging information generated by low level libraries. Note, however, that while this use is perfectly reasonable, the logging APIs are not intended to replace the normal debugging and profiling tools that may already exist in the development environment.

Some of the commonly used low-level logging libraries in Java include:
<table>
 <thead>
  <tr>
   <th>Libraries</th><th>Description</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>java.util.logging (java.util.logging package)</td><td>This is the built-in logging framework provided by Java (also known as JUL, or Java Util Logging). It is part of the Java SE platform (Logging package provided with JDK). You can use the java.util.logging classes to configure and output log messages. While it is a basic option, it may be sufficient for simple logging needs.</td>
  </tr>
  <tr>
   <td>Log4j (Apache Log4j)</td><td>Log4j is a popular, open-source logging framework developed by the Apache Software Foundation. It offers a more sophisticated and flexible logging system, and it is widely used in both small and large-scale Java applications. Supports logging to files, output streams and other targets and allows the configuration via config files. Logback is another open-source logging framework that is designed as a successor to Log4j. It offers various enhancements and performance improvements over Log4j and provides both SLF4J (Simple Logging Facade for Java) and native Logback APIs.</td>
  </tr>
  <tr>
   <td>Logback</td><td>Logback is another open-source logging framework that is designed as a successor to Log4j. It offers various enhancements and performance improvements over Log4j and provides both SLF4J (Simple Logging Facade for Java) and native Logback APIs.</td>
  </tr>
  <tr>
   <td>SLF4J (Simple Logging Facade for Java)</td><td>SLF4J is not a logging framework itself but a facade or API that provides a simple and unified interface to various other logging systems/libraries, including Log4j, Logback, and java.util.logging. Allowing developers to plug in their desired implementation and deployment type. You can use SLF4J to abstract away the underlying logging implementation and switch between different logging frameworks easily (supports a lot of connectors).</td>
  </tr>
  <tr>
   <td>Tinylog</td><td>Tinylog is a lightweight, open-source logging framework for Java. It's designed to be simple and efficient while providing basic logging features. It can be a good choice for smaller projects or when you need a minimalistic logging solution.</td>
  </tr>
 </tbody>
</table>

### Key Structure Elements of java.util.logging
<table>
 <thead>
  <tr>
   <th>Key Elements</th><th>Description</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>Logger</td><td>Logger object is used to log messages for a specific system or application component.</td>
  </tr>
  <tr>
   <td>LogRecord</td><td>Log records are used to pass logging requests between the logging framework and individual log handlers.</td>
  </tr>
  <tr>
   <td>Handler</td><td>Handlers exports Log records objects to a variety of destinations, including memory, output streams, consoles, files and sockets. A variety of handler subclasses exist for this purpose. Additional handlers may be developed by third parties and delivered on top of the core platform.</td>
  </tr>
  <tr>
   <td>Level</td><td>Level defines a set of standards, lodging levels that can be used to control logging output. Programs can be configured to output logging for some levels while ignoring output for others.</td>
  </tr>
  <tr>
   <td>Filter</td><td>Filter provides fine grained control over what gets logged beyond the control provided by log levels. The logging API supports a general purpose filter mechanism that allows application code to attach arbitrary filters to control log and output.</td>
  </tr>
   <tr>
    <td>Formatter</td><td>Formatter provides support for formatting log record objects. This package includes two formatters: SimpleFormatter and XMLFormatter. For formatting log records in plain text or XML, respectively. As with handlers, additional formatters may be developed by third parties.</td>
  </tr>
 </tbody>
</table>

### Concept of log levels(for SLF4J library) present in different loggers
<table>
 <thead>
  <tr>
   <th>Log Levels</th><th>Description</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>Fatal</td><td>The log level indicating that your application encountered an event that prevents it from working or a crucial part of it from working. A fatal log level is, for example, an inability to connect the database that your system relies on, or an external payment system that is needed to checkout the basket in your ecommerce system.
   </td>
  </tr>
  <tr>
   <td>Error</td><td>Log level that indicates an issue with a system that prevents certain functionality from working. For example, if you provide logging where social media is one way of logging in to your system, the failure of such a model is an error level log for sure. But taking into account log in feature still works. This is not like fatal error that describes complete inability to log in the fails the difference.</td>
  </tr>
  <tr>
   <td>Warn</td><td>Log level that usually indicates a state of the application that might be problematic or unusual execution is detected. Something may be wrong, but it doesn't mean that the application failed. For example, a message wasn't passed correctly because it was not correct. The code execution is continuing, but we could log that with the warn level to inform us and others that potential problems are happening.</td>
  </tr>
  <tr>
   <td>Info</td><td>The standard level of log information that indicates normal application action. For example, created the user with an ID is an example of a log message on an info level that gives you information about certain processes that finished with a success. In most cases, if you are not looking into how your application performs, you could ignore most, if not all, of the info level logs.</td>
  </tr>
  <tr>
   <td>Debug</td><td>Less granular than trace level, but still more granular than info level and more detailed than you need in your normal everyday use. Debug level should be used for information that can be useful for troubleshooting and is not needed for looking at the everyday application state.</td>
  </tr>
   <tr>
    <td>Trace</td><td>Very fine grained information only used in a rare case where you need the full visibility of what is happening in most cases is a trace level will be very verbose. But you can also expect a lot of information about the application used for annotating the steps in your program that are not relevant in everyday use.</td>
  </tr>
 </tbody>
</table>

### Logging Levels java.util.logging VS SLF4J
<table>
 <thead>
  <tr>
   <th>java.util.logging</th><th>SLF4J</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>Off</td><td>Error</td>
  </tr>
  <tr>
   <td>Severe</td><td>Error</td>
  </tr>
  <tr>
   <td>Warning</td><td>Warn</td>
  </tr>
  <tr>
   <td>Info</td><td>Info</td>
  </tr>
  <tr>
   <td>Config</td><td>Info</td>
  </tr>
   <tr>
    <td>Fine</td><td>Debug</td>
  </tr>
   <tr>
    <td>Finer</td><td>Debug</td>
  </tr>
  <tr>
    <td>Finest</td><td>Trace</td>
  </tr>  
  <tr>
    <td>All</td><td>Trace</td>
  </tr>
 </tbody>
</table>
