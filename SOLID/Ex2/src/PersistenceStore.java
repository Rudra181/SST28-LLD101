public interface PersistenceStore {
    void save(String invoiceId, String content);
    int countLines(String invoiceId);
}
