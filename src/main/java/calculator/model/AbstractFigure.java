package calculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure {
    static final String ERROR_DUPLICATE_POINTS_FOUND = "좌표에 중복값이 존재합니다.";
    private final List<Point> points;

    /**
     * 추상 클래스에서 생성자는 protected 가 주로 쓰여진다.
     * public 으로 설정할 경우 인스턴스를 만들 수 있다는 표현 같으니!
     */
    protected AbstractFigure(List<Point> points) {
        validateDuplicate(points);
        this.points = points;
    }

    /**
     * 면적 또는 길이 구하기
     */
    public abstract double getArea();

    public void validateDuplicate(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS_FOUND);
        }
    }

    public abstract boolean hasPoint(int x, int y);

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(getPoints(), that.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPoints());
    }
}
