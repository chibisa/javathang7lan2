package lesson101;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class fileexample {
    public static void main(String[] args) throws Exception{
        fileexample FileExample = new fileexample();
        String file_path = "E:\\Javacore\\data\\";
        String file_path1="E:\\anhthiennhiendep.jpg";
        File file = new File(file_path);
        if(file.exists() || file.isDirectory()){
            System.out.println(true);
        }else System.out.println(false);
        List<File> list = Arrays.asList(file.listFiles());
       for (File listname:list) {
            System.out.println(listname);
        }
       /* FileInputStream fileInputStream = new FileInputStream(file_path1);
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Javacore\\data\\anhthiennhiendep.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int c;
        while ((c= bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(c);
        }*/
        String[] filterfile = FileExample.Fillerfile(file_path);//lay cac file cos duoi la .txt
        String maxfiles=filterfile[filterfile.length-1];//so luong file co duoi la .txt
        //System.out.println("tong file"+(filterfile.length-1));
        //int maxfile=0;String maxname = null;
     /*   for (int i=0;i<filterfile.length;i++) {
            if(maxfile<filterfile[i].length()){
                maxfile=filterfile[i].length();
                maxname=filterfile[i];
            }
        }*/
        int stt = 0;
        int[] cout = FileExample.countword(filterfile,file_path);
        int maxcount=0;
        for (int j=0;j<cout.length;j++){
            if(cout[j]>maxcount) {
                maxcount=cout[j];
                stt = j;
            }
        }
        System.out.println("File co nhieu ki tu nhat la: "+file_path+filterfile[stt]);
    }
    public int[] countword(String[] filterfile, String file_path) throws Exception {
        int c;int i=0; int count[]= new int[filterfile.length];
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream=null;
        for (String f: filterfile) {
            //System.out.println(f);
            fileInputStream  = new FileInputStream(file_path+f);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            while((c=bufferedInputStream.read())!=-1){
                if(c==32||c==13){
                    count[i]++;
                }
            }
            i++;
        }
        return count;
    }
    public String[] Fillerfile(String file_path)throws Exception{
        File dir = new File(file_path);
        String[] file = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        return file;
    }
}
