package sessionFactory;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    private long id;
    private String countryName;
    private String vaccineRequirement;
    private String testRequirement;
    private int testValidationTimeByHours;
    private String isForeigner;

    public Countries() {
    }

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getVaccineRequirement() {
        return vaccineRequirement;
    }

    public void setVaccineRequirement(String vaccineRequirement) {
        this.vaccineRequirement = vaccineRequirement;
    }

    public String getTestRequirement() {
        return testRequirement;
    }

    public void setTestRequirement(String testRequirement) {
        this.testRequirement = testRequirement;
    }

    public int getTestValidationTimeByHours() {
        return testValidationTimeByHours;
    }

    public void setTestValidationTimeByHours(int testValidationTimeByHours) {
        this.testValidationTimeByHours = testValidationTimeByHours;
    }

    public String getForeigner() {
        return isForeigner;
    }

    public void setForeigner(String foreigner) {
        isForeigner = foreigner;
    }
}
