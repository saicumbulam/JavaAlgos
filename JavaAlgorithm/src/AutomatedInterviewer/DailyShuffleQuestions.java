package AutomatedInterviewer;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class DailyShuffleQuestions {
    private static String leetCodePath = "JavaAlgorithm\\src\\Leetcode";
    private static HashMap<String, Integer> hashMap = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        Controller();
    }

    private static void Controller()
    {
        LoadThreshold();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            List<String> files = getFileFromFolder(Paths.get(leetCodePath, entry.getKey()).toString());
            List<String> selectedFiles = shuffler(files, entry.getValue());
            printList(selectedFiles, entry.getKey());
        }
    }

    private static void printList(List<String> list, String tag)
    {
        System.out.println(String.format("Today's question for %s:", tag));
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size()-1));
        System.out.print("\n\n");
    }

    private static List<String> shuffler(List<String> list, int times)
    {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            String randomElement = list.get(random.nextInt(list.size()));
            if (!result.contains(randomElement))
            {
                result.add(randomElement);
            }
        }
        return result;
    }


    private static void LoadThreshold()
    {
        hashMap.put("Easy", 5);
        hashMap.put("Medium", 3);
        hashMap.put("Hard", 2);
    }

    private static List<String> getFileFromFolder(String path)
    {
        List<String> result = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                result.add(listOfFiles[i].getName());
            }
        }
        return result;
    }
}
