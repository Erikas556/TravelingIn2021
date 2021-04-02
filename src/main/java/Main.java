import dao.CountryDao;
import entity.CountryInfo;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Hello Traveling In 2021 =====");

        CountryDao countryDao = new CountryDao();
        CountryInfo countryInfo = new CountryInfo();
        countryDao.getCountriesInfo();

    }
}
