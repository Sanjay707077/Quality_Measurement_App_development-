package Main;

public class QCMGMT_App {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double toFeet() {
            return value; // already in feet
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            // Compare with Feet
            if (obj instanceof Feet) {
                Feet other = (Feet) obj;
                return Double.compare(this.toFeet(), other.toFeet()) == 0;
            }

            // Compare with Inches
            if (obj instanceof Inches) {
                Inches other = (Inches) obj;
                return Double.compare(this.toFeet(), other.toFeet()) == 0;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double toFeet() {
            return value / 12.0; // convert inches to feet
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            // Compare with Inches
            if (obj instanceof Inches) {
                Inches other = (Inches) obj;
                return Double.compare(this.toFeet(), other.toFeet()) == 0;
            }

            // Compare with Feet
            if (obj instanceof Feet) {
                Feet other = (Feet) obj;
                return Double.compare(this.toFeet(), other.toFeet()) == 0;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Same unit comparison
    public static boolean compareFeet(double a, double b) {
        return new Feet(a).equals(new Feet(b));
    }

    public static boolean compareInches(double a, double b) {
        return new Inches(a).equals(new Inches(b));
    }

    // Cross unit comparison
    public static boolean compareFeetAndInches(double feet, double inches) {
        return new Feet(feet).equals(new Inches(inches));
    }

    public static void main(String[] args) {

        System.out.println("Feet Equal: " +
                compareFeet(1.0, 1.0));

        System.out.println("Inches Equal: " +
                compareInches(12.0, 12.0));

        System.out.println("Feet vs Inches Equal: " +
                compareFeetAndInches(1.0, 12.0)); // true
    }
}