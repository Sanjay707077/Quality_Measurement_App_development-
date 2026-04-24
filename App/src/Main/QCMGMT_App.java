package Main;

public class QCMGMT_App {

    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        INCH(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            validate(value, unit);
            this.value = value;
            this.unit = unit;
        }

        private static void validate(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Invalid unit");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid number");
        }

        private double toBaseUnit() {
            return value * unit.getFactor(); // inches
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        // ---------- CONVERSION ----------
        public static double convert(double value, LengthUnit from, LengthUnit to) {
            validate(value, from);

            if (to == null)
                throw new IllegalArgumentException("Invalid target unit");

            return value * from.getFactor() / to.getFactor();
        }

        public QuantityLength convertTo(LengthUnit target) {
            return new QuantityLength(
                    convert(value, unit, target),
                    target
            );
        }

        // ---------- ADDITION (UC7 FEATURE) ----------
        public QuantityLength add(QuantityLength other) {
            return add(this, other, this.unit);
        }

        public static QuantityLength add(
                QuantityLength a,
                QuantityLength b,
                LengthUnit targetUnit) {

            if (a == null || b == null)
                throw new IllegalArgumentException("Null operand");

            if (targetUnit == null)
                throw new IllegalArgumentException("Null target unit");

            double totalBase = a.toBaseUnit() + b.toBaseUnit();

            double result = totalBase / targetUnit.getFactor();

            return new QuantityLength(result, targetUnit);
        }

        public static QuantityLength add(
                double v1, LengthUnit u1,
                double v2, LengthUnit u2,
                LengthUnit target) {

            return add(
                    new QuantityLength(v1, u1),
                    new QuantityLength(v2, u2),
                    target
            );
        }

        // ---------- EQUALITY ----------
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toBaseUnit());
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        var a = new QuantityLength(1, LengthUnit.FEET);
        var b = new QuantityLength(12, LengthUnit.INCH);

        System.out.println(
                QuantityLength.add(a, b, LengthUnit.FEET)
        ); // 2 FEET

        System.out.println(
                QuantityLength.add(a, b, LengthUnit.INCH)
        ); // 24 INCH

        System.out.println(
                QuantityLength.add(a, b, LengthUnit.YARDS)
        ); // 0.666... YARDS
    }
}