import java.util.ArrayList;
import java.util.List;

public class Transition {
    private String name;
    private int weight = 1; // default weight is 1
    private List<InputArc> inputArcList;
    private List<OutputArc> outputArcList;

    public Transition(String name, List<InputArc> inputArcList, List<OutputArc> outputArcList) {
        this.name = name;
        this.inputArcList = inputArcList;
        this.outputArcList = outputArcList;
    }

    public Transition(String name, List<InputArc> inputArcList, List<OutputArc> outputArcList, int weight) {
        this.name = name;
        this.inputArcList = inputArcList;
        this.outputArcList = outputArcList;
        this.weight = weight;
    }

    public Transition(String name) {
        this.name = name;
        this.inputArcList = new ArrayList<>();
        this.outputArcList = new ArrayList<>();
    }

    /**
     * Check current transition might be work
     * @return boolean
     */
    public boolean canTransit() {
        boolean flag = true;
        if (this.inputArcList != null) {
            for (InputArc inputArc : inputArcList) {
                if (!inputArc.isArcValid()) {
                    flag = false;
                }
            }
        }

        return flag;
    }

    /**
     * execute transition
     * @return int
     *              return the num of moved train
     */
    public int transit() {
        int successCount = 0;
        if (this.canTransit()) {
            for (int i = 0; i < this.inputArcList.size(); ++i) {
                Train token = this.inputArcList.get(i).getToken();
                if (this.outputArcList.get(i).trigger(token)) {
                    this.inputArcList.get(i).trigger();
                    successCount += 1;
                }
            }
        }

        return successCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<InputArc> getInputArcList() {
        return inputArcList;
    }

    public void setInputArcList(List<InputArc> inputArcList) {
        this.inputArcList = inputArcList;
    }

    public List<OutputArc> getOutputArcList() {
        return outputArcList;
    }

    public void setOutputArcList(List<OutputArc> outputArcList) {
        this.outputArcList = outputArcList;
    }
}
