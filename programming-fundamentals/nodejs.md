# Introduction to Node.js

## Synchronous vs Asynchronous Code (Blocking vs Non-blocking)

### Synchronous code AKA Blocking code 
```javascript
const fs = require('fs');

// Blocking code execution
const input = fs.readFileSync('input.txt', 'utf-8');
console.log(input);
```
- To read a file and then save its content into a variable, is in a synchronous way.
- Each statement is basically processed one after another, line by line.
- First, the file system module is required, then file is read and we log result to the console.
- Each line of code waits for the result of the previous line.
- It's problematic due to slow operations because each line blocks the execution of the previous line.

### Asynchronous code AKA Non-blocking code
```javascript
const fs = require('fs');

// Non-blocking code execution
fs.readfile('input.txt', 'utf-8', (err, data) => {
    console.log(data);
});
console.log('Reading file...');
```

In asynchronous code, we upload heavy work to basically be worked on in the background. \
Once that work is done, a callback function that we registered before is called to handle the result. \
During all the time, the code can still be executing without being blocked by the heavy task, 
which is now running in the background.\
We can effectively defer or reaction into the future in order to make the code non-blocking.

What's the problem with blocking code execution in Node.js?
Why do we use callback function so many times in Node.js?

## Asynchronous nature of Node.js: An overview
- A Node.js process, where our application is running, there's only one single thread (main thread).
- The other threads act as background threads. API execute as background threads.
- For each application, there's only one thread. A thread is just like a set of instructions that's run in the computer's CPU. 
The thread is actually executed in a machine's processor. 
- What this means is all users accessing your application are all accessing the same thread.
- Whenever they're interacting with the application, the code that is run for each user, will be executed all in the same thread, at the same place, in the computer running the application.
- What this means is that when one user blocks the single thread with the synchronous code, then all other users have to wait for that execution to finish.
- It's the responsibility as a developer to avoid this kind of situation by using asynchronous code.
- The asynchronous file read function does the heavy and time-consuming work in the background, where it basically stays until it is finished reading the file from the data.
- We can register a callback function to be called once the data is available.
- In this scenario, all the other users can then perform their tasks (login) in a single thread, one after another, while the file is still being read in the background.
- Once data is read, our callback function will get called to be executed in a main single thread in order to process the read data.
- When we use callback functions in our code, that doesn't automatically make it asynchronous.
- Passing functions around into other functions is quite common in javascript.
- It only works this way for some functions in the Node API, such as the readfile function and etc.

What is callback hell in Node.JS?
- Callback hell in Node. js is the situation in which we have complex nested callbacks.
- In this, each callback takes arguments that have been obtained as a result of previous callbacks.
- This kind of callback structure leads to lesser code readability and maintainability.

How to escape the callback hell?
- Use of more advanced tools for handline asynchronous code like ES6 promises, or even better ES8 async/await.
- These are more elegant ways of dealing with the code itself and writing it.

Can Node.js be used as multi-thread?
- Using advanced feature called worker threads. But typically, for many applications, that's not necessary at all thanks to Node's event loop.
- Highly fast and efficient with the single thread.

### Reading and writing files asynchronously
```javascript
const fs = require('fs');

/* Non-blocking code execution
 * Node will start reading the file in the background and as soon as it's ready,
 * it will start the callback function that we specify here which takes in two arguments, error and actual data
fs.readfile('./txt/start.txt', 'utf-8', (err, data) => {
    console.log(data);
});
console.log('Will read file!');
```
- As soon as the readfile function is run, it will start reading this file (./txt/start.txt) in the background without blocking the rest of the code execution.

Which log will display first? 
```javascript
Will read file!
read-this
```
- Node.js will start reading the file in the background and will not block the code, and then immediately move on to the next line of code.
- "Will read file!" will be the first thing that is logged to the terminal
- When a file is completely read, then the callback function will run, which has access to the error and the data that was read.

```javascript
const fs = require('fs');

/* Non-blocking code execution
 * Node will start reading the file in the background and as soon as it's ready,
 * it will start the callback function that we specify here which takes in two arguments, error and actual data
fs.readfile('./txt/start.txt', 'utf-8', (err, data1) => {
    fs.readfile(`./txt/${data1}`, 'utf-8', (err, data2) => {
        console.log(data2);
    });
});
console.log('Will read file!');
```
```javascript
// The output is:
Will read file!
The avocado 🥑 is also used as the base for the Mexican dip known as guacamole, 
as well as a spread on corn tortillas or toast served with spices.
```

```javascript
const fs = require('fs');

/* Non-blocking code execution
 * Node will start reading the file in the background and as soon as it's ready,
 * it will start the callback function that we specify here which takes in two arguments, error and actual data
fs.readfile('./txt/start.txt', 'utf-8', (err, data1) => {
    fs.readfile(`./txt/${data1}`, 'utf-8', (err, data2) => {
        console.log(data2);
        fs.readfile('./txt/append.txt', 'utf-8', (err, data3) => {
            console.log(data3);

            // what we want to write to the file
            fs.writefile('./txt/final.txt', `${data2}\n${data3}` 'utf-8', (err) => {
                console.log('Files have been written! 😀');
            })
        });
    });
});
console.log('Will read file!');
```
```javascript
// The output is:
Will read file!
The avocado 🥑 is also used as the base for the Mexican dip known as guacamole, 
as well as a spread on corn tortillas or toast served with spices.
APPENDIX: Generally, avocados 🥑 are served raw, but some cultivars can be cooked for a short time without become bitter.
```

```javascript
// Inside final.txt
The avocado 🥑 is also used as the base for the Mexican dip known as guacamole, 
as well as a spread on corn tortillas or toast served with spices.
APPENDIX: Generally, avocados 🥑 are served raw, but some cultivars can be cooked for a short time without become bitter.
```

```javascript
const fs = require("fs");
const { promisify } = require("util");
 
//Non-blocking, asynchronous way
const readFileAsync = promisify(fs.readFile);
const writeFileAsync = promisify(fs.writeFile);
const readAndWrite = async () => {
  try {
    const read = await readFileAsync("./txt/start.txt", "utf-8");
    const read2 = await readFileAsync(`./txt/${read}.txt`, "utf-8");
    const read3 = await readFileAsync("./txt/append.txt", "utf-8");
    console.log("Your file has been written");
    await writeFileAsync("./txt/final.txt", `${read2}\n${read3}`, "utf-8");
  } catch (error) {
    console.log("caught error: ", error);
  }
};
readAndWrite();
```

Typically, without arrow function, it gets the lexical this keyword from the parent function
```javascript
function(err, data1) {
    this
}
```
1. Global Context: If this function is called globally, this would refer to the global object (e.g., window in a browser or global in Node.js).
2. Object Method: If this function is called as a method of an object, this would refer to that object.
3. Event Handler: If this function is used as an event handler, this typically refers to the DOM element that triggered the event.
4. Constructor Function: If this function is used as a constructor function (i.e., with the new keyword), this would refer to the newly created object.
5. Explicit Context: You can also explicitly set the value of this using methods like call(), apply(), or bind().

```javascript
const fs = require('fs');

/* Non-blocking code execution
 * Node will start reading the file in the background and as soon as it's ready,
 * it will start the callback function that we specify here which takes in two arguments, error and actual data
fs.readfile('./txt/starttttt.txt', 'utf-8', (err, data1) => {
    if (err) return console.log('ERROR! 💥')    

    fs.readfile(`./txt/${data1}`, 'utf-8', (err, data2) => {
        console.log(data2);
        fs.readfile('./txt/append.txt', 'utf-8', (err, data3) => {
            console.log(data3);

            // what we want to write to the file
            fs.writefile('./txt/final.txt', `${data2}\n${data3}` 'utf-8', (err) => {
                console.log('Files have been written! 😀');
            })
        });
    });
});
console.log('Will read file!');
```
```javascript
// The output is:
Will read file!
ERROR! 💥
```
