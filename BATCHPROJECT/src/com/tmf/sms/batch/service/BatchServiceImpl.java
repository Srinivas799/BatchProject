package com.tmf.sms.batch.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.tmf.sms.batch.model.Batch;

public class BatchServiceImpl implements BatchService {
	private static final Date StartDate = null;
	private static final Date EndDate = null;
	private static final String Status = null;
	Batch batch = new Batch(0,0,null,null,0,0,0,null);
	Scanner scan = new Scanner(System.in);
	@Override
	public boolean addBatch() {
		// TODO Auto-generated method stub
		return dao.addBatch(batch);
	}

	@Override
	public List<Batch> displayBatch() {
		// TODO Auto-generated method stub
		return dao.displayBatch();
	}

	@Override
	public Batch displayBatchByBatchId() {
		// TODO Auto-generated method stub
		return dao.displayBatchByBatchId();
	}

	@Override
	public Batch displayBatchByCourseId() {
		// TODO Auto-generated method stub
		return dao.displayBatchByCourseId();
	}

	@Override
	public List<Batch> displayBatchByStartDate(Date StartDate) {
		// TODO Auto-generated method stub
		return dao.displayBatchByStartDate();
	}

	@Override
	public List<Batch> displayBatchByEndDate(Date EndDate) {
		// TODO Auto-generated method stub
		return dao.displayBatchByEndDate();
	}

	@Override
	public List<Batch> displayBatchByStatus(String Status) {
		// TODO Auto-generated method stub
		return dao.displayBatchByStatus(Status);
	}

	@Override
	public void menu() {
		while(true) {
			System.out.println("========================STUDENT MANAGEMENT SYSTEM=====================");
			System.out.println("Press 1 for Add New Batch");
			System.out.println("Press 2 for Display All Available Batchs");
			System.out.println("Press 3 for Display Batch By BatchId");
			System.out.println("Press 4 for Display Batch By CourseId");
			System.out.println("Press 5 for Display Batch By Starting Date");
			System.out.println("Press 6 for Display Batch By Ending Date");
			System.out.println("Press 7 for Display Batch By Status");
			System.out.println("Press 8 for Delete Batch using Batch Id");
			System.out.println("Press 0 for Exit");
			System.out.println("Please Enter your choice ");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 0 : System.exit(choice);
			case 1 : addBatch();break;
			case 2 : displayBatch();break;
			case 3 : displayBatchByBatchId();break;
			case 4 : displayBatchByCourseId();break;
			case 5 : displayBatchByStartDate(StartDate);break;
			case 6 : displayBatchByEndDate(EndDate);break;
			case 7 : displayBatchByStatus(Status);break;
			case 8 : deleteBatch();break;
			default : System.out.println("Sorry!!!! You have entered a wrong choice...");
			}
		}
	}

	@Override
	public boolean deleteBatch() {
		
		return dao.deleteBatch(batch);
	}
}
