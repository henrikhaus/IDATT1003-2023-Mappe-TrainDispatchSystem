package edu.ntnu.stud.commands;

import edu.ntnu.stud.models.TrainDepartureManager;
import edu.ntnu.stud.utils.DepartureTableRenderer;

public class ShowDepartureTableCommand extends Command{
    public ShowDepartureTableCommand() {
        super("show", "Shows the departure table");
    }
    @Override
    public void execute(TrainDepartureManager manager) {
        System.out.println(DepartureTableRenderer.renderDepartureTable(manager.getDepartures()));
    }
}
