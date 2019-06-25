package Models;

import java.util.List;

public class ToDisplayerModel {

   private List<TreatmentModel> pharmList;
   private List<TreatmentModel> nurseList;
   private TreatmentModel nextTreatment;
   private String pharmOrNurse;

    public List<TreatmentModel> getPharmList() {
        return pharmList;
    }

    public void setPharmList(List<TreatmentModel> pharmList) {
        this.pharmList = pharmList;
    }

    public List<TreatmentModel> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<TreatmentModel> nurseList) {
        this.nurseList = nurseList;
    }

    public TreatmentModel getNextTreatment() {
        return nextTreatment;
    }

    public void setNextTreatment(TreatmentModel nextTreatment) {
        this.nextTreatment = nextTreatment;
    }

    public String getPharmOrNurse() {
        return pharmOrNurse;
    }

    public void setPharmOrNurse(String pharmOrNurse) {
        this.pharmOrNurse = pharmOrNurse;
    }
}
