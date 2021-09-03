package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidNormalFrameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NormalFrameTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void of_invalidFrameNumber(int frameNumber) {
        assertThatThrownBy(() -> NormalFrame.of(frameNumber))
                .isInstanceOf(InvalidNormalFrameException.class);
    }

}
