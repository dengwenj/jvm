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

### JVM 的组成
* 1、类加载器 ClassLoader：加载 class 字节码文件中的内容到 jvm 内存中
* 2、运行时数据区域（jvm 管理的内存）：负责管理 jvm 使用到的内存，比如创建对象和销毁对象
* 3、执行引擎（即时编译器、解释器、垃圾回收器等）：将字节码文件中的指令解释成机器码，同时使用即时编译器优化性能
* 4、本地接口：调用本地已经编译的方法，比如虚拟机中提供的 c/c++ 的方法

### 字节码文件的组成
* 1、基础信息：魔数、字节码文件对应的 java 版本号，访问标识（public final 等），父类和接口 
* 2、常量池：保存了字符串常量、类或接口名、字段名主要在字节码指令中使用
* 3、字段：当前类或接口声明的字段信息
* 4、方法：当前类或接口声明的方法信息字节码指令
* 5、属性：类的属性，比如源码的文件名内部类的列表等
* 字节码指令越多性能越低

### Magic 魔数
* 文件是无法通过文件扩展名来确定文件类型的，文件扩展名可以随意修改，不影响文件的内容
* 软件使用文件的头几个字节（文件头）去校验文件的类型，如果软件不支持该种类型就会出错

### 主副版本号
* 版本号的作用主要是判断当前字节码的版本和运行时的 JDK 是否兼容

### 常量池
* 字节码文件中常量池的作用：避免相同的内容重复定义，节省空间
* 常量池中的数据都有一个编号，编号从1开始。在字段或者字节码指令中通过编号可以快速的找到对应的数据
* 字节码指令中通过编号引用到常量池的过程称之为符号引用

### 方法
* 字节码中的方法区域是存放字节码指令的核心位置，字节码指令的内容存放在方法的 Code 属性中
* 操作数栈是临时存放数据的地方，局部变量表是存放方法中的局部变量的位置（数组的形式）
* iconst_0 是将常数 0 放入操作数栈
* istore_1 从操作数栈取出放入局部变量表1号位置
* iload_1 将局部变量表1中的数据放入操作数栈
* iinc 1 by 1 将局部变量表1中的数据加1

### 字节码常用工具：javap -v 命令
* javap 是 jdk 自带的反编译工具，可以通过控制台查看字节码文件的内容。适合在服务器上查看字节码文件内容
* 直接输入 javap 查看所有参数
* 输入 javap -v 字节码文件名称 查看具体的字节码信息（如果 jar 包需要先使用 jar -xvf 命令解压）

### arthas
* Arthas 是一款线上监控诊断产品，通过全局视角实时查看应用 load，内存、gc、线程的状态信息，并能在不修该应用代码的情况下，对业务问题进行诊断，大大提升线上问题排查效率