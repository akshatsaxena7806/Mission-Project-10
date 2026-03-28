package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.dto.UserDTO;

public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot) ;

	

	public abstract  Class<T> getDtoClass() ;

	public void populate(T dto, UserContext userContext) {

	}

	@Override
	public long add(T dto, UserContext userContext) {

		System.out.println(userContext.getLoginId());
		dto.setCreatedBy(userContext.getLoginId());
		dto.setModifiedBy(userContext.getLoginId());
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}
	
	public List marksheetMeritList(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List l = q.getResultList();
		return l;
	}

	@Override
	public void update(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setModifiedBy(userContext.getLoginId());
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);

	}

	@Override
	public void delete(T dto, UserContext userContext) {

		entityManager.remove(dto);

	}

	@Override
	public T findByPk(long id, UserContext userContext) {
		T dto = entityManager.find(getDtoClass(), id);
		return dto;
	}

	@Override
	public T findByUniqueKey(String attribute, Object value, UserContext userContext) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDtoClass());

		Root<T> qRoot = criteriaQuery.from(getDtoClass());

		Predicate condition = criteriaBuilder.equal(qRoot.get(attribute), value);

		criteriaQuery.where(condition);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		List<T> list = typedQuery.getResultList();

		T dto = null;

		if (list.size() > 0) {

			dto = list.get(0);

		}

		return dto;
	}

	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDtoClass());

		Root<T> qRoot = criteriaQuery.from(getDtoClass());

		criteriaQuery.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, criteriaBuilder, qRoot);

		for (Predicate condition : whereClause) {
			criteriaQuery.where(condition);
		}

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);

		return query;
	}

	@Override
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		
		TypedQuery<T> query = createCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		System.out.println("===================" + list);
		return list;
	}
	

	@Override
	public List search(T dto, UserContext userContext) {
		// TODO Auto-generated method stub
		return search(dto, 0, 5, userContext);
	}
	
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	protected boolean isNotNull(Object val) {
		return val != null;
	}

}
