package com.tmf.sms.batch.service;

import java.sql.Date;
import java.util.List;

import com.tmf.sms.batch.dao.BatchDAO;
import com.tmf.sms.batch.dao.BatchDAOImpl;
import com.tmf.sms.batch.model.Batch;

public interface BatchService {
	BatchDAO dao = new BatchDAOImpl();
	
	boolean addBatch();
	List<Batch> displayBatch();
	Batch displayBatchByBatchId();
	Batch displayBatchByCourseId();
	List<Batch> displayBatchByStartDate(Date StartDate);
	List<Batch> displayBatchByEndDate(Date EndDate);
	List<Batch> displayBatchByStatus(String Status);
	boolean deleteBatch();
	public void menu();
	
}
