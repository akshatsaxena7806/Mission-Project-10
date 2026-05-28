package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GymManagementDTO;

@Repository
public class GymManagementDAOImpl extends BaseDAOImpl<GymManagementDTO>  implements GymManagementDAOInt{

	@Override
	protected List<Predicate> getWhereClause(GymManagementDTO dto, CriteriaBuilder builder,
			Root<GymManagementDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getMemberId())) {

		whereCondition.add(builder.like(qRoot.get("memberId"), dto.getMemberId()+ "%"));
	}
		if (!isEmptyString(dto.getTrainerName())) {

			whereCondition.add(builder.like(qRoot.get("trainerName"), dto.getTrainerName()+ "%"));
		}

		if (!isZeroNumber(dto.getMembershipFee())) {

			whereCondition.add(builder.like(qRoot.get("membershipFee"), dto.getMembershipFee()+ "%"));
		}
		if (!isEmptyString(dto.getMemberName())) {

			whereCondition.add(builder.like(qRoot.get("memberName"), dto.getMemberName()+ "%"));
		}
		
		
	

	return whereCondition;
}

	@Override
	public Class<GymManagementDTO> getDtoClass() {
		// TODO Auto-generated method stub
		return GymManagementDTO.class;
	}

}
