package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.BaseServiceInt;
import com.rays.dao.GenderDAOInt;
import com.rays.dto.GenderDTO;

@Service
@Transactional
public class GenderServiceImpl extends BaseServiceImpl<GenderDTO, GenderDAOInt> implements GenderServiceInt{

}
