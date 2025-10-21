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
/*
    ### Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기

      사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
      사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
      연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
      1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(➕,➖,✖️,➗) 기능을 수행한 후 2) 결과 값을 반환하는
       메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.

      **Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정**
      연산 수행 역할은 Calculator 클래스가 담당
      연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
      소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

      **App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)**
      간접 접근을 통해 필드에 접근하여 **가져올** 수 있도록 구현합니다. (Getter 메서드)
      간접 접근을 통해 필드에 접근하여 **수정할** 수 있도록 구현합니다. (Setter 메서드)
      위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

      Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후
      App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
      키워드 : `컬렉션`
      컬렉션에서 ‘값을 넣고 제거하는 방법을 이해한다.’가 중요합니다!
* */



package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 객체 생성
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        double result = 0;
        double n1 = 0;
        double n2 = 0;
        boolean isValid = false;

        // 실행 문구 출력
        System.out.println("계산기 실행\n아무 키를 입력하면 실행합니다.");
//        System.out.println("언제든 exit 입력시 종료");


        while (true) {
            String str = scanner.nextLine();


            // n1 입력 받기
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            try {
                n1 = scanner.nextDouble();
                isValid = true; // 올바른 값 받으면 탈출
            }
            catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 첫 번째 숫자를 다시 입력하세요.");
                scanner.next(); // 잘못 입력된 값을 버퍼에서 제거
                continue; // 다시 입력 받도록
            }

            // n2 입력 받기
            System.out.print("두 번째 숫자를 입력하세요 : ");
            try {
                n2 = scanner.nextDouble();
                isValid = true; // 올바른 값 받으면 탈출
            }
            catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 두 번재 숫자를 다시 입력하세요");
                scanner.next(); // 잘못 입력된 값을 버퍼에서 제거
                continue; // 다시 입력 받도록
            }

            // 사칙연산 기호 입력 받기
            System.out.print("사칙연산 기호 입력하세요 ( +, -, *, / ) : ");
            char operator = scanner.next().charAt(0);


            // 계산 기능

            // 초기화
            result = 0;

            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("잘못입력하셨습니다. + - * / 중에서 입력하세요.");
                continue;
            }
            else if (operator=='/' && n2 == 0) {
                System.out.println("나눗셈에서 부모에 0이 올 수 없습니다. 다시 입력하세요");
                continue;
            }
//            else {
//                if (operator == '/') {
//                    result = calculator.calculator(n1, n2, operator);
//                }
//            }

            result = calculator.calculator(n1, n2, operator);

            // 결과값 출력
            if (operator == '/') {
                System.out.println("결과 값 : " + result);
            }
            else {
                System.out.println("결과 값 : " + (long)result);
            }


//            System.out.println("저장된 결과값 : " + calculator.removeResult());
            calculator.printResult();   // 저장된 리스트 출력
            calculator.addResult(result);   // 결과 저장


            // 추가진행 중단 선택
            scanner.nextLine();  // 없으면 결과값 출력 후 다시 실행되면서 무한루프 이유는 버퍼가 남아서 자동으로 입력된것으로 넘어가는것으로 추정. 이유는 모르겠음
            System.out.println("추가 계산은 아무 키를 , 종료는 exit 를 입력하세요");
            str = scanner.next();    // nextLine() -> next() 로 수정하면 됨    / 개행때문이라해도 조건이 있는데 왜 넘어가지?
            if (str.equals("exit")) {
                break;
            }
            else {
                continue;
            }

        }

    }
}
