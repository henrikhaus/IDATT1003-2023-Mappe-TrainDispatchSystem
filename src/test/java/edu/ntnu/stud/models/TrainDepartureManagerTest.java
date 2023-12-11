package edu.ntnu.stud.models;

import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainDepartureManagerTest {
  TrainDepartureManager manager = new TrainDepartureManager();
  @BeforeEach
  void setUp() {
    manager.addDeparture(new TrainDeparture(
        LocalTime.of(11,0),
        "L1",
        1,
        "Trondheim",
        1,
        0
    ));
    manager.addDeparture(new TrainDeparture(
        LocalTime.of(10,0),
        "L2",
        2,
        "Oslo",
        2,
        10
    ));
  }
  @Nested
  @DisplayName("Positive tests")
  class PositiveTests {
    @Test
    @DisplayName("Test getting departures")
    void testGetDepartures() {
      assertEquals(2, manager.getDepartures().size());
    }

    @Test
    @DisplayName("Test correct sort order of departures")
    void testSortOrder() {
      List<TrainDeparture> departures = manager.getDepartures();
      assertEquals(LocalTime.of(10,0), departures.get(0).getDepartureTime());
      assertEquals(LocalTime.of(11,0), departures.get(1).getDepartureTime());
    }

    @Test
    @DisplayName("Test add valid departure")
    void testAddDeparture() {
      manager.addDeparture(new TrainDeparture(
          LocalTime.of(13,30),
          "L3",
          3,
          "Sandnes",
          0,
          2
      ));
      assertEquals(3, manager.getDepartures().size());
    }

    @Test
    @DisplayName("Test get departure by train number")
    void testGetDepartureByTrainNumber() {
      TrainDeparture departureWithTrainNumberOne = manager.getDepartureByTrainNumber(1);
      assertEquals(1, departureWithTrainNumberOne.getTrainNumber());
    }

    @Test
    @DisplayName("Test get departures by destination")
    void testGetDeparturesByDestination() {
      List<TrainDeparture> departuresToTrondheim = manager.getDeparturesByDestination("Trondheim");
      assertEquals(1, departuresToTrondheim.size());
    }

    @Test
    @DisplayName("Test remove departures before a certain time")
    void testRemoveDeparturesBefore() {
      assertEquals(2, manager.getDepartures().size());
      manager.removeDeparturesBefore(LocalTime.of(10,30));
      assertEquals(1, manager.getDepartures().size());
    }

    @Test
    @DisplayName("Test remove departure")
    void testRemoveDeparture() {
      assertEquals(2, manager.getDepartures().size());
      manager.removeDeparture(manager.getDepartures().get(0));
      assertEquals(1, manager.getDepartures().size());
    }

    @Test
    @DisplayName("Test set current time")
    void testSetCurrentTime() {
      manager.setCurrentTime(LocalTime.of(10,30));
      assertEquals(LocalTime.of(10,30), manager.getCurrentTime());
    }

    @Test
    @DisplayName("Test if train number validation is correct")
    void testIsTrainNumberValid() {
      boolean isValid = manager.isTrainNumberValid(1);
      assertFalse(isValid);
      isValid = manager.isTrainNumberValid(100);
      assertTrue(isValid);
    }
  }

  @Nested
  @DisplayName("Negative tests")
  class NegativeTests {
    @Test
    @DisplayName("Test add departure with train number already in use")
    void testInvalidAddDeparture() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.addDeparture(new TrainDeparture(
            LocalTime.of(10,0),
            "L1",
            1,
            "Trondheim",
            1,
            0
        ));
      });
      assertEquals("Train number already in use", exception.getMessage());
    }

    @Test
    @DisplayName("Test add departure with invalid departure time")
    void testInvalidAddDepartureTime() {
      manager.setCurrentTime(LocalTime.of(11,0));
      var exception = assertThrows(AssertionError.class, () -> {
        manager.addDeparture(new TrainDeparture(
            LocalTime.of(10,0),
            "L3",
            3,
            "Oslo",
            0,
            0
        ));
      });
      assertEquals("Departure time cannot be before current time", exception.getMessage());
    }

    @Test
    @DisplayName("Test remove departures before null value")
    void testNullRemoveDeparturesBefore() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.removeDeparturesBefore(null);
      });
      assertEquals("Time cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test remove departure with null value")
    void testNullRemoveDeparture() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.removeDeparture(null);
      });
      assertEquals("Departure cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test remove departure that does not exist")
    void testInvalidRemoveDeparture() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.removeDeparture(new TrainDeparture(
            LocalTime.of(10,0),
            "L10",
            1,
            "Trondheim",
            1,
            0
        ));
      });
      assertEquals("Departure does not exist", exception.getMessage());
    }

    @Test
    @DisplayName("Test setting current time as null")
    void testNullSetCurrentTime() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.setCurrentTime(null);
      });
      assertEquals("Time cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test setting current time before current time")
    void testInvalidSetCurrentTime() {
      var exception = assertThrows(AssertionError.class, () -> {
        manager.setCurrentTime(LocalTime.of(0,0));
      });
      assertEquals("Time cannot be before current time", exception.getMessage());
    }
  }
}