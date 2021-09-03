package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StrikeTest {

    @Test
    void description() {
        assertThat(Strike.of().description()).isEqualTo("X");
    }
}
