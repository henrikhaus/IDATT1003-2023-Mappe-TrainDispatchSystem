package edu.ntnu.stud.utils;

public class Colors {
    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

    public static final String YELLOW = "\u001B[33m";

    public static final String BLUE = "\u001B[34m";

    public static final String PURPLE = "\u001B[35m";

    public static final String CYAN = "\u001B[36m";

    public static final String WHITE = "\u001B[37m";

    public static String lineToColor(String line) {
        return switch (line) {
            case "L1" -> Colors.BLUE;
            case "L2" -> Colors.PURPLE;
            case "L3" -> Colors.CYAN;
            default -> Colors.WHITE;
        };
    }
}