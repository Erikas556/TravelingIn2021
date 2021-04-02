package dao;

import entity.CountryInfo;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CountryDao {

    public List<CountryInfo> getCountriesInfo() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<CountryInfo> Countries = session.createQuery("FROM CountryInfo", CountryInfo.class).getResultList();
            return Countries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
