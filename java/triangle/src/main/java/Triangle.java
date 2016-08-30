import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Triangle {

  private TriangleKind type;

  public Triangle(double x, double y, double z) throws TriangleException {
    validate(sorted(x, y, z));
    this.type = determineType(unique(x, y, z));
  }

  public TriangleKind getKind() {
    return this.type;
  }

  private void validate(List<Double> sides) throws TriangleException {
    if (sides.get(0) <= 0) {
      throw new TriangleException();
    }

    if ((sides.get(0) + sides.get(1)) <= sides.get(2)) {
      throw new TriangleException();
    }
  }

  private TriangleKind determineType(Set<Double> sides) {
    if (sides.size() == 1) {
      return TriangleKind.EQUILATERAL;
    } else if (sides.size() == 2) {
      return TriangleKind.ISOSCELES;
    } else if (sides.size() == 3) {
      return TriangleKind.SCALENE;
    }

    throw new IllegalArgumentException("Expected 1-3 sides");
  }

  private List<Double> sorted(double x, double y, double z) {
    List<Double> sides = Arrays.asList(x, y, z);
    Collections.sort(sides);
    return sides;
  }

  private Set<Double> unique(double x, double y, double z) {
    return new TreeSet<>(Arrays.asList(x, y, z));
  }

} 
