package com.geekster.User.Management.System.with.Validation.repository;

import com.geekster.User.Management.System.with.Validation.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDao {

    ArrayList<UserModel> userList  = new ArrayList<>();

    public boolean save(UserModel usermodel){
     userList.add(usermodel);
     return true;
    }

    public ArrayList<UserModel> getUsers(){
        return userList;
    }

    public boolean updateUserById(int userid , UserModel usermodel){
        for(UserModel userObject : userList){
            if(userid==userObject.getUserId()){
                userObject.setUserId(usermodel.getUserId());
                userObject.setUserName(usermodel.getUserName());
                userObject.setDateOfBirth(usermodel.getDateOfBirth());
                userObject.setEmailId(usermodel.getEmailId());
                userObject.setPhoneNumber(usermodel.getPhoneNumber());
                userObject.setDate(usermodel.getDate());
                userObject.setTime(usermodel.getTime());
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(UserModel user){
        userList.remove((user));
        return true;
    }
}
