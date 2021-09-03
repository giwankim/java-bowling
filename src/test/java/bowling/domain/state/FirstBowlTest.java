package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.pins.Pins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstBowlTest {

    private FirstBowl firstBowl;

    @BeforeEach
    void setUp() {
        firstBowl = FirstBowl.of(5);
    }

    @Test
    void bowl_spare() {
        State next = firstBowl.bowl(Pins.of(5));
        assertThat(next).isInstanceOf(Spare.class);
    }

    @Test
    void bowl_miss() {
        State next = firstBowl.bowl(Pins.of(4));
        assertThat(next).isInstanceOf(Miss.class);
    }

    @Test
    void description() {
        assertThat(firstBowl.description()).isEqualTo("5");
    }
}
