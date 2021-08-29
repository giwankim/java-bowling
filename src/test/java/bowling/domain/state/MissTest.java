package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;

class MissTest {

    @Test
    void of_invalid() {
        Pins firstBowl = Pins.of(5);
        Pins secondBowl = Pins.of(5);
        assertThatThrownBy(() -> Miss.of(firstBowl, secondBowl))
                .isInstanceOf(RuntimeException.class);
    }
}