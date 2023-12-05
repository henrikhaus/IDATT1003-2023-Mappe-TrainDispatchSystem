package edu.ntnu.stud;

import edu.ntnu.stud.commands.*;
import edu.ntnu.stud.models.TrainDepartureManager;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {

    private final TrainDepartureManager manager;
    private final Scanner scanner = new Scanner(System.in);
    private final Command[] commands = generateCommands();

    public TrainDispatchApp() {
        this.manager = new TrainDepartureManager();
    }

    public static void main(String[] args) {
        var app = new TrainDispatchApp();
        app.init();
        app.start();
    }

    public static Command[] generateCommands() {
        return new Command[]{
                new NewDepartureCommand(),
                new SetDelayCommand(),
                new ExitCommand(),
                new ShowDepartureTableCommand(),
                new SetTimeCommand()
        };
    }

    private void init() {
        manager.generateSampleDepartures();
    }

    public void start() {
        while (true) {
            System.out.println("Commands:");
            for (int i = 0; i < commands.length; i++) {
                System.out.printf("[%s] %s - %s%n", i + 1, commands[i].getName(),
                        commands[i].getDescription());
            }
            System.out.print("Input command: ");
            final String command = scanner.nextLine();
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
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
                            () -> System.out.printf("\nUnknown command: \"%s\", try again.%n\n", command
                            ));
        } catch (IndexOutOfBoundsException e) {
            //Invalid index
            System.out.printf("\nPlease input a number 1-%d, or write the command name.\n\n",
                    commands.length);
        }
    }
}