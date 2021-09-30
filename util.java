/**
 * Common Tool
 */
public class util {
    public static String getTrainMoveDirection(int entryTrackSection, int destinationTrackSection) {
        return entryTrackSection > destinationTrackSection ? Train.NORTH : Train.SOUTH;
    }

    public static void addNextToRoute(Route route, int next) {
        Route nextRoute = new Route(next);
        Route tmp = route;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(nextRoute);
    }
}
