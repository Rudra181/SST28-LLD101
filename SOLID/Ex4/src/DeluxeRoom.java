public class DeluxeRoom implements RoomPriceable {
    @Override
    public Money getMonthlyFee() {
        return new Money(16000.0);
    }

    @Override
    public String getName() {
        return "DELUXE";
    }
}
