/*
 * 
 */
package collectionsort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zhangshuting
 */
class Member {
    private String name;
    private Date birthday;
    private String phone;
    private String address;
    private int deposit;
    public Member(String n,Date b,String p,String a,int d){
        name=n;
        birthday=b;
        phone=p;
        address=a;
        deposit=d;
    }
    public String getName(){
        return name;
    }
    public Date getBirth(){
        return birthday;
    }
    public int getDeposit(){
        return deposit;
    }
    @Override
    public String toString(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return String.format("姓名:%-10s 生日:%-12s 電話:%-12s 住址:%-8s 存款:%-10d",name,df.format(birthday),phone,address,deposit);
    }
}

