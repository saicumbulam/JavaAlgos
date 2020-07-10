package AutomatedInterviewer;
import java.sql.*;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

class ProbsDef
{
    String name;
    LocalDate days;
    String category;

    public ProbsDef(String name, String days, String category) {
        this.name = name;
        this.days = LocalDate.parse(days);
        this.category = category;
    }
}

public class DailyShuffleQuestions {
    private static String leetCodePath = "JavaAlgorithm\\src\\Leetcode";
    private static HashMap<String, Integer> hashMap = new HashMap<>();
    private static Random random = new Random();
    private static Connection connection = null;
    private static String pastDate = "1970-01-01";

    public static void main(String[] args) {
        ResetRun();
        //Controller();
    }

    private static void ConnectDatabase()
    {
        boolean flag = false;
        File dbFile = new File("info.db");
        if (!dbFile.exists())
            flag = true;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:info.db");
            if (flag)
            {
                QueryExecutorVoid(
                        "CREATE TABLE PROBS " +
                        "(NAME TEXT NOT NULL, " +
                        " ACCESSDTE TEXT NOT NULL, " +
                        " CATEGORY CHAR(50)," +
                        " CONF TEXT)");
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static void QueryExecutorVoid(String query) {
        try
        {
            Statement stmt = connection.createStatement();
            String sql = query;
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static List<ProbsDef> QueryExecutorString(String query) {
        List<ProbsDef> result = new ArrayList<>();
        try
        {
            Statement stmt = connection.createStatement();
            String sql = query;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                result.add(new ProbsDef (
                        rs.getString("NAME"),
                        rs.getString("ACCESSDTE"),
                        rs.getString("CATEGORY"))
                );
            }
            rs.close();
            stmt.close();
        }
        catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }

    private static void CloseConnection() {
        try
        {
            connection.close();
        }
        catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void Controller()
    {
        LoadThreshold();
        ConnectDatabase();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            List<String> files = getFileFromFolder(Paths.get(leetCodePath, entry.getKey()).toString());
            List<ProbsDef> dbRows = QueryExecutorString("SELECT * FROM PROBS");
            InsertMissingProbs(files, dbRows, entry.getKey());
            List<String> selectedFiles = shuffler(entry.getKey(), entry.getValue());
            printList(selectedFiles, entry.getKey());
        }
        CloseConnection();
    }

    private static void ResetRun()
    {
        LoadThreshold();
        ConnectDatabase();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            List<String> files = getFileFromFolder(Paths.get(leetCodePath, entry.getKey()).toString());
            InsertMissingProbs(files, new ArrayList<>(), entry.getKey());
        }
    }

    private static void InsertMissingProbs(List<String> files, List<ProbsDef> dbRows,
                                           String category)
    {
        if (dbRows != null || dbRows.size() != 0)
        {
            for (ProbsDef item: dbRows) {
                files.remove(item.name);
            }
        }
        for (String item: files) {
            String sql = "INSERT INTO PROBS (NAME,ACCESSDTE,CATEGORY,CONF) " +
                    String.format("VALUES (\"%s\",\"%s\",\"%s\",\"%s\");", item,
                            pastDate,
                            category, "NS");
            QueryExecutorVoid(sql);
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

    private static List<String> shuffler(String category, int times)
    {
        List<String> result = new ArrayList<>();
        int count = times;
        List<ProbsDef> dbRows = QueryExecutorString(
                String.format("SELECT * FROM PROBS WHERE CATEGORY = '%s' " +
                        "AND (DATE('now') - ACCESSDTE) > %d AND " +
                        "CONF = \"%s\";",category, 7, "NS"));

        if (dbRows == null || dbRows.size() < count)
        {
            QueryExecutorVoid(String.format("UPDATE PROBS set ACCESSDTE = \"%s\" " +
                            "where (DATE('now') - ACCESSDTE) > %d " +
                            "AND " +
                            "CATEGORY = \"%s\";",
                    pastDate,7, category));
        }
        while (count > 0) {
            ProbsDef randomElement = dbRows.get(random.nextInt(dbRows.size()));
            if (!result.contains(randomElement.name))
            {
                result.add(randomElement.name);
                dbRows.remove(randomElement);
                QueryExecutorVoid(String.format("UPDATE PROBS set ACCESSDTE = \"%s\" " +
                                "where NAME=\"%s\";",
                        LocalDate.now().toString(),randomElement.name));
            }
            count--;
        }
        return result;
    }


    private static void LoadThreshold()
    {
        hashMap.put("Easy", 10);
        hashMap.put("Medium", 10);
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
