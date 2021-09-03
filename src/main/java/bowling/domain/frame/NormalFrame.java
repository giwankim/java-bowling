package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.dto.FinalFrame;
import bowling.dto.FrameResult;
import bowling.dto.FrameResults;
import bowling.exception.InvalidNormalFrameException;

public class NormalFrame implements Frame {

    public static final int MIN_FRAME_NUMBER = 1;
    public static final int MAX_FRAME_NUMBER = 9;

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
    public Frame bowl(Pins roll) {
        state = state.bowl(roll);
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

    private Frame nextFrame() {
        if (frameNumber + 1 == MAX_FRAME_NUMBER) {
            return FinalFrame.of();
        }
        return NormalFrame.of(frameNumber + 1);
    }

    private void validate(int frameNumber) {
        if (frameNumber < MIN_FRAME_NUMBER || frameNumber > MAX_FRAME_NUMBER) {
            throw new InvalidNormalFrameException();
        }
    }

    public static void printFrameResults(FrameResults frameResults) {
        frameResults.getResults()
                .stream()
                .map(FrameResult::getDescription)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Frame frame = NormalFrame.of(1);
        frame.bowl(Pins.of(5))
                .bowl(Pins.of(3))
                .bowl(Pins.of(2))
                .bowl(Pins.of(8))
                .bowl(Pins.of(10));
        FrameResults frameResults = frame.createFrameResults();
        printFrameResults(frameResults);
    }
}
