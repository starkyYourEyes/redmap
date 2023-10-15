package cn.ikarox.controller;

import cn.ikarox.pojo.Result;
import cn.ikarox.pojo.Rout;
import cn.ikarox.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/place")
    public Result getRedMap(Integer id){
        log.info("查询地址信息" + id);
        return Result.success(placeService.getTest(id));
    }

    @GetMapping("/marker")
    public Result getMarkers(){
        log.info("获取地图上的点标信息");
        return Result.success(placeService.getMarkers());
    }

    @GetMapping("/memBkgImg")
    public Result getBkgImg(){
        log.info("加载十大纪念碑的图片到界面");
        return Result.success(placeService.getBkgImg());
    }

    @GetMapping("/mems")
    public Result getMemInfo(Integer id){
        log.info("加载十大纪念碑信息");
        return Result.success(placeService.getMemInfo(id));
    }

    @GetMapping("/rout")
    public Result getRout(String str){
        log.info("查询景点旅游路线信息，" + str);
        List<Rout> stringList = placeService.getRout(str);
        return Result.success(stringList);
    }

    @GetMapping("/")
    public String tst2(){
        return "红色地图小程序--暑期社会实践";
    }
}
