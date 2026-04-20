public class QuantityMeasurementApp {

    // -------- Enum for Units --------
    enum Unit {
        FEET(1.0),
        INCH(1.0 / 12.0),          // 1 inch = 1/12 feet
        YARD(3.0),                 // 1 yard = 3 feet
        CM(0.393701 / 12.0);       // 1 cm = 0.393701 inch → convert to feet

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

            double thisValueInFeet = this.unit.toBase(this.value);
            double otherValueInFeet = other.unit.toBase(other.value);

            return Double.compare(thisValueInFeet, otherValueInFeet) == 0;
        }
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        // UC1 style (same unit)
        Quantity q1 = new Quantity(5.0, Unit.FEET);
        Quantity q2 = new Quantity(5.0, Unit.FEET);

        // UC3 style (feet vs inches)
        Quantity q3 = new Quantity(1.0, Unit.FEET);
        Quantity q4 = new Quantity(12.0, Unit.INCH);

        // UC4 new units
        Quantity q5 = new Quantity(1.0, Unit.YARD);   // 1 yard = 3 feet
        Quantity q6 = new Quantity(3.0, Unit.FEET);

        Quantity q7 = new Quantity(2.54, Unit.CM);    // 2.54 cm = 1 inch
        Quantity q8 = new Quantity(1.0, Unit.INCH);

        System.out.println("Feet vs Feet: " + q1.equals(q2));       // true
        System.out.println("Feet vs Inches: " + q3.equals(q4));     // true
        System.out.println("Yard vs Feet: " + q5.equals(q6));       // true
        System.out.println("CM vs Inches: " + q7.equals(q8));       // true
    }
}