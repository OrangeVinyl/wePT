# 🏡Team : wePT

<div align="center"><img src="https://github.com/OrangeVinyl/community/assets/155809042/4782d336-dae7-464b-9f9c-c39572ffe349.png" width="500" height="600"></div>


'우리(**we**)'라는 단어 + 아파트를 나타내는 약어인 '**APT**'의 합성어이자,

궁금한 모든 걸 알려주는 chatGPT와 같이, wePT를 사용한다면 아파트에 관한 모든 궁금증을 해결할 수 있다는 의미를 담았습니다.
<br/> <br/> <br/>

### 프로젝트 소개

1. 분류 : 아파트 단지 내 주민들을 위한 **종합적인 모바일 아파트 커뮤니티 플랫폼**
2. 목적 : <br/>
   2 - 1) 주민들 간 소통 강화 및 친목 도모 <br/>
   2 - 2) 아파트 시설 이용 및 관련 정보 검색 시 편의 증진 <br/>
   2 - 3) 아파트 커뮤니티 시설 활성화 <br/>
   2 - 4) 시설 관리 및 공지 간편화 <br/>
   <br/> <br/>

### 개발 기간

* 2024.02.22(목) ~ 2024.03.28(목) <br/> <br/> <br/>

### 회의 진행 기록

| 회차     | 일시         | 목적                                       |
|--------|------------|------------------------------------------|
| 1차 회의  | 2024.02.22 | 주제 조사                                    |
| 2차 회의  | 2024.02.25 | 주제 선정                                    |
| 3차 회의  | 2024.02.26 | 구체화 작업 - 세부 기능 고안 1st                    |
| 4차 회의  | 2024.02.27 | 구체화 작업 - 세부 기능 고안 2nd                    |
| 5차 회의  | 2024.03.03 | 구체화 작업 - 세부 기능 고안 3rd 및 기능 별 담당 파트 선정    |
| 6차 회의  | 2024.03.04 | 구체화 작업 - 세부 기능 고안 4th 및 주제와 기능 간의 관계성 탐구 |
| 7차 회의  | 2024.03.13 | 모델링 및 운영 정책 수립                           |
| 8차 회의  | 2024.03.18 | 운영 정책 수정 및 보완                            |
| 9차 회의  | 2024.03.20 | 개발 과정 중 오류 및 공지사항 공유, 중간 점검              |
| 10차 회의 | 2024.03.25 | 개발 과정 중 오류 사항 공유 및 팀 로고 디자인 선정           |
| 11차 회의 | 2024.03.27 | 최종 점검                                    |

<br/> <br/>

### 팀 소개

<table>
  <tbody>
    <tr>
      <td align="center"><a href=""><img src="" width="200px;" alt=""/><br /><sub><b>신민형</b></sub></a><br /></td>
      <td align="center"><a href=""><img src="" width="200px;" alt=""/><br /><sub><b>전예은</b></sub></a><br /></td>
      <td align="center"><a href=""><img src="https://avatars.githubusercontent.com/u/155809042?v=4" width="200px;" alt=""/><br /><sub><b> 정민지 </b></sub></a><br /></td>
      <td align="center"><a href=""><img src="" width="200px;" alt=""/><br /><sub><b>정현진</b></sub></a><br /></td>
      <td align="center"><a href=""><img src="" width="200px;" alt=""/><br /><sub><b>최수환</b></sub></a><br /></td>
    </tr>
    <tr>
      <td align="center">팀원</td>
<td align="center">팀원</td>
<td align="center">팀원</td>
<td align="center">팀원</td>
<td align="center">팀장</td>
    </tr>
  </tbody>
</table>
<br/><br/>

### ⚙️ 개발 환경

* Version : Java 17
* IDE : IntelliJ | VSCode
* Framework : SpringBoot 3.2.3
* ORM : JPA

### 🛠️ 기술 스택

- Spring Boot
- Spring Data JPA
- DB
    - Mysql
    - H2 (Testcase)
    - Redis (Email Certification)
- LogBack / Slf4j
- Spring Security (JWT Refresh Token, access Token)
- Swagger (API Documentation)

### 📦 디렉토리 구조

```
📦community
 ┣ 📂domain
 ┃ ┣ 📂apartment
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┣ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂auth
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┣ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂facility
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂maintenance
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂matching
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂matchingCategory
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂matchingStatus
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂membership
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┣ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂post
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┗ 📂service
 ┃ ┣ 📂security
 ┃ ┃ ┣ 📂filter
 ┃ ┃ ┣ 📂provider
 ┃ ┗ 📂user
 ┃ ┃ ┣ 📂common
 ┃ ┃ ┣ 📂ctrl
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┣ 📂repository
 ┃ ┃ ┗ 📂service
 ┣ 📂email
 ┃ ┣ 📂controller
 ┃ ┣ 📂dto
 ┃ ┣ 📂service
 ┣ 📂global
 ┃ ┣ 📂annotation
 ┃ ┣ 📂config
 ┃ ┣ 📂handler
 ┃ ┗ 📂util
 ┃ ┃ ┣ 📂api
 ┃ ┃ ┗ 📂const
 ┗ 📜CommunityApplication.java
```

```
📦resources
 ┣ 📂database
 ┃ ┗ 📜data.sql
 ┣ 📂static
 ┣ 📂templates
 ┃ ┗ 📜index.html
 ┣ 📜application.properties
 ┣ 📜jwt.yml
 ┗ 📜logback-spring.xml

```

## 주요 기능

[ 주요 기능 설명 ](https://github.com/beyond-sw-camp/be05-2nd-6team-wePT/wiki/Page-contents)

## 운영 정책

[ 운영 정책 설명 ](https://github.com/beyond-sw-camp/be05-2nd-6team-wePT/wiki/Policy)

## ERD

![apartment_db (2)](https://github.com/OrangeVinyl/community/assets/155809042/8622967c-a5c2-4a42-8ee2-fe8524ef83d1)

## WBS

[ WBS ](https://github.com/beyond-sw-camp/be05-2nd-6team-wePT/wiki/WBS)

## 요구사항 명세서

[ 요구사항 명세서 ](https://github.com/beyond-sw-camp/be05-2nd-6team-wePT/wiki/SRS)

## 테스트 케이스

[ 테스트 케이스 ](https://github.com/beyond-sw-camp/be05-2nd-6team-wePT/wiki/Test-case)

