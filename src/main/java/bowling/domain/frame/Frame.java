package bowling.domain.frame;

import bowling.domain.pins.Pins;
import bowling.dto.FrameResults;

public interface Frame {

    Frame bowl(Pins roll);

    int frameNumber();

    boolean isFinished();
}
