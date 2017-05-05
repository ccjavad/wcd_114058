package test;

enum MyEnum { A, B, C }
@interface MyAnn {
    int x();
}

/*********************/
@interface Ann03 {
    // primitive:
    int i1();
    
    //Referenz-Typen:
    String s1();
    Class<?> c1();
    
    MyEnum e1();
    MyAnn a1();
    
    //Arrays:
    int[] aInt();
    String[] aStr0();
    String[] aStr1();
    String[] aStr2();
    
    Class<?>[] aClass();
    
    MyEnum[] aEnum();
    
    MyAnn[] aAnn();
}

/*********************/
@Ann03(
   i1 = 4,
   s1 = "Hallo",
   c1 = Integer.class,
   e1 = MyEnum.A,
   a1 = @MyAnn(x=22),
   
   aInt = { 1, 2, 3 },
   aStr0 = {},
   aStr1 = "das einzige Element im String-Array",
   aStr2 = { "das einzige Element im String-Array" },
   
   aClass = { String.class, },
   
   aEnum = { MyEnum.B, MyEnum.C },
   
   aAnn = { @MyAnn(x=1), @MyAnn(x=33) }
)
public class B03_Typen_der_Attribute {

}
