package com.dnd.project.common.baseUtill;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CommonSpecification {

    public static Specification<?> searchWith(CommonVo vo) {
        return (Specification<?>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(vo, root, builder);
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

	private static List<Predicate> getPredicateWithKeyword(CommonVo vo, Root<?> root, CriteriaBuilder builder) {
        List<Predicate> predicate = new ArrayList<>();
        for (String key : vo.getLikeKeys().keySet()) {
        	if(!StringUtils.isEmpty(vo.getLikeKeys().get(key))) {
        		predicate.add(builder.like(root.get(key), "%"+vo.getLikeKeys().get(key)+"%"));
        	}
        }
        
        for (String key : vo.getEqualKeys().keySet()) {
        	if(!StringUtils.isEmpty(vo.getEqualKeys().get(key))) {
        		predicate.add(builder.equal(root.get(key), vo.getEqualKeys().get(key)));
        	}
        }
        
        for(String key : vo.getJoinKeys().keySet()) {
        	if(!StringUtils.isEmpty(vo.getJoinKeys().get(key))) {
        		String clazz = key.split("-")[0];
        		String type = key.split("-")[1];
        		predicate.add(builder.equal(((Path<Object>) root.fetch(clazz)).get(type), vo.getJoinKeys().get(key)));
        	}
        }
    
        return predicate;
    }
    
    
}
