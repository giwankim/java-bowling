package bowling.domain.state;

public abstract class Playing implements State {

    @Override
    public boolean isFinished() {
        return false;
    }
}
