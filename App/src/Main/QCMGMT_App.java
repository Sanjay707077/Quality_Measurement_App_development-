package Main;

public class QCMGMT_App {

    // ---------- FEET ----------
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double toInches() {
            return value * 12.0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof Feet)
                return Double.compare(this.toInches(), ((Feet) obj).toInches()) == 0;

            if (obj instanceof Inches)
                return Double.compare(this.toInches(), ((Inches) obj).toInches()) == 0;

            if (obj instanceof Yards)
                return Double.compare(this.toInches(), ((Yards) obj).toInches()) == 0;

            if (obj instanceof Centimeters)
                return Double.compare(this.toInches(), ((Centimeters) obj).toInches()) == 0;

            return false;
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
            this.value = value;
        }

        public double toInches() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof Feet)
                return Double.compare(this.toInches(), ((Feet) obj).toInches()) == 0;

            if (obj instanceof Inches)
                return Double.compare(this.toInches(), ((Inches) obj).toInches()) == 0;

            if (obj instanceof Yards)
                return Double.compare(this.toInches(), ((Yards) obj).toInches()) == 0;

            if (obj instanceof Centimeters)
                return Double.compare(this.toInches(), ((Centimeters) obj).toInches()) == 0;

            return false;
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
            this.value = value;
        }

        public double toInches() {
            return value * 36.0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof Feet)
                return Double.compare(this.toInches(), ((Feet) obj).toInches()) == 0;

            if (obj instanceof Inches)
                return Double.compare(this.toInches(), ((Inches) obj).toInches()) == 0;

            if (obj instanceof Yards)
                return Double.compare(this.toInches(), ((Yards) obj).toInches()) == 0;

            if (obj instanceof Centimeters)
                return Double.compare(this.toInches(), ((Centimeters) obj).toInches()) == 0;

            return false;
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
            this.value = value;
        }

        public double toInches() {
            return value * 0.393701;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof Feet)
                return Double.compare(this.toInches(), ((Feet) obj).toInches()) == 0;

            if (obj instanceof Inches)
                return Double.compare(this.toInches(), ((Inches) obj).toInches()) == 0;

            if (obj instanceof Yards)
                return Double.compare(this.toInches(), ((Yards) obj).toInches()) == 0;

            if (obj instanceof Centimeters)
                return Double.compare(this.toInches(), ((Centimeters) obj).toInches()) == 0;

            return false;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toInches());
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        Yards yard = new Yards(1);
        Feet feet = new Feet(3);
        Centimeters cm = new Centimeters(1);
        Inches inch = new Inches(0.393701);

        System.out.println("Yard == Feet: " + yard.equals(feet)); // true
        System.out.println("CM == Inch: " + cm.equals(inch));     // true
    }
}