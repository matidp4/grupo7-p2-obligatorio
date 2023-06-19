
import java.util.Scanner;

public interface MainMenu {


    public static void Menu() {
        Scanner optionSelect = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Menú principal");
        System.out.println("Seleccione una opción: ");

        Integer opcion = optionSelect.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Los 10 pilotos activos más mencionados en los tweets en un mes son:");
                Menu();
                break;
            case 2:
                System.out.println("Los 15 usuarios con más tweets son:");
                Menu();
                break;
            case 3:
                System.out.println("Cantidad de HashTags distiontos para un día dado:");
                Menu();
                break;
            case 4:
                System.out.println("HashTag más usado para un día dado:");
                Menu();
                break;
            case 5:
                System.out.println("7 cuentas con más favoritos:");
                Menu();
                break;
            case 6:
                Scanner wordToSearch = new Scanner(System.in);
                System.out.println("Ingrese la palabra que desea buscar");
                String palbraABuscar = wordToSearch.nextLine();
                System.out.println("Cantidad de tweets con la palabra buscada:");
                Menu();
                break;
            default:
                System.out.println("Opción inválida");
                Menu();
                break;
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}

