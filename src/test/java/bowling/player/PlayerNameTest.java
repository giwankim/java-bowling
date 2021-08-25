package bowling.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bowling.exception.InvalidPlayerNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

    @Test
    void of_NameToUpperCase() {
        PlayerName playerName = PlayerName.of("gwk");
        assertThat(playerName).isEqualTo(PlayerName.of("GWK"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcd", "한글", "a23"})
    void of_InvalidNames(String name) {
        assertThatThrownBy(() -> PlayerName.of(name))
                .isInstanceOf(InvalidPlayerNameException.class);
    }
}
