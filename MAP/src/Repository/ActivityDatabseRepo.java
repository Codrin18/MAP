package Repository;

import Domain.Activity;
import Domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class ActivityDatabseRepo extends Repository<Activity> {

    private static final String JDBC_URL = "jdbc:sqlite:data/Data.db";

    private Connection conn = null;

    public ActivityDatabseRepo(){
        openConnection();
        createTable();
    }

    public void openConnection(){
        try
        {
            // with DriverManager
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(JDBC_URL);

            // with DataSource
//            SQLiteDataSource ds = new SQLiteDataSource();
//            ds.setUrl(JDBC_URL);
//            if (conn == null || conn.isClosed())
//                conn = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTable(){
        try{
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS activity(name varchar(200),activityType varchar(200))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addElem(Activity a) {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO activity VALUES (?,?)");
            preparedStatement.setString(1,a.getName());
            preparedStatement.setString(2,a.getActivityType());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Activity> getAllElems() {
        ArrayList<Activity> activities = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from activity");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Activity a = new Activity(rs.getString("name"),rs.getString("activityType"));
                activities.add(a);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return activities;
    }
}
