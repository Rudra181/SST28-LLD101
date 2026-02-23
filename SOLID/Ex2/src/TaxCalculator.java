public interface TaxCalculator {
    double calculateTaxRate(String customerType);
    double calculateTax(double subtotal, String customerType);
}
