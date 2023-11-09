package edu.virginia.sde.javafx.tacos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {
    public static final String DATABASE_CONNECTION = "jdbc:sqlite:hotdogs.sqlite";

    private Connection connection;

    public DatabaseDriver() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_CONNECTION);
        connection.setAutoCommit(false);
        createTables();

    }

    private void createTables() throws SQLException {
        try {
            var statement = connection.prepareStatement(
                    """
                                CREATE table if not exists VOTES (
                                ID INTEGER PRIMARY KEY,
                                Choice Text UNIQUE NOT NULL,
                                Votes INTEGER NOT NULL
                            );
                            """);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void updateVotes(HotDogVotes hotDogVotes) throws SQLException {
        try {
            var clearStatement = connection.prepareStatement("DELETE FROM VOTES");
            clearStatement.executeUpdate();

            var insertStatement = connection.prepareStatement(
                    """
                            INSERT INTO VOTES(Choice, Votes) 
                                VALUES (?, ?)""");
            for (String choice : HotDogVotes.CHOICES) {
                insertStatement.setString(1, choice);
                insertStatement.setInt(2, hotDogVotes.getVotes(choice));
                insertStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            ;
            throw e;
        }
    }

    public HotDogVotes getVotes() throws SQLException {
        var statement = connection.prepareStatement(
                """
                        SELECT * FROM VOTES;
                        """);
        var hotDotVotes = new HotDogVotes();
        var resultSet = statement.executeQuery();
        while(resultSet.next()) {
            var choice = resultSet.getString("Choice");
            var votes = resultSet.getInt("Votes");
            hotDotVotes.setVote(choice, votes);
        }
        return hotDotVotes;
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
