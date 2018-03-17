package com.igumnov.common.example;


import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Field;
import com.igumnov.common.orm.annotations.Id;
@Entity(tableName = "ExampleUser")
public class ExampleUser {

    @Id(autoIncremental = false, fieldName = "userName")
    public String userName;
    @Field(fieldName = "userPassword", autoIncremental = false)
    public String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
