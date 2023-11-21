package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit", "Exits the program");
    }


    @Override
    public void execute(TrainDepartureManager manager) {
        System.out.println("Exiting program...");
        System.exit(0);
    }
}
