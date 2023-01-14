import java.util.Scanner;

public class DriverProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Radio radio = new Radio();

        while(radio.isOn()){
            display();
            menu(sc, radio);
        }
    }

    public static void display(){
        //Mostrar lo necesario en pantalla
    }

    public static void manageSlots(Scanner sc){
        //Se selecciona el slot deseado en la frecuencia deseada
    }

    public static void menu(Scanner sc, Radio radio){
        System.out.println("Opciones");
        System.out.println("-".repeat(30));
        System.out.println("1. Encender/Apagar \n2. Cambiar estacion \n3. Seleccionar una estacion guardada \n4. Guardar la estacion actual");
        System.out.println("-".repeat(30));
        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt){
            case 1:
                radio.off();
                break;
            case 2:
                System.out.println("Siguiente (F) / Anterior (B)");
                String op = sc.nextLine();
                if(op.equals("F")){
                    radio.Forward();
                } else if(op.equals("B")){
                    radio.Backward();
                }else {
                    System.out.println("NO DISPONIBLE");
                }
                break;
            case 3:
                manageSlots(sc, radio);
            case 4:
                if(radio.getFrequence().equalsIgnoreCase("AM")){
                    radio.saveAMStation(radio.getAMActualStation(), radio.getAMSlot(radio.getSlotF()));
                }else{
                    radio.saveFMStation(radio.getFMActualStation(), (int) radio.getFMSlot(radio.getSlotF()));
                }
        }
    }
}
