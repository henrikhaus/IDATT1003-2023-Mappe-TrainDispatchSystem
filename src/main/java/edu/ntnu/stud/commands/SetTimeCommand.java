package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.TIME;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDepartureManager;
import java.time.LocalTime;

/**
 * <h1>SetTimeCommand</h1>
 * Represents a command to set the time.
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
   * The time must be later than the current time.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    while (true) {
      LocalTime time = (LocalTime) InputHandler.getUserInput(TIME);
      if (time.isAfter(manager.getCurrentTime())) {
        manager.setCurrentTime(time);
        System.out.printf("Time set to %s\n", time);
        break;
      } else {
        System.out.printf("The time must be later than the current time. Current time is %s.\n",
            manager.getCurrentTime());
      }
    }
  }
}