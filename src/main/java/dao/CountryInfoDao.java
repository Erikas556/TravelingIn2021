package dao;

import entity.CountryInfo;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CountryInfoDao {

    public List<CountryInfo> getCountriesList() {
        try {
            Session session = HibernateUtil.setup().openSession();
            List<CountryInfo> countries = session.createQuery("FROM CountryInfo", CountryInfo.class).getResultList();
            return countries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
