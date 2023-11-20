package edu.ntnu.stud;

import java.time.LocalTime;

public class TrainDeparture {

  private final LocalTime departureTime;
  private final String line;
  private final int trainNumber;
  private final String destination;
  private final String track;
  private final LocalTime delay;

  public TrainDeparture(LocalTime departureTime, String line, int trainNumber, String destination, int track,
      LocalTime delay) {
    this.departureTime = departureTime;
    this.line = line;
    this.trainNumber = trainNumber;
    this.destination = destination;
    this.track = String.valueOf(track);
    this.delay = delay;
  }

  public LocalTime getDepartureTime() {
    return departureTime;
  }

  public String getLine() {
    return line;
  }

  public int getTrainNumber() {
    return trainNumber;
  }

  public String getDestination() {
    return destination;
  }

  public String getTrack() {
    return track;
  }

  public LocalTime getDelay() {
    return delay;
  }
}
