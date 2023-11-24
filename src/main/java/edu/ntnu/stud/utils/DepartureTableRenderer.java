package edu.ntnu.stud.utils;

import edu.ntnu.stud.models.TrainDeparture;

import java.util.List;

public class DepartureTableRenderer {

    public static String renderDepartureTable(List<TrainDeparture> departures) {
        String output = "";
        int[] lengths = departureDetailLengths(departures);
        output += renderHeader(lengths);
        for (TrainDeparture departure : departures) {
            output += renderTrainDeparture(departure, lengths);
        }
        return output;
    }
    private static String renderTrainDeparture(TrainDeparture departure, int[] lengths) {
        String output = "";
        String renderDepartureTime = ((departure.getDelay() != 0) ? Colors.YELLOW : Colors.GREEN) + departure.getDepartureTime() + Colors.RESET;
        String renderLine = Colors.lineToColor(departure.getLine()) + departure.getLine();
        String renderDestination = departure.getDestination() + Colors.RESET;
        String renderTrainNumber = String.valueOf(departure.getTrainNumber());
        String renderTrack = (departure.getTrack() != -1) ? String.valueOf(departure.getTrack()) : "";
        String renderDelay = ((departure.getDelay() != 0) ? Colors.YELLOW + departure.getDelay() : "") + Colors.RESET;

        output = String.format("%-"+(lengths[0]+10)+"s %-"+(lengths[1]+7)+"s %-"+(lengths[2]+5)+"s %-"+(lengths[3]+1)+"s %-"+(lengths[4])+"s %-"+(lengths[5])+"s\n",
                renderDepartureTime,
                renderLine,
                renderDestination,
                renderTrainNumber,
                renderTrack,
                renderDelay);

        return output;
    }

    private static String renderHeader(int[] lengths) {
        return "%s %s %s %s %s %s\n".formatted("Time", "Line", "Destination", "Train", "Track", "Delay");
    }

    private static int[] departureDetailLengths(List<TrainDeparture> departures) {
        int[] lengths = new int[6];
        for (TrainDeparture departure : departures) {
            lengths[0] = Math.max(lengths[0], departure.getDepartureTime().toString().length());
            lengths[1] = Math.max(lengths[1], departure.getLine().length());
            lengths[2] = Math.max(lengths[2], departure.getDestination().length());
            lengths[3] = Math.max(lengths[3], String.valueOf(departure.getTrainNumber()).length());
            lengths[4] = Math.max(lengths[4], String.valueOf(departure.getTrack()).length());
            lengths[5] = Math.max(lengths[5], String.valueOf(departure.getDelay()).length());
        }
        return lengths;
    }
}