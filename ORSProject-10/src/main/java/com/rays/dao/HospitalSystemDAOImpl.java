package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.HospitalSystemDTO;


@Repository
public class HospitalSystemDAOImpl extends BaseDAOImpl<HospitalSystemDTO> implements HospitalSystemDAOInt{

	@Override
	protected List<Predicate> getWhereClause(HospitalSystemDTO dto, CriteriaBuilder builder,
			Root<HospitalSystemDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getDoctorName())) {

		whereCondition.add(builder.like(qRoot.get("doctorName"), dto.getDoctorName()+ "%"));
	}
		if (!isEmptyString(dto.getPatientName())) {

			whereCondition.add(builder.like(qRoot.get("patientName"), dto.getPatientName()+ "%"));
		}
		
		if (!isZeroNumber(dto.getRoomNumber())) {

			whereCondition.add(builder.like(qRoot.get("roomNumber"), dto.getRoomNumber()+ "%"));
		}
		

	

	return whereCondition;
}

	@Override
	public Class<HospitalSystemDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return HospitalSystemDTO.class;
	}

}
