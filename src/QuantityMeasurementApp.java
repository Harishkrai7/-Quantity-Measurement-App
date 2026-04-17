public class QuantityMeasurementApp {

    // Method to compare two values in feet
    public boolean areEqualInFeet(Double value1, Double value2) {

        // Validate inputs
        if (value1 == null || value2 == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }

        // Compare values
        return value1.equals(value2);
    }

    public static void main(String[] args) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        // Sample inputs
        Double value1 = 10.0;
        Double value2 = 10.0;

        // Call method
        boolean result = app.areEqualInFeet(value1, value2);

        // Output
        if (result) {
            System.out.println("Both values are equal in feet.");
        } else {
            System.out.println("Values are NOT equal in feet.");
        }
    }
}