import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * add some examples to test this procedure by JunitTest
 */
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
            System.out.println("The " + trainName1 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }


        //  test add 3 to 4 (OK)
        String trainName3 = "train3";
        int entryTrackSection3 = 3;
        int destinationTrackSection3 = 4;
        try {
            interlocking.addTrain(trainName3, entryTrackSection3, destinationTrackSection3);
            System.out.println("The " + trainName3 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveTrain() {

        InterlockingImpl interlocking = new InterlockingImpl();

        //test add 1 to 8 (OK)
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        try {
            interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);
            System.out.println("The " + trainName1 + " is OK");
        } catch (IllegalArgumentException e) {
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
            System.out.println("The " + trainName2 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // test add 1 to 9 after move the train1(OK)
        try {
            interlocking.moveTrains(new String[]{trainName1});
            interlocking.addTrain(trainName2, entryTrackSection2, destinationTrackSection2);
            System.out.println("The " + trainName2 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSection() {
        InterlockingImpl interlocking = new InterlockingImpl();
        //test add 1 to 8,the train1 currently in section 1,No train currently in  section 3
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        try {
            interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);
            System.out.println("The " + trainName1 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        String currentTrain = interlocking.getSection(1);
        if (currentTrain.isEmpty()) {
            System.out.println("No train currently in section 1");
        } else {
            System.out.println("The " + currentTrain + " currently in section 1");
        }

        String currentTrainNew = interlocking.getSection(3);
        if (currentTrain.isEmpty() || currentTrainNew == null) {
            System.out.println("No train currently in section 3");
        } else {
            System.out.println("The " + currentTrainNew + " currently in section 3");
        }
    }

    @Test
    public void getTrain() {
        InterlockingImpl interlocking = new InterlockingImpl();
        //test add 1 to 8,the train1 currently in section 1,No train currently in  section 3
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        try {
            interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);
            System.out.println("The " + trainName1 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        //test the getTrain
        try {
            int res = interlocking.getTrain(trainName1);
            System.out.println("The res is " + res);
            interlocking.moveTrains(new String[]{trainName1});
            res = interlocking.getTrain(trainName1);
            System.out.println("The getTrain is " + res);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkPathIsValid() {
        InterlockingImpl interlocking = new InterlockingImpl();
        int entryTrackSection1 = 5;
        int destinationTrackSection1 = 9;
        try {
            //there is no valid path from the 5 to the 9
            interlocking.checkPathIsValid(entryTrackSection1,destinationTrackSection1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkTrackSectionValid(){
        InterlockingImpl interlocking = new InterlockingImpl();
        int entryTrackSection1 = 5;
        int destinationTrackSection1 = 20;
        try {
            interlocking.checkTrackSectionValid(entryTrackSection1);
            interlocking.checkTrackSectionValid(destinationTrackSection1);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTransitionList(){
        InterlockingImpl interlocking = new InterlockingImpl();
        //test add 1 to 8 (OK)
        String trainName1 = "train1";
        int entryTrackSection1 = 1;
        int destinationTrackSection1 = 9;
        try {
            interlocking.addTrain(trainName1, entryTrackSection1, destinationTrackSection1);
            System.out.println("The " + trainName1 + " is OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            List<Transition> res=interlocking.getTransitionList();
            for(Transition e:res){
                System.out.println("name: "+e.getName());
            }
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkIsConflict(){
        InterlockingImpl interlocking = new InterlockingImpl();
        try {
           boolean flag= interlocking.checkIsConflict(4,3);
           if(flag){
               System.out.println("track sections isn't conflict");
           }else {
               System.out.println("track sections is conflict");
           }
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
