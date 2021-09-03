package bowling.player;

import bowling.exception.InvalidPlayerNameException;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class PlayerName {

    public static final int MAX_NAME_LENGTH = 3;
    public static final String VALID_REGEX = String.format("[a-zA-Z]{%d}", MAX_NAME_LENGTH);

    private final String name;

    private PlayerName(String name) {
        validate(name);
        this.name = name.toUpperCase();
    }

    public static PlayerName of(String name) {
        return new PlayerName(name);
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidPlayerNameException("플레이어 이름을 입력해야 합니다.");
        }
        if (!name.matches(VALID_REGEX)) {
            throw new InvalidPlayerNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerName)) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
