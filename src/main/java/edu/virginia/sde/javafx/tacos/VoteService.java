package edu.virginia.sde.javafx.tacos;

import java.sql.SQLException;

public class VoteService {
    private DatabaseDriver databaseDriver;

    public VoteService() {
        try {
            databaseDriver = new DatabaseDriver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(HotDogVotes hotDogVotes) {
        try {
            databaseDriver.updateVotes(hotDogVotes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                databaseDriver.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
