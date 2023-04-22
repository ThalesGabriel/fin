package org.zhr.account.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class Validator<T> extends AbstractValidator<T> {

    public void execute(T o) throws InvalidParameterException {
        ValidationResult result = this.validate(o);

        if (!result.isValid())
            buildMessageAndThrowInvalidParams(result.getErrors());
    }

    private void buildMessageAndThrowInvalidParams(Collection<Error> errors) throws InvalidParameterException {
        HashMap<String, Object> map = new HashMap<>();
        List<String> errorsMessage = new ArrayList<>();

        for (Error error : errors) {
            map.put("key", error.getField());
            map.put("value", error.getAttemptedValue());
            map.put("message", error.getMessage());
            errorsMessage.add(map.toString());
        }

        throw new InvalidParameterException(errorsMessage.toString());
    }

}
