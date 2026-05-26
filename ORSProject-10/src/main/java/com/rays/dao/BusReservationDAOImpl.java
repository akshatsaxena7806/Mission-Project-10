package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BusReservationDTO;


@Repository
public class BusReservationDAOImpl extends BaseDAOImpl<BusReservationDTO> implements BusReservationDAOInt{

	@Override
	protected List<Predicate> getWhereClause(BusReservationDTO dto, CriteriaBuilder builder,
			Root<BusReservationDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBusNo())) {

		whereCondition.add(builder.like(qRoot.get("busNo"), dto.getBusNo()+ "%"));
	}
		if (!isEmptyString(dto.getPassengerName())) {

			whereCondition.add(builder.like(qRoot.get("passengerName"), dto.getPassengerName()+ "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<BusReservationDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return BusReservationDTO.class;
	}

}
