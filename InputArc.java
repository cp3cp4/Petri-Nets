public class InputArc extends Arc {
    public InputArc(String name, Place place) {
        super(name, place);
    }

    // enable the transition,
    // return Train
    public Train trigger() {
        Train token = null;
        Place place = this.getPlace();
        if (place.getTokens().size() == 1) {
            token = this.getPlace().getTokens().get(0);
            this.getPlace().resetToken();
        }

        return token;
    }

    // Validate action of input arc is possible
    public boolean isArcValid() {
        return this.getPlace().getTokens().size() == 1;
    }
}
