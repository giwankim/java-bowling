package bowling.domain;

import bowling.exception.InvalidRollException;

public class Roll {

    public static final int MAX_PINS = 10;
    public static final int MIN_PINS = 0;

    private final int pins;

    private Roll(int pins) {
        validate(pins);
        this.pins = pins;
    }

    public static Roll of(int pins) {
        return new Roll(pins);
    }

    private void validate(int pins) {
        if (pins < MIN_PINS || pins > MAX_PINS) {
            throw new InvalidRollException();
        }
    }
}
