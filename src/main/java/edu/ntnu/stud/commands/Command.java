package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

/**
 * <h1>Command</h1>
 * Represents a generic command that can be executed by the user.
 *
 * <p>
 * This class is abstract and should be extended by subclasses to define specific command behaviors.
 * </p>
 */
public abstract class Command {
  private final String name;
  private final String description;

  /**
   * Constructs a new Command with the given name and description.
   *
   * @param name        The name of the command.
   * @param description A brief description of what the command does.
   */
  public Command(String name, String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * Gets the name of the command.
   *
   * @return The name of the command.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description of the command.
   *
   * @return The description of the command.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns a string representation of the command.
   *
   * @return The command name and description formatted as a string.
   */
  @Override
  public String toString() {
    return "%s - %s".formatted(name, description);
  }

  /**
   * Executes the command using the provided TrainDepartureManager.
   * This method should be implemented by subclasses to define specific command behaviors.
   *
   * @param manager The TrainDepartureManager to be used in the command execution.
   */
  public abstract void execute(TrainDepartureManager manager);
}