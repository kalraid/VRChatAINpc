# VRChatAINpc
====================================

## AI can play to VRChat
------------------------------------

### README.md 용 마크다운 문법
1. https://github.com/sejong-interface/Interface_Manual/wiki/Git-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0%233-README.md-%ED%8C%8C%EC%9D%BC-%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0!
2. https://heropy.blog/2017/09/30/markdown/
3. https://gist.github.com/ihoneymon/652be052a0727ad59601


***

## 프로젝트 설명 
-------------------------------------

### VRChat를 AI가 자동으로 즐길수 있게 만들고자 시작한 프로젝트 / 2020-03-30 시작
### 한 / 영 / 일 / 중 번역, 문장분석, 단어분석 및 대화, 화제 제시, 다중언어환경 분석, 다화자 분석 등의 사고적 AI 환경과
### 이동, 손짓, 발짓, 표정, 표현 등 행동적 AI 환경을 동시에 구현 목표

***

## 프로젝트 구조
-------------------------------------


#### 파이썬 : 디장고 - 대화 분석용 모듈 + 행동 명령용 모듈
#### 자바 : 스프링부트 - 화면 채증 + vrchat 접속 + 명령에 따른 행동 구현
#### 디장고 서버 2, 스프링 부트 2 구성

#### 각 서버간 데이터 전송은 메세지큐 방식을 도입(https://www.smoh.kr/289) - 스프링 자바(메인) - 메세지큐 - 파이썬 서버 두개

#### DB는 마리아 SQL로 자바 메인, 파이썬 서버 마다 하나씩

### * 스프링 부트기반
#### 자바 메인서버 <- AI 컨트롤용 페이지 + VRChat 접속 + 각 서버 상태 확인(가능한 가볍게)
##### * spring boot devtools
##### * lombok
##### * spring configuration prc
##### * spring for rabbitmq
##### * spring boot actuator(https://supawer0728.github.io/2018/05/12/spring-actuator/)
##### * mybatis framework(https://4urdev.tistory.com/46)(maria db 적용 필요)
##### * spring REST Docs
##### * thymeleaf(https://eblo.tistory.com/54)

#### 자바 바디서버 <- AI 행동명령 및 언어신경과 행동신경 연결 및 해당 행동내용, 전달내용 메인서버에 로그로 받고 페이지에 볼수있게 전달


## 플라스크 기반 (http://blog.naver.com/PostView.nhn?blogId=alice_k106&logNo=221375101934&from=search&redirect=Log&widgetTypeCall=true&directAccess=false)

#### 언어신경 서버(보고 들은내용으로 뭘말할지 정리) <- 바디서버를 통해 받은 정보를 토대로 행해야할 행동 분석후 바디서버로 전달
#### 청각신경 서버(듣고 들은내용 정리) <- 청각에 따른 정보 획득 후 바디서버로 전달
#### 시각신경 서버(보고 본내용 정리) <- 시각에 따른 정보 획득 후 바디서버로 전달
#### 행동신경 서버(보고 들은내용으로 뭐할지 정리) <- 바디서버를 통해 받은 정보를 토대로 행해야할 행동 분석후 바디서버로 전달
#### 감정 서버(바디서버를 통해서 기존에 정리한 내용을 받고 기존감정 + 정리한 내용을 통해 생긴 감정을 정리해서 바디서버로 재전달)

## 최종 구조

- 시각 신경 서버 + 청각 신경 서버

- 바디 서버 에서 데이터 전달

- 감정 서버 

- 바디 서버 에서 데이터 전달 

- 행동 신경 서버 + 언어 신경 서버

- 바디 서버에서 VRChat에 행동 입력


***

## 프로젝트 계획  및 구현 순서
-------------------------------------------

> 1. 기초시작 - 사람에 의한 원격제어
  >> 1. 로깅용 관리자 페이지 - 기본 명령어, 대화 전달, 대화 txt 로깅 등이 들어갈 페이지
  >> 2. VRChat 접속
  >> 3. 서버 이동 구현
  >> 4. 기본 움직임 구현
  >> 5. 표정 변화 구현
  >> 6. 손짓 발짓 구현 
  
> 2. AI 모듈 작업 베이스 시작
  >> 1. (사진인식)화면 인식후 아이디 출력 -> 관리자 페이지에 현재 보이는 아이디 리스트 출력
  >> 2. 화자 분석 -> 말하는 사람의 목소리 또는 위치 등을 통해서 현재 아이디 리스트에서 마이크 표시
 
> 3. 따라하기
  >> 1. 현재 말하는 화자의 행동을 보고 어떤 행동인지 구하기
  >> 2. 위의 행동 따라하기
  >> 3. 위의 행동과 동시에 어떤행동인지 언어적 표현
   
> 4. 말하기
  >> 1. 상대방 대사 그대로 따라하기
  >> 2. 상대방이 말한 행동 과 표정 하기
  >> 3. 대화중에서 상대 감정 분석 
  >> 4. 내 감정 분석
  >> 5. 내감정에 맞는 행동하기

> 5. 다중 화자 처리

> 6. 다 언어 처리

***

## 참고 
----------------

#### VRChat APi 사이트  
#### - https://vrchatapi.github.io/#/  
#### - https://github.com/VRChatAPI/vrchatapi.github.io  

#### 패턴 관련 사이트 
#### - https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195#2707195 


- https://pypi.org/project/py-eureka-client/#files
- https://niceman.tistory.com/101
- https://mainia.tistory.com/4533

* 플라스크
- https://niceman.tistory.com/151 (플라스크 예제)
- https://hamait.tistory.com/864 (플라스크 예제)
- https://www.finterstella.com/8 (플라스크 프로젝트 구조 예제)

* 스프링 리액티브 웹
- http://wiki.sys4u.co.kr/display/SOWIKI/Design+Patterns
- https://parkcheolu.tistory.com/134
- https://brunch.co.kr/@springboot/96

----------------------

## 고민해야될 사항


----------------------

## 고민 종료
#### 디장고 서버 대신 스프링부트로 만들어 놓고 자이썬으로 .py를 직접 실행시키는 방법이 더 낫지않을까? (자이썬 활용)
#### 마찬가지로 C#를 직접 쓰지 말고 해당 api 호출하는부분 및 데이터 받는부분만 대신 사용시키면?  -> 스프링에서 파이썬을 직접 사용
1. http://pds10.egloos.com/pds/200907/25/69/Call_CSharp_Code_in_Java(JNI).pdf
2. http://sjava.net/2010/04/%EC%9E%90%EB%B0%94-cc-c-%EB%A9%94%EC%84%9C%EB%93%9C-%ED%98%B8%EC%B6%9C-%EC%A7%80%EC%9B%90-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC/
3. http://egloos.zum.com/js7309/v/11155038
4. http://blog.naver.com/estern/220705777919
5. https://jythonbook-ko.readthedocs.io/en/latest/JythonAndJavaIntegration.html



<img src="https://user-images.githubusercontent.com/39545613/79848782-7f5cb200-83fc-11ea-8f16-e236a00e049c.png" width="90%"></img>
