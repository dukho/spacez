package com.nomadworks.spacez.resource

import android.content.Context
import android.provider.Settings
import com.nomadworks.spacez.BuildConfig

class ResourceQueryImpl (private val context: Context) : ResourceQuery {
    private val releaseConfig = if (BuildConfig.DEBUG) "DEBUG" else "RELEASE"

    override fun getString(resId: Int): String = context.getString(resId)
    override fun getString(resId: Int, param: String): String = getString(resId).format(param)
    override fun getStringArray(resId: Int): Array<String> = context.resources.getStringArray(resId)
    override fun getQuantityString(resId: Int, count: Int, param: String) = context.resources.getQuantityString(resId, count, param)

    override fun getDeviceId(): String = context.getDeviceId()
    override fun getVersionInfo(): String = "Version ${BuildConfig.VERSION_NAME} (build ${BuildConfig.VERSION_CODE}) - $releaseConfig"
    override fun getVersionName(): String = BuildConfig.VERSION_NAME
    override fun getVersionCode(): String = "${BuildConfig.VERSION_CODE}"

    private fun Context.getDeviceId() = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}