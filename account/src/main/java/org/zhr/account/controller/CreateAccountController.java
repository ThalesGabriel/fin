package org.zhr.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zhr.account.api.CreateAccountApi;
import org.zhr.account.dto.CreateAccountInput;
import org.zhr.account.validator.CreateAccountValidator;
import org.zhr.core.command.CommandContext;
import org.zhr.core.entity.IAccount;
import org.zhr.core.processor.CreateAccountProcessor;
import org.zhr.domain.account.Account;

import java.net.URI;
import java.security.InvalidParameterException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreateAccountController implements CreateAccountApi {

    CreateAccountValidator validator;
    CreateAccountProcessor processor;

    @Override
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountInput input) {
        log.debug("Iniciando o cadastro da conta.");

        try {

            validator.execute(input);

            IAccount account = Account.with(input.name(), input.subdomain());

            CommandContext commandContext = new CommandContext(account);

            account = processor.process(commandContext);

            log.info("Conta cadastrada com sucesso");

            return ResponseEntity.created(URI.create("/api/v1/accounts/"+account.getId())).build();
        } catch (InvalidParameterException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
