package src;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {
        Scanner optionSelect = new Scanner(System.in);
        System.out.println("Seleccione una opción: ");

        Integer opcion = optionSelect.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Los 10 pilotos activos más mencionados en los tweets en un mes son:");
                break;
            case 2:
                System.out.println("Los 15 usuarios con más tweets son:");
                break;
            case 3:
                System.out.println("Cantidad de HashTags distiontos para un día dado:");
                break;
            case 4:
                System.out.println("HashTag más usado para un día dado:");
                break;
            case 5:
                System.out.println("7 cuentas con más favoritos:");
                break;
            case 6:
                System.out.println("Cantidad de tweets con la palabra buscada:");
                break;

        }
    }
}

