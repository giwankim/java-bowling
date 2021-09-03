package bowling.domain.state;

import bowling.domain.pins.Pins;
import bowling.exception.InvalidMissException;

public class Miss extends Finished {

    private final Pins firstRoll;
    private final Pins secondRoll;

    private Miss(Pins firstRoll, Pins secondRoll) {
        validate(firstRoll, secondRoll);
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public static Miss of(Pins firstRoll, Pins secondRoll) {
        return new Miss(firstRoll, secondRoll);
    }

    public static Miss of(int firstRoll, int secondRoll) {
        return new Miss(Pins.of(firstRoll), Pins.of(secondRoll));
    }

    @Override
    public String description() {
        return firstRoll.description(secondRoll);
    }

    private void validate(Pins firstRoll, Pins secondRoll) {
        if (firstRoll.isSpare(secondRoll)) {
            throw new InvalidMissException();
        }
    }
}
