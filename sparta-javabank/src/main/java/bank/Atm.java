package bank;

public interface Atm {
    void showAccountsAll(String password); //전체 계좌 조회
    void createAccounts(String name, String accountNum, int password); // 계좌 생성
    Account getMyAccount(String name, String accountNum, int password);
    Account getMyAccountWithoutPassword(String accountNum);
    boolean checkManager(String password);
    void removeAccount(String owner, String accNum, int password); // 계좌 삭제
    void searchNameAccount(String name); // 내 계좌 찾기 (이름)
    void searchAccountNumAccount(String accountNum); // 내 계좌 찾기(계좌번호)

}
