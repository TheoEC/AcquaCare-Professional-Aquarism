package com.tmpsolutions.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tmpsolutions.data.entity.AnimalInfo
import com.tmpsolutions.data.entity.AquariumEntity
import com.tmpsolutions.data.entity.HabitantEntity

@Database(
    entities = [
        AquariumEntity::class,
        HabitantEntity::class,
        AnimalInfo::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase(){
    abstract fun AquariumDao() : AquariumDao
}