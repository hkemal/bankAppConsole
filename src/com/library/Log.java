package com.library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Log {
  String processType;
  LocalDateTime date;
  String accountNumber;
  double amount;

  public String getProcessType() {
    return processType;
  }

  public void setProcessType(String processType) {
    this.processType = processType;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public static void log(String processType, String accountNumber, double amount) {
    Log logItem = new Log();
    logItem.setAccountNumber(accountNumber);
    logItem.setAmount(amount);
    logItem.setProcessType(processType);
    logItem.setDate(LocalDateTime.now());
    Main.log.add(logItem);
  }

  public void showInfo(LocalDateTime firstDate, LocalDateTime lastDate) {
    {
      List<Log> newLog = new ArrayList<>();
      newLog = Main.log.stream().filter(x -> x.date.isAfter(firstDate) && x.date.isBefore(lastDate)).collect(Collectors.toList());

      for (Log item : newLog) {
        System.out.println(item.toString());
      }
    }
  }

  @Override
  public String toString() {
    return "Log{" +
            "processType='" + processType + '\'' +
            ", date=" + date +
            ", accountNumber='" + accountNumber + '\'' +
            ", amount=" + amount +
            '}';
  }
}
