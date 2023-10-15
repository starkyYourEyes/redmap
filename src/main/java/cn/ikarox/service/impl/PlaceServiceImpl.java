package cn.ikarox.service.impl;

import cn.ikarox.mapper.PlaceMapper;
import cn.ikarox.pojo.*;
import cn.ikarox.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public Place getTest(Integer id) {

        Place place = placeMapper.getTest(id);
        // 获取图片
        List<String> imgs = placeMapper.getImages(id);
//        System.out.println(imgs);
        place.setImg(imgs);
//        System.out.println(place.toString());
        return place;
    }

    @Override
    public List<Marker> getMarkers() {
        return placeMapper.getMarkers();
    }

    @Override
    public List<Mem> getBkgImg() {
        return placeMapper.getBkgImg();
    }

    @Override
    public Mem getMemInfo(Integer id) {
        id ++;
        Mem mem = new Mem();
        mem = placeMapper.getMemInfo(id);
        List<String> imgs = placeMapper.getMemImgs(id + 25);
        mem.setImgs(imgs);
        return mem;
    }

    @Override
    public List<Rout> getRout(String str) {
        return placeMapper.getRout(str);
    }
}
