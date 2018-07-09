package com.stats.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "stats", catalog = "")
public class UserEntity {
    private int id;
    private String memberId;
    private String userName;
    private String password;
    private Integer usertType;
    private String emailAddress;
    private String mobileNumber;
    private int enabled;
    private Date dateEstablished;
    private String description;
    private String address;
    private Integer race;
    private String firstName;
    private String surname;
    private Integer maritalStatus;
    private Integer gender;
    private String identification;
    private Integer identificationType;

    @Basic
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "member_id", nullable = false, length = 45)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usert_type", nullable = true)
    public Integer getUsertType() {
        return usertType;
    }

    public void setUsertType(Integer usertType) {
        this.usertType = usertType;
    }

    @Basic
    @Column(name = "email_address", nullable = true, length = 45)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "mobile_number", nullable = false, length = 45)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "date_established", nullable = true)
    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "race", nullable = true)
    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "marital_status", nullable = true)
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "identification", nullable = true, length = 45)
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "identification_type", nullable = true)
    public Integer getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(Integer identificationType) {
        this.identificationType = identificationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                enabled == that.enabled &&
                Objects.equals(memberId, that.memberId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(usertType, that.usertType) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(mobileNumber, that.mobileNumber) &&
                Objects.equals(dateEstablished, that.dateEstablished) &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address) &&
                Objects.equals(race, that.race) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(maritalStatus, that.maritalStatus) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(identification, that.identification) &&
                Objects.equals(identificationType, that.identificationType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, memberId, userName, password, usertType, emailAddress, mobileNumber, enabled, dateEstablished, description, address, race, firstName, surname, maritalStatus, gender, identification, identificationType);
    }
}
