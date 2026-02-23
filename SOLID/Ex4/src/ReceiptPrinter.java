
public class ReceiptPrinter {
    public static void print(BookingRequest req, RoomPriceable room, Money monthly, Money deposit) {
        System.out.println("Room: " + room.getName() + " | AddOns: " + req.addOns);
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
