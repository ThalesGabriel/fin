package org.zhr.repositoryjpa.adapter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.zhr.core.entity.IAccount;
import org.zhr.core.repository.AccountRepository;
import org.zhr.repositoryjpa.entity.AccountEntity;
import org.zhr.repositoryjpa.mapper.AccountMapper;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final AccountMapper mapper = AccountMapper.INSTANCE;

    @Override
    @Transactional
    public IAccount create(IAccount account) throws Exception {
        final AccountEntity savedObject = entityManager.merge(mapper.mapFrom(account));
        return mapper.mapFrom(savedObject);
    }

    @Override
    public IAccount findByName(String name) {
        return (IAccount) entityManager.createQuery("SELECT u FROM AccountEntity a where a.name = :name").setParameter("name", name).getResultList().get(0);
    }

}
