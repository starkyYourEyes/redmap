package cn.ikarox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    private String title;
    private List<String> img;
    private String address;
    private String ontime;
    private String ticket;
    private String intro;
    private String video;
}
