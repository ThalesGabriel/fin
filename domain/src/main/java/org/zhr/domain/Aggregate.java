package org.zhr.domain;

import org.zhr.core.notification.INotification;

import java.io.Serializable;

public abstract class Aggregate<ID extends Identifier> extends Entity<ID> implements Serializable {

  private final INotification notification;
  protected Aggregate(ID id, INotification notification) {
    super(id);
    this.notification = notification;
  }

  public INotification getNotification() {
    return notification;
  }
  public abstract void validate();

  public ID getId() {
    return this.id;
  }

}
