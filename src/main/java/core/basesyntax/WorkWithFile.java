package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {

    public void getStatistic(String fromFileName, String toFileName) {
        int buy = 0;
        int supply = 0;
        File file = new File(fromFileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName, true))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].equals("buy")) {
                        buy += Integer.parseInt(array[1]);
                    } else if (array[i].equals("supply")) {
                        supply += Integer.parseInt(array[1]);
                    }
                }
            }

            int result = supply - buy;

            bufferedWriter.write("supply" + "," + supply + "\n"
                    + "buy" + "," + buy
                    + "\n" + "result" + "," + result);

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
