package edu.ntnu.stud.constants;

/**
 * Provides ANSI color codes for console output.
 */
public class Colors {
  public static final String RESET = "\u001B[0m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String GRAY = "\u001B[37m";

  /**
   * Converts a train line identifier to its corresponding color code.
   *
   * @param line The train line identifier (e.g., "L1", "L2").
   * @return The ANSI color code associated with the train line.
   */
  public static String lineToColor(String line) {
    return switch (line) {
      case "L1" -> Colors.BLUE;
      case "L2" -> Colors.PURPLE;
      case "L3" -> Colors.CYAN;
      default -> Colors.GRAY;
    };
  }
}