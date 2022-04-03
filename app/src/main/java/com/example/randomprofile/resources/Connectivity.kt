package com.example.randomprofile.resources

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.randomprofile.activities.Profile

class Connectivity {

   fun VerifyConnection(obj: Activity): Boolean? {
        return try {

            val ConnectivityM: ConnectivityManager
            ConnectivityM =
                obj.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                val networkInfo = ConnectivityM.activeNetworkInfo
                return networkInfo != null && networkInfo.isConnected
            }
            val networks = ConnectivityM.allNetworks
            var hasInternet = false
            if (networks.size > 0) {
                for (network in networks) {
                    val nc = ConnectivityM.getNetworkCapabilities(network)
                    if (nc!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) hasInternet =
                        true
                }
            }
            hasInternet
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


     fun isOnlineNet(): Boolean? {
         try {
             val p =
                 Runtime.getRuntime().exec("ping -c 1 www.google.es")
             val v = p.waitFor()
             val r = (v==0)
             return r
         } catch (e: java.lang.Exception) {
             e.printStackTrace()
         }
         return false
     }
}