package my.learn.concurrenttest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 运行多次，打印的 sequence 值均不同，最大值均为 110
 **/
public class AtomicReferenceTest {

    private AtomicReference<Reference> atomicReference;

    public AtomicReferenceTest(Reference reference) {
        this.atomicReference = new AtomicReference<>(reference);
    }

    public void atomicIncr() {
        Reference oldObj;
        Reference newObj;

        long sequence;
        long timestamp;

        while (true) {
            oldObj = this.atomicReference.get();
            sequence = oldObj.getSequence();
            sequence++;
            timestamp = System.currentTimeMillis();
            newObj = new Reference(sequence, timestamp);
            if (this.atomicReference.compareAndSet(oldObj, newObj)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Reference reference = new Reference(10L, System.currentTimeMillis());
        AtomicReferenceTest test = new AtomicReferenceTest(reference);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test.atomicIncr();
                System.out.println(test.atomicReference.get().toString());
            }).start();
        }
    }

}
