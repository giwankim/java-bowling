package bowling.domain.frame;

import bowling.domain.pins.Pins;

public interface Frame {

    Frame bowl(Pins roll);

    boolean isFinished();

}
