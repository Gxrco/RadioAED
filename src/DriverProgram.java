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

    public static void manageSlots(Scanner sc, Radio radio){
        //Se selecciona el slot deseado en la frecuencia deseada
        if (radio.getFrequence() == "AM") {
            for (int i = 0; i < 11 ; i++) {
                int o = i+1;
                System.out.println(o + ". " + radio.getAMSavedStation());
            }
            System.out.println("Cual Slot elige? ");
            int x= sc.nextInt();
            if (radio.getAMSavedStation()[x]== 0){
                System.out.println("Este Slot no tiene guardado una estacion");
            }else {
                int station= radio.getAMSavedStation()[x];
                radio.setAMActualStation(station);
            }
        } else if (radio.getFrequence()== "FM") {
            for (int i = 0; i < 11 ; i++) {
                int o = i+1;
                System.out.println(o + ". " + radio.getFMSavedStation());
            }
            System.out.println("Cual Slot elige? ");
            int x= sc.nextInt();
            if (radio.getFMSavedStation()[x]== 0.0){
                System.out.println("Este Slot no tiene guardado una estacion");
            }else {
                double station= radio.getFMSavedStation()[x];
                radio.setFMActualStation(station);
            }
        }
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
