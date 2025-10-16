/*
1. **Lv 1.**
    1. 계산기는 2개의 숫자를 받을 수 있고 사칙연산 될 문자를 받을 수 있다.
    2. 계산기는 exit을 입력할 때까지 계속해서 값을 받고 연산 결과를 반환한다.
2. **Lv 2.**
    1. 계산된 결과 값들을 기록하는 컬렉션을 만든다.
    2. 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.
3. **Lv 3.**
    1. 양의 정수만 받을 수 있었지만, 이제부터는 실수도 받을 수 있게 수정한다.
    2. 결과가 저장되어 있는 컬렉션을 조회하는 기능을 만든다.
    3. 그 때 특정 값보다 큰 결과 값을 출력할 수 있도록 한다.
* */
/*
    ### Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

      **양의 정수(0 포함)를 입력받기**
      Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
      양의 정수는 각각 하나씩 전달 받습니다.
      양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.

      **사칙연산 기호(➕,➖,✖️,➗)를 입력받기**
      Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
      사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)

      **위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기**
      키워드 : `if` `switch`
      사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
      입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (예를 들면 if, switch)
      연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
      ex) “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“

      **반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기**
      키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
      반복문을 사용합니다. (예를 들어, for, while…)
* */

package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기 실행");
//        System.out.println("언제든 exit 입력시 종료");

        while (true) {

            // 정수 입력 받기
            System.out.print("\n" + "첫 번째 숫자를 입력하세요 : ");
            long n1 = scanner.nextInt();

            System.out.print("\n" + "두 번째 숫자를 입력하세요 : ");
            long n2 = scanner.nextInt();

            // 사칙연산 기호 입력 받기
            System.out.print("\n" + "사칙연산 기호 입력하세요 ( +, -, *, / ) : ");
            char operator = scanner.next().charAt(0);


            // 계산
            long result = 0;
            long re = 0;

            switch (operator) {
                case ('+'):
                    result = n1 + n2;
                    break;

                case ('-'):
                    result = n1 - n2;
                    break;

                case ('*'):
                    result = n1 * n2;
                    break;

                case ('/'):
                    if (n2 == 0) {
                        System.out.println("나눗셈 연산에서 부모에 0이 올수 없습니다." + "\n");
                    }
                    else {
                        result = (n1 / n2);
                        re = (n1 % n2);
                        break;
                    }
            }

            // 결과값 출력
            if (operator == '/')
            {
            System.out.println("결과 값 : " + result + "." + re + "\n");
            }
            else {
                System.out.println("결과 값 : " + result + "\n");
            }


            // 추가진행 중단 선택
            scanner.nextLine();
            System.out.println("추가 계산은 아무 키를 , 종료는 exit 를 입력하세요" + "\n");
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                break;
            }
            else {
                continue;
            }
        }
    }
}
