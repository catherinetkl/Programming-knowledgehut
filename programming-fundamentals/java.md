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
## Generic Methods
```java
// GenericMethods.java
package com.globalsoftwaresupport;

// Create a class Generic Method
public class GenericMethod {
	// In this class, it's going to be a void method that's going to showItem
	// Define a given generic type parameter
	// we can construct a generic method that's going to wait for a generic item 	
	// (String, custom object, an integer, floating point number)
	public <T> void showItem(T item) {
		// we print out the item and we call the toString method that's going to convert the item to string
		System.out.println("The item is: " + item.toString());
	}
}
```
If we saved it, in the App.java		
```java
// App.java
package com.globalsoftwaresupport;

public class App {
	
	public static void main(String[] args) {
		// Instantiate a genericMethod
		GenericMethod method = new genericMethod();
		method.showItem("Hello world!");
	}
}
```
```java
// Output of App.java
The item is: Hello world!
```
What do we have to do if we want to return a given item?
- Need to make sure that the return type is not going to be void, but it is going to return the given type itself.

```java
// GenericMethods.java
package com.globalsoftwaresupport;

// Create a class Generic Method
public class GenericMethod {
	// In this class, it's going to be a void method that's going to showItem
	// Define a given generic type parameter
	// we can construct a generic method that's going to wait for a generic item 	
	// (String, custom object, an integer, floating point number)
	public <T> T showItem(T item) {
		// we print out the item and we call the toString method that's going to convert the item to string
		System.out.println("The item is: " + item.toString());
		return item;
	}
}
```
```java
// App.java
package com.globalsoftwaresupport;

public class App {
	
	public static void main(String[] args) {
		// Instantiate a genericMethod
		GenericMethod method = new genericMethod();
		System.out.println("The item returned is: " + method.showItem(34.5));
	}
}
```
```java
// Output of App.java
The item is: 34.5
The item returned is: 34.5
```
The first line is printed out because System.out.println("The item is: " + item.toString()); is from the showItem method as concerned, then we print out the return value.

### Generic Methods II: Using multiple parameters
```java
// GenericMethods.java
package com.globalsoftwaresupport;

public class GenericMethod {

	public <T,V> void printItems(T t, V v) {
		System.out.println(t.toString());
		System.out.println(v.toString());
	}
	public <T> void showItem(T item) {
		// we print out the item and we call the toString method that's going to convert the item to string
		System.out.println("The item is: " + item.toString());
	}
}
```
call that method in App.java
```java
// App.java
package com.globalsoftwaresupport;

public class App {
	
	public static void main(String[] args) {

		GenericMethod method = new genericMethod();
		method.printItems("Adam", 3);
	}
}
```
```java
// Output of App.java
Adam
3
```

This kind of solutions are crucial when implementing data structures from scratch. \
As far as hash tables are concerned, we are dealing with key-value pairs.

How to use a one-dimensional array of generic items?

```java
// GenericMethods.java
package com.globalsoftwaresupport;

public class GenericMethod {

	public <T,V> void printItems(T t, V v) {
		System.out.println(t.toString());
		System.out.println(v.toString());
	}

	public <T> void showItems(T[] items){
		for (T item : items)
			System.out.println(item);
	}
	public <T> void showItem(T item) {
		// we print out the item and we call the toString method that's going to convert the item to string
		System.out.println("The item is: " + item.toString());
	}
}
```
```java
// App.java
package com.globalsoftwaresupport;

public class App {
	
	public static void main(String[] args) {

		GenericMethod method = new genericMethod();
		
		// create a one-dimensional array of integers
		// int[] nums = { 1, 2, 5, 4, 3 }; primitive type representation doesn't work
		// Integer object representation works
		Integer[] nums = { 1, 2, 5, 4, 3 };
		method.showItems(nums);

		String[] names = {"Adam", "Anna", "Daniel", "Kevin", "Michael"};
		method.showItems(names);
	}
}
```
```java
// Output of App.java
1
2
5
4
3
Adam
Anna
Daniel
Kevin
Michael
```
### Generic methods exercise

```java
/* Let's implement a generic method that checks 2 parameters share the same value or not!
 * For example: checkEquality(12, 8) returns false
 * checkEquality(10.5, 10.5) returns true
 * checkEquality("Joe", "Joe") returns true */

public class Exercise {

    // implement the checkEquality() method that takes 2 values as input parameters and it returns
    // a boolean value whether the values are matching or not
    public <T,V> boolean checkEquality(T value1, V value2) {
        return value1.equals(value2);
    }
    
    public static void main(String[] args) {
        Exercise exercise = new Exercise();
        
        int int1 = 12;
        int int2 = 8;
        boolean intResult = exercise.checkEquality(int1, int2);
        
        float float1 = 10.5f;
        float float2 = 10.5f;
        boolean floatResult = exercise.checkEquality(float1, float2);
        
        String name1 = "Joe";
        String name2 = "Joe";
        boolean stringResult = exercise.checkEquality(name1, name2);
    }
}
```

```java
// solution
public class Exercise {
 
    public <T> boolean checkEquality(T t1, T t2) {
        return t1.equals(t2);
    }
}
```

## Bounded Generic Types

### What's the motivation behind bounded Generic types
- The motivation is that sometimes we want to restrict the types that can be used as type arguments.
- For example, a method that operates on numbers such as integers, floating point numbers or doubles might only want to accept instances of the number class or its subclasses. For example, let's assume that we would like to execute some mathematical operation and of course we can do mathematical operations on integers, floats and doubles.
- We are not able to execute mathematical operations on strings or characters. So this is why sometimes it is crucial to restrict the generic types.
- And this is exactly why there are bounded type parameters and bounded types allow you to invoke methods defined in the bounds.

```java
package com.globalsoftwaresupport;

// what happens if we want to instantiate a new person
class Person implements Comparable<Person> {
  
  private int age;
  private String name;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // generate the getter method
  public int getAge() {
    return age;
  } 

  // Add the unimplemented compareTo method
  @Override
  public int compareTo(Person otherPerson) {
    return Integer.compare(age, otherPerson.getAge());
  }

  
  @Override
  public String toString() {
    return "Person [age=" + age + ", name=" + name + "]";
  }
  
}
public class App {
  
  public static <T extends Comparable<T>> T calculateMin(T num1, T num2) {

    // comparable interface has a compareTo method - it means that num1 < num2
      if (num1.compareTo(num2) < 0) {
        return num1;
      return num2;

    } 
  }
  
  public static void main(String[] args) {

    System.out.println(calculateMin(new Person("Adam", 45),new Person("Kevin", 78));
    System.out.println(calculateMin(new Person("Mindy", 23),new Person("Mavis", 46));
  }
}
```

```java
// Output of App.java
Person [age=45, name=Adam]
Person [age=23, name=Mindy]
```
```java
/* In the previous lecture we have been talking about bounded type parameters.
 * Let's construct a method that can add 2 arbitrary Numbers (whether it is an integer, 
 * a float or a double). */

public class Exercise {
    
    // here you have to implement a generic method to add 2 numbers and return the result
    // name of the method must be add(num1, num2) - with 2 arguments num1 and num2 !!!
    public <T extends Number> T add(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}
```

```java
// solution
public class App {
 
    public static <T extends Number> double add(T num1, T num2) {
        double result = num1.doubleValue() + num2.doubleValue();
	return result;
    }

    public static void main(String[] args) {
	System.out.println(add(10.0,20.0));
    }
}
```
```java
// Output of App.java
30.0
```
```java
// solution
public class App {
 
    public static <T extends Number> int add(T num1, T num2) {
        int result = num1.intValue() + num2.intValue();
	return result;
    }
    
    public static void main(String[] args) {
	System.out.println(add(10,14));
    }
}
```
```java
// Output of App.java
24
```
```java
/* In this exercise, your task is to construct a generic method that takes a T[] one-dimensional array 
 * as the input with a T item and it counts that how many items are greater than this specified T item.
 * For example: [1, 2, 3, 4, 5] and item=3 --> result is 2 because 4, 5 are greater than 3.
 * [1.4, 2.1, 3.9, 4.3, 5.1] and item=2.0 --> result is 4 because 2.1, 3.9, 4.3, 5.1 are greater than 2.0.
 * ["a", "b", "f", "d", "e"] and item="c" --> result is 3 because "f", "d", "e" are greater than "c" in the
 * alphabetical order. */

public class Exercise {

    // method name must be: countGreaterItems(T[] items, T item) !!! 
    public static <T extends Comparable<T>> int countGreaterItems(T[] items, T item){
        // Initialize a variable to keep track of the count
        int count = 0;
        // Loop through each element in the array for each element in array
        for (T element: items) {
            // Compare the current element with the specified item if element > item
            if (element.compareTo(item) > 0) {
		// If the current element is greater, increment the count
                count++;
            }
        }
	// Return final count
        return count;
    }
}
```
```
Review: 
Question 1: 
What is the motivation behind bounded type parameters?
- We want to restrict the types that can be used a type arguments

Question 2:
Bounded types allow you to invoke methods defined in the bounds?
- True
```

## Type Inference
- Type inference is the ability of the compiler to look at each method invocation and corresponding declaration
- To determine the type argument(s) such as T generic type - that make the invocation applicable
- The type inference algorithm determines <T> type of the arguments + the type that the result is being assigned ore returned if available

```java
public <T> T getData(T t1, T t2) {
   return t1;
}
```
- The type inference algorithm tries to find the most specific type that works with all of the arguments
- If we use this method, so getData method with a string and an arraylist, then if a Serializable is used as the return type, there is no need for casting for return type.
- Both string and array list implements the Serializable interface so we can use something like this without any problem.
```java
Serializable s = getData("Hello World", new ArrayList<>());
```
- Another feature of Type inference is that we can use class instantiation like this
```java
List<String> list = new ArrayList<>();
```
- So whenever we instantiate an array list, like a list in the generic manner, means that we have to define the type. The items we are going to store in the underlying one-dimensional array and then we can define the string with the <> diamond operator.
- But due to Type inference algorithm, we can use class instantiation without having to specify that the arraylist is going to store strings because the compiler is going to know we are going to use a list interface and it is equals to a new arraylist implementation.
- Type inference enables us to invoke a generic method as an ordinary Java method without specifying the type
```java
import java.util.List;

package com.globalsoftwaresupport;

// going to have a class named Bucket, and it is generic typed,
// has to be defined outside the App class
class Bucket <T> {
	// bucket is going to store generic items
	private T item;

	// create getter method
	public <T> getItem() {
		return this.item;
	}

	// create setter method
	public void setItem(T item) {
		this.item = item;
	}
}

public class App {
	// t parameter and going to get a list of generic buckets, return type void
	public static <T> void addStore(T t, List<Bucket<T>> list) {

		// Instantiate the bucket
		Bucket<T> bucket = new Bucket<>();
		bucket.setItem(t);
		// add bucket to the list
		list.add(bucket);
		// Print out
		System.out.println(t.toString() + " has been added to the list...");
	}

	// Main method
	public static void main(String[] args) {

		List<Bucket<String>> list = new ArrayList<>();
		App.addStore("Adam", list);
		// type witness
		App.<String>addStore("Daniel", list);
	}
}
```
- Bucket Class:
	- Bucket is a generic class that can store items of any data type.
	- It has a private field item of type T to store the item. It has a getter getItem and a setter setItem to get and set the item.

- addStore Method:
	- This is a generic method that takes two parameters: 
	- T t: The item to be stored in a Bucket.
	- List<Bucket<T>> list: A list of buckets that can store items of type T.
	- Inside the method, a new Bucket is created and initialized with the item t.
	- The Bucket is then added to the list.
	- It prints a message to indicate that the item has been added to the list.

- main Method:
	- It starts by creating an empty ArrayList of Bucket<String> called list.
	- It calls the addStore method to add two strings, "Adam" and "Daniel", to the list.

- Type Inference:
	- Java's type inference allows you to omit the type parameters when calling generic methods. In this code, you see an example of type inference when calling App.addStore("Adam", list). 
	- You don't need to specify the type parameter <String> because the Java compiler can infer it from the arguments.

- Type Witness:
	- The code also demonstrates the use of a type witness.
 	- A type witness is explicitly specifying the type parameter when calling a generic method.
  	- This can be useful when the compiler cannot infer the type correctly or when you want to be explicit about the types.
	- In the line App.<String>addStore("Daniel", list);, <String> is a type witness, indicating that the type parameter should be String. This is done explicitly.

- Use Cases:
	- Type inference and type witnesses are useful when working with generic methods or classes, as they allow you to write more concise and readable code.
	- Use type inference when the compiler can correctly infer the type from the context.
	- Use a type witness when you want to be explicit about the types, especially in situations where the compiler might not infer the type correctly.

```java
package com.globalsoftwaresupport;

import java.util.ArrayList;
import java.util.List;

public class App {	
	// Generic method that's going to add generic items to a generic list
	static <T> List<T> add(List<T> list, T item1, T item2) {
		list.add(item1);
		list.add(item2);
		return list;
	}

	public static void main(String[] args) {

		// Test whether type inference is working fine or not
		// since input values in the parameter are integers, 
		// java is going to know that ArrayList will store integers
		List<Integer> list1 = add(new ArrayList<>(), 20, 30);
		System.out.println(list1); // [20, 30]

		List<String> list2 = add(new ArrayList<>(), "Adam", "Kevin");
		System.out.println(list2); // [Adam, Kevin]

		List<Character> list2 = add(new ArrayList<>(), 'a', 'b');
		System.out.println(list2); // [a, b]
		
	}
}
```
## Subtyping
- Fundamental principle in object-oriented programming
- One type is a subtype of another if they're related by "extends" or "implements" clause
```
Integer is a subtype of Number (Integer extends Number class)
ArrayList<E> is a subtype of List<E> 
(Transitive property "relationship": if the ArrayList is a subtype of List and List is a subtype of Collection, then ArrayList is a subtype of Collection)
List<E> is a subtype of Collection<E>
```
- In Java, we can create interfaces and the given class can implement a given interface
- A given class may extend another class - Inheritance
- With the help of inheritance we can define subclasses and parent classes or super classes
- If one type is a subtype of another, then it means that the second is a supertype of the first
	- Number is a supertype of Integer
 	- List is a supertype of ArrayList
	- Collection is a supertype of List and ArrayList
- Despite the fact that Integer is a subtype of Number, if we created a List of Integers, it is not a subtype for a List of Numbers
```
List<Integer> is not a subtype of List<Number>
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
   <td>Logger</td><td>Logger object is used to log messages for a specific system or application component. Main entity that an application uses to make logging calls to capture log records to the appropriate handler.</td>
  </tr>
  <tr>
   <td>LogRecord</td><td>Log records (Logging event is an entity) are used to pass logging requests between the logging framework and individual log handlers that are responsible for log shaping.</td>
  </tr>
  <tr>
   <td>Handler</td><td>Handlers exports Log records objects to a variety of destinations, including memory, output streams, consoles, files and sockets. A variety of handler subclasses exist for this purpose. Additional handlers may be developed by third parties and delivered on top of the core platform. Log object is usually used for a single class or a single component to provide context bound to a specific use case.</td>
  </tr>
  <tr>
   <td>Level</td><td>Level defines a set of standards, lodging levels that can be used to control logging output. Programs can be configured to output logging for some levels while ignoring output for others.</td>
  </tr>
  <tr>
   <td>Filter</td><td>Filter provides fine grained control over what gets logged beyond the control provided by log levels. The logging API supports a general purpose filter mechanism that allows application code to attach arbitrary filters to control log and output.</td>
  </tr>
   <tr>
    <td>Formatter</td><td>Formatter provides support for formatting log record objects. This package includes two formatters: SimpleFormatter (Generate all messages as text) and XMLFormatter (Generates XML output for the log messages). For formatting log records in plain text or XML, respectively. As with handlers, additional formatters may be developed by third parties.</td>
  </tr>
 </tbody>
</table>

### Examples of handlers
<table>
 <thead>
  <tr>
   <th>Handlers</th><th>Description</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>ConsoleHandler</td><td>A ConsoleHandler records all the log messages to System.err. By default, a Logger is associated with this handler.</td>
  </tr>
  <tr>
   <td>FileHandler</td><td>A FileHandler is used to record all the log messages to a specific file or to a rotating set of files.</td>
  </tr>
  <tr>
   <td>StreamHandler</td><td>A StreamHandler publishes all the log messages to an OutputStream.</td>
  </tr>
  <tr>
   <td>SocketHandler</td><td>The SocketHandler publish the LogRecords to a network stream connection.</td>
  </tr>
  <tr>
   <td>MemoryHandler</td><td> It is used to keep the LogRecords into a memory buffer. If the buffer gets full, the new LogRecords starts overwriting the old LogRecords.</td>
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


```java
package com.itbulls.learnit.onlinestore.core.logging.javalogging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    static private FileHandler simpleTextFileHandler;
    static private SimpleFormatter simpleFormatter;
    // filehandler for logs in HTML form
    static private FileHandler htmlFileHandler;
    // variables will be initialized with custom HTML format
    static private Formatter htmlFormatter;
    
   /*
		The following lists the Log Levels in descending order:

		SEVERE (highest)
	
		WARNING
	
		INFO
	
		CONFIG
	
		FINE
	
		FINER
	
		FINEST
	
		LOGGER.setLevel(Level.INFO);
		In addition to that you also have the levels OFF and ALL to turn the logging off or to log everything.

============================================================================================================================
		You can also build your own custom formatter.
		Add multiple handlers to the global logger 
*/

    static public void setup() throws IOException {
        // Configure global logger - intended for all the application
        // use getLogger method from Logger class and pass it as stream values which is used as a logger identifier
	// If a logger has already been created with a given name, it is returned, otherwise a new logger is created
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	// we can set a level to the logger - specift which message levels will be logged by this logger
	// message levels lower than this value will be discarded
	// why is it needed? For example, you can configure one logger to write in the file 
	// all messages including finest or trace level log records and you can use another logger that will print into
	// the output stream on the log messages with warn error and fatal level
        logger.setLevel(Level.FINE);
	
        // initialize our file handlers with our file handler object
	// one filehandler will store logs in simple text format
        simpleTextFileHandler = new FileHandler("log-example-simple-text-formatter.txt");
        // one filehandler will store logs in HTML format
	htmlFileHandler = new FileHandler("log-example-html-formatter.html");

	// you can limit logs with a specific level by setting level not the the logger, but the handler itself
	// message levels lower than the one we passed in the setLevel method will be discarded
	// the intention is to allow developers to churn on voluminous logging, 
	// but to limit the messages that are sent to a certain handler
        simpleTextFileHandler.setLevel(Level.SEVERE);

        // create a TXT formatter from JDK - this is a class from java.util.logging package
        simpleFormatter = new SimpleFormatter();

	// set format for the file handler
	// now when log records will be published as a file,
	// simpleFormatter will format text messages
        simpleTextFileHandler.setFormatter(simpleFormatter);

	// Add file handler for simple text to the logger with the help of addHandler method
        logger.addHandler(simpleTextFileHandler);

        // create an HTML formatter (custom type)
        htmlFormatter = new MyHtmlFormatter();
        htmlFileHandler.setFormatter(htmlFormatter);
        logger.addHandler(htmlFileHandler);
    }
}
```
```java
package com.itbulls.learnit.onlinestore.core.logging.javalogging;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* custom handler template class contains a skeleton of new custom handler
 * You can also create your own handler by extending the handler class
 * (extend abstract handler class and implement 3 abstract methods */
public class CustomHandlerDemo extends Handler {

	@Override
	public void publish(LogRecord logRecord) {
		System.out.println(
				String.format("Log level: %s, message: %s", 
						logRecord.getLevel().toString(), logRecord.getMessage()));
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() throws SecurityException {
	}

}
```
```java
package com.itbulls.learnit.onlinestore.core.logging.javalogging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* MyHtmlFormatter that extends the abstract Formatter class from the java.util.logging package
 * This class extends the Formatter class, indicating that it's a custom log formatter.
 * It will be responsible for formatting log records
 * this custom formatter formats parts of a log record to a single line */
public class MyHtmlFormatter extends Formatter {
	
    /* implement format method that takes LogRecord as a parameter
     * this is the only abstract method in the Formatter class
     * this method is called for every log records
     * This is the overridden format method, a required method in any class that extends the Formatter class. 
     * This method takes a LogRecord as a parameter, which contains information about the log event.
     * Inside this method, a StringBuffer named buf is created to build the formatted log record.
     * The method starts by opening an HTML table row (<tr>).
     * It then checks the log level of the LogRecord and colors the log level text in red and 
     * makes it bold if it's at least Level.WARNING. This is used to highlight warning and error log levels.
     * It appends the log level, the log record's timestamp, and the formatted log message to the table row.
     * The method closes the table row.
     * The formatted log record is returned as a string. */
	@Override
    public String format(LogRecord rec) {
        StringBuffer buf = new StringBuffer(1000);
        buf.append("<tr>\n");

        // colorize any levels >= WARNING in red
        if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
            buf.append("\t<td style=\"color:red\">");
            buf.append("<b>");
            buf.append(rec.getLevel());
            buf.append("</b>");
        } else {
            buf.append("\t<td>");
            buf.append(rec.getLevel());
        }

        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append(calcDate(rec.getMillis()));
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append(formatMessage(rec));
        buf.append("</td>\n");
        buf.append("</tr>\n");

        return buf.toString();
    }

    // This helper method is used to format the timestamp (in milliseconds) into a human-readable date and time.
    // It uses a SimpleDateFormat to achieve this.
    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }

    // we can override getHead method to provide the HTML header for the log output. 
    // It is called just after the handler is set to use this formatter. 
    // The HTML header includes a basic table structure and styling.
    @Override
    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<head>\n<style>\n"
            + "table { width: 100% }\n"
            + "th { font:bold 10pt Tahoma; }\n"
            + "td { font:normal 10pt Tahoma; }\n"
            + "h1 {font:normal 11pt Tahoma;}\n"
            + "</style>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>" + (new Date()) + "</h1>\n"
            + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
            + "<tr align=\"left\">\n"
            + "\t<th style=\"width:10%\">Loglevel</th>\n"
            + "\t<th style=\"width:15%\">Time</th>\n"
            + "\t<th style=\"width:75%\">Log Message</th>\n"
            + "</tr>\n";
      }

    // this method is called just after the handler using this
    // formatter is closed
    public String getTail(Handler h) {
        return "</table>\n</body>\n</html>";
    }
}
```
```java
package com.itbulls.learnit.onlinestore.core.logging.javalogging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public void doSomethingAndLog() {
        LOGGER.setLevel(Level.SEVERE);
        
        LOGGER.severe("SEVERE Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("FINEST Really not important");

        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("SEVERE Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Finest Really not important");
    }

    public static void main(String[] args) {
        LoggerDemo loggerDemo = new LoggerDemo();
        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        loggerDemo.doSomethingAndLog();
    }
}
```
