package seedu.address.inventory.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.inventory.logic.commands.AddCommand;
import seedu.address.inventory.logic.commands.Command;
import seedu.address.inventory.logic.commands.CommandResult;
import seedu.address.inventory.logic.commands.DeleteCommand;
import seedu.address.inventory.logic.commands.EditCommand;
import seedu.address.inventory.logic.commands.SortCategoryCommand;
import seedu.address.inventory.logic.commands.SortDescriptionCommand;
import seedu.address.inventory.logic.commands.SortQuantityCommand;
import seedu.address.inventory.logic.commands.SortResetCommand;

import seedu.address.inventory.model.Item;
import seedu.address.inventory.model.Model;
import seedu.address.inventory.model.ModelManager;
import seedu.address.inventory.ui.InventoryMessages;
import seedu.address.inventory.util.InventoryList;
import seedu.address.testutil.EditItemDescriptorBuilder;
import seedu.address.testutil.TypicalItem;

public class CommandTest {

    @Test
    public void execute_addCommandTest_successful() {
        Model inventoryModel = new ModelManager(new InventoryList());
        Command addCommand = new AddCommand(TypicalItem.FISH_BURGER);

        CommandResult commandResult = null;

        try {
            commandResult = addCommand.execute(inventoryModel);
        } catch (Exception e) {
            fail();
        }
        assertEquals(new CommandResult(String.format(InventoryMessages.MESSAGE_ADDED_ITEM, TypicalItem.FISH_BURGER)),
                commandResult);
    }

    @Test
    public void execute_deleteCommandTest_successful() {
        //create a new InventoryList that only contains TypicalItem.FISH_BURGER
        ArrayList<Item> fishBurgerList = new ArrayList<>();
        fishBurgerList.add(TypicalItem.FISH_BURGER);
        InventoryList inventoryList = new InventoryList(fishBurgerList);

        Model inventoryModel = new ModelManager(inventoryList);
        Command deleteCommand = new DeleteCommand(1);

        CommandResult commandResult = null;

        try {
            commandResult = deleteCommand.execute(inventoryModel);
        } catch (Exception e) {
            fail();
        }
        //compares the String CommandResult given to the expected CommandResult
        assertEquals(new CommandResult(String.format(InventoryMessages.MESSAGE_DELETED_ITEM, TypicalItem.FISH_BURGER)),
                commandResult);
    }

    @Test
    public void execute_editCommandTest_successful() {
        //create a new InventoryList that only contains TypicalItem.FISH_BURGER
        ArrayList<Item> fishBurgerList = new ArrayList<>();
        fishBurgerList.add(TypicalItem.FISH_BURGER);
        InventoryList inventoryList = new InventoryList(fishBurgerList);

        Model inventoryModel = new ModelManager(inventoryList);
        Item expectedItem = new Item("T-Shirt", "clothes", 50, 5.00,
                10.00, 1);
        EditCommand.EditItemDescriptor editItemDescriptor = new EditItemDescriptorBuilder(expectedItem).build();
        //Original Item:    withDescription("Burger")
        //                  .withCategory("food")
        //                  .withQuantity(99000)
        //                  .withCost(5.23)
        //                  .withPrice(3.25)

        Command editCommand = new EditCommand(1, editItemDescriptor);

        CommandResult commandResult = null;

        try {
            commandResult = editCommand.execute(inventoryModel);
        } catch (Exception e) {
            fail();
        }

        //compares the String CommandResult given to the expected CommandResult
        assertEquals(new CommandResult(String.format(InventoryMessages.MESSAGE_EDITED_ITEM, TypicalItem.FISH_BURGER,
                expectedItem)), commandResult);
    }

    @Test
    public void execute_editCommandTestUnsuccessful() {
        //create a new InventoryList that only contains TypicalItem.FISH_BURGER
        ArrayList<Item> fishBurgerList = new ArrayList<>();
        fishBurgerList.add(TypicalItem.FISH_BURGER);
        InventoryList inventoryList = new InventoryList(fishBurgerList);

        Model inventoryModel = new ModelManager(inventoryList);
        Item fishBurger = TypicalItem.FISH_BURGER;
        EditCommand.EditItemDescriptor editItemDescriptor = new EditItemDescriptorBuilder(fishBurger).build();
        Command editCommand = new EditCommand(1, editItemDescriptor);

        CommandResult commandResult = null;

        try {
            commandResult = editCommand.execute(inventoryModel);
        } catch (Exception e) {
            assertEquals(InventoryMessages.MESSAGE_DUPLICATE, e.getMessage());
        }
    }

    @Test
    public void execute_sortDescriptionCommandTest_successful() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(TypicalItem.FISH_BURGER);
        list.add(TypicalItem.STORYBOOK);
        list.add(TypicalItem.BLACK_SHIRT);

        InventoryList inventoryList = new InventoryList(list);
        Model sortDescriptionInventoryModel = new ModelManager(inventoryList);

        SortDescriptionCommand sortDescriptionCommand = new SortDescriptionCommand();

        CommandResult sortDescriptionCommandResult = null;
        try {
            sortDescriptionCommandResult = sortDescriptionCommand.execute(sortDescriptionInventoryModel);

        } catch (Exception e) {
            fail();
        }

        assertEquals(new CommandResult(InventoryMessages.MESSAGE_SORTED_BY_DESCRIPTION),
                sortDescriptionCommandResult);

        assertEquals(TypicalItem.FISH_BURGER, sortDescriptionInventoryModel.getInventoryList().get(0));
    }

    @Test
    public void execute_sortCategoryCommandTest_successful() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(TypicalItem.FISH_BURGER);
        list.add(TypicalItem.STORYBOOK);
        list.add(TypicalItem.BLACK_SHIRT);

        InventoryList inventoryList = new InventoryList(list);
        Model sortCategoryInventoryModel = new ModelManager(inventoryList);

        SortCategoryCommand sortCategoryCommand = new SortCategoryCommand();

        CommandResult sortCategoryCommandResult = null;
        try {
            sortCategoryCommandResult = sortCategoryCommand.execute(sortCategoryInventoryModel);
        } catch (Exception e) {
            fail();
        }

        assertEquals(new CommandResult(InventoryMessages.MESSAGE_SORTED_BY_CATEGORY),
                sortCategoryCommandResult);

        assertEquals(TypicalItem.STORYBOOK, sortCategoryInventoryModel.getInventoryList().get(0));
    }

    @Test
    public void execute_sortQuantityCommandTest_successful() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(TypicalItem.FISH_BURGER);
        list.add(TypicalItem.STORYBOOK);
        list.add(TypicalItem.BLACK_SHIRT);

        //Instantiate ModelManagers for all sort commands
        InventoryList inventoryList = new InventoryList(list);
        Model sortQuantityInventoryModel = new ModelManager(inventoryList);

        //Instantiate all sortCommands
        SortQuantityCommand sortQuantityCommand = new SortQuantityCommand();

        CommandResult sortQuantityCommandResult = null;

        try {
            sortQuantityCommandResult = sortQuantityCommand.execute(sortQuantityInventoryModel);
        } catch (Exception e) {
            fail();
        }

        assertEquals(new CommandResult(InventoryMessages.MESSAGE_SORTED_BY_QUANTITY),
                sortQuantityCommandResult);

        assertEquals(TypicalItem.BLACK_SHIRT, sortQuantityInventoryModel.getInventoryList().get(0));
    }

    @Test
    public void execute_sortResetCommandTest_successful() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(TypicalItem.FISH_BURGER);
        list.add(TypicalItem.STORYBOOK);
        list.add(TypicalItem.BLACK_SHIRT);

        //Instantiate ModelManagers for all sort commands
        InventoryList inventoryList = new InventoryList(list);
        Model sortResetInventoryModel = new ModelManager(inventoryList);

        SortResetCommand sortResetCommand = new SortResetCommand();

        CommandResult sortResetCommandResult = null;

        try {
            sortResetCommandResult = sortResetCommand.execute(sortResetInventoryModel);
        } catch (Exception e) {
            fail();
        }

        assertEquals(new CommandResult(InventoryMessages.MESSAGE_RESET_TO_ORIGINAL_ORDER),
                sortResetCommandResult);

        assertEquals(TypicalItem.FISH_BURGER, sortResetInventoryModel.getInventoryList().get(0));
    }

    @Test
    public void equalsTest() {
        AddCommand addCommand1 = new AddCommand(TypicalItem.BLACK_SHIRT);
        AddCommand addCommand1Copy = new AddCommand(TypicalItem.BLACK_SHIRT);
        AddCommand addCommand2 = new AddCommand(TypicalItem.FISH_BURGER);

        DeleteCommand deleteCommand1 = new DeleteCommand(1);
        DeleteCommand deleteCommand1Copy = new DeleteCommand(1);
        DeleteCommand deleteCommand2 = new DeleteCommand(2);

        EditCommand.EditItemDescriptor editItemDescriptor1 = new EditItemDescriptorBuilder(TypicalItem.CHIPS).build();
        EditCommand.EditItemDescriptor editItemDescriptor2 = new EditItemDescriptorBuilder(TypicalItem.WATER).build();
        EditCommand editCommand1 = new EditCommand(1, editItemDescriptor1);
        EditCommand editCommand1Copy = new EditCommand(1, editItemDescriptor1);
        EditCommand editCommand2 = new EditCommand(2, editItemDescriptor1);
        EditCommand editCommand3 = new EditCommand(1, editItemDescriptor2);

        assertTrue(addCommand1.equals(addCommand1Copy));
        assertFalse(addCommand1.equals(addCommand2));

        assertTrue(deleteCommand1.equals(deleteCommand1Copy));
        assertFalse(deleteCommand1.equals(deleteCommand2));

        assertTrue(editCommand1.equals(editCommand1Copy));
        //Different index
        assertFalse(editCommand1.equals(editCommand2));
        //Different EditItemDescriptor
        assertFalse(editCommand1.equals(editCommand3));
    }
}
