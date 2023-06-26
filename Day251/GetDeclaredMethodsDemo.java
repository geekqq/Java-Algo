package Day251;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetDeclaredMethodsDemo {
    public static void main(String[] args) {
        Class stu = Student.class;
        Method[] methods = stu.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }
}

class Student{

    public void ahqym(){}
    public void amftc(){}
    public void anotherfunction(){}
    public void atcks(){}
    public void bwkbd(){}
    public void cfwyc(){}
    public void cmkxa(){}
    public void dnpym(){}
    public void dnqvo(){}
    public void dvvwq(){}
    public void ehjdm(){}
    public void elyed(){}
    public void fmyce(){}
    public void getEmail(){}
    public void getId(){}
    public void getName(){}
    public void ghtlj(){}
    public void hluvb(){}
    public void isqdf(){}
    public void iwhtf(){}
    public void jmopy(){}
    public void jnskt(){}
    public void kbjlt(){}
    public void kgwku(){}
    public void khuag(){}
    public void levtp(){}
    public void mcgme(){}
    public void migyc(){}
    public void moebl(){}
    public void nixhb(){}
    public void odyqp(){}
    public void ogvdl(){}
    public void ormim(){}
    public void piwro(){}
    public void plaob(){}
    public void pnruo(){}
    public void pqfct(){}
    public void ptrup(){}
    public void pvgyp(){}
    public void qthde(){}
    public void rmjig(){}
    public void setEmail(){}
    public void setId(){}
    public void setName(){}
    public void sumvl(){}
    public void tkbpp(){}
    public void tntpj(){}
    public void toxdp(){}
    public void twyfa(){}
    public void uccfq(){}
    public void ujxei(){}
    public void vhxoi(){}
    public void viwuu(){}
    public void viyog(){}
    public void whjtj(){}
    public void ytijy(){}

}