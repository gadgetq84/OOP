package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class ModelFile  implements iGetModel {
    private String fileName;

    public ModelFile(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Toy> getAllToys() {
        List<Toy> toys  = new ArrayList<Toy>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Toy itm = new Toy(param[1], Integer.parseInt(param[2]));
                toys.add(itm);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return toys;
    }

    public void saveAllToyToFile(List<Toy> ty)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Toy itm : ty)
            {
                fw.write(itm.getName()+" "+itm.getWeight()+" "+itm.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSelToy(Toy std) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSelStud'");
    }

    @Override
    public List<Toy> getFoundToyByName(String stdName) {
        List<Toy> result = this.getAllToys().stream().filter(item -> item.getName().equals(stdName))
        .collect(Collectors.toList());
        return result;
        
    }

    @Override
    public List<Toy> getFoundToyById(int id) {
        final List<Toy> result = this.getAllToys().stream().filter(item -> Integer.valueOf(item.getId()).equals(id))
        .collect(Collectors.toList());
        return result;
    }

    @Override
    public void addNewToy(Toy newtoy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewToy'");
    }


}
