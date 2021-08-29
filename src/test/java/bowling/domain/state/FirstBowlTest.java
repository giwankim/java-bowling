package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.Pins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstBowlTest {

    private State firstBowl;

    @BeforeEach
    void setUp() {
        firstBowl = FirstBowl.of(5);
    }

    @Test
    void bowl_spare() {
        State spare = firstBowl.bowl(Pins.of(5));
        assertThat(spare.isFinished()).isTrue();
    }

    @Test
    void bowl_miss() {
        State state = firstBowl.bowl(Pins.of(3));
        assertThat(state.isFinished()).isTrue();
    }
}