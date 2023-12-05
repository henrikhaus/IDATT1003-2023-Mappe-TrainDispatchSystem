package edu.ntnu.stud.input;

import edu.ntnu.stud.constants.Colors;
import edu.ntnu.stud.constants.Regex;
import edu.ntnu.stud.models.TrainDeparture;

import java.time.LocalTime;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    public enum InputType {
        DEPARTURE_TIME,
        LINE,
        TRAIN_NUMBER,
        DESTINATION,
        TRACK,
        DELAY,
    }

    public static Object getUserInput (InputType type) {
        return switch (type) {
            case DEPARTURE_TIME -> getDepartureTimeInput();
            case LINE -> getLineInput();
            case TRAIN_NUMBER -> getTrainNumberInput();
            case DESTINATION -> getDestinationInput();
            case TRACK -> getTrackInput();
            case DELAY -> getDelayInput();
        };
    }

    private static LocalTime getDepartureTimeInput() {
        while (true) {
            System.out.print("Enter departure time: " + Colors.GRAY + "(hh:mm) " + Colors.RESET);
            String input = scanner.nextLine();
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
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Line cannot be empty. Please enter a valid line.");
        }
    }

    private static int getTrainNumberInput() {
        while (true) {
            System.out.print("Enter train number: ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= 1) {
                    return number;
                }
                System.out.println("Train number cannot be less than 1. Please enter a valid train number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number");
            }
        }
    }

    private static String getDestinationInput() {
        while (true) {
            System.out.print("Enter name of destination: ");
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Destination cannot be empty. Please enter a valid destination.");
        }
    }

    private static int getTrackInput() {
        while (true) {
            System.out.print("Enter track number: ");
            String input = scanner.nextLine();
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
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return 0;
            }

            try {
                int delay = Integer.parseInt(input);
                if (delay > 1 && delay < 300) {
                    return delay;
                } else {
                    System.out.println("Please enter a valid delay between 1 and 300 minutes.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number or leave blank.");
            }
        }
    }
}