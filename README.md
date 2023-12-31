Github Repo link: https://github.com/matidp4/grupo7-p2-obligatorio

# grupo7-p2-obligatorio
Obligatorio de Matías Di Palma y Antonella Parentini


## Ejecución

![UML](imagenes/DiagramaUML.jpg)

Diagrama UML del programa


![UsoMemoriaInicio](imagenes/UsoMemoria_AlIniciar.jpg)

Uso de memoria al inicar el programa

### Carga de datos
La clase CSVReader se encarga de la carga de datos y mediante el uso de la libreria Apache Commons CSV se parsea el archivo.
Luego se crean las entidades y se almacenan en diversas estructuras.

Los tweets se almacenan en un Hash y en una lista, los hashtags en una lista y los usuarios en un Hash con la fecha de creación con la key y otra con un número como id.)
También se lee el txt con los drivers y se les almacena en un Hash con un numero como key.

Demora de la función: alrededor de 1500ms con el dataset_test.csv

![UsoMemoriaCarga](imagenes/UsoMemoria_TrasCargarDatos.jpg)

Uso de memoria al cargar los datos

### Consulta 1 10 pilotos con más menciones
La consulta uno pide la fecha y verifica que sea correcta. Luego se recorre los pilots y se separan en nombre y apellido.
Se crea un boolean SeMenciona y si este boolean es true se le suma uno a las menciones de los pilotos.
Al final los ordena con un Heap y imprime los 10 con más menciones.

Demora de la función: alrededor de 2000ms con el dataset_test.csv

![UsoMemoriaCons1](imagenes/UsoMemoria_Consulta1.jpg)

Uso de memoria al hacer la consulta 1

### Consulta 2 15 usuarios con más tweets
Se obtiene la cantidad de tweets de los usuarios y se las ingresa a un Heap. Luego se ordenan en un Array y se imprimen los valores.

Demora de la función: alrededor de 153ms con el dataset_test.csv

![UsoMemoriaCons2](imagenes/soMemoria_Consulta2.jpg)

Uso de memoria al hacer la consulta 2

### Consulta 3 Cantidad de Hash Tags distintos para un día dado
Se crea una LinkedList de Hash Tags distintos.
Se pide la fecha y se verifica que sea correcta. Luego se recorre los tweets y se verifica que la fecha sea la misma que la ingresada.
Luego se verifica si los HashTags son distintos y se los ingresa a una LinkedList.
Finalmente se imprime el tamaño de la LinkedList.

Demora de la función: Alrededor de 3000ms con el dataset_test.csv

![UsoMemoriaCons3](imagenes/UsoMemoria_Consulta3.jpg)

Uso de memoria al hacer la consulta 3

### Consulta 4 HashTag más usado en un día dado
Incompleta

### Consulta 5 Siete cuentas con más favoritos
Incompleta

### Consulta 6 Cantidad de tweets con una palabra especifica
Se pide la palabra y se hace un contents con ella a la lista de Tweets.
Si la contiene se suma a un valor de Cantidad de tweets que se imprime al final.

Demora de la consulta: Alrededor de 1500ms con el dataset_test.csv

![UsoMemoriaCons6](imagenes/UsoMemoria_Consulta6.jpg)

Uso de memoria al hacer la consulta 6