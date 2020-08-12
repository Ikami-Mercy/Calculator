package com.tindi.my_calc

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log

class CalculationService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate()")
    }

    override fun onBind(intent: Intent): IBinder? {
        return object : CalcService.Stub() {
            @Throws(RemoteException::class)
            override fun add(firstValue: Double, secondValue: Double): Double {
                return firstValue + secondValue
            }

            @Throws(RemoteException::class)
            override fun subtract(firstValue: Double, secondValue: Double): Double {
                return firstValue - secondValue
            }

            @Throws(RemoteException::class)
            override fun multiply(firstValue: Double, secondValue: Double): Double {
                return firstValue * secondValue
            }

            @Throws(RemoteException::class)
            override fun divide(firstValue: Double, secondValue: Double): Double {
                return firstValue / secondValue
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    companion object {
        private val TAG = "CalculationService"
    }
}
