package bowling.domain.state;

import bowling.domain.pins.Pins;
import bowling.exception.InvalidFirstBowlException;

public class FirstBowl extends Playing {

    private final Pins firstRoll;

    private FirstBowl(Pins firstRoll) {
        validate(firstRoll);
        this.firstRoll = firstRoll;
    }

    public static FirstBowl of(Pins roll) {
        return new FirstBowl(roll);
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
        return firstRoll.description();
    }

    private void validate(Pins firstRoll) {
        if (firstRoll.isStrike()) {
            throw new InvalidFirstBowlException();
        }
    }
}
