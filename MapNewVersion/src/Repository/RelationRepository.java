package Repository;

import Domain.Relation;

import java.sql.*;
import java.util.ArrayList;

public class RelationRepository extends Database {
    public RelationRepository() {
        super("Relations","(activity STRING,discipline STRING,formation STRING,room STRING,teacher STRING,date STRING, PRIMARY KEY(activity,formation,room,teacher))");
    }

    public void addRelation(Relation r){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Relations VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,r.getActivity());
            preparedStatement.setString(2,r.getDiscipline());
            preparedStatement.setString(3,r.getFormation());
            preparedStatement.setString(4,r.getRoom());
            preparedStatement.setString(5,r.getTeacher());
            preparedStatement.setString(6,r.getDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Relation> getAllRelations(){
        ArrayList<Relation> relations = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Relations");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Relation r = new Relation(resultSet.getString("activity"),resultSet.getString("discipline"),resultSet.getString("formation"),resultSet.getString("room"),resultSet.getString("teacher"),resultSet.getString("date"));
                relations.add(r);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  relations;
    }

    public void removeRelation(Relation r){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Relations WHERE activity=? AND formation=? AND room=? AND teacher=?");
            preparedStatement.setString(1,r.getActivity());
            preparedStatement.setString(2,r.getFormation());
            preparedStatement.setString(3,r.getRoom());
            preparedStatement.setString(4,r.getTeacher());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
