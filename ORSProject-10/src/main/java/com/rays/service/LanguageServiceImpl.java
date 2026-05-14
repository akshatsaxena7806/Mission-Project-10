package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.LanguageDAOInt;
import com.rays.dto.LanguageDTO;

@Service
@Transactional
public class LanguageServiceImpl  extends BaseServiceImpl<LanguageDTO, LanguageDAOInt> implements LanguageServiceInt{

}
