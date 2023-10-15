package cn.ikarox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marker {
    Integer id;
    Double latitude;
    Double longitude;
    String content;
}
