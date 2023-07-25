import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectivity
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password ="VishvaShyam@1999";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            System.out.println("This is Connected to database");

            ResultSet resultSet=statement.executeQuery("select * from students");
            System.out.println("id"+" "+"name"+" "+"age");
            while (resultSet.next())
            {

                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            }
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
