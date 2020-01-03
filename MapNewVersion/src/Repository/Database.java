package Repository;

import java.sql.*;



public  abstract class Database {
    protected String path;
    protected String tableName;

    protected String tableStructure;

    public Database(String tableName, String tableStructure) {
        this.tableName = tableName;
        this.tableStructure = tableStructure;
        this.path = "jdbc:sqlite:Data/lab.db";
        createConnection();
        createTable();

    }

    public void execute(String exe){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            Statement statement = conn.createStatement();
            statement.execute(exe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnection(){
        try{
            Connection conn = DriverManager.getConnection(this.path);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(){
        this.execute("CREATE TABLE IF NOT EXISTS " + this.tableName + " " + this.tableStructure + ";");
    }
}
