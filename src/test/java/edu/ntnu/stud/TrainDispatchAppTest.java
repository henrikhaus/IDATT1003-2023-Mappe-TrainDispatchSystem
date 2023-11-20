package edu.ntnu.stud;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TrainDispatchAppTest {

    @Nested
    @DisplayName("Positive tests for TrainDispatchApp")
    public class PositiveTrainDispatchAppTests {

        @Test
        @DisplayName("Test main method")
        public void testMain() {
            try {
                // TrainDispatchApp.main();
                // assertNotNull(getClass());
            } catch (Exception e) {
                // fail("Exception thrown: " + e.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("Negative tests for TrainDispatchApp")
    public class NegativeTrainDispatchAppTests {

        @Test
        @DisplayName("Test main method")
        public void testMain() {
            try {
                // TrainDispatchApp.main();
                // fail("Exception thrown: " + e.getMessage());
            } catch (Exception e) {
                // assertNotNull(getClass());
            }
        }
    }
}