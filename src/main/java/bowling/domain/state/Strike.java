package bowling.domain.state;

public class Strike extends Finished {

    private Strike() {
    }

    public static Strike of() {
        return new Strike();
    }

    @Override
    public String description() {
        return "X";
    }
}
