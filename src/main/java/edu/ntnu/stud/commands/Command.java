package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;

public abstract class Command {
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "%s - %s".formatted(name, description);
    }

    public abstract void execute(TrainDepartureManager manager);
}
