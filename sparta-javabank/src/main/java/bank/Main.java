package bank;

import bank.presentation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("πππππππππππππππ");
        System.out.println("πκΉλ£¨λΉνΈλ―Έμνμ μ€μ κ±Έ νμν©λλ€!π");
        System.out.println("πππππππππππππππ");
        Scanner scanner = new Scanner(System.in);
        Atm bank = new Bank();
        TransactionalInformationList transactionalInformationList = new TransactionalInformationList();

        while(true) {
            StartInterface startInterface = new StartInterface();
            startInterface.run();
            System.out.print("μλ ₯ > ");
            String input = scanner.next();
            scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("κ³μ’ λ²νΈλ 000000-000000 νμμΌλ‘ μμ±ν΄μ£ΌμΈμ.");
                    System.out.print("κ³μ’ λ²νΈ: ");
                    String accNum = scanner.nextLine();
                    System.out.print("μ΄λ¦: ");
                    String name = scanner.nextLine();
                    System.out.print("λΉλ°λ²νΈ: ");
                    int password = scanner.nextInt();
                    //Bank κ°μ²΄μμ κ³μ’ μμ±νλ λ©μλ
                    bank.createAccounts(name, accNum, password);
                    break;
                // κ³μ’ μ‘°ν (λ΄ κ³μ’ μ°ΎκΈ°)
                case "2":
                    // κ³μ’μ°ΎκΈ° UI κ°μ Έμ€κΈ°
                    LookupInterface lookupInterface = new LookupInterface();
                    lookupInterface.run();
                    int input2 = scanner.nextInt();
                    // 1 μλ ₯ - κ³μ’λ²νΈλ‘ λ΄ κ³μ’ μ°ΎκΈ°
                    // 2 μλ ₯ - μ΄λ¦μΌλ‘ λ΄ κ³μ’ μ°ΎκΈ°
                    if (input2 == 1) {
                        System.out.println("κ³μ’λ²νΈλ‘ λ΄ κ³μ’ μ°ΎκΈ°");
                        System.out.println("κ³μ’λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.print("κ³μ’λ²νΈ: ");
                        String accountNum = scanner.next();
                        System.out.println();
                        bank.searchAccountNumAccount(accountNum);
                        break;
                    } else if (input2 == 2) {
                        System.out.println("μ΄λ¦μΌλ‘ λ΄ κ³μ’ μ°ΎκΈ°");
                        System.out.println("μμ μ£Ό λͺμ μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.print("κ³μ’ μμ μ£Ό λͺ: ");
                        String owner = scanner.next();
                        System.out.println();
                        bank.searchNameAccount(owner);
                        break;
                    } else {
                        System.out.println("μλͺ» μλ ₯νμ¨μ΅λλ€.");
                        break;
                    }
                case "3":
                    System.out.println("λ³ΈμΈνμΈμ μν΄ μλμ μ λ³΄λ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
                    System.out.print("κ³μ’ λ²νΈ: ");
                    String accNum3 = scanner.nextLine();
                    System.out.print("μ΄λ¦: ");
                    String name3 = scanner.nextLine();
                    System.out.print("λΉλ°λ²νΈ: ");
                    int password3 = scanner.nextInt();
                    Account myAccount = bank.getMyAccount(name3,accNum3, password3);
                    if(myAccount==null){break;}
                    ManagementInterface managementInterface = new ManagementInterface();
                    managementInterface.run();
                    while(true) {
                        System.out.print("μλ ₯ >");
                        int selectNum = scanner.nextInt();
                        if(selectNum == 1) {
                            // λΉλ°λ²νΈ μμ 
                            System.out.print("μλ‘μ΄ λΉλ°λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ: ");
                            int newPassword = scanner.nextInt();
                            myAccount.changePassword(newPassword);
                            break;
                        } else if (selectNum == 2) {
                            // κ³μ’ μ­μ 
                            System.out.print("νμΈμ μν΄ λΉλ°λ²νΈλ₯Ό λ€μ μλ ₯ν΄μ£ΌμΈμ: ");
                            int password3_2 = scanner.nextInt();
                            if(myAccount.getPassword() == password3_2) {
                                bank.removeAccount(name3, accNum3, password3_2);
                            } else {
                                System.out.println("λΉλ°λ²νΈλ₯Ό νλ Έμ΅λλ€.");
                            }
                            break;
                        } else if (selectNum == 3) {
                            // μκ³  μ‘°ν
                            System.out.println("μκ³ : "+ myAccount.getBalance());
                            break;
                        } else if (selectNum == 4) {
                            // κ±°λλ΄μ­ μ‘°ν
                            System.out.println("μλνμΈμ. κ±°λλ΄μ­μ μλμ μΆλ ₯ν©λλ€.");
                            transactionalInformationList.getTransaction(accNum3, name3, password3);
                            break;
                        } else {
                            // μμΈ(μ£Όμ΄μ§ μ«μ μΈμ κ°μ μλ ₯νμ κ²½μ°) μ²λ¦¬ -> μ«μλ₯Ό λ€μ μλ ₯νκ² νλ€.
                            System.out.println("1μμ 4 μ¬μ΄μ μ«μλ₯Ό μλ ₯νμΈμ");
                        }
                    }
                    break;
                case "4":
                    // μ/μΆκΈ UI κ°μ Έμ€κΈ°
                    InOutInterface inOutInterface = new InOutInterface();
                    inOutInterface.run();
                    System.out.print("μλ ₯ >");
                    int input4 = scanner.nextInt();
                    // 1. μκΈ
                    // 2. μΆκΈ
                    if (input4 == 1) {
                        System.out.println("μκΈνκΈ°");
                        System.out.println("μκΈμ μν μ λ³΄λ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.print("μκΈμ λͺ: ");
                        String name4 = scanner.next();
                        System.out.print("μκΈν  κ³μ’: ");
                        String account = scanner.next();
                        System.out.println("μκΈ μ΅λ κΈμ‘μ 20μ΅μλλ€.");
                        System.out.print("μκΈν  κΈμ‘: ");
                        int money = scanner.nextInt();
                        if ( bank.getMyAccountWithoutPassword(account) == null) {
                            break;
                        } else {
                            Account depositAccount = bank.getMyAccountWithoutPassword(account);
                            depositAccount.deposit(money);
                            transactionalInformationList.writeTransaction(1, account, money);
                        }
                        break;
                    } else if (input4 == 2) {
                        System.out.println("μΆκΈ");
                        System.out.println("μΆκΈμ μν μ λ³΄λ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.print("μΆκΈμ λͺ: ");
                        String name4_2 = scanner.next();
                        System.out.print("μΆκΈν  κ³μ’: ");
                        String account = scanner.next();
                        System.out.print("μΆκΈν  κΈμ‘: ");
                        int money = scanner.nextInt();
                        if (bank.getMyAccountWithoutPassword(account) == null) {
                            break;
                        } else {
                            Account withdrawAccount = bank.getMyAccountWithoutPassword(account);
                            if (withdrawAccount.withdraw(money)) {
                                transactionalInformationList.writeTransaction(2, account, money);
                            }
                        }
                        break;
                    } else {
                        System.out.println("μλͺ» μλ ₯νμ¨μ΅λλ€.");
                        break;
                    }
                case "5":
                    // κ΄λ¦¬μ
                    System.out.println("κ΄λ¦¬μ νμΈμ μν΄ λΉλ°λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
                    System.out.print("λΉλ°λ²νΈ: ");
                    String managerPassword = scanner.next();
                    System.out.println("μμ μ£Ό λͺ |   κ³μ’λ²νΈ   |   μμ‘");
                    bank.showAccountsAll(managerPassword);
                    break;

                case "q":
                    System.out.println("νλ‘κ·Έλ¨μ΄ μ’λ£λμμ΅λλ€");
                    System.exit(0);
            }
        }
    }
}
