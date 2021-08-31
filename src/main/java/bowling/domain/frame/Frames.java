package bowling.domain.frame;

import bowling.domain.Pins;
import java.util.ArrayList;
import java.util.List;

public class Frames {

    private final List<Frame> frames;

    private Frames() {
        this.frames = new ArrayList<>();
    }

    private Frames(List<Frame> frames) {
        this.frames = frames;
    }

    public void bowl(Pins roll) {

    }
}
