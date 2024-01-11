package utils.view;

public class OutputView {
    public final static String STRIKE="스트라이크";
    public final static String BALL="볼";
    public final static String NOTHING="낫싱";

    public static void outputView(String message){
        System.out.print(message);
    }

    public static void resultView(String message){
       System.out.println(message);
    }
}
