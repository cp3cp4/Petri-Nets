public class Route {
    private int section;
    private Route next;

    public Route(int section) {
        this.section = section;
    }
    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public Route getNext() {
        return next;
    }

    public void setNext(Route next) {
        this.next = next;
    }
}
