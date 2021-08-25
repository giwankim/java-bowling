package bowling.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidRollException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RollTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void of_InvalidNumberOfPins(int numberOfPins) {
        assertThatThrownBy(() -> Roll.of(numberOfPins))
                .isInstanceOf(InvalidRollException.class);
    }
}
