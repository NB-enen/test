package com.whw.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: month5
 * @ClassName Scenic
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:01
 * @Version 1.0
 **/
@Getter
@Setter
@Entity
@Table(name = "t_scenic")
public class Scenic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   //主键
    private Integer id;
    //名称
    private String name;

    @ManyToOne(cascade={CascadeType.MERGE} )
    @JoinColumn(name = "level_id")
    //景点等级
    private Level level;

    @ManyToOne(cascade={CascadeType.MERGE} )
    @JoinColumn(name = "type_id")
    //风格
    private Type type;
    //省
    private String province;
    //市
    private String city;
    //区/县
    private String county;
    //门票
    private String ticket;
    //图片
    private String pic;
    //介绍
    private String introduction;

    @Override
    public String toString() {
        return "Scenic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", ticket='" + ticket + '\'' +
                ", pic='" + pic + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
