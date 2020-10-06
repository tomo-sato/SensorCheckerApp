package jp.dcworks.android.sensorcheckerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SensorCheckerAppActivity extends Activity implements SensorEventListener , OnClickListener {
	
	private SensorManager sensorManager;
	
	private Button accelerometerButton;
	private Button orientationButton;
	private Button magneticFieldButton;
	private Button lightButton;
	private Button proximityButton;
	private Button temperatureButton;
	private Button pressureButton;
	private Button gyroscopeButton;
	private Button gravityButton;
	private Button linearAccelerometerButton;
	private Button rotationVetorButton;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu);
        
        // SensorManagerインスタンスを取得
        sensorManager = 
        	(SensorManager) 
        		getSystemService(Context.SENSOR_SERVICE);
        
        accelerometerButton = (Button) findViewById(R.id.accelerometerButton);
        accelerometerButton.setOnClickListener(this);
        
        orientationButton = (Button) findViewById(R.id.orientationButton);
        orientationButton.setOnClickListener(this);
        
        magneticFieldButton = (Button) findViewById(R.id.magneticFieldButton);
        magneticFieldButton.setOnClickListener(this);
        
        lightButton = (Button) findViewById(R.id.lightButton);
        proximityButton = (Button) findViewById(R.id.proximityButton);
        temperatureButton = (Button) findViewById(R.id.temperatureButton);
        pressureButton = (Button) findViewById(R.id.pressureButton);
        gyroscopeButton = (Button) findViewById(R.id.gyroscopeButton);
        
        gravityButton = (Button) findViewById(R.id.gravityButton);
        gravityButton.setOnClickListener(this);
        
        linearAccelerometerButton = (Button) findViewById(R.id.linearAccelerometerButton);
        linearAccelerometerButton.setOnClickListener(this);
        
        rotationVetorButton = (Button) findViewById(R.id.rotationVectorButton);
        rotationVetorButton.setOnClickListener(this);
        
    }
    
    public void  onClick(View view) {
    	if(view.getId() == R.id.accelerometerButton){
    		Intent intent = new Intent(this,AccelerometerSensorCheckActivity.class);
    		startActivity(intent);
    	}
    	else if (view.getId() == R.id.magneticFieldButton) {
       		Intent intent = new Intent(this,MagneticFieldSensorCheckActivity.class);
    		startActivity(intent);
    	}
    	else if (view.getId() == R.id.linearAccelerometerButton) {
       		Intent intent = new Intent(this,LinearAccelerometerSensorCheckActivity.class);
    		startActivity(intent);
    	}
    	else if (view.getId() == R.id.rotationVectorButton) {
       		Intent intent = new Intent(this,RotationVectorSensorCheckActivity.class);
    		startActivity(intent);
    	}
    	else if (view.getId() == R.id.gravityButton) {
       		Intent intent = new Intent(this,GravitySensorCheckActivity.class);
    		startActivity(intent);
    	}
    	else if (view.getId() == R.id.orientationButton) {
       		Intent intent = new Intent(this,OrientationSensorCheckActivity.class);
    		startActivity(intent);
    	}
    	
    }
    
    
    @Override
 	protected void onResume() {
     	super.onResume();
     	
     	// 加速度センサーを指定してSensorインスタンスを取得
     	Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
     	if (accelerometerSensor==null){
     		accelerometerButton.setEnabled(false);
     	}

    	// 傾きセンサーを指定してSensorインスタンスを取得
     	Sensor orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
     	if (orientationSensor==null){
     		orientationButton.setEnabled(false);
     	}
     	
    	// 地磁気センサーを指定してSensorインスタンスを取得
     	Sensor magneticFieldSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
     	if (magneticFieldSensor==null){
     		magneticFieldButton.setEnabled(false);
     	}

    	// 照度センサーを指定してSensorインスタンスを取得
     	Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
     	if (lightSensor==null){
     		lightButton.setEnabled(false);
     	}
     	
    	// 近接センサーを指定してSensorインスタンスを取得
     	Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
     	if (proximitySensor==null){
     		proximityButton.setEnabled(false);
     	}
     	
    	// 温度センサーを指定してSensorインスタンスを取得
     	Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
     	if (temperatureSensor==null){
     		temperatureButton.setEnabled(false);
     	}
     	
    	// 圧力センサーを指定してSensorインスタンスを取得
     	Sensor pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
     	if (pressureSensor==null){
     		pressureButton.setEnabled(false);
     	}
     	
    	// ジャイロスコープセンサーを指定してSensorインスタンスを取得
     	Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
     	if (gyroscopeSensor==null){
     		gyroscopeButton.setEnabled(false);
     	}
     	
    	// 重力センサーを指定してSensorインスタンスを取得
     	Sensor gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
     	if (gravitySensor==null){
     		gravityButton.setEnabled(false);
     	}
     	
    	// 直線加速度センサーを指定してSensorインスタンスを取得
     	Sensor linearAccelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
     	if (linearAccelerationSensor==null){
     		linearAccelerometerButton.setEnabled(false);
     	}
     	
    	// 回転ベクトルセンサーを指定してSensorインスタンスを取得
     	Sensor rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
     	if (rotationVectorSensor==null){
     		rotationVetorButton.setEnabled(false);
     	}    	
     	   	
     }

    @Override
    protected void onPause() {
        super.onPause();
        
        // センサーリスナーを解除
        //sensorManager.unregisterListener(this);
        
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