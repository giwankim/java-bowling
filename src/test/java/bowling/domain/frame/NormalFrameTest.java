package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.state.FirstBowl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NormalFrameTest {

    private Frame frame;

    @BeforeEach
    void setUp() {
        frame = NormalFrame.of(1);
    }

    @Test
    void of_readyState() {
        assertThat(frame.isFinished()).isFalse();
    }

    @Test
    void bowl_strikeNextFrame() {
        frame = frame.bowl(10);
        assertThat(frame).isEqualTo(NormalFrame.of(2));
    }

    @Test
    void bowl_firstBowlCurrentFrame() {
        frame = frame.bowl(5);
        assertThat(frame).isEqualTo(NormalFrame.of(1, FirstBowl.of(5)));
    }
}
