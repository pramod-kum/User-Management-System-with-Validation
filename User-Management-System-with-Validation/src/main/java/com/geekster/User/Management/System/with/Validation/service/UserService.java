package com.geekster.User.Management.System.with.Validation.service;

import com.geekster.User.Management.System.with.Validation.model.UserModel;
import com.geekster.User.Management.System.with.Validation.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserDao userdao;
    public String addNewUser(UserModel usermodel){
        boolean checkPoint = userdao.save(usermodel);

        if(checkPoint){
            return "Added Successfully!!";
        }else{
            return "Not Added Error!!";
        }
    }

    public ArrayList<UserModel> getAllUsers(){
        return userdao.getUsers();
    }

    public UserModel getUserById(int userid){
        ArrayList<UserModel> helperList = getAllUsers();
        UserModel matchingUser = null;
        for(UserModel user : helperList){
            if(user.getUserId() == userid){
                matchingUser = user;
                break;
            }
        }
        return matchingUser;
    }

    public String updateUser(int userid , UserModel usermodel){
        boolean updateStatus = userdao.updateUserById(userid , usermodel);
        if(updateStatus){
            return "User " + userid + " was Updated!!";
        }else{
            return "User " + userid + " does not Exist!!";
        }
    }

    public String deleteUserById(int userid){
        ArrayList<UserModel> helperList = getAllUsers();
        boolean deleteStatus = false;
        for(UserModel user : helperList) {
            if (user.getUserId() == userid) {
                deleteStatus = userdao.deleteUser(user);
                break;
            }
        }
        if(deleteStatus) {
            return "User " + userid + " removed from database!!";
        }else {
            return "User " + userid + " does not Exit!!";
        }
    }
}
