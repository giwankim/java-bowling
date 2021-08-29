package bowling.domain;

import bowling.exception.InvalidPinsException;
import java.util.Objects;

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

    public boolean isStrike() {
        return roll == MAX_PINS;
    }

    public boolean isSpare(Pins pins) {
        return roll + pins.roll == MAX_PINS;
    }

    private void validate(int roll) {
        if (roll < MIN_PINS || roll > MAX_PINS) {
            throw new InvalidPinsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pins)) {
            return false;
        }
        Pins pins = (Pins) o;
        return roll == pins.roll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll);
    }
}
