package bowling.domain.state;

public class Strike extends Finished {

    private Strike() {
    }

    public static State of() {
        return new Strike();
    }
}
