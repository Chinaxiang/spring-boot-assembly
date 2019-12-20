package com.quanshi.springbootassembly.orm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanshi.springbootassembly.orm.entity.BaseDO;

/**
 * 
 * @author yanxiang.huang
 */
public interface BaseDAO extends JpaRepository<BaseDO, Long> {

}
