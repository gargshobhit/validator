package com.cme.validator.repositories;

import java.io.*;

public class UserInput {

    public static void save(com.cme.validator.entities.UserInput userInput) {
        Writer output = null;

        try {
            StringBuilder builder = new StringBuilder();
            File file = new File("UserInput.csv");
            if (!file.exists())
                builder.append("Id,UserId,Value \n");

            output = new BufferedWriter(new FileWriter(file, true));

            builder.append(userInput.getId() + 1 +",");
            builder.append(userInput.getUserId() +",");
            builder.append(userInput.getValue());
            builder.append('\n');
            output.write(builder.toString());
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
