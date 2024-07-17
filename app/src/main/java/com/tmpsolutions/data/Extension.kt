package com.tmpsolutions.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tmpsolutions.data.mapper.toEntity
import com.tmpsolutions.domain.model.parameters.CommonParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val DATA_BASE_NAME = "aquariums-database"

val Context.db: AppDataBase
    get() = Room.databaseBuilder(
        applicationContext,
        AppDataBase::class.java, DATA_BASE_NAME
    )
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    val tempBD = Room.databaseBuilder(
                        applicationContext,
                        AppDataBase::class.java, DATA_BASE_NAME
                    ).build()
                    
                    prePopulateDataBase(tempBD.AquariumDao())
                }
            }
        })
        .build()

private suspend fun prePopulateDataBase(dao: AquariumDao) {
//    with(CommonParameters) {
//        dao.insert(ammonia.toEntity())
//        dao.insert(salinity.toEntity())
//        dao.insert(ph.toEntity())
//        dao.insert(kh.toEntity())
//        dao.insert(gh.toEntity())
//        dao.insert(nitrate.toEntity())
//        dao.insert(nitrite.toEntity())
//        dao.insert(temperature.toEntity())
//        dao.insert(calcium.toEntity())
//        dao.insert(magnesium.toEntity())
//        dao.insert(phosphate.toEntity())
//        dao.insert(potassium.toEntity())
//    }
}