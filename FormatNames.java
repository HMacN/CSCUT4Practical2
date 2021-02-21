import java.io.*;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNames {

    public static void main(String[] args)
    {
        String inputFilePath;
        String outputFilePath;
        EnumDesiredCase targetCase;


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

        if (args[0].equals("-u"))
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

        //System.out.println("Input file: " + args[0] + ", Output File: " + args[1]);

        FileProcessor fileProcessor = new FileProcessor(inputFilePath, outputFilePath);
        fileProcessor.convertDocumentCase(targetCase);
        fileProcessor.writeToFile();


    } // main


} // FilesInOut
