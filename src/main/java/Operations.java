import entities.User;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.Node;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Operations {
    public static void diezPilotosMasActivos(){
        System.out.println("Diez pilotos más activos");
    }

    public static void quinceUsuariosMasActivos(){
        System.out.println("Quince usuarios más activos");
        /*int Actividad = 0;
        for (User.name : CSVReader.userNamesAppereance) {

            Actividad ++;

        }*/

    }

    public static void cantidadHashTagsDistintos(){

        MyLinkedList<String> hashTagsDistintos = new MyLinkedListImpl<>();
        int contadorHashtagsDistintos = 0;
        try{
            Scanner fechaIntro = new Scanner(System.in);
            System.out.println("Introduza una fecha en el formato YYYY-MM-DD");
            String fechaString = fechaIntro.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(fechaString, dateFormat);

            for (int i = 0; i < CSVReader.tweets.size(); i++){
                String fechaString2 = String.valueOf(CSVReader.tweets.get(i).getDate());
                String fechaString3 = String.valueOf(fecha);
                if (fechaString2.contains(fechaString3)){
                    String[] hashTagsVector = CSVReader.tweets.get(i).getHashtags();      //Arreglar, no está imprimiendo
                    for (int j = 0; j < hashTagsVector.length; j++){
                        String stringSinCosas = hashTagsVector[j].replace("[", "");
                        stringSinCosas = stringSinCosas.replace("]","");
                        stringSinCosas = stringSinCosas.replace("'","");
                        stringSinCosas = stringSinCosas.replace(",","");
                        if (!hashTagsDistintos.contains(stringSinCosas)){
                            hashTagsDistintos.add(stringSinCosas);
                            contadorHashtagsDistintos ++;
                        }
                    }
                }
            }
            System.out.println("La cantidad de hashtags distintos en la fecha " + fecha + " es de " + contadorHashtagsDistintos + " hashtags");


        }catch (java.time.format.DateTimeParseException e){
            System.out.println("Fecha invalida, el mes no está entre 1y 12, o el dia no está entre 1 y 31, o no se ha ingresado en el formato correcto");
        }
    }

    public static void hashTagMasUsado(){
        try{
            Scanner fechaIntro = new Scanner(System.in);
            System.out.println("Introduza una fecha en el formato YYYY-MM-DD");
            String fechaString = fechaIntro.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(fechaString, dateFormat);

        }catch (java.time.format.DateTimeParseException e){
            System.out.println("Fecha invalida, el mes no está entre 1y 12, o el dia no está entre 1 y 31, o no se ha ingresado en el formato correcto");
        }
    }

    public static void sieteCuentasMasFavoritos(){
        System.out.println("Siete cuentas con más favoritos");

    }

    public static void cantidadTweetsPalabraBuscada(){
        Scanner wordToSearch = new Scanner(System.in);
        System.out.println("Ingrese la palabra a buscar:");
        String palabraABuscar = wordToSearch.nextLine();

        int CantidadTweets = 0;


        for (int i = 0; i < CSVReader.tweets.size(); i++){
            if (CSVReader.tweets.get(i).getContent().contains(palabraABuscar)){
                CantidadTweets++;
            }
        }

        System.out.println("Cantidad de tweets con la palabra buscada: " + CantidadTweets);
    }
}
