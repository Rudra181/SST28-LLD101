import java.util.HashMap;
import java.util.Map;

public class AddOnFactory {
    private static final Map<AddOn, AddOnPriceable> addOnsByType = new HashMap<>();

    static {
        addOnsByType.put(AddOn.MESS, new MessAddOn());
        addOnsByType.put(AddOn.LAUNDRY, new LaundryAddOn());
        addOnsByType.put(AddOn.GYM, new GymAddOn());
    }

    public static AddOnPriceable getAddOnPrice(AddOn addOn) {
        return addOnsByType.getOrDefault(addOn, new MessAddOn());
    }
}
