import entities.User;
import uy.edu.um.prog2.adt.linkedlist.Node;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Operations {
    public static void diezPilotosMasActivos(){
        System.out.println("Diez pilotos más activos");
    }

    /*public static void quinceUsuariosMasActivos(){
        LocalDateTime Key = User.getUser_created();
        String[] userArray = new String[CSVReader.users.size()];
        Node<String> nodo = CSVReader.userNames.getHead();
        int i = 0;
        while (nodo != null) {
            userArray[i] = nodo.getElement();
            nodo = nodo.getNext();
            i++;
        }
        Sorting.heapSort(userArray, 15);

        for (int j = 0; j < 15; j++) {
            String nombre = userArray[userArray.length - 1 - j];
            User user = CSVReader.users.get(Key);
            System.out.println(user.getName() + " " + user.getTweets().size() + "" + user.getUser_verified());
        }

    }*/

    public static void cantidadHashTagsDistintos(){
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
        System.out.println("Cantidad de tweets con la palabra buscada:");
        String palabraABuscar = wordToSearch.nextLine();
    }
}
