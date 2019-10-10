package tasks.task4;

public class PortApp {

    public PortApp() {
    }

    public void play(){
        Port port = new Port();

        ProducerShip producerShip1 = new ProducerShip(port,11);
        ProducerShip producerShip2 = new ProducerShip(port,12);
        ProducerShip producerShip3 = new ProducerShip(port,13);
        ProducerShip producerShip4 = new ProducerShip(port,14);
        ProducerShip producerShip5 = new ProducerShip(port,15);
        ProducerShip producerShip6 = new ProducerShip(port,16);
        ProducerShip producerShip7 = new ProducerShip(port,17);
        ProducerShip producerShip8 = new ProducerShip(port,18);
        ProducerShip producerShip9 = new ProducerShip(port,19);

        ConsumerShip consumerShip1 = new ConsumerShip(port,21);
        ConsumerShip consumerShip2 = new ConsumerShip(port,22);
        ConsumerShip consumerShip3 = new ConsumerShip(port,23);
        ConsumerShip consumerShip4 = new ConsumerShip(port,24);
        ConsumerShip consumerShip5 = new ConsumerShip(port,25);
        ConsumerShip consumerShip6 = new ConsumerShip(port,26);
        ConsumerShip consumerShip7 = new ConsumerShip(port,27);
        ConsumerShip consumerShip8 = new ConsumerShip(port,28);
        ConsumerShip consumerShip9 = new ConsumerShip(port,29);

        new Thread(producerShip1).start();
        new Thread(consumerShip1).start();
        new Thread(producerShip2).start();
        new Thread(consumerShip2).start();
        new Thread(consumerShip3).start();
        new Thread(producerShip3).start();
        new Thread(producerShip4).start();
        new Thread(consumerShip4).start();
        new Thread(producerShip5).start();
        new Thread(consumerShip5).start();
        new Thread(producerShip6).start();
        new Thread(consumerShip6).start();
        new Thread(producerShip7).start();
        new Thread(consumerShip7).start();
        new Thread(producerShip8).start();
        new Thread(consumerShip8).start();
        new Thread(producerShip9).start();
        new Thread(consumerShip9).start();
    }


}
