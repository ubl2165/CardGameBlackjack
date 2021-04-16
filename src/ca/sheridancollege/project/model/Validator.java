package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.basecode.Player;
import java.util.ArrayList;

/**
 *
 * A class delegates all the methods to validate the user input.
 * There are two methods are tailored to this card game project.
 * @author Ji Li
 * @version 1.0 2021 April
 *
 */
public class Validator {

    /**
     *
     * A class with all the methods to validate the input of the TextField
     *
     * @author Ji Li
     * @version 1.0 2021 March
     *
     */
    /**
     * Default constructor
     */
    public Validator() {

    }
    
    /**
     * A method to decide if name is duplicated in the player list or is the 
     * same name of "DEALER".
     * 
     * @param name
     * @param players
     * @return true if unique, false if duplicated.
     */
    public boolean isUniqueName (String name, ArrayList<Player> players) {
        
        boolean result = true;
        
        if(!players.isEmpty()) {
            
            for(Player player : players ) {
            
                if (name.equals(player.getName())) {
                    
                    result = false;
                    throw new IllegalArgumentException("Name already exists.");
                }    
            }
        }
        
        if(name.toUpperCase().equals("DEALER")) {
            result = false;
            throw new IllegalArgumentException("You can't use name of Dealer.");
            
        }
 
        
        return result;
      
    }
    
    /**
     * A method to check if a full name is valid by Regex. 
     * Valid full name should contain letters and space only.
     *
     * @param input String
     * @return true if valid
     * @throws IllegalArgumentException name should be letters only
     */
    public boolean isValidFullName(String input) {

        if (!input.matches("[a-zA-Z' ]*")) {
            throw new IllegalArgumentException("Name should be letters only");
        }

        return input.matches("[a-zA-Z' ]*");
        //or return true;

    }
    
    
    /**
     * Method to check if a null string or empty one.
     *
     * @param input String
     * @return true if valid
     * @throws IllegalArgumentException input should not be empty
     */
    public boolean isNotEmptyOrNull(String input) {

        if ( input == null || input.strip().equals("")) {
            throw new IllegalArgumentException("Input should not be empty");
        }

//        return input.strip().equals("") || input == null;//or
         return true;

    }

    /**
     * Method to check valid length
     *
     * @param input String
     * @param validLength valid length
     * @return true if valid
     * @throws IllegalArgumentException input is too short
     */
    public boolean isValidLength(String input, int validLength) {

        //strip() will remove all leading and trailing spaces from a String
        if (input.strip().length() < validLength) {
            throw new IllegalArgumentException("Too short.");
        }

        return input.length() >= validLength;
    }
    
    
     /**
     * Method to check if it is a valid Betting number input. 
     * Valid input should be less than player's chips in the pocket 
     *
     * @param bet which is a double type
     * @param gambler which is a Gambler Type
     * @return true     * 
     * @throws IllegalArgumentException Insufficient Fund
     */
    public boolean isValidBetting(double bet, Gambler gambler) {

        
        if(bet <= 0) {
        
            throw new IllegalArgumentException("Betting can not be zero or less.");
        
        }else if (bet <= gambler.getChips().getChipsInPocket()) {

           return true;

        } else {

            throw new IllegalArgumentException("Insufficient Fund.");
        }
 

    }



    /**
     * Method to check if it is a valid double input with 
     * regular expression:
     * (\\-?\\d*\\.?\\d+) valid input should greater than zero.
     *
     * @param input which is a String type
     * @return true if valid
     * @throws IllegalArgumentException Input should be a number.
     */
    public boolean isValidDouble(String input) { 

        if (input.strip().matches("-?\\d*\\.?\\d+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Input should be a number. ");
        }

    }

    /**
     * Method to check if it is a valid double input. 
     * valid input should greater than zero.
     *
     * @param input double
     * @return true if valid
     */
    public boolean isValidDouble(double input) { 

        return isInTheRange(input, 0.0);

    }


    /**
     * Method to check if it is a valid int input.
     * 
     * @param input String
     * @return true if valid
     */
    public boolean isValidInteger(String input) {


	if (input.strip().matches("\\d+")) {

	    return true;

	}else {

	    throw new IllegalArgumentException("Input must be a whole number");
	}

    }



    /**
     * Method to check if the double is in the range. min and max can switch
     * places if min is greater max by input error.
     *
     * @param args which is a double array input
     * @return true if in the range
     * @throws IllegalArgumentException if range is not in min and max
     */
    public boolean isInTheRange(double... args) {

        boolean result = false;
        double input, min, max;

        switch (args.length) {
            case 2:
                input = args[0];
                min = args[1];
                result = (input > min);
                break;
            case 3:
                input = args[0];
                min = args[1];
                max = args[2];
                //if min is greater than max, then switch value
                if (min > max) {
                    double temp = min;
                    min = max;
                    max = temp;
                }

                result = (input >= min) && (input <= max);
                break;

        }

        if (result) {
            return result;
        } else {
            throw new IllegalArgumentException("Input out of range ");
        }

    }
    
    
        /**
     * Method to check if the int is in the range. min and max can switch
     * places if min is greater max by input error.
     *
     * @param args which is an int array input
     * @return true if in the range
     * @throws IllegalArgumentException if range is not in min and max
     */
    public boolean isInTheRange(int... args) {

        boolean result = false;
        
        int input, min, max;

        switch (args.length) {
            case 2:
                input = args[0];
                min = args[1];
                result = (input > min);
                break;
            case 3:
                input = args[0];
                min = args[1];
                max = args[2];
                //if min is greater than max, then switch value
                if (min > max) {
                    int temp = min;
                    min = max;
                    max = temp;
                }

                result = (input >= min) && (input <= max);
                break;

        }

        if (result) {
            return result;
        } else {
            throw new IllegalArgumentException("Input out of range ");
        }

    }

}
