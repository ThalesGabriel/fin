package org.zhr.domain.transaction;

import org.springframework.http.HttpStatus;
import org.zhr.core.entity.ITransaction;
import org.zhr.core.utils.Constants;
import org.zhr.core.utils.ErrorConstants;
import org.zhr.core.utils.StringUtils;

public class TransactionValidator {

    public void validate(ITransaction transaction) {
        isNameNullOrBlank(transaction);
        isDescriptionNullOrBlank(transaction);
        isCategoryNullOrBlank(transaction);
        isTypeNullOrBlank(transaction);
        isPaymentDateNull(transaction);
        isAmountNullOrNegative(transaction);
        isAccountNull(transaction);
        isValidNameLength(transaction);
        isValidDescriptionLength(transaction);
    }

    private static void isValidNameLength(ITransaction transaction) {
        final String name = transaction.getName().trim();
        if ((name.length() < Constants.MIN_NAME_LEN) || (name.length() > Constants.MAX_NAME_LEN)) {
            transaction.getNotification().append(ErrorConstants.STRING_LENGTH_INVALID.replace("{}", Constants.NAME), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
        }
    }

    private static void isValidDescriptionLength(ITransaction transaction) {
        final String description = transaction.getDescription().trim();
        if ((description.length() < Constants.MIN_NAME_LEN) || (description.length() > Constants.MAX_NAME_LEN)) {
            transaction.getNotification().append(ErrorConstants.STRING_LENGTH_INVALID.replace("{}", Constants.DESCRIPTION), Constants.ACCOUNT, HttpStatus.BAD_REQUEST.value());
        }
    }

    private static void isNameNullOrBlank(ITransaction transaction) {
        if(StringUtils.isNullOrBlank(transaction.getName()))
            transaction.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.NAME), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isDescriptionNullOrBlank(ITransaction transaction) {
        if(StringUtils.isNullOrBlank(transaction.getName()))
            transaction.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.DESCRIPTION), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isCategoryNullOrBlank(ITransaction transaction) {
        if(StringUtils.isNullOrBlank(transaction.getCategory()))
            transaction.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.CATEGORY), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isTypeNullOrBlank(ITransaction transaction) {
        if(StringUtils.isNullOrBlank(transaction.getType()))
            transaction.getNotification().append(ErrorConstants.STRING_SHOULD_NOT_BE_NULL_OR_BLANK.replace("{}", Constants.TYPE), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isPaymentDateNull(ITransaction transaction) {
        if(transaction.getPaymentDate() == null)
            transaction.getNotification().append(ErrorConstants.SHOULD_NOT_BE_NULL.replace("{}", Constants.PAYMENT_DATE), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isAmountNullOrNegative(ITransaction transaction) {
        if(transaction.getAmount() == null || transaction.getAmount() < 0)
            transaction.getNotification().append(ErrorConstants.SHOULD_NOT_BE_NULL_OR_NEGATIVE.replace("{}", Constants.AMOUNT), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

    private static void isAccountNull(ITransaction transaction) {
        if(transaction.getAccount() == null)
            transaction.getNotification().append(ErrorConstants.SHOULD_NOT_BE_NULL.replace("{}", Constants.ACCOUNT), Constants.TRANSACTION, HttpStatus.BAD_REQUEST.value());
    }

}
