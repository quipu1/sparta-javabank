package bank;

import java.util.ArrayList;
import java.util.List;
import bank.TransactionalInformation;
import bank.Account;

public class TransactionalInformationList implements Transaction{
    List<TransactionalInformation> TransactionalInformationList = new ArrayList<>();

    // 앞에서 account의 계좌번호, 소유주, 비밀번호일치 확인 /  해당 account의  거래내역 조회(거래내역 리스트의 계좌번호일치여부만 확인) //
    @Override
    public void getTransaction(String accountNum, String owner, int password) {
        if(TransactionalInformationList.isEmpty()){
            System.out.println("해당 계좌에는 거래내역이 존재하지 않습니다.");
        }else{
            for (int i=0 ; i < TransactionalInformationList.size(); i++) {
                TransactionalInformation information = TransactionalInformationList.get(i);
                if(information.getAccountNum().equals(accountNum)){
                    System.out.println("거래일자 : " + information.getDate() + " | 거래시간 : " +information.getTime() + " | 계좌번호 : " + information.getAccountNum() + " | 입금/출금 : " + information.getAvailability() + " | 거래금액 : " + information.getTransactionAmount()+"원");
                    System.out.println("------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }

    //거래 발생시에 거래내역 기록하는 메소드
    @Override
    public void writeTransaction(int availability, String accountNum, int transactionAmount) {
        TransactionalInformation transaction = new TransactionalInformation(accountNum, availability, transactionAmount);
        // 앞에서부터 저장
        TransactionalInformationList.add(0,transaction);
        System.out.println("거래내역이 등록되었습니다.");

    }



}


