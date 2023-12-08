package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

/**
 * A command to exit the program.
 */
public class ExitCommand extends Command {

    /**
     * Constructs an ExitCommand.
     */
    public ExitCommand() {
        super("exit", "Exits the program");
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
        System.exit(0);
    }
}
