package fuel.domain;

public abstract class Car {

    protected int traveledDistance;

    private Car() {}

    public Car(int travelDistance) {
        this.traveledDistance = travelDistance;
    }

    /**
     * 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 차종 이름
     */
    public abstract String getBrand();

    /**
     * 주입해야 할 연료
     */
    int getFuelTotal() {
        return (int) (traveledDistance / getDistancePerLiter());
    }
}
