package seedu.address.inventory.ui;

import java.util.logging.Logger;

import seedu.address.inventory.model.Item;
import seedu.address.person.commons.core.LogsCenter;

/**
 * Formats the Ui return responses for different commands to be shown to user.
 */
public class InventoryMessages {
    public static final String MESSAGE_NO_SUCH_SORT_COMMAND =
            "The items can be sorted by category, quantity and description.\n"
                    + "Please input sort by category/quantity/description";

    public static final String RESET_TO_ORIGINAL_ORDER = "The items are now reset to original order of input "
            + "when treasurerPro was just open.";

    public static final String MESSAGE_SORTED_BY_DESCRIPTION = "The items are now sorted by description!";

    public static final String MESSAGE_SORTED_BY_CATEGORY = "The items are now sorted by category!";

    public static final String MESSAGE_SORTED_BY_QUANTITY = "The items are now sorted by quantity!";

    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Sorry! Please type find with your keywords\n "
            + "(Eg. find poster printing)";

    public static final String MESSAGE_INVALID_ADDCOMMAND_FORMAT = "Sorry! Please type add with parameters:\n"
            + "d/description c/category q/quantity co/cost [p/price]";

    public static final String MESSAGE_NOT_A_NUMBER = "Sorry! Please input a number.";

    public static final String NO_SUCH_ITEM_INVENTORY =
            "Sorry! There is no such item in our database. Do add the item in.";

    public static final String NO_SUCH_COMMAND = "Sorry! There is no such command.";

    public static final String MESSAGE_INVALID_ADD_COMMAND_FORMAT = "Sorry! Please type add with parameters:\n"
            + " dt/DATE (eg.21-Sep-2019, 24-Aug-2019 etc)\n d/DESCRIPTION\n c/CATEGORY\n a/AMOUNT\n p/PERSON";

    public static final String MESSAGE_INVALID_EDIT_COMMAND_FORMAT = "Sorry! Please type edit with the index "
            + "and any parameters to be edited:\n" + " dt/DATE\n d/DESCRIPTION\n c/CATEGORY\n a/AMOUNT\n p/PERSON";

    public static final String MESSAGE_NOT_EDITED = "Sorry! Did not manage to edit item!";

    public static final String NO_SUCH_INDEX_INVENTORY = "There is no item at the inputted index.";

    private static final Logger logger = LogsCenter.getLogger(InventoryMessages.class);

    public static String editedItem(Item itemBefore, Item itemAfter) {
        return "Edited Item from:\n" + itemBefore + "\nto :" + itemAfter;
    }

    public String addedItem(Item item) {
        return "Added Item:\n" + item;
    }

    public String deletedItem(Item item) {
        return "Deleted Item:\n" + item;
    }
}