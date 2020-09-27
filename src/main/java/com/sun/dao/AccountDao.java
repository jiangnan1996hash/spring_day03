package com.sun.dao;

import com.sun.pojo.Account;

/**
 * 持久层
 */
public interface AccountDao {
    //根据账户的name更新账户的余额
    public void update(Account account);


    //根据账户的name查询账户
    public Account findByName(String name);




}
