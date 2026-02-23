public class TripleRoom implements RoomPriceable {
    @Override
    public Money getMonthlyFee() {
        return new Money(12000.0);
    }

    @Override
    public String getName() {
        return "TRIPLE";
    }
}
