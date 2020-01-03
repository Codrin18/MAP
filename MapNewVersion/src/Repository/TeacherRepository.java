package Repository;

import Domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherRepository extends Database {


    public TeacherRepository() {
        super("Teachers", "(name STRING PRIMARY KEY,rank STRING NOT NULL)");
    }

    public void addTeacher(Teacher t){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Teachers VALUES (?,?)");
            preparedStatement.setString(1,t.getName());
            preparedStatement.setString(2,t.getRank());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Teacher> getAllTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Teachers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Teacher t = new Teacher(resultSet.getString("name"),resultSet.getString("rank"));
                teachers.add(t);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  teachers;
    }

    public void removeTeacher(Teacher t){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Teachers WHERE name=?");
            preparedStatement.setString(1,t.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
