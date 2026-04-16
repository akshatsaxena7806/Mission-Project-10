package com.rays.common;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract base service providing common transactional CRUD and search operations.
 *
 * @param <T> DTO type extending {@link BaseDTO}
 * @param <D> DAO type extending {@link BaseDAOInt}
 * @author Akshat Saxena
 */
@Transactional
public abstract class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

    /** DAO layer for database operations. */
    @Autowired
    protected D dao;

    /**
     * Adds a new entity and returns its generated ID.
     *
     * @param dto         entity to add
     * @param userContext current user context
     * @return generated primary key
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public long add(T dto, UserContext userContext) {
        long id = dao.add(dto, userContext);
        return id;
    }

    /**
     * Updates an existing entity.
     *
     * @param dto         entity to update
     * @param userContext current user context
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T dto, UserContext userContext) {
        dao.update(dto, userContext);
    }

    /**
     * Saves entity — updates if ID exists, otherwise adds new.
     *
     * @param dto         entity to save
     * @param userContext current user context
     * @return primary key of saved entity
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(T dto, UserContext userContext) {
        Long id = dto.getId();
        if (id != null && id > 0) {
            dao.update(dto, userContext);
        } else {
            id = dao.add(dto, userContext);
        }
        return id;
    }

    /**
     * Deletes an entity by ID. Throws exception if not found.
     *
     * @param id          primary key of entity to delete
     * @param userContext current user context
     * @return deleted entity
     * @throws RuntimeException if record not found
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T delete(Long id, UserContext userContext) {
        T dto = findById(id, userContext);
        if (dto == null) {
            throw new RuntimeException("record not found");
        }

        System.out.println(dto);
        dao.delete(dto, userContext);
        return dto;
    }

    /**
     * Finds an entity by primary key. Throws exception if not found.
     *
     * @param id          primary key
     * @param userContext current user context
     * @return matching entity
     * @throws RuntimeException if record not found
     */
    @Override
    @Transactional(readOnly = true)
    public T findById(long id, UserContext userContext) {
        T dto = dao.findByPk(id, userContext);
        if (dto == null) {
            throw new RuntimeException("record not found");
        }
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
    @Transactional(readOnly = true)
    public T findByUniqueKey(String attribute, String value, UserContext userContext) {
        T dto = dao.findByUniqueKey(attribute, value, userContext);
        return dto;
    }

    /**
     * Searches entities with pagination.
     *
     * @param dto         search criteria
     * @param pageNo      page number (zero-based)
     * @param pageSize    number of records per page
     * @param userContext current user context
     * @return paginated list of results
     */
    @Override
    @Transactional(readOnly = true)
    public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
        List list = dao.search(dto, pageNo, pageSize, userContext);
        return list;
    }

    /**
     * Searches entities using default page size. Throws exception if none found.
     *
     * @param dto         search criteria
     * @param userContext current user context
     * @return list of matching results
     * @throws RuntimeException if no records found
     */
    @Override
    @Transactional(readOnly = true)
    public List search(T dto, UserContext userContext) {
        List<T> list = dao.search(dto, userContext);
        if (list.size() == 0) {
            throw new RuntimeException("record not found");
        }
        return list;
    }
}