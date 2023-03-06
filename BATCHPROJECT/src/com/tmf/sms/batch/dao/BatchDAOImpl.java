package com.tmf.sms.batch.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tmf.sms.batch.model.Batch;

public class BatchDAOImpl implements BatchDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	

	@Override
	public boolean addBatch(Batch batch) {
		boolean result = false;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Enter Batch Id");
			int BatchId =Integer.parseInt(br.readLine());
			System.out.println("Enter Course Id");
			int CourseId =Integer.parseInt(br.readLine());
			System.out.println("Enter Batch Starting Date in yyyy-mm-dd");
			String StartDate = br.readLine();
			System.out.println("Enter Batch Ending Date in yyyy-mm-dd");
			String EndDate = br.readLine();
			System.out.println("Enter No of Males");
			int NoOfMales =Integer.parseInt(br.readLine());
			System.out.println("Enter No Of Females");
			int NoOfFemales =Integer.parseInt(br.readLine());
			System.out.println("Enter Batch Status");
			String Status = br.readLine();
			Date start = Date.valueOf(StartDate);
			Date end = Date.valueOf(EndDate);
			
			String query = "insert into batch values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, BatchId);
			ps.setInt(2, CourseId);
			ps.setDate(3, start);
			ps.setDate(4, end);
			ps.setDouble(5, NoOfMales);
			ps.setDouble(6, NoOfFemales);
			ps.setDouble(7, NoOfMales+NoOfFemales);
			ps.setString(8, Status);
			
			ps.execute();
			
			System.out.println("Student has been inserted successfully ...");
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Batch> displayBatch() {
		List<Batch> batchs = new ArrayList<Batch>();
		//batchs.clear();
		try {
			query = "select * from batch";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{	
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				Batch batch = new Batch(bid,cid,start,end,males,females,total,status);
				batchs.add(batch);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchs;
	}

	@Override
	public Batch displayBatchByBatchId() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Batch Id");
		int BatchId = scan.nextInt();
		Batch batch = new Batch(0,0,null,null,0,0,0,null);
		try {
			query = "select * from batch where BatchId like ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, BatchId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				batch = new Batch(bid,cid,start,end,males,females,total,status);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batch;
	}

	@Override
	public Batch displayBatchByCourseId() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Course Id");
		int CourseId = scan.nextInt();
		Batch batch = null;
		try {
			query = "select * from batch where CourseId=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, CourseId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				batch = new Batch(bid,cid,start,end,males,females,total,status);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batch;
		
	}

	@Override
	public List<Batch> displayBatchByStartDate(){
		
		batchs.clear();
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Enter Batch Starting Date in yyyy-mm-dd");
			String Start = br.readLine();
			Date StartDate = Date.valueOf(Start);
			
			
			query = "select * from batch where StartDate = ?";
			ps = con.prepareStatement(query);
			ps.setDate(1, StartDate);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				Batch batch = new Batch(bid,cid,start,end,males,females,total,status);
				batchs.add(batch);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
			}
			if(!rs.next())
			{
				System.out.println("There is no batch with this Start Date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchs;
	}

	@Override
	public List<Batch> displayBatchByEndDate() {
		batchs.clear();
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Enter Batch Starting Date in yyyy-mm-dd");
			String End = br.readLine();
			Date EndDate = Date.valueOf(End);
			
			
			query = "select * from batch where EndDate = ?";
			ps = con.prepareStatement(query);
			ps.setDate(1, EndDate);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				Batch batch = new Batch(bid,cid,start,end,males,females,total,status);
				batchs.add(batch);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
			}
			if(!rs.next())
			{
				System.out.println("There is no batch with this End Date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchs;
	}

	@Override
	public List<Batch> displayBatchByStatus(String Status) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Status of Batch");
		Status = scan.nextLine(); 
		
		batchs.clear();
		try {
			query = "select * from batch where Status = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, Status);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				Date start = rs.getDate("StartDate");
				Date end = rs.getDate("EndDate");
				double males = rs.getDouble("NoOfMales");
				double females = rs.getDouble("NoOfFemales");
				double total = rs.getDouble("TotalNoOfStudents");
				String status = rs.getString("Status");
				
				Batch batch = new Batch(bid,cid,start,end,males,females,total,status);
				batchs.add(batch);
				
				System.out.println("BatchId= " + bid + ", CourseId= " + cid + ", StartDate= " + start + ", EndDate= "+ end + ", NoOfMales= " + males + ", NoOfFemales= " + females + ", TotalNoOfStudents= "+ total + ", Status= " + status +"");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchs;
	}

	@Override
	public boolean deleteBatch(Batch batch) {
		boolean result = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Batch Id you want to delete");
		int BatchId = scan.nextInt();
		try {
			query = "delete from batch where BatchId = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, BatchId);
			ps.execute();
			result = true;
			
			System.out.println("Batch deleted successfully......");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
