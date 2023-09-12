package personal.vankhulup.dbsqldelight.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import me.tatarka.inject.annotations.Provides
import personal.vankhulup.dbsqldelight.LeStonksDb

actual interface SQLDelightDatabasePlatformComponent {
  @Provides
  fun createDriver(context: Application): SqlDriver =
    AndroidSqliteDriver(schema = LeStonksDb.Schema, context = context, name = "lestonks.db")
}