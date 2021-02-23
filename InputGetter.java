import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 * Class to handle capturing the required information from the user.
 */
public class InputGetter
{
    private String inputFilePath = "";
    private String outputFilePath = "";
    private EnumDesiredCase desiredCase = EnumDesiredCase.TitleCase;
    private String userTypesThisToQuit = "q";
    private boolean userWantsToContinue = true;

    /**
     * Calls relevant methods to get data from the user, provided the user still wants to continue with the program.
     */
    public void captureData()
    {
        if (userWantsToContinue)
        {
            askUserForInputFilePath();
        }

        if (userWantsToContinue)
        {
            askUserForOutputFilePath();
        }

        if (userWantsToContinue)
        {
            askUserForTargetCase();
        }
    }   //captureData


    /**
     * Repeatedly asks the user for which input file to use, until wither a valid file path is entered, or the user enters the (case-insensitive) escape string to quit the program.
     */
    private void askUserForInputFilePath()
    {
        boolean keepAskingUser = false;
        System.out.println("Please provide an input file name.  Enter \"Q\" at any time to quit the program.");

        do
        {
            inputFilePath = System.console().readLine();    //Read the user input.

            if (inputFilePath.toLowerCase().equals(userTypesThisToQuit))  //Check if the user wants to quit.
            {
                userWantsToContinue = false;
                System.out.println("Quitting program...");
                return;
            }
            else
            {
                try
                {
                    File inputFile = new File(inputFilePath);
                    if (inputFile.exists() == false || inputFile.isDirectory() == true) //Check if the file name is valid.
                    {
                        System.out.println("Sorry, that input file name does not work.  Please provide a valid input file name.");
                        keepAskingUser = true;  //Make a note to ask the user again.
                    }
                }
                catch (Exception exception)
                {
                    System.out.println("Sorry, that file name has caused the following exception: " + exception);
                    System.out.println("\nThe program will now close.");
                    userWantsToContinue = false;
                    return;
                }
            }
        }
        while (keepAskingUser) ; //Ask again if the user does not put correct input in.
    }   //askUserForInputFilePath

    /**
     * Repeatedly asks the user for which output file to use, until wither a valid file path is entered, or the user enters the (case-insensitive) escape string to quit the program.
     */
    private void askUserForOutputFilePath()
    {
        boolean keepAskingUser = false;
        System.out.println("Please provide an output file name.  Enter \"Q\" at any time to quit the program.");

        do
        {
            outputFilePath = System.console().readLine();    //Read the user input.

            if (outputFilePath.toLowerCase().equals(userTypesThisToQuit))  //Check if the user wants to quit.
            {
                userWantsToContinue = false;
                System.out.println("Quitting program...");
                return;
            }
            else
            {
                try
                {
                    File outputFile = new File(outputFilePath);
                    if (outputFile.exists() == false || outputFile.isDirectory() == true) //Check if the file name is valid.
                    {
                        System.out.println("Sorry, that output file name does not work.  Please provide a valid output file name.");
                        keepAskingUser = true;  //Make a note to ask the user again.
                    }
                }
                catch (Exception exception)
                {
                    System.out.println("Sorry, that file name has caused the following exception: " + exception);
                    System.out.println("\nThe program will now close.");
                    userWantsToContinue = false;
                    return;
                }
            }
        }
        while (keepAskingUser) ; //Ask again if the user does not put correct input in.
    }   //askUserForOutputFilePath

    /**
     * Asks the user which formatting style they want to use.
     */
    private void askUserForTargetCase()
    {
        String userInput;

        System.out.println("Please press \"U\" for UPPER CASE, \"Q\" to quit, or any other key for Title Case.");

        userInput = System.console().readLine();    //Read the user input.

        if (userInput.toLowerCase().equals(userTypesThisToQuit))  //Check if the user wants to quit.
        {
            userWantsToContinue = false;
            System.out.println("Quitting program...");
        }
        else if (userInput.toLowerCase().equals("u"))
        {
            desiredCase = EnumDesiredCase.UpperCase;
            System.out.println("The document will be formatted in UPPER CASE.");
        }
        else
        {
            desiredCase = EnumDesiredCase.TitleCase;
            System.out.println("The document will be formatted in Title Case.");
        }
    }   //askUserForTargetCase

    /**
     * Getter for the Input File Path.
     *
     * @return : The input file path as a string.
     */
    public String getInputFilePath()
    {
        return inputFilePath;
    }   //getInputFilePath

    /**
     * Getter for the Output File Path.
     *
     * @return : The output file path as a string.
     */
    public String getOutputFilePath()
    {
        return outputFilePath;
    }   //getOutputFilePath

    /**
     * Getter for the Desired Case.
     *
     * @return : The case formatting desired by the user.
     */
    public EnumDesiredCase getDesiredCase()
    {
        return desiredCase;
    }   //getDesiredCase

    /**
     * Getter for whether or not the user wants to continue.
     *
     * @return : The boolean value of whether or not the user wants to continue.
     */
    public boolean getIfUserWantsToContinue()
    {
        return userWantsToContinue;
    }   //getIfUserWantsToContinue
}
