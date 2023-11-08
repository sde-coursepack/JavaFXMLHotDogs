package edu.virginia.sde.javafx.tacos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HotDogVotesTest {
    @ParameterizedTest
    @ValueSource(strings = {"Sandwich", "Taco", "Both", "Neither"})
    void getVotes_initial(String category) {
        var hotDogVotes = new HotDogVotes();
        assertEquals(0, hotDogVotes.getVotes(category));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sandwich", "Taco", "Both", "Neither"})
    void addVote(String category) {
        var hotDogVotes = new HotDogVotes();
        hotDogVotes.addVote(category);
        assertEquals(1, hotDogVotes.getVotes(category));
    }

    @Test
    void getVotes_exception() {
        var hotDogVotes = new HotDogVotes();
        assertThrows(NullPointerException.class, () -> hotDogVotes.getVotes("not a valid category"));
    }

    @Test
    void addVotes_exception() {
        var hotDogVotes = new HotDogVotes();
        assertThrows(IllegalArgumentException.class, () -> hotDogVotes.addVote("not a valid category"));
    }
}