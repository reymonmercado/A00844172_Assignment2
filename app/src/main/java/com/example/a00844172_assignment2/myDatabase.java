package com.example.a00844172_assignment2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Customer.class, Employee.class, ServiceType.class, CustomerService.class, CustomerServiceSchedule.class, CustSched.class}, version = 1,
exportSchema = false)
public abstract class myDatabase extends RoomDatabase{

    private static myDatabase instance;

    public abstract myDao myDao();

    public static synchronized myDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    myDatabase.class, "database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private myDao myDao;

        private PopulateDbAsyncTask(myDatabase db){
            myDao = db.myDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDao.insert(new CustSched("Dwight Schrute", "Main Street", "Honesdale",
                    "June 5", "Male", "Health Check", "8pm",
                    "1 hour", "Scheduled"));

            myDao.insert(new CustSched("Michael Scott", "Fake Street", "Dunder",
                    "August 1", "Male", "Medication", "5pm",
                    "2 hours", "Scheduled"));

            myDao.insert(new CustSched("Jim Halpert", "Pam Street", "Mifflin",
                    "February 24", "Male", "Food Prep", "9am",
                    "3 hours", "Scheduled"));

            return null;
        }
    }

}
