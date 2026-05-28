package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_GYMMANAGEMENT")
public class GymManagementDTO extends BaseDTO {
	
	
	@Column(name = "memberId", length = 55)
	private String memberId ;

	@Column(name = "memberName", length = 55)
	private String memberName ;

	@Column(name = "trainerName", length = 55)
	private String  trainerName;

	@Column(name = "membershipFee")
	private double membershipFee;

	@Column(name = "workoutType", length = 55)
	private String workoutType;
	
	
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public double getMembershipFee() {
		return membershipFee;
	}

	public void setMembershipFee(double membershipFee) {
		this.membershipFee = membershipFee;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return memberName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "memberId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return memberId;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "memberId";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Gym Management";
	}

}
