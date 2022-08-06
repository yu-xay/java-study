
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@interface TYPE {
}

@Target(ElementType.FIELD)
@interface FIELD {

}

@Target(ElementType.METHOD)
@interface METHOD {
}

@Target(ElementType.PARAMETER)
@interface PARAMETER {
}

@Target(ElementType.CONSTRUCTOR)
@interface CONSTRUCTOR {
}

@Target(ElementType.LOCAL_VARIABLE)
@interface LOCAL_VARIABLE {
}

@Target(ElementType.ANNOTATION_TYPE)
@interface ANNOTATION_TYPE {
}

@Target(ElementType.PACKAGE)
@interface PACKAGE {
}

@Target(ElementType.TYPE_PARAMETER)
@interface TYPE_PARAMETER {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface TYPE_USE {
}

@Inherited
@interface Inherited {

}


//////////// ”¶”√ ////////////
@TYPE
interface TYPE1 {
}

@TYPE
enum TYPE3 {A}

@TYPE
class TYPE2<@TYPE_PARAMETER E> {
    @FIELD
    @Inherited
    @TYPE_USE
    public String s;

    @TYPE_USE
    public String ss;

    @CONSTRUCTOR
    public TYPE2() {
    }

    @METHOD
    public void init(@PARAMETER String s) {
        @LOCAL_VARIABLE String a = "1";
    }
}
@interface Role {
    String roleName();
}
 @interface Roles {
    Role[] value();
}
