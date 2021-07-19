package com.library;

public class BusinessAccount extends Account {
  double customerPoint;

  String fullName;

  public BusinessAccount() {
    customerPoint = 0;
  }

  public double getCustomerPoint() {
    return customerPoint;
  }

  public String getFullName() {
    return firstName.concat(" " + lastName).toLowerCase();
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setCustomerPoint(double customerPoint) {
    this.customerPoint = customerPoint;
  }

  //Para yatırma
  public void depositMoney(double money, String accountNumber) {
    BusinessAccount item = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumber)).findFirst().get();
    item.setBalance(item.getBalance() + money);
    customerPoint += money / 50;
    Log.log("Deposit Money", accountNumber, money);
  }

  //Para Çekme
  public void withdrawMoney(double money, String accountNumber) {
    if (money >= balance) {
      BusinessAccount item = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumber)).findFirst().get();
      item.setBalance(item.getBalance() - money);
      System.out.println("Operation successful.");
    } else {
      System.out.println("Your account is inadequate.");
    }
    Log.log("Withdraw Money", accountNumber, money);
  }

  //Bilgileri gösterme
  public void showMoney(String accountNumber, String name) {
    BusinessAccount item = Main.bAccount.stream().filter(x -> (x.getAccountNo().equals(accountNumber) && (x.getFirstName().concat(" " + x.getLastName())).toLowerCase().contains(name))).findFirst().get();
    System.out.println(item.toString());
    System.out.println("Operation successful.");
    Log.log("Show Balance", accountNumber, 0);
  }

  //Para Transfer
  public void transferMoney2(double money, String accountNumberSender, String accountNumberReceiver) {
    BusinessAccount item1 = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberSender)).findFirst().get();
    item1.setBalance(item1.getBalance() - money);
    BusinessAccount item2 = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberReceiver)).findFirst().get();
    item2.setBalance(item2.getBalance() + money);
    Log.log("Send Money", accountNumberSender, (-1 * money));
    Log.log("Receive Money", accountNumberSender, money);
  }

  public void transferReceiveMoney3(double money, String accountNumberReceiver) {
    BusinessAccount item1 = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberReceiver)).findFirst().get();
    item1.setBalance(item1.getBalance() + money - 1);
    Log.log("Receive Money", accountNumberReceiver, (money - 1));
  }

  public void transferSendMoney4(double money, String accountNumberSender) {
    BusinessAccount item1 = Main.bAccount.stream().filter(x -> x.getAccountNo().equals(accountNumberSender)).findFirst().get();
    item1.setBalance(item1.getBalance() - money);
    Log.log("Send Money", accountNumberSender, (-1 * money));
  }

  @Override
  public String toString() {
    return "BusinessAccount{" +
            "accountNo='" + accountNo + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", customerType='" + customerType + '\'' +
            ", accountType='" + accountType + '\'' +
            ", balance=" + balance +
            ", customerPoint=" + customerPoint +
            ", fullName='" + fullName + '\'' +
            '}';
  }
}

