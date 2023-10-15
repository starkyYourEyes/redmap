package cn.ikarox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mem {
    Integer id;
    String name;
    String address;
    List<String> imgs;
    String tel;
    String ticket;
    String ontime;
    String intro;
    String video;
    String img;
}
