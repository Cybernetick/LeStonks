package personal.vankhulup.lestonks.android

import android.app.Application
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import personal.vankhulup.lestonks.SharedComponent

@Component
abstract class ApplicationComponent(@get:Provides val application: Application) : SharedComponent {
}