package com.example.blended.Diary

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.BaseColumns._ID
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blended.*

import com.example.blended.Diary.DatabaseManager.DiaryEntry.COLUMN_DATE
import com.example.blended.Diary.DatabaseManager.DiaryEntry.COLUMN_DIARY
import com.example.blended.Diary.DatabaseManager.DiaryEntry.COLUMN_TITLE
import com.example.blended.Diary.DatabaseManager.DiaryEntry.TABLE_NAME
import com.example.blended.Lists.CalorieMainList
import kotlinx.android.synthetic.main.activity_diary.*



class DiaryActivity : AppCompatActivity() {

    private lateinit var mDBHelper: DiaryDBHelper

    private var diaryList: ArrayList<Diary> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)


        mDBHelper = DiaryDBHelper(this)

//        displayDataInfo()


    }

    fun displayDataInfo() {
        val db = mDBHelper.readableDatabase

        val projection = arrayOf(_ID, COLUMN_DATE, COLUMN_TITLE, COLUMN_DIARY)

        val cursor: Cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)

        val idColumnIndex = cursor.getColumnIndexOrThrow(_ID)
        val dateColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_DATE)
        val titleColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_TITLE)
        val diaryColumIndex = cursor.getColumnIndexOrThrow(COLUMN_DIARY)

        while (cursor.moveToNext()) {

            val currentId = cursor.getInt(idColumnIndex)
            val currentDate = cursor.getString(dateColumnIndex)
            val currentTitle = cursor.getString(titleColumnIndex)
            val currentDiary = cursor.getString(diaryColumIndex)

            diaryList.add(Diary(currentId, currentDate, currentTitle, currentDiary, ))
        }

        cursor.close()

        linearLayoutManager = LinearLayoutManager(this)

        diary_recycler_view.layoutManager = linearLayoutManager
        adapter = DiaryAdapter(diaryList)
        diary_recycler_view.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        diaryList.clear()
        displayDataInfo()
    }

    fun createNewDiary(view: View) {
        val intent = Intent(this, NewDiaryActivity::class.java)
        startActivity(intent)
    }

    //menu for the page
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this@DiaryActivity, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@DiaryActivity, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@DiaryActivity, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@DiaryActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@DiaryActivity, History::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@DiaryActivity, ContactUs::class.java)
                startActivity(intent)

            }
            R.id.bmi1 -> {
                val intent = Intent(this@DiaryActivity, BMIActivity::class.java)
                startActivity(intent)

            }
            R.id.diary1 -> {
                val intent = Intent(this@DiaryActivity, DiaryActivity::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }
}
