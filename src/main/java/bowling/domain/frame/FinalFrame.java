package bowling.domain.frame;

import bowling.domain.state.Ready;
import bowling.domain.state.State;

public class FinalFrame implements Frame {

    private static final int LAST_FRAME_NUMBER = 10;

    private State state;

    private FinalFrame() {
        state = Ready.of();
    }

    public static FinalFrame of() {
        return new FinalFrame();
    }

    @Override
    public Frame bowl(int roll) {
        return null;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }
}
