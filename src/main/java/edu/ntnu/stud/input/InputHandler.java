package edu.ntnu.stud.input;

import edu.ntnu.stud.constants.Colors;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Handles various types of user inputs.
 */
public class InputHandler {
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final int MAX_DELAY_MIN = 300;

  /**
   * Gets user input based on the specified type.
   *
   * @param type The type of input to be retrieved.
   * @return The user input in the appropriate format as an object.
   */
  public static Object getUserInput(InputType type) {
    return switch (type) {
      case TIME -> getTimeInput();
      case LINE -> getLineInput();
      case TRAIN_NUMBER -> getTrainNumberInput();
      case DESTINATION -> getDestinationInput();
      case TRACK -> getTrackInput();
      case DELAY -> getDelayInput();
      case INTEGER -> getIntegerInput();
    };
  }

  private static int getIntegerInput() {
    while (true) {
      System.out.print("Enter number: ");
      String input = SCANNER.nextLine();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please enter a valid number");
      }
    }
  }

  private static LocalTime getTimeInput() {
    while (true) {
      System.out.print("Enter time: " + Colors.GRAY + "(hh:mm) " + Colors.RESET);
      String input = SCANNER.nextLine();
      try {
        return LocalTime.parse(input);
      } catch (Exception e) {
        System.out.println("Invalid input, please enter a valid time format: hh:mm");
      }
    }
  }

  private static String getLineInput() {
    while (true) {
      System.out.print("Enter line: ");
      String input = SCANNER.nextLine();
      if (!input.trim().isEmpty()) {
        return input;
      }
      System.out.println("Line cannot be empty. Please enter a valid line.");
    }
  }

  private static int getTrainNumberInput() {
    while (true) {
      System.out.print("Enter train number: ");
      String input = SCANNER.nextLine();
      try {
        int number = Integer.parseInt(input);
        if (number >= 1) {
          return number;
        }
        System.out.println(
            "Train number cannot be less than 1. Please enter a valid train number.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please enter a valid number.");
      }
    }
  }

  private static String getDestinationInput() {
    while (true) {
      System.out.print("Enter name of destination: ");
      String input = SCANNER.nextLine();
      if (!input.trim().isEmpty()) {
        return input;
      }
      System.out.println("Destination cannot be empty. Please enter a valid destination.");
    }
  }

  private static int getTrackInput() {
    while (true) {
      System.out.print("Enter track number: ");
      String input = SCANNER.nextLine();
      if (input.trim().isEmpty()) {
        return 0;
      }
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please enter a valid number or leave blank.");
      }
    }
  }

  private static int getDelayInput() {
    while (true) {
      System.out.print("Enter delay in minutes: ");
      String input = SCANNER.nextLine().trim();

      if (input.isEmpty()) {
        return 0;
      }

      try {
        int delay = Integer.parseInt(input);
        if (delay >= 0 && delay <= MAX_DELAY_MIN) {
          return delay;
        } else {
          System.out.printf("Please enter a valid delay from 0 to %s minutes.\n", MAX_DELAY_MIN);
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please enter a valid number.");
      }
    }
  }

  /**
   * Enum for the types of input that can be handled.
   */
  public enum InputType {
    TIME,
    LINE,
    TRAIN_NUMBER,
    DESTINATION,
    TRACK,
    DELAY,
    INTEGER
  }
}