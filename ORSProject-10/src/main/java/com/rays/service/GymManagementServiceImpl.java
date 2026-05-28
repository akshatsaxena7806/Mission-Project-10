package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.GymManagementDAOInt;
import com.rays.dto.GymManagementDTO;

@Service
@Transactional
public class GymManagementServiceImpl extends BaseServiceImpl<GymManagementDTO, GymManagementDAOInt> implements GymManagementServiceInt{

}
