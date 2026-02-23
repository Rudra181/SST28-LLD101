import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxCalculator taxCalculator;
    private final DiscountCalculator discountCalculator;
    private final PersistenceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxCalculator taxCalculator, DiscountCalculator discountCalculator, PersistenceStore store) {
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.store = store;
    }

    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public void checkout(String customerType, List<OrderLine> orderLines) {
        String invoiceId = "INV-" + (++invoiceSeq);

        double subtotal = calculateSubtotal(orderLines);
        double taxRate = taxCalculator.calculateTaxRate(customerType);
        double tax = taxCalculator.calculateTax(subtotal, customerType);
        double discount = discountCalculator.calculateDiscount(customerType, subtotal, orderLines.size());
        double total = subtotal + tax - discount;

        String invoice = buildInvoiceText(invoiceId, orderLines, subtotal, taxRate, tax, discount, total);
        System.out.print(invoice);

        store.save(invoiceId, invoice);
        System.out.println("Saved invoice: " + invoiceId + " (lines=" + store.countLines(invoiceId) + ")");
    }

    private double calculateSubtotal(List<OrderLine> orderLines) {
        double subtotal = 0.0;
        for (OrderLine line : orderLines) {
            MenuItem item = menu.get(line.itemId);
            double lineTotal = item.price * line.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }

    private String buildInvoiceText(String invoiceId, List<OrderLine> orderLines, 
                                     double subtotal, double taxRate, double tax, double discount, double total) {
        StringBuilder invoice = new StringBuilder();
        invoice.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine line : orderLines) {
            MenuItem item = menu.get(line.itemId);
            double lineTotal = item.price * line.qty;
            invoice.append(String.format("- %s x%d = %.2f\n", item.name, line.qty, lineTotal));
        }

        invoice.append(String.format("Subtotal: %.2f\n", subtotal));
        invoice.append(String.format("Tax(%.0f%%): %.2f\n", taxRate, tax));
        invoice.append(String.format("Discount: -%.2f\n", discount));
        invoice.append(String.format("TOTAL: %.2f\n", total));

        return invoice.toString();
    }
}
