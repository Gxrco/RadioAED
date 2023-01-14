public class Radio implements IRadio{


    private boolean carStatus;
    private String frequence;
    private double FMStation = 87.9;
    private int AMStation = 530;
    private int slotF = 0;
    private int[] AMSavedStation = new int[12];
    private double[] FMSavedStation = new double[12];


    @Override
    public void on() {
        carStatus = true;
    }

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

    @Override
    public String getFrequence() {
        if(!frequence.equalsIgnoreCase("")){
            return frequence;
        }else{
            return null;
        }
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

    }

    @Override
    public void saveFMStation(double actualStation, int slot) {

    }

    @Override
    public void saveAMStation(int actualStation, int slot) {

    }

    @Override
    public double getFMSlot(int slot) {
        return 0;
    }

    @Override
    public int getAMSlot(int slot) {
        return 0;
    }
}
