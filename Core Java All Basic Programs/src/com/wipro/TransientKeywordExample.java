package com.wipro;

import java.io.*;

// Serializable class
class UserCredentials implements Serializable {
    private static final long serialVersionUID = 1L;

    String userName;
    transient String password;  // excluded from serialization

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void display() {
        System.out.println("UserName : " + userName);
        System.out.println("Password : " + password);
    }
}

// Serialization logic
class SerializeData {
    public void serializeData() {
        UserCredentials cr = new UserCredentials("Niti", "3434sdfdsf");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bfile.ser"));
            out.writeObject(cr);
            out.close();
            System.out.println("Data is serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Deserialization logic
class DeSerializeData {
    public void deSerializeData() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("bfile.ser"));
            UserCredentials user = (UserCredentials) in.readObject();
            in.close();
            System.out.println("Data is deserialized");
            user.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Main class
public class TransientKeywordExample {
    public static void main(String[] args) {
        SerializeData sd = new SerializeData();
        sd.serializeData();

        DeSerializeData ds = new DeSerializeData();
        ds.deSerializeData();
    }
}
