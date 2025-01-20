package fuel.domain;

public abstract class Car implements VehicleInterface {

    protected int traveledDistance;

    private Car() {}

    public Car(int travelDistance) {
        this.traveledDistance = travelDistance;
    }

    /**
     * 주입해야 할 연료
     */
    int getFuelTotal() {
        return (int) (traveledDistance / getDistancePerLiter());
    }
}
