public class MainTest {

    public static void main(String[] args) {

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
    }
}
