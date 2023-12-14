package com.ej.defaultcamera_gallary_test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ej.defaultcamera_gallary_test.databinding.FragmentQrBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QrFragment : Fragment() {
    lateinit var binding : FragmentQrBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_qr,container,false)

        //integrator = 적분기, 바코드 스캐너 실행
        val integrator = IntentIntegrator.forSupportFragment(this@QrFragment)
        integrator.setBeepEnabled(false) // 스캔 시 소리
        integrator.setOrientationLocked(false) // 가로,세로 모드 고정
        integrator.captureActivity = QrScannerActivity::class.java //커스텀 스캐너 액티비티
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE) //원하는 바코드 형식
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES) //원하는 바코드 형식
        integrator.setPrompt("Scan QR code") //스캔 하단 문구
        integrator.initiateScan() // 스캐너 실행


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {

        val TAG = this::class.java.simpleName

        @JvmStatic
        fun newInstance() =
            QrFragment()
    }
}