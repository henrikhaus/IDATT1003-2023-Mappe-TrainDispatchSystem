package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

public class NewDepartureCommand extends Command {
    public NewDepartureCommand() {
        super("new", "Creates a new departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {
        
    }
}
