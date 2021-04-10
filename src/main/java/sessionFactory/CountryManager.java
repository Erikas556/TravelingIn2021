package sessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CountryManager {

    private SessionFactory sessionFactory;


    private void setup() {
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

    private void exit() {
        // code to close Hibernate Session factory
        sessionFactory.close();
    }

    private void create(String countryName, String vaccineReq, String testReq, int validiationTime, String isForeigner) {
        // method to add countries to database
        CountryInfo country = new CountryInfo();

        country.setCountryName(countryName);
        country.setVaccineRequirement(vaccineReq);
        country.setTestRequirement(testReq);
        country.setTestValidationTimeByHours(validiationTime);
        country.setForeignerAllowedToEnter(isForeigner);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(country);

        session.getTransaction().commit();
        session.close();

    }

    private void read(long id) {
        // method to read a specific table line by id
        Session session = sessionFactory.openSession();

        long countryId = id;
        CountryInfo countryInfo = session.get(CountryInfo.class, countryId);

        System.out.println("Name of Country : " + countryInfo.getCountryName());
        System.out.println("Vaccine required to enter country : " + countryInfo.getVaccineRequirement());
        System.out.println("COVID-19 Test required to enter country : " + countryInfo.getTestRequirement());
        System.out.println("Oldest time(hours) of COVID-19 test : " + countryInfo.getTestValidationTimeByHours());
        System.out.println("Allows foreigner : " + countryInfo.getForeignerAllowedToEnter());

        session.close();
    }

    private void update(long id, String countryName, String vacReq, String testReq, int validationTime, String foreigner) {
        // method to modify a line from a table by id
        CountryInfo countryInfo = new CountryInfo();

        countryInfo.setId(id);
        countryInfo.setCountryName(countryName);
        countryInfo.setVaccineRequirement(vacReq);
        countryInfo.setTestRequirement(testReq);
        countryInfo.setTestValidationTimeByHours(validationTime);
        countryInfo.setForeignerAllowedToEnter(foreigner);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(countryInfo);

        session.getTransaction().commit();
        session.close();

    }

    private void delete(long id) {
        // method to delete a line form a table by id
        CountryInfo countryInfo = new CountryInfo();

        countryInfo.setId(id);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(countryInfo);

        session.getTransaction().commit();
        session.close();

    }

    public static void main(String[] args) {
        // code to run the program
        CountryManager manager = new CountryManager();

        manager.setup();
        manager.delete(61);
        manager.exit();
    }
}

