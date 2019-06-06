package com.hfmodel.service.Impl;

import com.hfmodel.bean.Account;
import com.hfmodel.dao.AccountDao;
import com.hfmodel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public boolean deleteAccount(Integer id) {
        return accountDao.deleteAccount(id);
    }

    @Override
    public Integer updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }
}
