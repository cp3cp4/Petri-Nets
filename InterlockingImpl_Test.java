import org.junit.Test;

import java.util.Arrays;

public class InterlockingImpl_Test {
    @Test
    public void initPetriNets() {
        InterlockingImpl interlocking = new InterlockingImpl();
        System.out.println(Arrays.toString(interlocking.getPlaces()));
        System.out.println(interlocking.getRoadMap());
    }

    @Test
    public void addTrain() {
        InterlockingImpl interlocking = new InterlockingImpl();

        // 1-8
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);

        // 1-9
        String trainName2 = "train2";
        int entryTrackSection2 = 1;
        int destinationTrackSection2 = 9;
        try {
            interlocking.addTrain(trainName2, entryTrackSection2, destinationTrackSection2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // 3-4
        String trainName3 = "train3";
        int entryTrackSection3 = 3;
        int destinationTrackSection3 = 4;
        try {
            interlocking.addTrain(trainName3, entryTrackSection3, destinationTrackSection3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // 10-1
        try {
            interlocking.addTrain("train4", 10, 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // 4-3
        try {
            interlocking.addTrain("train5", 4, 3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
