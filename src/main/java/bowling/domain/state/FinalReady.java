package bowling.domain.state;

import bowling.domain.pins.Pins;

public class FinalReady extends Playing {

    private FinalReady() {
    }

    public static FinalReady of() {
        return new FinalReady();
    }

    @Override
    public State bowl(Pins roll) {
        return null;
    }

    @Override
    public String description() {
        return "";
    }
}
