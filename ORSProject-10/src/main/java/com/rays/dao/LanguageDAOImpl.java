package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.LanguageDTO;

@Repository
public class LanguageDAOImpl extends BaseDAOImpl<LanguageDTO> implements LanguageDAOInt {

	@Override
	protected List<Predicate> getWhereClause(LanguageDTO dto, CriteriaBuilder builder, Root<LanguageDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		
		if (!isEmptyString(dto.getSourceLanguage())) {

			whereCondition.add(builder.like(qRoot.get("sourceLanguage"), dto.getSourceLanguage()+ "%"));
		}

		if (!isEmptyString(dto.getTargetLanguage())) {

			whereCondition.add(builder.like(qRoot.get("targetLanguage"), dto.getTargetLanguage()+ "%"));
		}

	

	return whereCondition;
}
	@Override
	public Class<LanguageDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return LanguageDTO.class;
	}

}
