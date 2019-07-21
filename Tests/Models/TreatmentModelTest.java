package Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreatmentModelTest {

    TreatmentModel treatmentModel;

    @Before
    public void init() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(1);
        treatmentModel.setNumberServiceProvider(1);
    }

    @Test
    public void getNumberPatient() {
        assertEquals("", treatmentModel.getNumberPatient(), 1);
    }

    @Test
    public void setNumberPatient() {
        assertEquals("", treatmentModel.setNumberPatient(2), 2);
    }

    @Test
    public void getNumberServiceProvider() {
        assertEquals("", treatmentModel.getNumberServiceProvider(), 1);
    }

    @Test
    public void setNumberServiceProvider() {
        assertEquals("", treatmentModel.setNumberServiceProvider(2), 2);
    }

    @Test
    public void ToString(){
        assertEquals("", treatmentModel.toString(), "1 1");
    }
}