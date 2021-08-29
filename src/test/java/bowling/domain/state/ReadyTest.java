package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.Pins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadyTest {

    private State state;

    @BeforeEach
    void setUp() {
        state = Ready.of();
    }

    @Test
    void bowl_firstBowl() {
        State bowl = state.bowl(Pins.of(5));
        assertThat(bowl.isFinished()).isFalse();
    }

    @Test
    void bowl_strike() {
        State strike = state.bowl(Pins.of(Pins.MAX_PINS));
        assertThat(strike.isFinished()).isTrue();
    }
}