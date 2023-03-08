package services;

import Interface.IBankingManagement;
import utility.DBConnection;
//import java.
import java.sql.Connection;
import java.util.Scanner;

public class BankingManagementImp implements IBankingManagement {
    private static Connection connection = DBConnection.getDbConnection().getConnection();
    @Override
    public void deposit(Scanner scanner) {
        System.out.println("Enter account number");
        int accNumber = scanner.nextInt();
        System.out.println("Enter deposite Money");
        int depositeMoney = scanner.nextInt();
        System.out.println("Enter Id");
        int idNumber = scanner.nextInt();


        DBConnection.deposite(accNumber,depositeMoney,idNumber);
    }

    @Override
    public void withdrawl(Scanner scanner) {
        System.out.println("Enter account number");
        int accNumber = scanner.nextInt();
        System.out.println("Enter withdrawl Money");
        int depositeMoney = scanner.nextInt();
        System.out.println("Enter Id");
        int idNumber = scanner.nextInt();


        DBConnection.withdraw(accNumber,depositeMoney,idNumber);

    }


}
