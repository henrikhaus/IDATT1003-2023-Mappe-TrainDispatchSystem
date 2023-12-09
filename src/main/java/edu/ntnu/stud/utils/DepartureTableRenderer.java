package edu.ntnu.stud.utils;

import edu.ntnu.stud.constants.Colors;
import edu.ntnu.stud.models.TrainDeparture;

import java.time.LocalTime;
import java.util.List;

/**
 * Utility class for rendering a table of train departures.
 */
public class DepartureTableRenderer {

  //Configurable constants
  private static final int SPACING = 2; // Minimum 1
  private static final int TABLE_ROWS = 4; // Minimum 1
  private static final boolean RENDER_EMPTY_ROWS = true;
  private static final String SIDE_FRAME = "|";

  /**
   * Renders a table for a list of train departures.
   *
   * @param departures  The list of train departures sorted by departure time.
   * @param currentTime The current time.
   * @return A string representing the formatted departure table.
   */
  public static String renderDepartureTable(List<TrainDeparture> departures, LocalTime currentTime) {
    StringBuilder output = new StringBuilder();
    int[] headerLengths = departureDetailLengths(departures, true);
    output.append(renderHeader(headerLengths, currentTime));
    int[] departureDetailLengths = departureDetailLengths(departures, false);
    departures.stream()
        .limit(TABLE_ROWS)
        .forEach(departure -> output.append(renderTrainDeparture(departure, departureDetailLengths)));

    if (RENDER_EMPTY_ROWS) {
      output.append(String.valueOf(renderEmptyLine(headerLengths)).repeat(Math.max(0, TABLE_ROWS - departures.size())));
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
        SIDE_FRAME,
        renderDepartureTime,
        renderLine,
        renderDestination,
        renderTrainNumber,
        renderTrack,
        renderDelay,
        SIDE_FRAME + "\n");
  }

  /**
   * Creates a formatted string for an empty row.
   *
   * @param lengths An array of maximum lengths for each column.
   * @return A formatted empty row string.
   */
  private static String renderEmptyLine(int[] lengths) {
    String departureRowFormat = "%-" + SPACING + "s" + Colors.GRAY + " %-" + SPACING + "s" + Colors.RESET + "  %s";

    return String.format(departureRowFormat,
        SIDE_FRAME,
        "-".repeat(lengths[0] + lengths[1] + lengths[2] + lengths[3] + lengths[4] + lengths[5] + SPACING * 6 + 2),
        SIDE_FRAME + "\n");
  }

  /**
   * Creates the header row for the departure table.
   *
   * @param lengths     An array of maximum lengths for each column.
   * @param currentTime The current time.
   * @return A formatted header row string.
   */
  private static String renderHeader(int[] lengths, LocalTime currentTime) {
    String headerFormat = "%-" + SPACING + "s %-"
        + (lengths[0] + SPACING) + "s %-"
        + (lengths[1] + lengths[2] + SPACING - 1) + "s %-"
        + (lengths[3] + SPACING) + "s %-"
        + (lengths[4] + SPACING + 2) + "s %-"
        + (lengths[5] + SPACING)
        + "s %s  " + Colors.GRAY + "(%s)" + Colors.RESET + "\n";
    return String.format(headerFormat,
        SIDE_FRAME,
        "Time",
        "Destination",
        "Train",
        "Track",
        "Delay",
        SIDE_FRAME,
        currentTime);
  }

  /**
   * Calculates the maximum length of details for each column, accounting for ANSI color codes.
   *
   * @param departures The list of train departures.
   * @param header     Flag indicating whether the lengths are for the header.
   * @return An array of maximum lengths for each column.
   */
  private static int[] departureDetailLengths(List<TrainDeparture> departures, boolean header) {
    final int[] lengths = new int[6];
    final int resetCodeLength = (header) ? 0 : Colors.RESET.length(); // Length of resetting ANSI color code
    final int colorCodeLength = (header) ? 0 : Colors.GREEN.length(); // Length of one ANSI color code

    // Minimum lengths for each column
    final int minTimeLength = 3;
    final int minLineLength = 1;
    final int minDestinationLength = 10;
    final int minTrainNumberLength = 4;
    final int minTrackNumberLength = 2;
    final int minDelayLength = 1;

    // Set minimum lengths for each column
    lengths[0] = minTimeLength;
    lengths[1] = minLineLength;
    lengths[2] = minDestinationLength;
    lengths[3] = minTrainNumberLength;
    lengths[4] = minTrackNumberLength;
    lengths[5] = minDelayLength;

    // Find the longest string in each column
    int i = 0;
    for (TrainDeparture departure : departures) {
      lengths[0] = Math.max(lengths[0], departure.getDepartureTime().toString().length());
      lengths[1] = Math.max(lengths[1], departure.getLine().length());
      lengths[2] = Math.max(lengths[2], departure.getDestination().length());
      lengths[3] = Math.max(lengths[3], String.valueOf(departure.getTrainNumber()).length());
      lengths[4] = Math.max(lengths[4], String.valueOf(Math.max(departure.getTrack(), 0)).length());
      lengths[5] = Math.max(lengths[5], String.valueOf(departure.getDelay()).length());

      // Ignore departures after the table limit
      i++;
      if (i >= TABLE_ROWS) {
        break;
      }
    }

    // Adjust lengths for color codes and minimum column widths
    lengths[0] += colorCodeLength;
    lengths[1] += colorCodeLength;
    lengths[2] += resetCodeLength;
    lengths[5] += colorCodeLength + resetCodeLength + 3; // "min" is 3 chars

    return lengths;
  }
}
