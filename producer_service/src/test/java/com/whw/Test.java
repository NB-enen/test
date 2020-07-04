package com.whw;

import com.whw.dao.LevelDao;
import com.whw.dao.TypeDao;
import com.whw.entity.Level;
import com.whw.entity.Scenic;
import com.whw.entity.Type;
import com.whw.query.ScenicQuery;
import com.whw.response.Page;
import com.whw.service.ScenicService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: month5
 * @ClassName Test
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:27
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
@Transactional
public class Test {
    @Autowired
    private TypeDao typeDao;
    @Autowired
    ScenicService scenicService;

    @Autowired
    LevelDao level;

    @org.junit.Test
    public void savetype(){
        Type type = new Type();
        type.setName("A");
        type.setSorted(1);
        typeDao.save(type);
    }

    @org.junit.Test
    public void page(){
        public static void main（String [] args）{
            System.out.println("1");
        }
        public static void main（）{
            System.out.println("2");
        }
    }

}
