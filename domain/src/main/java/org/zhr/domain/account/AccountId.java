package org.zhr.domain.account;

import org.zhr.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class AccountId extends Identifier {

    private final String value;

    public AccountId(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static AccountId unique() {
        return AccountId.from(UUID.randomUUID());
    }

    public static AccountId from(String id) {
        return new AccountId(id);
    }

    public static AccountId from(UUID id) {
        return new AccountId(id.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId that = (AccountId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
