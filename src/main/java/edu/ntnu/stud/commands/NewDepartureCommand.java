package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;
import static edu.ntnu.stud.input.InputHandler.InputType.*;

public class NewDepartureCommand extends Command {
    public NewDepartureCommand() {
        super("new", "Creates a new departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {
        TrainDeparture departure = (TrainDeparture) InputHandler.getUserInput(DEPARTURE);
        manager.addDeparture(departure);
        System.out.println("Departure added successfully");
    }
}
