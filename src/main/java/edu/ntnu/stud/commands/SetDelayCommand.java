package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;

import java.time.LocalTime;

import static edu.ntnu.stud.input.InputHandler.InputType.*;

public class SetDelayCommand extends Command{
    public SetDelayCommand() {
        super("delay", "Set a delay to a departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {
        TrainDeparture departure = null;
        while (departure == null) {
            int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
            departure = manager.getDepartureByTrainNumber(trainNumber);
            if (departure == null) {
                System.out.printf("No departure with train number %d%n", trainNumber);
            }
        }

        int delay = (int) InputHandler.getUserInput(DELAY);
        manager.setDelay(departure, delay);
        System.out.println("Delay set successfully.");
    }
}
