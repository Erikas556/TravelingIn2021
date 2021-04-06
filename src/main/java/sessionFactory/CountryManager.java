package sessionFactory;

import entity.CountryInfo;
import org.hibernate.Session;

import util.HibernateUtil;

import java.util.List;

public class CountryManager {

    private void create() {
        // code to save
    }

    public void read(int id) {
        // code to get a specific row from table
        Session session = HibernateUtil.setup().openSession();
        try {
            CountryInfo countryInfo = session.get(CountryInfo.class, id);

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


    private void update() {
        // code to modify
    }

    private void delete() {
        // code to remove
    }

    public List<String> printCountryNames() {

        CountryManager manager = new CountryManager();
        Session session = HibernateUtil.setup().openSession();

        return session.createQuery("SELECT countryName FROM CountryInfo").getResultList();
    }

    public static void main(String[] args) {
        // code to run the program
        HibernateUtil.setup();
        CountryManager manager = new CountryManager();
        manager.read(15);
        HibernateUtil.exit();

    }
}
