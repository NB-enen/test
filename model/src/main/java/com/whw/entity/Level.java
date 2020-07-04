package com.whw.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @program: month5
 * @ClassName Level
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:09
 * @Version 1.0
 **/
@Getter
@Setter
@Entity
@Table(name = "t_level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "level")
    private Set<Scenic> scenics;

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
