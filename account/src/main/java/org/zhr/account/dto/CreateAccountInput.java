package org.zhr.account.dto;

import java.math.BigDecimal;

public record CreateAccountInput(String name, String subdomain, BigDecimal balance) {
}
