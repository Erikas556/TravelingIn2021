package sessionFactory;

import entity.CountryInfo;
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

    private void create() {
        // code to save a country
        CountryInfo cInfo = new CountryInfo();
        cInfo.setCountryName("Lietuva");
        cInfo.setForeigner(false);
        cInfo.setVaccineRequirement(true);
        cInfo.setTestRequirement(true);
        cInfo.setTestValidationTimeByHours(72);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(cInfo);

        session.getTransaction().commit();
        session.close();
    }

    private void read() {
        // code to get a country
    }

    private void update() {
        // code to modify a country

    }

    private void delete() {
        // code to remove a country
    }

    public static void main(String[] args) {
        // code to run the program

        CountryManager cManager = new CountryManager();
        cManager.setup();

        cManager.create();

        cManager.exit();
    }
}

