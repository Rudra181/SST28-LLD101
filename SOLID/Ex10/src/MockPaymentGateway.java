public class MockPaymentGateway implements PaymentProcessor {
    private String mockTxn;

    public MockPaymentGateway(String mockTxn) {
        this.mockTxn = mockTxn;
    }

    public String charge(String studentId, double amount) {
        return mockTxn;
    }
}
