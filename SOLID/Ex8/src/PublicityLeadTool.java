public class PublicityLeadTool implements ClubAdminTools, EventTools, MinutesTools {
    private final EventPlanner planner;
    private final MinutesBook book;

    public PublicityLeadTool(EventPlanner planner, MinutesBook book) {
        this.planner = planner;
        this.book = book;
    }

    @Override public void createEvent(String name, double budget) { planner.create(name, budget); }
    @Override public int getEventsCount() { return planner.count(); }
    @Override public void addMinutes(String text) { book.add(text); }
}
