package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ATMSystemDTO;


@Repository
public class ATMSystemDAOImpl extends BaseDAOImpl<ATMSystemDTO> implements ATMSystemDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ATMSystemDTO dto, CriteriaBuilder builder, Root<ATMSystemDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBankName())) {

		whereCondition.add(builder.like(qRoot.get("bankName"), dto.getBankName()+ "%"));
	}
		if (!isEmptyString(dto.getLocation())) {

			whereCondition.add(builder.like(qRoot.get("location"), dto.getLocation()+ "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<ATMSystemDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return ATMSystemDTO.class;
	}

}
