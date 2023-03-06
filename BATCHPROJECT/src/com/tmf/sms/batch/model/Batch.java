package com.tmf.sms.batch.model;

import java.sql.Date;

public class Batch {
	private int BatchId,CourseId;
	private Date StartDate,EndDate;
	private double NoOfMales,NoOfFemales,TotalNoOfStudents;
	private String Status;
	public int getBatchId() {
		return BatchId;
	}
	public void setBatchId(int batchId) {
		BatchId = batchId;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public double getNoOfMales() {
		return NoOfMales;
	}
	public void setNoOfMales(double noOfMales) {
		NoOfMales = noOfMales;
	}
	public double getNoOfFemales() {
		return NoOfFemales;
	}
	public void setNoOfFemales(double noOfFemales) {
		NoOfFemales = noOfFemales;
	}
	public double getTotalNoOfStudents() {
		return TotalNoOfStudents;
	}
	public void setTotalNoOfStudents(double totalNoOfStudents) {
		TotalNoOfStudents = totalNoOfStudents;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Batch(int batchId, int courseId, Date startDate, Date endDate, double noOfMales, double noOfFemales,
			double totalNoOfStudents, String status) {
		super();
		BatchId = batchId;
		CourseId = courseId;
		StartDate = startDate;
		EndDate = endDate;
		NoOfMales = noOfMales;
		NoOfFemales = noOfFemales;
		TotalNoOfStudents = totalNoOfStudents;
		Status = status;
	}
	@Override
	public String toString() {
		return "Batch [BatchId=" + BatchId + ", CourseId=" + CourseId + ", StartDate=" + StartDate + ", EndDate="
				+ EndDate + ", NoOfMales=" + NoOfMales + ", NoOfFemales=" + NoOfFemales + ", TotalNoOfStudents="
				+ TotalNoOfStudents + ", Status=" + Status + "]";
	}
	
	
}
