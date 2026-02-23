import java.util.List;

public class InvoiceBuilder {
    private String invoiceId;
    private List<OrderLine> lines;
    private double subtotal;
    private double taxRate;
    private double tax;
    private double discount;
    private double total;

    public InvoiceBuilder withId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    public InvoiceBuilder withLines(List<OrderLine> lines) {
        this.lines = lines;
        return this;
    }

    public InvoiceBuilder withSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public InvoiceBuilder withTax(double taxRate, double tax) {
        this.taxRate = taxRate;
        this.tax = tax;
        return this;
    }

    public InvoiceBuilder withDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public InvoiceBuilder withTotal(double total) {
        this.total = total;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine line : lines) {
            sb.append(line.description).append("\n");
        }

        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", taxRate, tax));
        sb.append(String.format("Discount: -%.2f\n", discount));
        sb.append(String.format("TOTAL: %.2f\n", total));

        return sb.toString();
    }
}
