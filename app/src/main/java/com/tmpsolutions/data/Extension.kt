package com.tmpsolutions.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tmpsolutions.data.entity.paremeters.ParameterType
import com.tmpsolutions.domain.model.parameters.AquariumParameterID
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
    val ammonia = ParameterType(
        id = AquariumParameterID.AMMONIA,
        name = "Amonia",
        metric = "ppm",
        name2 = "Concentração de amonia",
        metric2 = "?",
    )

    val salinity = ParameterType(
        id = AquariumParameterID.SALINITY,
        name = "Salinity",
        metric = "SG"
    )

    val ph = ParameterType(
        id = AquariumParameterID.PH,
        name = "PH",
        metric = ""
    )

    val kh = ParameterType(
        id = AquariumParameterID.KH,
        name = "KH",
        metric = "°dKH"
    )

    val gh = ParameterType(
        id = AquariumParameterID.GH,
        name = "GH",
        metric = "°dH"
    )

    val nitrite = ParameterType(
        id = AquariumParameterID.NITRITE,
        name = "Nitrite",
        metric = "°dH"
    )

    val nitrate = ParameterType(
        id = AquariumParameterID.NITRATE,
        name = "Nitrato",
        metric = "°dH"
    )

    val temperature = ParameterType(
        id = AquariumParameterID.TEMPERATURE,
        name = "GH",
        metric = "°dH"
    )

    val calcium = ParameterType(
        id = AquariumParameterID.CALCIUM,
        name = "Calcio",
        metric = "mg/L"
    )

    val magnesium = ParameterType(
        id = AquariumParameterID.MAGNESIUM,
        name = "Magnesium",
        metric = "mg/L"
    )

    val phosphate = ParameterType(
        id = AquariumParameterID.PHOSPHATE,
        name = "Phosphate",
        metric = "mg/L"
    )

    val potassium = ParameterType(
        id = AquariumParameterID.POTASSIUM,
        name = "Potassium",
        metric = "mg/L"
    )

    dao.insert(ammonia)
    dao.insert(salinity)
    dao.insert(ph)
    dao.insert(kh)
    dao.insert(gh)
    dao.insert(nitrate)
    dao.insert(nitrite)
    dao.insert(temperature)
    dao.insert(calcium)
    dao.insert(magnesium)
    dao.insert(phosphate)
    dao.insert(potassium)
}