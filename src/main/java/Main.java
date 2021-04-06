import dao.CountryDao;
import entity.CountryInfo;
import util.HibernateUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        CountryDao countryDao = new CountryDao();
        List<CountryInfo> countries = countryDao.getCountriesList();
        for (CountryInfo p : countries) {
            System.out.println(p.toString());
        }

        HibernateUtil.shutdown();

    }
}
