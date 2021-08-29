package bowling.domain.frame;

public interface Frame {

    Frame bowl(int roll);
    boolean isFinished();
}
