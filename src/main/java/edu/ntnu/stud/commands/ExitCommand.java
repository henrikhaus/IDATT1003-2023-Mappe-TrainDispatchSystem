package edu.ntnu.stud.commands;

import edu.ntnu.stud.TrainDispatchApp;
import edu.ntnu.stud.models.TrainDepartureManager;

/**
 * A command to exit the program.
 */
public class ExitCommand extends Command {
  private final TrainDispatchApp app;

  /**
   * Constructs an ExitCommand.
   */
  public ExitCommand(TrainDispatchApp app) {
    super("exit", "Exits the program");
    this.app = app;
  }

  /**
   * Executes the command to exit the program.
   * This method will terminate the JVM and thus the program.
   *
   * @param manager The TrainDepartureManager instance, not used in this command.
   */
  @Override
  public void execute(TrainDepartureManager manager) {
    System.out.println("Exiting program...");
    app.stop();
  }
}