package com.ej.defaultcamera_gallary_test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ej.defaultcamera_gallary_test.databinding.ActivityScannerBinding
import com.journeyapps.barcodescanner.CaptureManager

class QrScannerActivity : AppCompatActivity(){
    private lateinit var binding: ActivityScannerBinding
    private lateinit var capture : CaptureManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_scanner)

        capture = CaptureManager(this,binding.barcodescanner)
        capture.initializeFromIntent(Intent(), savedInstanceState)
        capture.decode()
    }

    override fun onDestroy() {
        super.onDestroy()
        capture.onDestroy()
    }
    override fun onResume() {
        super.onResume()
        capture.onResume()
    }

    override fun onPause() {
        super.onPause()
        capture.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        capture.onSaveInstanceState(outState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        capture.onRequestPermissionsResult(requestCode,permissions, grantResults)
    }

}