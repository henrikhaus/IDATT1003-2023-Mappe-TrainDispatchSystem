package edu.ntnu.stud.models;

import java.time.LocalTime;

public class TrainDeparture {

    private final LocalTime departureTime;
    private final String line;
    private final int trainNumber;
    private final String destination;
    private int track;
    private int delay;

    public TrainDeparture(LocalTime departureTime, String line, int trainNumber, String destination, int track,
                          int delay) {
        this.departureTime = departureTime;
        this.line = line;
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.track = track;
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

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public LocalTime getDelayedDepartureTime() {
        return departureTime.plusMinutes(delay);
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s", departureTime, line, trainNumber, destination, track, delay);
    }
}
