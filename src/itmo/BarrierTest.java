package itmo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ДНС on 12.05.2017.
 */
public class BarrierTest {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Barrier barrier = new Barrier(3);

        for (int i = 1; i <= 3; i++) {
            threads.add(new TestThread(i * 1000, barrier));
        }


        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static class TestThread extends Thread {
        private final long millis;
        private final Barrier barrier;

        private TestThread(long millis, Barrier barrier) {
            this.millis = millis;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            try {

                sleep(millis);

                System.out.println("Ready");



                barrier.ready();



                System.out.println(getName() + " is  released == reason: monitor state: " +
                        +
                        barrier.counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
