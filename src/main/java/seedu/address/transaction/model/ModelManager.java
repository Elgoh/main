package seedu.address.transaction.model;

import java.util.logging.Logger;
import seedu.address.person.commons.core.LogsCenter;
import seedu.address.transaction.model.exception.NoSuchIndexException;
import seedu.address.transaction.storage.StorageManager;
import seedu.address.transaction.util.TransactionList;

public class ModelManager implements Model {
    private final Logger logger = LogsCenter.getLogger(getClass());

    private final TransactionList transactionList;
    private final StorageManager storage;

    /*public ModelManager(TransactionList transactionList) {
        this.transactionList = transactionList;
    }*/

    public ModelManager(StorageManager storage) {
        this.storage = storage;
        this.transactionList = storage.getTransactionList();
    }

    @Override
    public TransactionList getTransactionList() {
        return this.transactionList;
    }

    @Override
    public void setTransaction(Transaction transactionToEdit, Transaction editedTransaction) throws Exception {
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction curr = transactionList.get(i);
            if (curr.equals(transactionToEdit)) {
                transactionList.set(i, editedTransaction);
            }
        }
    }

    @Override
    public boolean hasTransaction(Transaction editedTransaction) {
        for (int i = 0 ; i < transactionList.size(); i++) {
            try {
                if (transactionList.get(i).equals(editedTransaction)) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void addTransaction(Transaction trans) {
        transactionList.add(trans);
    }

    @Override
    public Transaction findTransactionByIndex(int index) throws NoSuchIndexException {
        Transaction transaction = transactionList.get(index - 1);
        return transaction;
    }

    @Override
    public void deleteTransaction(int index) {
        transactionList.delete(index - 1);
    }

    @Override
    public void writeInTransactionFile() throws Exception{
        storage.writeFile(transactionList);
    }

    @Override
    public void updateIndexes() throws Exception {
        for (int i = 0; i < transactionList.size(); i++) {
            transactionList.get(i).setId(i + 1);
        }
    }

}