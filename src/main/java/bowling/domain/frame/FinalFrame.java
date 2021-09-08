package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.dto.FrameResult;
import bowling.dto.FrameResults;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FinalFrame implements Frame {

    public static final int FRAME_NUMBER = 10;

    private final LinkedList<State> states = new LinkedList<>();

    private FinalFrame() {
        states.addLast(Ready.of());
    }

    public static FinalFrame of() {
        return new FinalFrame();
    }

    @Override
    public Frame bowl(int roll) {
        Pins pins = Pins.of(roll);
        State state = states.getLast();

        state = state.bowl(pins);

        return this;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public int frameNumber() {
        return FRAME_NUMBER;
    }

    @Override
    public FrameResults createFrameResults() {
        FrameResults frameResults = FrameResults.of();
        addFrameResult(frameResults);
        return frameResults;
    }

    @Override
    public void addFrameResult(FrameResults results) {
        String description = states.stream()
                .map(State::description)
                .collect(Collectors.joining("|"));
        FrameResult frameResult = FrameResult.of(description);
        results.addFrameResult(frameResult);
    }
}
