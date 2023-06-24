import entities.User;
import uy.edu.um.prog2.adt.linkedlist.Node;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public class Operations {
    public static void diezPilotosMasActivos(){
        System.out.println("Diez pilotos más activos");
    }

    public static void quinceUsuariosMasActivos(){
        /*String[] userArray = new String[userNames.size];
        Node<String> nodo = userNames.getHead();
        int i = 0;
        while (nodo != null) {
            userArray[i] = nodo.getElement();
            nodo = nodo.getNext();
            i++;
        }
        MergeSort.MergeSort(userArray, users);

        for (int j = 0; j < 15; j++) {
            String nombre = userArray[userArray.length - 1 - j];
            User user = users.get(nombre).getValue();
            System.out.println(user.getName() + " " + user.getTweets().size());
        }*/

    }

    public static void cantidadHashTagsDistintos(){
        System.out.println("Cantidad de HashTags distintos");
        // implementacion aca abajo
        int cantidad = 0;
        System.out.println("prueba commit");
        //for (HashTag hashTag : hashTags.values()) {
    }

    public static void hashTagMasUsado(){
        System.out.println("HashTag más usado");
    }

    public static void sieteCuentasMasFavoritos(){
        System.out.println("Siete cuentas con más favoritos");
    }

    public static void cantidadTweetsPalabraBuscada(){
        System.out.println("Cantidad de tweets con la palabra buscada");
    }
}
