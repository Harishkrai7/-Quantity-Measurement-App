public class QuantityMeasurementApp {

    // -------- Feet Class --------
    static class Feet {
        private Double value;

        public Feet(Double value) {
            if (value == null) {
                throw new IllegalArgumentException("Feet value cannot be null");
            }
            this.value = value;
        }

        public boolean equals(Feet other) {
            if (other == null) {
                return false;
            }
            return this.value.equals(other.value);
        }
    }

    // -------- Inches Class --------
    static class Inches {
        private Double value;

        public Inches(Double value) {
            if (value == null) {
                throw new IllegalArgumentException("Inches value cannot be null");
            }
            this.value = value;
        }

        public boolean equals(Inches other) {
            if (other == null) {
                return false;
            }
            return this.value.equals(other.value);
        }
    }

    // -------- Static Methods --------

    public static boolean compareFeet(Double value1, Double value2) {
        Feet f1 = new Feet(value1);
        Feet f2 = new Feet(value2);
        return f1.equals(f2);
    }

    public static boolean compareInches(Double value1, Double value2) {
        Inches i1 = new Inches(value1);
        Inches i2 = new Inches(value2);
        return i1.equals(i2);
    }

    // -------- Main Method --------

    public static void main(String[] args) {

        // Hard-coded values (as per UC2)
        Double feetValue1 = 5.0;
        Double feetValue2 = 5.0;

        Double inchValue1 = 10.0;
        Double inchValue2 = 12.0;

        // Feet comparison
        boolean feetResult = compareFeet(feetValue1, feetValue2);
        System.out.println("Feet equality: " + feetResult);

        // Inches comparison
        boolean inchResult = compareInches(inchValue1, inchValue2);
        System.out.println("Inches equality: " + inchResult);
    }
}