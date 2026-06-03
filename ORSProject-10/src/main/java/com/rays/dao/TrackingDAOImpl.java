package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.TrackingDTO;

@Repository
public class TrackingDAOImpl extends BaseDAOImpl<TrackingDTO> implements TrackingDAOInt {

	@Override
	protected List<Predicate> getWhereClause(TrackingDTO dto, CriteriaBuilder builder, Root<TrackingDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getTrackingNumber())) {

		whereCondition.add(builder.like(qRoot.get("trackingNumber"), dto.getTrackingNumber()+ "%"));
	}
		if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus()+ "%"));
		}

		if (!isEmptyString(dto.getTrackintId())) {

			whereCondition.add(builder.like(qRoot.get("trackingId"), dto.getTrackintId()+ "%"));
		}
		if (!isEmptyString(dto.getCurrentLocation())) {

			whereCondition.add(builder.like(qRoot.get("currentLocation"), dto.getCurrentLocation()+ "%"));
		}
	

	return whereCondition;
}

	@Override
	public Class<TrackingDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return TrackingDTO.class;
	}

}
