package lib.javaLang;

public class JavaLang {
    /* 클래스 정보를 출력하는 3가지 방법
    1. getClass
    2. literal
    3. getName
        - 리소스 사용 효율이 높음
        - 동적 로딩
            - 
    * */
    public static void main(String[] args) {

        String str = "abc";
        Class <? extends String> cstr1 = str.getClass();
        System.out.println(cstr1);

        Class <? extends String> cstr2 = String.class;
        System.out.println(cstr2);

        try{
        Class <?> cstr3 = Class.forName("java.lang.String");
        System.out.println(cstr3);
        }catch (ClassNotFoundException e){}
    }
}
