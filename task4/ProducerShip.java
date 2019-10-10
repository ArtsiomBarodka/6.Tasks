package tasks.task4;

public class ProducerShip implements Runnable {

    private Port port;
    private int shipNumber;

    public ProducerShip(Port port, int shipNumber) {
        this.port = port;
        this.shipNumber = shipNumber;
    }

    @Override
    public void run() {

        System.out.printf("Корабль №%d подъплыл к порту.\n", shipNumber);
        try {
            Thread.sleep(2000);
            port.getSEMAPHORE().acquire();
            int parkingNumber = -1;

            synchronized (port.getPIERS()){
                for (int i = 0; i < 5; i++)
                    if (!port.getPIERS()[i]) {
                        port.getPIERS()[i] = true;
                        parkingNumber = i;
                        System.out.printf("Корабль №%d остановился у причала %d.\n", shipNumber, i);
                        break;
                    }
            }

            for (int i = 1; i < 6; i++) {
                port.put(shipNumber);
                Thread.sleep(2000);
            }

            synchronized (port.getPIERS()) {
                port.getPIERS()[parkingNumber] = false;
            }

            port.getSEMAPHORE().release();
            System.out.printf("Корабль №%d покинул порт.\n", shipNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

