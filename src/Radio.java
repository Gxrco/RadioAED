public class Radio implements IRadio{

    private boolean carStatus= true;
    private String frequence;
    private double FMStation = 87.9;
    private int AMStation = 530;
    private int slotF = 0;
    private int[] AMSavedStation = new int[12];
    private double[] FMSavedStation = new double[12];


    /**
     * Metodo para encender la radio
     */
    @Override
    public void on() {
        carStatus = true;
    }

    /**
     * Metodo para apagar la radio
     */
    @Override
    public void off() {
        carStatus = false;
    }

    /***
     * Este metodo nos indica si la radio esta encendida o apagada
     * @return true si la radio esta encendida y false cuando la radio este apagada
     */
    @Override
    public boolean isOn() {
        return carStatus;
    }

    /***
     * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
     * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
     */
    @Override
    public void setFrequence(String freq) throws Exception {
        if(!(freq.equalsIgnoreCase("FM") || (freq.equalsIgnoreCase("AM")))){
            throw new Exception("Only select the frequencies displayed (AM/FM).");
        }
        else{
            frequence = freq;
        }
    }

    /**
     * Obtener la frecuencia en la que se ubica la radio
     * @return AM o FM
     */
    @Override
    public String getFrequence() {
        if(!(frequence == null)){
            return frequence;
        }else{
            return null;
        }
    }

    /**
     * Pasar a la siguiente estacion segun sea la frecuencia
     */
    @Override
    public void Forward() {
        if(getFrequence().equals("AM")){
            if(AMStation >= 530 && AMStation <= 1600){
                setAMActualStation(AMStation + 10);
            }else{
                setAMActualStation(530);
            }
        }else{
            if(FMStation >= 87.9 && FMStation <= 107.7){
                setFMActualStation(Math.round((FMStation + 0.2)*100.0)/100.0);
            }else{
                setFMActualStation(87.9);
            }
        }
    }

    /**
     * Regresar a la anterior estacion segun sea la frecuencia
     */
    @Override
    public void Backward() {
        if(getFrequence().equals("AM")){
            if(AMStation >= 540 && AMStation <= 1610){
                setAMActualStation(AMStation - 10);
            }else{
                setAMActualStation(1610);
            }
        }else{
            if(FMStation >= 87.7 && FMStation <= 107.9){
                setFMActualStation(FMStation - 0.2);
            }else{
                setFMActualStation(107.9);
            }
        }
    }

    /**
     * Obtener la estacion en radio FM actual
     * @return Estacion actual
     */
    @Override
    public double getFMActualStation() {
        return FMStation;
    }

    /**
     * Obtener la estacion en radio AM actual
     * @return Estacion actual
     */
    @Override
    public int getAMActualStation() {
        return AMStation;
    }

    /**
     * Establecer una nueva estacion FM
     * @param actualStation Estacion actual
     */
    @Override
    public void setFMActualStation(double actualStation) {
        FMStation = actualStation;
    }

    /**
     * Establecer una nueva estacion AM
     * @param actualStation Estacion actual
     */
    @Override
    public void setAMActualStation(int actualStation) {
        this.AMStation= actualStation;
    }

    /**
     * Guardar la estacion de radio en uno de los slots para cada frecuencia
     * @param actualStation Estacion actual
     * @param slot Espacio a ocupar
     */
    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMSavedStation[(int) getFMSlot(slotF)]= actualStation;
        System.out.println("Se agrego la estacion con acceso directo");
    }

    /**
     * Guardar la estacion de radio en uno de los slots para cada frecuencia
     * @param actualStation Estacion actual
     * @param slot Espacio a ocupar
     */
    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMSavedStation[getAMSlot(slotF)]= actualStation;
        System.out.println("Se agrego la estacion con acceso directo");
    }

    /**
     *  Se utilizar oara obtener el slot desocupado de la lista de FM
     * @param slot Espacio
     * @return Slot disponible
     */
    @Override
    public double getFMSlot(int slot) {
        for (int i = 0; i < FMSavedStation.length; i++) {
            if (FMSavedStation[i] == 0.0) {
                slot=i;
                break;
            }
            if (i == 11 && FMSavedStation[11]!= 0.0) {
                System.out.println("Usted ya tiene lleno la capacidad de accesos directos de estaciones");
            }
        }
        return slot;
    }

    /**
     *  Se utilizar oara obtener el slot desocupado de la lista de AM
     * @param slot Espacio
     * @return Slot disponible
     */
    @Override
    public int getAMSlot(int slot) {
        for (int i = 0; i < AMSavedStation.length; i++) {
            if (AMSavedStation[i] == 0) {
                slot=i;
                break;
            }
            if (i == 11 && AMSavedStation[11]!= 0) {
                System.out.println("Usted ya tiene lleno la capacidad de accesos directos de estaciones");
            }
        }
        return slot;
    }

    /**
     * Obtener el slot de espacio
     * @return Variable de espacio
     */
    public int getSlotF() {
        return slotF;
    }

    /**
     * Obtener el Array de estaciones guardadas AM
     * @return ArrayAM
     */
    public int[] getAMSavedStation() {
        return AMSavedStation;
    }

    /**
     * Obtener el Array de estaciones guardadas FM
     * @return ArrayAM
     */
    public double[] getFMSavedStation() {
        return FMSavedStation;
    }
}
