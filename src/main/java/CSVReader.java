import entities.HashTag;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import entities.Tweet;
import entities.User;

import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class CSVReader {
    private static final String filePath = "C:\\Users\\matid\\Downloads\\f1_dataset_test.csv";
    private static final String txtPath = "C:\\Users\\matid\\Downloads\\drivers.txt";

    //Establece variables y nombres de tads de almacenamiento
    static Boolean primeraPasada = true;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    Tweet[] tweetsArray = new Tweet[500_000];
    static MyLinkedList<String> tweetsList = new MyLinkedListImpl<>();
    static MyHashImpl<LocalDateTime, User> users = new MyHashImpl<>(100_000);
    static MyHashImpl<Integer, Tweet> tweets = new MyHashImpl<Integer, Tweet>(500_000);
    static MyLinkedList<String> hashTags = new MyLinkedListImpl<>();
    static MyLinkedList<String> drivers = new MyLinkedListImpl<>();

    static Integer counter = 0;

    public static void CargaDeDatos() throws IOException {



        //Lee el CSV
        try (
                Reader reader = Files.newBufferedReader(Paths.get(filePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                if (primeraPasada) {
                    primeraPasada = false;
                }
                else{

                    try{
                    String user_name = csvRecord.get(1);
                    String user_location = csvRecord.get(2);
                    String user_description = csvRecord.get(3);
                    LocalDateTime user_created = LocalDateTime.parse(csvRecord.get(4), formatter);
                    Float user_followers = Float.parseFloat(csvRecord.get(5));
                    Float user_friends = Float.parseFloat(csvRecord.get(6));
                    Float user_favourites = Float.parseFloat(csvRecord.get(7));
                    Boolean user_verified = Boolean.parseBoolean(csvRecord.get(8));
                    LocalDateTime tweet_date = LocalDateTime.parse(csvRecord.get(9), formatter);
                    String tweet_text = csvRecord.get(10);
                    String hashtags = csvRecord.get(11);
                    String tweet_source = csvRecord.get(12);
                    Boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));



                    /*System.out.println("Record No - " + csvRecord.getRecordNumber());
                    System.out.println("---------------");
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
                    System.out.println("---------------\n\n");*/


                    //Almacena los datos
                    if(!users.contains(user_created)){
                        User nuevoUsuario = new User(user_created, user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
                        users.put(user_created, nuevoUsuario);
                    }



                        Tweet nuevoTweet = new Tweet(counter, tweet_text, hashtags, tweet_source, isRetweet,tweet_date);
                        tweets.put(counter, nuevoTweet);
                        tweetsList.add(tweet_text);

                    if(!hashTags.contains(hashtags)){
                        HashTag nuevoHashTag = new HashTag(hashtags);
                        hashTags.add(hashtags);
                    }

                    counter += 1;
                    //System.out.println("Counter" + counter); Para verificar que mantenga coherencia en lo que lee
                    }
                    catch(NumberFormatException e){
                        //

                    }
                    catch(DateTimeParseException e2){

                    }
                }
            }

            //Lee el txt con los drivers y los almacena
            try {
                File myObj = new File(txtPath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String driver = myReader.nextLine();
                    //System.out.println(driver);

                    if(!drivers.contains(driver)){
                        drivers.add(driver);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
