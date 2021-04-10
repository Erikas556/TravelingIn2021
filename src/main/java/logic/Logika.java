package logic;

import org.hibernate.SessionFactory;
import sessionFactory.CountryManager;
import sessionFactory.UserManager;

import java.util.Scanner;

public class Logika {

    public Logika() {
        printMenu();
    }

    private Scanner scan = new Scanner(System.in);
    private CountryManager manager = new CountryManager();

    public void printMenu() {

        System.out.println("\nMENU");
        System.out.println("Select action with Letter :");
        System.out.println("\nA - a list of european countries .");
        System.out.println("B - Input a country which you would like to visit.");
        System.out.println("C - Register user to DataBase.");
        System.out.println("D - List of existing users.");
        System.out.println("E - Enter Developer Menu.");
        System.out.println("F - Exit program.");

        String answer = scan.nextLine();

        switch (answer.toUpperCase()) {
            case "A": {
                manager.setup();
                for (String country : manager.printCountryNames()) {
                    System.out.println(country);
                }
                manager.exit();
                printMenu();
            }
            break;

            case "B": {
                System.out.println("Enter a country name : ");
                String input = scan.nextLine();
                manager.setup();
                if (!manager.printCountryNames().contains(input)) {
                    System.out.println("No such Country !");
                    System.out.println("Check your spelling and try again !");
                    printMenu();
                }
                manager.setup();
                System.out.println(manager.readCountryInfo(input));
                manager.exit();
                printSecondMenu();
            }
            break;

            case "C": {
                UserManager user = new UserManager();
                System.out.println("Enter your nickname/user name below :");
                String nick = scan.nextLine();
                System.out.println("Enter your email below :");
                String email = scan.nextLine();

                user.setup();
                user.addUser(nick, email);
                user.exit();

                System.out.println("Registration successfully completed !");
                printMenu();

            }
            case "D": {
                System.out.println("List all registered users.");
                UserManager user = new UserManager();
                user.setup();
                System.out.println("   USERS   ");
                System.out.println("\n" + user.listUsers());
                user.exit();
                printMenu();
            }
            break;
            case "E": {
                printDeveloperMenu();
            }
            break;
            case "F": {
                System.exit(0);
            }
            break;

            default: {
                System.out.println("No such command !");
                System.out.println("Check your text for possible mistakes !");
                printMenu();
            }
        }
    }

    public void printSecondMenu() {

        System.out.println("\nMENU");
        System.out.println("Select action with Letter :");
        System.out.println("\nA - Try another country ?");
        System.out.println("B - Receive advice and tips on how to better defend your self during the pandemic via Email letter.");
        System.out.println("C - Back to main menu.");

        String input = scan.nextLine();

        switch (input.toUpperCase()) {

            case "A": {
                System.out.println("Enter a country name : ");
                String input2 = scan.nextLine();
                manager.setup();
                if (!manager.printCountryNames().contains(input2)) {
                    System.out.println("No such Country !");
                    System.out.println("Check your spelling and try again !");
                    printSecondMenu();
                }
                manager.setup();
                System.out.println(manager.readCountryInfo(input2));
                manager.exit();
                printSecondMenu();
            }
            break;
            case "B": {
                System.out.println("Enter your email address below : ");
                SendEmail.sendEmail(scan.nextLine());
                printSecondMenu();
            }
            break;
            case "C": {
                printMenu();
            }
            break;
            default: {
                System.out.println("No such command !");
                System.out.println("Check your text for possible mistakes !");
                printSecondMenu();
            }
            break;
        }
    }

    public void printDeveloperMenu() {

        System.out.println("\n DEVELOPER MENU");
        System.out.println("Select action with Letter :");
        System.out.println("\nA - Read a row from table.");
        System.out.println("\nB - Create row in table.");
        System.out.println("C - Modify a row from table.");
        System.out.println("D - Delete a row from table.");

    }
}
