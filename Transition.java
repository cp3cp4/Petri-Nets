import java.util.ArrayList;
import java.util.List;

public class Transition {
    private String name;
    private List<InputArc> inputArcList;
    private List<OutputArc> outputArcList;

    public Transition(String name, List<InputArc> inputArcList, List<OutputArc> outputArcList) {
        this.name = name;
        this.inputArcList = inputArcList;
        this.outputArcList = outputArcList;
    }

    public Transition(String name) {
        this.name = name;
        this.inputArcList = new ArrayList<>();
        this.outputArcList = new ArrayList<>();
    }


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

    public void transit() {
        if (this.canTransit()) {
            for (int i = 0; i < this.inputArcList.size(); ++i) {
                this.outputArcList.get(i).trigger(this.inputArcList.get(i).trigger());
            }
        }
    }
}
