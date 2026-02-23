public class MessAddOn implements AddOnPriceable {
    @Override
    public Money getFee() {
        return new Money(1000.0);
    }
}
