package logic;

import dao.CountryInfoDao;
import entity.CountryInfo;
import org.hibernate.SessionFactory;
import sessionFactory.UserManager;
import util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class Logika {

    Scanner scan = new Scanner(System.in);
    UserManager userManager = new UserManager();


    public void printMenu() {

        System.out.println();
        System.out.println("MENU");
        System.out.println("Select action with Letter :");

        System.out.println("A - List EU countries");
        System.out.println("B - Register Username if not registered");
        System.out.println("C - Type Username if it is registered");
        System.out.println("X - Exit.");

        String answer = scan.nextLine();

        switch (answer.toUpperCase()) {
            case "A": {
                HibernateUtil.setup();
                CountryInfoDao countryInfoDao = new CountryInfoDao();
                List<CountryInfo> countries = countryInfoDao.getCountriesList();
                for (CountryInfo p : countries) {
                    System.out.println(p.toString());
                }
                HibernateUtil.exit();
                printMenu();
            }
            break;

            case "B": {

                System.out.println("Please enter new Username");
                String userName = scan.nextLine();

                System.out.println("Please enter email address");
                String email = scan.nextLine();

                System.out.println("Please enter the number of the country you are citizen");
                Integer nationality = scan.nextInt();

                HibernateUtil.setup();
                userManager.createUser(userName, email, nationality);
                HibernateUtil.exit();

                System.out.println("User successfully created !");

                printMenu();
            }
            break;

            case "C": {
                System.out.println("Please type username");
                String sc = scan.nextLine();
                HibernateUtil.setup();
                if (!userManager.printUsernames().contains(sc)) {
                    System.out.println("User Does not exist");
                    System.out.println("Check your spelling and try again");
                    printMenu();
                }
                HibernateUtil.setup();
                System.out.println(userManager.readUsername(sc));
                HibernateUtil.exit();

            }
            default: {
                System.out.println("No such command !");
                System.out.println("Check your text for possible mistakes !");
                printMenu();
            }
        }
    }

    public void printSecondMenu() {

        System.out.println();
        System.out.println();
        System.out.println("MENU");
        System.out.println("Select action with Letter :");

        System.out.println("A - Try another country ?");
        System.out.println("B - Receive live information about the country via Email");
        System.out.println("C - Back to main menu.");
        System.out.println("D - exit program.");

        String input = scan.nextLine();

        switch (input.toUpperCase()) {

            case "A": {
                System.out.println("Enter a country name : ");
                String input2 = scan.nextLine();
                HibernateUtil.setup();
                //  manager.read(2);
                HibernateUtil.exit();
                printSecondMenu();
            }
            break;
            case "B": {
                System.out.println("Later to be added...");
            }
            break;
            case "C": {
                printMenu();
            }
            break;
            case "D": {
                System.exit(0);
            }
        }
    }
}
