package com.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

@Service
@Transactional
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt> implements MarksheetServiceInt{
	
	
	@Override
	@Transactional(readOnly = true)
	public List<MarksheetDTO> getMeritList(UserContext userContext){
		return dao.getMeritList(userContext);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return dao.findByUniqueKey("rollNo", rollNo, context);
	}


}
