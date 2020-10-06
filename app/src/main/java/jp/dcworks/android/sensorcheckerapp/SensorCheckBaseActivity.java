package jp.dcworks.android.sensorcheckerapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class SensorCheckBaseActivity extends Activity implements SensorEventListener {

	protected TextView sensor1TextView;
	protected TextView sensor2TextView;
	protected TextView sensor3TextView;
	
	//センサーマネージャ
	protected SensorManager sensorManager;
	
	//ローパスフィルタ用の現在のセンサーの値
	protected float[] currentSensorValues = {0.0f, 0.0f ,0.0f};  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
        //センサーマネージャの取得
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
	}

    @Override
    protected void onPause() {
    	super.onPause();
        
        // センサーリスナーを解除
        sensorManager.unregisterListener(this);
        
    }
    
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
}
