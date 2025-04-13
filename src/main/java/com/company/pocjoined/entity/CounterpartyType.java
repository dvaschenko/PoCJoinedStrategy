package com.company.pocjoined.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum CounterpartyType implements EnumClass<String> {

    LEGAL_CP("legal"),
    PHYSICAL_CP("physical");

    private final String id;

    CounterpartyType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CounterpartyType fromId(String id) {
        for (CounterpartyType at : CounterpartyType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}