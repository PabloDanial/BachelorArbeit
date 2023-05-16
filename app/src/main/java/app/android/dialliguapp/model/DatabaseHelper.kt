package app.android.dialliguapp.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery =
                                "CREATE TABLE $TABLE_NAME" +
                                "($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "$COL_USERNAME TEXT, " +
                                "$COL_PASSWORD TEXT)"
        db?.execSQL(createTableQuery)
    }

    //if it's necessary
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2)
            db?.execSQL("ALTER TABLE $TABLE_NAME ADD COLUMN $COL_EMAIL TEXT")
    }


    companion object{
        private const val DATABASE_NAME = "credential.db"
        private const val DATABASE_VERSION = 3
        private const val TABLE_NAME = "user"
        private const val COL_ID = "id"
        private const val COL_USERNAME = "username"
        private const val COL_PASSWORD = "password"
        private const val COL_EMAIL = "username@gmail.com"
    }


    val dbHelper = DatabaseHelper(context)
    val db = dbHelper.writableDatabase // add data (table) to database

    fun insertCredentialsDb(username: String, password: String) {
        val values = ContentValues()
        values.put(DatabaseHelper.COL_USERNAME, username)
        values.put(DatabaseHelper.COL_PASSWORD, password)

        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }





}