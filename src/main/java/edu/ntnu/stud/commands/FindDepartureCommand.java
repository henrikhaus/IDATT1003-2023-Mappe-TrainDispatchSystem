package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;
import edu.ntnu.stud.utils.DepartureTableRenderer;

import java.util.List;

import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

public class FindDepartureCommand extends Command {
    public FindDepartureCommand() {
        super("find", "Finds a departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {
        System.out.println("How do you want to find the departure?");
        System.out.println("[1] Find departure by train number.");
        System.out.println("[2] Find departure by destination.");
        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = (int) InputHandler.getUserInput(InputHandler.InputType.INTEGER);
            if (choice != 1 && choice != 2) {
                System.out.println("Please choose a number 1 or 2.");
            }
        }

        switch (choice) {
            case 1:
                TrainDeparture departure = null;
                while (departure == null) {
                    int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
                    departure = manager.getDepartureByTrainNumber(trainNumber);
                    if (departure == null) {
                        System.out.printf("No departure with train number %d\n", trainNumber);
                    }
                }
                System.out.println(DepartureTableRenderer.renderDepartureTable(List.of(departure), manager.getCurrentTime()));
                break;
            case 2:
                String destination = (String) InputHandler.getUserInput(InputHandler.InputType.DESTINATION);
                System.out.printf("Departures to %s:\n", destination);
                System.out.println(DepartureTableRenderer.renderDepartureTable(manager.getDeparturesByDestination(destination), manager.getCurrentTime()));
                break;
        }
    }
}
