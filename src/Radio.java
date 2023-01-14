public class Radio implements IRadio{


    private boolean carStatus;
    private String FMequence;
    private double FMStation;
    private int AMStation;
    private int slot = 0;
    private int[] AMSavedStation = new int[12];
    private double[] FMSavedStation = new double[12];


    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    /***
     * Este metodo nos indica si la radio esta encendida o apagada
     * @return true si la radio esta encendida y false cuando la radio este apagada
     */
    @Override
    public boolean isOn() {


        return false;
    }

    /***
     * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
     * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
     */
    @Override
    public void setFrequence(String freq) throws Exception {

    }

    @Override
    public String getFrequence() {
        return null;
    }

    @Override
    public void Forward() {

    }

    @Override
    public void Backward() {

    }

    @Override
    public double getFMActualStation() {
        return 0;
    }

    @Override
    public int getAMActualStation() {
        return 0;
    }

    @Override
    public void setFMActualStation(double actualStation) {

    }

    @Override
    public void setAMActualStation(int actualStation) {
        this.AMStation= actualStation;
    }
//cambiar a slotF
    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMSavedStation[(int) getFMSlot(slot)]= actualStation;
        System.out.println("Se agrego la estacion con acceso directo");
    }
    //cambiar a slotF
    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMSavedStation[getAMSlot(slot)]= actualStation;
        System.out.println("Se agrego la estacion con acceso directo");
    }

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
}
