package Models;

import java.io.Serializable;

public class TreatmentModel implements Serializable {

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

    public String toString()
    {
        return NumberPatient+" "+ NumberServiceProvider;

    }
}
