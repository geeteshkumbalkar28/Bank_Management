package controler;

import services.BankingManagementImp;

import java.util.Scanner;

public class BankingManagementMain {
    private static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        int checkCondition =1;
        BankingManagementImp bankingManagementImp = new BankingManagementImp();
        do {
            System.out.println("1 : Deposit money");
            System.out.println("2 : Withdrawl money");
            checkCondition = SCANNER.nextInt();

            switch (checkCondition)
            {
                case 0:
                    checkCondition = 0;
                break;
                case 1:
                    bankingManagementImp.deposit(SCANNER);
                break;
                case 2:
                    bankingManagementImp.withdrawl(SCANNER);
                break;
            }
        }while (checkCondition!=0);
    }
}


//
//    Bank Management
//    Mentors Fellowship8:17 AM
//        Entity
//        CustomerDetails(Id, firstName, middleName, lastName, mobileNumber);
//        Mentors Fellowship8:18 AM
//        AccountDetails(Id, accountNumber, accountType, balance, branchCode)
//        Operation
//        deposit
//        withdraw
//        Mentors Fellowship8:21 AM
//        Checks should be add like below
//        Check account number exist or not
//        Check balance while withdrawal
//        DURGA PRASAD PRADHAN8:23 AM
//        Mentors Fellowship8:15 AM
//        Bank Management
//        Mentors Fellowship8:17 AM
//        Entity
//        CustomerDetails(Id, firstName, middleName, lastName, mobileNumber);
//        Mentors Fellowship8:18 AM
//        AccountDetails(Id, accountNumber, accountType, balance, branchCode)
//        Operation
//        deposit
//        withdraw
//        Mentors Fellowship8:21 AM
//        Checks should be add like below
//        Check account number exist or not
//        Check balance while withdrawal
//AccountDetails (customerId as foreign key)
