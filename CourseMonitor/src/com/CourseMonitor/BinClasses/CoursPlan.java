package com.CourseMonitor.BinClasses;

public class CoursPlan {
	
	private int PlanId;
	private int BatchId;
	private int DayNumber;
	private String Topic;
	private String Status;
	
	
	public CoursPlan(int planId, int batchId, int dayNumber, String topic, String status) {
		super();
		PlanId = planId;
		BatchId = batchId;
		DayNumber = dayNumber;
		Topic = topic;
		Status = status;
	}


	public int getPlanId() {
		return PlanId;
	}


	public void setPlanId(int planId) {
		PlanId = planId;
	}


	public int getBatchId() {
		return BatchId;
	}


	public void setBatchId(int batchId) {
		BatchId = batchId;
	}


	public int getDayNumber() {
		return DayNumber;
	}


	public void setDayNumber(int dayNumber) {
		DayNumber = dayNumber;
	}


	public String getTopic() {
		return Topic;
	}


	public void setTopic(String topic) {
		Topic = topic;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "CoursPlan [PlanId=" + PlanId + ", BatchId=" + BatchId + ", DayNumber=" + DayNumber + ", Topic=" + Topic
				+ ", Status=" + Status + "]";
	}
	
	

}
