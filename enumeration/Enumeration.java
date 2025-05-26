package enumeration;
/*상수 선언 방법
    1. final static
    2. interface
    3. 자체 클래스
    - 자체클래스 Primitive Type이 아닌 Reference Type으로 상수를 다룸
*/

// 2. interface
// interface의 특징 매개변수는 final static 생략가능
interface EnumInterface {
    int MONDAY = 1;
    int TUESDAY = 2;
    int WEDNESDAT = 3;
    int THURSDAY = 4;
    int FRIDAY = 5;
    int SATURDAY = 6;
    int SUNDAY = 7;
}

// 3. 자체클래스
//객체의 비교임으로 값을 통한 비교가 어려워짐
class Day{
    public final static Day MONDAY = new Day();
    public final static Day TUESDAY = new Day();
    public final static Day WEDNESDAY = new Day();
}
public class Enumeration {

    private final static int MONDAY = 1;
    private final static int TUESDAY = 2;
    private final static int WEDNESDAT = 3;
    private final static int THURSDAY = 4;
    private final static int FRIDAY = 5;
    private final static int SATURDAY = 6;
    private final static int SUNDAY = 7;

    public static void main(String[] args) {
        // 정수값인 상수의 문제 발생 -> 이를 해결하기 위해 자체 클래스 상수
        if(MONDAY == 1)
        {
            System.out.println("월요일 입니다.");
        }
        // switch문에서 클래스활용이 어려움
        // TODO: 변수명을 가져오는 reflection을 활용해야함
    }
}