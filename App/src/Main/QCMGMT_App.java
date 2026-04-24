package Main;

public class QCMGMT_App {

    private static final double EPSILON = 1e-6;

    // ---------- FEET ----------
    public static class Feet {
        private final double value;

        public Feet(double value) {
            validate(value);
            this.value = value;
        }

        public double toInches() {
            return value * 12.0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;

            double otherValue;

            if (obj instanceof Feet)
                otherValue = ((Feet) obj).toInches();
            else if (obj instanceof Inches)
                otherValue = ((Inches) obj).toInches();
            else if (obj instanceof Yards)
                otherValue = ((Yards) obj).toInches();
            else if (obj instanceof Centimeters)
                otherValue = ((Centimeters) obj).toInches();
            else
                return false;

            return Math.abs(this.toInches() - otherValue) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toInches());
        }
    }

    // ---------- INCHES ----------
    public static class Inches {
        private final double value;

        public Inches(double value) {
            validate(value);
            this.value = value;
        }

        public double toInches() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;

            double otherValue;

            if (obj instanceof Feet)
                otherValue = ((Feet) obj).toInches();
            else if (obj instanceof Inches)
                otherValue = ((Inches) obj).toInches();
            else if (obj instanceof Yards)
                otherValue = ((Yards) obj).toInches();
            else if (obj instanceof Centimeters)
                otherValue = ((Centimeters) obj).toInches();
            else
                return false;

            return Math.abs(this.toInches() - otherValue) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toInches());
        }
    }

    // ---------- YARDS ----------
    public static class Yards {
        private final double value;

        public Yards(double value) {
            validate(value);
            this.value = value;
        }

        public double toInches() {
            return value * 36.0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;

            double otherValue;

            if (obj instanceof Feet)
                otherValue = ((Feet) obj).toInches();
            else if (obj instanceof Inches)
                otherValue = ((Inches) obj).toInches();
            else if (obj instanceof Yards)
                otherValue = ((Yards) obj).toInches();
            else if (obj instanceof Centimeters)
                otherValue = ((Centimeters) obj).toInches();
            else
                return false;

            return Math.abs(this.toInches() - otherValue) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toInches());
        }
    }

    // ---------- CENTIMETERS ----------
    public static class Centimeters {
        private final double value;

        public Centimeters(double value) {
            validate(value);
            this.value = value;
        }

        public double toInches() {
            return value * 0.393701;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;

            double otherValue;

            if (obj instanceof Feet)
                otherValue = ((Feet) obj).toInches();
            else if (obj instanceof Inches)
                otherValue = ((Inches) obj).toInches();
            else if (obj instanceof Yards)
                otherValue = ((Yards) obj).toInches();
            else if (obj instanceof Centimeters)
                otherValue = ((Centimeters) obj).toInches();
            else
                return false;

            return Math.abs(this.toInches() - otherValue) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toInches());
        }
    }

    // ---------- VALIDATION ----------
    private static void validate(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }
    }

    // ---------- CONVERSION UTILITY ----------
    public static double convertToInches(Object obj) {
        if (obj instanceof Feet) return ((Feet) obj).toInches();
        if (obj instanceof Inches) return ((Inches) obj).toInches();
        if (obj instanceof Yards) return ((Yards) obj).toInches();
        if (obj instanceof Centimeters) return ((Centimeters) obj).toInches();
        throw new IllegalArgumentException("Unsupported type");
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        Feet f = new Feet(1);
        Inches i = new Inches(12);
        Yards y = new Yards(1);
        Centimeters cm = new Centimeters(1);

        System.out.println("Feet == Inches: " + f.equals(i));   // true
        System.out.println("Yard == Feet: " + y.equals(new Feet(3))); // true
        System.out.println("CM == Inch: " + cm.equals(new Inches(0.393701))); // true
    }
}