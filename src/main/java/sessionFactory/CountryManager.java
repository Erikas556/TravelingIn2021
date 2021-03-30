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
        Countries country = new Countries();

        country.setCountryName(countryName);
        country.setVaccineRequirement(vaccineReq);
        country.setTestRequirement(testReq);
        country.setTestValidationTimeByHours(validiationTime);
        country.setForeigner(isForeigner);

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
        Countries countries = session.get(Countries.class, countryId);

        System.out.println("Name of Country : " + countries.getCountryName());
        System.out.println("Vaccine required to enter country : " + countries.getVaccineRequirement());
        System.out.println("COVID-19 Test required to enter country : " + countries.getTestRequirement());
        System.out.println("Oldest time(hours) of COVID-19 test : " + countries.getTestValidationTimeByHours());
        System.out.println("Allows foreigner : " + countries.getForeigner());

        session.close();
    }

    private void update(long id, String countryName, String vacReq, String testReq, int validationTime, String foreigner) {
        // method to modify a line from a table by id
        Countries countries = new Countries();

        countries.setId(id);
        countries.setCountryName(countryName);
        countries.setVaccineRequirement(vacReq);
        countries.setTestRequirement(testReq);
        countries.setTestValidationTimeByHours(validationTime);
        countries.setForeigner(foreigner);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(countries);

        session.getTransaction().commit();
        session.close();

    }

    private void delete(long id) {
        // method to delete a line form a table by id
        Countries countries = new Countries();

        countries.setId(id);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(countries);

        session.getTransaction().commit();
        session.close();

    }

    public static void main(String[] args) {
        // code to run the program
        CountryManager manager = new CountryManager();

        manager.setup();

        manager.exit();
    }
}

