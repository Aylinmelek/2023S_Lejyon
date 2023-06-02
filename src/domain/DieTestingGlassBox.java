package domain;

import org.junit.Assert;
import org.junit.Test;

import UI.InitSharing;
import domain.controller.ConKUerorHandler;

public class DieTestingGlassBox {

    @Test
    public void TestListOfDice() {
        // Create necessary objects
    	Board board = new Board();
        ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
        Die die = new Die();
       
        // Test case: Verify if the die value is added to the list of dice in the Die class
        conKUerorHandler.rollDice();
        int dieNumber = conKUerorHandler.getDieValue();
        die.dice.add(dieNumber);
        Assert.assertEquals("Die value should be added to the list of dice in the Die class", dieNumber, die.dice.get(0).intValue());
    }
    
 
        
        @Test
        public void TestBoardPrint() {
            // Create necessary objects
        	Board board = new Board();
            ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
            
            // Test case (Glass Box): Verify if the board publishes the board event correctly by checking if the die value is printed
            for (int dieNumber = 1; dieNumber <= 6; dieNumber++) {
                String expectedOutput = Integer.toString(dieNumber);
                String actualOutput = board.publishBoardEvent(dieNumber);
                
                // Verify that the die value is printed correctly
                Assert.assertEquals("Die value should be printed in the Board class", expectedOutput, actualOutput);
            }
        }
    

  
        
        @Test
        public void RollDiceWithinRange() {
            // Create necessary objects
            Die die = new Die();
            Board board = new Board();
            ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
            InitSharing initSharing = new InitSharing(conKUerorHandler);
            
            // Test case (Glass Box): Roll the die and verify if the value is within the valid range
            for (int i = 0; i < 100; i++) {
                conKUerorHandler.rollDice();
                int dieNumber = conKUerorHandler.getDieValue();
                
                // Verify the die value is within the valid range
                Assert.assertTrue("Die value should be between 1 and 6", dieNumber >= 1 && dieNumber <= 6);
            }
        }
        
            
        
            
            @Test
            public void TestUIDomainCommunication_GlassBox() {
                // Create necessary objects
                Die die = new Die();
                Board board = new Board();
                ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
                InitSharing initSharing = new InitSharing(conKUerorHandler);
               
                // Test case (Glass Box): Verify if UI and domain can communicate by checking if the die value is displayed correctly in InitSharing
                for (int dieNumber = 1; dieNumber <= 6; dieNumber++) {
                    conKUerorHandler.rollDice();
                    int actualDieNumber = conKUerorHandler.getDieValue();
                    String expectedDisplay = Integer.toString(actualDieNumber); //InitSharing
                    String actualDisplay = Integer.toString(board.getDiceValue()); //Board
                    
                    // Verify that the die value is displayed correctly in InitSharing
                    Assert.assertEquals("Die value should be displayed correctly in InitSharing", expectedDisplay, actualDisplay);
                }
            }
       
                
                @Test
                public void testDisplayDieIcon_GlassBox() {
                    // Create necessary objects
                    Die die = new Die();
                    Board board = new Board();
                    ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
                    InitSharing initSharing = new InitSharing(conKUerorHandler);  
                    
                    // Test case (Glass Box): Verify if the correct die icon is displayed based on the dieNumber
                    // Roll the die with different values and check the displayed icon
                    for (int dieNumber = 1; dieNumber <= 6; dieNumber++) {
                        // Set the expected icon file name based on the die number
                        String expectedIcon = "die" + dieNumber + ".png";

                        // Call the displayDie() method
                        initSharing.displayDie(dieNumber);
                        String actualIcon = initSharing.displayDie(dieNumber).toString();
                        
                        // Obtain the last part of the actual icon file name
                        String lastPart = actualIcon.substring(actualIcon.lastIndexOf("/") + 1);
                        System.out.println("lastPart: " + lastPart);
                        
                        // Compare the actual and expected icons
                        Assert.assertEquals("Die icon should match the expected icon for the given die number", expectedIcon, lastPart);
                    }
                }
            


        



}
