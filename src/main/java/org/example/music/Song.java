package org.example.music;

import org.example.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

//Utwórz rekord Song składający się z napisów: artysty i tytułu oraz czasu trwania wyrażonego
// w sekundach. Utwórz klasę Playlist dziedziczącą po ArrayList<Song>.
public record Song(String artist, String title, int timeInSecond) {
    @Override
    public String artist() {
        return artist;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public int timeInSecond() {
        return timeInSecond;
    }

    public static class Persistence{
        public static Optional<Song> read(int id) throws SQLException {
            String sql = "SELECT artist, title, length FROM song WHERE id = ?";
            PreparedStatement statement = DatabaseConnection.getConnection("songs").prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new Song(resultSet.getString("artist"), resultSet.getString("title"), resultSet.getInt("length")));
            }
            return Optional.empty();
        }
    }
}
