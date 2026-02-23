public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        String body = n.body != null ? n.body : "";
        System.out.println("SMS -> to=" + n.phone + " body=" + body);
        audit.add("sms sent");
    }
}
