package edu.ntnu.stud;

// Single class import instead of * import for checkstyle compliance

import edu.ntnu.stud.commands.Command;
import edu.ntnu.stud.commands.ExitCommand;
import edu.ntnu.stud.commands.FindDepartureCommand;
import edu.ntnu.stud.commands.NewDepartureCommand;
import edu.ntnu.stud.commands.RemoveDepartureCommand;
import edu.ntnu.stud.commands.SetDelayCommand;
import edu.ntnu.stud.commands.SetTimeCommand;
import edu.ntnu.stud.commands.SetTrackCommand;
import edu.ntnu.stud.commands.ShowDepartureTableCommand;
import edu.ntnu.stud.models.TrainDepartureManager;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class for the train dispatch application.
 * This class handles the initialization and execution of the application,
 * including the management of user commands and interaction with the TrainDepartureManager.
 */
public class TrainDispatchApp {
  private final TrainDepartureManager manager;
  private final Scanner scanner = new Scanner(System.in);
  private final Command[] commands = generateCommands();
  private boolean isRunning = true;

  /**
   * Constructs a new TrainDispatchApp.
   * Initializes the train departure manager.
   */
  public TrainDispatchApp() {
    this.manager = new TrainDepartureManager();
  }

  /**
   * Main method for the application.
   * Creates a new TrainDispatchApp and calls init() and start().
   *
   * @param args Command line arguments, not used.
   */
  public static void main(String[] args) {
    var app = new TrainDispatchApp();
    app.init();
    app.start();
  }

  /**
   * Stops the application by setting the running flag to false.
   */
  public void stop() {
    this.isRunning = false;
  }

  private void init() {
    manager.generateSampleDepartures();
  }

  private void start() {
    System.out.println("\nWelcome to the train dispatch application!");
    while (isRunning) {
      delayForReadability();
      displayCommands();
      System.out.print("Input command: ");
      final String command = scanner.nextLine();
      executeCommand(command);
    }
    System.exit(0);
  }

  /**
   * Delays the thread for readability.
   * This method is used to make the application easier to read by adding a delay between
   * commands.
   */
  private void delayForReadability() {
    try {
      Thread.sleep(1200);
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  private void displayCommands() {
    System.out.println("Commands:");
    for (int i = 0; i < commands.length; i++) {
      System.out.printf("[%s] %s - %s%n", i + 1, commands[i].getName(),
          commands[i].getDescription());
    }
  }

  /**
   * Executes the command based on the user input.
   * The command can be specified either by number or by its name.
   *
   * @param command The command input from the user.
   */
  private void executeCommand(String command) {
    try {
      // Attempt to parse the command as an integer (command index)
      int commandIndex = Integer.parseInt(command) - 1;

      commands[commandIndex].execute(manager);
    } catch (NumberFormatException ignored) {
      // If parsing fails, treat the input as a command name
      Arrays.stream(commands)
          .filter(c -> c.getName().equals(command))
          .findFirst()
          .ifPresentOrElse(
              (c) -> c.execute(manager),
              () -> System.out.printf("\nUnknown command: \"%s\", try again.%n\n",
                  command
              ));
    } catch (IndexOutOfBoundsException e) {
      // Handle invalid command indices
      System.out.printf("\nPlease input a number 1-%d, or write the command name.\n\n",
          commands.length);
    }
  }

  private Command[] generateCommands() {
    return new Command[]{
        new ShowDepartureTableCommand(),
        new FindDepartureCommand(),
        new NewDepartureCommand(),
        new RemoveDepartureCommand(),
        new SetTrackCommand(),
        new SetDelayCommand(),
        new SetTimeCommand(),
        new ExitCommand(this),
    };
  }
}