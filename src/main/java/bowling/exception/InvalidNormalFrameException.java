package bowling.exception;

public class InvalidNormalFrameException extends IllegalArgumentException {

    public InvalidNormalFrameException() {
        this("일반 프레임은 1 ~ 9 프레임입니다.");
    }

    public InvalidNormalFrameException(String s) {
        super(s);
    }
}
