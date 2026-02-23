public class DoubleRoom implements RoomPriceable {
    @Override
    public Money getMonthlyFee() {
        return new Money(15000.0);
    }

    @Override
    public String getName() {
        return "DOUBLE";
    }
}
