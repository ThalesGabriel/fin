package org.zhr.core.entity;

import org.zhr.core.notification.INotification;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public interface IAccount extends Serializable {

    public Object getId();
    public String getName();
    public BigDecimal getBalance();
    public String getSubdomain();
    public Instant getCreatedAt();
    public Instant getUpdatedAt();
    public Instant getDeletedAt();
    public INotification getNotification();

}
