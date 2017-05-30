package itmo;

/**
 * Created by ДНС on 12.05.2017.
 */
public class Barrier {
  int counter=3;

    public Barrier(int num) {
    }


    public void ready() throws InterruptedException {

        synchronized (this) {
             counter--;
            if (counter > 0) wait();
            else  notifyAll();
        }




}
}
