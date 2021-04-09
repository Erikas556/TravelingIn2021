package sessionFactory;

import entity.CountryInfo;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;

public class CountryManager {

     public void read(Integer countryID) {
        // code to get a specific row from table
        Session session = HibernateUtil.setup().openSession();
        try {
            CountryInfo countryInfo = session.get(CountryInfo.class, countryID);

            System.out.println("Country Name : " + countryInfo.getCountryName());
            System.out.println("Vaccine Requirement: " + countryInfo.isVaccineRequirement());
            System.out.println("Test Requirement : " + countryInfo.isTestRequirement());
            System.out.println("Test Validation Time By hours : " + countryInfo.getTestValidationTimeByHours());
            System.out.println("Are foreigners allowed to the country : " + countryInfo.isForeignerAllowedToEnter());

            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public List<String> printCountriesName() {
        Session session = HibernateUtil.setup().openSession();
        return session.createQuery("SELECT countryID from CountryInfo ").getResultList();
    }


    private void update() {
        // code to modify
    }

    private void delete() {
        // code to remove
    }

    public static void main(String[] args) {
        // code to run the program
//        HibernateUtil.setup();
//        CountryManager manager = new CountryManager();
//
//        HibernateUtil.exit();

    }
}
