package bowling.exception;

public class InvalidMissException extends RuntimeException {

    public InvalidMissException() {
        this("두 투구의 합이 미스가 아니라 스패어입니다.");
    }

    public InvalidMissException(String message) {
        super(message);
    }
}
