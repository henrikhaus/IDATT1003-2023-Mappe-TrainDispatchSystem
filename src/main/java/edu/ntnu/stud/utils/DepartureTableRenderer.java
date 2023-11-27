package edu.ntnu.stud.utils;

import edu.ntnu.stud.models.TrainDeparture;
import java.util.List;

/**
 * Utility class for rendering a table of train departures.
 */
public class DepartureTableRenderer {

    private static final int SPACING = 2;
    private static final int MIN_TRAIN_NUMBER_LENGTH = 4;
    private static final int MIN_TRACK_NUMBER_LENGTH = 2;
    private static final int MIN_DESTINATION_LENGTH = 10;
    private static final String PIPE = "|";

    /**
     * Renders a table for a list of train departures.
     *
     * @param departures The list of train departures.
     * @return A string representing the formatted departure table.
     */
    public static String renderDepartureTable(List<TrainDeparture> departures) {
        StringBuilder output = new StringBuilder();
        int[] lengths = departureDetailLengths(departures, true);
        output.append(renderHeader(lengths));
        lengths = departureDetailLengths(departures, false);
        for (TrainDeparture departure : departures) {
            output.append(renderTrainDeparture(departure, lengths));
        }
        return output.toString();
    }

    /**
     * Creates a formatted string for a train departure row.
     *
     * @param departure The train departure to format.
     * @param lengths   An array of maximum lengths for each column.
     * @return A formatted departure row string.
     */
    private static String renderTrainDeparture(TrainDeparture departure, int[] lengths) {
        String renderDepartureTime = ((departure.getDelay() != 0) ? Colors.YELLOW : Colors.GREEN)
                + departure.getDepartureTime();
        String renderLine = Colors.lineToColor(departure.getLine()) + departure.getLine();
        String renderDestination = departure.getDestination() + Colors.RESET;
        String renderTrainNumber = String.valueOf(departure.getTrainNumber());
        String renderTrack = (departure.getTrack() > 0) ? String.valueOf(departure.getTrack()) : "";
        String renderDelay = Colors.YELLOW + ((departure.getDelay() != 0) ? departure.getDelay() + " min" : "") + Colors.RESET;

        String departureRowFormat = "%-" + SPACING + "s %-"
                + (lengths[0] + SPACING) + "s %-"
                + (lengths[1]) + "s %-"
                + (lengths[2] + SPACING) + "s %-"
                + (lengths[3] + SPACING) + "s %-"
                + (lengths[4] + SPACING) + "s %-"
                + (lengths[5] + SPACING) + "s %s";

        return String.format(departureRowFormat,
                PIPE,
                renderDepartureTime,
                renderLine,
                renderDestination,
                renderTrainNumber,
                renderTrack,
                renderDelay,
                PIPE + "\n");
    }

    /**
     * Creates the header row for the departure table.
     *
     * @param lengths An array of maximum lengths for each column.
     * @return A formatted header row string.
     */
    private static String renderHeader(int[] lengths) {
        String headerFormat = "%-" + SPACING + "s %-"
                + (lengths[0] + SPACING) + "s %-"
                + (lengths[1] + lengths[2] + SPACING - 1) + "s %-"
                + (lengths[3] + SPACING) + "s %-"
                + (lengths[4] + SPACING + 2) + "s %-"
                + (lengths[5] + SPACING) + "s %s";
        return String.format(headerFormat,
                PIPE,
                "Time",
                "Destination",
                "Train",
                "Track",
                "Delay",
                PIPE + "\n");
    }

    /**
     * Calculates the maximum length of details for each column, accounting for ANSI color codes.
     *
     * @param departures The list of train departures.
     * @param header     Flag indicating whether the lengths are for the header.
     * @return An array of maximum lengths for each column.
     */
    private static int[] departureDetailLengths(List<TrainDeparture> departures, boolean header) {
        int[] lengths = new int[6];
        int resetCodeLength = (header) ? 0 : Colors.RESET.length(); // Length of resetting ANSI color code
        int colorCodeLength = (header) ? 0 : Colors.GREEN.length(); // Length of one ANSI color code

        // Find the longest string in each column
        for (TrainDeparture departure : departures) {
            lengths[0] = Math.max(lengths[0], departure.getDepartureTime().toString().length());
            lengths[1] = Math.max(lengths[1], departure.getLine().length());
            lengths[2] = Math.max(lengths[2], departure.getDestination().length());
            lengths[3] = Math.max(lengths[3], String.valueOf(departure.getTrainNumber()).length());
            lengths[4] = Math.max(lengths[4], String.valueOf(Math.max(departure.getTrack(), 0)).length());
            lengths[5] = Math.max(lengths[5], String.valueOf(departure.getDelay()).length());
        }

        // Adjust lengths for color codes and minimum column widths
        lengths[0] += colorCodeLength;
        lengths[1] += colorCodeLength;
        lengths[2] = Math.max(lengths[2], MIN_DESTINATION_LENGTH) + resetCodeLength;
        lengths[3] = Math.max(lengths[3], MIN_TRAIN_NUMBER_LENGTH);
        lengths[4] = Math.max(lengths[4], MIN_TRACK_NUMBER_LENGTH);
        lengths[5] += colorCodeLength + resetCodeLength + 3; // " min" is 3 chars

        return lengths;
    }
}
