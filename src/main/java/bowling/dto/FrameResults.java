package bowling.dto;

import java.util.ArrayList;
import java.util.List;

public class FrameResults {

    private List<FrameResult> results;

    private FrameResults() {
        results = new ArrayList<>();
    }

    private FrameResults(List<FrameResult> results) {
        this.results = results;
    }

    public static FrameResults of() {
        return new FrameResults();
    }

    public static FrameResults of(List<FrameResult> results) {
        return new FrameResults(results);
    }

    public void addFrameResult(FrameResult frameResult) {
        results.add(frameResult);
    }

    public List<FrameResult> getResults() {
        return results;
    }

    public void setResults(List<FrameResult> results) {
        this.results = results;
    }
}
