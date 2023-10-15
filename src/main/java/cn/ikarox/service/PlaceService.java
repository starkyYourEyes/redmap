package cn.ikarox.service;

import cn.ikarox.pojo.Marker;
import cn.ikarox.pojo.Mem;
import cn.ikarox.pojo.Place;
import cn.ikarox.pojo.Rout;

import java.util.List;

public interface PlaceService {
    // 红色地图界面的信息
    Place getTest(Integer id);

    List<Marker> getMarkers();

    List<Mem> getBkgImg();

    Mem getMemInfo(Integer id);

    List<Rout> getRout(String str);
}
