package TestShit;

public class ChildClass  extends AbsClass{

    String fullName = "Alex";

    public void ABC(){
        ChildClass childClass = new ChildClass();
        System.out.println(childClass.fullName);
        System.out.println(childClass.name);
        AbsClass absClass = new AbsClass();
        absClass.ar();
    }
}
