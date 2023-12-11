package edu.ntnu.stud.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>TrainDepartureManager</h1>
 * Manages the collection of train departures, allowing for adding, modifying,
 * and querying departures based on various criteria.
 */
public class TrainDepartureManager {
  private final List<TrainDeparture> departures = new ArrayList<>();
  private LocalTime currentTime = LocalTime.MIN;

  /**
   * Adds a new train departure to the manager.
   *
   * @param departure The TrainDeparture to add.
   */
  public void addDeparture(TrainDeparture departure) {
    assert isTrainNumberValid(departure.getTrainNumber()) : "Train number already in use";
    assert departure.getDepartureTime().isAfter(currentTime)
        : "Departure time cannot be before current time";
    departures.add(departure);
  }

  /**
   * Retrieves all train departures, sorted by departure time.
   *
   * @return A list of sorted TrainDepartures.
   */
  public List<TrainDeparture> getDepartures() {
    departures.sort(Comparator.comparing(TrainDeparture::getDepartureTime));
    return departures;
  }

  /**
   * Finds a train departure by its train number.
   *
   * @param trainNumber The train number to search for.
   * @return The TrainDeparture with the specified number, or null if not found.
   */
  public TrainDeparture getDepartureByTrainNumber(int trainNumber) {
    return departures.stream()
        .filter(departure -> departure.getTrainNumber() == trainNumber)
        .findFirst()
        .orElse(null);
  }

  /**
   * Retrieves all train departures for a specific destination.
   *
   * @param destination The destination to filter the departures.
   * @return A list of TrainDepartures to the specified destination.
   */
  public List<TrainDeparture> getDeparturesByDestination(String destination) {
    List<TrainDeparture> result = new ArrayList<>();
    for (TrainDeparture departure : departures) {
      if (departure.getDestination().equals(destination)) {
        result.add(departure);
      }
    }
    result.sort(Comparator.comparing(TrainDeparture::getDepartureTime));
    return result;
  }

  /**
   * Sets the track for a specific train departure.
   *
   * @param departure The TrainDeparture to modify.
   * @param track     The new track number.
   */
  public void setTrack(TrainDeparture departure, int track) {
    assert track >= 0 : "Track number cannot be less than 0";
    departure.setTrack(track);
  }

  /**
   * Sets the delay for a specific train departure.
   *
   * @param departure The TrainDeparture to modify.
   * @param minutes   The delay in minutes.
   */
  public void setDelay(TrainDeparture departure, int minutes) {
    assert minutes >= 0 : "Delay cannot be less than 0";
    departure.setDelay(minutes);
  }

  /**
   * Removes all train departures that are scheduled to depart before a certain time.
   *
   * @param time The time before which departures should be removed.
   */
  public void removeDeparturesBefore(LocalTime time) {
    assert time != null : "Time cannot be null";
    departures.removeIf(departure -> departure.getDelayedDepartureTime().isBefore(time));
  }

  /**
   * Removes a specific train departure from the manager.
   *
   * @param departure The TrainDeparture to remove.
   */
  public void removeDeparture(TrainDeparture departure) {
    assert departure != null : "Departure cannot be null";
    assert departures.contains(departure) : "Departure does not exist";
    departures.remove(departure);
  }

  /**
   * Gets the current time in the manager.
   *
   * @return The current time.
   */
  public LocalTime getCurrentTime() {
    return currentTime;
  }

  /**
   * Sets the current time and removes any departures that are scheduled before this time.
   *
   * @param time The new current time.
   */
  public void setCurrentTime(LocalTime time) {
    assert time != null : "Time cannot be null";
    assert time.isAfter(currentTime) : "Time cannot be before current time";
    currentTime = time;
    removeDeparturesBefore(currentTime);
  }

  /**
   * Checks if a train number is valid, not already in use.
   *
   * @param trainNumber The train number to check.
   * @return True if the train number is valid, false otherwise.
   */
  public boolean isTrainNumberValid(int trainNumber) {
    return departures.stream().noneMatch(departure -> departure.getTrainNumber() == trainNumber);
  }

  /**
   * Generates a sample set of train departures for testing purposes.
   */
  public void generateSampleDepartures() {
    addDeparture(new TrainDeparture(
        LocalTime.of(11, 1),
        "L1",
        1,
        "Oslo",
        1,
        2)
    );
    addDeparture(new TrainDeparture(
        LocalTime.of(11, 16),
        "L2",
        2,
        "Trondheim",
        4,
        0)
    );
    addDeparture(new TrainDeparture(
        LocalTime.of(11, 48),
        "L3",
        3,
        "Sandnes",
        0,
        40)
    );
    addDeparture(new TrainDeparture(
        LocalTime.of(12, 4),
        "L1",
        4,
        "Kragerø",
        0,
        0)
    );
    addDeparture(new TrainDeparture(
        LocalTime.of(12, 28),
        "L3",
        5,
        "Kristiansand",
        0,
        0)
    );
  }
}
