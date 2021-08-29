package bowling.controller;

import bowling.player.PlayerName;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingController {

    private BowlingController() {
    }

    public static void run() {
        PlayerName playerName = PlayerName.of(InputView.playerName());
        ResultView.printFrameHeaders();
    }
}
