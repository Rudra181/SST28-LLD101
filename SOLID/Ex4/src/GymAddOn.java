public class GymAddOn implements AddOnPriceable {
    @Override
    public Money getFee() {
        return new Money(300.0);
    }
}
