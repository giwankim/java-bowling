package bowling.domain.state;

import bowling.domain.Pins;
import java.util.Objects;

public class Miss extends Finished {

    private final Pins firstBowl;
    private final Pins secondBowl;

    private Miss(Pins firstBowl, Pins secondBowl) {
        validate(firstBowl, secondBowl);
        this.firstBowl = firstBowl;
        this.secondBowl = secondBowl;
    }

    public static Miss of(Pins firstBowl, Pins secondBowl) {
        return new Miss(firstBowl, secondBowl);
    }

    private void validate(Pins firstBowl, Pins secondBowl) {
        if (firstBowl.isSpare(secondBowl)) {
            throw new RuntimeException("두 핀의 합이 스페어입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Miss)) {
            return false;
        }
        Miss miss = (Miss) o;
        return Objects.equals(firstBowl, miss.firstBowl) && Objects.equals(
                secondBowl, miss.secondBowl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstBowl, secondBowl);
    }
}
