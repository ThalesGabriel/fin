package org.zhr.domain.account;

import org.zhr.core.entity.IAccount;
import org.zhr.core.notification.Notification;
import org.zhr.domain.Aggregate;

import java.math.BigDecimal;
import java.time.Instant;

public class Account extends Aggregate<AccountId> implements IAccount {

    protected Account(AccountId accountId, String name, BigDecimal balance, String subdomain, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        super(accountId, new Notification());
        this.name = name;
        this.balance = balance;
        this.subdomain = subdomain;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Account with(String name, String subdomain) {
        AccountId accountId = AccountId.unique();
        Instant now = Instant.now();
        return new Account(accountId, name, BigDecimal.ZERO, subdomain, now, now, null);
    }

    private final String name;
    private final BigDecimal balance;
    private final String subdomain;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    @Override
    public void validate() {
        new AccountValidator().validate(this);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

}
