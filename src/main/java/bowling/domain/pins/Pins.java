package bowling.domain.pins;

import bowling.exception.InvalidPinsException;

public class Pins {

    public static final int MAX_PINS = 10;
    public static final int MIN_PINS = 0;

    private final int roll;

    private Pins(int roll) {
        validate(roll);
        this.roll = roll;
    }

    public static Pins of(int roll) {
        return new Pins(roll);
    }

    public String description() {
        if (isGutter()) {
            return "-";
        }
        if (isStrike()) {
            return "X";
        }
        return String.valueOf(roll);
    }

    public String description(Pins pins) {
        if (isSpare(pins)) {
            return description() + "|/";
        }
        return description() + "|" + pins.description();
    }

    public boolean isStrike() {
        return roll == MAX_PINS;
    }

    public boolean isSpare(Pins pins) {
        return roll + pins.roll == MAX_PINS;
    }

    public boolean isGutter() {
        return roll == MIN_PINS;
    }

    private void validate(int roll) {
        if (roll < MIN_PINS || roll > MAX_PINS) {
            throw new InvalidPinsException();
        }
    }
}
