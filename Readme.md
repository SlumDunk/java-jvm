## day01
    -server  (the run mode of JVM, in this mode we can do escape analysis mix/client)
    -Xmx10m  (size of heap)
    -Xms10m  (size of heap)
    -XX:+DoEscapeAnalysis (open escape analysis)
    -XX:+PrintGC (print gc log)
    -XX:+EliminateAllocations (scarlar replacement)
    -XX:+UseTLAB (use thread local allocation buffer, Allocate private memory in the heap in advance)
    
    Object in Memory Layout
    Header+Instance Data
    
    OOM--mock heap oom
    -server -Xmx5m -Xms5m -XX:+PrintGC
    
    -- Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    
    --Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
      	at com.slam.dunk.day01.OOM.main(OOM.java:24)

    Metaspace--mock metaspace oom
    -server -XX:MaxMetaspaceSize=3M -XX:+PrintGC
    FATAL ERROR in native method: processing of -javaagent failed
    Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
    
    StackOOM--mock stack oom
    -server -Xss256k -XX:+PrintGC
    java.lang.StackOverflowError
    
    DirectMem--mock directmemory oom
    -server -Xmx10m -Xms10m -XX:MaxDirectMemorySize=10M -XX:+PrintGC
    Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    
## day02
    GC
        Reference Counting (fast, easy, refer each other ->isolated island->could not recycle)
        Java use Reachability analysis(GC Roots)
            a.object referneced in static field
            b.object referneced in const field
            c.object referneced in JVM stack 
            d.object referneced in JNI stack 
           
        Strong Reference
            Object obj=new Object()
            
        Soft Reference
            useful but not necessary, will be recycled in priority before OOM
            
        WeakReference
            useful but not necessary, alive until next GC
            
        PhantomReference
            the weakest reference, could not get an instance from this reference, receive notification when it is recycled
            
    TestSoftRef--the feature of SoftReference
    -server -Xmx10m -Xms10m -XX:+PrintGC
                
    TestWeakRef--the feature of WeakReference
    
    Apply the SoftReference and WeakReference when the memory is very limited
                    
    Strategies:
    a.Mark-Sweep Algorithm （memory fragmentation）
    b.Copying Algorithm (wasting space, data copy)
    c.Mark-Compact Algorithm (data copy)
    
    Generational Collection
    New Generation (minor GC)
        Eden/2 Survivors
        8:1:1
        
        GC collector:
        Serial--single thread, copy algorithm
        ParNew--multiple threads, copy algorithm
        Parallel GC--multiple threads, throughput, server side, not heavy CPU application
        
        
    Old Generation (full GC will trigger the GC in old generation)
        CMS--mark sweep multiple threads and parallel
            work with Serial and ParNew
            
        Serial Old--mark compacting single threads
            work with all
            
        Parallel Scavenge--mark compacting multiple threads
            work with Parallel Scavenge
            
    Serial/Serial Old: -XX:+UseSerialGC 
        the oldest, single thread, stop the world, exclusive, mature (1 cpu core server)
        
        -XX:+UseParNewGC ParNew/Seiral Old
        -XX:+UseParallelGC Parallel GC/Serial Old
    
    Parallel Scavenge (ParallelGC)/Parallel Old (care the throughput)
        -XX:MaxGCPauseMills the maximum pause time
        -XX:GCTimeRatio  1/throughput=19 time for GC (1/(1+19))=5%          
                            
        -XX:+UseAdaptiveSizePolicy
        
        -XX:+UseParallelOldGC ParallelGC/Parallel Old
    
    CMS (Cocurrent Mark Sweep), web application
        care pause time
        
        4 phrases:
        a. initial mark (GC Root)--short
        b. concurrency mark--work with the application's thread at the same time
        c. remark--short
        d. concurrent cleanup
        
    -XX:UseConcMarkSweepGC ParNew/CMS
    -XX:CMSInitialOccupyFraction 68% after JDK 1.6 92% 
    
    "Concurrent Mode Fail", use backup collector: Serial Old
    
    open default
    -XX:+UseCMSCompactAtFullCollection
    -XX:+CMSFullGCBeforeCompaction
          
    G1 for both (Mark-compact+copying)
        Predictable pause, no memory fragmentation
        
        -XX:+UseG1GC
    
        mixed collection    
        Survivor/Eden/Old/Humongous
        
        initial mark
        root area scan
        concurrency mark
        remark
        exclusive cleanup
        concurrent cleanup
        
        -XX:MaxGCPauseMillis
        -XX:ParalerGCThreads
        
        
    ZGC (JDK11)
        colored pointer+load barrier
        just one stop the world in the initial mark phrase
        
        TB heap
        GC less than 10ms
        guarantee the throughput
    
    StopWorld
    -server -Xmx300m -Xms30m -XX:+UseSerialGC -XX:+PrintGCDetails
    
    memory allocation and recycle strategy
        eden first
        
        big object allocate into old generation directly
            -XX:PretenureSizeThreshold
            
        live a long time, move into old generation
            -XX:MaxTenuringThreshold=15
            
        Dynamic object age judgement    
        
        space allocation gurantee
            survivor isn't enough to store the object
            
    New Generation Configuration
        -XX:NewSize/MaxNewSize highest
        -Xmn middle
        -XX:NewRatio lowest
        -XX:SurvivorRatio default value is 8 Eden:Survivor1:Survivor2=8:1:1
        
        -server -Xmx20m -Xms20m -Xmn2m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
        
        -server -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
        
        -server -Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
        
        -server -Xmx20m -Xms20m -XX:NewRatio=2 -XX:+PrintGCDetails
        
    Memory Leak
    
    Memory Overflow
    
    Tools
    a.jps
    
    b.jstat
    
    c.jinfo
        jinfo -flag +PrintGCDetail pid
        
    d.jmap    
        
    e.jstack
    
    f.JConsole
        config the remote server:
        -Djava.rmi.server.hostname=…..
        -Dcom.sun.management.jmxremote
        -Dcom.sun.management.jmxremote.port=8888
        -Dcom.sun.management.jmxremote.authenticate=false
        -Dcom.sun.management.jmxremote.ssl=false

    g.VisualVM
    
    h.jhat (analyze the dump bin produced by jmap) Memory Analyzer
    -XX:+HeapDumpOnOutOfMemoryError
    
    shallow heap, retained heap

## day03
    #Java Executive Subsystem   
    .class file
    unsigned number and table
    u1, u2, u4, u8
    table similar to struct
     
    magic+minor_version+major_version+constant_pool_count+constant_pool+access_flags+this_class
    +super_class+interfaces_count+interfaces+fields_count+fields+methods_count+methods+attributes_count
    +attributes
    u4+u2+u2+u2+cp_info+u2+u2+u2+u2+u2+u2+field_info+u2+method_info+u2+attribute_info
    
    javap -verbose xxxx.class
    
    instruction example:
    bipush
    istore_1
    iload_1
    iadd
    imul
    ireturn
    
    class loading mechanism
    Loading->Linking->Initialization->Using->Unloading
    
    Linking:
    Verification->Preparation->Resolution
    
    Loading:
    a. load binary class file
    b. translate the static structure into runtime structure in method area
    c. class object
    
    Initialization:
    JVM guarantee its thread safety
    execute <clinit>, for static field and code block
    
    when Initialize the class, not instance?
    1. new, getstatic, putstatic, invokestatic
    2. Reflection 
    3. create the instance of the class, trigger parent class
    4. class that executes the main function
    5. dynamic language support
    
    ## class loader
    System ClassLoaders:
        Bootstrap ClassLoader
        
        Extension ClassLoader
        
        Application ClassLoader
        
    Parental delegation model
        guarantee the priority and the stable of the application
        
    Thread Context ClassLoader (JDBC Driver)
        beyond the principle of Parental delegation model
            
    classloader+class-> unique            
    
    ##Stack Frame (abstract concept)
    local variable table + operation stack + dynamic link + return address
    include main memory address, cpu cache, cpu register
    
    ##call method
    Parse (we know what is it during compiling)
        constructor
        private method
        static method
        
    static dispatch (we know what is it during compiling)
        method overload
    
    dynamic dispatch -- implements by method table, maintained by JVM, maintain the real address of the method in the method area
        method override
        virtual method table during compiling
    
    register-based execution engine (tightly with hardware)       
    stack-based bytecode execution engine (Java use this, portable)

    ##how to Write efficient Java code?
    OOD:      
    a. What about too many constructor parameters
    b. Classes that do not need to be instantiated should be constructor private
    c. Don't create unnecessary objects
    d. Avoid using finalization methods
    e. Minimize the accessibility of classes and members
    f. Minimizing variability
    g. composite has higher priority than inheritance
    h. Interfaces have higher priority than abstract classes
    
    Method:
    i. use variable arguments carefully          
    j. return the empty array or list, not null
    k. use the standard exception first
        IllegalArgumentException       
        IllegalStateException 
        NullPointerException
        UnSupportedOperationException
    
    General Program Design:
    l. use enums instead of int constants
    m. minimize the scope of local variable
    n. don't use float or double for exact calculation
    o. pay attention to the performance of string
    p. the lines of a method no more than two screens
    
    ## system performance optimization
    1. average response time
        open a website x s
        query from db 1x ms
        Mechanical hard disk addressing  x ms
        SSD hard disk addressing 0.x ms
        read from redis 0.x ms
        read 1M data from memory 1x us
        Java call local method x us
        transfer 2K data in network 1 us 
    
    2. Concurrency
        50%-150% * active user
    
    3. throughput
    
    4. avoid  optimization too early
        system performance test, find the bottleneck, then optimization, step by step
    
    Front-end optimization
        reduce the number of request
            combine static files
            keep-alive
        
        use client-cache
            Cache-Control relate time difference
            Expires based on the timestamp of server
            change name of file
            
        use compress
            
            
        load order of resources file
            set css file at the top of the page
            set js file at the bottom of the page
            
        reduce the transfer of cookie
            
        CDN Acceleration
        
        Reverse Proxy Cache
        
        web components separation
            images server
            css server
            js server
          
            
        
    Application optimization
        Cache
            read:write>2:1
            hot data
            80% requests fall on 20% of data
            data inconsistence toleration--Eventual consistency
            cache availability
            cache preloading
            cache breakdown: 1. bloom filter 2. cache non-existence data
            distributed cache and consistent hashing
                virtual node
                                    
        Asynchronous
            The synchronous and asynchronous focus on the communication mechanism of the result message
            The blocking and non-blocking focus on the what the state of caller when it waiting for the result 
            
            BIO synchronous blocking
            NIO synchronous non-blocking polling
            AIO asynchronous non-blocking
            
            Servlet 3.0 Synchronous
            Multithreading
            Message Queue
        Cluster
            
        Program              
            code level
                better data structure
                better algorithm
                less code
                
            concurrency programming
                concurrency container
                lock, cas
                
            reuse of resources
                single instances
                pool technology
            
            JVM                
                JIT
                type of compiler -server, -client, -XX:+TieredCompilation
                cache -XX:ReservedCodeCacheSize=N     
                    CodeCache is full
                    32M-48M jdk 1.7
                    240M >jdk 1.8
                
                compiling threshold
                    -XX:CounterHalfLifeTime
                
                compiling threads
                
                method inlining
                    -XX:+Inline
                    size of bytecode < 325B -XX:MaxFreqInlinesSize=N
                    size of method < 35B -XX:MaxInline=N
                                                                                
                Escape analysis
                
                GC Optimization
                    the last method
                    
                    monitor the state of GC
                        minorGC < 50 ms, freq 10s per time
                        fullGC < 1s, freq >10 minutes per time
                -XX:+PrintGCDetails
                -XX:+HeapDumpOnOutOfMemoryError
                -XX:HeapDumpPath
                -Xlogger:logpath
                -XX:PrintHeapAtGC
                -XX:TraceClassLoading
                
    Storage optimization
        SSD first
        separate db and separate table
        deal with resultset
        setFetchSize
        
        
    
    