public class MainTest {

    public static void main(String[] args) {

        /*
        // Producer Consumer Example without Locks
        SharedBuffer sharedBuffer = new SharedBuffer();

        // producer thread
        Thread producerThread = new Thread(() -> {

            for (int i = 0; i < 5; i++){

                try {
                    sharedBuffer.produce(i);
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }, "Producer Thread");

        // consumer thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++){

                try {
                    sharedBuffer.consume();
                    Thread.sleep(800L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }, "Consumer Thread");

        producerThread.start();
        consumerThread.start();
        */
        // Producer Consumer Example with Locks
        SharedBufferWithLock sharedBufferWithLock = new SharedBufferWithLock();
        // producer thread
        Thread producerThreadWithLock = new Thread(() -> {
            for (int i = 0; i < 5; i++){

                sharedBufferWithLock.produce(i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread With Lock");
        // consumer thread
        Thread consumerThreadWithLock = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBufferWithLock.consume();
                try {
                    Thread.sleep(800L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer Thread With Lock");

        producerThreadWithLock.start();
        consumerThreadWithLock.start();
    }
}
