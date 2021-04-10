package sessionFactory;

import javax.persistence.*;

@Entity
@Table(name = "countryInfo")
public class CountryInfo {

    private long id;
    private String countryName;
    private String vaccineRequirement;
    private String testRequirement;
    private int testValidationTimeByHours;
    private String foreignerAllowedToEnter;

    public CountryInfo() {
    }

    @Id
    @Column(name = "ID")
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

    public String getForeignerAllowedToEnter() {
        return foreignerAllowedToEnter;
    }

    public void setForeignerAllowedToEnter(String foreigner) {
        this.foreignerAllowedToEnter = foreigner;
    }
}
