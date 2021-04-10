package sessionFactory;

import entity.CountryInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CountryManager {
    private SessionFactory sessionFactory;
    private CountryInfo countries = new CountryInfo();


    public void setup() {
        // code to load Hibernate Session factory

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void exit() {
        sessionFactory.close();
        // code to close Hibernate Session factory
    }

    public void create(String countryName, boolean vaccineReq, boolean testReq, int validiationTime, boolean isForeigner) {
        // method to add countries to database

        countries.setCountryName(countryName);
        countries.setVaccineRequirement(vaccineReq);
        countries.setTestRequirement(testReq);
        countries.setTestValidationTimeByHours(validiationTime);
        countries.setForeignerAllowedToEnter(isForeigner);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(countries);

        session.getTransaction().commit();
        session.close();

    }

    public void read(int id) {
        // code to get a specific row from table
        Session session = sessionFactory.openSession();
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

    public void update(int id, String countryName, boolean vacReq, boolean testReq, int validationTime, boolean foreigner) {
        // method to modify a line from a table by id

        countries.getId();
        countries.setCountryName(countryName);
        countries.setVaccineRequirement(vacReq);
        countries.setTestRequirement(testReq);
        countries.setTestValidationTimeByHours(validationTime);
        countries.setForeignerAllowedToEnter(foreigner);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(countries);

        session.getTransaction().commit();
        session.close();

    }

    public void delete(int id) {
        // method to delete a line form a table by id

        countries.setId(id);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(countries);

        session.getTransaction().commit();
        session.close();

    }

    public List<String> printCountryNames() {

        Session session = sessionFactory.openSession();

        return session.createQuery("SELECT countryName FROM CountryInfo").getResultList();
    }

    public Object readCountryInfo(String s) {

        Session session = sessionFactory.openSession();

        return session.createQuery("FROM CountryInfo WHERE countryName='" + s + "'").getSingleResult();
    }
}

