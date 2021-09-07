package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.dto.FrameResult;
import bowling.dto.FrameResults;

public class FinalFrame implements Frame {

    public static final int FRAME_NUMBER = 10;

    private State state;

    private FinalFrame() {
        state = Ready.of();
    }

    public static FinalFrame of() {
        return new FinalFrame();
    }

    @Override
    public Frame bowl(int roll) {
        Pins pins = Pins.of(roll);
        state = state.bowl(pins);
        return this;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
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
        FrameResult frameResult = FrameResult.of(state.description());
        results.addFrameResult(frameResult);
    }
}
