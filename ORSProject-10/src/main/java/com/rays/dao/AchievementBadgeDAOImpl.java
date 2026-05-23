package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AchievementBadgeDTO;

@Repository
public class AchievementBadgeDAOImpl extends BaseDAOImpl<AchievementBadgeDTO> implements AchievementBadgeDAOInt{

	@Override
	protected List<Predicate> getWhereClause(AchievementBadgeDTO dto, CriteriaBuilder builder,
			Root<AchievementBadgeDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBadgeName())) {

		whereCondition.add(builder.like(qRoot.get("badgeName"), dto.getBadgeName()+ "%"));
	}
		if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus()+ "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<AchievementBadgeDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return AchievementBadgeDTO.class;
	}

}
