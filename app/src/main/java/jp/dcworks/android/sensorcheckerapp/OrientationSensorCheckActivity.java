package jp.dcworks.android.sensorcheckerapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class OrientationSensorCheckActivity extends SensorCheckBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_value_layout);
        
        sensor1TextView = (TextView) findViewById(R.id.sensorX);
        sensor2TextView = (TextView) findViewById(R.id.sensorY);
        sensor3TextView = (TextView) findViewById(R.id.sensorZ);
        
        TextView title =  (TextView) findViewById(R.id.titleText);
        title.setText("傾き(方向)センサー");

        TextView measure =  (TextView) findViewById(R.id.measure);
        measure.setText("単位：Degrees(度）");
        
        TextView value1 = (TextView) findViewById(R.id.value1Text);
        value1.setText("方　角 : ");
        TextView value2 = (TextView) findViewById(R.id.value2Text);
        value2.setText("ピッチ : ");
        TextView value3 = (TextView) findViewById(R.id.value3Text);
        value3.setText("ロール : ");
        
    }
	
    @Override
 	protected void onResume() {
     	super.onResume();
     	
     	// 回転ベクトルセンサーを指定してSensorインスタンスを取得
     	Sensor linearAccelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
     	//リスナー登録
     	if (linearAccelerometerSensor != null) {
     		sensorManager.registerListener(this,linearAccelerometerSensor,SensorManager.SENSOR_DELAY_GAME);
     	}

    }
    
	@Override
	public void onSensorChanged(SensorEvent event) {

		// Lowpass Filter 
		currentSensorValues[0] = event.values[0] * 0.1f + currentSensorValues[0] * (1.0f - 0.1f);  
		currentSensorValues[1] = event.values[1] * 0.1f + currentSensorValues[1] * (1.0f - 0.1f);  
		currentSensorValues[2] = event.values[2] * 0.1f + currentSensorValues[2] * (1.0f - 0.1f);
		
		
		sensor1TextView.setText(String.valueOf(currentSensorValues[0]));
		
		sensor2TextView.setText(String.valueOf(currentSensorValues[1]));

		sensor3TextView.setText(String.valueOf(currentSensorValues[2]));

		
	}
}
