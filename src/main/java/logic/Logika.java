package logic;

import dao.CountryInfoDao;
import entity.CountryInfo;
import org.hibernate.SessionFactory;
import sessionFactory.CountryManager;
import util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class Logika {

    private SessionFactory sessionFactory1;
    Scanner scan = new Scanner(System.in);
    CountryManager manager = new CountryManager();

    public void printMenu() {

        System.out.println();
        System.out.println("MENU");
        System.out.println("Select action with Letter :");

        System.out.println("A - a list of european countries .");
        System.out.println("B - Input a country which you would like to visit.");
        System.out.println("C - Exit.");

        String answer = scan.nextLine();

        switch (answer.toUpperCase()) {
            case "A": {
                HibernateUtil.setup();
                CountryInfoDao countryInfoDao = new CountryInfoDao();
                List<CountryInfo> countries = CountryInfoDao.getCountriesList();
                for (CountryInfo p : countries) {
                    System.out.println(p.toString());
                }
                HibernateUtil.exit();
                printMenu();
            }
            break;

            case "B": {
                System.out.println("Enter a country name : ");
                String input = scan.nextLine();
                HibernateUtil.setup();
                //   manager.read(1);
                HibernateUtil.exit();
                printSecondMenu();
            }
            break;

            case "C": {
                System.exit(0);
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
