package com.saucefan.stuff.additionalandroidm01.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

//i hope this guy isn't one of those social justice warriors,
//   looking for more of a healer
//ba dum tish

class ProgressWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        //todo
        return Result.failure()
    }
}


/*
private Runnable mUpdateTimeTask = new Runnable() {
       public void run() {
           long totalDuration = mp.getDuration();
           long currentDuration = mp.getCurrentPosition();

           // Displaying Total Duration time
           songTotalDurationLabel.setText(""+utils.milliSecondsToTimer(totalDuration));
           // Displaying time completed playing
           songCurrentDurationLabel.setText(""+utils.milliSecondsToTimer(currentDuration));

           // Updating progress bar
           int progress = (int)(utils.getProgressPercentage(currentDuration, totalDuration));
           //Log.d("Progress", ""+progress);
           songProgressBar.setProgress(progress);

           // Running this thread after 100 milliseconds
           mHandler.postDelayed(this, 100);
       }
    };
private Handler mHandler = new Handler();
//Make sure you update Seekbar on UI thread
MainActivity.this.runOnUiThread(new Runnable() {

    @Override
    public void run() {
        if(mMediaPlayer != null){
            int mCurrentPosition = mMediaPlayer.getCurrentPosition() / 1000;
            mSeekBar.setProgress(mCurrentPosition);
        }
        mHandler.postDelayed(this, 1000);
    }
});
 */