package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

public class SetDelayCommand extends Command{
    public SetDelayCommand() {
        super("delay", "Gives a delay to a departure");
    }

    @Override
    public void execute(TrainDepartureManager manager) {

    }
}
