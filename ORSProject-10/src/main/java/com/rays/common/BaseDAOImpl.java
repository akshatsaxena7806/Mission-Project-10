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

/**
 * Abstract base DAO providing common CRUD and search operations.
 *
 * @param <T>    DTO type extending {@link BaseDTO}
 * @author Akshat Saxena
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

    /** JPA entity manager for database operations. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Builds WHERE clause predicates for search queries.
     *
     * @param dto     search criteria
     * @param builder criteria builder
     * @param qRoot   root entity
     * @return list of predicates
     */
    protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

    /**
     * Returns the DTO class type.
     *
     * @return DTO class
     */
    public abstract Class<T> getDtoClass();

    /**
     * Hook method to populate additional fields before persist or merge.
     *
     * @param dto         entity to populate
     * @param userContext current user context
     */
    public void populate(T dto, UserContext userContext) {

    }

    /**
     * Persists a new entity and returns its generated ID.
     *
     * @param dto         entity to add
     * @param userContext current user context
     * @return generated primary key
     */
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

    /**
     * Fetches top 10 records using the provided HQL for merit list.
     *
     * @param hql         HQL query string
     * @param userContext current user context
     * @return list of results
     */
    public List marksheetMeritList(String hql, UserContext userContext) {
        Query q = entityManager.createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(10);
        List l = q.getResultList();
        return l;
    }

    /**
     * Updates an existing entity with audit timestamps.
     *
     * @param dto         entity to update
     * @param userContext current user context
     */
    @Override
    public void update(T dto, UserContext userContext) {

        dto.setCreatedBy(userContext.getLoginId());
        dto.setModifiedBy(userContext.getLoginId());
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

        populate(dto, userContext);

        entityManager.merge(dto);

    }

    /**
     * Removes the given entity from the database.
     *
     * @param dto         entity to delete
     * @param userContext current user context
     */
    @Override
    public void delete(T dto, UserContext userContext) {

        entityManager.remove(dto);

    }

    /**
     * Finds an entity by its primary key.
     *
     * @param id          primary key
     * @param userContext current user context
     * @return matching entity or {@code null}
     */
    @Override
    public T findByPk(long id, UserContext userContext) {
        T dto = entityManager.find(getDtoClass(), id);
        return dto;
    }

    /**
     * Finds a single entity by a unique attribute and value.
     *
     * @param attribute   field name to match
     * @param value       value to match
     * @param userContext current user context
     * @return matching entity or {@code null}
     */
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

    /**
     * Builds a typed criteria query from the given DTO filters.
     *
     * @param dto         search criteria
     * @param userContext current user context
     * @return configured typed query
     */
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

    /**
     * Searches entities with pagination support.
     *
     * @param dto         search criteria
     * @param pageNo      page number (zero-based)
     * @param pageSize    number of records per page
     * @param userContext current user context
     * @return paginated list of results
     */
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

    /**
     * Searches entities using default page size of 5.
     *
     * @param dto         search criteria
     * @param userContext current user context
     * @return list of results
     */
    @Override
    public List search(T dto, UserContext userContext) {
        // TODO Auto-generated method stub
        return search(dto, 0, 5, userContext);
    }

    /**
     * Checks if a string is null or blank.
     *
     * @param val string to check
     * @return {@code true} if null or empty
     */
    protected boolean isEmptyString(String val) {
        return val == null || val.trim().length() == 0;
    }

    /**
     * Checks if a Double value is null or zero.
     *
     * @param val value to check
     * @return {@code true} if null or zero
     */
    protected boolean isZeroNumber(Double val) {
        return val == null || val == 0;
    }

    /**
     * Checks if a Long value is null or zero.
     *
     * @param val value to check
     * @return {@code true} if null or zero
     */
    protected boolean isZeroNumber(Long val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an Integer value is null or zero.
     *
     * @param val value to check
     * @return {@code true} if null or zero
     */
    protected boolean isZeroNumber(Integer val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an object is not null.
     *
     * @param val object to check
     * @return {@code true} if not null
     */
    protected boolean isNotNull(Object val) {
        return val != null;
    }

}