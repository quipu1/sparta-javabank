package bank;

public interface Transaction {
    void getTransaction(String accountNum, String owner, int password);

    void writeTransaction(int availability, String accountNum, int transactionAmount);


}
