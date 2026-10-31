import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IoTSensorMonitoringSystem {
    private static final int STOP = Integer.MIN_VALUE;
    private static final int READINGS_PER_RUN = 10;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n=== IoTSensorMonitoringSystem ===");
                System.out.println("1. Start Simulation");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");

                String choice = input.nextLine().trim();
                switch (choice) {
                    case "1":
                        runSimulation();
                        break;
                    case "2":
                        running = false;
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Enter 1 or 2.");
                }
            }
        }
    }

    private static void runSimulation() {
        BlockingQueue<Integer> evenReadings = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> oddReadings = new LinkedBlockingQueue<>();
        SquareCalculator squareCalculator = new SquareCalculator(evenReadings);
        CubeCalculator cubeCalculator = new CubeCalculator(oddReadings);
        RandomNumberGenerator generator = new RandomNumberGenerator(evenReadings, oddReadings, READINGS_PER_RUN);

        squareCalculator.start();
        cubeCalculator.start();
        generator.start();
        try {
            generator.join();
            evenReadings.put(STOP);
            oddReadings.put(STOP);
            squareCalculator.join();
            cubeCalculator.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Simulation interrupted.");
        }
        System.out.println("Simulation stopped.");
    }

    private static class RandomNumberGenerator extends Thread {
        private final BlockingQueue<Integer> evenReadings;
        private final BlockingQueue<Integer> oddReadings;
        private final int readingsPerRun;

        RandomNumberGenerator(BlockingQueue<Integer> evenReadings,
                              BlockingQueue<Integer> oddReadings,
                              int readingsPerRun) {
            super("RandomNumberGenerator");
            this.evenReadings = evenReadings;
            this.oddReadings = oddReadings;
            this.readingsPerRun = readingsPerRun;
        }

        @Override
        public void run() {
            for (int count = 0; count < readingsPerRun; count++) {
                int reading = (int) (Math.random() * 100) + 1;
                System.out.println("Sensor reading: " + reading);
                try {
                    (reading % 2 == 0 ? evenReadings : oddReadings).put(reading);
                    if (count < readingsPerRun - 1) Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private static class SquareCalculator extends Thread {
        private final BlockingQueue<Integer> readings;

        SquareCalculator(BlockingQueue<Integer> readings) {
            super("SquareCalculator");
            this.readings = readings;
        }

        @Override
        public void run() {
            processReadings();
        }

        private void processReadings() {
            try {
                while (true) {
                    int number = readings.take();
                    if (number == STOP) break;
                    System.out.println("[SquareCalculator] " + number + "² = " + (long) number * number);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class CubeCalculator extends Thread {
        private final BlockingQueue<Integer> readings;

        CubeCalculator(BlockingQueue<Integer> readings) {
            super("CubeCalculator");
            this.readings = readings;
        }

        @Override
        public void run() {
            processReadings();
        }

        private void processReadings() {
            try {
                while (true) {
                    int number = readings.take();
                    if (number == STOP) break;
                    System.out.println("[CubeCalculator] " + number + "³ = " + (long) number * number * number);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
