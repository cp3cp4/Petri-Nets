package core;

public class Train {
    // constant var
    public static final String NORTH = "north";
    public static final String SOUTH = "south";

    private String trainName;
    private String moveDirection; // north or south
    private String entryTrackSection;
    private String destinationTrackSection;

    public Train(String trainName, String moveDirection) {
        this.trainName = trainName;
        this.moveDirection = moveDirection;
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

    public String getEntryTrackSection() {
        return entryTrackSection;
    }

    public void setEntryTrackSection(String entryTrackSection) {
        this.entryTrackSection = entryTrackSection;
    }

    public String getDestinationTrackSection() {
        return destinationTrackSection;
    }

    public void setDestinationTrackSection(String destinationTrackSection) {
        this.destinationTrackSection = destinationTrackSection;
    }
}
