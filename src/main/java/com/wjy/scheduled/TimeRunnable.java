package com.wjy.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeRunnable implements Runnable {

	@Override
	public void run() {

		try {

			System.out.println(new SimpleDateFormat("mm:ss").format(new Date()));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
