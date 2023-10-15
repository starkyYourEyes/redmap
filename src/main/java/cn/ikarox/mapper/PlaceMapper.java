package cn.ikarox.mapper;

import cn.ikarox.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlaceMapper {

    @Select("select title, address, ontime, ticket, intro, video from addinfo where id = #{xid}")
    Place getTest(Integer xid);

    @Select("select url from redmap.img where pid = #{id}")
    List<String> getImages(Integer id);

    @Select("select * from marker")
    List<Marker> getMarkers();

    @Select("select name, img from mem order by id")
    List<Mem> getBkgImg();

    @Select("select id, name, address, tel, ticket, ontime, intro, video from mem where id = #{id}")
    Mem getMemInfo(Integer id);

    @Select("select url from redmap.img where pid = #{id}")
    List<String> getMemImgs(int i);

    List<Rout> getRout(String str);
}
