package seedu.address.inventory.commands;

import seedu.address.inventory.model.Item;
import seedu.address.inventory.model.ModelManager;
import seedu.address.inventory.model.exception.NoSuchIndexException;
import seedu.address.inventory.ui.InventoryMessages;

/**
 * Deletes a transaction to the transaction list.
 */
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private int index;

    /**
     * Creates an DeleteIndexCommand to delete the specified {@code Transaction}
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(ModelManager model)
            throws NoSuchIndexException {
        InventoryMessages inventoryMessages = new InventoryMessages();
        Item item = model.findItemByIndex(index);
        model.deleteItem(index);
        return new CommandResult(inventoryMessages.deletedItem(item));
    }
}