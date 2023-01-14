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
        if(getFrequence().equals("AM")){
            if(AMStation >= 530 && AMStation <= 1600){
                setAMActualStation(AMStation + 10);
            }else{
                setAMActualStation(530);
            }
        }else{
            if(FMStation >= 87.9 && FMStation <= 107.7){
                setFMActualStation(FMStation + 0.2);
            }else{
                setFMActualStation(87.9);
            }
        }
    }

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

    @Override
    public double getFMActualStation() {
        return FMStation;
    }

    @Override
    public int getAMActualStation() {
        return AMStation;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        FMStation = actualStation;
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
