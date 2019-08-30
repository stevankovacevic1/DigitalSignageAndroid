package com.consulteer.digital_signage.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.consulteer.digital_signage.data.db.entities.Event
import com.consulteer.digital_signage.data.db.entities.Group
import com.consulteer.digital_signage.data.db.entities.User

@Database(
    entities = [User::class, Event::class, Group::class],// what repose and entities with table have and when is used
    version = 1
)
abstract class AppDatabase : RoomDatabase() {


    abstract fun getUserDao(): UserDao
    abstract fun getEventDao(): EventDao
    abstract fun getGroupDao(): GroupDao
    abstract fun getVacReqDao() : VacReqDao


    companion object {

        @Volatile//this var is building of all the other threads
        private var instance: AppDatabase? = null
        private val LOCK = Any()/// no 2 instance at time

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }/// menjaces posle bazu, dok je current user logged user

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Digital_Signage.db"
            ).build()
    }


}