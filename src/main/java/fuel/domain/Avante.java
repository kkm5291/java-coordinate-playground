package fuel.domain;

public class Avante extends Car{

    private final String brand = "Avante";

    public Avante(int travelDistance) {
        super(travelDistance);
    }

    @Override
    double getDistancePerLiter() {
        return 15;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
