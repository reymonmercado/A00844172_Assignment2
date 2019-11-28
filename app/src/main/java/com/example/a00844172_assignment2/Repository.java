package com.example.a00844172_assignment2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import java.util.List;

public class Repository {

    private myDao myDao;
    private LiveData<List<CustSched>> allCustSched;

    public Repository(Application application){
        myDatabase database = myDatabase.getInstance(application);
        myDao = database.myDao();
        allCustSched = myDao.getAllCustSched();
    }

    public void insert(CustSched custSched){

        new InsertCustSchedAsyncTask(myDao).execute(custSched);

    }

    public void update(CustSched custSched){

        new UpdateCustSchedAsyncTask(myDao).execute(custSched);

    }

    public void delete(CustSched custSched){

        new DeleteCustSchedAsyncTask(myDao).execute(custSched);

    }

    public void deleteAllCustSched(){

        new DeleteAllCustSchedAsyncTask(myDao).execute();

    }

    public void populateDBAsyncTask(){
        new PopulateDbAsyncTask(myDao).execute();
    }

    public LiveData<List<CustSched>> getAllCustSched(){
        return allCustSched;
    }

    private static class InsertCustSchedAsyncTask extends AsyncTask<CustSched, Void, Void>{

        private myDao myDao;

        private InsertCustSchedAsyncTask(myDao myDao){
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(CustSched... custScheds) {
            myDao.insert(custScheds[0]);
            return null;
        }
    }

    private static class UpdateCustSchedAsyncTask extends AsyncTask<CustSched, Void, Void>{
        private myDao myDao;

        private UpdateCustSchedAsyncTask(myDao myDao){
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(CustSched... custScheds) {
            myDao.update(custScheds[0]);
            return null;
        }
    }

    private static class DeleteCustSchedAsyncTask extends AsyncTask<CustSched, Void, Void>{
        private myDao myDao;

        private DeleteCustSchedAsyncTask(myDao myDao){
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(CustSched... custScheds) {
            myDao.delete(custScheds[0]);
            return null;
        }
    }

    private static class DeleteAllCustSchedAsyncTask extends AsyncTask<CustSched, Void, Void>{
        private myDao myDao;

        private DeleteAllCustSchedAsyncTask(myDao myDao){
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(CustSched... custScheds) {
            myDao.deleteAllCustSched();
            return null;
        }
    }

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private myDao myDao;

        private PopulateDbAsyncTask(myDao myDao){
            this.myDao = myDao;
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
