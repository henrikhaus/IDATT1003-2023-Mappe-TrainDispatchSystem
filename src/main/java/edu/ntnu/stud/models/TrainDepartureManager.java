package edu.ntnu.stud.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class TrainDepartureManager {
    private List<TrainDeparture> departures = new ArrayList<>();

    public void addDeparture(TrainDeparture departure) {
        departures.add(departure);
    }

    public List<TrainDeparture> getDepartures() {
        return departures;
    }

public TrainDeparture getDepartureByTrainNumber(int trainNumber) {
        for (TrainDeparture departure : departures) {
            if (departure.getTrainNumber() == trainNumber) {
                return departure;
            }
        }
        return null;
    }

    public List<TrainDeparture> getDeparturesByDestination(String destination) {
        List<TrainDeparture> result = new ArrayList<>();
        for (TrainDeparture departure : departures) {
            if (departure.getDestination().equals(destination)) {
                result.add(departure);
            }
        }
        return result;
    }


    public void setTrack(TrainDeparture departure, int track) {
        departure.setTrack(track);
    }

    public void setDelay(TrainDeparture departure, int minutes) {
        departure.setDelay(minutes);
    }

    public String toString() {
        String result = "";
        for (TrainDeparture departure : departures) {
            result += departure.toString() + "\n";
        }
        return result;
    }

    public void GenerateSampleDepartures(){
        addDeparture(new TrainDeparture(
                LocalTime.of(11,1),
                "L1",
                1,
                "Oslo",
                1,
                2)
        );
        addDeparture(new TrainDeparture(
                LocalTime.of(11,16),
                "L2",
                2,
                "Trondheim",
                4,
                0)
        );
        addDeparture(new TrainDeparture(
                LocalTime.of(11,48),
                "L3",
                3,
                "Sandnes",
                0,
                40)
        );
        addDeparture(new TrainDeparture(
                LocalTime.of(12,4),
                "L1",
                4,
                "Kragerø",
                0,
                0)
        );
        addDeparture(new TrainDeparture(
                LocalTime.of(12,28),
                "L3",
                5,
                "Kristiansand",
                0,
                0)
        );
    }
}
