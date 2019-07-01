package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDisplayerModel implements Serializable {

   private ArrayList<TreatmentModel> pharmList;
   private ArrayList<TreatmentModel> nurseList;
   private TreatmentModel nextTreatment;
    private String pharmOrNurseOrNew;

    public ArrayList<TreatmentModel> getPharmList() {
        return pharmList;
    }

    public void setPharmList(ArrayList<TreatmentModel> pharmList) {
        this.pharmList = pharmList;
    }

    public ArrayList<TreatmentModel> getNurseList() {
        return nurseList;
    }

    public void setNurseList(ArrayList<TreatmentModel> nurseList) {
        this.nurseList = nurseList;
    }

    public TreatmentModel getNextTreatment() {
        return nextTreatment;
    }

    public void setNextTreatment(TreatmentModel nextTreatment) {
        this.nextTreatment = nextTreatment;
    }

    public String getPharmOrNurse() {
        return pharmOrNurseOrNew;
    }

    public void setPharmOrNurse(String pharmOrNurse) {
        this.pharmOrNurseOrNew = pharmOrNurse;
    }
}
