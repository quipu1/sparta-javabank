package bank;

public class Account {

    String bank;
    String accountNum;
    String owner;
    int password;
    int balance = 0;


    public Account(String bank, String accountNum, String owner, int password) {
        this.bank = bank;
        this.accountNum = accountNum;
        this.owner = owner;
        this.password = password;
    }

    public String getBank() {
        return bank;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getOwner() {
        return owner;
    }

    public int getPassword() {
        return password;
    }

    public int getBalance() {


        return balance;
    }

    public void deposit(int money) {
        this.balance += money;
        System.out.println("결과: 예금이 완료되었습니다.");
    }

    public boolean withdraw(int money) {
        if (balance < money) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }else {
            this.balance -= money;
            System.out.println("결과: 출금이 완료되었습니다.");
            return true;
        }
    }

    public void changePassword(int password) {
        this.password = password;
    }



}
