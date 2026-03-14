package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.UserDTO;
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt{

	@Override
	protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {
List<Predicate> conditions = new ArrayList<Predicate>();
		
		if (dto!=null) {
			if (!isEmptyString(dto.getFirstName())) {
				conditions.add(builder.like(qRoot.get("firstName"), dto.getFirstName()+"%"));
			}
			if (!isEmptyString(dto.getLastName())) {
				conditions.add(builder.like(qRoot.get("lastName"), dto.getLastName()+"%"));
			}
			if (!isEmptyString(dto.getRoleName())){
				conditions.add(builder.like(qRoot.get("roleName"), dto.getRoleName()+"%"));
			}
			if (!isEmptyString(dto.getLoginId())) {
				conditions.add(builder.like(qRoot.get("loginId"), dto.getLoginId()+"%"));
			}
			if (!isEmptyString(dto.getStatus())) {
				conditions.add(builder.like(qRoot.get("statusId"), dto.getStatus()+"%"));
			}
			
		}
		
		
		return conditions;
	}
	

	@Override
	public Class<UserDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return UserDTO.class;
	}

}
