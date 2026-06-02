package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BrokerDTO;


@Repository
public class BrokerDAOImpl extends BaseDAOImpl<BrokerDTO> implements BrokerDAOInt {

	@Override
	protected List<Predicate> getWhereClause(BrokerDTO dto, CriteriaBuilder builder, Root<BrokerDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBrokerName())) {

		whereCondition.add(builder.like(qRoot.get("brokerName"), dto.getBrokerName()+ "%"));
	}
		if (!isEmptyString(dto.getContactNumber())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getContactNumber()+ "%"));
		}
		
		if (!isEmptyString(dto.getBrokerId())) {

			whereCondition.add(builder.like(qRoot.get("brokerId"), dto.getBrokerId()+ "%"));
		}

		if (!isEmptyString(dto.getCompany())) {

			whereCondition.add(builder.like(qRoot.get("company"), dto.getCompany()+ "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<BrokerDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return BrokerDTO.class;
	}

}
