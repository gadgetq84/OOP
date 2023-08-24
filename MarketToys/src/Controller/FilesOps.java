package Controller;

import java.io.FileWriter;
import java.util.List;

import Model.Toy;

public class FilesOps {
    private String fileName;
    public FilesOps(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void saveToyToFile(Toy toy)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {

                fw.write("Название: "+toy.getName()+" вес:"+toy.getWeight()+" id:"+toy.getId());
                fw.append('\n');

            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
