package bank;

import bank.presentation.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    pubic static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        TransactionalInformationList transactionalInformationList = new TransactionalInformationList();

        while(true) {
            StartInterface.run();
            System.out.print("입력 > ");
            String input = scanner.next();
            switch (input) {
                case "1":
                    System.out.print("계좌 번호: ");
                    String accNum = scanner.nextLine();
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("비밀번호: ");
                    int password = scanner.nextInt();
                    //Bank 객체에서 계좌 생성하는 메서드
                    bank.createAccounts(name, accNum, password);
                    break;
                // 계좌 조회 (내 계좌 찾기)
                case "2":
                    // 계좌찾기 UI 가져오기
                    LookupInterface.run();
                    int input = scanner.nextInt();
                    // 1 입력 - 계좌번호로 내 계좌 찾기
                    // 2 입력 - 이름으로 내 계좌 찾기
                    if (input == 1) {
                        System.out.println("계좌번호로 내 계좌 찾기");
                        System.out.println("계좌번호를 입력해주세요.");
                        System.out.println("계좌번호: ");
                        String accountnum = scanner.next();
                        bank.searchAccountnumAccount(accountnum);
                        break;
                    } else if (input == 2) {
                        System.out.println("이름으로 내 계좌 찾기");
                        System.out.println("소유주 명을 입력해주세요.");
                        System.out.println("계좌 소유주 명: ");
                        String owner = scanner.next();
                        bank.searchAccountnumAccount(owner);
                        break;
                    } else {
                        System.out.println("잘못 입력하셨습니다.");
                        break;
                    }
                case "3":
                    System.out.println("본인확인을 위해 아래의 정보를 입력해주세요.");
                    System.out.print("계좌 번호: ");
                    String accNum3 = scanner.nextLine();
                    System.out.print("이름: ");
                    String name3 = scanner.nextLine();
                    System.out.print("비밀번호: ");
                    int password3 = scanner.nextInt();
                    Account myAccount = bank.getMyAccount(name3,accNum3, password3);
                    ManagementInterface.run();
                    System.out.print("입력 >");
                    int selectNum = scanner.nextInt();
                    while(True) {
                        if(selectNum == 1) {
                            // 비밀번호 수정
                            System.out.print("새로운 비밀번호를 입력해주세요: ");
                            int newPassword = scanner.nextInt();
                            myAccount.changePassword(int newPassword);
                        } else if (selectNum == 2) {
                            // 계좌 삭제
                            System.out.print("확인을 위해 비밀번호를 다시 입력해주세요: ");
                            int password = scanner.nextInt();
                            if(myAccount.getPassword == password) {
                                Account deleted = bank.removeAccount(name3, accNum3, password3);
                                System.out.println("계좌" + deleted.getAccountNum()+ "가 삭제되었습니다.");
                            }
                            System.out.println("비밀번호를 틀렸습니다.");
                        } else if (selectNum == 3) {
                            // 잔고 조회
                            System.out.println("잔고: "+ myAccount.getBalance());
                        } else if (selectNum == 4) {
                            // 거래내역 조회
                            System.out.println("안녕하세요. 거래내역을 아래에 출력합니다.");
                            transactionalInformationList.getTransaction(accNum3,name3, password3);
                        } else {
                            // 예외(주어진 숫자 외의 값을 입력했을 경우) 처리 -> 숫자를 다시 입력하게 한다.
                            System.out.println("1에서 4 사이의 숫자를 입력하세요");
                        }
                    }

                    break;
                case "4":
                    // 입/출금 UI 가져오기
                    InOutInterface.run();
                    System.out.print("입력 >");
                    int input = scanner.nextInt();
                    // 1. 입금
                    // 2. 출금
                    if (input == 1) {
                        System.out.println("입금하기");
                        System.out.println("입금을 위한 정보를 입력해주세요.");
                        System.out.println("입금자 명: ");
                        String name = scanner.next();
                        System.out.println("입금할 계좌: ");
                        String account = scanner.next();
                        System.out.println("입금할 금액: ");
                        int money = scanner.next();
                        Account depositeAccount = bank.searchAccountnumAccount(account);
                        depositeAccount.deposit(name, account, money);
                        transactionalInformationList.writeTransaction(1, name, account, money);
                        break;
                    } else if (input == 2) {
                        System.out.println("출금");
                        System.out.println("출금을 위한 정보를 입력해주세요.");
                        System.out.println("출금자 명: ");
                        String name = scanner.next();
                        System.out.println("출금할 계좌: ");
                        String account = scanner.next();
                        System.out.println("출금할 금액: ");
                        int money = scanner.next();
                        Account withdrawAccount = bank.searchAccountnumAccount(account);
                        withdrawAccount.withdraw(name, account, money);
                        transactionalInformationList.writeTransaction(2, name, account, money);
                        break;
                    } else {
                        System.out.println("잘못 입력하셨습니다.");
                        break;
                    }
                case "5":
                    // 관리자
                    System.out.println("관리자 확인을 위해 비밀번호를 입력해주세요.");
                    System.out.println("비밀번호: ");
                    String managerpassword = scanner.next();
                    boolean check = bank.checkManager(managerpassword);
                    if (check) {
                        System.out.println("관리자 확인이 되었습니다.");
                        System.out.println("해당 은행에 등록된 계좌 목록");
                        bank.showAccounts();
                        break;
                    } else {
                        System.out.println("관리자가 아닙니다.");
                        break;
                    }

                case "q":
                    System.out.println("프로그램이 종료되었습니다");
                    System.exit(0);
            }
        }
    }
}
