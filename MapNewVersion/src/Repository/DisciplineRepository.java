package Repository;

import Domain.Discipline;

import java.sql.*;
import java.util.ArrayList;

public class DisciplineRepository extends Database {
    public DisciplineRepository() {
        super("Disciplines","(name STRING PRIMARY KEY");
    }

    public void addDiscipline(Discipline d){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Disciplines VALUES(?)");
            preparedStatement.setString(1,d.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Discipline> getAllDisciplines(){
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Disciplines");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Discipline d = new Discipline(resultSet.getString("name"));
                disciplines.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public void deleteDiscipline(Discipline d){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Disciplines WHERE name=?");
            preparedStatement.setString(1,d.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
