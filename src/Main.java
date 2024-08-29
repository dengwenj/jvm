public class Main {
    private static final String a1 = "hhh";
    private static final String a2 = "hhh";
    private static final String hhh = "123";

    public static void main(String[] args) {
        int i = 0, j = 0, k = 0;
        i++;
        j = j + 1;
        k += 1;
        // 字节码指令越多，性能越低
        // 结论：
        // 字节码指令如下：
        // iconst_0
        // istore_1
        // iconst_0
        // istore_2
        // iconst_0
        // istore_3
        // iinc 1 by 1
        // iload_2
        // iconst_1
        // iadd
        // istore_2
        // iinc 3 by 1
        // return
    }

    public void test() {
        System.out.println("test!");
    }
}