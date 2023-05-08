package com.example.dataanalyticrestfulapi.repository.provider;

import org.apache.ibatis.jdbc.SQL;

import static org.springframework.http.HttpHeaders.FROM;

public class UserProvider {
    public static String getAllUsers(String filterName){
        return new SQL(){{
            SELECT("*");
            FROM("users_tb");
            if (!filterName.isEmpty()){
                WHERE("upper(username) like upper('%' || #{filterName} || '%' )");

            }

        }}.toString();
    }
//    public static String createNewUser(){
//        return  new SQL(){{
//            INSERT_INTO("users_tb");
//            VALUES("username","#{u.username}");
//            VALUES("gender","#{u.gender}");
//            VALUES("address","#{u.address}");
//        }}.toString();
//    }
}
