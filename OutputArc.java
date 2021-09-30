public class OutputArc extends Arc {
    public OutputArc(String name, Place place) {
        super(name, place);
    }

    // add token to output arc from the action of input arc
    public boolean trigger(Train token) {
        boolean flag = false;
        Place place = this.getPlace();
        if (place.getToken() == null) {
            flag = place.addToken(token);
        }

        return flag;
    }
}
