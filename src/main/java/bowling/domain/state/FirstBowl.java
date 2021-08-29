package bowling.domain.state;

import bowling.domain.Pins;
import java.util.Objects;

public class FirstBowl extends Running {

    private final Pins bowl;

    private FirstBowl(Pins firstBowl) {
        this.bowl = firstBowl;
    }

    public static FirstBowl of(Pins firstBowl) {
        return new FirstBowl(firstBowl);
    }

    public static FirstBowl of(int rolls) {
        return new FirstBowl(Pins.of(rolls));
    }

    @Override
    public State bowl(Pins pins) {
        if (bowl.isSpare(pins)) {
            return Spare.of(bowl, pins);
        }
        return Miss.of(bowl, pins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FirstBowl)) {
            return false;
        }
        FirstBowl firstBowl1 = (FirstBowl) o;
        return Objects.equals(bowl, firstBowl1.bowl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bowl);
    }
}
