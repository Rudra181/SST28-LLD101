public class StandardTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTaxRate(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType)) return 2.0;
        return 8.0;
    }

    @Override
    public double calculateTax(double subtotal, String customerType) {
        double taxRate = calculateTaxRate(customerType);
        return subtotal * (taxRate / 100.0);
    }
}
