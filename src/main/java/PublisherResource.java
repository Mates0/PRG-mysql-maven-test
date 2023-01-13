import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;

@Named
@RequestScoped
public class PublisherResource {
    public ArrayList<String> getPublishers() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT p.publisher_name FROM publisher AS p")
                ) {
            ArrayList<String> publishers = new ArrayList<>();

            while(resultSet.next()) {
                publishers.add(resultSet.getString(1));
            }
            return publishers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Publisher> getPublisherDetails() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT s.superhero_name, s.full_name, s.gender_id, s.race_id, s.publisher_id FROM superhero AS s")
        ) {
            ArrayList<Publisher> publisherdetails = new ArrayList<>();

            while(resultSet.next()) {
                publisherdetails.add(new Publisher(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5)));
            }
            return publisherdetails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Integer> getHeroesCount() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(s.publisher_id) FROM superhero AS s")
        ) {
            ArrayList<Integer> countofheroes = new ArrayList<>();
            while (resultSet.next()) {
                countofheroes.add(resultSet.getInt(1));
            }
            return countofheroes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
