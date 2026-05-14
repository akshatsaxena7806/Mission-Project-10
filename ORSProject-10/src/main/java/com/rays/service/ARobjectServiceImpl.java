package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ARObjectDAOInt;
import com.rays.dto.ARObjectDTO;

@Service
@Transactional
public class ARobjectServiceImpl extends BaseServiceImpl<ARObjectDTO, ARObjectDAOInt> implements ARObjectServiceInt {

}
