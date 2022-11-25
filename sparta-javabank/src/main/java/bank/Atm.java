package bank;

public interface Atm {
    void showAccounts(); //전체 계좌 조회
    void createAccounts(String name, String accountNum, int password); // 계좌 생성
    Account getMyAccount(String name, String accountNum, int password)
    boolean checkManager(string password)
    void removeAccount(Sting owner, String accNum, int password) // 계좌 삭제
    void showAccountsAll(String password);
    Account searchNameAccount(String name); // 내 계좌 찾기 (이름)
    Account searchAccountNumAccount(int password); // 내 계좌 찾기(계좌번호)

}
