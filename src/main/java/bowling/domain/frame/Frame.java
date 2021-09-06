package bowling.domain.frame;

import bowling.dto.FrameResults;

public interface Frame {

    Frame bowl(int roll);

    int frameNumber();

    boolean isFinished();

    FrameResults createFrameResults();

    void addFrameResult(FrameResults frameResults);
}
