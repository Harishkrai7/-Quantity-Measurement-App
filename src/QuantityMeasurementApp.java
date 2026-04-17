public class QuantityMeasurementApp {

    // -------- Enum for Units --------
    enum Unit {
        FEET(1.0),
        INCH(1.0 / 12.0);  // 1 inch = 1/12 feet

        private final double toFeetFactor;

        Unit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toBase(double value) {
            return value * toFeetFactor; // convert to feet
        }
    }

    // -------- Generic Quantity Class --------
    static class Quantity {
        private Double value;
        private Unit unit;

        public Quantity(Double value, Unit unit) {
            if (value == null) {
                throw new IllegalArgumentException("Value cannot be null");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        public boolean equals(Quantity other) {
            if (other == null) {
                return false;
            }

            // Convert both to base unit (feet)
            double thisValueInFeet = this.unit.toBase(this.value);
            double otherValueInFeet = other.unit.toBase(other.value);

            return Double.compare(thisValueInFeet, otherValueInFeet) == 0;
        }
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        // Same unit comparison (like UC1)
        Quantity q1 = new Quantity(5.0, Unit.FEET);
        Quantity q2 = new Quantity(5.0, Unit.FEET);

        // Different unit comparison (UC3 feature)
        Quantity q3 = new Quantity(1.0, Unit.FEET);
        Quantity q4 = new Quantity(12.0, Unit.INCH);

        System.out.println("Feet vs Feet: " + q1.equals(q2));     // true
        System.out.println("Feet vs Inches: " + q3.equals(q4));   // true
    }
}