package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.DELAY;
import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;

/**
 * A command to set a delay to a departure.
 */
public class SetDelayCommand extends Command {

  /**
   * Constructs a SetDelayCommand.
   */
  public SetDelayCommand() {
    super("delay", "Set a delay to a departure");
  }

  /**
   * Executes the command to set a delay to a departure.
   * This method will prompt the user for input to set a delay to a departure.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    TrainDeparture departure = getDepartureByTrainNumber(manager);
    int delay = (int) InputHandler.getUserInput(DELAY);

    manager.setDelay(departure, delay);
    System.out.printf("Delay for train number %d set to %d minutes.%n",
        departure.getTrainNumber(), delay);
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