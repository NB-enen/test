package com.whw.query;

import com.whw.entity.Level;
import com.whw.entity.Type;
import lombok.Data;

/**
 * @program: month5
 * @ClassName ScenicQuery
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:21
 * @Version 1.0
 **/
@Data
public class ScenicQuery extends PageQuery{
    //省
    private String province;
    //市
    private String city;
    //区/县
    private String county;

    private Level level;

    private Type type;
}
