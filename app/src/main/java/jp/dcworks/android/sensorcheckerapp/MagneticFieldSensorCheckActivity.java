package jp.dcworks.android.sensorcheckerapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MagneticFieldSensorCheckActivity extends SensorCheckBaseActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_value_layout);
        
        sensor1TextView = (TextView) findViewById(R.id.sensorX);
        sensor2TextView = (TextView) findViewById(R.id.sensorY);
        sensor3TextView = (TextView) findViewById(R.id.sensorZ);
        
        TextView title =  (TextView) findViewById(R.id.titleText);
        title.setText("地磁気センサー");
        
        TextView measure =  (TextView) findViewById(R.id.measure);
        measure.setText("単位：μT(マイクロテスラー)");
        
        TextView value1 = (TextView) findViewById(R.id.value1Text);
        value1.setText("X軸 : ");
        TextView value2 = (TextView) findViewById(R.id.value2Text);
        value2.setText("Y軸 : ");
        TextView value3 = (TextView) findViewById(R.id.value3Text);
        value3.setText("Z軸 : ");
        
    }
	
    @Override
 	protected void onResume() {
     	super.onResume();
     	
     	// 地磁気センサーを指定してSensorインスタンスを取得
     	Sensor magneticFieldSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
     	//リスナー登録
     	if (magneticFieldSensor != null) {
     		sensorManager.registerListener(this,magneticFieldSensor,SensorManager.SENSOR_DELAY_GAME);
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
