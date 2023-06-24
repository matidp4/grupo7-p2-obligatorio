
import java.util.Scanner;

public interface MainMenu {


    public static void Menu() {
        try{

        Scanner optionSelect = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Menú principal");
        System.out.println("1. Los 10 pilotos activos más mencionados en los tweets en un mes");
        System.out.println("2. Los 15 usuarios más activos en un mes");
        System.out.println("3. Cantidad de HashTags distiontos para un día dado");
        System.out.println("4. HashTag más usado para un día dado");
        System.out.println("5. 7 cuentas con más favoritos");
        System.out.println("6. Cantidad de tweets con una palabra");
        System.out.println("7. Salir");
        System.out.println("Seleccione una opción mediante un número: ");

        Integer opcion = optionSelect.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Los 10 pilotos activos más mencionados en los tweets en un mes son:");
                Menu();
                break;
            case 2:
                System.out.println("Los 15 usuarios más activos en un mes son:");
                Operations.quinceUsuariosMasActivos();
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

            case 7:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción inválida");
                Menu();
                break;

            }}
            catch(java.util.InputMismatchException LetraEnLugarDeNumero){
                System.out.println("Ha ingresado una letra en lugar de un número");
                Menu();
            }
        }

    public static void main(String[] args) {
        Menu();
    }
}
