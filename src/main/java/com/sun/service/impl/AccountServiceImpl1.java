package com.sun.service.impl;

import com.sun.dao.AccountDao;
import com.sun.pojo.Account;
import com.sun.service.AccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class AccountServiceImpl1 implements AccountService {
    private AccountDao accountDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @Transaction :  添加到需要控制事务的方法的上面
     *
     * transactionManager ="transactionManager" ,//配置事务管理器
     *             readOnly = false, //是否制度
     *             propagation = Propagation.REQUIRED,//是否需要处理事务，  必须处理事务
     *             isolation = Isolation.READ_COMMITTED// 事务的隔离级别    读已经提交
     * @param from
     * @param to
     * @param amount
     */

    @Transactional(transactionManager ="transactionManager",
            readOnly = false,
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED)
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
