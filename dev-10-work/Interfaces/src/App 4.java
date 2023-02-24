public class App {

    public static void main(String[] args) {
        Vehicle truck = new Truck();
        Vehicle spaceship = new Spaceship();

        for (int i = 0; i < 7; i++) {
            truck.accelerate();
            spaceship.accelerate();
        }

        System.out.println("truck: " + truck.getVelocityMessage());
        System.out.println("spaceship: " + spaceship.getVelocityMessage());
    }


}

