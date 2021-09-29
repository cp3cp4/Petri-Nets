/**
 * Common Tool
 */
public class util {
    public static String getTrainMoveDirection(int entryTrackSection, int destinationTrackSection) {
        return entryTrackSection > destinationTrackSection ? Train.NORTH : Train.SOUTH;
    }
}
