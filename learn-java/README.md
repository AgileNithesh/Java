# Java A2Z
*My go-to reference for Java.*


## Access Specifiers

- private -- access from same class only.
- public -- access from anywhere.
- protected -- access from other class in same package or subclasses in different package
- default -- if access specifier is not specified then default is used by java, it can be
            accessed only by the classes in same package. 
 

## Memory management

2 Types of memory (Stack, Heap) --> RAM --> JVM Manages the memory

### Stack
- Store temporary variables and separate memory block for methods
- Store Primitive data types
- Store references of heap objects
  * Strong reference -- GC won't delete the object
    * Employee e  = new Employee()
  * Weak Reference -- GC will delete and access after GC will result in null
    * WeakReference\<Employee> weakE = new WeakReference\<Employee>(new Employee())
  * Soft reference -- GC will remove only in the case of immediate memory space clearance
    * SoftReference\<StringBuilder> reference2 = new SoftReference<>(builder, referenceQueue);
- Each threads will have its own stack memory
- Stack variable scopes are cleaned up in LIFO manner ( hierarchy of {var a {var b}})
- When stack memory goes full - "java.lang.StackOverflowError


### Heap
- Store objects
- Heap memory is same across all threads
- There is no order of allocating the memory
- Garbage Collector deletes unreferenced objects from heap periodically
  * Mark and Sweep Algorithm
  * if System.gc() is called explicitly this does not guarantee garbage collection
  * automated garbage collection based on memory analytics
- 2 parts of heap memory
  * Young Generation - 3 parts again -- Minor GC
    * Eden 
      * new objects
    * S0 (Survivor)
      * new objects remaining in Eden after GC sits here after age 1 of the object
    * S1
      * new Objects remaining after 2nd GC in Eden and S1 goes in here and age 1(Eden) and age 2 (S0)
    * If the age threshold is 3 and if S1 is full and S0 is free it obj's and swap
    * after threshold Obj will move to old generation
    
  * Old Generation -- Major GC
    * GC runs less periodically and these obj's mostly used frequently since alive from
      so long  might lead to multiple references which justifies less frequent GC
- Meta Space -- JVM Native memory separate form Heap memory  
  * It holds class definitions, method data, field info, and constant pools for loaded classes, 
    tied to their class loaders.
  * Before Java 8 it is called PermGenSpace(which was part of heap memory)
  * Garbage collected when class loaders unload classes, avoiding leaks from excessive loading.

### Garbage Collector

- GC is expensive since it pauses all application threads till GC is completed

- Algorithms 
  * Mark and Sweep algo
  * Mark and Sweep with Compact algo -- after GC remaining obj's made to be in sequence

- Types of GC
  * Serial GC - only one GC thread for Minor and Major, slow process, till Java 8, Pause target 100ms
  * Parallel GC - for multi core and less pause time, similar pause, till java 8
  * Concurrent Mark and Sweep - Removed in Java 14, No Pause GC is concurrently in best effort basis,
                                So no guarantee that application thread won't stop,
                                No memory compaction.
  * G1 Garbage Collector - Best effort no pause of application threads with memory compaction, 
                           Default GC from Java 17+, default pause time target is 200ms, 
                           pause time target can be configured. 
  * ZGC - ZGC (Z Garbage Collector) is a scalable, low-latency GC in modern Java versions, 
          targeting sub-millisecond pauses (<1-10ms) independent of heap size (8MB to 16TB). 
          It uses colored pointers, load/store barriers, and region-based concurrent mark-relocate
          to keep most work off application threads.Introduced experimentally in JDK 11, 
          production-ready in JDK 15; generational version stable in JDK 21 for better throughput.


                                
  
