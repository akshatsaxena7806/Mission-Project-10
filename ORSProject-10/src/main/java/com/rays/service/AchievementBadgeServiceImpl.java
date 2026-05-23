package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AchievementBadgeDAOInt;
import com.rays.dto.AchievementBadgeDTO;


@Service
@Transactional
public class AchievementBadgeServiceImpl extends BaseServiceImpl<AchievementBadgeDTO, AchievementBadgeDAOInt> implements AchievementBadgeServiceInt {

}
