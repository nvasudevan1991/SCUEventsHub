package edu.scu.androidproject;

/**
 * Created by nithi on 5/5/2017.
 */

public class DbContact {

    String fName,lName,pass,cPass,email,userName;
    public void setfName(String name1)
    {
        fName=name1;
    }
    public void setlName(String name2)
    {
        lName=name2;
    }
    public  void setEmail(String email)
    {
        this.email=email;
    }
    public  void setPass(String pass)
    {
        this.pass=pass;
    }
    public void setcPass(String cPass)
{
    this.cPass=cPass;
}
    public void setUserName(String userName)
{
    this.userName=userName;
}
    public String getUserName(){

      return  this.userName;
    }
    public String getcPass()
    {
       return this.cPass;
    }
    public String getPass()
    {
        return this.pass;
    }
    public String getEmail()
    {
        return  this.email;

    }
    public String getfName()
    {
        return fName;
    }
    public String getlName()
    {
        return lName;
    }

}
