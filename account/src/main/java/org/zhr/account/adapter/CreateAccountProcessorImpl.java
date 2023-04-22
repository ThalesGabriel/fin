package org.zhr.account.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zhr.core.command.CommandContext;
import org.zhr.core.entity.IAccount;
import org.zhr.core.processor.CreateAccountProcessor;
import org.zhr.core.repository.AccountRepository;
import org.zhr.domain.account.Account;

@Component
@RequiredArgsConstructor
public class CreateAccountProcessorImpl implements CreateAccountProcessor {

//    private final AccountRepository repository;

    @Override
    public IAccount process(CommandContext context) throws Exception {

        Account account = context.getData(Account.class);

        if(hasAccount(account.getName()))
            throw new IllegalArgumentException("Name already exists on database.");

//        return repository.create(account);
        return null;
    }

    private boolean hasAccount(String name) throws Exception {
//        return !(repository.findByName(name) == null);
        return true;
    }

}
