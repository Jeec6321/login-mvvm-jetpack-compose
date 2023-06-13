package com.minutos.tumpi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minutos.tumpi.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    /*@Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>*/

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    suspend fun findUser(email: String, password: String): User?

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}