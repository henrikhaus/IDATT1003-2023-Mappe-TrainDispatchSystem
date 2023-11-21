package edu.ntnu.stud;

import edu.ntnu.stud.commands.Command;
import edu.ntnu.stud.commands.ExitCommand;
import edu.ntnu.stud.commands.GiveDelayCommand;
import edu.ntnu.stud.commands.NewDepartureCommand;
import edu.ntnu.stud.models.TrainDepartureManager;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {

  public TrainDispatchApp() {
    this.manager = new TrainDepartureManager();
  }

  private final TrainDepartureManager manager;
    private final Scanner scanner = new Scanner(System.in);
    private final Command[] commands = generateCommands();

  public static void main(String[] args) {
    var app = new TrainDispatchApp();
    app.init();
    app.start();
  }

  private void init() {
    manager.GenerateSampleDepartures();
  }

  public void start() {
    while (true) {
      System.out.println("\nCommands:");
      for (int i = 0; i < commands.length; i++) {
        System.out.printf("[%s] %s - %s%n", i + 1, commands[i].getName(),
                commands[i].getDescription());
      }
      System.out.println("Input command: ");
      final String command = scanner.nextLine();
      executeCommand(command, scanner);
    }
  }

private void executeCommand(String command, Scanner scanner) {
    try {
        //Find command by index
        int commandIndex = Integer.parseInt(command) - 1;

        commands[commandIndex].execute(manager);
    } catch (NumberFormatException ignored) {
        //Find command by name
        Arrays.stream(commands)
                .filter(c -> c.getName().equals(command))
                .findFirst()
                .ifPresentOrElse(
                        (c) -> c.execute(manager),
                        () -> System.out.printf("Unknown command: \"%s\", try again.%n", command
                        ));
    } catch (IndexOutOfBoundsException e) {
        //Invalid index
        System.out.printf("Please input a number 1-%d, or write the command name.",
                commands.length);
    }
}

  public static Command[] generateCommands() {
      return new Command[] {
              new NewDepartureCommand(),
              new GiveDelayCommand(),
              new ExitCommand()
      };
  }
}