package com.company.pocjoined.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JmixEntity
@Table(name = "LEGAL_CP")
@Entity
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class LegalCP extends Counterparty {

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Pattern(message = "{msg://com.company.pocapplication.entity/LegalCP.taxPayerNumber.validation.Pattern}", regexp = "^\\d{10}$")
    @NotNull
    @Column(name = "TAX_PAYER_NUMBER", nullable = false)
    private String taxPayerNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxPayerNumber() {
        return taxPayerNumber;
    }

    public void setTaxPayerNumber(String taxPayerNumber) {
        this.taxPayerNumber = taxPayerNumber;
    }
}