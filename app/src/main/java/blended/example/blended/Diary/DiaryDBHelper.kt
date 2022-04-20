package com.wit.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import com.example.blended.DatabaseManager.DiaryEntry.COLUMN_DATE
import com.example.blended.DatabaseManager.DiaryEntry.COLUMN_DIARY
import com.example.blended.DatabaseManager.DiaryEntry.COLUMN_TITLE
import com.example.blended.DatabaseManager.DiaryEntry.TABLE_NAME


class DiaryDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {


    companion object {
        private  val DATABASE_NAME = "mydiaries.db"
        private  val DATABASE_VERSION = 1
        private  val SQL_CREATE_DIARY_TABLE = "CREATE TABLE $TABLE_NAME (" +
                "$_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_DATE TEXT, " +
                "$COLUMN_TITLE TEXT, " +
                "$COLUMN_DIARY TEXT )"
        public final val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS {$TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL(SQL_CREATE_DIARY_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(SQL_DELETE_ENTRIES)
    }


}
