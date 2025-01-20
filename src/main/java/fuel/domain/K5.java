package fuel.domain;

public class K5 extends Car {

    private final String brand = "K5";

    public K5(int travelDistance) {
        super(travelDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return 13;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
