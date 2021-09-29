import java.util.ArrayList;
import java.util.List;

/** P = { p1, p2, . . . ,pm } is a finite set of places
 * Define place vertex in the petri net
 */
public class Place {
    private int section;

    public Place(int section) {
        this.section = section;
    }
    // each section only have one train,
    // maybe i should define tokens as Train.class
    private List<Train> tokens = new ArrayList<>();

    public List<Train> getTokens() {
        return tokens;
    }

    public void setTokens(List<Train> tokens) {
        this.tokens = tokens;
    }
    public void  addToken(Train train) throws IllegalStateException {
        if (this.tokens.size() == 0) {
            train.setCurSection(this.section);
            this.tokens.add(train);
        } else {
            throw new IllegalStateException("the entry track is already occupied by " + this.tokens.get(0).getTrainName());
        }
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void resetToken() {
        this.tokens = new ArrayList<>();
    }

    public String getTrainName() {
        if (this.tokens.isEmpty()) {
            return null;
        }

        return this.tokens.get(0).getTrainName();
    }
}
