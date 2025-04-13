package com.company.pocjoined.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTRACT")
@Entity
public class Contract {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private String number;

    @Column(name = "DATE_OF_CONCLUSION", nullable = false)
    @NotNull
    private LocalDate dateOfConclusion;

    @JoinColumn(name = "COUNTERPARTY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Counterparty counterparty;

    @Column(name = "COUNTERPARTY_TYPE", nullable = false)
    @NotNull
    private String counterpartyType;

    public CounterpartyType getCounterpartyType() {
        return counterpartyType == null ? null : CounterpartyType.fromId(counterpartyType);
    }

    public void setCounterpartyType(CounterpartyType counterpartyType) {
        this.counterpartyType = counterpartyType == null ? null : counterpartyType.getId();
    }

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"counterparty", "number"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s %s",
                metadataTools.format(counterparty),
                metadataTools.format(number));
    }
}