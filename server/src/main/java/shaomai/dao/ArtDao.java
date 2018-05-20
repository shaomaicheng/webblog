package shaomai.dao;

import org.apache.ibatis.annotations.*;
import shaomai.model.p.ArtBean;

import java.util.List;

@Mapper
public interface ArtDao {
    @Insert("insert into tb_art(title,author,a_date,content,url) values(#{title},#{author},#{a_date},#{content},#{url})")
    int insert(
            @Param("title") String title,
            @Param("author") String author,
            @Param("a_date") long date,
            @Param("content") String content,
            @Param("url") String url
    );

    @Select("select * from tb_art limit #{pageNo},#{pageSize}")
    @Results({
            @Result(property = "id", column = "a_id"),
            @Result(property = "date", column = "a_date")
    })
    List<ArtBean> selectAll(
            @Param("pageNo") int pageNo,
            @Param("pageSize") int pageSize
    );

    @Select("select count(*) from tb_art")
    int artTotal();

    @Select("select * from tb_art where a_id = #{id}")
    @Results({
            @Result(property = "id", column = "a_id"),
            @Result(property = "date", column = "a_date")
    })
    ArtBean selectArtById(int id);
}
