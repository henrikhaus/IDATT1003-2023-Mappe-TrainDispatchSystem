package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;
import edu.ntnu.stud.utils.DepartureTableRenderer;
import java.util.List;

/**
 * <h1>FindDepartureCommand</h1>
 * Represents a command to find a departure.
 */
public class FindDepartureCommand extends Command {

  /**
   * Constructs a FindDepartureCommand.
   */
  public FindDepartureCommand() {
    super("find", "Finds a departure");
  }

  /**
   * Executes the command to find a departure.
   * This method will prompt the user for input to find a departure.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    System.out.println("How do you want to find the departure?");
    System.out.println("[1] Find departure by train number.");
    System.out.println("[2] Find departure by destination.");

    while (true) {
      int choice = (int) InputHandler.getUserInput(InputHandler.InputType.INTEGER);
      switch (choice) {
        case 1:
          findDepartureByTrainNumber(manager);
          return;
        case 2:
          findDepartureByDestination(manager);
          return;
        default:
          System.out.println("Please choose a number 1 or 2.");
          break;
      }
    }
  }

  private void findDepartureByTrainNumber(TrainDepartureManager manager) {
    TrainDeparture departure = null;
    while (departure == null) {
      int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
      departure = manager.getDepartureByTrainNumber(trainNumber);
      if (departure == null) {
        System.out.printf("No departure with train number %d\n", trainNumber);
      }
    }
    System.out.println(DepartureTableRenderer.renderDepartureTable(List.of(departure),
        manager.getCurrentTime()));
  }

  private void findDepartureByDestination(TrainDepartureManager manager) {
    String destination = (String) InputHandler.getUserInput(InputHandler.InputType.DESTINATION);
    List<TrainDeparture> departures = manager.getDeparturesByDestination(destination);
    System.out.printf("\nFound %d departure%s to %s:\n",
        departures.size(),
        (departures.size() == 1) ? "" : "s",
        destination
    );
    System.out.println(DepartureTableRenderer.renderDepartureTable(departures,
        manager.getCurrentTime()));
  }
}