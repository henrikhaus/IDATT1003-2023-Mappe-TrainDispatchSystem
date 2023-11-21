package edu.ntnu.stud.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class TrainDepartureManager {
    private List<TrainDeparture> departures = new ArrayList<TrainDeparture>();

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
        List<TrainDeparture> result = new ArrayList<TrainDeparture>();
        for (TrainDeparture departure : departures) {
            if (departure.getDestination().equals(destination)) {
                result.add(departure);
            }
        }
        return result;
    }


    public void setTrack(TrainDeparture departure, String track) {
        departure.setTrack(track);
    }

    public void setDelay(TrainDeparture departure, int minutes) {
        departure.setDelay(departure.getDelay() + minutes);
    }

    public void GenerateSampleDepartures(){
        addDeparture(new TrainDeparture(LocalTime.of(11,0), "l4", 1, "Oslo", 2, 0));
    }

    public String toString() {
        String result = "";
        for (TrainDeparture departure : departures) {
            result += departure.toString() + "\n";
        }
        return result;
    }
}
