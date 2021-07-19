package com.library;

public class NormalAccount extends Account {
  //Para yatırma
  public void depositMoney(double money, String accountNumber) {
    NormalAccount item = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumber)).findFirst().get();
    item.setBalance(item.getBalance() + money - 3);
    money = -1 * money;
    Log.log("Deposit Money", accountNumber, money);
  }

  //Para Çekme
  public void withdrawMoney(double money, String accountNumber) {
    if (money >= balance) {
      NormalAccount item = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumber)).findFirst().get();
      item.setBalance(item.getBalance() - money);
      System.out.println("Operation successful.");
    } else {
      System.out.println("Your account is inadequate.");
    }
    Log.log("Withdraw Money", accountNumber, money);
  }

  //Bilgileri gösterme
  public void showMoney(String accountNumber) {
    NormalAccount item = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumber)).findFirst().get();
    System.out.println(item.toString());
    System.out.println("Operation successful.");
    Log.log("Show Balance", accountNumber, 0);

  }

  //Para Transfer
  public void transferMoney1(double money, String accountNumberSender, String accountNumberReceiver) {
    NormalAccount item1 = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberSender)).findFirst().get();
    item1.setBalance(item1.getBalance() - money);
    NormalAccount item2 = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberReceiver)).findFirst().get();
    item2.setBalance(item2.getBalance() + money - 2);
    Log.log("Send Money", accountNumberSender, (-1 * (money - 2)));
    Log.log("Receive Money", accountNumberSender, (money - 2));
  }

  public void transferSendMoney3(double money, String accountNumberSender) {
    NormalAccount item1 = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberSender)).findFirst().get();
    item1.setBalance(item1.getBalance() - money);
    Log.log("Send Money", accountNumberSender, (-1 * money));
  }

  public void transferReceiveMoney4(double money, String accountNumberReceiver) {
    NormalAccount item1 = Main.nAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberReceiver)).findFirst().get();
    item1.setBalance(item1.getBalance() + money);
    Log.log("Receive Money", accountNumberReceiver, (money - 1));
  }
}
