package com.example.a00844172_assignment2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<CustSched>> allCustSched;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allCustSched = repository.getAllCustSched();
    }

    public void insert(CustSched custSched){
        repository.insert(custSched);
    }

    public void update(CustSched custSched){
        repository.update(custSched);
    }

    public void delete(CustSched custSched){
        repository.delete(custSched);
    }

    public void deleteAllNotes(){
        repository.deleteAllCustSched();
    }

    public LiveData<List<CustSched>> getAllCustSched() {
        return allCustSched;
    }

    public void populateDBAsyncTask(){ repository.populateDBAsyncTask();
    }
}
