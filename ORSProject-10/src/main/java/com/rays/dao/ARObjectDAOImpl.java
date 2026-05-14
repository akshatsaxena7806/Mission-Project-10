package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ARObjectDTO;

@Repository
public class ARObjectDAOImpl extends BaseDAOImpl<ARObjectDTO> implements ARObjectDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ARObjectDTO dto, CriteriaBuilder builder, Root<ARObjectDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getUserId())) {

		whereCondition.add(builder.like(qRoot.get("userId"), dto.getUserId()+ "%"));
	}
		if (!isEmptyString(dto.getSubscriptionType())) {

			whereCondition.add(builder.like(qRoot.get("subscriptionType"), dto.getSubscriptionType()+ "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<ARObjectDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return ARObjectDTO.class;
	}

}
