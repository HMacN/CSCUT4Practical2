import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


/**
 * Class to handle file processing and part 1 of the assignment.
 */
public class FileProcessor
{
    private String inputFilePath;
    private String outputFilePath;
    private int linesInFile;
    private String stringArrayOfInputFileLines[];
    private String stringArrayOfOutputFileLines[];

    /**
     * Constructor captures file path of file to be processed, and sets up class variables.
     *
     * @param inputFilePath :  The file path of the file to be processed.
     */
    public FileProcessor(String inputFilePath, String outputFilePath)
    {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.linesInFile = numbersOfLinesInFile();
        stringArrayOfOutputFileLines = new String[linesInFile]; //Set up array to correct size
        this.stringArrayOfInputFileLines = scanTextFileToStringArray();
    }   //Constructor

    /**
     * Creates a file with the names correctly capitalised and the dates correctly formatted.
     *
     */
    public void convertDocumentToTitleCase()
    {
        int dateColumnOffset = lengthOfLongestString(stringArrayOfInputFileLines);

        for (int i = 0; i < linesInFile; i++)
        {
            stringArrayOfOutputFileLines[i] = convertStringToTitleCase(stringArrayOfInputFileLines[i], dateColumnOffset);
        }
    }   //convertDocumentToTitleCase

    /**
     * Converts given strings of names and dates to correctly formatted ones.
     *
     * @param inputString : The string to be reformatted.
     * @param dateColumnOffset :  The number of characters to write before starting to write the date.
     * @return : The correctly formatted string to return.
     */
    private String convertStringToTitleCase (String inputString, int dateColumnOffset)
    {
        String result = "";
        int pointInStringToStartReadingDate = inputString.length() - 8;
        String unformattedName = inputString.substring(0, pointInStringToStartReadingDate);
        String unformattedDate = inputString.substring(pointInStringToStartReadingDate);
        String formattedDate = "";
        String formattedName = "";




        result = formattedName + spacesBeforeNextColumn(formattedName.length(), dateColumnOffset) + formattedDate);     //Build correctly formatted output.

        return result;
    }   //convertStringToTitleCase

    /**
     * Generates a string of space characters the correct length to align a second column of text in a file.
     *
     * @param charactersInFirstColumn : The number of characters in the first column being printed.
     * @param charactersBeforeSecondColumn : The set number of characters before the second column.
     * @return : The string consisting of the correct number of spaces.
     */
    private String spacesBeforeNextColumn (int charactersInFirstColumn, int charactersBeforeSecondColumn)
    {
        String stringFullOfSpaces = "";

        for (int i = charactersInFirstColumn; i < charactersBeforeSecondColumn; i++)
        {
            stringFullOfSpaces += " ";
        }

        return stringFullOfSpaces;
    }   //spacesBeforeNextColumn

    /**
     * Returns the integer length of the longest string in the array.
     */
    private int lengthOfLongestString (String[] inputStringArray)
    {
        int lengthOfLongestStringFoundSoFar = 0;

        for (String element : inputStringArray)   //For each entry in array:
        {
            if (element.length() > lengthOfLongestStringFoundSoFar)    //Check if the string is the longest one found so far.
            {
                lengthOfLongestStringFoundSoFar = element.length();    //Update the longest string found so far.
            }
        }

        return lengthOfLongestStringFoundSoFar;
    }   //lengthOfLongestString


    /**
     * Writes the array of string outputs to the given file location.
     */
    private void writeToFile() throws FileNotFoundException //Needed for PrintWriter
    {
        PrintWriter writer = new PrintWriter(this.outputFilePath);  //Set up print writer.


        for (int i = 0; i < linesInFile; i++)
        {
            writer.println(stringArrayOfOutputFileLines[i] + "\n");    //Output each array element to a new line.
        }

        writer.close(); //Make sure PrintWriter is closed before exit.
    }   //writeToFile

    /**
     *Parses a given file to an array of strings, with one string element for each line in the file.
     *
     * @return result[] : The string array of the lines in the file.
     */
    private String[] scanTextFileToStringArray()
    {
        String result[] = new String[this.linesInFile]; //Creates an array with an entry for each line in the given file.
        Scanner inputFileScanner = new Scanner(this.inputFilePath);

        for (int i = 0; i < result.length; i++)
        {
            result[i] = inputFileScanner.nextLine(); //Parse the file into a String array.
        }

        inputFileScanner.close();   //Make sure the scanner is closed.
        return result;
    }   //scanTextFIleToStringArray

    /**
     * Gets the number of distinct lines in a given file.
     *
     * @return result : The number of lines in the text file.
     */
    private int numbersOfLinesInFile()
    {
        int result = 0;
        Scanner inputFileScanner = new Scanner(this.inputFilePath);

        while (inputFileScanner.hasNextLine())  //If there is another line for te scanner to move to:
        {
            result++;   //Count a new line.
            inputFileScanner.nextLine();    //Increment the scanner to the next line.
        }

        inputFileScanner.close();   //Make sure the scanner is closed.
        return result;
    }   //numbersOfLinesInAFile

}   //FileProcessor
