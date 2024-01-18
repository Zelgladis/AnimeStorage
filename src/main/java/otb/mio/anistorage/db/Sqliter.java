package otb.mio.anistorage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Sqliter
{
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public Sqliter()
    {
        try {
            conn();
        } catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex);
        }
    }
    public static void conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:data/bd/AlohaAnime.db");

        System.out.println("База Подключена!");
    }
}
