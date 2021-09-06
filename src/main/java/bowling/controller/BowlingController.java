package bowling.controller;

import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.player.PlayerName;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingController {

    private final PlayerName playerName;

    private BowlingController(PlayerName playerName) {
        this.playerName = playerName;
    }

    public static BowlingController init() {
        PlayerName playerName = PlayerName.of(InputView.playerName());
        return new BowlingController(playerName);
    }

    public void run() {
        Frame firstFrame = NormalFrame.of(1);
        ResultView.printFrameResults(playerName, firstFrame.createFrameResults());

        Frame currentFrame = firstFrame;
        while (!isGameOver(currentFrame)) {
            int roll = InputView.frameScore(currentFrame.frameNumber());
            currentFrame = currentFrame.bowl(roll);
            ResultView.printFrameResults(playerName, firstFrame.createFrameResults());
        }
    }

    private static boolean isGameOver(Frame frame) {
        return frame.frameNumber() == FinalFrame.FINAL_FRAME_NUMBER && frame.isFinished();
    }
}
