package bowling.view;

import java.util.Scanner;

public class InputView {

    public static final String NAME_PROMPT = "플레이어 이름은(3 english letters)?: ";
    public static final String FRAME_PROMPT_TEMPLATE = "%d프레임 투구 : ";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String playerName() {
        System.out.print(NAME_PROMPT);
        return scanner.nextLine();
    }

    public static int frameScore(int frameNumber) {
        System.out.printf(FRAME_PROMPT_TEMPLATE, frameNumber);
        return Integer.parseInt(scanner.nextLine());
    }
}
