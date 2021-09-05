package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.dto.FrameResults;

public class FinalFrame implements Frame {

    public static final int FINAL_FRAME_NUMBER = 10;

    private State state;

    private FinalFrame() {
        state = Ready.of();
    }

    private FinalFrame(State state) {
        this.state = state;
    }

    public static FinalFrame of() {
        return new FinalFrame();
    }

    @Override
    public Frame bowl(Pins roll) {
        return null;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    @Override
    public int frameNumber() {
        return 0;
    }

//    @Override
//    public FrameResults createFrameResults() {
//        return null;
//    }
//
//    @Override
//    public void addFrameResult(FrameResults results) {
//
//    }
}
