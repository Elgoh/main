package seedu.address.inventory.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.inventory.ui.InventoryMessages.MESSAGE_ADDED_ITEM;

import java.util.logging.Logger;

import seedu.address.inventory.model.Item;
import seedu.address.inventory.model.Model;
import seedu.address.person.commons.core.LogsCenter;

/**
 * Adds a transaction to the transaction list.
 */
public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    private Item item;
    private final Logger logger = LogsCenter.getLogger(getClass());

    /**
     * Creates an AddCommand to add the specified {@code Item}
     */
    public AddCommand(Item item) {
        requireNonNull(item);
        this.item = item;
    }

    @Override
    public CommandResult execute(Model model) {
        model.addItem(item);
        logger.info(item.toString());
        return new CommandResult(String.format(MESSAGE_ADDED_ITEM, item));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && item.equals(((AddCommand) other).item));
    }
}
