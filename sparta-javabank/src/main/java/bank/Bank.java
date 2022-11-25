package bank;

import java.util.*;

public class Bank implements Atm {
    private String bankName = “4조은행”;
    private String password = “imbankmaster”;
    List<Account> AccountsAll = new ArrayList<>(); // 계좌 목록

    // 계좌 삭제
    public void removeAccount(Sting owner, String accNum, int password){
        int idx = this.findAccountIndex(owner, accNum, password);
        Account delAccount = null;
        if(idx != -1) {
            delAccount = AccountsAll.remove(idx);
            System.out.println("계좌 번호 " + delAccount.getAccountNum + " 가 삭제되었습니다.");
        }
        else {
            System.out.println("계좌가 존재하지 않습니다.");
        }
    }

    public int findAccountIndex(String name, String accNum, int password) {
        Iterator<Account> iterator = AccountsAll.iterator();
        while (iterator.hasNext()) {
            Account acc = iterator.next();
            if(acc.getAccountNum() == accNum && acc.getOwner() == name) {
                return AccountsAll.indexOf(acc);
            }
        }
        return -1;
    }
}
