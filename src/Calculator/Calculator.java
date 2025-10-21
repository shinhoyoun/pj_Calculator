/*
    ### Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기

      사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
      사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
      연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
      1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(➕,➖,✖️,➗) 기능을 수행한 후
      2) 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.

      **Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정**
      연산 수행 역할은 Calculator 클래스가 담당
      연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
      소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

      **App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)**
      간접 접근을 통해 필드에 접근하여 **가져올** 수 있도록 구현합니다. (Getter 메서드)
      간접 접근을 통해 필드에 접근하여 **수정할** 수 있도록 구현합니다. (Setter 메서드)
      위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

      Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
      키워드 : `컬렉션`
      컬렉션에서 ‘값을 넣고 제거하는 방법을 이해한다.’가 중요합니다!
* */


package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final int MAX_SIZE = 10;

    // 리스트 생성
    private static List<Double> resultList = new ArrayList<>();

    double result;

    // getter, setter 생성+기능

    public List<Double> getResultList() {
        return new ArrayList<>(resultList);
    }

    // 저장 결과 모두 출력
    public void printResult() {

//        if (resultList.isEmpty()) {
//            System.out.println("저장된 계산 결과가 없습니다");
//        } else {
//            System.out.println("현재 저장된 결과 목록 (" + resultList.size() + "개): " + resultList);
//        }

        if ( resultList.isEmpty() ) {
            System.out.println(" 저장된 계산 결과가 없습니다.");
        } else {
            System.out.println("저장된 계산 결과 목록 : " + resultList.size() + "개 : ");
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println((i + 1) + ". " + resultList.get(i));
            }

        }
    }

    // 결과 리스트에 자동 추가 (10개 초과시 자동 삭제)
    public void addResult(double result) {
//        resultList.add(result);
        if (resultList.size() >= MAX_SIZE) {
            double removed = resultList.remove(0);  // 가장 오래된 결과값 삭제
            System.out.println("10개 초과로 가장 오래된 결과 (" + removed + ") 가 삭제되었습니다.");
        }
        resultList.add(result);
    }


    // 특정 결과 수동 삭제
    public void deleteResult(int index) {
        if (index < 1 || index > resultList.size()) {
            System.out.println("잘못된 인덱스입니다.");
        } else {
            double removed = resultList.remove(index - 1);
            System.out.println("삭제된 결과: " + removed);
        }
    }


//    public void deleteResult(double scanner) {
////        resultList.remove(0);
//
//        if (!resultList.isEmpty()) {    // 리스트가 비어 있지 않은 경우
//            System.out.println("오래된 저장결과를 삭제하시겠습니까?  (remove 입력시 삭제)");
//
//            if (remove.equalsIgnoreCase("remove")) {
//                resultList.remove(0); // 첫 번째 요소 삭제
//                System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
//            } else {
//                System.out.println("삭제가 취소되었습니다.");
//            }
//        } else {
//            System.out.println("삭제할 결과가 없습니다.");
//        }
//    }


    /**
     * @param n1       : 첫 번째 입력값
     * @param n2       : 두 번째 입력값
     * @param operator : 사칙연산 기호
     * @return : 결과값
     */
    public double calculator(double n1, double n2, char operator) {

        // 생성
        result = 0;

        // 계산
        switch (operator) {
            case ('+'): // 덧셈
                result = n1 + n2;
                break;

            case ('-'): // 뺄셈
                result = n1 - n2;
                break;

            case ('*'): // 곱셈
                result = n1 * n2;
                break;

            case ('/'): // 나눗셈
                result = n1 / n2;
                break;
        }

        // 계산 결과 저장
//        addResult(result);

        // 반환
        return result;

    }


// calculator 에서 계산된 re값도 main에 가져와서 출력

// main에서 계산 돌릴 때 try-catch를 사용할려고 했는데 이때 각 조건마다 다 붙여서 넣어줘야 하는지
// 강의에서는 다른 클래스에서 사용해서 상속받을 경우로 나옴


}
