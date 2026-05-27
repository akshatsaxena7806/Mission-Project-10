package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ElectricityBillDTO;


@Repository
public class ElectricityBillDAOImpl extends BaseDAOImpl<ElectricityBillDTO> implements ElectricityBillDAOInt{

	@Override
	protected List<Predicate> getWhereClause(ElectricityBillDTO dto, CriteriaBuilder builder,
			Root<ElectricityBillDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBillId())) {

		whereCondition.add(builder.like(qRoot.get("billId"), dto.getBillId()+ "%"));
	}
		if (!isEmptyString(dto.getCustomerName())) {

			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName()+ "%"));
		}

		if (!isZeroNumber(dto.getBillAmount())) {

			whereCondition.add(builder.like(qRoot.get("billAmount"), dto.getBillAmount()+ "%"));
		}
	

	return whereCondition;
}
	@Override
	public Class<ElectricityBillDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return ElectricityBillDTO.class;
	}

}
