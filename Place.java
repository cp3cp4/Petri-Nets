/** P = { p1, p2, . . . ,pm } is a finite set of places
 * Define place vertex in the petri net
 */
public class Place {
    private int section;
    // each section only have one train
    private Train token;

    public Place(int section) {
        this.section = section;
    }

    public boolean addToken(Train train) throws IllegalStateException {
        boolean flag = false;
        if (this.token == null) {
            Route curTrainRoute = train.getRoute();
            // add token only if current section is on the route of train
            while (curTrainRoute != null) {
                if (curTrainRoute.getSection() == section) {
                    train.setCurSection(this.section);
                    this.token = train;
                    flag = true;
                    break;
                }
                curTrainRoute = curTrainRoute.getNext();
            }
        } else {
            throw new IllegalStateException("the entry track is already occupied by " + this.token.getTrainName());
        }

        return flag;
    }

    public void resetToken() {
        this.token = null;
    }

    public boolean isReachDestination() {
        boolean flag = false;
        if (this.token != null) {
            if (this.token.getDestinationTrackSection() == this.section) {
                flag = true;
            }
        }

        return flag;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getTrainName() {
        if (this.token == null) {
            return null;
        }

        return this.token.getTrainName();
    }

    public Train getToken() {
        return token;
    }

    public void setToken(Train token) {
        this.token = token;
    }
}
