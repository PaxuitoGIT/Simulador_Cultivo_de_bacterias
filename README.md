# Simulador para gestionar cultivos de bacterias

Link del repositorio: https://github.com/PaxuitoGIT/Simulador_Cultivo_de_bacterias

## Análisis y descripción de la aplicación

He creado 3 paquetes, cada una representando la lógica del experimento, la interfaz gráfica para el usuario y un manejador de archivos para guardar y cargar los datos del disco duro.

Las clases que hay dentro del paquete "Lógica", como por ejemplo "Experimento", sirve para crear, eliminar y listar las poblaciones de las bacterias. La clase "PoblacionBacterias" 
contiene los atributos que luego el usuario le dará el valor correspondiente a las bacterias como el nombre, las fechas del experimento, la temperatura...étc. La clase "DosisAlimento"
sirve para calcular las condiciones que el usuario vaya a meter cuando cree la población, como por ejemplo, si el día es menor o igual que el día en el que se empiece a consumir los alimentos,
que sume la comida inicial introducida y el día correspondiente.

La clase que hay en el paquete "Datos", sirve para manejar la carga y el guardado de archivos del experimento se accionará cuando se pulse los botones que hay en la interfaz gráfica.

Por último, la clase "UI" dentro del "GUI" es el responsable de mostrar y ejecutar las acciones de cada botón que ordene el usuario.

Las decisiones que he implementado ha sido guardar y cargar los datos en .JSON ya que es un formato de texto sencillo y es fácil de interpretar los datos tanto a vista humana como máquina, por tanto,
he tenido que implementar la serialización en las clases que hay en el paquete "Lógica". Además, he implementado gracias al Maven las dependencias necesarias para el JSON que es 
la gson de Google. Luego, en la interfaz añadí el SwingX para hacer algunas casillas más bonitas y el uso de un DatePicker para escoger las fechas de forma más rápida (Calcula 
la fecha final de forma automática cuando se escoge la fecha inicial). 

Las comprobaciones y excepciones que se han implementado ha sido que al pinchar ver detalles o eliminar poblaciones se compruebe si existe alguna bacteria, las dosis de comida que se introduzcan
deben ser menor a 300 y el dia en el que empiecen a consumir (decrecer los alimentos) sea entre 1 y 30, la lectura de archivos...

## Listado de fallos conocidos

Los errores que no he podido solucionar ha sido que si la comida final es mayor que la comida inicial y la comida inicial llega a ser más que la comida final antes del día de consumición, empieza del revés (aumenta) en vez de decrecer.

Otro error que ha surgido es que si se ejecuta el "Main" desde el IntelliJ, debería poder cargar el archivo "Ejemplo.json" y leer sus datos pero el ejecutable .jar no es 
capaz de cargar ese ejemplo en concreto. Sin embargo, si se ha guardado un experimento .json desde el ejecutable .jar y se carga el archivo .json creado por el ejecutable, sí deja leer los datos de forma correcta.

## Conclusión 

Se ha creado un simulador de cultivo de bacterias cumpliendo lo más posible con las instrucciones dadas estructurando el programa en 3 paquetes, con un diseño simple para el usuario, pudiendo leer y guardar los datos en un .JSON.
