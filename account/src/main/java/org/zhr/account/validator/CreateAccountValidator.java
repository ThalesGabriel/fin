package org.zhr.account.validator;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.zhr.account.dto.CreateAccountInput;

@Component
@NoArgsConstructor
public class CreateAccountValidator extends Validator<CreateAccountInput> {

    @Override
    public void rules() {
    }

}
