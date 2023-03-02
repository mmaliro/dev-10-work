public class Truck implements Vehicle {
    private static final int MAX_KM_PER_HOUR = 195;
    private int kilometersPerHour = 0;

    public int getKilometersPerHour() {
        return kilometersPerHour;
    }

    @Override
    public void accelerate() { // 2. matches the interface
        kilometersPerHour = Math.min(kilometersPerHour + 10, MAX_KM_PER_HOUR);
    }

    @Override
    public String getVelocityMessage() {
        return String.format("%s km/hr", kilometersPerHour);
    }

}
