package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl<EmployeeDTO> implements EmployeeDAOInt {

	@Override
	protected List<Predicate> getWhereClause(EmployeeDTO dto, CriteriaBuilder builder, Root<EmployeeDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getEmployeeCode())) {

		whereCondition.add(builder.like(qRoot.get("employeeCode"), dto.getEmployeeCode()+ "%"));
	}
		if (!isEmptyString(dto.getEmployeeName())) {

			whereCondition.add(builder.like(qRoot.get("employeeName"), dto.getEmployeeName()+"%"));
		}
		if (!isEmptyString(dto.getState())) {

			whereCondition.add(builder.like(qRoot.get("state"), dto.getState()+"%"));
		}
		if (!isEmptyString(dto.getCity())) {

			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity()+"%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<EmployeeDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return EmployeeDTO.class;
	}

}
