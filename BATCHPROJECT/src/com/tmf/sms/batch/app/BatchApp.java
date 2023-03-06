package com.tmf.sms.batch.app;

import com.tmf.sms.batch.service.BatchService;
import com.tmf.sms.batch.service.BatchServiceImpl;

public class BatchApp {

	public static void main(String[] args) {
		BatchService service = new BatchServiceImpl();
		service.menu();
	}

}
