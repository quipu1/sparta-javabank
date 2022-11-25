package bank;

import java.util.regex.Pattern;

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

        // 잔고 조회 메서드() {계좌번호, 소유자 명, 비밀번호 정보 입력}
        return balance;
    }

    public void ChangePassword(int password) {

        //계좌번호, 소유자명, 새로운 비밀번호 입력
        this.password = password;
    }

    public static void ChangeBalanceAmount() {

        //입출금 메서드를 나눠서 만들 때
        //입금 : deposit(String owner, String AccountNum, int money){}
        //출금 : withdraw(String owner, String AccountNum, int money){}

    }

    public void deposit(int money) {
        this.balance += money;
        System.out.println("결과: 예금이 완료되었습니다.");
    }

    public void withdraw(int money) {
        this.balance -= money;
        System.out.println("결과: 출금이 완료되었습니다.");
    }

    public void changePassword(int password) {
        this.password = password;
    }


    public void isAccountNum(String accountNum) {
        String regExp = "([0-9]{6}\\-[0-9,\\-]{6})";

        boolean result = Pattern.matches(regExp, accountNum);
        if (result) {
            System.out.println("계좌번호가 일치합니다"); //숫자 입력한 방식이 계좌 번호 방식(정규식)이 맞는지 먼저 사전에 확인.. 없어도 되는 기능?
        } else {
            System.out.println("계좌번호 입력 방식이 아닙니다"); // 이것도 그냥 계좌번호가 아닙니다로?
        }

    }
}
