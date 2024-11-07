import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AdventureTime {

    /**
     * This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
    }

    /**
     * TODO 1
     * <p>
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        File file = new File(fileName);
        Scanner scanner1 = new Scanner(file);
        int lineCount = 0;
        while (scanner1.hasNextLine()) {
            lineCount++;
            scanner1.nextLine();
        }
        Scanner scanner2 = new Scanner(file);
        int[] array = new int[lineCount];
        for (int i = 0; i < lineCount; i++) {
            array[i] = scanner2.nextInt();
        }
        for (int n = 0; n < array.length-1; n++) {
            if (array[n + 1] > array[n]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws IOException {
        int count = 0;
        File file = new File(fileName);
        Scanner scanner1 = new Scanner(file);
        int lineCount = 0;
        while (scanner1.hasNextLine()) {
            lineCount++;
            scanner1.nextLine();
        }
        Scanner scanner2 = new Scanner(file);
        int[] array = new int[lineCount];
        for (int i = 0; i < lineCount; i++) {
            array[i] = scanner2.nextInt();
        }
        for (int n = 0; n < array.length-3; n++) {
            if (array[n + 1] + array[n+2] + array [n+3] > array[n] + array[n+1] + array[n+2]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;
        int count = 0;
        File file = new File(fileName);
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextLine()) {
            count++;
            scanner1.nextLine();
        }
        Scanner scanner2 = new Scanner(file);
        String[] array = new String[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner2.nextLine();
        }
        for (int n = 0; n < array.length; n++) {
            if (array[n].substring(0,2).equals("fo")) {
                horizontal = horizontal + Integer.parseInt(array[n].substring(8));
            }
            if (array[n].substring(0,2).equals("do")) {
                depth = depth + Integer.parseInt(array[n].substring(5));
            }
            if (array[n].substring(0,2).equals("up")) {
                depth = depth - Integer.parseInt(array[n].substring(3));
            }
        }
        return depth * horizontal;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;
        int count = 0;
        int aim = 0;
        File file = new File(fileName);
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextLine()) {
            count++;
            scanner1.nextLine();
        }
        Scanner scanner2 = new Scanner(file);
        String[] array = new String[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner2.nextLine();
        }
        for (int n = 0; n < array.length; n++) {
            if (array[n].substring(0,2).equals("fo")) {
                horizontal = horizontal + Integer.parseInt(array[n].substring(8));
                depth = depth + aim * Integer.parseInt(array[n].substring(8));
            }
            if (array[n].substring(0,2).equals("do")) {
                aim = aim + Integer.parseInt(array[n].substring(5));
            }
            if (array[n].substring(0,2).equals("up")) {
                aim = aim - Integer.parseInt(array[n].substring(3));
            }
        }
        return depth * horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}