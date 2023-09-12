package personal.vankhulup.dbsqldelight.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import me.tatarka.inject.annotations.Provides
import personal.vankhulup.dbsqldelight.LeStonksDb

actual interface SQLDelightDatabasePlatformComponent {
  @Provides
  fun createDriver(): SqlDriver = NativeSqliteDriver(LeStonksDb.Schema, name = "lestonks.db")
}