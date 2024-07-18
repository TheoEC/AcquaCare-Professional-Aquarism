package com.tmpsolutions.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.tmpsolutions.data.entity.AnimalInfo
import com.tmpsolutions.data.entity.AquariumEntity
import com.tmpsolutions.data.entity.FullAquarium
import com.tmpsolutions.data.entity.HabitantEntity
import com.tmpsolutions.data.entity.paremeters.AquariumParameter
import com.tmpsolutions.data.entity.paremeters.AquariumParameterWithType
import com.tmpsolutions.data.entity.paremeters.Measurement
import com.tmpsolutions.data.entity.paremeters.ParameterTypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AquariumDao {
    @Insert
    suspend fun insert(aquarium: AquariumEntity)

    @Insert
    suspend fun insert(habitant: HabitantEntity)

    @Insert
    suspend fun insert(animalInfo: AnimalInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(parameterTypeEntity: ParameterTypeEntity)

    @Query("Select * From parametertype")
    fun getParameterTypes() : Flow<List<ParameterTypeEntity>>

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

    // PARAMETERS

    @Insert
    fun insert(aquariumParameter: AquariumParameter)

    @Query("Select * From aquarium_parameter where aquarium_id = :aquariumID")
    fun getAllAquariumParameters(aquariumID: Int) : Flow<List<AquariumParameterWithType>>

    @Query("""
        Select * From measurement where parameter_id = :parameterID
        ORDER BY date DESC
        LIMIT 1
    """)
    suspend fun getLastMeasurement(parameterID: Int) : Measurement?
}