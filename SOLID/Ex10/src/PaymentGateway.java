public class PaymentGateway implements PaymentProcessor {
    public String charge(String studentId, double amount) {
        return "TXN-9001";
    }
}
