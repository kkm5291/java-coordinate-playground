package fuel.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static List<Car> garage;

    private RentCompany() {
        this.garage = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        garage.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : garage) {
            sb.append(car.getBrand())
                    .append(" : ")
                    .append(car.getFuelTotal())
                    .append("리터")
                    .append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
