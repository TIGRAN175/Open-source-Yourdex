package com.example.yourdex;

public class Credentials {


    private String getUsername;
    private String getPassword;


Credentials(String username, String password){

          this.getUsername = username;
          this.getPassword = password;

}
    public String getUsername(){
       return  getUsername;
      }

      public void setUsername(String username){
          getUsername = username;

      }

      public String getPassword(){
    return getPassword;

      }


      public void setPassword(String password){
    getPassword = password;

      }
}