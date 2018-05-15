package shaomai.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArtDao {
    @Insert("insert into tb_art(title,author,a_date,content,url) values(#{title},#{author},#{a_date},#{content},#{url})")
    int insert(
            @Param("title")String title,
            @Param("author") String author,
            @Param("a_date")long date,
            @Param("content")String content,
            @Param("url")String url
    );
}
