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
       // if (oldVersion < 2)
         //   db?.execSQL("ALTER TABLE $TABLE_NAME ADD COLUMN $COL_EMAIL TEXT")
    }


    companion object{
        const val DATABASE_NAME = "credential.db"
        const val DATABASE_VERSION = 3
        const val TABLE_NAME = "admin_table"
        private const val COL_ID = "id"
        const val COL_USERNAME = "username"
        const val COL_PASSWORD = "password"
    }


    private val dbHelper = DatabaseHelper(context)

    fun insertCredentialsDb() {
        val values = ContentValues()
        values.put(COL_USERNAME,"test")
        values.put(COL_PASSWORD, "test")
        val db = writableDatabase // add data (table) to database
        db.insert(TABLE_NAME, null, values)
        db.close()
    }



    fun retrieveCredentialFromDb(username: String, password: String): Boolean {
        val selection = "$COL_USERNAME = ? AND $COL_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = dbHelper.readableDatabase.query(
            TABLE_NAME,
            arrayOf(COL_USERNAME, COL_PASSWORD),
            null,
            null,
            null,
            null,
            null
        )
        val isValidCredentials = cursor.count > 0
        cursor.close()
        return isValidCredentials
    }


}