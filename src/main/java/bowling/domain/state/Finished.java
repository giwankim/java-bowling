package bowling.domain.state;

import bowling.domain.pins.Pins;
import bowling.exception.FinishedStateException;

public abstract class Finished implements State {

    @Override
    public State bowl(Pins roll) {
        throw new FinishedStateException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
