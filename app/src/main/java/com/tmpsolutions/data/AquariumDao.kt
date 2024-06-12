package com.tmpsolutions.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.tmpsolutions.data.entity.AnimalInfo
import com.tmpsolutions.data.entity.AquariumEntity
import com.tmpsolutions.data.entity.FullAquarium
import com.tmpsolutions.data.entity.HabitantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AquariumDao {
    @Insert
    suspend fun insert(aquarium: AquariumEntity)

    @Insert
    suspend fun insert(habitant: HabitantEntity)

    @Insert
    suspend fun insert(animalInfo: AnimalInfo)

    @Transaction
    @Query("Select * From aquarium")
    fun getAll(): Flow<List<FullAquarium>>

    @Transaction
    @Query("Select * From aquarium where id = :aquariumID")
    fun getAquarium(aquariumID: Int): Flow<FullAquarium>

    @Update
    suspend fun update(aquarium: AquariumEntity)

    @Insert
    suspend fun update(habitant: HabitantEntity)

    @Insert
    suspend fun update(animalInfo: AnimalInfo)

}