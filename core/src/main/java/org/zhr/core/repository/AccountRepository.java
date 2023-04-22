package org.zhr.core.repository;


import org.zhr.core.entity.IAccount;

public interface AccountRepository {

    public IAccount create(IAccount account) throws Exception;
    public IAccount findByName(String name) throws Exception;

}
