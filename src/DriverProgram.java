import java.util.Scanner;

public class DriverProgram {

    /**
     * Metodo para ejecutar el programa
     * @param args argumentos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Radio radio = new Radio();

        while(radio.isOn()){
            display(radio);
            menu(sc, radio);
        }
    }

    /**
     * Metodo para mostrar al usuario la informacion de la radio
     * @param radio Objeto de radio
     */
    public static void display(Radio radio){
        if(radio.getFrequence() == null){
            System.out.println("Current Frequency: No Frequency Selected.");
            System.out.println("Current Station: No Station Selected");
        }
        else if(radio.getFrequence().equalsIgnoreCase("FM")){
            System.out.println("Current Frequency: " + radio.getFrequence());
            System.out.println("Current Station: " + radio.getFMActualStation());
        }
        else if(radio.getFrequence().equalsIgnoreCase("AM")) {
            System.out.println("Current Frequency: " + radio.getFrequence());
            System.out.println("Current Station: " + radio.getAMActualStation());
        }
    }

    /**
     * Manejo de las diferentes estaciones guardadas
     * @param sc Scanner
     * @param radio Objeto de radio
     */
    public static void manageSlots(Scanner sc, Radio radio){
        //Se selecciona el slot deseado en la frecuencia deseada
        if (radio.getFrequence().equals("AM")) {
            for (int i = 0; i < 12 ; i++) {
                int o = i+1;
                System.out.println(o + ". " + radio.getAMSavedStation()[i]);
            }
            System.out.println("Cual Slot elige? ");
            int x= sc.nextInt();
            if (radio.getAMSavedStation()[x-1]== 0){
                System.out.println("Este Slot no tiene guardado una estacion");
            }else {
                int station= radio.getAMSavedStation()[x-1];
                radio.setAMActualStation(station);
            }
        } else if (radio.getFrequence().equals("FM")){
            for (int i = 0; i < 12 ; i++) {
                int o = i+1;
                System.out.println(o + ". " + radio.getFMSavedStation()[i]);
            }
            System.out.println("Cual Slot elige? ");
            int x= sc.nextInt();
            if (radio.getFMSavedStation()[x-1]== 0.0){
                System.out.println("Este Slot no tiene guardado una estacion");
            }else {
                double station= radio.getFMSavedStation()[x-1];
                radio.setFMActualStation(station);
            }
        }
    }

    /**
     * Opciones para el usuario
     * @param sc Scanner
     * @param radio Objeto radio
     */
    public static void menu(Scanner sc, Radio radio){
        System.out.println("Opciones");
        System.out.println("-".repeat(30));
        System.out.println("1. Encender/Apagar \n2. Cambiar frecuencia \n3. Cambiar estacion \n4. Seleccionar una estacion guardada \n5. Guardar la estacion actual");
        System.out.println("-".repeat(30));
        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt){
            case 1:
                radio.off();
                break;
            case 2:
                System.out.println("1. FM \n2. AM");
                int x= sc.nextInt();
                if (x==1){
                    try {
                        radio.setFrequence("FM");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (x==2) {
                    try {
                        radio.setFrequence("AM");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 3:
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
            case 4:
                manageSlots(sc, radio);
                break;
            case 5:
                if(radio.getFrequence().equalsIgnoreCase("AM")){
                    radio.saveAMStation(radio.getAMActualStation(), radio.getAMSlot(radio.getSlotF()));
                }else{
                    radio.saveFMStation(radio.getFMActualStation(), (int) radio.getFMSlot(radio.getSlotF()));
                }
                break;
        }
    }
}
