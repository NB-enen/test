package com.whw.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @program: month5
 * @ClassName Type
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:00
 * @Version 1.0
 **/
@Getter
@Setter
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;

    private String name;

    private Integer sorted;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private Set<Scenic> scenics;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sorted=" + sorted +
                '}';
    }
}
