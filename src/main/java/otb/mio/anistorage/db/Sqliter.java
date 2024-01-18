package otb.mio.anistorage.db;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Sqliter
{
    public Connection conn;
    public Statement statmt;
    public ResultSet resSet;

    public String bd_path;

    public Sqliter(String bd_path)
    {
        this.bd_path = bd_path;
        boolean res = this.bd_file();

        try {
            conn();
        } catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex);
        }
    }

    private boolean bd_file()
    {
        try {
            File file = new File(bd_path);
            if (!file.exists()) {
                file.createNewFile();
                conn();
                new_dbase();
            }
            return true;
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void new_dbase()
    {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void conn() throws ClassNotFoundException, SQLException
    {
        if (conn == null || conn.isClosed()) {
            //conn = null;
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+this.bd_path);
            System.out.println("База Подключена!");
        }
    }



}
