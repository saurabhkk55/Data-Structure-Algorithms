https://chatgpt.com/share/cb75f5af-f0ad-4625-a536-a0070219d690

What is multithreading?
ANS)
Multithreading is a process of executing multiple threads simultaneously. Multithreading is used to obtain the multitasking. It consumes less memory and gives the fast and efficient performance. Its main advantages are:

- Threads share the same address space.
- The thread is lightweight.
- The cost of communication between the processes is low.

##########################################################################################################

2) What is the thread?
A thread is a lightweight subprocess. It is a separate path of execution because each thread runs in a different stack frame. A process may contain multiple threads. Threads share the process resources, but still, they execute independently.

A project (process) can have many workers (threads) working simultaneously. They all share the same resources (like documents or tools), but each worker handles its own part of the project independently.

##########################################################################################################


Differentiate between process and thread?

There are the following differences between the process and thread.
A Program in the execution is called the process whereas; A thread is a subset of the process
Processes are independent whereas threads are the subset of process.
Process have different address space in memory, while threads contain a shared address space.
Context switching is faster between the threads as compared to processes.
Inter-process communication is slower and expensive than inter-thread communication.
Any change in Parent process doesn't affect the child process whereas changes in parent thread can affect the child thread.

##########################################################################################################

4) What do you understand by inter-thread communication?
The process of communication between synchronized threads is termed as inter-thread communication.
Inter-thread communication is used to avoid thread polling in Java.
The thread is paused running in its critical section, and another thread is allowed to enter (or lock) in the same critical section to be executed.
It can be obtained by wait(), notify(), and notifyAll() methods.

##########################################################################################################

8) What are the states in the lifecycle of a Thread?
A thread can have one of the following states during its lifetime:

New: In this state, a Thread class object is created using a new operator, but the thread is not alive. Thread doesn't start until we call the start() method.
Runnable: In this state, the thread is ready to run after calling the start() method. However, the thread is not yet selected by the thread scheduler.
Running: In this state, the thread scheduler picks the thread from the ready state, and the thread is running.
Waiting/Blocked: In this state, a thread is not running but still alive, or it is waiting for the other thread to finish.
Dead/Terminated: A thread is in terminated or dead state when the run() method exits.

##########################################################################################################


##########################################################################################################


##########################################################################################################


##########################################################################################################


##########################################################################################################


##########################################################################################################


##########################################################################################################


##########################################################################################################
