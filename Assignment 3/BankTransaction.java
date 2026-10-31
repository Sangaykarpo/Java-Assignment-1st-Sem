import java.util.concurrent.CountDownLatch;


public class BankTransaction extends Thread {
    private final long amount;
    private final CountDownLatch highValueProcessed;

    public BankTransaction(String name, long amount, int priority,
                           CountDownLatch highValueProcessed) {
        super(name);
        this.amount = amount;
        this.highValueProcessed = highValueProcessed;
        setPriority(priority);
    }

    @Override
    public void run() {
        boolean highValue = amount >= 50_000;

        // Ensure the low-value transaction waits until the high-value one finishes.
        if (!highValue) {
            try {
                highValueProcessed.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (highValue) {
            System.out.println("High-value transaction processed first: ₹" + amount);
            highValueProcessed.countDown();
        } else {
            System.out.println("Low-value transaction processed later: ₹" + amount);
        }
    }

    public static void main(String[] args) {
        CountDownLatch highValueProcessed = new CountDownLatch(1);

        BankTransaction lowValueTransaction = new BankTransaction(
                "LowValueTransaction", 5_000, Thread.MIN_PRIORITY, highValueProcessed);
        BankTransaction highValueTransaction = new BankTransaction(
                "HighValueTransaction", 50_000, Thread.MAX_PRIORITY, highValueProcessed);

        // Start low first to show that the latch, rather than start order, controls processing.
        lowValueTransaction.start();
        highValueTransaction.start();

        try {
            highValueTransaction.join();
            lowValueTransaction.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Transaction processing was interrupted.");
        }
    }
}
