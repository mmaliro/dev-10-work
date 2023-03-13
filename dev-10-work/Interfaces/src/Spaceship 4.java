public class Spaceship implements Vehicle {

    private double percentOfLightSpeed = 0.0;

    @Override
    public void accelerate() {
        // Gets harder to approach the speed of light as we accelerate.
        percentOfLightSpeed += (0.1 * (1.0 - percentOfLightSpeed));
    }

    @Override
    public String getVelocityMessage() {
        return String.format("Traveling at %.2f%% the speed of light.", percentOfLightSpeed * 100.0);
    }
}
