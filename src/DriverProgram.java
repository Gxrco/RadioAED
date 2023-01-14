import java.util.Scanner;

public class DriverProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Radio radio = new Radio();

        while(radio.isOn()){
            display();
            menu(sc);
        }
    }

    public static void display(){
        //Mostrar lo necesario en pantalla
    }

    public static void manageSlots(Scanner sc){
        //Se selecciona el slot deseado en la frecuencia deseada
    }

    public static void menu(Scanner sc){
        int opt = 0;
        switch (opt){
            case 1:
                //Apagado encendido
            case 2:
                //Siguiente/Anterior
            case 3:
                //Acceso directo slots AM y FM
            case 4:
                //Guardar nueva estacion
        }
    }
}
