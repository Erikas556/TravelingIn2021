package sessionFactory;

import entity.CountryInfo;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserManager {

    private SessionFactory sessionFactory;

    public void setup() {

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

    }

    public void read(int id) {

        Session session = sessionFactory.openSession();
        try {
            Users users = session.get(Users.class, id);

            System.out.println("User name : " + users.getUserName());
            System.out.println("Email : " + users.getEmail());

            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public void addUser(String userName, String email) {

        Users user = new Users();

        user.setUserName(userName);
        user.setEmail(email);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.setup();
        manager.addUser("Klaipeckas", "klaipeckiukas556@gmail.com");
        manager.exit();
    }
}
