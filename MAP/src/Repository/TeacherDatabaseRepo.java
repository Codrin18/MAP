package Repository;

import Domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;


public class TeacherDatabaseRepo extends Repository<Teacher> {

    private static final String JDBC_URL = "jdbc:sqlite:data/Lab.db";

    private Connection conn = null;

    public TeacherDatabaseRepo(){
        openConnection();
        createTable();
        init();
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
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers(name varchar(200),rank varchar(200))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init()
    {
        final String[] teachers = new String[]{
                "Mihai|Lecturer",
                "Gabi|Professor",
                "Cosmin|Professor",
                "Andrei|Lecturer",
                "Rares|Professor"
        };

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO teachers VALUES (?,?)");

            for(String s: teachers){
                String [] tokens = s.split("[|]");
                preparedStatement.setString(1,tokens[0]);
                preparedStatement.setString(2,tokens[1]);
                preparedStatement.executeUpdate();

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addElem(Teacher t) {

        try{
            super.addElem(t);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO teachers VALUES (?,?)");
            preparedStatement.setString(1,t.getName());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Teacher> getAllElems() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from teachers");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Teacher t = new Teacher(rs.getString("name"),rs.getString("rank"));
                teachers.add(t);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return teachers;
    }

    public void removeElem(Teacher t){
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE from teachers WHERE name=?");
            preparedStatement.setString(1,t.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
