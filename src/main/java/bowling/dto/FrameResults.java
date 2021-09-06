package bowling.dto;

import java.util.ArrayList;
import java.util.List;

public class FrameResults {

    private List<FrameResult> results;

    private FrameResults() {
        results = new ArrayList<>();
    }

    public static FrameResults of() {
        return new FrameResults();
    }

    public void addFrameResult(FrameResult frameResult) {
        results.add(frameResult);
    }

    public List<FrameResult> getResults() {
        return results;
    }
}
