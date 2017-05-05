package test;

/**********************************/
@interface Ann05_a {
    int value();
}

@Ann05_a(value = 22)
class MyClass05_a_1{}

@Ann05_a(22)                //vereinfacht value = 22
class MyClass05_a_2{}


/**********************************/
@interface Ann05_b {
    int value();
    int x();
}

//@Ann05_b(22, x=3)         //geht leider nicht
@Ann05_b(value = 0, x = 22)
class MyClass05_b_1{}

/**********************************/
@interface Ann05_c {
    int value();
    int x() default 0;
}

@Ann05_c(value = 13, x = 22)
class MyClass05_c_1{}

@Ann05_c(13)            //vereinfacht, value = 13, x = 0
class MyClass05_c_2{}

public class B05_value {

}
