package seedu.address.inventory.model;

import seedu.address.inventory.model.exception.NoSuchIndexException;
<<<<<<< HEAD
import seedu.address.inventory.model.exception.NoSuchItemException;
=======
>>>>>>> Implemented some Inventory classes
import seedu.address.inventory.storage.StorageManager;
import seedu.address.inventory.util.InventoryList;


public class ModelManager implements Model {
    private InventoryList inventoryList;
    private StorageManager storage;

    public ModelManager(InventoryList inventoryList) {
        this.inventoryList = inventoryList;
    }

    public ModelManager(StorageManager storage) {
        this.storage = storage;
        try {
            this.inventoryList = storage.getInventoryList();
        } catch (Exception e) {
            this.inventoryList = new InventoryList();
        }
    }

    @Override
    public InventoryList getInventoryList() {
        return this.inventoryList;
    }

    @Override
<<<<<<< HEAD
    public void setItem(int i, Item editedItem) throws Exception {
                inventoryList.set(i, editedItem);
    }

    @Override
    public boolean hasItemInInventory(Item item) {
        for (int i = 0 ; i < inventoryList.size(); i++) {
            try {
                if (inventoryList.getItemByIndex(i).equals(item)) {
=======
    public void setItem(Item itemToEdit, Item editedItem) throws Exception {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).equals(itemToEdit)) {
                inventoryList.set(i, editedItem);
            }
        }
    }

    @Override
    public boolean hasItem(Item item) {
        for (int i = 0 ; i < inventoryList.size(); i++) {
            try {
                if (inventoryList.get(i).equals(item)) {
>>>>>>> Implemented some Inventory classes
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void addItem(Item item) {
        inventoryList.add(item);
    }

    @Override
    public Item findItemByIndex(int index) throws NoSuchIndexException {
<<<<<<< HEAD
        Item item = inventoryList.getItemByIndex(index - 1);
=======
        Item item = inventoryList.get(index - 1);
>>>>>>> Implemented some Inventory classes
        return item;
    }

    @Override
    public void deleteItem(int index) {
        inventoryList.delete(index - 1);
    }

    @Override
    public void writeInInventoryFile() throws Exception {
        storage.writeFile(inventoryList);
    }

    @Override
<<<<<<< HEAD
    public boolean hasSufficientQuantity(String description, int quantity) throws NoSuchItemException {
        if (inventoryList.getOriginalItem(description).getQuantity() > quantity) {
            return false;
        }
        else {
            return true;
        }
    }

=======
    public boolean hasSufficientQuantity(Item item, int quantity) {
        boolean hasSufficientQuantity = true;
        if (item.getQuantity() < quantity || !hasItem(item)) {
            hasSufficientQuantity = false;
        }
        return hasSufficientQuantity;
    }

    @Override
    public void updateInventoryList() throws Exception {

    }
>>>>>>> Implemented some Inventory classes
}