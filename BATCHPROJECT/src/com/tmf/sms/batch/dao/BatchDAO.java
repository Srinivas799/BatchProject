package com.tmf.sms.batch.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tmf.sms.batch.dbconfig.DBConfig;
import com.tmf.sms.batch.model.Batch;

public interface BatchDAO {
	List<Batch> batchs = new ArrayList<Batch>();
	DBConfig db = new DBConfig();
	Connection con = db.getConnection();
	
	boolean addBatch(Batch batch);
	List<Batch> displayBatch();
	Batch displayBatchByBatchId();
	Batch displayBatchByCourseId();
	List<Batch> displayBatchByStartDate();
	List<Batch> displayBatchByEndDate();
	List<Batch> displayBatchByStatus(String Status);
	boolean deleteBatch(Batch batch);
}
