package sessionFactory;

import entity.CountryInfo;
import entity.Users;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class UserManager {

    public void createUser(String userName, String email, int nationality) {

        Users user = new Users();

        user.setUserName(userName);
        user.setEmail(email);
        user.setNationality(nationality);

        Session session = HibernateUtil.setup().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void readUser(String userName) {
        Session session = HibernateUtil.setup().openSession();
        try {
            Users user = session.get(Users.class, userName);

            System.out.println("Username : " + user.getUserName());
            System.out.println("Email Address: " + user.getEmail());
            System.out.println("Nationality : " + user.getNationality());

            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public List<String> printUsernames() {
        Session session = HibernateUtil.setup().openSession();
        return session.createQuery("SELECT userName from Users ").getResultList();
    }

    public Object readUsername(String sc){
        Session session = HibernateUtil.setup().openSession();
        return session.createQuery("FROM Users WHERE userName ='" + sc + "'").getSingleResult();
    }

    public static void main(String[] args) {
        // code to run the program
        HibernateUtil.setup();
        UserManager userManager = new UserManager();
        userManager.createUser("vardas", "email adresas", 0);
        HibernateUtil.exit();
    }

}
