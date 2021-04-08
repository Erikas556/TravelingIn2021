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

    private void create() {
        // code to save
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

    private void update() {
        // code to modify
    }

    private void delete() {
        // code to remove
    }

    public List<String> printCountryNames() {

        Session session = sessionFactory.openSession();

        return session.createQuery("SELECT countryName FROM CountryInfo").getResultList();
    }

    public Object readCountryInfo(String s) {

        Session session = sessionFactory.openSession();

        return session.createQuery("FROM CountryInfo WHERE countryName='" + s + "'").getSingleResult();
    }


    public static void main(String[] args) {
        // code to run the program
        CountryManager manager = new CountryManager();
        manager.setup();

        System.out.println(manager.readCountryInfo("Lithuania").toString());
        manager.exit();

    }
}

