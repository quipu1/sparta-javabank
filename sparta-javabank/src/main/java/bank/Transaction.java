package bank;

public interface Transaction {
    void getTransaction(int accountNum, String owner, int password);

    void  writeTransaction(String date, String time, int accountNum, int availability, int transactionAmount, String bank);


}
