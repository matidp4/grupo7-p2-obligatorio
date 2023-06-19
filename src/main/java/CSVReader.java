import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\matid\\Downloads\\f1_dataset_test.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                int user_id = Integer.valueOf(csvRecord.get(0));
                String user_name = csvRecord.get(1);
                String user_location = csvRecord.get(2);
                String user_description = csvRecord.get(3);
                String user_created = csvRecord.get(4);
                String user_followers = csvRecord.get(5);
                String user_friends = csvRecord.get(6);
                String user_favourites = csvRecord.get(7);
                String user_verified = csvRecord.get(8);
                String tweet_date = csvRecord.get(9);
                String tweet_text = csvRecord.get(10);
                String hashtags = csvRecord.get(11);
                String tweet_source = csvRecord.get(12);
                String isRetweet = csvRecord.get(13);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Id:" + user_id);
                System.out.println("Nombre:" + user_name);
                System.out.println("Ubicacion:" + user_location);
                System.out.println("Descripción:" + user_description);
                System.out.println("Fecha de creación:" + user_created);
                System.out.println("Seguidores: " + user_followers);
                System.out.println("Amigos: " + user_friends);
                System.out.println("Favoritos: " + user_favourites);
                System.out.println("Verificado?: " + user_verified);
                System.out.println("Fecha del tweet:" + tweet_date);
                System.out.println("Tweet:" + tweet_text);
                System.out.println("Hashtags: " + hashtags);
                System.out.println("Fuente del tweet: " + tweet_source);
                System.out.println("Es Retweet?: " + isRetweet);
                System.out.println("---------------\n\n");
            }
        }
    }
}
