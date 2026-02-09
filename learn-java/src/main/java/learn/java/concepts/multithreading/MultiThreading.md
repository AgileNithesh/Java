# Multithreading

Allows a program to perform multiple operations at the same time. Multiple threads share
resources such as memory but still can perform task independently. This leads to efficient 
usage of available resource.

There are some challenges:
- Concurrency issue like deadlock, data inconsistency
- Synchronized overhead.
- Testing and Debugging is difficult.


## Process

process is an instance of a program which is getting executed.
It has its own resource like memory, thread etc. OS allocate these
resources to process when it is created. 2 process never share resources.

process creation is when the java execution starts
ex: "java MainClass"

## Thread

Thread is also known as lightweight process. OR Smallest sequence of instructions
that are executed by the CPU independently. 
When a process is created, it starts with 1 thread abd that initial thread is known as 
"main thread" from that additional threads can be created to perform tasks concurrently.


## JVM Instance

Whenever a new process is created, a new JVM instance is created and allocated
to the process. A JVM instance will have heap, stack, code segment, register, counter etc.

## Thread Resource

Register, Stack and Counter is specific for each thread. Code segment( Read Only ) contains the 
machine code and shared across threads in a process, Data segment( Read and Write ) contains global and 
static variable and is shared across segments. 

Heap - is shared across threads of a memory, Synchronizations is required between threads.

Stack - manages method calls and variables and private for each thread.

Register - when JIT converts byte code to machine code it uses register to 
optimize the generated machine code, helps in context switching.

Counter - holds then address of code segment section for the thread to execute, increments
after successful execution of instruction.

OS schedules the thread execution then the code segment which is pointed by program counter
gets executed by CPU and then counter is incremented and points to next instruction.

