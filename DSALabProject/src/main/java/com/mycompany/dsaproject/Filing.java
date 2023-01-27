package com.mycompany.dsaproject;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.PrintWriter;

public class Filing {


    public  void WriteToFile(String[] lines ,String path) throws IOException {
        int lineNumber = 0;
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        for( String line: lines) {
            if(line != null){
                writer.println(line);
                lineNumber++;
            }
        }
        writer.close();
    }
    public  String[] readAllData(String path , int Count){
        File fpath = new File(path);
        String[] array = new String[Count];
        int i = 0;
        try{
            try (BufferedReader reader = new BufferedReader (new FileReader(fpath));){
                String currentLine;
                while((currentLine = reader.readLine()) != null) {
                    array[i] = currentLine;
                    i++;
                }
            }
        } catch (IOException e){

        }
        return array;
    }
    public  int getLineCount(String path){
        File fpath = new File(path);
        int i = 1;
        try{
            try (BufferedReader reader = new BufferedReader (new FileReader(fpath));){
                String currentLine;
                while((currentLine = reader.readLine()) != null) {
                    i++;
                }
            }
        } catch (IOException e){

        }
        return i;
    }


}
