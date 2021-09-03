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

    public static FirstBowl of(int roll) {
        return new FirstBowl(Pins.of(roll));
    }

    @Override
    public State bowl(Pins roll) {
        if (firstRoll.isSpare(roll)) {
            return Spare.of(firstRoll, roll);
        }
        return Miss.of(firstRoll, roll);
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
