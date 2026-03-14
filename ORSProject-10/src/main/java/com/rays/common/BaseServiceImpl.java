package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	@Autowired
	protected D dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto, UserContext userContext) {
		long id = dao.add(dto, userContext);
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) {
		dao.update(dto, userContext);

	}

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

	@Override
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto = dao.findByPk(id, userContext);
		if (dto == null) {
			throw new RuntimeException("record not found");

		}
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String value, UserContext userContext) {

		T dto = dao.findByUniqueKey(attribute, value, userContext);

		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		
		
		List list = dao.search(dto, pageNo, pageSize, userContext);

		
		return list;
	}

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
