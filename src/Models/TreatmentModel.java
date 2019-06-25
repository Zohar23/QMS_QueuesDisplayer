package Models;
public class TreatmentModel {

    private int NumberPatient = 0;
    private int NumberServiceProvider = 0;

    public int getNumberPatient() {

        return NumberPatient;
    }

    public void setNumberPatient(int numberPatient) {

        NumberPatient = numberPatient;
    }

    public int getNumberServiceProvider() {
        return NumberServiceProvider;
    }

    public void setNumberServiceProvider(int numberPharmacist) {

        NumberServiceProvider = numberPharmacist;
    }
}
