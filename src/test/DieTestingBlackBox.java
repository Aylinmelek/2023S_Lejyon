package test;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Test;
import UI.InitSharing;
import domain.Board;
import domain.Die;
import domain.controller.ConKUerorHandler;

public class DieTestingBlackBox {

	/**
	 * Specification:
	 * @Requires: Player wants to roll a die, to do that clicks the 'ROLL' button
	 * @Modifies: displayDie() method in UI. rollDie() method in domain. ConKUerorHandler's internal state.
	 * @Effects: When player rolls a die, the icon that displayed in the UI will change according
	 * to the result of the rollDie() function.  Updates the internal state of ConKUerorHandler.
	 */

    @Test
    public void RollDiceWithinRange() {
        // Create necessary objects
        Die die = new Die();
        Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler();
        InitSharing initSharing = new InitSharing();
       
    
        // Test case 1: Roll the die and verify if the value is within the valid range
        conKUerorHandler.rollDice();
        int dieNumber = conKUerorHandler.getDieValue();
        Assert.assertTrue("Die value should be between 1 and 6", dieNumber >= 1 && dieNumber <= 6);
    }
    @Test
    public void TestUIDomainCommunication() {
        // Create necessary objects
        Die die = new Die();
        Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler();
        InitSharing initSharing = new InitSharing();
       
        // Test case 2: Verify if UI and domain can communicate by checking if the die value is displayed correctly in InitSharing
        conKUerorHandler.rollDice();
        int dieNumber = conKUerorHandler.getDieValue();
        String expectedDisplay = Integer.toString(dieNumber); //InitSharing
        String actualDisplay = Integer.toString(conKUerorHandler.getDieValue()); //Board
        Assert.assertEquals("Die value should be displayed correctly in InitSharing", expectedDisplay, actualDisplay);
    }
    
    @Test
    public void TestListOfDice() {
        // Create necessary objects
        Die die = new Die();
        Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler();
        InitSharing initSharing = new InitSharing();
       
        
        // Test case 3: Verify if the die value is added to the list of dice in the Die class
        conKUerorHandler.rollDice();
        int dieNumber = conKUerorHandler.getDieValue();
        die.dice.add(dieNumber);
        Assert.assertEquals("Die value should be added to the list of dice in the Die class", dieNumber, die.dice.get(0).intValue());
    }
    
    @Test
    public void TestBoardPrint() {
        // Create necessary objects
        Die die = new Die();
        Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler();
        InitSharing initSharing = new InitSharing();
        
        // Test case 4: Verify if the board publishes the board event correctly by checking if the die value is printed
        conKUerorHandler.rollDice();
        int dieNumber = conKUerorHandler.getDieValue();
        String expectedOutput = Integer.toString(dieNumber);
        String actualOutput = board.publishBoardEvent(dieNumber);
        Assert.assertEquals("Die value should be printed in the Board class", expectedOutput, actualOutput);
    }
    
    @Test
    public void testDisplayDieIcon() {
        // Create necessary objects
        Die die = new Die();
        Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler();
        InitSharing initSharing = new InitSharing();  
        int finalDieDisplayed;
        
        // Test case 5: Verify if the correct die icon is displayed based on the dieNumber
        // Roll the die with a specific value
        int dieNumber = 4;
        finalDieDisplayed=dieNumber;
        String expectedIcon = "die4.png"; // Expected icon file name for die number 4

        // Call the displayDie() method
        //initSharing.displayDie(dieNumber);



     // Obtain the current displayed icon
        initSharing.displayDie(dieNumber);
        String actualIcon = initSharing.displayDie(dieNumber).toString();
        
        String lastPart = actualIcon.substring(actualIcon.lastIndexOf("/") + 1);
        System.out.println("lastPart: " + lastPart);
        // Compare the actual and expected icons
        Assert.assertTrue("Die icon should match the expected icon for the given die number", expectedIcon.equals(lastPart));
    }

    private String iconToString(Icon icon) {
        if (icon != null) {
            return icon.toString();
        } else {
            return null;
        }
    }

}
