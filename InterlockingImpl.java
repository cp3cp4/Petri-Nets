import java.util.*;
import java.util.stream.Collectors;

public class InterlockingImpl implements Interlocking
{

    private Place[] places;
    private Map<String, Transition> transitionMap = new HashMap<>();
    private Map<String, Train> trainMap = new HashMap<>();
    private Map<Integer, List<Integer>> roadMap = new HashMap<>();
    private Map<String, Route> routeMap = new HashMap<>();

    /**
     * Init Petri Nets
     *
     * t1:  1 -> 5
     * t2': 5 -> 2
     * t3:  3 -> 4 7
     * t3': 7 4 -> 3
     * t4:  5 -> 8 9
     * t4': 9 -> 5
     * t5:  10 9 -> 6
     * t6:  7 -> 11
     * t6': 11 -> 7
     *
     * t1 has higher privileges than t3 & t3'
     * t2' has higher privileges than t3
     *
     * t3, t6 will conflict with t3', t6'
     * t4 will conflict with t4'
     */
    public InterlockingImpl() {
        Place p1 = new Place(1);
        Place p2 = new Place(2);
        Place p3 = new Place(3);
        Place p4 = new Place(4);
        Place p5 = new Place(5);
        Place p6 = new Place(6);
        Place p7 = new Place(7);
        Place p8 = new Place(8);
        Place p9 = new Place(9);
        Place p10 = new Place(10);
        Place p11 = new Place(11);

        // t1:  1 -> 5
        List<InputArc> t1InputArcList = new ArrayList<>();
        InputArc i15 = new InputArc("1-t1", p1);
        t1InputArcList.add(i15);
        List<OutputArc> t1OutputArcList = new ArrayList<>();
        OutputArc o15 = new OutputArc("t1-5", p5);
        t1OutputArcList.add(o15);
        Transition t1 = new Transition("t1", t1InputArcList, t1OutputArcList);
        transitionMap.put("t1", t1);

        // t2': 5 -> 2
        List<InputArc> t2_InputArcList = new ArrayList<>();
        InputArc i52 = new InputArc("5-t2'", p5);
        t2_InputArcList.add(i52);
        List<OutputArc> t2_OutputArcList = new ArrayList<>();
        OutputArc o_t2_2 = new OutputArc("t2'-2", p2);
        t2_OutputArcList.add(o_t2_2);
        Transition t2_ = new Transition("t2'", t2_InputArcList, t2_OutputArcList);
        transitionMap.put("t2'", t2_);

        // t3:  3 -> 4 7
        List<InputArc> t3InputArcList = new ArrayList<>();
        InputArc i3_t3 = new InputArc("3-t3", p3);
        t3InputArcList.add(i3_t3);
        List<OutputArc> t3OutputArcList = new ArrayList<>();
        OutputArc o34 = new OutputArc("t3-4", p4);
        OutputArc o37 = new OutputArc("t3-7", p7);
        t3OutputArcList.add(o34);
        t3OutputArcList.add(o37);
        Transition t3 = new Transition("t3", t3InputArcList, t3OutputArcList, 0);
        transitionMap.put("t3", t3);

        // t3': 7 4 -> 3
        List<InputArc> t3_InputArcList = new ArrayList<>();
        InputArc i_43 = new InputArc("4-t3'", p4);
        InputArc i_73 = new InputArc("7-t3'", p7);
        t3_InputArcList.add(i_73);
        List<OutputArc> t3_OutputArcList = new ArrayList<>();
        OutputArc o_43 = new OutputArc("t3'-3", p3);
        t3_OutputArcList.add(o_43);
        Transition t3_ = new Transition("t3", t3_InputArcList, t3_OutputArcList, 0);
        transitionMap.put("t3'", t3_);

        // t4:  5 -> 8 9
        List<InputArc> t4InputArcList = new ArrayList<>();
        InputArc i58 = new InputArc("5-t4", p5);
        t4InputArcList.add(i58);
        List<OutputArc> t4OutputArcList = new ArrayList<>();
        OutputArc o58 = new OutputArc("t4-8", p8);
        OutputArc o59 = new OutputArc("t4-9", p9);
        t4OutputArcList.add(o58);
        t4OutputArcList.add(o59);
        Transition t4 = new Transition("t4", t4InputArcList, t4OutputArcList);
        transitionMap.put("t4", t4);

        // t4': 9 -> 5
        List<InputArc> t4_InputArcList = new ArrayList<>();
        InputArc i_95 = new InputArc("9-t4'", p9);
        t4_InputArcList.add(i_95);
        List<OutputArc> t4_OutputArcList = new ArrayList<>();
        OutputArc o95 = new OutputArc("t4'-5", p5);
        t4_OutputArcList.add(o95);
        Transition t4_ = new Transition("t4'", t4_InputArcList, t4_OutputArcList);
        transitionMap.put("t4'", t4_);

        // t5:  10 9 -> 6
        List<InputArc> t5InputArcList = new ArrayList<>();
        InputArc i10_6 = new InputArc("10-t5", p10);
        InputArc i9_6 = new InputArc("9-t5", p9);
        t5InputArcList.add(i10_6);
        t5InputArcList.add(i9_6);
        List<OutputArc> t5OutputArcList = new ArrayList<>();
        OutputArc ot5_6 = new OutputArc("t5-6", p6);
        t5OutputArcList.add(ot5_6);
        Transition t5 = new Transition("t5", t5InputArcList, t5OutputArcList);
        transitionMap.put("t5", t5);

        // t6:  7 -> 11
        List<InputArc> t6InputArcList = new ArrayList<>();
        InputArc i7_11 = new InputArc("7-t6", p7);
        t6InputArcList.add(i7_11);
        List<OutputArc> t6OutputArcList = new ArrayList<>();
        OutputArc o7_11 = new OutputArc("t6-11", p11);
        t6OutputArcList.add(o7_11);
        Transition t6 = new Transition("t6", t6InputArcList, t6OutputArcList);
        transitionMap.put("t6", t6);

        // t6': 11 -> 7
        List<InputArc> t6_InputArcList = new ArrayList<>();
        InputArc i11_7 = new InputArc("11-t6'", p11);
        t6_InputArcList.add(i11_7);
        List<OutputArc> t6_OutputArcList = new ArrayList<>();
        OutputArc o11_7 = new OutputArc("t6'-7", p7);
        t6_OutputArcList.add(o11_7);
        Transition t6_ = new Transition("t6'", t6_InputArcList, t6_OutputArcList);
        transitionMap.put("t6'", t6_);

        places = new Place[]{ p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};

        // left to right (south)
        // 1 -> 8 9 (1-5-8, 1-5-9)
        List<Integer> r1 = new ArrayList<>();
        r1.add(8);
        r1.add(9);
        roadMap.put(1, r1);

        Route route1_8 = new Route(1);
        util.addNextToRoute(route1_8, 5);
        util.addNextToRoute(route1_8, 8);
        this.routeMap.put("1-8", route1_8);

        Route route1_9 = new Route(1);
        util.addNextToRoute(route1_9, 5);
        util.addNextToRoute(route1_9, 9);
        this.routeMap.put("1-9", route1_9);

        // 3 -> 4 11 (3-4, 3-7-11)
        List<Integer> r3 = new ArrayList<>();
        r3.add(4);
        r3.add(11);
        roadMap.put(3, r3);

        Route route3_4 = new Route(3);
        util.addNextToRoute(route3_4, 4);
        this.routeMap.put("3-4", route3_4);

        Route route3_11 = new Route(3);
        util.addNextToRoute(route3_11, 7);
        util.addNextToRoute(route3_11, 11);
        this.routeMap.put("3-11", route3_11);

        // right to left (north)
        // 4 -> 3 (4-3)
        List<Integer> r4 = new ArrayList<>();
        r4.add(3);
        roadMap.put(4, r4);

        Route route4_3 = new Route(4);
        util.addNextToRoute(route4_3, 4);
        this.routeMap.put("4-3", route4_3);

        // 9 -> 2 (9-6-2)
        List<Integer> r9 = new ArrayList<>();
        r9.add(2);
        roadMap.put(9, r9);

        Route route9_2 = new Route(9);
        util.addNextToRoute(route9_2, 2);
        this.routeMap.put("9-2", route9_2);
        // 10 -> 2 (10-6-2)
        List<Integer> r10 = new ArrayList<>();
        r10.add(2);
        roadMap.put(10, r10);

        Route route10_2 = new Route(10);
        util.addNextToRoute(route10_2, 6);
        util.addNextToRoute(route10_2, 2);
        this.routeMap.put("10-2", route10_2);
        // 11 -> 3 (11-7-3)
        List<Integer> r11 = new ArrayList<>();
        r11.add(3);
        roadMap.put(11, r11);

        Route route11_3 = new Route(11);
        util.addNextToRoute(route11_3, 7);
        util.addNextToRoute(route11_3, 3);
        this.routeMap.put("11-3", route11_3);
    }

    /**
     * Adds a train to the rail corridor.
     *
     * @param   trainName A String that identifies a given train. Cannot be the same as any other train present.
     * @param   entryTrackSection The id number of the track section that the train is entering into.
     * @param   destinationTrackSection The id number of the track section that the train should exit from.
     * @throws  IllegalArgumentException 
     *              if the train name is already in use, or there is no valid path from the entry to the destination
     * @throws  IllegalStateException 
     *              if the entry track is already occupied
     */
    public void addTrain(String trainName, int entryTrackSection, int destinationTrackSection)
        throws IllegalArgumentException, IllegalStateException {
            if (this.trainMap.containsKey(trainName)) {
                throw new IllegalArgumentException("the train named as" + trainName + " is already in use");
            }

            this.checkPathIsValid(entryTrackSection, destinationTrackSection);
            Route route = this.routeMap.get(String.valueOf(entryTrackSection) + "-" + String.valueOf(destinationTrackSection));
            Train train = new Train(trainName, entryTrackSection, destinationTrackSection, route);

            this.places[entryTrackSection - 1].addToken(train);
            if (this.checkIsConflict(entryTrackSection, destinationTrackSection)) {
                this.places[entryTrackSection - 1].resetToken();
                throw new IllegalArgumentException("There is no valid path from the entry to the destination.");
            } else {
                this.trainMap.put(trainName, train);
            }
        }

    /**
     * The listed trains proceed to the next track section.
     * Trains only move if they are able to do so, otherwise they remain in their current section.
     * When a train reaches its destination track section, it exits the rail corridor next time it moves.
     *
     * @param   trainNames The names of the trains to move.
     * @return  The number of trains that have moved.
     * @throws  IllegalArgumentException 
     *              if the train name does not exist or is no longer in the rail corridor
     */
    public int moveTrains(String[] trainNames)
        throws IllegalArgumentException {
        int movedTrainCount = 0;
        // get all transitions that can execute
        List<Transition> transitionList = this.getTransitionList();

        // sort transitions by weight
        if (!transitionList.isEmpty()) {
            transitionList = transitionList.stream().sorted(Comparator.comparing(Transition::getWeight).reversed()).collect(Collectors.toList());
        }
        // When a train reaches its destination track section, it exits the rail corridor next time it moves.
        for (int i = 0; i < this.places.length; ++i) {
            Place place = this.places[i];
            if (place != null && place.isReachDestination()) {
                this.places[i] = null;
                movedTrainCount += 1; // train leave its destination
            }
            // update trainMap
            this.trainMap.remove(place.getTrainName());
        }
        // execute transition
        for (Transition transition : transitionList) {
            movedTrainCount += transition.transit();
        }

        return movedTrainCount;
        }

    /**
     * Returns the name of the Train currently occupying a given track section
     *
     * @param   trackSection The id number of the section of track.
     * @return  The name of the train currently in that section, or null if the section is empty/unoccupied.
     * @throws  IllegalArgumentException 
     *              if the track section does not exist
     */
    public String getSection(int trackSection)
        throws IllegalArgumentException {
            this.checkTrackSectionValid(trackSection);
            return this.places[trackSection - 1].getTrainName();
        }

    /**
     * Returns the track section that a given train is occupying
     *
     * @param   trainName The name of the train.
     * @return  The id number of section of track the train is occupying, or -1 if the train is no longer in the rail corridor
     * @throws  IllegalArgumentException
     *              if the train name does not exist
     */
    public int getTrain(String trainName)
        throws IllegalArgumentException {
            if (!this.trainMap.containsKey(trainName)) {
                throw new IllegalArgumentException("train named " + trainName + " does not exist");
            }

            return this.trainMap.get(trainName).getCurSection();
        }

    /**
     * Check there is valid path from the entry to the destination.
     *
     * @param   entryTrackSection The id number of the track section that the train is entering into.
     * @param   destinationTrackSection The id number of the track section that the train should exit from.
     *  @throws IllegalArgumentException
     *              if there is no valid path from the entry to the destination
     */
    public void checkPathIsValid(int entryTrackSection, int destinationTrackSection) {
        this.checkTrackSectionValid(entryTrackSection);
        this.checkTrackSectionValid(destinationTrackSection);

        Route route = this.routeMap.get(String.valueOf(entryTrackSection) + "-" + String.valueOf(destinationTrackSection));
        if (route == null) {
            throw new IllegalArgumentException("there is no valid path from the entry to the destination");
        }
    }

    /**
     * Check track section is valid.
     * @param trackSection The id number of the section of track.
     * @throws  IllegalArgumentException
     *              if the track section does not exist
     */
    public void checkTrackSectionValid(int trackSection) {
        if (trackSection < 1 || trackSection > this.places.length) {
            throw new IllegalArgumentException("track section "+trackSection+" does not exist!");
        }
    }

    /**
     * check track sections is conflict
     * @param entryTrackSection The id number of the track section that the train is entering into.
     * @param  destinationTrackSection The id number of the track section that the train should exit from.
     * @return true is ok
     */
    public boolean checkIsConflict(int entryTrackSection, int destinationTrackSection) {
        // 3-4
        if (entryTrackSection == 3 && destinationTrackSection == 4) {
            for (Train train : this.trainMap.values()) {
                if (train.getDestinationTrackSection() == 3 && train.getEntryTrackSection() == 4) {
                    return true;
                }
            }
        } else if (entryTrackSection == 4 && destinationTrackSection == 3) {
            for (Train train : this.trainMap.values()) {
                if (train.getDestinationTrackSection() == 4 && train.getEntryTrackSection() == 3) {
                    return true;
                }
            }
        } else if (entryTrackSection == 3 && destinationTrackSection == 11) { // 3 - 11
            for (Train train : this.trainMap.values()) {
                if (train.getDestinationTrackSection() == 11 && train.getEntryTrackSection() == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * get all trains
     * @return trains list
     */
    public List<Transition> getTransitionList() {
        List<Transition> transList = new ArrayList<>();
        for (String name : transitionMap.keySet()) {
            Transition tmpTransition = transitionMap.get(name);
            if (tmpTransition.canTransit()) {
                transList.add(tmpTransition);
            }
        }

        return transList;
    }

    public Place[] getPlaces() {
        return places;
    }

    public void setPlaces(Place[] places) {
        this.places = places;
    }

    public Map<String, Transition> getTransitionMap() {
        return transitionMap;
    }

    public void setTransitionMap(Map<String, Transition> transitionMap) {
        this.transitionMap = transitionMap;
    }

    public Map<String, Train> getTrainMap() {
        return trainMap;
    }

    public void setTrainMap(Map<String, Train> trainMap) {
        this.trainMap = trainMap;
    }

    public Map<Integer, List<Integer>> getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(Map<Integer, List<Integer>> roadMap) {
        this.roadMap = roadMap;
    }

    public Map<String, Route> getRouteMap() {
        return routeMap;
    }

    public void setRouteMap(Map<String, Route> routeMap) {
        this.routeMap = routeMap;
    }

    public static void main(String[] args) {
    }
}
