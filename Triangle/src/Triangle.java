
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Triangle {

public static int maxTriangleSum(String filePath) {
    String currentLine = "";
    String[] adjacentNums = new String[2];
    String[] arrayOfLine;
    int currIndexOfFirst = 0;
    int currIndexOfSecond = 1;
    long firstNum = 0;
    long secondNum = 0;
    int sum = 0;
    try {
        //readfile
        Scanner scan = new Scanner(new File(filePath));

        //extract the first number
        sum = scan.nextInt();;
        while (scan.hasNextLine()) {

            //store entire next line
            currentLine = scan.nextLine();

            //trim whitespace at the end of eachline
            currentLine.trim();

            //make sure line isnt the empty string or whitespace
            if (!currentLine.equals("") && !currentLine.equals(" ")) {
                //populate a string array with the numbers of the current line
                arrayOfLine = toStringArray(currentLine);

                //adjNums will be  0, 1 to begin.
                adjacentNums[0] = arrayOfLine[currIndexOfFirst];
                adjacentNums[1] = arrayOfLine[currIndexOfSecond];

                //change the strings into ints for computation
                 firstNum = Integer.parseInt(adjacentNums[0]);
                 secondNum = Integer.parseInt(adjacentNums[1]);

                if (firstNum >= secondNum)
                {
                    sum += firstNum;
                }
                else if(firstNum < secondNum)
                {
                    sum += secondNum;
                    currIndexOfFirst++;
                    currIndexOfSecond++;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return sum;
}
    //changes the String input into a String []
     public static String [] toStringArray(String input)
     {
         int length = numInputs(input);
         String [] stringArray = new String[length];
         int beginIndex =0;

         //the end of the first string will be the index of the next whitespace
         int endIndex =input.indexOf(" ");

         for (int i = 0; i < stringArray.length ; i++) {

         //beginning index will smaller until the last whitespace
            if(beginIndex < endIndex)
            {
                stringArray[i] = input.substring(beginIndex, endIndex);
                beginIndex = endIndex + 1;
                endIndex = input.indexOf(" ", beginIndex);
            }
             else
                stringArray[i] = input.substring(beginIndex);
        }
         return stringArray;
     }

    //Counts the number of integers in an input String
    //by searching the string for whitespace
    public static int numInputs(String input)
    {
        int result = 0;
        for (int i = 0 ; i <input.length() ; i++) {
            if(input.charAt(i) == ' ')
            {
                result++;
            }
        }
        return result+1;
    }

    public static void main(String [] args)
    {
        String filePath = "triangle.txt";
        System.out.println(maxTriangleSum("triangle.txt"));
    }
}

