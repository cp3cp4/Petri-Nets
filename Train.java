public class Train {
    // constant var
    public static final String NORTH = "north";
    public static final String SOUTH = "south";

    private String trainName;
    private String moveDirection; // north or south
    private int entryTrackSection;
    private int destinationTrackSection;
    private int curSection;

    public Train(String trainName, String moveDirection) {
        this.trainName = trainName;
        this.moveDirection = moveDirection;
    }

    public Train(String trainName, int entryTrackSection, int destinationTrackSection) {
        this.trainName = trainName;
        this.entryTrackSection = entryTrackSection;
        this.destinationTrackSection = destinationTrackSection;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(String moveDirection) {
        this.moveDirection = moveDirection;
    }

    public int getEntryTrackSection() {
        return entryTrackSection;
    }

    public void setEntryTrackSection(int entryTrackSection) {
        this.entryTrackSection = entryTrackSection;
    }

    public int getDestinationTrackSection() {
        return destinationTrackSection;
    }

    public void setDestinationTrackSection(int destinationTrackSection) {
        this.destinationTrackSection = destinationTrackSection;
    }

    public int getCurSection() {
        return curSection;
    }

    public void setCurSection(int curSection) {
        this.curSection = curSection;
    }
}
