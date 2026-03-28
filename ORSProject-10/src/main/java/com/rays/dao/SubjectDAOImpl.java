package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.service.CourseServiceInt;

@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	@Autowired
	private CourseServiceInt course;
	
	@Override
	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		return whereCondition;
	}
	@Override
	public Class<SubjectDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return SubjectDTO.class;
	}
	
	@Override
	public void populate(SubjectDTO dto, UserContext userContext) {

		CourseDTO courseDto = course.findById(dto.getCourseId(), userContext);
	
				if (courseDto!=null) {
					dto.setCourseName(courseDto.getName());
					
				}
	}

	
	
}
