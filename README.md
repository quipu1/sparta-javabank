# README



### 📌 프로젝트 소개

> 22.11.24 - 22.11.29

Java를 통해 은행 계좌 시스템을 구현합니다.

- 계좌 생성
  => 계좌번호 정규표현식, 계좌번호 중복 확인 후 생성

- 계좌 관리

  => 계좌 찾기 : 계좌번호 or 소유자 명(동명이인일 경우 모두 출력)으로 계좌 출력

  => 계좌 수정 : 비밀번호 수정만 가능

  => 계좌 삭제

- 계좌 조회
  => 잔고 확인 : 소유주만 확인 가능

  => 입/출금 : 입출금 시, 거래내역 추가

- 모든 계좌 조회

  => 비밀번호 확인 후, 관리자일 경우 해당 은행의 계좌 목록 모두 조회

- 거래 내역 생성/조회
  => 잔고 변화가 있을 때, 거래 내역 생성

  

  <br>

### ✨ 개발 인원 및 역할

5명

성루비 : 팀장, 프로젝트 실행(main), UI, 계좌 생성 메서드, 계좌 찾기 메서드

김송미 : 팀원, Bank 클래스

김시원 : 팀원, TransactionInformation 클래스, TransactionalInformationList 클래스

김태웅 : 팀원, Account 클래스, 전체 계좌 조회 메서드

최승호 : 팀원, 프로젝트 실행(main), UI, 계좌 삭제 메서드

<br>

### 📌 사용된 기술

프론트, 백, DB : Java

<br>

### 📌 프레임워크

```
=====================================================
1 계좌 생성 | 2 계좌 조회(내 계좌 찾기) | 3 계좌 관리(잔고 조회, 비밀번호 수정, 계좌 삭제, 거래내역 조회) | 4 입/출금 | 5 관리자 | q 프로그램 종료
=====================================================
입력 > 1
계좌 번호: 
이름: 
비밀번호: 
계좌가 생성되었습니다.
=====================================================
1 계좌 생성 | 2 계좌 조회(내 계좌 찾기) | 3 계좌 관리(잔고 조회, 비밀번호 수정, 계좌 삭제, 거래내역 조회) | 4 입/출금 | 5 관리자 | q 프로그램 종료
=====================================================
입력 > 2

=====================================================
1 계좌번호로 찾기 | 2 소유자명으로 찾기 
=====================================================
입력 > 1
계좌 번호: 
성루비 111-1111 or 계좌가 존재하지 않습니다.

=====================================================
1 계좌 생성 | 2 계좌 조회(내 계좌 찾기) | 3 계좌 관리(잔고 조회, 비밀번호 수정, 계좌 삭제, 거래내역 조회)  | 4 입/출금 | 5 관리자 | 6 프로그램 종료
=====================================================
입력 > 2
=====================================================
1 계좌번호로 찾기 | 2 소유자명으로 찾기 
=====================================================
입력 > 2
소유자 명: 
성루비 111-1111 
성루비 222-2222
성루비 333-3333 or 계좌가 존재하지 않습니다.

=====================================================
...
```

<br>

### 📌 Field

|          Bank Field          |            Type             |
| :--------------------------: | :-------------------------: |
|          은행 이름           |       String bankName       |
|       관리자 비밀번호        |       String password       |
| 해당 은행에 등록된 계좌 목록 | List<Account> AccountsAll[] |

| Account Field |       Type        |
| :-----------: | :---------------: |
|   은행 이름   |    String bank    |
|   계좌번호    | String accountNum |
|   소유주 명   |   String owner    |
|   비밀번호    |   int password    |
|     잔액      |    int balance    |

| TransactionalInformationList Field |                      Type                       |
| :--------------------------------: | :---------------------------------------------: |
|         전체 거래내역 목록         | List<TransactionalInformation> TransactionAll[] |

| TransactionInformation Field  |         Type          |
| :---------------------------: | :-------------------: |
|           거래 일자           |      String date      |
|           거래 시간           |      String time      |
|           계좌번호            |   String accountNum   |
| 입/출금 여부 (1:입금, 2:출금) |   int availability    |
|           거래 금액           | int transactionAmount |
|            은행 명            |      String bank      |

<br>

### 📌 Youtube 시연 영상

https://www.youtube.com/watch?v=7NnJDBWjNG4
