package edu.ntnu.stud;

public class UserInterface {
    public static void displayMenu() {
        System.out.println("============= Main Menu =============");
        System.out.println("1. Display Departure Table");
        System.out.println("2. Create new departure");
        System.out.println("3. Add track to departure");
        System.out.println("4. Add delay to departure");
        System.out.println("5. Find departure by train number");
        System.out.println("6. Find departure by destination");
        System.out.println("7. Change time");
        System.out.println("8. Exit");
        System.out.println("=====================================");
    }

    public static void displayDepartureTable() {
        System.out.println("========== Train Departures ==========");
        displayTrain("L46", "New York", "09:58", "On Time");
        displayTrain("T456", "Chicago", "10:04", "5 min");
        displayTrain("T789", "Los Angeles", "10:16", "On Time");
        displayTrain("L12", "San Francisco", "10:28", "4 min");
        displayTrain("T567", "Miami", "10:41", "On Time");
        displayTrain("T890", "Seattle", "10:48", "On Time");
        System.out.println("======================================");
    }
    public static void displayTrain(String trainNumber, String destination, String departureTime, String delayStatus) {
        if (delayStatus.equals("On Time")) {
            System.out.printf((char) 27 + "[32m%-7s" + (char) 27 + "[39m%-6s %s\n", departureTime, trainNumber,
                    destination);
        } else {
            System.out.printf(
                    (char) 27 + "[33m%-7s" + (char) 27 + "[39m%-6s %-15s" + (char) 27 + "[33m%-7s" + (char) 27 + "[39m%s\n",
                    departureTime, trainNumber, destination, delayStatus, "|10|");
        }
    }
}
