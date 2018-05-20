package shaomai.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shaomai.Application;
import shaomai.dao.ArtDao;
import shaomai.model.p.ArtBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ArtDaoTest {
    @Autowired
    ArtDao artDao;

    @Test
    @Rollback
    public void insertTest() {
        int result = artDao.insert(
                "Android原理解析",
                "cheng",
                System.currentTimeMillis(),
                "Android原理解析",
                "http://localhost:8080/arts/test.md"
        );
        assertEquals(result, 1);
    }

    @Test
    @Rollback
    public void selectAllArtTest() {
        List<ArtBean> arts = artDao.selectAll(1,2);
        for (ArtBean art: arts) {
            System.out.println(art.toString());
        }
        assertEquals(2, arts.size());
    }

    @Test
    @Rollback
    public void artTotalTest() {
        int total = artDao.artTotal();
        assertEquals(total, 8);
    }

    @Test
    @Rollback
    public void selectArtByIdTest() {
        ArtBean artBean = artDao.selectArtById(1);
        System.out.println(artBean);
    }
}
