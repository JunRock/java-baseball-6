package utils.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void inputMessage(String message){
        System.out.println(message);
    }

    public static String input(){
        return Console.readLine();
    }
}
