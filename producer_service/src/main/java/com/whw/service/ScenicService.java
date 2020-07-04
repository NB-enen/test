package com.whw.service;

import com.whw.entity.Level;
import com.whw.entity.Scenic;
import com.whw.query.ScenicQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Service
@Transactional
public class ScenicService extends BaseService<Scenic, Integer, ScenicQuery> {

    protected void makeupWhereClause(ScenicQuery params, CriteriaBuilder builder, Root<Scenic> root, List<Predicate> predicates) {
        if (StringUtils.isNotEmpty(params.getProvince())) {
            predicates.add(builder.like(root.get("province"), "%" + params.getProvince() + "%")); // and name like concat('%',:name,'%')
        }
        if (StringUtils.isNotEmpty(params.getCity())) {
            predicates.add(builder.like(root.get("city"), "%" + params.getCity() + "%")); // and phone like concat('%',:phone,'%')
        }
        if (StringUtils.isNotEmpty(params.getCounty())) {
            predicates.add(builder.like(root.get("county"), "%" + params.getCounty() + "%")); // and phone like concat('%',:phone,'%')
        }
        if (params.getLevel() != null) {
            Join<Scenic, Level> joinlevel=root.join("level", JoinType.LEFT);
            predicates.add(builder.equal(joinlevel.get("name"),params.getLevel())); // and birthday>=:birthdayStart
        }
        if (params.getType() != null) {
            predicates.add(builder.equal(root.get("name"),params.getType().getName())); // and birthday>=:birthdayStart
        }

//        //省
//        private String province;
//        //市
//        private String city;
//        //区/县
//        private String county;
//
//        private Level level;
//
//        private Type type;
    }
}
