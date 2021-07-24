package workwithfile;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Lorem Ipsum - это текст-\"рыба\", \n"
                + "часто используемый в печати и вэб-дизайне. \n"
                + "Lorem Ipsum является стандартной \"рыбой\" \n"
                + "для текстов на латинице с начала XVI века. \n"
                + "В то время некий безымянный печатник создал \n"
                + "большую коллекцию...";
        String s = "hello everybody";

        try (FileWriter writer = new FileWriter("test2.txt", true)) {
            writer.write(rubai);
            writer.write(s);
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
