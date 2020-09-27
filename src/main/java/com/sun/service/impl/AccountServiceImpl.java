package com.sun.service.impl;

import com.sun.dao.AccountDao;
import com.sun.dao.impl.AccountDaoImpl;
import com.sun.pojo.Account;
import com.sun.service.AccountService;


public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账
     * @param from  转出方
     * @param to    转入当
     * @param amount 现金金额
     */
    public void transfer(String from, String to, Double amount) {

        //获取转账人的信息
        Account afrom = accountDao.findByName(from);
        Account ato = accountDao.findByName(to);
        //核对转账金额
        afrom.setBalance(afrom.getBalance() - amount);//转出方减少金额
        ato.setBalance(ato.getBalance() + amount);//转入增加金额
        //开始转账
        accountDao.update(afrom);
        accountDao.update(ato);



    }


}
