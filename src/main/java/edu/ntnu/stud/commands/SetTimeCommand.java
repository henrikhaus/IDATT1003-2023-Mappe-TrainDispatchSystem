package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.TIME;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDepartureManager;
import java.time.LocalTime;



/**
 * A command to set the time.
 */
public class SetTimeCommand extends Command {

  /**
   * Constructs a SetTimeCommand.
   */
  public SetTimeCommand() {
    super("time", "Set the time");
  }

  /**
   * Executes the command to set the time.
   * This method will prompt the user for input to set the time.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    LocalTime time = (LocalTime) InputHandler.getUserInput(TIME);
    manager.setCurrentTime(time);
    System.out.printf("Time set successfully to %s.\n", time);
  }
}