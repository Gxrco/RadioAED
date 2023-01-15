import static org.junit.Assert.*;


public class RadioTest extends Radio {

    IRadio radioTest = new Radio();

    /**
     * Test del cambio de frecuencia en la radio
     * @throws Exception Excepcion sobre frecuencia
     */
    @org.junit.Test
    public void testGetFrequence() throws Exception { //Test para getteo de frecuencia.
        radioTest.setFrequence("FM"); //Se settea la frecuencia a FM.
        String frequence = radioTest.getFrequence(); //Se hace un get para la frecuencia.
        assertSame(frequence, "FM"); //Se compara si es la misma.
    }

    /**
     * Test de encendido de la radio
     */
    @org.junit.Test
    public void on() { //Test para encendido de radio.
        radioTest.off(); //Se apaga el auto.
        radioTest.on(); //Se enciende.
        boolean carStatus = radioTest.isOn(); //Se confirma si el auto esta encendido.
        assertSame(carStatus, true); //Se compara el estado.
    }

    /**
     * Test de radio FM para verificar que la estacion se cambie de manera correcta
     */
    @org.junit.Test
    public void setFMActualStation() { //Test para setteo de estacion.
        radioTest.setFMActualStation(88.8); //Se settea la estacion FM a 88.8.
        double actualStation = radioTest.getFMActualStation(); //Se gettea el valor de la estacion FM.
        assertEquals(actualStation, 88.801, 0.01); //Se compara la estacion, con una diferencia de 0.01 (delta) por uso de punto flotante.
    }
}