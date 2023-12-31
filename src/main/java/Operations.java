import entities.Driver;
import entities.Tweet;
import entities.User;
import uy.edu.um.prog2.adt.hash.MyHash;
import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.Node;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.heap.MyHeap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.YearMonth;

public class Operations {

    static long duration3 = 0;
    public static void diezPilotosMasActivos(){

        long startTime1 = System.currentTimeMillis();
        MyHeap<Integer> heapPilotos = new MyHeapImpl<>(20);
        int h = 0;

        try{
        Scanner mesIntro = new Scanner(System.in);
        System.out.println("Introduza un mes en el formato MM");
        String mesString = mesIntro.nextLine();
        Scanner anoIntro = new Scanner(System.in);
        System.out.println("Introduza un año en el formato YYYY");
        String anoString = anoIntro.nextLine();
        String anoMesString = anoString + "-" + mesString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth fechaABuscar = YearMonth.parse(anoMesString, formatter);
        System.out.println(fechaABuscar);

            for (int i = 0; i < CSVReader.pilotosActivos.size(); i++){
                for (int j = 0; j < CSVReader.tweets.size(); j++){
                String[] nombreCompleto = CSVReader.pilotosActivos.get(i).getDriverName().split(" ");
                String nombre = nombreCompleto[0];
                String apellido = nombreCompleto[1];
                if(nombreCompleto.length == 3){
                    apellido += " " + nombreCompleto[2];
                }

                boolean seMenciona = CSVReader.tweets.get(j).getContent().contains(nombre) || CSVReader.tweets.get(j).getContent().contains(apellido);

                if (seMenciona == true){
                    CSVReader.pilotosActivos.get(i).setMentions(CSVReader.pilotosActivos.get(i).getMentions() + 1);

                }
                }
                heapPilotos.insert(CSVReader.pilotosActivos.get(i).getMentions());
        }
            for(int i = 0; i < 20; i++){
                if(i > 9){

                    for(int i1 = 0; i1 < CSVReader.pilotosActivos.size() - 1; i1++){
                        if(CSVReader.pilotosActivos.get(i1).getMentions() == heapPilotos.get()){
                        System.out.println(CSVReader.pilotosActivos.get(i1).getDriverName()+ " " + heapPilotos.get());
                        heapPilotos.delete();
                    }
                }
            }
                else{
                    heapPilotos.delete();
                }
            }
        }catch (java.time.format.DateTimeParseException e){
            System.out.println("Fecha inválida, el mes no está en el formato correcto");
        }
        catch (java.lang.NullPointerException e){

        }
        long endTime1 = System.currentTimeMillis();
        long duration1 = (endTime1 - startTime1);
        //System.out.println(duration1);
    }   //Completa


    public static void quinceUsuariosMasActivos(){

        MyHeap<Integer> heapUsuarios = new MyHeapImpl<>(500000);
        long startTime2 = System.currentTimeMillis();
        try{


            for (int i = 0; i < CSVReader.usersKeyNumber.size(); i++){

            heapUsuarios.insert(CSVReader.usersKeyNumber.get(i).getCant_tweets());
        }
            Integer[] arrayUsuarios = new Integer[heapUsuarios.size()];
            for(int i1 = 0; i1 < CSVReader.usersKeyNumber.size(); i1++){
                int cosa = heapUsuarios.get();
                heapUsuarios.delete();
                arrayUsuarios[i1] = cosa;
            }
            for(int i2 = 0; i2 < 15; i2++){

                System.out.println(CSVReader.usersKeyNumber.get(CSVReader.usersKeyNumber.size() -i2 -1).getName()+ " " + arrayUsuarios[arrayUsuarios.length - i2 -1] +" " + CSVReader.usersKeyNumber.get(CSVReader.usersKeyNumber.size() -i2 -1).getUser_verified());
            }

        }
        catch (java.lang.NullPointerException e){

        }
        long endTime2 = System.currentTimeMillis();
        long duration2 = (endTime2 - startTime2);
        //System.out.println(duration2);
    }




    public static void cantidadHashTagsDistintos(){

        long startTime3 = System.currentTimeMillis();
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
                    String[] hashTagsVector = CSVReader.tweets.get(i).getHashtags();
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
            long endTime3 = System.currentTimeMillis();
            long duration3 = (endTime3 - startTime3);
            //System.out.println(duration3);

        }catch (java.time.format.DateTimeParseException e){
            System.out.println("Fecha invalida, el mes no está entre 1y 12, o el dia no está entre 1 y 31, o no se ha ingresado en el formato correcto");
        }
    }  //Completa

    public static void hashTagMasUsado(){
        /*try{
            Scanner fechaIntro = new Scanner(System.in);
            System.out.println("Introduza una fecha en el formato YYYY-MM-DD");
            String fechaString = fechaIntro.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(fechaString, dateFormat);

            MyHash<Integer, String> hashHashtags = new MyHashImpl<>(50000);
            int contadorHashtagsDistintos = 0;
            int contadorUsos = 0;


            for (int i = 0; i < CSVReader.tweets.size(); i++){
                String fechaString2 = String.valueOf(CSVReader.tweets.get(i).getDate());
                String fechaString3 = String.valueOf(fecha);
                if (fechaString2.contains(fechaString3)){
                    String[] hashTagsVector = CSVReader.tweets.get(i).getHashtags();
                    for (int j = 0; j < hashTagsVector.length; j++){
                        String stringSinCosas = hashTagsVector[j].replace("[", "");
                        stringSinCosas = stringSinCosas.replace("]","");
                        stringSinCosas = stringSinCosas.replace("'","");
                        stringSinCosas = stringSinCosas.replace(",","");
                        if (!hashHashtags.contains(stringSinCosas)){
                            hashHashtags.put(contadorHashtagsDistintos, stringSinCosas);
                        }
                        else{
                            int indice = hashTags.indexOf(stringSinCosas);
                            int usos = hashTagsUsos.get(indice);
                            usos ++;
                            hashTagsUsos.set(indice, usos);
                        }
                    }
                }
            }
            try{
            for (int i = 0; i < CSVReader.tweets.size(); i++){
                hashTagsDistintos.insert(hashTagsUsos.get(i));
                //hashTagsDistintos.extract();
                System.out.println(hashTagsDistintos.peek());
            }
            }
            catch (Exception e){
                System.out.println("Error");
            }
            System.out.println("El hashtag más usado en la fecha " + fecha + " es " + "" + " usos");




        }catch (java.time.format.DateTimeParseException e){
            System.out.println("Fecha invalida, el mes no está entre 1y 12, o el dia no está entre 1 y 31, o no se ha ingresado en el formato correcto");
        }*/
    }   //Incompleta

    public static void sieteCuentasMasFavoritos(){
        System.out.println("Siete cuentas con más favoritos");
        MyHeap<Integer> heapCuentas = new MyHeapImpl<>(500000);

        try{
        for(int i = 0; i < CSVReader.users.size(); i++){
            int favouritesInt = Math.round((CSVReader.usersKeyNumber.get(i).getUser_favourites()));
            heapCuentas.insert(favouritesInt);

            for(int i1 = 0; i1 < CSVReader.usersKeyNumber.size() ; i++){
                if(i > 8){

                    for(int i2 = 0; i2 < CSVReader.usersKeyNumber.size() - 1; i1++){
                        if(CSVReader.usersKeyNumber.get(i2).getUser_favourites() == heapCuentas.get()){
                            System.out.println(CSVReader.usersKeyNumber.get(i1).getName()+ " " + heapCuentas.get());
                            heapCuentas.delete();
                        }
                    }
                }
                else{
                    heapCuentas.delete();
                }
            }
        }
        }catch(RuntimeException e){

        }



    }       //Incompleta

    public static void cantidadTweetsPalabraBuscada(){
        Scanner wordToSearch = new Scanner(System.in);
        System.out.println("Ingrese la palabra a buscar:");
        String palabraABuscar = wordToSearch.nextLine();

        long startTime6 = System.currentTimeMillis();
        int CantidadTweets = 0;


        for (int i = 0; i < CSVReader.tweets.size(); i++){
            if (CSVReader.tweets.get(i).getContent().contains(palabraABuscar)){
                CantidadTweets++;
            }
        }

        System.out.println("Cantidad de tweets con la palabra buscada: " + CantidadTweets);
        long endTime6 = System.currentTimeMillis();
        long duration6 = (endTime6 - startTime6);
        //System.out.println(duration6);
    }   //Completa
}
