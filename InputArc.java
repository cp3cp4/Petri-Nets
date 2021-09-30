public class InputArc extends Arc {
    public InputArc(String name, Place place) {
        super(name, place);
    }

    // enable the transition,
    // return Train
    public Train trigger() {
        Train token = null;
        Place place = this.getPlace();
        if (place.getToken() != null) {
            token = this.getPlace().getToken();
            this.getPlace().resetToken();
        }

        return token;
    }

    // Validate action of input arc is possible
    public boolean isArcValid() {
        return this.getPlace().getToken() != null;
    }
}
