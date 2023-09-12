package personal.vankhulup.dbsqldelight.di

import app.cash.sqldelight.db.SqlDriver
import me.tatarka.inject.annotations.Provides
import personal.vankhulup.dbsqldelight.LeStonksDb
import personal.vankhulup.dbsqldelight.daos.TickerDao

expect interface SQLDelightDatabasePlatformComponent


interface DatabaseComponent : SQLDelightDatabasePlatformComponent {

  @Provides
  fun provideDatabase(driver: SqlDriver): LeStonksDb =
    LeStonksDb(driver)

  @Provides
  fun provideTickerDao(database: LeStonksDb): TickerDao = TickerDao(database)
}


