public class LaundryAddOn implements AddOnPriceable {
    @Override
    public Money getFee() {
        return new Money(500.0);
    }
}
