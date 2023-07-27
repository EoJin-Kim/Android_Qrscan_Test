package com.ej.defaultcamera_gallary_test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ej.defaultcamera_gallary_test.databinding.ActivityScannerBinding
import com.google.zxing.Result
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CaptureManager
import me.dm7.barcodescanner.zxing.ZXingScannerView

class QrScannerActivity : AppCompatActivity(){
    private lateinit var binding: ActivityScannerBinding
    private lateinit var capture : CaptureManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_scanner)

        capture = CaptureManager(this,binding.barcodescanner)
        capture.initializeFromIntent(Intent(), savedInstanceState)
        capture.decode()

        binding.barcodescanner.decodeContinuous(getBarcodeCallBack())
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
    var idx = 0;
    fun getBarcodeCallBack(): BarcodeCallback {
        return object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                result?.let {
                    val qrText = it.text
                    Toast.makeText(baseContext,"$qrText : ${idx++}", Toast.LENGTH_SHORT).show()
                    val intent = Intent()
                    intent.putExtra("sdfd",qrText)
                    setResult(RESULT_OK,intent)
                    finish()
                }
            }

            override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {
            }
        }
    }
}