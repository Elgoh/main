package seedu.address.inventory.logic;

import static seedu.address.util.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.util.CliSyntax.PREFIX_COST;
import static seedu.address.util.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.util.CliSyntax.PREFIX_PRICE;
import static seedu.address.util.CliSyntax.PREFIX_QUANTITY;

import seedu.address.inventory.commands.EditCommand;
import seedu.address.inventory.logic.exception.ParseException;
import seedu.address.inventory.ui.InventoryMessages;
import seedu.address.util.ArgumentMultimap;
import seedu.address.util.ArgumentTokenizer;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns a EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTION, PREFIX_CATEGORY, PREFIX_QUANTITY, PREFIX_COST,
                        PREFIX_PRICE);
        int index;
        try {
            index = Integer.parseInt(argMultimap.getPreamble());
        } catch (Exception e) {
            throw new ParseException(InventoryMessages.MESSAGE_INVALID_EDIT_COMMAND_FORMAT);
        }

        EditCommand.EditItemDescriptor editPersonDescriptor = new EditCommand.EditItemDescriptor();
        if (argMultimap.getValue(PREFIX_DESCRIPTION).isPresent()) {
            editPersonDescriptor.setDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());
        }
        if (argMultimap.getValue(PREFIX_CATEGORY).isPresent()) {
            editPersonDescriptor.setCategory(argMultimap.getValue(PREFIX_CATEGORY).get());
        }
        if (argMultimap.getValue(PREFIX_QUANTITY).isPresent()) {
            editPersonDescriptor.setQuantity(Integer.parseInt(argMultimap.getValue(PREFIX_QUANTITY).get()));
        }
        if (argMultimap.getValue(PREFIX_COST).isPresent()) {
            editPersonDescriptor.setCost(Double.parseDouble(argMultimap.getValue(PREFIX_COST).get()));
        }
        if (argMultimap.getValue(PREFIX_PRICE).isPresent()) {
            editPersonDescriptor.setPrice(Double.parseDouble(argMultimap.getValue(PREFIX_PRICE).get()));
        }

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(InventoryMessages.MESSAGE_NOT_EDITED);
        }
        return new EditCommand(index, editPersonDescriptor);
    }
}