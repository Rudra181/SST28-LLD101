import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    public void process(BookingRequest req) {
        RoomPriceable room = RoomFactory.getRoomByType(req.roomType);
        Money monthly = calculateMonthlyFee(room, req.addOns);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, room, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthlyFee(RoomPriceable room, List<AddOn> addOns) {
        Money total = room.getMonthlyFee();
        for (AddOn addOn : addOns) {
            AddOnPriceable addOnPrice = AddOnFactory.getAddOnPrice(addOn);
            total = total.plus(addOnPrice.getFee());
        }
        return total;
    }
}
