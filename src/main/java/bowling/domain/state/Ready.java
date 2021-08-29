package bowling.domain.state;

import bowling.domain.Pins;

public class Ready extends Running {

    private Ready() {
    }

    public static Ready of() {
        return new Ready();
    }

    @Override
    public State bowl(Pins pins) {
        if (pins.isStrike()) {
            return Strike.of();
        }
        return FirstBowl.of(pins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ready)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
