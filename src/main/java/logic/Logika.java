package logic;

import dao.CountryInfoDao;
import entity.CountryInfo;
import sessionFactory.CountryManager;
import sessionFactory.UserManager;
import util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class Logika {

    Scanner scan = new Scanner(System.in);
    UserManager userManager = new UserManager();
    CountryManager countryManager = new CountryManager();


    public void printMenu() {

        System.out.println();
        System.out.println("MENU 1");
        System.out.println("Select action with Letter :");

        System.out.println("A - List EU countries");
        System.out.println("B - Register Username if not registered");
        System.out.println("C - Type Username if it is registered");
        System.out.println("\nX - Exit.");

        String answer = scan.nextLine();

        switch (answer.toUpperCase()) {
            case "A":
                HibernateUtil.setup();
                CountryInfoDao countryInfoDao = new CountryInfoDao();
                List<CountryInfo> countries = countryInfoDao.getCountriesList();
                for (CountryInfo p : countries) {
                    System.out.println(p.toString());
                }
                HibernateUtil.exit();
                printMenu();

                break;

            case "B":

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

                break;

            case "C":
                System.out.println("Please type username");
                String sc = scan.nextLine();
                HibernateUtil.setup();

                if (!userManager.printUsernames().contains(sc)) {
                    System.out.println("User Does not exist");
                    System.out.println("Check your spelling and try again");
                }
                HibernateUtil.setup();
                System.out.println(userManager.readUsername(sc));
                HibernateUtil.exit();
                printSecondMenu();
                break;

            default:
                System.out.println("No such command !");
                System.out.println("Check your text for possible mistakes !");
                printMenu();

        }
    }

    public void printSecondMenu() {

        System.out.println();
        System.out.println();
        System.out.println("MENU 2");
        System.out.println("Select action with Letter :");

        System.out.println("A - List EU Countries");
        System.out.println("B - Put the country name to receive information");
        System.out.println("C - Back to main menu.");
        System.out.println("\nX - exit program.");

        String input = scan.nextLine();

        switch (input.toUpperCase()) {

            case "A":
                HibernateUtil.setup();
                CountryInfoDao countryInfoDao = new CountryInfoDao();
                List<CountryInfo> countries = countryInfoDao.getCountriesList();
                for (CountryInfo p : countries) {
                    System.out.println(p.toString());
                }
                HibernateUtil.exit();
                printSecondMenu();
                break;

            case "B":
                System.out.println("Enter a country name number: ");
                Integer br = scan.nextInt();
                HibernateUtil.setup();
                if (countryManager.printCountriesName().contains(br)) {
                    HibernateUtil.setup();
                    countryManager.read(br);
                    HibernateUtil.exit();
                    printSecondMenu();
                }
                System.out.println("Country does not exist");
                System.out.println("Check your spelling and try again");
                printSecondMenu();
                break;

            case "C":
                printMenu();
                break;

            case "X":
                System.exit(0);

        }
    }
}
