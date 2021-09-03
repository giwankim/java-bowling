package bowling.exception;

public class FinishedStateException extends RuntimeException {

    public FinishedStateException() {
        this("프레임이 끝난 상태로 투구가 불가능합니다.");
    }

    public FinishedStateException(String message) {
        super(message);
    }
}
