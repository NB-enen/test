package com.whw.dao;

import com.whw.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: month5
 * @Interface District
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:25
 * @Version 1.0
 **/
@Repository
public interface TypeDao extends JpaRepository<Type,Integer> {
}
