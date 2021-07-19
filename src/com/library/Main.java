package com.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static List<Log> log = new ArrayList<>();
  public static List<NormalAccount> nAccount = new ArrayList<>();
  public static List<BusinessAccount> bAccount = new ArrayList<>();

  public static void main(String[] args) {
    //List<NormalAccount> normalAccount = new ArrayList<>();
    //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    NormalAccount account1 = new NormalAccount();
    account1.setAccountNo("1");
    account1.setFirstName("John");
    account1.setLastName("Doe");
    account1.setCustomerType("normal");
    account1.setAccountType("normal");
    account1.setBalance(1000);

    nAccount.add(account1);

    NormalAccount account2 = new NormalAccount();
    account2.setAccountNo("2");
    account2.setFirstName("Jane");
    account2.setLastName("Doe");
    account2.setCustomerType("special");
    account2.setAccountType("normal");
    account2.setBalance(2000);

    nAccount.add(account2);

    //List<BusinessAccount> businessAccount = new ArrayList<>();

    BusinessAccount account3 = new BusinessAccount();
    account3.setAccountNo("3");
    account3.setFirstName("Marta");
    account3.setLastName("Cope");
    account3.setCustomerType("normal");
    account3.setAccountType("business");
    account3.setBalance(3000);
    //System.out.println(account3.getFullName());
    bAccount.add(account3);

    BusinessAccount account4 = new BusinessAccount();
    account4.setAccountNo("4");
    account4.setFirstName("Abubakr");
    account4.setLastName("Smyth");
    account4.setCustomerType("special");
    account4.setAccountType("business");
    account4.setBalance(4000);
    //System.out.println(account4.getFullName());
    bAccount.add(account4);

    NormalAccount normalAccount = new NormalAccount();
    normalAccount.depositMoney(50, "1");
    normalAccount.withdrawMoney(50, "1");

    String processType = initialMessage();


    switch (processType) {
      case "1":
        System.out.println("What is your account number?");
        Scanner scannerAccountNumber = new Scanner(System.in);
        String accountNumber = scannerAccountNumber.next();
        System.out.println("How much do you want deposit?");
        Scanner scanner2 = new Scanner(System.in);
        double balance = Double.parseDouble(scanner2.next());
        System.out.println("What is your Account Type?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        System.out.println("3 - Unknown");
        Scanner scannerAccountType = new Scanner(System.in);
        String accountType = scannerAccountNumber.next();
        if (accountType.equals("1")) {
          NormalAccount normalAccount1 = new NormalAccount();
          normalAccount1.depositMoney(balance, accountNumber);
        } else if (accountType.equals("2")) {
          BusinessAccount businessAccount1 = new BusinessAccount();
          businessAccount1.depositMoney(balance, accountNumber);
        } else {

        }

        break;

      case "2":
        System.out.println("What is your account number?");
        Scanner scannerAccountNumber1 = new Scanner(System.in);
        String accountNumber1 = scannerAccountNumber1.next();
        System.out.println("How much do you want withdraw?");
        Scanner scanner3 = new Scanner(System.in);
        double balance1 = Double.parseDouble(scanner3.next());
        System.out.println("What is your Account Type?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        Scanner scannerAccountType1 = new Scanner(System.in);
        String accountType1 = scannerAccountType1.next();
        if (accountType1.equals("1")) {
          NormalAccount normalAccount1 = new NormalAccount();
          normalAccount1.withdrawMoney(balance1, accountNumber1);
        } else if (accountType1.equals("2")) {
          BusinessAccount businessAccount1 = new BusinessAccount();
          businessAccount1.withdrawMoney(balance1, accountNumber1);
        } else {
          System.out.println("Wrong choice!");
        }
        break;

      case "3":
        System.out.println("What is your account number?");
        Scanner scannerAccountNumber2 = new Scanner(System.in);
        String accountNumber2 = scannerAccountNumber2.next();
        System.out.println("What is your Account Type?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        Scanner scannerAccountType2 = new Scanner(System.in);
        String accountType2 = scannerAccountType2.next().toLowerCase();
        if (accountType2.equals("1")) {
          NormalAccount normalAccount1 = new NormalAccount();
          normalAccount1.showMoney(accountNumber2);
        } else if (accountType2.equals("2")) {
          System.out.println("Enter your name : ");
          Scanner scannerName = new Scanner(System.in);
          String name = scannerName.next().toLowerCase();
          BusinessAccount businessAccount1 = new BusinessAccount();
          //String fullName = (businessAccount1.getFirstName().concat(businessAccount1.getLastName())).toLowerCase();
          businessAccount1.showMoney(accountNumber2, name);
        } else {
          System.out.println("Wrong choice!");
        }

        break;
      case "4":

        System.out.println("What is your account number?");
        Scanner scannerAccountNumber3 = new Scanner(System.in);
        String accountNumberSender = scannerAccountNumber3.next();
        System.out.println("What is other account number?");
        Scanner scannerAccountNumber4 = new Scanner(System.in);
        String accountNumberReceiver = scannerAccountNumber4.next();

        System.out.println("Enter the transfer amount?");
        Scanner scannerTransferAmount = new Scanner(System.in);
        String transferAmountString = scannerTransferAmount.next();
        double transferAmount = Double.parseDouble(transferAmountString);

        System.out.println("What is your Account Type?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        Scanner scannerAccountType3 = new Scanner(System.in);
        String accountType3 = scannerAccountType3.next();
        System.out.println("What is other Account Type?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        Scanner scannerAccountType4 = new Scanner(System.in);
        String accountType4 = scannerAccountType4.next();

        if (accountType3.equals("1") && accountType4.equals("1")) {
          NormalAccount normalAccount1 = new NormalAccount();
          normalAccount1.transferMoney1(transferAmount, accountNumberSender, accountNumberReceiver);
        } else if (accountType3.equals("2") && accountType4.equals("2")) {
          BusinessAccount businessAccount1 = new BusinessAccount();
          businessAccount1.transferMoney2(transferAmount, accountNumberSender, accountNumberReceiver);
        } else if (accountType3.equals("1") && accountType4.equals("2")) {
          NormalAccount normalAccount1 = new NormalAccount();
          BusinessAccount businessAccount1 = new BusinessAccount();
          normalAccount1.transferSendMoney3(transferAmount, accountNumberSender);
          businessAccount1.transferReceiveMoney3(transferAmount, accountNumberReceiver);
        } else if (accountType3.equals("2") && accountType4.equals("1")) {
          NormalAccount normalAccount1 = new NormalAccount();
          BusinessAccount businessAccount1 = new BusinessAccount();
          businessAccount1.transferSendMoney4(transferAmount, accountNumberSender);
          normalAccount1.transferReceiveMoney4(transferAmount, accountNumberReceiver);
        } else {
          System.out.println("Wrong choice!");
        }


        break;

      case "5":
        //AccountNumber
        System.out.println("Enter an account number:");
        Scanner scannerNewAccountNumber = new Scanner(System.in);
        String newAccountNumber = scannerNewAccountNumber.next();
        //FirstName
        System.out.println("Enter an your Firstname :");
        Scanner scannerNewFirstName = new Scanner(System.in);
        String newFirstName = scannerNewFirstName.next();
        //LastName
        System.out.println("Enter an your Lastname :");
        Scanner scannerNewLastName = new Scanner(System.in);
        String newLastName = scannerNewLastName.next();
        //CustomerType
        String newCustomerTypeAfter = "Normal";
        System.out.println("Which customer type do you want to create?");
        System.out.println("1 - Normal");
        System.out.println("2 - Special");
        Scanner scannerNewCustomerType = new Scanner(System.in);
        String newCustomerTypeBefore = scannerNewCustomerType.next();
        if (newCustomerTypeBefore.equals("1")) newCustomerTypeAfter = "Normal";
        else if (newCustomerTypeBefore.equals("2")) newCustomerTypeAfter = "Special";
        else System.out.println("Wrong choice!");
        //Balance
        System.out.println("Enter an your balance :");
        Scanner scannerNewBalance = new Scanner(System.in);
        String strNewBalance = scannerNewBalance.next();
        double newBalance = Double.parseDouble(strNewBalance);
        //AccountType
        System.out.println("Which account type do you want to create?");
        System.out.println("1 - Normal");
        System.out.println("2 - Business");
        Scanner scannerNewAccountType = new Scanner(System.in);
        String newAccountType = scannerNewAccountType.next();
        if (newAccountType.equals("1")) {
          NormalAccount newAccount = new NormalAccount();
          newAccount.setAccountNo(newAccountNumber);
          newAccount.setFirstName(newFirstName);
          newAccount.setLastName(newLastName);
          newAccount.setCustomerType(newCustomerTypeAfter);
          newAccount.setAccountType("normal");
          newAccount.setBalance(newBalance);
          nAccount.add(newAccount);
        } else if (newAccountType.equals("2")) {
          BusinessAccount newAccount = new BusinessAccount();
          newAccount.setAccountNo(newAccountNumber);
          newAccount.setFirstName(newFirstName);
          newAccount.setLastName(newLastName);
          newAccount.setCustomerType(newCustomerTypeAfter);
          newAccount.setAccountType("business");
          newAccount.setBalance(newBalance);
          bAccount.add(newAccount);
        }

        break;
      case "6":
        System.out.println("Enter account number?");
        Scanner scannerAccountNumberFilter = new Scanner(System.in);
        String accountNumberFilter = scannerAccountNumberFilter.next();
        System.out.println("Enter First Date : ");
        Scanner scannerFirstDate = new Scanner(System.in);
        String firstDateString = scannerFirstDate.next();
        System.out.println(firstDateString);
        LocalDateTime firstDate = LocalDateTime.parse(firstDateString);
        System.out.println("Enter second Date : ");
        Scanner scannerLastDate = new Scanner(System.in);
        String lastDateString = scannerLastDate.next();
        LocalDateTime lastDate = LocalDateTime.parse(lastDateString);
        Log logInfo = new Log();
        logInfo.showInfo(firstDate, lastDate);
        break;
      default:
        break;
    }


    for (Account item : nAccount) {
      System.out.println(item);
    }
    for (Account item : bAccount) {
      System.out.println(item);
    }
    System.out.println("");
  }

  private static String initialMessage() {
    System.out.println("Please select a transaction.");
    System.out.println("1 - Deposit");
    System.out.println("2 - Withdraw");
    System.out.println("3 - Check Balance");
    System.out.println("4 - Money Transfer");
    System.out.println("5 - Create Account");
    System.out.println("6 - Transaction Informations");
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

}
