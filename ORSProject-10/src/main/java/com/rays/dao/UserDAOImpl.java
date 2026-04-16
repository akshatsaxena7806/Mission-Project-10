package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.service.AttachmentServiceInt;

/**
 * DAO implementation for User operations.
 *
 * @author Akshat Saxena
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

    /** Service for managing user profile attachments. */
    @Autowired
    private AttachmentServiceInt attachmentService;

    /** DAO for fetching role details. */
    @Autowired
    private RoleDAOInt roleDao;

    /**
     * Builds WHERE clause predicates based on user search criteria.
     *
     * @param dto     search criteria
     * @param builder criteria builder
     * @param qRoot   root entity
     * @return list of predicates
     */
    @Override
    protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {
        List<Predicate> conditions = new ArrayList<Predicate>();
        if (dto != null) {
            if (!isEmptyString(dto.getFirstName())) {
                conditions.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
            }
            if (!isEmptyString(dto.getLastName())) {
                conditions.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
            }
            if (!isEmptyString(dto.getRoleName())) {
                conditions.add(builder.like(qRoot.get("roleName"), dto.getRoleName() + "%"));
            }
            if (!isEmptyString(dto.getLoginId())) {
                conditions.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
            }
            if (!isEmptyString(dto.getStatus())) {
                conditions.add(builder.like(qRoot.get("statusId"), dto.getStatus() + "%"));
            }
        }
        return conditions;
    }

    /**
     * Returns the DTO class type.
     *
     * @return UserDTO.class
     */
    @Override
    public Class<UserDTO> getDtoClass() {
        // TODO Auto-generated method stub
        return UserDTO.class;
    }

    /**
     * Populates role name, last login, and image ID on the DTO.
     *
     * @param dto         user data to populate
     * @param userContext current user context
     */
    @Override
    public void populate(UserDTO dto, UserContext userContext) {
        if (dto.getRoleId() != null && dto.getRoleId() > 0) {
            RoleDTO roleDto = roleDao.findByPk(dto.getRoleId(), userContext);
            dto.setRoleName(roleDto.getName());
        }
        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO userData = findByPk(dto.getId(), userContext);
            dto.setLastLogin(userData.getLastLogin());
        }
        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO userData = findByPk(dto.getId(), userContext);
            dto.setImageId(userData.getImageId());
        }
    }

    /**
     * Deletes user along with their profile image if present.
     *
     * @param dto         user to delete
     * @param userContext current user context
     */
    @Override
    public void delete(UserDTO dto, UserContext userContext) {
        if (dto.getImageId() != null && dto.getImageId() > 0) {
            attachmentService.delete(dto.getImageId(), userContext);
        }
        super.delete(dto, userContext);
    }
}