package edu.ntnu.stud.models;

import java.time.LocalTime;

/**
 * Represents a train departure.
 */
public class TrainDeparture {

  private final LocalTime departureTime;
  private final String line;
  private final int trainNumber;
  private final String destination;
  private int track;
  private int delay;

  /**
   * Constructs a new TrainDeparture instance.
   *
   * @param departureTime The time of departure.
   * @param line          The line of the train.
   * @param trainNumber   The train number.
   * @param destination   The train's destination.
   * @param track         The track number.
   * @param delay         The delay in minutes.
   */
  public TrainDeparture(LocalTime departureTime, String line, int trainNumber, String destination,
                        int track, int delay) {
    assert departureTime != null : "Departure time cannot be null";
    assert line != null : "Line cannot be null";
    assert !line.isEmpty() : "Line cannot be empty";
    assert destination != null : "Destination cannot be null";
    assert !destination.isEmpty() : "Destination cannot be empty";
    assert trainNumber > 0 : "Train number cannot be less than 1";
    assert track >= 0 : "Track number cannot be less than 0";
    assert delay < 300 && delay >= 0 : "Delay cannot be less than 0 or greater than 300";

    this.departureTime = departureTime;
    this.line = line;
    this.trainNumber = trainNumber;
    this.destination = destination;
    this.track = track;
    this.delay = delay;
  }

  /**
   * Gets the departure time.
   *
   * @return The time of departure.
   */
  public LocalTime getDepartureTime() {
    return departureTime;
  }

  /**
   * Gets the line of the departure.
   *
   * @return The name of the line.
   */
  public String getLine() {
    return line;
  }

  /**
   * Gets the unique train number of the departure.
   *
   * @return The train number.
   */
  public int getTrainNumber() {
    return trainNumber;
  }

  /**
   * Gets the destination of the departure.
   *
   * @return The name of the destination.
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Gets the track number of the departure.
   *
   * @return The track number.
   */
  public int getTrack() {
    return track;
  }

  /**
   * Gets the delay of the departure.
   *
   * @return The delay in minutes.
   */
  public int getDelay() {
    return delay;
  }

  /**
   * Calculates and returns the new departure time after considering the delay.
   *
   * @return The delayed departure time.
   */
  public LocalTime getDelayedDepartureTime() {
    return departureTime.plusMinutes(delay);
  }

  /**
   * Sets the track number of the departure.
   *
   * @param track The new track number.
   */
  public void setTrack(int track) {
    assert track >= 0 : "Track number cannot be less than 0";
    this.track = track;
  }

  /**
   * Sets the delay of the departure.
   *
   * @param delay The new delay in minutes.
   */
  public void setDelay(int delay) {
    assert delay < 300 && delay >= 0 : "Delay cannot be less than 0 or greater than 300";
    this.delay = delay;
  }

  /**
   * Returns a simple string representation of the departure for testing purposes.
   *
   * @return A string representation of the departure.
   */
  @Override
  public String toString() {
    return String.format(
        "Departure time: %s, Line: %s, TrainNumber: %d, Destination: %s, Track: %d, Delay: %d min",
        departureTime, line, trainNumber, destination, track, delay
    );
  }
}
