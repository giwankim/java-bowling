package bowling.domain.state;

import bowling.domain.pins.Pins;

public class Ready extends Playing {

    private Ready() {
    }

    public static Ready of() {
        return new Ready();
    }

    @Override
    public State bowl(Pins roll) {
        if (roll.isStrike()) {
            return Strike.of();
        }
        return FirstBowl.of(roll);
    }

    @Override
    public String description() {
        return "";
    }
}
