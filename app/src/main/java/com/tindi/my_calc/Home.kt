package com.tindi.my_calc

import androidx.appcompat.app.AppCompatActivity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.text.DecimalFormat
import java.text.ParseException

class Home : AppCompatActivity() {
     var service: CalcService? = null
     private lateinit var connection: CalculationServiceConnection
     var v1 = 0.0
     var v2 = 0.0
     var res = 0.0


    /**
     * This class represents the actual service connection. It casts the bound
     * stub implementation of the service to the AIDL interface.
     */
    inner class CalculationServiceConnection : ServiceConnection {

        override fun onServiceConnected(name: ComponentName, boundService: IBinder) {
            service = CalcService.Stub.asInterface(boundService)
            Log.d(TAG, "onServiceConnected() connected")
            Toast.makeText(this@Home, "Service connected", Toast.LENGTH_LONG)
                    .show()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            service = null
            Log.d(TAG, "onServiceDisconnected() disconnected")
            Toast.makeText(this@Home, "Service connected", Toast.LENGTH_LONG)
                    .show()
        }
    }

    /**
     * Binds this activity to the service.
     */
    private fun initService() {
        connection = CalculationServiceConnection()
        val i = Intent()
        i.setClassName("com.tindi.my_calc", CalculationService::class.java!!.getName())
        val ret = bindService(i, connection!!, Context.BIND_AUTO_CREATE)
        Log.d(TAG, "initService() bound with $ret")
    }

    /**
     * Unbinds this activity from the service.
     */
    private fun releaseService() {
        unbindService(this.connection)
        //connection = null
        Log.d(TAG, "releaseService() unbound.")
    }

    private fun initUI() {
        /**
         * Setup the UI
         */

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val result = findViewById<TextView>(R.id.result)
        val value1 = findViewById<EditText>(R.id.value1)
        val value2 = findViewById<EditText>(R.id.value2)


        buttonAdd.setOnClickListener { v: View ->

            if (value1.text.toString().isEmpty() || value2.text.toString().isEmpty()) {
                result.setText("result")
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    v1 = DecimalFormat.getNumberInstance().parse(value1.text.toString())!!.toDouble()
                    v2 = DecimalFormat.getNumberInstance().parse(value2.text.toString())!!.toDouble()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                try {
                    res = service!!.add(v1, v2)
                } catch (e: RemoteException) {
                    Log.e(TAG, "onClick failed with: $e")
                    e.printStackTrace()
                }

                result.text = java.lang.Double.valueOf(res).toString()
            }
        }

        buttonSubtract.setOnClickListener { v: View ->
            if (value1.text.toString().isEmpty() || value2.text.toString().isEmpty()) {
                result.setText("result")
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()

            } else {

                try {
                    v1 = DecimalFormat.getNumberInstance().parse(value1.text.toString())!!.toDouble()
                    v2 = DecimalFormat.getNumberInstance().parse(value2.text.toString())!!.toDouble()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                //v1 = Double.parseDouble(value1.getText().toString());
                //v2 = Double.parseDouble(value2.getText().toString());


                try {
                    res = service!!.subtract(v1, v2)
                } catch (e: RemoteException) {
                    Log.e(TAG, "onClick failed with: $e")
                    e.printStackTrace()
                }

                result.text = java.lang.Double.valueOf(res).toString()
            }
        }

        buttonMultiply.setOnClickListener { v: View ->

            if (value1.text.toString().isEmpty() || value2.text.toString().isEmpty()) {
                result.setText("result")
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()

            } else {
                try {
                    v1 = DecimalFormat.getNumberInstance().parse(value1.text.toString())!!.toDouble()
                    v2 = DecimalFormat.getNumberInstance().parse(value2.text.toString())!!.toDouble()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                try {
                    res = service!!.multiply(v1, v2)
                } catch (e: RemoteException) {
                    Log.e(TAG, "onClick failed with: $e")
                    e.printStackTrace()
                }

                result.text = res.toString()
            }
        }

        buttonDivide.setOnClickListener { v: View ->
            //str != null && !str.isEmpty()
            if (value1.text.toString().isEmpty() || value2.text.toString().isEmpty()) {
                result.setText("result")
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()

            } else {
                try {
                    v1 = DecimalFormat.getNumberInstance().parse(value1.text.toString())!!.toDouble()
                    v2 = DecimalFormat.getNumberInstance().parse(value2.text.toString())!!.toDouble()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                try {
                    res = service!!.divide(v1, v2)
                } catch (e: RemoteException) {
                    Log.e(TAG, "onClick failed with: $e")
                    e.printStackTrace()
                }

                result.text = res.toString()
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initService()
        initUI()

    }

    override fun onDestroy() {
        super.onDestroy()
        releaseService()
    }

    companion object {
        private val TAG = "Home"
    }
}
