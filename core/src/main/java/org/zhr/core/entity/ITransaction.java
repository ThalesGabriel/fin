package org.zhr.core.entity;

import org.zhr.core.notification.INotification;

import java.time.Instant;

public interface ITransaction {

    public Instant getPaymentDate();
    public String getName();
    public String getDescription();
    public String getCategory();
    public Integer getAmount();
    public String getType();
    public Instant getCreatedAt();
    public Instant getUpdatedAt();
    public Instant getDeletedAt();
    public INotification getNotification();
    public IAccount getAccount();

}
