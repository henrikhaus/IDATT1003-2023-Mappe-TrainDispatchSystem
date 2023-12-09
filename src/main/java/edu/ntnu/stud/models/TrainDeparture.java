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
   * Sets the track number of the departure.
   *
   * @param track The new track number.
   */
  public void setTrack(int track) {
    this.track = track;
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
   * Sets the delay of the departure.
   *
   * @param delay The new delay in minutes.
   */
  public void setDelay(int delay) {
    this.delay = delay;
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
   * Returns a string representation of the departure.
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
