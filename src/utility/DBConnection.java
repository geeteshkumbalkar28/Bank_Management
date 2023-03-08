package utility;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.*;
public class DBConnection {
    private static final DBConnection dbconnection = new DBConnection();
    private static final String user = "root";
    private static final String password = "Geetesh@2000";
    private static final String dbName = "bank_management";
    private static final String hostName = "localhost";

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded .....");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver is missing");
            e.printStackTrace();
        }
    }
    public  static DBConnection getDbConnection()
    {
        return dbconnection;
    }


    public Connection getConnection() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://");
        stringBuilder.append(hostName).append("/").append(dbName);
        String url = stringBuilder.toString();
        System.out.println(url);
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            System.out.println("connection is successfull..");

        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());

        }
        return connection;

    }

    public static void main(String[] args) throws SQLException {
    Connection connection = DBConnection.dbconnection.getConnection();

//    dbconnection.deposite(11111,2000,1);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
//        dbconnection.withdraw(11111,20000,1);
//            Statement statement = connection.createStatement();
//           ResultSet rs = statement.executeQuery("select * from customerDetails");
//        while (rs.next())
//        {
//            System.out.println("address id "+rs.getString("firstname"));
//        }



    }
    public static void deposite(int AccountNumber,int depositeMoney,int id)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = DBConnection.dbconnection.getConnection();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from accountDetails where Account_Number = "+AccountNumber+";");
            int totalMoney=0;
            while (rs.next())
            {
                  totalMoney = rs.getInt("Account_Balance")+depositeMoney;
            }
            statement.close();
            Statement statement1 = connection.createStatement();
            String que = "update accountdetails set Account_Balance = "+totalMoney+" where Customer_Id = "+id+" ;";
            int rowAffect = statement1.executeUpdate(que);
            System.out.println("Deposite money :"+depositeMoney);
            System.out.println("Total money :"+totalMoney);


            connection.close();
        }catch (SQLException e)
        {
            System.out.println("Exception occurs:"+e);
        }

    }

    public static void withdraw(int AccountNumber,int withdraw,int id)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = DBConnection.dbconnection.getConnection();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from accountDetails where Account_Number = "+AccountNumber+";");
            int totalMoney=0;
            while (rs.next())
            {
                totalMoney = rs.getInt("Account_Balance")-withdraw;

            }
            statement.close();
            if(totalMoney>withdraw)
            {

                Statement statement1 = connection.createStatement();
                String que = "update accountdetails set Account_Balance = "+totalMoney+" where Customer_Id = "+id+" ;";
                int rowAffect = statement1.executeUpdate(que);
                System.out.println("withdraw money :"+withdraw);
                System.out.println("Total money :"+totalMoney);

            }
            else
            {
                System.out.println("insufficient balance");

            }

            connection.close();
        }catch (SQLException e)
        {
            System.out.println("Exception occurs:"+e);
        }

    }
}
