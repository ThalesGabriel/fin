package org.zhr.core.notification;

import java.util.ArrayList;

public interface INotification {
  void append(NotificationErrorProps error);
  void append(String message, String context, Integer code);
  boolean hasErrors();
  ArrayList<NotificationErrorProps> getErrors();
  String messages(String context);
}