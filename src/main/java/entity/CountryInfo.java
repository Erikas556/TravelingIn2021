package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countryInfo")
public class CountryInfo {
    private int id;
    private String countryName;
    private boolean vaccineRequirement;
    private boolean testRequirement;
    private int testValidationTimeByHours;
    private boolean foreignerAllowedToEnter;

//    public CountryInfo(int id, String countryName, boolean vaccineRequirement, boolean testRequirement, int testValidationTimeByHours, boolean foreignerAllowedToEnter) {
//        this.id = id;
//        this.countryName = countryName;
//        this.vaccineRequirement = vaccineRequirement;
//        this.testRequirement = testRequirement;
//        this.testValidationTimeByHours = testValidationTimeByHours;
//        this.foreignerAllowedToEnter = foreignerAllowedToEnter;
//    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isVaccineRequirement() {
        return vaccineRequirement;
    }

    public void setVaccineRequirement(boolean vaccineRequirement) {
        this.vaccineRequirement = vaccineRequirement;
    }

    public boolean isTestRequirement() {
        return testRequirement;
    }

    public void setTestRequirement(boolean testRequirement) {
        this.testRequirement = testRequirement;
    }

    public int getTestValidationTimeByHours() {
        return testValidationTimeByHours;
    }

    public void setTestValidationTimeByHours(int testValidationTimeByHours) {
        this.testValidationTimeByHours = testValidationTimeByHours;
    }

    public boolean isForeignerAllowedToEnter() {
        return foreignerAllowedToEnter;
    }

    public void setForeignerAllowedToEnter(boolean foreignerAllowedToEnter) {
        this.foreignerAllowedToEnter = foreignerAllowedToEnter;
    }
}