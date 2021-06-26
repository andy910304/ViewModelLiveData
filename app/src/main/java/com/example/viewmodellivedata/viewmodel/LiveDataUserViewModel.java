package com.example.viewmodellivedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodellivedata.User;

import java.util.ArrayList;
import java.util.List;

//Clase observable que permite la reactividad en android

public class LiveDataUserViewModel extends ViewModel {

    private MutableLiveData<List<User>> userListLiveData; // MutableLiveData puede ser modificado
    private List<User> userList;

    public LiveData<List<User>> getUserList(){ //LiveData es solo de lectura
        if (userListLiveData == null) {
            userListLiveData = new MutableLiveData<List<User>>();
            userList = new ArrayList<User>();
        }
        return userListLiveData;
    }

    public void addUser(User user){
        userList.add(user);
        userListLiveData.setValue(userList);
    }
}
