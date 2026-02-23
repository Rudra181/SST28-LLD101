public class SingleRoom implements RoomPriceable {
    @Override
    public Money getMonthlyFee() {
        return new Money(14000.0);
    }

    @Override
    public String getName() {
        return "SINGLE";
    }
}
