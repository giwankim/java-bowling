package bowling.view;

import bowling.player.PlayerName;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class ResultView {

    public static final String SEPARATOR = "|";
    public static final String NAME_HEADER = "|  NAME  |";
    public static final int WIDTH = 6;

    private ResultView() {
    }

    public static void printFrameHeaders() {
        System.out.print(NAME_HEADER);
        IntStream.range(1, 11)
                .mapToObj(ResultView::frameNumberToString)
                .forEach(s -> System.out.print(s + SEPARATOR));
    }

    private static String frameNumberToString(int frameNumber) {
        String numString = String.format("%02d", frameNumber);
        return StringUtils.center(numString, WIDTH);
    }

    public static void printStates(PlayerName playerName) {
//        String center = StringUtils.center(playerName.getName(), WIDTH);
//        System.out.println(SEPARATOR + center);
    }
}
