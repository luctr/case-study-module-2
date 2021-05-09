package controller;

import model.LogIn;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private static LoginManager INSTANCE = new LoginManager();
    private  List<LogIn> listLogIn = new ArrayList<>();

    public  List<LogIn> getListLogIn() {
        return listLogIn;
    }

    public void setListLogIn(List<LogIn> listLogIn) {
        this.listLogIn = listLogIn;
    }

    public static LoginManager getINSTANCE() {
        return INSTANCE;
    }

    private LoginManager() {
    }

    public static void setINSTANCE(LoginManager INSTANCE) {
        LoginManager.INSTANCE = INSTANCE;
    }

    public  boolean checkUser(String user, String password) {
        for (int i = 0; i < listLogIn.size(); i++) {
            if (listLogIn.get(i).getUser().equals(user)) {
                if (listLogIn.get(i).getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public  void addList(LogIn logIn) {
        listLogIn.add(logIn);
        FileManager.writeFile("LogIn.dat", logIn);
    }

    public  boolean check(String name) {
        for (int i = 0; i < listLogIn.size(); i++) {
            if (listLogIn.get(i).getUser().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public  void showUser(){
        for (int i = 0; i < listLogIn.size(); i++) {
            System.out.println(listLogIn.get(i).getUser());
        }
    }

}
