package Main;

public class QCMGMT_App{

    // Inner class for Feet measurement
     public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        // Override equals() method
        @Override
        public boolean equals(Object obj) {

            // Reflexive check
            if (this == obj) {
                return true;
            }

            // Null and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Type casting
            Feet other = (Feet) obj;

            // Floating point comparison
            return Double.compare(this.value, other.value) == 0;
        }

        // (Optional but recommended)
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        boolean result = f1.equals(f2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }
}