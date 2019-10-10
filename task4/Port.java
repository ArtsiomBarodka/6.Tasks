package tasks.task4;

import java.util.concurrent.Semaphore;

public class Port {

    private int product = 0;
    private final int MAX_PRODUCTS = 20;
    private final boolean[] PIERS = new boolean[5];
    private final Semaphore SEMAPHORE = new Semaphore(5, true);

    public synchronized void get(int shipNumber) {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.printf("Корабль %d загрузил 1 товар\n",shipNumber);
        System.out.println("Товаров в порту: " + product);
        notify();
    }

    public synchronized void put(int shipNumber) {
        while (product>=MAX_PRODUCTS) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.printf("Корабль %d разгрузил 1 товар\n",shipNumber);
        System.out.println("Товаров в порту: " + product);
        notify();
    }

    public  Semaphore getSEMAPHORE() {
        return SEMAPHORE;
    }

    public boolean[] getPIERS() {
        return PIERS;
    }
}
