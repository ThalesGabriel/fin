package org.zhr.domain.transaction;

import org.zhr.core.entity.ITransaction;
import org.zhr.domain.Aggregate;
import org.zhr.core.entity.IAccount;
import org.zhr.core.enumerator.TransactionCategory;
import org.zhr.core.enumerator.TransactionType;
import org.zhr.core.notification.INotification;
import org.zhr.core.notification.Notification;

import java.time.Instant;

public class Transaction extends Aggregate<TransactionId> implements ITransaction {

    protected Transaction(TransactionId transactionId, Instant paymentDate, String name, String description, TransactionCategory category, Integer amount, TransactionType type, Instant createdAt, Instant updatedAt, Instant deletedAt, IAccount account) {
        super(transactionId, new Notification());
        this.paymentDate = paymentDate;
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.account = account;
    }

    public static Transaction with(Instant paymentDate, String name, String description, TransactionCategory category, Integer amount, TransactionType type, IAccount account) {
        TransactionId transactionId = TransactionId.unique();
        Instant now = Instant.now();
        return new Transaction(transactionId, paymentDate, name, description, category, amount, type, now, now, null, account);
    }

    private final Instant paymentDate;
    private final String name;
    private final String description;
    private final TransactionCategory category;
    private final TransactionType type;
    private final Integer amount;
    private final IAccount account;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    @Override
    public void validate() {
        new TransactionValidator().validate(this);
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category.name();
    }

    public Integer getAmount() {
        return amount;
    }

    public String getType() {
        return type.name();
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

    public IAccount getAccount() {
        return account;
    }

    @Override
    public INotification getNotification() {
        return null;
    }
}
