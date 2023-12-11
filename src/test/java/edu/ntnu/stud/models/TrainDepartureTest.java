package edu.ntnu.stud.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class TrainDepartureTest {

  @Nested
  @DisplayName("Positive tests")
  class PositiveTests {
    @Test
    @DisplayName("Test valid construction")
    void testValidConstruction() {
      TrainDeparture trainDeparture1 = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      TrainDeparture trainDeparture2 = new TrainDeparture(
          LocalTime.of(23,0),
          "L2",
          2,
          "Sandnes",
          0,
          10
      );

      assertNotNull(trainDeparture1);
      assertNotNull(trainDeparture2);
    }

    @Test
    @DisplayName("Test get correct departure time")
    void testGetDepartureTime() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      assertEquals(LocalTime.of(10,0), trainDeparture.getDepartureTime());
    }

    @Test
    @DisplayName("Test get correct line")
    void testGetLine() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      assertEquals("L1", trainDeparture.getLine());
    }

    @Test
    @DisplayName("Test get correct train number")
    void testGetTrainNumber() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      assertEquals(1, trainDeparture.getTrainNumber());
    }

    @Test
    @DisplayName("Test get correct destination")
    void testGetDestination() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      assertEquals("Trondheim", trainDeparture.getDestination());
    }

    @Test
    @DisplayName("Test get departure time + delay")
    void testGetDelayedDepartureTime() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          5
      );
      assertEquals(LocalTime.of(10,5), trainDeparture.getDelayedDepartureTime());
    }

    @Test
    @DisplayName("Test get correct track")
    void testSetTrack() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      trainDeparture.setTrack(2);
      assertEquals(2, trainDeparture.getTrack());
    }

    @Test
    @DisplayName("Test get correct delay")
    void testSetDelay() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      trainDeparture.setDelay(5);
      assertEquals(5, trainDeparture.getDelay());
    }

    @Test
    @DisplayName("Test correct toString information")
    void testToString() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      assertEquals(String.format(
          "Departure time: %s, Line: %s, TrainNumber: %d, Destination: %s, Track: %d, Delay: %d min",
          "10:00", "L1", 1, "Trondheim", 1, 0), trainDeparture.toString());
    }
  }

  @Nested
  @DisplayName("Negative tests")
  class NegativeTests {
    @Test
    @DisplayName("Test invalid construction with null values in departure time")
    void testNullDepartureTime() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              null,
              "L3",
              3,
              "Oslo",
              0,
              0)
      );
      assertEquals("Departure time cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with null values in line")
    void testNullLine() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              null,
              3,
              "Oslo",
              0,
              0)
      );
      assertEquals("Line cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with empty string in line")
    void testEmptyLine() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "",
              3,
              "Oslo",
              0,
              0)
      );
      assertEquals("Line cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with null values in destination")
    void testNullDestination() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "L3",
              3,
              null,
              0,
              0)
      );
      assertEquals("Destination cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with empty string in destination")
    void testEmptyDestination() {
      var exception = assertThrows(AssertionError.class, () -> new TrainDeparture(
          LocalTime.of(10,0),
          "L3",
          3,
          "",
          0,
          0
      ));
      assertEquals("Destination cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with 0 and negative number as train number")
    void testInvalidTrainNumber() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "L3",
              0,
              "Oslo",
              0,
              0)
      );
      assertEquals("Train number cannot be less than 1", exception.getMessage());
      exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "L3",
              -1,
              "Oslo",
              0,
              0)
      );
      assertEquals("Train number cannot be less than 1", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with negative track number")
    void testInvalidTrackNumber() {
      var exception = assertThrows(AssertionError.class, () -> new TrainDeparture(
          LocalTime.of(10,0),
          "L3",
          3,
          "Oslo",
          -1,
          0
      ));
      assertEquals("Track number cannot be less than 0", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid construction with too high and negative delay")
    void testInvalidDelay() {
      var exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "L3",
              3,
              "Oslo",
              0,
              301)
      );
      assertEquals("Delay cannot be less than 0 or greater than 300",
          exception.getMessage());
      exception = assertThrows(AssertionError.class,
          () -> new TrainDeparture(
              LocalTime.of(10,0),
              "L3",
              3,
              "Oslo",
              0,
              -1)
      );
      assertEquals("Delay cannot be less than 0 or greater than 300",
          exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid set track")
    void testInvalidSetTrack() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      var exception = assertThrows(AssertionError.class, () -> trainDeparture.setTrack(-1));
      assertEquals("Track number cannot be less than 0", exception.getMessage());
    }

    @Test
    @DisplayName("Test invalid set delay")
    void testInvalidSetDelay() {
      TrainDeparture trainDeparture = new TrainDeparture(
          LocalTime.of(10,0),
          "L1",
          1,
          "Trondheim",
          1,
          0
      );
      var exception = assertThrows(AssertionError.class, () -> trainDeparture.setDelay(-1));
      assertEquals("Delay cannot be less than 0 or greater than 300",
          exception.getMessage());
      exception = assertThrows(AssertionError.class, () -> trainDeparture.setDelay(301));
      assertEquals("Delay cannot be less than 0 or greater than 300",
          exception.getMessage());
    }
  }
}