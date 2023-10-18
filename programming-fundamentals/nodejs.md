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
- A Node.js process, where our application is running, there's only one single thread.
- For each application, there's only one thread. A thread is just like a set of instructions that's run in the computer's CPU. 
The thread is actually executed in a machine's processor. 
- What this means is all users accessing your application are all accessing the same thread.
- Whenever they're interacting with the application, the code that is run for each user, will be executed all in the same thread, at the same place, in the computer running the application.
- What this means is that when one user blocks the single thread with the synchronous code, then all other users have to wait for that execution to finish.
