package com.sun.dao.impl;

import com.sun.dao.AccountDao;
import com.sun.pojo.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //更新数据
    public void update(Account account) {
        String sql = "update account set balance = ? where name = ?";
        jdbcTemplate.update(sql,account.getBalance(),account.getName());

    }

    //通过姓名查找账户
    public Account findByName(String name) {
        String sql = "SELECT * FROM account WHERE NAME=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int i) throws SQLException {
                Account account=new Account();
                account.setId(rs.getInt("id"));
                account.setBalance(rs.getDouble("balance"));
                account.setName(rs.getString("name"));
                return account;
            }
        }, name);

    }

}
