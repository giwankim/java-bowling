package bowling.view;

import bowling.dto.FrameResult;
import bowling.dto.FrameResults;
import bowling.player.PlayerName;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class ResultView {

    public static final String SEPARATOR = "|";
    public static final String NAME_HEADER = "| NAME |";
    public static final int WIDTH = 6;

    private ResultView() {
    }

    public static void printFrameResults(PlayerName playerName, FrameResults frameResults) {
        List<String> frameDescriptions = frameResults.getResults()
                .stream()
                .map(FrameResult::getDescription)
                .map(s -> StringUtils.center(s, WIDTH))
                .collect(Collectors.toList());
        while (frameDescriptions.size() < 10) {
            frameDescriptions.add(StringUtils.center(" ", WIDTH));
        }
        String resultsString = String.join(SEPARATOR, frameDescriptions) + SEPARATOR;
        printFrameHeaders();
        printName(playerName);
        System.out.println(resultsString);
    }

    private static void printName(PlayerName playerName) {
        String name = playerName.getName();
        String centeredName = SEPARATOR + StringUtils.center(name, WIDTH) + SEPARATOR;
        System.out.print(centeredName);
    }

    private static void printFrameHeaders() {
        List<String> headers = IntStream.range(1, 11)
                .mapToObj(ResultView::frameNumberToString)
                .collect(Collectors.toList());
        String frameHeader = NAME_HEADER + String.join(SEPARATOR, headers) + SEPARATOR;
        System.out.println(frameHeader);
    }

    private static String frameNumberToString(int frameNumber) {
        String numString = String.format("%02d", frameNumber);
        return StringUtils.center(numString, WIDTH);
    }
}
