package edu.ntnu.stud;

public class UserInterface {
    public static void start() {
        System.out.println("Welcome to the train dispatch system!");
    }

    public static void init() {

    }

    public static void displayDepartureTable() {
        System.out.println("======== Train Departures ========");
        displayTrain("L46", "New York", "09:58", "On Time");
        displayTrain("T456", "Chicago", "10:04", "5 min");
        displayTrain("T789", "Los Angeles", "10:16", "On Time");
        displayTrain("L12", "San Francisco", "10:28", "4 min");
        displayTrain("T567", "Miami", "10:41", "On Time");
        displayTrain("T890", "Seattle", "10:48", "On Time");
        System.out.println("==================================");
    }
    public static void displayTrain(String trainNumber, String destination, String departureTime, String delayStatus) {
        if (delayStatus.equals("On Time")) {
            System.out.printf((char) 27 + "[32m%-7s" + (char) 27 + "[39m%-6s %s\n", departureTime, trainNumber,
                    destination);
        } else {
            System.out.printf(
                    (char) 27 + "[33m%-7s" + (char) 27 + "[39m%-6s %-15s" + (char) 27 + "[33m%s\n" + (char) 27 + "[39m",
                    departureTime, trainNumber, destination, delayStatus);
        }
    }
}
