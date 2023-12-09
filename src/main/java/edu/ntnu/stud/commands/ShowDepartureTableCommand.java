package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;
import edu.ntnu.stud.utils.DepartureTableRenderer;

/**
 * A command to show the departure table.
 */
public class ShowDepartureTableCommand extends Command {

  /**
   * Constructs a ShowDepartureTableCommand.
   */
  public ShowDepartureTableCommand() {
    super("show", "Shows the departure table");
  }

  /**
   * Executes the command to show the departure table.
   * This method will print the departure table to the console.
   *
   * @param manager The TrainDepartureManager instance.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    System.out.println(DepartureTableRenderer.renderDepartureTable(manager.getDepartures(),
        manager.getCurrentTime())
    );
  }
}