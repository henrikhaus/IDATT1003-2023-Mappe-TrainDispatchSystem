package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;

import java.time.LocalTime;

import static edu.ntnu.stud.input.InputHandler.InputType.*;

public class NewDepartureCommand extends Command {
    public NewDepartureCommand() {
        super("new", "Creates a new departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {

        LocalTime departureTime = (LocalTime) InputHandler.getUserInput(DEPARTURE_TIME);
        String line = (String) InputHandler.getUserInput(LINE);

        // Train number must be unique
        int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
        while (manager.getDepartureByTrainNumber(trainNumber) != null) {
            System.out.printf("Train number %d is already in use. ", trainNumber);
            trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
        }

        String destination = (String) InputHandler.getUserInput(DESTINATION);
        int track = (int) InputHandler.getUserInput(TRACK);
        int delay = (int) InputHandler.getUserInput(DELAY);
        TrainDeparture departure = new TrainDeparture(departureTime, line, trainNumber, destination, track, delay);

        manager.addDeparture(departure);
        System.out.println("Departure added successfully");
    }
}
