package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDepartureManager;

import java.time.LocalTime;

import static edu.ntnu.stud.input.InputHandler.InputType.TIME;

public class SetTimeCommand extends Command {
    public SetTimeCommand() {
        super("time", "Set the time");
    }

    @Override
    public void execute(TrainDepartureManager manager) {
        LocalTime time = (LocalTime) InputHandler.getUserInput(TIME);
        manager.setCurrentTime(time);
        System.out.println("Time set successfully.");
    }
}
