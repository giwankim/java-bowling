package bowling.dto;

public class FrameResult {

    private final String description;

    private FrameResult(String description) {
        this.description = description;
    }

    public static FrameResult of(String description) {
        return new FrameResult(description);
    }

    public String getDescription() {
        return description;
    }
}
