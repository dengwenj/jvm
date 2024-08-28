## Java 虚拟机

### 什么是 JVM（Java Virtual Machine）
* jvm 本质上是一个运行在计算机上的程序，他的职责是运行 java 字节码文件

### jvm 的功能
* 1、解释和运行：对字节码文件中的指令，实时的解释成机器码，让计算机执行
* 2、内存管理：自动为对象、方法等分配内存。自动的垃圾回收机制，回收不再使用的对象
* 3、即时编译：对热点代码进行优化提升执行效率（把常用的代码放入内存中，再次使用就不用解释了，直接从内存中拿出使用机器码）
* java 需要实时解释，主要是为了支持跨平台特性
* jvm 提供了即时编译（just-in-time 简称 jit）进行性能的优化，最终能达到接近 c、c++ 语言的运行性能

### 常见的 JVM
* HotSpot（Oracle 默认的）、GraalVM、Dragonwell JDK、Eclipse OpenJ9
 * 可以自己实现 JVM，但是要遵循 java 虚拟机的规范