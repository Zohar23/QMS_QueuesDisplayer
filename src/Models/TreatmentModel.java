package Models;

import java.io.Serializable;

public class TreatmentModel implements Serializable {

    private int NumberPatient = 0;
    private int NumberServiceProvider = 0;

    public int getNumberPatient() {

        return NumberPatient;
    }

    public int setNumberPatient(int numberPatient) {
        NumberPatient = numberPatient;
        return numberPatient;
    }

    public int getNumberServiceProvider() {
        return NumberServiceProvider;
    }

    public int setNumberServiceProvider(int numberPharmacist) {
        NumberServiceProvider = numberPharmacist;
        return numberPharmacist;
    }

    public String toString()
    {
        return NumberPatient+" "+ NumberServiceProvider;

    }
}
