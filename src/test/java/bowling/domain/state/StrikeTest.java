package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;

class StrikeTest {

    @Test
    void isFinished() {
        State strike = Strike.of();
        assertThat(strike.isFinished()).isTrue();
    }

    @Test
    void bowl_invalid() {
        assertThatThrownBy(() -> Strike.of().bowl(Pins.of(5)))
                .isInstanceOf(RuntimeException.class);
    }
}