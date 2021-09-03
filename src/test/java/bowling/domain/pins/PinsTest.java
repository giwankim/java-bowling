package bowling.domain.pins;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidPinsException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PinsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void of_InvalidNumberOfPins(int numberOfPins) {
        assertThatThrownBy(() -> Pins.of(numberOfPins))
                .isInstanceOf(InvalidPinsException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,true", "9,false"})
    void isStrike(int numberOfPins, boolean expected) {
        assertThat(Pins.of(numberOfPins).isStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,true", "4,false"})
    void isSpare(int roll, boolean expected) {
        Pins pins = Pins.of(5);
        assertThat(pins.isSpare(Pins.of(roll))).isEqualTo(expected);
    }

    @Test
    void description_strike() {
        String description = Pins.of(10).description();
        assertThat(description).isEqualTo("X");
    }

    @Test
    void description_firstBowl() {
        String description = Pins.of(1).description();
        assertThat(description).isEqualTo(String.valueOf(1));
    }

    @Test
    void description_spare() {
        String description = Pins.of(1).description(Pins.of(9));
        assertThat(description).isEqualTo("1|/");
    }

    @Test
    void description_miss() {
        String description = Pins.of(2).description(Pins.of(3));
        assertThat(description).isEqualTo("2|3");
    }
}
