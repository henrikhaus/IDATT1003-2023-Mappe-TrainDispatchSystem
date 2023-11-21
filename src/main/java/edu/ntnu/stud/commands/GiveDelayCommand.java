package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

public class GiveDelayCommand extends Command{
    public GiveDelayCommand() {
        super("delay", "Gives a delay to a departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {

    }
}
