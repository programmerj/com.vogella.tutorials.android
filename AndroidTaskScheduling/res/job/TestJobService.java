package com.vogella.android.jobscheduler;

import java.util.LinkedList;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * JobService to be scheduled by the JobScheduler. 
 * Requests scheduled with the JobScheduler call the "onStartJob" method
 */
public class TestJobService extends JobService {
	private static final String TAG = "SyncService";

	@Override
	public boolean onStartJob(JobParameters params) {
	    // run in the main thread
		// start your service here or perform some asynchronous processing
		return true;
	}

	@Override
	public boolean onStopJob(JobParameters params) {
		return true;
	}

}
