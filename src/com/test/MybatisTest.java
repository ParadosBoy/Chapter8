package com.test;

import com.po.Customer;
import com.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 10574
 */
public class MybatisTest {
    @Test
    public void findCustomerByNameAndJobsTest() {
        SqlSession session = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = session.selectList("com.mapper" + ".CustomerMapper.findCustomerByNameAndJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        session.close();
    }

    @Test
    public void findCustomerByNameOrJobsTest() {
        SqlSession session = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = session.selectList("com.mapper" + ".CustomerMapper.findCustomerByNameOrJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        session.close();
    }

    @Test
    public void updateCustomerTest() {
        SqlSession session = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("12344578901");
        int rows = session.update("com.mapper" + ".CustomerMapper.updateCustomer", customer);
        if (rows > 0) {
            System.out.println("成功修改了" + rows + "条数据!");
        } else {
            System.out.println("修改失败!");
        }
        session.commit();
        session.close();
    }

    @Test
    public void findCustomerByIdsTest() {
        SqlSession session = MybatisUtils.getSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<Customer> customers = session.selectList("com.mapper" + ".CustomerMapper.findCustomerByIds", ids);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        session.close();
    }

    @Test
    public void findCustomerByNameTest() {
        SqlSession session = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("j");
        List<Customer> customers = session.selectList("com.mapper" + ".CustomerMapper.findCustomerByName", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        session.close();
    }
}


