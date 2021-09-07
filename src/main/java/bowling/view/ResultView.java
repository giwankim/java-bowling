package bowling.view;

import bowling.dto.FrameResult;
import bowling.dto.FrameResults;
import bowling.player.PlayerName;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class ResultView {

    public static final int WIDTH = 6;
    public static final String NUMBER_FORMAT = "%02d";
    public static final String SEPARATOR = "|";
    public static final String NAME_PREFIX = "| NAME ";
    public static final String SPACES = StringUtils.repeat(" ", WIDTH);

    private ResultView() {
    }

    public static void printScoreBoard(PlayerName playerName, FrameResults frameResults) {
        printHeaderRow();
        printFrameResults(playerName, frameResults);
    }

    private static void printHeaderRow() {
        String headerRow = IntStream.range(1, 11)
                .mapToObj(ResultView::frameNumberToString)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(NAME_PREFIX + wrapSeparators(headerRow));
    }

    private static void printFrameResults(PlayerName playerName, FrameResults frameResults) {
        System.out.println(playerNamePrefix(playerName) + frameResultsToString(frameResults));
    }

    private static String frameResultsToString(FrameResults frameResults) {
        List<String> descriptions = frameResults.getResults()
                .stream()
                .map(FrameResult::getDescription)
                .map(s -> StringUtils.center(s, WIDTH))
                .collect(Collectors.toList());
        while (descriptions.size() < 10) {
            descriptions.add(SPACES);
        }
        return wrapSeparators(String.join(SEPARATOR, descriptions));
    }

    private static String playerNamePrefix(PlayerName playerName) {
        String name = playerName.getName();
        return SEPARATOR + StringUtils.center(name, WIDTH);
    }

    private static String frameNumberToString(int frameNumber) {
        String numberString = String.format(NUMBER_FORMAT, frameNumber);
        return StringUtils.center(numberString, WIDTH);
    }

    private static String wrapSeparators(String string) {
        return SEPARATOR + string + SEPARATOR;
    }
}
