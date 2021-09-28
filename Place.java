package core;

import java.util.ArrayList;
import java.util.List;

/** P = { p1, p2, . . . ,pm } is a finite set of places
 * Define place vertex in the petri net
 */
public class Place {
    // each section only have one train,
    // maybe i should define tokens as Train.class
    private List<Train> tokens = new ArrayList<>();

    public List<Train> getTokens() {
        return tokens;
    }

    public void setTokens(List<Train> tokens) {
        this.tokens = tokens;
    }

    public void resetToken() {
        this.tokens = new ArrayList<>();
    }
}
