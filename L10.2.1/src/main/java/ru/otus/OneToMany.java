package ru.otus;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.h2.tools.Server;

import ru.otus.data.AddressDataSet;
import ru.otus.data.UserDataSet;


public class OneToMany {
    public static void main(String[] args) throws Exception{
        Server.createWebServer("-web","-webAllowOthers","-webPort","8082").start();
        DbService dbService = new DbService();

        String status = dbService.getLocalStatus();
        System.out.println("Status: " + status);

        UserDataSet user1 = new UserDataSet(
                "tully",
                Collections.singletonList(new AddressDataSet("Mira"))
        );

        System.out.println(user1);

        dbService.save(user1);

        List<AddressDataSet> addresses = new ArrayList<>();
        addresses.add(new AddressDataSet("Truda"));
        addresses.add(new AddressDataSet("Moskovskaya"));

        UserDataSet user2 = new UserDataSet(
                "sully",
                addresses
        );

        dbService.save(user2);

        System.out.println("____________________________");

        UserDataSet dataSet = dbService.read(1);
        System.out.println(dataSet);

        dataSet = dbService.readByName("sully");
        System.out.println(dataSet);

        List<UserDataSet> dataSets = dbService.readAll();
        for (UserDataSet userDataSet : dataSets) {
            System.out.println(userDataSet);
        }

        dbService.shutdown();
    }
}
