package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CourseDTO;

@Repository
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt{

	@Override
	protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();

		if (dto != null) {
			if (!isEmptyString(dto.getName())){
				conditions.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}
			if (!isEmptyString(dto.getDescription())) {
				conditions.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
			}
			if (!isEmptyString(dto.getDuration())) {
				conditions.add(builder.like(qRoot.get("duration"), dto.getDuration()+ "%"));
			}
			
		}

		return conditions;
		
	}

	@Override
	public Class<CourseDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return CourseDTO.class;
	}

}
