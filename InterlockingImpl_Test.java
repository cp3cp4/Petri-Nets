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

        //test add 1 to 8 (OK)
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        try {
            interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);
            System.out.println("The "+trainName1+" is OK");
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // test add 1 to 9 (the entry track is already occupied by train1)
        String trainName2 = "train2";
        int entryTrackSection2 = 1;
        int destinationTrackSection2 = 9;
        try {
            interlocking.addTrain(trainName2, entryTrackSection2, destinationTrackSection2);
            System.out.println("The "+trainName2+" is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //  test add 3 to 4 (there is no valid path from the entry to the destination)
        String trainName3 = "train3";
        int entryTrackSection3 = 3;
        int destinationTrackSection3 = 4;
        try {
            interlocking.addTrain(trainName3, entryTrackSection3, destinationTrackSection3);
            System.out.println("The "+trainName3+" is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // test add 10 to 1 (There is no valid path from the entry to the destination)
        String trainName4 = "train4";
        try {
            interlocking.addTrain("train4", 10, 1);
            System.out.println("The "+trainName4+" is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //  test add 4 to 3
        String trainName5 = "train3";
        try {
            interlocking.addTrain("train5", 4, 3);
            System.out.println("The "+trainName5+" is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
