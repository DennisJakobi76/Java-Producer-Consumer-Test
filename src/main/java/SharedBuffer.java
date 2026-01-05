public class SharedBuffer {

    private int data;
    private boolean hasData = false;

    // producer method
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        System.out.println(Thread.currentThread().getName() + " produced: " + data);
        hasData = true;
        notify();
    }

    // consumer
    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumed: " + data);
        hasData = false;
        notify();
    }
}