public class ConsoleColors {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String INDIGO = "\u001B[38;5;93m";
    public static final String VIOLET = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String GRAY = "\u001B[90m";

    public static void print(String text, String color) {
        String colorCode;
        switch (color.toLowerCase()) {
            case "red":
                colorCode = RED;
                break;
            case "orange":
                colorCode = ORANGE;
                break;
            case "yellow":
                colorCode = YELLOW;
                break;
            case "green":
                colorCode = GREEN;
                break;
            case "blue":
                colorCode = BLUE;
                break;
            case "indigo":
                colorCode = INDIGO;
                break;
            case "violet":
                colorCode = VIOLET;
                break;
            case "cyan":
                colorCode = CYAN;
                break;
            case "magenta":
                colorCode = MAGENTA;
                break;
            case "white":
                colorCode = WHITE;
                break;
            case "black":
                colorCode = BLACK;
                break;
            case "grey":
            case "gray":
                colorCode = GRAY;
                break;
            default:
                colorCode = RESET;
        }
        System.out.print(colorCode + text + RESET);
    }

    public static void println(String text, String color) {
        print(text + "\n", color);
    }

    public static void main(String[] args) {
        // Demonstrate various colors
        println("This is red text", "red");
        println("This is orange text", "orange");
        println("This is yellow text", "yellow");
        println("This is green text", "green");
        println("This is blue text", "blue");
        println("This is indigo text", "indigo");
        println("This is violet text", "violet");
        println("This is cyan text", "cyan");
        println("This is magenta text", "magenta");
        println("This is white text", "white");
        println("This is black text", "black");
        println("This is grey text", "grey");

        // Demonstrate default color
        println("This is default text", "invalid_color");
    }
}
