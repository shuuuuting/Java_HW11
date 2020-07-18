/*
 * B10433006_張舒婷
 */
package collectionsort;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhangshuting
 */
class NameCompare implements Comparator<Member>{
    @Override
    public int compare(Member x,Member y){
         return x.getName().compareTo(y.getName());
        }
    }
class BirthCompare implements Comparator<Member>{
    @Override
    public int compare(Member x,Member y){
         return x.getBirth().compareTo(y.getBirth());
        }
    }
class DepositCompare implements Comparator<Member>{
    @Override
    public int compare(Member x,Member y){
        return x.getDeposit()-y.getDeposit();
        }
    }
public class CollectionSort {

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        readandwriteWithEncoding("member.txt","UTF-8");
    }
    private static void readandwriteWithEncoding(String filename,String encoding) throws FileNotFoundException, IOException, ParseException{
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename),encoding));
            List<Member>members=new LinkedList();
            while(input.ready()){
                String line = input.readLine();
                if(line==null) break;
                String tokens[] = line.split("\t");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Member member = new Member(tokens[0],formatter.parse(tokens[1]),tokens[3],tokens[2],Integer.parseInt(tokens[4]));
                members.add(member);
            }
            Collections.sort(members,new NameCompare());
            System.out.println("===============================Sort By Name================================");
            for(Member member : members) System.out.println(member);
            Collections.sort(members,new BirthCompare());
            System.out.println("==============================Sort By Birthday==============================");
            for(Member member : members) System.out.println(member);
            Collections.sort(members,new DepositCompare());
            System.out.println("==============================Sort By Deposit==============================");
            for(Member member : members) System.out.println(member);
            input.close();
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CollectionSort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
