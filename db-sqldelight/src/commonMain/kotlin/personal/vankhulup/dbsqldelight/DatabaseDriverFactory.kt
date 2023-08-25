package personal.vankhulup.dbsqldelight

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
  fun createDriver(): SqlDriver
}

fun createDatabase(driver: SqlDriver): LeStonksDb =
  LeStonksDb(driver)

