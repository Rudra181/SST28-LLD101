public class OrderLine {
    public final String itemId;
    public final int qty;
    public String description;

    public OrderLine(String itemId, int qty) {
        this.itemId = itemId;
        this.qty = qty;
    }
}

