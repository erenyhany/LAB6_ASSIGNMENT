import java.util.Collections;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        try{
            String fileName=args[0];
            if(!fileName.endsWith(".arxml"))
            {throw new NotValidExtension("Invalid file extension");}

            File file=new File(fileName);
            FileInputStream f=new FileInputStream(file);
            int d;
            StringBuilder s=new StringBuilder();
            if ( !((file).length () > 0)){
                throw new EmptyFileException("Your file is empty");
            }

            while((d=f.read())!=-1){
                s.append((char)d);

            }
            String data=s.toString();
            Scanner n=new Scanner(data);

            ArrayList<Cont> cont=new ArrayList<>();
            while(n.hasNextLine())
            {
                String line=n.nextLine();
                if(line.contains("<CONTAINER"))
                {
                    String UUID=line.substring(line.indexOf("=")+1, line.indexOf(">"));
                    String SHORTNAME=n.nextLine();
                    String shortname=SHORTNAME.substring(SHORTNAME.indexOf(">")+1,SHORTNAME.indexOf("</") );
                    String LONGNAME=n.nextLine();
                    String longname=LONGNAME.substring(LONGNAME.indexOf(">")+1,LONGNAME.indexOf("</") );
                    Cont con=new Cont();
                    con.setUUID(UUID);
                    con.setSHORTNAME(shortname);
                    con.setLONGNAME(longname);
                    cont.add(con);


                }
            }

            Collections.sort(cont);
            String out=fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
            FileOutputStream o=new FileOutputStream(out);
            o.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            o.write("<AUTOSAR>\n".getBytes());
            for(int i=0;i<cont.size();i++){
                o.write(cont.get(i).toString().getBytes());

            }
            o.write("</AUTOSAR>\n".getBytes());
            o.close();


        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(NotValidExtension e){
            System.out.println(e.getMessage());
        }
        catch(EmptyFileException e){
            System.out.println(e.getMessage());
        }


    }
}
