# Gundamdex

# 목적

- 건담의 정보(이름, 형식 번호, 크기, 시리즈, 외형 등)을 보여주고 찾아볼 수 있는 정보 가이드를 만들기 위함
- 안드로이드 앱 개발 실력 향상을 위함

# 사용할 기술

- Android
- Jetpack Compose
- ViewModel
- Coroutine
- Retrofit
- Kotlinx Serialization
- Coil
- Compose Navigation
- Kotlin Flow

# 데이터는 어떻게 가져올 것인가?(Supabase)

## Firebase VS Supabase

이 중 Supabase를 사용해보기로 했다.

## Firebase를 사용하지 않는 이유

Firebase는 실시간 데이터 동기화가 매우 강력하고, 오프라인 캐싱을 SDK 차원에서 알아서 처리해주지만, SDK가 너무 많은 것을 처리해주기 때문에, 오히려 안드로이드의
네트워크 통신을 연습할 기회가 없어진다.

## Supabase의 장점

관계형 데이터베이스인 PostgreSQL을 기반으로 동작한다.

- 특징 : 데이터베이스 테이블을 시각적으로 생성하기만 하면, 즉시 그에 맞는 REST API 엔드포인트를 자동으로 생성해준다.

- 장점 : 관계형 DB의 장점을 그대로 가져가면서도, 서버 코드를 작성할 필요가 없다.

## Supabase를 선택한 이유

사실 위의 장점은 잘 모르겠고… Firebase를 사용해보면서 내가 서버를 연결할 때 무언가 조작한다는 느낌을 받지 못했었다. 딸-깍하면 다 연결되고… 그래서 찾아보니
Supabase는 Retrofit과 Coroutine을 활용해서 통신 레이어를 직접 구축해야 한다고 한다. 통신 연결도 직접 해보고 싶었기에 이번에는 Firebase가 아닌
Supabase를 사용해보고자 했다.

Firebase는 구글이 만든 전용 SDK를 앱이 설치해서 사용해야한다. 이 말은 개발자가 HTTP 통신 코드를 작성하는 것이 아니라 Firebase가 제공하는 내부 함수가 알아서
처리해준다는 의미다.

Supabase는 오픈소스 관계형 데이터베이스를 기반으로 한다. 데이터베이스는 보통 보안상 모바일 앱이 직접 접속하면 안되기 떄문에, 중간에 API 서버가 있어야 한다.
Supabase는 이 문제를 PostgREST라는 기술로 해결한다.

Supabase에서 테이블을 만들면, 서버가 자동으로 그 테이블에 접속할 수 있는 표준 RESTful API 엔드포인트를 만들어준다. 이 주소는 일반적인 웹 서버가 제공하는
API 주소와 완전히 동일한 표준 JSON 응답을 준다.

그렇기에 앱에서는 이 주소가 Supabase인지, 다른 커스텀 서버인지 알 필요 없이 Retrofit이나 Ktor같은 HTTP 클라이언트를 사용해 통신 레이어를 직접 구축하여
데이터를 가져오는 것이 정석이다.

# 직렬화 라이브러리 선택(Kotlinx Serialization)

## Kotlinx Serialization VS Moshi

이 중 Kotlinx Serialization을 사용하기로 결정했다.

## Kotlinx Serialization을 선택한 이유는?

- Kotlinx Serialization은 코틀린 컴파일러 플러그인 방식으로 동작하기 때문에, 서버에서 필수 값이 안 내려왔을 때 코틀린에 정의된 기본값을 채워주거나, Null이 들어오면 컴파일 에러/런타임 에러로 안전하게 잡아줄 수 있다.
- Kotlinx Serialization은 코틀린 전용으로 설계되었기 떄문에 가볍고 빠르며, Kotlin Flow와 Coroutine을 사용하기 떄문에 데이터 파이프라인의 일관성을 맞출 수 있다.
- Compose Navigation 2.8.0 이상부터는 타입 안전성 보장 이동(Type-Safe Navigation)이 공식 지원된다. 이때 화면 간에 복잡한 데이터 객체를 안전하게 넘기기 위한 기술로 Kotlinx Serialization을 강제로 요구한다.

## Moshi를 선택하지 않은 이유는?

Moshi도 리플렉션 대신 Moshi CodeGen을 사용하면 코틀린의 Null Safety도 잘 지켜주고 Retrofit과 궁합도 잘 맞는다. 하지만 Jetpack Compose Navigation의 공식 타입 안전성 기능을 직접적으로 지원하지 않기 때문에 Navigation을 사용할 때 Moshi 뿐만 아니라 Kotlinx Serialization도 넣어줘야 한다.

즉, 직렬화 라이브러리 2개를 중복해서 넣어야 한다는 문제가 발생한다.

# 데이터

- 목 데이터

```json
{
  "gundams": [
    {
      "id": "rx-78-2",
      "modelNumber": "RX-78-2",
      "name": "건담",
      "series": "기동전사 건담",
      "imageUrl": "https://example.com/images/rx-78-2.jpg",
      "era": "U.C. 0079",
      "faction": "지구연방군",
      "pilot": "아무로 레이",
      "description": "지구연방군이 지온 공국군의 자쿠를 참고해 개발한 백병전용 MS. 사이드 7에서 반출될 예정이었으나, 자쿠의 급습으로 인해 그대로 실전에 배치되었다. 사상 최초로 전함급 위력을 자랑하는 빔 병기를 탑재하여 '연방의 하얀 녀석'이라 불렸다.",
      "dimensions": {
        "height": "18.0m",
        "weight": "43.4t"
      },
      "technicalSpecifications": {
        "generatorOutput": "1380 kW",
        "armorMaterial": "루나 티타늄 합금",
        "totalThrust": "55,500 kg",
        "sensorRadius": "5,700 m",
        "crew": "Pilot only (Core Block)"
      },
      "armaments": [
        {
          "name": "60mm 발칸포",
          "details": "x2 (머리 장착)",
          "indicatorColor": "red"
        },
        {
          "name": "빔 사벨",
          "details": "x2 (백팩)",
          "indicatorColor": "blue"
        },
        {
          "name": "빔 라이플",
          "details": "휴대용",
          "indicatorColor": "blue"
        },
        {
          "name": "실드",
          "details": "팔 장착 / 휴대용",
          "indicatorColor": "grey"
        }
      ]
    },
    {
      "id": "ms-06s",
      "modelNumber": "MS-06S",
      "name": "샤아 전용 자쿠 II",
      "series": "기동전사 건담",
      "imageUrl": "https://example.com/images/ms-06s.jpg",
      "era": "U.C. 0079",
      "faction": "지온 공국군",
      "pilot": "샤아 아즈나블",
      "description": "지온 공국군의 지휘관용 MS로, 샤아 아즈나블의 퍼스널 컬러인 붉은색으로 도장되어 있다. 통상형 자쿠 II보다 3배 빠른 속도로 전장을 누벼 '붉은 혜성'이라는 이명을 얻었다.",
      "dimensions": {
        "height": "17.5m",
        "weight": "56.2t"
      },
      "technicalSpecifications": {
        "generatorOutput": "976 kW",
        "armorMaterial": "초경강 합금",
        "totalThrust": "51,600 kg",
        "sensorRadius": "3,200 m"
      },
      "armaments": [
        {
          "name": "120mm 자쿠 머신건",
          "details": "휴대용",
          "indicatorColor": "grey"
        },
        {
          "name": "히트 호크",
          "details": "근접 무기",
          "indicatorColor": "red"
        }
      ]
    }
  ]
}
```

### 데이터 형식

- 📌 기본 속성 (Root Properties)

  목록(List) 화면의 카드 UI와 상세(Detail) 화면의 최상단 요소를 구성하는 데 주로 사용되는 기본 속성입니다.

  | **속성명 (Key)** | **데이터 타입** | **설명** |
  | --- | --- | --- |
  | **`id`** | `String` | 데이터의 고유 식별자입니다. (목록 렌더링 시 `key` 값이나 상세 페이지 라우팅 파라미터로 사용) |
  | **`modelNumber`** | `String` | 기체의 형식 번호입니다. (예: "RX-78-2") |
  | **`name`** | `String` | 기체의 공식 명칭입니다. (예: "건담", "사자비") |
  | **`series`** | `String` | 기체가 등장하는 작품명입니다. (예: "기동전사 건담") |
  | **`imageUrl`** | `String` | 기체 이미지의 URL 경로입니다. |
  | **`era`** | `String` | 작품 속 연호 및 연도입니다. (예: "U.C. 0079") |
  | **`faction`** | `String` | `null` | 기체의 소속 세력명입니다. (예: "지구연방군") |
  | **`pilot`** | `String` | `null` | 기체에 탑승하는 주요 파일럿의 이름입니다. |
  | **`description`** | `String` | `null` | 기체에 대한 상세한 설명 텍스트입니다. |
- 📏 제원 및 스펙 속성 (Nested Objects)

  상세 화면의 세부 정보 영역을 구성하는 객체(Object) 형태의 속성들입니다. 데이터가 없는 기체를 대비해 상위 속성이 `null`일 수 있습니다.

    1. `dimensions` (크기 및 중량)

  | **속성명 (Key)** | **데이터 타입** | **설명** |
  | --- | --- | --- |
  | **`height`** | `String` | 기체의 전고(높이)입니다. (예: "18.0m") |
  | **`weight`** | `String` | 기체의 본체 중량입니다. (예: "43.4t") |

    2. `technicalSpecifications` (기술 사양)

  | **속성명 (Key)** | **데이터 타입** | **설명** |
  | --- | --- | --- |
  | **`generatorOutput`** | `String` | 제네레이터 출력량입니다. (예: "1380 kW") |
  | **`armorMaterial`** | `String` | 장갑 재질입니다. (예: "루나 티타늄 합금") |
  | **`totalThrust`** | `String` | 총 추력입니다. (예: "55,500 kg") |
  | **`sensorRadius`** | `String` | 센서 유효 반경입니다. (예: "5,700 m") |
  | **`crew`** | `String` | 탑승 인원 및 구조 방식입니다. (예: "Pilot only") |
- **⚔️ 무장 속성 (Array of Objects)**

  상세 화면 하단의 리스트 형태 UI를 구성하는 배열(Array) 속성입니다.

  `armaments` (무장 목록)

  내부에 각 무장 정보를 담은 객체들을 가집니다. 값이 없을 경우 `null`을 반환합니다.

  | **속성명 (Key)** | **데이터 타입** | **설명** |
  | --- | --- | --- |
  | **`name`** | `String` | 무장의 이름입니다. (예: "빔 라이플") |
  | **`details`** | `String` | 무장의 장착 위치나 개수 등 상세 정보입니다. (예: "x2 (머리 장착)") |
  | **`indicatorColor`** | `String` | UI 좌측에 표시될 점(Indicator)의 색상 값입니다. (`"red"`, `"blue"`, `"grey"` 등 CSS 클래스나 스타일 변수와 매핑용) |

# UI 디자인

| 홈 화면                                                                                                                                  | 디테일 화면 1                                                                                                                              | 디테일 화면 2                                                                                                                              |
|---------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| <img width="403" height="869" alt="스크린샷 2026-06-14 오전 1 14 00" src="https://github.com/user-attachments/assets/3b3aae0e-1d11-47f4-b21c-a68efe373d1f" /> | <img width="407" height="866" alt="스크린샷 2026-06-14 오전 1 18 07" src="https://github.com/user-attachments/assets/f6e8cf6c-fb53-4039-b050-c181264e55fa" /> | <img width="399" height="861" alt="스크린샷 2026-06-14 오전 1 18 15" src="https://github.com/user-attachments/assets/84bfebfa-fe84-405c-91a8-9a0aab3103e6" /> |
