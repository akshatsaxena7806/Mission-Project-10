package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.WeatherSystemDTO;


@Repository
public class WeatherSystemDAOImpl extends BaseDAOImpl<WeatherSystemDTO> implements WeatherSystemDAOInt {

	@Override
	protected List<Predicate> getWhereClause(WeatherSystemDTO dto, CriteriaBuilder builder,
			Root<WeatherSystemDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getCityName())) {

		whereCondition.add(builder.like(qRoot.get("cityName"), dto.getCityName()+ "%"));
	}
		if (!isZeroNumber(dto.getTemperature())) {

			whereCondition.add(builder.like(qRoot.get("temperature"), dto.getTemperature() + "%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<WeatherSystemDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return WeatherSystemDTO.class;
	}

}
