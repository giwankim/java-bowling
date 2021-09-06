package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.dto.FrameResult;
import bowling.dto.FrameResults;
import bowling.exception.InvalidNormalFrameException;

public class NormalFrame implements Frame {

    public static final int MIN_NORMAL_FRAME_NUMBER = 1;
    public static final int MAX_NORMAL_FRAME_NUMBER = 9;

    private final int frameNumber;
    private State state;
    private Frame next;

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
    public int frameNumber() {
        return frameNumber;
    }

    @Override
    public Frame bowl(int roll) {
        Pins pins = Pins.of(roll);
        state = state.bowl(pins);
        if (state.isFinished()) {
            next = nextFrame();
            return next;
        }
        return this;
    }

    @Override
    public FrameResults createFrameResults() {
        FrameResults frameResults = FrameResults.of();
        addFrameResult(frameResults);
        return frameResults;
    }

    @Override
    public void addFrameResult(FrameResults frameResults) {
        FrameResult frameResult = FrameResult.of(state.description());
        frameResults.addFrameResult(frameResult);
        if (next != null) {
            next.addFrameResult(frameResults);
        }
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    private Frame nextFrame() {
        if (frameNumber == MAX_NORMAL_FRAME_NUMBER) {
            return FinalFrame.of();
        }
        return NormalFrame.of(frameNumber + 1);
    }

    private void validate(int frameNumber) {
        if (frameNumber < MIN_NORMAL_FRAME_NUMBER || frameNumber > MAX_NORMAL_FRAME_NUMBER) {
            throw new InvalidNormalFrameException();
        }
    }
}
