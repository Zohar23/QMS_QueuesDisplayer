package Models;

import Services.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToDisplayerModelTest {

    ToDisplayerModel toDisplayerModel;
    private ArrayList<TreatmentModel> pharmList;
    private ArrayList<TreatmentModel> nurseList;
    TreatmentModel treatmentModel;

    @Before
    public void init() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(1);
        treatmentModel.setNumberServiceProvider(3);
        toDisplayerModel = new ToDisplayerModel();
        pharmList = new ArrayList<>();
        nurseList = new ArrayList<>();
        pharmList.add(treatmentModel);
        nurseList.add(treatmentModel);
        toDisplayerModel.setPharmList(pharmList);
    }

    @Test
    public void getPharmList() {
        assertEquals("",toDisplayerModel.getPharmList(),pharmList);
        assertNotEquals("",toDisplayerModel.getPharmList(),new ArrayList<>());
    }

    @Test
    public void setPharmList() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(2);
        treatmentModel.setNumberServiceProvider(4);
        toDisplayerModel = new ToDisplayerModel();
        toDisplayerModel.setPharmList(pharmList);
        assertNotEquals("",toDisplayerModel.getPharmList(),new ArrayList<>());
        assertEquals("",toDisplayerModel.getPharmList(),pharmList);
    }

    @Test
    public void getNurseList() {
        assertEquals("",toDisplayerModel.getPharmList(),nurseList);
        assertNotEquals("",toDisplayerModel.getPharmList(),new ArrayList<>());
    }

    @Test
    public void setNurseList() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(2);
        treatmentModel.setNumberServiceProvider(4);
        toDisplayerModel = new ToDisplayerModel();
        toDisplayerModel.setNurseList(nurseList);
        assertNotEquals("",toDisplayerModel.getNurseList(),new ArrayList<>());
        assertEquals("",toDisplayerModel.getNurseList(),nurseList);
    }

    @Test
    public void getNextTreatment() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(5);
        treatmentModel.setNumberServiceProvider(7);
        toDisplayerModel.setNextTreatment(treatmentModel);
        assertNotEquals("",toDisplayerModel.getNextTreatment(),new TreatmentModel());
        assertEquals("",toDisplayerModel.getNextTreatment(),treatmentModel);
    }

    @Test
    public void setNextTreatment() {
        treatmentModel = new TreatmentModel();
        treatmentModel.setNumberPatient(9);
        treatmentModel.setNumberServiceProvider(10);
        toDisplayerModel.setNextTreatment(treatmentModel);
        assertNotEquals("",toDisplayerModel.getNextTreatment(),new TreatmentModel());
        assertEquals("",toDisplayerModel.getNextTreatment(),treatmentModel);
    }

    @Test
    public void getPharmOrNurse() {
        toDisplayerModel.setPharmOrNurse(Constants.ADMINROLE);
        assertEquals("", toDisplayerModel.getPharmOrNurse(), Constants.ADMINROLE);
        assertNotEquals("", toDisplayerModel.getPharmOrNurse(), Constants.NURSEROLE);
    }

    @Test
    public void setPharmOrNurse() {
        toDisplayerModel.setPharmOrNurse(Constants.NURSEROLE);
        assertEquals("", toDisplayerModel.getPharmOrNurse(), Constants.NURSEROLE);
        assertNotEquals("", toDisplayerModel.getPharmOrNurse(), Constants.ADMINROLE);
    }
}