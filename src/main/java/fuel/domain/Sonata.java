package fuel.domain;

public class Sonata extends Car {

    private final String brand = "Sonata";

    public Sonata(int travelDistance) {
        super(travelDistance);
    }

    @Override
    double getDistancePerLiter() {
        return 10;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}