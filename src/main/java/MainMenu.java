
import java.io.IOException;
import java.util.Scanner;

public interface MainMenu {


    public static void Menu() throws IOException {
        try{

        Scanner optionSelect = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Menú principal");
        System.out.println("0. Cargar datos del CSV");
        System.out.println("1. Los 10 pilotos activos más mencionados en los tweets en un mes");
        System.out.println("2. Los 15 usuarios más activos en un mes");
        System.out.println("3. Cantidad de HashTags distintos para un día dado");
        System.out.println("4. HashTag más usado para un día dado");
        System.out.println("5. 7 cuentas con más favoritos");
        System.out.println("6. Cantidad de tweets con una palabra");
        System.out.println("7. Salir");
        System.out.println("Seleccione una opción mediante un número: ");

        Integer opcion = optionSelect.nextInt();

        switch (opcion){
            case 0:
                long startTime0 = System.currentTimeMillis();
                System.out.println("Cargar datos del CSV");
                CSVReader.CargaDeDatos();
                long endTime0 = System.currentTimeMillis();
                long duration0 = (endTime0 - startTime0);
                System.out.println("Demora carga" + "" + duration0 + "ms");
                Menu();
                break;
            case 1:
                Operations.diezPilotosMasActivos();
                Menu();
                break;
            case 2:
                System.out.println("Los 15 usuarios más activos en un mes son:");
                Operations.quinceUsuariosMasActivos();
                Menu();
                break;
            case 3:
                System.out.println("Cantidad de HashTags distintos para un día dado:");
                long startTime3 = System.currentTimeMillis();
                Operations.cantidadHashTagsDistintos();
                long endTime3 = System.currentTimeMillis();
                long duration3 = (endTime3 - startTime3);
                System.out.println("Demora carga" + "" + Operations.duration3 + "ms");
                Menu();
                break;
            case 4:
                System.out.println("HashTag más usado para un día dado:");
                Operations.hashTagMasUsado();
                Menu();
                break;
            case 5:
                System.out.println("7 cuentas con más favoritos:");
                Operations.sieteCuentasMasFavoritos();
                Menu();
                break;
            case 6:
                long startTime6 = System.currentTimeMillis();
                Operations.cantidadTweetsPalabraBuscada();
                long endTime6 = System.currentTimeMillis();
                long duration6 = (endTime6 - startTime6);
                System.out.println("Demora carga" + "" + duration6 + "ms");
                Menu();
                break;

            case 7:
                System.out.println("Saliendo...");
                break;

            default:
                //Si no es una de las opciones listadas, informamos y volvemos a llamar al menú
                System.out.println("Opción inválida");
                Menu();
                break;

            }}
            catch(java.util.InputMismatchException LetraEnLugarDeNumero){
                System.out.println("Ha ingresado una letra en lugar de un número");
                Menu();
            }
        }

    public static void main(String[] args) throws IOException {
        Menu();
    }
}

