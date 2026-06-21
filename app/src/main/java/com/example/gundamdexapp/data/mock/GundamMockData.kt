package com.example.gundamdexapp.data.mock

import com.example.gundamdexapp.data.domain.detail.model.Armament
import com.example.gundamdexapp.data.domain.detail.model.Armaments
import com.example.gundamdexapp.data.domain.detail.model.Dimensions
import com.example.gundamdexapp.data.domain.detail.model.GundamInfo
import com.example.gundamdexapp.data.domain.detail.model.IndicatorColor
import com.example.gundamdexapp.data.domain.detail.model.TechnicalSpecifications

object GundamMockData {
    val mockGundams = listOf(
        GundamInfo(
            id = "rx-78-2",
            modelNumber = "RX-78-2",
            name = "건담",
            series = "기동전사 건담",
            imageUrl = "https://example.com/images/rx-78-2.jpg",
            era = "U.C. 0079",
            faction = "지구연방군",
            pilot = "아무로 레이",
            description = "지구연방군이 지온 공국군의 자쿠를 참고해 개발한 백병전용 MS. 사이드 7에서 반출될 예정이었으나, 자쿠의 급습으로 인해 그대로 실전에 배치되었다. 사상 최초로 전함급 위력을 자랑하는 빔 병기를 탑재하여 '연방의 하얀 녀석'이라 불렸다.",
            dimensions = Dimensions(
                height = "18.0m",
                weight = "43.4t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "1380 kW",
                armorMaterial = "루나 티타늄 합금",
                totalTrust = "55,500 kg",
                sensorRadius = "5,700 m",
                crew = "Pilot only (Core Block)",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "60mm 발칸포",
                        details = "x2 (머리 장착)",
                        indicatorColor = IndicatorColor.RED,
                    ),
                    Armament(
                        name = "빔 사벨",
                        details = "x2 (백팩)",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "빔 라이플",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "실드",
                        details = "팔 장착 / 휴대용",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "ms-06s",
            modelNumber = "MS-06S",
            name = "샤아 전용 자쿠 II",
            series = "기동전사 건담",
            imageUrl = "https://example.com/images/ms-06s.jpg",
            era = "U.C. 0079",
            faction = "지온 공국군",
            pilot = "샤아 아즈나블",
            description = "지온 공국군의 지휘관용 MS로, 샤아 아즈나블의 퍼스널 컬러인 붉은색으로 도장되어 있다. 통상형 자쿠 II보다 3배 빠른 속도로 전장을 누벼 '붉은 혜성'이라는 이명을 얻었다.",
            dimensions = Dimensions(
                height = "17.5m",
                weight = "56.2t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "976 kW",
                armorMaterial = "초경강 합금",
                totalTrust = "51,600 kg",
                sensorRadius = "3,200 m",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "120mm 자쿠 머신건",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                    Armament(
                        name = "히트 호크",
                        details = "근접 무기",
                        indicatorColor = IndicatorColor.RED,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "msz-006",
            modelNumber = "MSZ-006",
            name = "Z 건담",
            series = "기동전사 Z 건담",
            imageUrl = "https://example.com/images/msz-006.jpg",
            era = "U.C. 0087",
            faction = "에우고 (A.E.U.G.)",
            pilot = "카미유 비단",
            description = "에우고가 개발한 가변형 MS(TMS). 바이오 센서를 탑재하여 파일럿의 뉴타입 능력을 기체 제어에 반영할 수 있으며, 웨이브 라이더 형태로 변형해 대기권 단독 돌입이 가능하다.",
            dimensions = Dimensions(
                height = "19.85m",
                weight = "28.7t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "2020 kW",
                armorMaterial = "건다리움 합금",
                totalTrust = "112,600 kg",
                sensorRadius = "14,000 m",
            ),
            armaments = Armaments(),
        ),
        GundamInfo(
            id = "rx-93",
            modelNumber = "RX-93",
            name = "뉴 건담",
            series = "기동전사 건담 역습의 샤아",
            imageUrl = "https://example.com/images/rx-93.jpg",
            era = "U.C. 0093",
            faction = "론도 벨",
            pilot = "아무로 레이",
            description = "론도 벨 부대의 에이스 아무로 레이가 직접 설계에 참여한 기체. 콕핏 주변에 사이코프레임이 채용되어 경이적인 반응 속도를 보여주며, 핀 판넬을 장비하여 올 레인지 공격이 가능하다.",
            dimensions = Dimensions(
                height = "22.0m",
                weight = "27.9t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "핀 판넬",
                        details = "x6 (백팩 장착)",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "빔 라이플",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "뉴 하이퍼 바주카",
                        details = "백팩 장착 / 휴대용",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "msn-04",
            modelNumber = "MSN-04",
            name = "사자비",
            series = "기동전사 건담 역습의 샤아",
            imageUrl = "https://example.com/images/msn-04.jpg",
            era = "U.C. 0093",
            faction = "네오 지온",
            pilot = "샤아 아즈나블",
            description = "신생 네오 지온의 총수 샤아 아즈나블의 전용기. 뉴타입 전용기로서 사이코프레임을 채용하여 거대한 덩치에도 불구하고 기동성이 뛰어나며 판넬을 이용한 다각도 공격이 특기이다.",
            dimensions = Dimensions(
                height = "25.6m",
                weight = "30.5t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "3960 kW",
                armorMaterial = "건다리움 합금",
                totalTrust = "133,000 kg",
                sensorRadius = "22,600 m",
            ),
            armaments = Armaments(),
        ),
        GundamInfo(
            id = "rx-0",
            modelNumber = "RX-0",
            name = "유니콘 건담",
            series = "기동전사 건담 UC",
            imageUrl = "https://example.com/images/rx-0.jpg",
            era = "U.C. 0096",
            faction = "에코즈 / 론도 벨",
            pilot = "버나지 링크스",
            description = "애너하임 일렉트로닉스사가 개발한 풀 사이코프레임 탑재기. '라플라스의 상자'로 가는 열쇠이며, 특정 조건에서 NT-D 시스템이 발동하면 디스트로이 모드로 변신하여 압도적인 성능을 발휘한다.",
            dimensions = Dimensions(
                height = "19.7m (유니콘) / 21.7m (디스트로이)",
                weight = "23.7t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "빔 매그넘",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "하이퍼 바주카",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "msn-06s",
            modelNumber = "MSN-06S",
            name = "시난주",
            series = "기동전사 건담 UC",
            imageUrl = "https://example.com/images/msn-06s.jpg",
            era = "U.C. 0096",
            faction = "소데츠키",
            pilot = "풀 프론탈",
            description = "소데츠키의 리더 풀 프론탈의 탑승기. 유니콘 건담의 개발 베이스가 된 기체로 무버블 프레임의 일부에 사이코프레임이 사용되었다. 붉은 혜성의 재래라 불리는 기동성을 자랑한다.",
            dimensions = Dimensions(
                height = "22.6m",
                weight = "25.2t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(),
        ),
        GundamInfo(
            id = "xxxg-00w0",
            modelNumber = "XXXG-00W0",
            name = "윙 건담 제로",
            series = "신기동전기 건담 W",
            imageUrl = "https://example.com/images/xxxg-00w0.jpg",
            era = "A.C. 195",
            faction = "콜로니 해방 조직",
            pilot = "히이로 유이",
            description = "5기의 건담의 원형이 되는 기체로, 제로 시스템을 탑재하여 파일럿에게 전장의 미래 예측을 강제로 주입한다. 주 무장인 트윈 버스터 라이플은 스페이스 콜로니조차 파괴할 수 있는 위력을 지녔다.",
            dimensions = Dimensions(
                height = "16.7m",
                weight = "7.1t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "3732 kW",
                armorMaterial = "건다늄 합금",
                totalTrust = "88,150 kg",
                sensorRadius = "알 수 없음",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "트윈 버스터 라이플",
                        details = "휴대용 / 분리 가능",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "머신 캐논",
                        details = "x2 (어깨 장착)",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "zgmf-x10a",
            modelNumber = "ZGMF-X10A",
            name = "프리덤 건담",
            series = "기동전사 건담 SEED",
            imageUrl = "https://example.com/images/zgmf-x10a.jpg",
            era = "C.E. 71",
            faction = "자프트 (Z.A.F.T.) / 삼척동맹",
            pilot = "키라 야마토",
            description = "자프트가 탈취한 GAT 시리즈의 데이터를 바탕으로 개발한 기체. 뉴트론 재머 캔슬러를 장비해 핵엔진을 구동시키며, 멀티 록온 시스템을 통한 화력 전개(풀 버스트)가 특징이다.",
            dimensions = Dimensions(
                height = "18.03m",
                weight = "71.5t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                armorMaterial = "페이즈 시프트(PS) 장갑",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "루프스 빔 라이플",
                        details = "휴대용",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "크시피어스 레일포",
                        details = "x2 (허리 장착)",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                    Armament(
                        name = "발라에나 플라즈마 수속 빔 포",
                        details = "x2 (날개 장착)",
                        indicatorColor = IndicatorColor.RED,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "zgmf-x09a",
            modelNumber = "ZGMF-X09A",
            name = "저스티스 건담",
            series = "기동전사 건담 SEED",
            imageUrl = "https://example.com/images/zgmf-x09a.jpg",
            era = "C.E. 71",
            faction = "자프트 (Z.A.F.T.) / 삼척동맹",
            pilot = "아스란 자라",
            description = "프리덤 건담과 함께 개발된 형제기. 배면에 장착된 대형 서포트 메카 '파툼-00'을 활용한 고기동 전투 및 다채로운 변칙 공격이 특기이다.",
            dimensions = Dimensions(
                height = "18.56m",
                weight = "75.4t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(),
        ),
        GundamInfo(
            id = "gat-x105",
            modelNumber = "GAT-X105",
            name = "스트라이크 건담",
            series = "기동전사 건담 SEED",
            imageUrl = "https://example.com/images/gat-x105.jpg",
            era = "C.E. 71",
            faction = "지구연합군",
            pilot = "키라 야마토",
            description = "지구연합군이 개발한 G 병기 중 하나. 스트라이커 팩 시스템을 도입하여 전황에 맞춰 에일, 소드, 런처 등으로 장비를 교체하며 다양한 전장에 대응할 수 있는 범용성을 지녔다.",
            dimensions = Dimensions(
                height = "17.72m",
                weight = "64.8t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "아머 슈나이더",
                        details = "x2 (허리 수납)",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "gn-001",
            modelNumber = "GN-001",
            name = "건담 엑시아",
            series = "기동전사 건담 00",
            imageUrl = "https://example.com/images/gn-001.jpg",
            era = "A.D. 2307",
            faction = "솔레스탈 비잉",
            pilot = "세츠나 F. 세이에이",
            description = "솔레스탈 비잉이 소유한 제3세대 건담. '세븐 소드'라는 개발 코드명처럼 7개의 검을 장비하여 격투전에 특화되어 있으며, GN 드라이브를 통해 무한에 가까운 에너지를 얻는다.",
            dimensions = Dimensions(
                height = "18.3m",
                weight = "57.2t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "GN 드라이브",
                armorMaterial = "E카본",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "GN 소드",
                        details = "오른팔 장착",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                    Armament(
                        name = "GN 롱/숏 블레이드",
                        details = "허리 장착",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                    Armament(
                        name = "GN 빔 사벨",
                        details = "x4 (어깨/허리 후면 장착)",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "gn-0000",
            modelNumber = "GN-0000",
            name = "더블오 건담",
            series = "기동전사 건담 00",
            imageUrl = "https://example.com/images/gn-0000.jpg",
            era = "A.D. 2312",
            faction = "솔레스탈 비잉",
            pilot = "세츠나 F. 세이에이",
            description = "엑시아의 후계기. 2기의 GN 드라이브를 동기화시키는 '트윈 드라이브 시스템'을 탑재하여 기하급수적인 입자 방출량을 자랑한다.",
            dimensions = Dimensions(),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(),
        ),
        GundamInfo(
            id = "asw-g-08",
            modelNumber = "ASW-G-08",
            name = "건담 발바토스",
            series = "기동전사 건담 철혈의 오펀스",
            imageUrl = "https://example.com/images/asw-g-08.jpg",
            era = "P.D. 323",
            faction = "철화단",
            pilot = "미카즈키 아우구스",
            description = "액제전 시절에 개발된 '건담 프레임'을 채용한 MS 중 하나. 아라야식 시스템을 통해 파일럿과 기체가 일체화되어 야성적인 전투를 펼친다.",
            dimensions = Dimensions(
                height = "18.0m",
                weight = "28.5t",
            ),
            technicalSpecifications = TechnicalSpecifications(
                generatorOutput = "에이합 리액터 x2",
                armorMaterial = "나노 라미네이트 아머",
            ),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "메이스",
                        details = "물리 타격 무기",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                    Armament(
                        name = "태도",
                        details = "근접 베기 무기",
                        indicatorColor = IndicatorColor.GRAY,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "xvx-016",
            modelNumber = "XVX-016",
            name = "건담 에어리얼",
            series = "기동전사 건담 수성의 마녀",
            imageUrl = "https://example.com/images/xvx-016.jpg",
            era = "A.S. 122",
            faction = "주식회사 건담",
            pilot = "슬레타 머큐리",
            description = "수성에서 온 소녀 슬레타 머큐리가 아스티카시아 고등 전문 학원에 가져온 기체. 군드 포맷을 탑재하고 있으며, 11개의 건비트로 구성된 에스쿠천을 활용해 다채로운 공방을 보여준다.",
            dimensions = Dimensions(
                height = "18.0m",
                weight = "43.9t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(
                _value = listOf(
                    Armament(
                        name = "에스쿠천 (건비트)",
                        details = "다목적 원격 조작 병기",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                    Armament(
                        name = "빔 라이플",
                        details = "비트 스테이브 결합 가능",
                        indicatorColor = IndicatorColor.BLUE,
                    ),
                ),
            ),
        ),
        GundamInfo(
            id = "gf13-017njii",
            modelNumber = "GF13-017NJII",
            name = "갓 건담",
            series = "기동무투전 G 건담",
            imageUrl = "https://example.com/images/gf13-017njii.jpg",
            era = "F.C. 60",
            faction = "네오 재팬",
            pilot = "도몬 캇슈",
            description = "네오 재팬의 모빌 파이터. 샤이닝 건담의 후계기로 명경지수 상태에 이르면 기체가 황금빛으로 빛나는 하이퍼 모드가 된다. 폭렬 갓 핑거를 비롯한 강력한 무술 공격이 특기다.",
            dimensions = Dimensions(
                height = "16.6m",
                weight = "7.5t",
            ),
            technicalSpecifications = TechnicalSpecifications(),
            armaments = Armaments(),
        ),
    )
}
