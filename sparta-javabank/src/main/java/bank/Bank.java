package bank;

class Bank implements Atm {

    private String password  = "imbankmaster";
    private String bankName = "4조은행";
    private List<Account> AccountsAll; // 계좌목록

    public Bank() {
        this.AccountsAll = new ArrayList<>();
    }

    public getBankName() {
        return bankName;
    } // 은행 이름
    public getBankPassword() {
         return password;
    } // 은행 비밀번호 가져오기 나중에 확인을 위해
    public getAccounts() {
        return AccountsAll;
    }// 전체 계좌 가져오기

    public boolean checkManager(string password) {
        boolean returnValue = false;
        if (this.password.equals(password)) {
            returnVaule = ture;
        }
        return returnValue;
    }// 사용자가 입력한 비밀번호와 지정한 비밀번호 비교하는 함수일치하면 ture, 일치하지않으면 false

    @override
    public void showAccountsAll(String password); {

        if ( Bank.checkManager(password) ) {
            System.out.println("안녕하세요. 현재 생성된 계좌 목록을 아래에 출력합니다."); //checkManger에서 관리자 패스워드 동일시
            for(Account account : AccountsAll){
                System.out.println(account.getowner() + "|"+ account.getaccountNum() +"|"+ account.getbalance());
            }
            System.out.println("-------------------------------------");
        } else {
            System.out.println("비밀번호가 틀렸습니다");
        }

    } //전체 계좌 조회
    public void createAccount(String name, String accountNum, int password) {
        // 계좌번호 중복 조회
        for (Account account : AccountsAll) {
            if (account.getAccountNum().equals(accountNum)) {
                System.out.println("중복된 계좌번호입니다. 다시 설정해주세요.");
                break;
            }
        }
        Account myAccount = new Account(this.bankName, accountNum, name, password, 0);
        AccountsAll.add(myAccount);
        System.out.println(name + "님의 계좌가 생성되었습니다.");
    } // 계좌 생성
    public void removeAccount(Sting owner, String accNum, int password){
        int idx = this.findAccountIndex(owner, accNum);

        Account newAccount = new Account(bankName,accountNum, owner, password, balance)

        Account delAccount = null;
        if(idx != -1) {
            delAccount = AccountsAll.remove(idx);
            System.out.println("계좌 번호 " + delAccount.getAccountNum + " 가 삭제되었습니다.");
        }
        else {
            System.out.println("계좌가 존재하지 않습니다.");
        }
    }

    public int findAccountIndex(String name, String accNum) {
        Iterator<Account> iterator = AccountsAll.iterator();
        while (iterator.hasNext()) {
            Account acc = iterator.next();
            if(acc.getAccountNum().equals(accNum) && acc.getOwner().equals(name)) {
                return AccountsAll.indexOf(acc);
            }
        }
        return -1;
    }
    public Account getMyAccount(String name, String accountNum, int password) {
        for (Account account : AccountsAll) {
            if (account.getOwner().equals(name) && account.getAccountNum().equals(accountNum) && account.getPassword() == password) {
                return account;
            }
        }
        System.out.println("입력한 정보를 다시 확인해주세요.");
        return (Account) Collections.emptyList();
    } // 계좌 검색(찾기)
    public void searchNameAccount(String name) {
        for (Account account : AccountsAll) {
            if (account.getOwner().equals(name)) {
                System.out.println(account.getAccountNum());
                return;
            }
        }
        System.out.println("입력한 이름을 다시 확인해주세요.");
    } // 내 계좌 찾기 (이름)
    public void searchAccountNumAccount(String accountNum) {
        for (Account account : AccountsAll) {
            if (account.getAccountNum().equals(accountNum)) {
                System.out.println(account.getAccountNum());
                return;
            }
        }
        System.out.println("입력한 계좌번호를 다시 확인해주세요.");
    } // 내 계좌 찾기(계좌번호)



}
