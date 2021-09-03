package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.pins.Pins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadyTest {

    private State state;

    @BeforeEach
    void setUp() {
        state = Ready.of();
    }

    @Test
    void bowl_strike() {
        State next = state.bowl(Pins.of(10));
        assertThat(next).isInstanceOf(Strike.class);
    }

    @Test
    void bowl() {
        State next = state.bowl(Pins.of(5));
        assertThat(next).isInstanceOf(FirstBowl.class);
    }
}