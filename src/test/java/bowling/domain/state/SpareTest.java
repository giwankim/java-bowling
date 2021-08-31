package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.domain.Pins;
import bowling.exception.InvalidSpareException;
import org.junit.jupiter.api.Test;

class SpareTest {

    @Test
    void of_invalid() {
        Pins firstBowl = Pins.of(5);
        Pins secondBowl = Pins.of(6);
        assertThatThrownBy(() -> Spare.of(firstBowl, secondBowl))
                .isInstanceOf(InvalidSpareException.class);
    }

    @Test
    void isFinished() {
        Pins firstBowl = Pins.of(5);
        Pins secondBowl = Pins.of(5);
        State state = Spare.of(firstBowl, secondBowl);
        assertThat(state.isFinished()).isTrue();
    }
}
