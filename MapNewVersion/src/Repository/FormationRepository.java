package Repository;

import Domain.Formation;

import java.sql.*;

import java.util.ArrayList;

public class FormationRepository extends Database {
    public FormationRepository() {
        super("Formations","(name STRING PRIMARY KEY)");
    }

    public void addFormation(Formation f){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Formations VALUES(?)");
            preparedStatement.setString(1,f.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Formation> getAllFormations(){
        ArrayList<Formation> formations = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Formations");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Formation f = new Formation(resultSet.getString("name"));
                formations.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }

    public void deleteFormation(Formation f){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Formations WHERE name=?");
            preparedStatement.setString(1,f.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
