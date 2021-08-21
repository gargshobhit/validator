package com.cme.validator.repositories;

import java.io.*;

public class UserDetails {

    public static void save(com.cme.validator.entities.UserDetails userDetails) {

        Writer output = null;
        try {
            StringBuilder builder = new StringBuilder();
            File file = new File("UserDetails.csv");
            if (!file.exists())
                builder.append("Id,UserName \n");

            output = new BufferedWriter(new FileWriter(file, true));

            builder.append(userDetails.getId() + 1 + ",");
            builder.append(userDetails.getUserName());
            builder.append('\n');
            output.write(builder.toString());
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userDetails.getUserInput().get(0).setUserId(userDetails.getId() + 1);
        UserInput.save(userDetails.getUserInput().get(0));
    }
}
