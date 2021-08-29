package bowling.domain;

import static bowling.domain.Pins.MAX_PINS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidPinsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PinsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void of_InvalidNumberOfPins(int numberOfPins) {
        assertThatThrownBy(() -> Pins.of(numberOfPins))
                .isInstanceOf(InvalidPinsException.class);
    }

    @Test
    void isStrike() {
        assertThat(Pins.of(MAX_PINS).isStrike()).isTrue();
        assertThat(Pins.of(MAX_PINS - 1).isStrike()).isFalse();
    }

    @Test
    void isSpare() {
        Pins pins = Pins.of(5);
        assertThat(pins.isSpare(Pins.of(5))).isTrue();
        assertThat(pins.isSpare(Pins.of(3))).isFalse();
    }
}
