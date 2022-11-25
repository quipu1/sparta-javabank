package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionalInformation {
    String date;
    String time;
    String accountNum;
    int availability;
    int transactionAmount;
    String bank = "4조 은행";

    public TransactionalInformation(String accountNum, int availability, int transactionAmount) {
        this.date = setDate();
        this.time = setTime();
        this.accountNum = accountNum;
        this.availability = availability;
        this.transactionAmount = transactionAmount;
    }
    public String setDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
    public String getDate(){return date;}
    public String setTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH-mm");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
    public String getTime(){return time;}
    public String getAccountNum(){return this.accountNum;}

    public String getAvailability(){
        if(this.availability==1){
            return "입금";
        }else{
            return "출금";
        }
    }

    public int getTransactionAmount(){return this.transactionAmount;}

    public String getBank(){return bank;}
}
