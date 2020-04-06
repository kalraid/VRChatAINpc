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


### 파이썬 : 디장고 - 대화 분석용 모듈 + 행동 명령용 모듈
### 자바 : 스프링부트 - 화면 채증 + vrchat 접속 + 명령에 따른 행동 구현
### 디장고 서버 2, 스프링 부트 1 구성

### 각 서버간 데이터 전송은 메세지큐 방식을 도입(https://www.smoh.kr/289) - 스프링 자바(메인) - 메세지큐 - 파이썬 서버 두개

### DB는 마리아 SQL로 자바 메인, 파이썬 서버 마다 하나씩

### 자바 메인서버
#### * 스프링 부트기반
#### * spring boot devtools
#### * lombok
#### * spring configuration prc
#### * spring for rabbitmq
#### * spring boot actuator(https://supawer0728.github.io/2018/05/12/spring-actuator/)
#### * mybatis framework(https://4urdev.tistory.com/46)(maria db 적용 필요)
#### * spring REST Docs
#### * thymeleaf(https://eblo.tistory.com/54)

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

