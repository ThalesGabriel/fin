package org.zhr.repositoryjpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.zhr.core.entity.IAccount;
import org.zhr.repositoryjpa.entity.AccountEntity;

@Mapper
public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    public abstract AccountEntity mapFrom(IAccount source);
}
