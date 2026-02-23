public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        String phone = n.phone != null ? n.phone : "";
        if (phone.isEmpty() || !phone.startsWith("+")) {
            throw new IllegalArgumentException("phone must start with + and country code");
        }
        String body = n.body != null ? n.body : "";
        System.out.println("WA -> to=" + phone + " body=" + body);
        audit.add("wa sent");
    }
}

