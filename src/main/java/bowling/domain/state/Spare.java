package bowling.domain.state;

import bowling.domain.Pins;
import java.util.Objects;

public class Spare extends Finished {

    private final Pins firstBowl;
    private final Pins secondBowl;

    private Spare(Pins firstBowl, Pins secondBowl) {
        validate(firstBowl, secondBowl);
        this.firstBowl = firstBowl;
        this.secondBowl = secondBowl;
    }

    public static Spare of(Pins firstBowl, Pins secondBowl) {
        return new Spare(firstBowl, secondBowl);
    }

    private void validate(Pins firstBowl, Pins secondBowl) {
        if (!firstBowl.isSpare(secondBowl)) {
            throw new RuntimeException("핀들의 합이 스페어가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Spare)) {
            return false;
        }
        Spare spare = (Spare) o;
        return Objects.equals(firstBowl, spare.firstBowl) && Objects.equals(
                secondBowl, spare.secondBowl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstBowl, secondBowl);
    }
}
