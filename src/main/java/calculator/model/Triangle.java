package calculator.model;

import java.util.List;

public class Triangle extends AbstractFigure {

    private static final String ERROR_NOT_TRIANGLE_POINTS = "삼각형을 만들 수 없는 좌표입니다.";

    /**
     * 추상 클래스에서 생성자는 protected 가 주로 쓰여진다.
     * public 으로 설정할 경우 인스턴스를 만들 수 있다는 표현 같으니!
     *
     * @param points
     */
    protected Triangle(List<Point> points) {
        super(points);
    }

    /**
     * 헤론 공식
     * 1. 각 선분의 길이를 먼저 구함
     */
    @Override
    public double getArea() {
        List<Point> points = getPoints();

        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        double sideA = pointA.calculateDistanceTo(pointB);
        double sideB = pointB.calculateDistanceTo(pointC);
        double sideC = pointC.calculateDistanceTo(pointA);

        double semiPerimeter = (sideA + sideB + sideC) / 2;

        double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));

        return (int) Math.ceil(area);
    }
}
