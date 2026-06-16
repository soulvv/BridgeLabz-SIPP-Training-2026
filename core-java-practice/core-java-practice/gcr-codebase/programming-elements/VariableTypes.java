public class VariableTypes{

    static int x; //static variable
    int y; //instance variable


    static void m1(){ //static method
        System.out.println("m1");
        System.out.println(x);
    }

    void m2(){ //non-static method
        System.out.println("m2");
        System.out.println(x);
    }

    public static void main(String[] args){
        int x=10; //local variable
        int e=45; //local variable

        System.out.println(x);
        VariableTypes obj=new VariableTypes(); //objects creation
        System.out.println(obj.y);

        m1(); //static method calling
        obj.m2(); //non-static method calling
    }
}