package christmas.view;

import christmas.message.MessageProvider;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(MessageProvider message) {
        System.out.println(message.getMessage());
    }
    public static void printMessageWithBlankLine(MessageProvider message) {
        printMessage(message);
        printMessageBlankLine();
    }
    public static <T> void print(T message){
        System.out.println(message);
    }
    public static <T> void printWithBlankLine(T message) {
        print(message);
        printMessageBlankLine();
    }
    public static <T> void printMessagesWithBlankLine(List<T> messages) {
        messages.forEach(System.out::println);
        printMessageBlankLine();
    }
    public static void printMessageBlankLine() {
        System.out.println();
    }
}
