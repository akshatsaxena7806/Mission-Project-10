package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.catalina.Role;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;

@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt{

	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		if (dto!=null) {
			if (!isEmptyString(dto.getName())) {
				conditions.add(builder.like(qRoot.get("name"), dto.getName()+"%"));
			}
			if (!isEmptyString(dto.getDescription())) {
				conditions.add(builder.like(qRoot.get("description"), dto.getDescription()+"%"));
			}
		}
		
		
		return conditions;
	}

	@Override
	public Class<RoleDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return RoleDTO.class;
	}

	
	
	}

