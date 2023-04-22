package org.zhr.domain.account;

import org.springframework.http.HttpStatus;
import org.zhr.core.entity.IAccount;
import org.zhr.core.utils.Constants;
import org.zhr.core.utils.ErrorConstants;
import org.zhr.core.utils.StringUtils;

import java.math.BigDecimal;

public class AccountValidator {

    public void validate(IAccount account) {
        isNameNullOrBlank(account);
        isSubdomainNullOrBlank(account);
        isValidNameLength(account);
        isBalanceNullOrNegative(account);
    }

    private void isBalanceNullOrNegative(IAccount account) {
        if(account.getBalance() == null || account.getBalance().compareTo(BigDecimal.ZERO) < 0)
            account.getNotification().append(ErrorConstants.SHOULD_NOT_BE_NULL_OR_NEGATIVE.replace("{}", Constants.AMOUNT), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
    }

    private static void isValidNameLength(IAccount account) {
        final String name = account.getName().trim();
        if ((name.length() < Constants.MIN_NAME_LEN) || (name.length() > Constants.MAX_NAME_LEN)) {
            account.getNotification().append(ErrorConstants.STRING_LENGTH_INVALID.replace("{}", Constants.NAME), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
        }
    }

    private static void isNameNullOrBlank(IAccount account) {
        if(StringUtils.isNullOrBlank(account.getName()))
            account.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.NAME), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
    }

    private static void isSubdomainNullOrBlank(IAccount account) {
        if(StringUtils.isNullOrBlank(account.getSubdomain()))
            account.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.SUBDOMAIN), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
    }

}
