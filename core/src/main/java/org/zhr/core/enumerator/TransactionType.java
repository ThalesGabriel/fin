package org.zhr.core.enumerator;

public enum TransactionType {

    DEBIT("DEBIT"), CREDIT("CREDIT");

    private final String name;

    TransactionType(String name) {
        this.name = name;
    }

}
