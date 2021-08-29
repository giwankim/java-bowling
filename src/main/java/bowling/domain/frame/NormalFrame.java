package bowling.domain.frame;

import bowling.domain.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.exception.InvalidNormalFrameException;
import java.util.Objects;

public class NormalFrame implements Frame {

    public static final int MIN_NORMAL_FRAME = 1;
    public static final int MAX_NORMAL_FRAME = 9;

    private final int frameNumber;
    private State state;

    private NormalFrame(int frameNumber) {
        this(frameNumber, Ready.of());
    }

    private NormalFrame(int frameNumber, State state) {
        validate(frameNumber);
        this.frameNumber = frameNumber;
        this.state = state;
    }

    public static NormalFrame of(int frameNumber) {
        return new NormalFrame(frameNumber);
    }

    public static NormalFrame of(int frameNumber, State state) {
        return new NormalFrame(frameNumber, state);
    }

    @Override
    public Frame bowl(int roll) {
        state = state.bowl(Pins.of(roll));
        if (state.isFinished()) {
            return nextFrame();
        }
        return this;
    }

    private Frame nextFrame() {
        if (frameNumber == MAX_NORMAL_FRAME) {
            return FinalFrame.of();
        }
        return NormalFrame.of(frameNumber + 1);
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    private void validate(int frameNumber) {
        if (frameNumber < MIN_NORMAL_FRAME || frameNumber > MAX_NORMAL_FRAME) {
            throw new InvalidNormalFrameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NormalFrame)) {
            return false;
        }
        NormalFrame that = (NormalFrame) o;
        return frameNumber == that.frameNumber && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frameNumber, state);
    }
}
