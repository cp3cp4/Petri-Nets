public class OutputArc extends Arc {
    public OutputArc(String name, Place place) {
        super(name, place);
    }

    // add token to output arc from the action of input arc
    public void trigger(Train token) {
        Place place = this.getPlace();
        if (place.getTokens().size() == 0) {
            place.addToken(token);
        }
    }
}
