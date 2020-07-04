package com.whw.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: month5
 * @ClassName District
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:00
 * @Version 1.0
 **/
@Getter
@Setter
@Entity
@Table(name = "t_district")
public class District {

            // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;
            //name
            private String name;
            // parent
            private Integer parent;
}
