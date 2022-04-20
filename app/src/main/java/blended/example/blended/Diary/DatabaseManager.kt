package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.provider.BaseColumns

object DatabaseManager {

    //the entries for the database to store the variables
    object DiaryEntry : BaseColumns {
        const val TABLE_NAME = "diaries"

        const val ID = BaseColumns._ID

        const val COLUMN_DATE = "date"

        const val COLUMN_TITLE = "title"

        const val COLUMN_DIARY = "diary"

    }
}