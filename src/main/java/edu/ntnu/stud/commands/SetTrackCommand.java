package edu.ntnu.stud.commands;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;

import static edu.ntnu.stud.input.InputHandler.InputType.TRACK;
import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

/**
 * A command to set a track to a departure.
 */
public class SetTrackCommand extends Command {
  /**
   * Constructs a SetTrackCommand.
   */
  public SetTrackCommand() {
    super("track", "Set a track to a departure");
  }

  /**
   * Executes the command to set a track to a departure.
   * This method will prompt the user for input to set a track to a departure.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    TrainDeparture departure = getDepartureByTrainNumber(manager);
    int track = (int) InputHandler.getUserInput(TRACK);
    manager.setTrack(departure, track);
    System.out.printf("Track for train number %d set to %d.%n", departure.getTrainNumber(), track);
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