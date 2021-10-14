package school.alihamz.assignment2.database

import android.content.Context
import android.os.AsyncTask
import school.alihamz.assignment2.model.AppData

class UserRepository(context: Context) {

    var db: PersonDao = AppDatabase.getInstance(context)?.personDao()!!


    //Fetch All the Users
    fun getAllUsers(): List<AppData> {
        return db.loadAllPersons()
    }

    // Insert new user
    fun insertUser(users: AppData) {
        insertAsyncTask(db).execute(users)
    }

    // update user
    fun updateUser(users: AppData) {
        db.updatePerson(users)
    }

    // Delete user
    fun deleteUser(users: AppData) {
        db.delete(users)
    }

    private class insertAsyncTask internal constructor(private val usersDao: PersonDao) :
        AsyncTask<AppData, Void, Void>() {

        override fun doInBackground(vararg params: AppData): Void? {
            usersDao.insertPerson(params[0])
            return null
        }
    }
}