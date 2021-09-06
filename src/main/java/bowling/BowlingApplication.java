package bowling;

import bowling.controller.BowlingController;

public class BowlingApplication {

    public static void main(String[] args) {
        BowlingController bowlingController = BowlingController.init();
        bowlingController.run();
    }
}
