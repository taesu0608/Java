import java.util.List;
import java.util.ArrayList;
/*
* Iterator 반복자
* - Collection Framework의 요소를 읽어오는 방식을 표준화 위한 인터페이스
* - Collection의 하위 컬렉션들이 소유
*       - 하위 Collection들이 Iterator 타입의 객체 반환으로 구현되어 있음
* - 주로 읽기 전용으로 사용
*
* Iterator의 주요 멤버
* 1. boolean hasNext()
* 2. T next()
* 3. remove()
*
*
* */

//List의 반복을 통한 일기 방식
public class Iterator01 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("사과");
        list.add("바나나");
        list.add("포도");
        list.add("파인애플");
        list.add("복숭아");
    }

    void printList01(List list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    void printList02(List<String> list)
    {
        for (String str: list) {
            System.out.println(str);
        }
    }

    void printList03(List list){}
}
