package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GenderDTO;

@Repository
public class GenderDAOImpl extends BaseDAOImpl<GenderDTO> implements GenderDAOInt{

	@Override
	protected List<Predicate> getWhereClause(GenderDTO dto, CriteriaBuilder builder, Root<GenderDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getGenderCode())) {

		whereCondition.add(builder.like(qRoot.get("genderCode"), dto.getGenderCode()+ "%"));
	}
		if (!isEmptyString(dto.getGenderType())) {

			whereCondition.add(builder.like(qRoot.get("genderType"), dto.getGenderType()+ "%"));
		}
		
		

	

	return whereCondition;
}

	@Override
	public Class<GenderDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return GenderDTO.class;
	}

}
