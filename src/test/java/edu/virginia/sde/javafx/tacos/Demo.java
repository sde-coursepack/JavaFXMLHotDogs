package edu.virginia.sde.javafx.tacos;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        var hotDogVotes = new HotDogVotes();

        hotDogVotes.setVote("Sandwich", 5);
        hotDogVotes.setVote("Taco", 7);
        hotDogVotes.setVote("Neither", 12);
        hotDogVotes.setVote("Both", 3);

        var databaseDriver = new DatabaseConnection();
        databaseDriver.updateVotes(hotDogVotes);
        databaseDriver.disconnect();
    }
}
