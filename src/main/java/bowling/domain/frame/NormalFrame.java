package bowling.domain.frame;

import bowling.exception.InvalidNormalFrameException;

public class NormalFrame {

    public static final int MIN_FRAME_NUMBER = 1;
    public static final int MAX_FRAME_NUMBER = 9;

    private final int frameNumber;

    private NormalFrame(int frameNumber) {
        validate(frameNumber);
        this.frameNumber = frameNumber;
    }

    public static NormalFrame of(int frameNumber) {
        return new NormalFrame(frameNumber);
    }


    private void validate(int frameNumber) {
        if (frameNumber < MIN_FRAME_NUMBER || frameNumber > MAX_FRAME_NUMBER) {
            throw new InvalidNormalFrameException();
        }
    }
}
