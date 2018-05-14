package io.shaomai.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shaomai.Application;
import shaomai.dao.ArtDao;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtDaoTest {
    @Autowired
    protected ArtDao artDao;

//    @Test
//    public void insertTest() {
//        int result = artDao.insert(
//                "Android原理解析",
//                "烧麦",
//                System.currentTimeMillis(),
//                "Android原理解析",
//                "http://localhost:8080/arts/test.md"
//        );
//        assertEquals(result, 1);
//    }

    @Test
    public void test(){}
}
