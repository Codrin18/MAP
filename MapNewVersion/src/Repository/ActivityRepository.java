package Repository;

import Domain.Activity;

import java.sql.*;
import java.util.ArrayList;

public class ActivityRepository extends Database {
    public ActivityRepository() {
        super("Activities", "(name STRING PRIMARY KEY,type STRING NOT NULL)");
    }

    public void addActivity(Activity a){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Activities VALUES (?,?)");
            preparedStatement.setString(1,a.getName());
            preparedStatement.setString(2,a.getActivityType());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Activity> getAllActivities(){
        ArrayList<Activity> activities = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Activities");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Activity a = new Activity(resultSet.getString("name"),resultSet.getString("type"));
                activities.add(a);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activities;
    }

    public void deleteActivity(Activity a){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Activities WHERE name=? AND type=?");
            preparedStatement.setString(1,a.getName());
            preparedStatement.setString(2,a.getActivityType());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
