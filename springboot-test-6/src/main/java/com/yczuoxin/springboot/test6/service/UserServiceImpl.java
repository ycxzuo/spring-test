package com.yczuoxin.springboot.test6.service;

import com.yczuoxin.springboot.test6.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager manager;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public boolean save(User user) {
        return jdbcTemplate.execute("INSERT INTO user (name, age) value (?,?)",
                new PreparedStatementCallback<Boolean>() {
                    @Override
                    public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                        ps.setString(1, user.getName());
                        ps.setInt(2, user.getAge());
                        return ps.executeUpdate() > 0;
                    }
                });
    }

    public boolean save2(User user) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus transaction = manager.getTransaction(definition);
        boolean result = false;
        try {
            result = save(user);
            manager.commit(transaction);
        } catch (Exception e) {
            manager.rollback(transaction);
        }
        return result;

    }
}
