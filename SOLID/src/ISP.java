public class ISP {
    public interface flatShape {
        double area();
    }
    public interface bulkShape {
        double volume();
    }

    public class Circle implements flatShape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return 2 * 3.14 * radius;
        }
    }

    public class Cube implements  flatShape,bulkShape {
        private int edge;

        public Cube(int edge) {
            this.edge = edge;
        }

        @Override
        public double area() {
            return 6 * edge * edge;
        }

        @Override
        public double volume() {
            return edge * edge * edge;
        }
    }
}
