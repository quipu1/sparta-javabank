package bank;

import java.util.ArrayList;
import java.util.List;
import bank.TransactionalInformation;
import bank.Account;

public class TransactionalInformationList implements Transaction{
    List<TransactionalInformation> TransactionalInformationList = new ArrayList<>();

    // 전체 거래내역 목록 가져오기
    public void getTransactionInformationList() {
        for (TransactionalInformation information : this.TransactionalInformationList) {
            System.out.println("거래일자 : " + information.getDate() + " | 거래시간 : " +information.getTime());
            System.out.println("계좌번호 : " + information.getAccountNum());
            System.out.println("입금/출금 : " + information.getAvailability());
            System.out.println("거래금액 : " + information.getTransactionAmount());
            System.out.println("-------------------------------------");
        }
    }
    // 앞에서 account의 계좌번호, 소유주, 비밀번호일치 확인 /  해당 account의  거래내역 조회(거래내역 리스트의 계좌번호일치여부만 확인) //
    @Override
    public void getTransaction(int accountNum, String owner, int password) {
        for (int i=0 ; i < TransactionalInformationList.size(); i++) {
            TransactionalInformation information = TransactionalInformationList.get(i);
            if(information.getAccountNum()==accountNum){
                System.out.println("해당 계좌의 거래내역을 불러옵니다.");
                System.out.println(information);
            }
        }
    }

    //거래 발생시에 거래내역 기록하는 메소드
    @Override
    public void writeTransaction(String date, String time, int accountNum, int availability, int transactionAmount, String bank) {
        TransactionalInformation transaction = new TransactionalInformation(date, time, accountNum, availability, transactionAmount, bank);
        // 앞에서부터 저장
        TransactionalInformationList.add(0,transaction);
        System.out.println("거래내역이 등록되었습니다.");

    }



}


