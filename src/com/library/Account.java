package com.library;

public abstract class Account {
  String accountNo;
  String firstName;
  String lastName;
  String customerType;
  String accountType;
  double balance;

  public Account() {
    //accountNo = Integer.toString((int) Math.ceil(Math.random() * (999999 - 100000 + 1) + 100000));
  }

  public void depositMoney(String accoountNumer, double money) {
    balance = balance + money - 5;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" +
            "accountNo='" + accountNo + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", customerType='" + customerType + '\'' +
            ", accountType='" + accountType + '\'' +
            ", balance=" + balance +
            '}';
  }
}