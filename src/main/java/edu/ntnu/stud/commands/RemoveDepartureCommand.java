package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;

/**
 * <h1>RemoveDepartureCommand</h1>
 * Represents a command to remove a departure.
 */
public class RemoveDepartureCommand extends Command {

  /**
   * Constructs a RemoveDepartureCommand.
   */
  public RemoveDepartureCommand() {
    super("remove", "Remove a departure");
  }

  /**
   * Executes the command to remove a departure.
   * This method will prompt the user for input to remove a departure.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    TrainDeparture departure = getDepartureByTrainNumber(manager);
    manager.removeDeparture(departure);
    System.out.printf("Departure with train number %d successfully removed.%n",
        departure.getTrainNumber());
  }

  private TrainDeparture getDepartureByTrainNumber(TrainDepartureManager manager) {
    TrainDeparture departure = null;
    while (departure == null) {
      int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
      departure = manager.getDepartureByTrainNumber(trainNumber);
      if (departure == null) {
        System.out.printf("No departure with train number %d\n", trainNumber);
      }
    }
    return departure;
  }
}