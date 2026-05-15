package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.LiveStreamingDTO;

@Repository
public class LiveStreamingDAOImpl extends BaseDAOImpl<LiveStreamingDTO> implements LiveStreamingDAOInt{

	@Override
	protected List<Predicate> getWhereClause(LiveStreamingDTO dto, CriteriaBuilder builder,
			Root<LiveStreamingDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getStatus())) {

		whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus()+ "%"));
	    }
		if (!isEmptyString(dto.getStreamCode())){

			whereCondition.add(builder.like(qRoot.get("streamCode"), dto.getStreamCode()+ "%"));
		}
		if (!isEmptyString(dto.getStreamerName())){

			whereCondition.add(builder.like(qRoot.get("streamerName"), dto.getStreamerName() +"%"));
		}

	

	return whereCondition;
}

	@Override
	public Class<LiveStreamingDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return LiveStreamingDTO.class;
	}

}
