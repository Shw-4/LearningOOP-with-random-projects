package com.mycompany.grademanagementsystem;

import java.io.IOException;

public class Utils {
    
    //cls
    public void cls(){
    try {

     if (System.getProperty("os.name").contains("Windows"))
         new ProcessBuilder("cmd", "/c", 
                  "cls").inheritIO().start().waitFor();
     else
         Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
}
    
    //Timer method
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
