package dao;

import entity.CountryInfo;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CountryDao {

    public List<CountryInfo> getCountriesList() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<CountryInfo> countries = session.createQuery("FROM CountryInfo", CountryInfo.class).list();
            return countries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
