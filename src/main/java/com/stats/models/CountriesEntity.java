package com.stats.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "stats", catalog = "")
public class CountriesEntity {
    private int id;
    private String code;
    private String name;
    private String currency;
    private String currencyName;
    private String iso2Code;
    private String continent;
    private String oldCountryCode;
    private int countryPartnerId;
    private String dialingCode;
    private Integer utcOffset;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 3)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "currency", nullable = false, length = 3)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "currency_name", nullable = false, length = 255)
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Basic
    @Column(name = "iso_2_code", nullable = true, length = 2)
    public String getIso2Code() {
        return iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }

    @Basic
    @Column(name = "continent", nullable = false, length = 15)
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Basic
    @Column(name = "old_country_code", nullable = true, length = 3)
    public String getOldCountryCode() {
        return oldCountryCode;
    }

    public void setOldCountryCode(String oldCountryCode) {
        this.oldCountryCode = oldCountryCode;
    }

    @Basic
    @Column(name = "country_partner_id", nullable = false)
    public int getCountryPartnerId() {
        return countryPartnerId;
    }

    public void setCountryPartnerId(int countryPartnerId) {
        this.countryPartnerId = countryPartnerId;
    }

    @Basic
    @Column(name = "dialing_code", nullable = true, length = 45)
    public String getDialingCode() {
        return dialingCode;
    }

    public void setDialingCode(String dialingCode) {
        this.dialingCode = dialingCode;
    }

    @Basic
    @Column(name = "utc_offset", nullable = true)
    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return id == that.id &&
                countryPartnerId == that.countryPartnerId &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(currencyName, that.currencyName) &&
                Objects.equals(iso2Code, that.iso2Code) &&
                Objects.equals(continent, that.continent) &&
                Objects.equals(oldCountryCode, that.oldCountryCode) &&
                Objects.equals(dialingCode, that.dialingCode) &&
                Objects.equals(utcOffset, that.utcOffset);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code, name, currency, currencyName, iso2Code, continent, oldCountryCode, countryPartnerId, dialingCode, utcOffset);
    }
}
