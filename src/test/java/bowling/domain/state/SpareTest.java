package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidSpareException;
import org.junit.jupiter.api.Test;

class SpareTest {

    @Test
    void of_invalid() {
        assertThatThrownBy(() -> Spare.of(2, 3))
                .isInstanceOf(InvalidSpareException.class);
    }

    @Test
    void description() {
        assertThat(Spare.of(4, 6).description()).isEqualTo("4|/");
    }
}
