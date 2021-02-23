import java.io.*;

/**
 * CSCU9T4 Java strings and files exercise.
 *
 * Code works for part 1 and 2, no separate FormatNamesm program was created.
 *
 */
public class FormatNames
{
    public static void main(String[] args)
    {
        String inputFilePath;
        String outputFilePath;
        EnumDesiredCase targetCase;
        InputGetter inputGetter = new InputGetter();


        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.

        //System.out.println("Length of args array: " + args.length);

        if (args.length < 2)   //If the user hasn't passed in any file paths:
        {
            inputGetter.captureData();  //Actually capture the input data.

            inputFilePath = inputGetter.getInputFilePath();     //Get data from the inputGetter object.
            outputFilePath = inputGetter.getOutputFilePath();
            targetCase = inputGetter.getDesiredCase();
        }
        else    //If the user has passed in enough arguments:
        {
            if (args[0].equals("-u"))  //Check for uppercase flag.
            {
                inputFilePath = args[1];
                outputFilePath = args[2];
                targetCase = EnumDesiredCase.UpperCase;
            }
            else
            {
                inputFilePath = args[0];
                outputFilePath = args[1];
                targetCase = EnumDesiredCase.TitleCase;
            }
        }



        //System.out.println("Input file: " + args[0] + ", Output File: " + args[1]);

        if (inputGetter.getIfUserWantsToContinue())  //If the user wants to continue.
        {
            FileProcessor fileProcessor = new FileProcessor(inputFilePath, outputFilePath);
            fileProcessor.convertDocumentCase(targetCase);
            fileProcessor.writeToFile();
        }
        
    } // main


} // FilesInOut
