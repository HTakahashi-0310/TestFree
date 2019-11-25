package com.tkhiromu13.testfree;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public abstract class GetSpeed extends AppCompatActivity implements LocationListener {
    private LocationManager locationManager;    //ロケーションマネージャー
    private float speed = 0f;                   //速度用の変数


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //ポーズ時にはGPS（位置情報）の取得を解除する
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //GPS（位置情報）の取得が許可があるのかをチェック
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //GPSの使用が許可されていなければパーミッションを要求し、その後再度チェックが行われる
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            return;
        }
        //ロケーションマネージャーにGPS（位置情報）のリクエストを開始する
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        //速度が出ている？
        if(location.hasSpeed()) {
            //速度が出ている時（km/hに変換して変数speedへ）
            speed = location.getSpeed() * 3.6f;
        } else {
            //速度が出ていない時
            speed = 0;
        }
        if(speed >= 40){
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) { }

    @Override
    public void onProviderEnabled(String s) { }

    @Override
    public void onProviderDisabled(String s) { }

}
