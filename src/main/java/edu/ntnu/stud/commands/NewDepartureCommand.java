package edu.ntnu.stud.commands;

import static edu.ntnu.stud.input.InputHandler.InputType.DELAY;
import static edu.ntnu.stud.input.InputHandler.InputType.DESTINATION;
import static edu.ntnu.stud.input.InputHandler.InputType.LINE;
import static edu.ntnu.stud.input.InputHandler.InputType.TIME;
import static edu.ntnu.stud.input.InputHandler.InputType.TRACK;
import static edu.ntnu.stud.input.InputHandler.InputType.TRAIN_NUMBER;

import edu.ntnu.stud.constants.Colors;
import edu.ntnu.stud.input.InputHandler;
import edu.ntnu.stud.models.TrainDeparture;
import edu.ntnu.stud.models.TrainDepartureManager;
import java.time.LocalTime;

/**
 * <h1>NewDepartureCommand</h1>
 * Represents a command to create a new departure.
 */
public class NewDepartureCommand extends Command {

  /**
   * Constructs a NewDepartureCommand.
   */
  public NewDepartureCommand() {
    super("new", "Creates a new departure");
  }

  /**
   * Executes the command to create a new departure.
   * This method will prompt the user for input to create a new departure.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {

    LocalTime departureTime = getValidDepartureTime(manager);
    String line = (String) InputHandler.getUserInput(LINE);
    int trainNumber = getUniqueTrainNumber(manager);
    String destination = (String) InputHandler.getUserInput(DESTINATION);
    System.out.print(Colors.GRAY + "(Optional) " + Colors.RESET);
    int track = (int) InputHandler.getUserInput(TRACK);
    System.out.print(Colors.GRAY + "(Optional) " + Colors.RESET);
    int delay = (int) InputHandler.getUserInput(DELAY);

    TrainDeparture departure = new TrainDeparture(departureTime, line, trainNumber, destination,
        track, delay);
    manager.addDeparture(departure);
    System.out.println("Departure added successfully");
  }

  private LocalTime getValidDepartureTime(TrainDepartureManager manager) {
    LocalTime departureTime = (LocalTime) InputHandler.getUserInput(TIME);
    while (departureTime.isBefore(manager.getCurrentTime())) {
      System.out.printf("Departure time cannot be before current time: %s\n",
          manager.getCurrentTime());
      departureTime = (LocalTime) InputHandler.getUserInput(TIME);
    }
    return departureTime;
  }

  private int getUniqueTrainNumber(TrainDepartureManager manager) {
    int trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
    while (!manager.isTrainNumberValid(trainNumber)) {
      System.out.printf("Train number %d is already in use. ", trainNumber);
      trainNumber = (int) InputHandler.getUserInput(TRAIN_NUMBER);
    }
    return trainNumber;
  }
}