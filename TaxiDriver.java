import java.util.*;
import java.util.concurrent.*;

interface Taxi {
    void placeOrder(String address);

    void endMessage();
}

class TaxiDriver implements Taxi, Runnable {
    Thread thread;
    int id;
    BlockingQueue<String> addresses = new LinkedBlockingQueue<>();
    volatile boolean running;

    TaxiDriver(int number) {
        id = number;
        running = true;
        thread = new Thread(this, "Taxi " + number);
        thread.start();
    }

    public void run() {
        while (running) {
            try {
                String address = addresses.poll(100, TimeUnit.MILLISECONDS);

                if (address != null) {

                    System.out.println("Taxi " + id + ": fulfilling order to " + address);
                    Random random = new Random();
                    int randomNumber = random.nextInt(20) + 1;
                    Thread.sleep(randomNumber * 100);
                    System.out.println("Order to " + address + " is done");

                } else {
                    running = false;
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Taxi " + id + ": shutting down");
    }

    public void placeOrder(String address) {
        addresses.offer(address);
    }


    public void endMessage() {
        while (running) ;
        this.shutdown();
    }

    public void shutdown() {
        try {
            thread.join(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            thread.interrupt();
        }
    }
}