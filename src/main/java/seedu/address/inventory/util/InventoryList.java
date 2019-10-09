package seedu.address.inventory.util;

import java.util.ArrayList;

import seedu.address.inventory.model.Item;
import seedu.address.inventory.model.exception.NoSuchIndexException;
import seedu.address.inventory.model.exception.NoSuchItemException;


/**
 *
 */
public class InventoryList {

    static ArrayList<Item> iList;

    public InventoryList() {
        this.iList = new ArrayList<Item>();
    }

    public InventoryList(ArrayList<Item> list) {
        this.iList = list;
    }

    public static Item getItemByIndex(int index) throws NoSuchIndexException {
        if (index >= iList.size()) {
            throw new NoSuchIndexException(InventoryUi.NO_SUCH_INDEX_INVENTORY);
        } else {
            return iList.get(index);
        }
    }

    public int getIndex(String description) throws NoSuchItemException {
        for (int i = 0; i < iList.size(); i++) {
            if (iList.get(i).getDescription().equalsIgnoreCase(description)) {
                return i;
            }
        }
        throw new NoSuchItemException(InventoryUi.NO_SUCH_ITEM_INVENTORY);
    }

    public static Item getOriginalItem(String description) throws seedu.address.inventory.model.exception.NoSuchItemException {
        for (int i = 0; i < iList.size(); i++) {
            if (iList.get(i).getDescription().equalsIgnoreCase(description)) {
                return iList.get(i);
            }
        }
        throw new seedu.address.inventory.model.exception.NoSuchItemException(InventoryUi.NO_SUCH_ITEM_INVENTORY);
    }

    public static Item getOriginalItem(Item item) throws seedu.address.inventory.model.exception.NoSuchItemException {
        for (int i = 0; i < iList.size(); i++) {
            if (iList.get(i).isSameItem(item)) {
                return iList.get(i);
            }
        }
        throw new seedu.address.inventory.model.exception.NoSuchItemException(InventoryUi.NO_SUCH_ITEM_INVENTORY);
    }

    public void add(Item item) {
        iList.add(item);
    }

    public void delete(int index) {
        iList.remove(index);
    }

    public static int size() {
        return iList.size();
    }

    public void set(int i, Item item) {
        iList.set(i, item);
    }

}