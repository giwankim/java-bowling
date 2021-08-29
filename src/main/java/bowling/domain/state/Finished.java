package bowling.domain.state;

import bowling.domain.Pins;

public abstract class Finished implements State {

    @Override
    public State bowl(Pins pins) {
        throw new RuntimeException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
