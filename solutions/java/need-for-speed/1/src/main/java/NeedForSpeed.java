public class NeedForSpeed {
    public final int speed;
    public final int batteryDrain;
    private int distance = 0;
    private int battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public void drive() {
        if (battery >= batteryDrain) {
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public int distanceDriven() {
        return distance;
    }

    public boolean batteryDrained() {
        return battery<batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;
    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxDrives = 100 / car.batteryDrain;
        int maxDistance = maxDrives * car.speed;
        return maxDistance >= distance;
    }
}