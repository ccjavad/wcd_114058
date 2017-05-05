package test;

/*********************************/
@interface Ann04_a {
    int x();
}

@Ann04_a(x=1)
class MyClass04_a {}


/*********************************/
@interface Ann04_b {
    int x() default 0;
    
    String[] sArr() default {};
}

@Ann04_b(x = 0, sArr = {"a", "b"} )
class MyClass04_b_1{}

@Ann04_b()                  //vereinfacht, x = 0 und sArr = {}
class MyClass04_b_2{}

@Ann04_b                    //vereinfacht, x = 0 und sArr = {}
class MyClass04_b_3{}

@Ann04_b(sArr = {"a", "b"} )//vereinfacht, x = 0
class MyClass04_b_4{}


public class B04_default {

}
