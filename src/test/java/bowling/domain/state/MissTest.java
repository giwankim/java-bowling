package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidMissException;
import org.junit.jupiter.api.Test;

class MissTest {

    @Test
    void of_invalid() {
        assertThatThrownBy(() -> Miss.of(4, 6))
                .isInstanceOf(InvalidMissException.class);
    }

    @Test
    void description() {
        assertThat(Miss.of(2, 3).description()).isEqualTo("2 | 3");
    }
}