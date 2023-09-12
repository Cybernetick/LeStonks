package personal.vankhulup.lestonks.android

import android.app.Application

class LeStonksApp: Application() {

  val component: ApplicationComponent by lazy {
    ApplicationComponent::class.create(this)
  }

  override fun onCreate() {
    super.onCreate()
  }
}