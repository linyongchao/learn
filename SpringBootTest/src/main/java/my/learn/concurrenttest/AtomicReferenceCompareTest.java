package my.learn.concurrenttest;

/**
 * 运行多次，打印的 sequence 值有可能相同，最大值有可能不为 110
 **/
public class AtomicReferenceCompareTest {

    public static void main(String[] args) {
        Reference reference = new Reference(10L, System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                long sequence = reference.getSequence();
                sequence++;
                reference.setSequence(sequence);
                reference.setTimestamp(System.currentTimeMillis());
                System.out.println(reference.toString());
            }).start();
        }
    }

}
