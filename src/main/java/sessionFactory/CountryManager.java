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
        sessionFactory.close();
        // code to close Hibernate Session factory
    }

    private void create() {
        // code to save
    }

    private void read() {
        // code to get
        Session session = sessionFactory.openSession();
        try {
            int ID = 20;
            CountryInfo countryInfo = session.get(CountryInfo.class, ID);

            System.out.println("Country Name: " + countryInfo.getCountryName());
            System.out.println("Vaccine Requirement: " + countryInfo.isVaccineRequirement());
            System.out.println("Test Requirement: " + countryInfo.isTestRequirement());
            System.out.println("Test Validation Time By hours: " + countryInfo.getTestValidationTimeByHours());
            System.out.println("Is Foreigner Allowed To Enter The Country?: " + countryInfo.isForeignerAllowedToEnter());

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

    public static void main(String[] args) {
        // code to run the program
        CountryManager manager = new CountryManager();
        manager.setup();
//        manager.create();
        manager.read();
//        manager.update();
//        manager.delete();
//        manager.exit();
    }
}
