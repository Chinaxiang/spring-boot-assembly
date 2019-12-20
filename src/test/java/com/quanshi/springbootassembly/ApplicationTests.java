package com.quanshi.springbootassembly;

import com.alibaba.fastjson.JSON;
import com.quanshi.springbootassembly.orm.dao.BaseDAO;
import com.quanshi.springbootassembly.orm.entity.BaseDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Resource
    private BaseDAO baseDao;

    @Test
    public void contextLoads() {
        log.info("test.");
        List<BaseDO> datas = baseDao.findAll();
        log.info(JSON.toJSONString(datas, true));
    }

}
