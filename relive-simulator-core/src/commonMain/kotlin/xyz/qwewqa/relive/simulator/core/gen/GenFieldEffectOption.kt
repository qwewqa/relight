@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenFieldEffectOption(
    val effect_description: Map<String,String>,
    val effect_name: String,
    val extra_description: Map<String,String>,
    val icon_id: Int,
    val param1: Int,
    val param1_unit: Int,
    val time_unit: Int,
    val type: Int,
    val value_unit: Int
)

/*
1:
  effect_description:
    en: Light of Courage
    ja: 勇気の灯
    ko: 용기의 등불
    zh_hant: 勇氣之燈
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 1
  param1: 1
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
2:
  effect_description:
    en: We Are on the Stage (Flower)
    ja: 私たちはもう舞台の上（花）
    ko: 우리는 이미 무대 위(꽃)
    zh_hant: 我們已經站上舞台（花）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 2
  param1: 2
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
3:
  effect_description:
    en: We Are on the Stage (Wind)
    ja: 私たちはもう舞台の上（風）
    ko: 우리는 이미 무대 위(바람)
    zh_hant: 我們已經站上舞台（風）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 3
  param1: 3
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
4:
  effect_description:
    en: We Are on the Stage (Snow)
    ja: 私たちはもう舞台の上（雪）
    ko: 우리는 이미 무대 위(눈)
    zh_hant: 我們已經站上舞台（雪）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 4
  param1: 4
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
5:
  effect_description:
    en: We Are on the Stage (Moon)
    ja: 私たちはもう舞台の上（月）
    ko: 우리는 이미 무대 위(달)
    zh_hant: 我們已經站上舞台（月）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 5
  param1: 5
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
6:
  effect_description:
    en: We Are on the Stage (Space)
    ja: 私たちはもう舞台の上（宙）
    ko: 우리는 이미 무대 위(우주)
    zh_hant: 我們已經站上舞台（宙）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 6
  param1: 6
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
7:
  effect_description:
    en: We Are on the Stage (Cloud)
    ja: 私たちはもう舞台の上（雲）
    ko: 우리는 이미 무대 위(구름)
    zh_hant: 我們已經站上舞台（雲）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 7
  param1: 7
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
8:
  effect_description:
    en: Sunset Tune
    ja: 落日の音色
    ko: 낙조의 음색
    zh_hant: 落日音色
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 8
  param1: 8
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
9:
  effect_description:
    en: Shadow Stupor
    ja: 昏迷の影
    ko: 혼미의 그림자
    zh_hant: 昏迷之影
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 9
  param1: 9
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
10:
  effect_description:
    en: Lightning Shade
    ja: 電光影裏
    ko: 번갯불의 그림자
    zh_hant: 雷光影裏
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10
  param1: 10
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
11:
  effect_description:
    en: Ironclad Guard
    ja: 鉄壁の守備
    ko: 철벽 수비
    zh_hant: 鐵壁守備
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 11
  param1: 11
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
12:
  effect_description:
    en: Boldness
    ja: ガッツ
    ko: 근성
    zh_hant: 毅力
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 12
  param1: 12
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
13:
  effect_description:
    en: Thunder
    ja: 雷鳴
    ko: 천둥
    zh_hant: 雷鳴
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 13
  param1: 13
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
14:
  effect_description:
    en: Winning Determination
    ja: 勝負根性
    ko: 승부 근성
    zh_hant: 勝負鬥志
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 14
  param1: 14
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
15:
  effect_description:
    en: Concentration (Space)
    ja: 本日も集中あるのみ（宙）
    ko: 오늘도 집중할 뿐(우주)
    zh_hant: 今天也要全神貫注（宙）
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 15
  param1: 15
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
16:
  effect_description:
    en: Concentration (Wind)
    ja: 本日も集中あるのみ（風）
    ko: 오늘도 집중할 뿐(바람)
    zh_hant: 今天也要全神貫注（風）
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 16
  param1: 16
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
17:
  effect_description:
    en: Concentration (Snow)
    ja: 本日も集中あるのみ（雪）
    ko: 오늘도 집중할 뿐(눈)
    zh_hant: 今天也要全神貫注（雪）
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 17
  param1: 17
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
18:
  effect_description:
    en: Tears or Mist
    ja: 露か涙か
    ko: 이슬인가 눈물인가
    zh_hant: 如露又似淚
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 18
  param1: 18
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
19:
  effect_description:
    en: God of War's Protection
    ja: 戦神の護り
    ko: 전쟁신의 수호
    zh_hant: 戰神加護
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 19
  param1: 19
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
20:
  effect_description:
    en: Wild Hope
    ja: 希望の荒野
    ko: 희망의 황야
    zh_hant: 希望荒野
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 20
  param1: 20
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
21:
  effect_description:
    en: Roaring Fire
    ja: 火煙轟々
    ko: 타오르는 불꽃
    zh_hant: 熊熊烈火
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 21
  param1: 21
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
22:
  effect_description:
    en: Angelic Smile
    ja: 天使のほほえみ
    ko: 천사의 미소
    zh_hant: 天使的微笑
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 22
  param1: 22
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
23:
  effect_description:
    en: Self Trapping
    ja: 自縄自縛
    ko: 자승자박
    zh_hant: 自作自受
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 23
  param1: 23
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
24:
  effect_description:
    en: Disaster Hail
    ja: 災禍の呼び声
    ko: 재해가 부르는 소리
    zh_hant: 呼喚災禍之聲
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 24
  param1: 24
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
25:
  effect_description:
    en: Death's Kiss
    ja: 死の口づけ
    ko: 죽음의 입맞춤
    zh_hant: 死亡之吻
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 25
  param1: 25
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
26:
  effect_description:
    en: Tragic Music
    ja: 悲壮の奏
    ko: 비장의 멜로디
    zh_hant: 悲壯之奏
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  param1: 26
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
27:
  effect_description:
    en: Blooming Flowers
    ja: 百花繚乱
    ko: 백화요란
    zh_hant: 百花繚亂
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 27
  param1: 27
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
28:
  effect_description:
    en: Afterlife Trials
    ja: 幽世の試練
    ko: 저승의 시련
    zh_hant: 幽世試煉
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 28
  param1: 28
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
29:
  effect_description:
    en: Junna Hoshimi's Stage
    ja: 星見純那が主役の舞台
    ko: 호시미 준나가 주역인 무대
    zh_hant: 星見純那所主演的舞台
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 29
  param1: 29
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
30:
  effect_description:
    en: Trial to the Hero, Temptation to the Saint
    ja: 英雄には試練を、聖者には誘惑を
    ko: 영웅에게는 시련을, 성자에게는 유혹을
    zh_hant: 將試煉賜予英雄，將誘惑賜予聖者
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 30
  param1: 30
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
31:
  effect_description:
    en: Sweet Moment
    ja: 甘美なひととき
    ko: 감미로운 시간
    zh_hant: 蜜糖時光
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 31
  param1: 31
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
32:
  effect_description:
    en: Falling Into Flames Together
    ja: 共に堕ちていく焔
    ko: 함께 추락하는 불꽃
    zh_hant: 共同墮落的火焰
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 32
  param1: 32
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
33:
  effect_description:
    en: Severing of Bonds
    ja: これにて縁切り
    ko: 이로써 의절
    zh_hant: 我們就此斷絕關係
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 33
  param1: 33
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
34:
  effect_description:
    en: Our Pathetic Selves
    ja: しょうもないあたしたち
    ko: 구제불능인 우리들
    zh_hant: 無可救藥的我們
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 34
  param1: 34
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
35:
  effect_description:
    en: Brilliant Stage
    ja: キラめく舞台
    ko: 반짝이는 무대
    zh_hant: 萬丈光芒的舞台
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 35
  param1: 35
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
36:
  effect_description:
    en: Bullseye
    ja: 百発百中、一発必中
    ko: 백발백중, 일발필중
    zh_hant: 百發百中，一擊必中
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 36
  param1: 36
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
37:
  effect_description:
    en: Applauses (Flower)
    ja: 拍手喝采（花）
    ko: 박수갈채(꽃)
    zh_hant: 拍手喝采（花）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 37
  param1: 37
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
38:
  effect_description:
    en: Applauses (Wind)
    ja: 拍手喝采（風）
    ko: 박수갈채(바람)
    zh_hant: 拍手喝采（風）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 38
  param1: 38
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
39:
  effect_description:
    en: Applauses (Snow)
    ja: 拍手喝采（雪）
    ko: 박수갈채(눈)
    zh_hant: 拍手喝采（雪）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 39
  param1: 39
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
40:
  effect_description:
    en: Applauses (Moon)
    ja: 拍手喝采（月）
    ko: 박수갈채(달)
    zh_hant: 拍手喝采（月）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 40
  param1: 40
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
41:
  effect_description:
    en: Applauses (Space)
    ja: 拍手喝采（宙）
    ko: 박수갈채(우주)
    zh_hant: 拍手喝采（宙）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 41
  param1: 41
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
42:
  effect_description:
    en: Applauses (Cloud)
    ja: 拍手喝采（雲）
    ko: 박수갈채(구름)
    zh_hant: 拍手喝采（雲）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 42
  param1: 42
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
43:
  effect_description:
    en: We Are Rivals!
    ja: 私たちはライバル！
    ko: 우리는 라이벌!
    zh_hant: 我們是勁敵！
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 43
  param1: 43
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
44:
  effect_description:
    en: Royal Authority
    ja: 燦然たる王威
    ko: 찬란한 왕의 위엄
    zh_hant: 璀璨的王之威光
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 44
  param1: 44
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
45:
  effect_description:
    en: Captivating Pupils
    ja: 魅惑の瞳
    ko: 매혹의 눈동자
    zh_hant: 魅惑的眼眸
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 45
  param1: 45
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
46:
  effect_description:
    en: Twilight of the Gods
    ja: 神々の黄昏
    ko: 신들의 황혼
    zh_hant: 諸神黃昏
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 46
  param1: 46
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
48:
  effect_description:
    en: This Is the Stage
    ja: ここが舞台だ
    ko: 여기가 무대다
    zh_hant: 這裡是舞台
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 48
  param1: 48
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
49:
  effect_description:
    en: Je T'Aime
    ja: ジュ・テーム
    ko: 쥬뗌므
    zh_hant: Je t'aime
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 49
  param1: 49
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
50:
  effect_description:
    en: Scar of Grief
    ja: 嘆きの傷痕
    ko: 비탄의 상흔
    zh_hant: 悲嘆的傷痕
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 50
  param1: 50
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
51:
  effect_description:
    en: Tragic Fate
    ja: 散華のさだめ
    ko: 산화의 숙명
    zh_hant: 光榮犧牲的宿命
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 51
  param1: 51
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
52:
  effect_description:
    en: Divine Power
    ja: 神授の力
    ko: 신이 내린 힘
    zh_hant: 神授之力
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 52
  param1: 52
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
53:
  effect_description:
    en: Majestic
    ja: 威風凛々
    ko: 위풍당당
    zh_hant: 威風凛凛
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 53
  param1: 53
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
54:
  effect_description:
    en: Hesitation
    ja: 遅疑逡巡
    ko: 의심과 망설임
    zh_hant: 遲疑不定
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 54
  param1: 54
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
55:
  effect_description:
    en: Mellow Flavor
    ja: 心躍る芳醇
    ko: 마음 들뜨는 향긋함
    zh_hant: 心悸的香醇
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 55
  param1: 55
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
56:
  effect_description:
    en: Sugary Corruption
    ja: 甘き堕落
    ko: 달콤한 타락
    zh_hant: 甘美墮落
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 56
  param1: 56
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
57:
  effect_description:
    en: Plan of the Abyss
    ja: 深淵なる謀
    ko: 심연의 계략
    zh_hant: 深謀遠慮
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 57
  param1: 57
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
58:
  effect_description:
    en: Golden Vitality
    ja: 黄金の活力
    ko: 황금의 활력
    zh_hant: 黃金活力
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 58
  param1: 58
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
59:
  effect_description:
    en: Pledge of the Sage
    ja: 賢者の契り
    ko: 현자의 약속
    zh_hant: 賢者的契約
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 59
  param1: 59
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
60:
  effect_description:
    en: Heavenly Highlight
    ja: 天体ハイライト
    ko: 천체 하이라이트
    zh_hant: 天體注目
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 60
  param1: 60
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
61:
  effect_description:
    en: Grace, Nobility, Fun
    ja: 美しく、気高く、楽しく
    ko: 아름답게, 품위있게, 즐겁게
    zh_hant: 美麗、高貴且樂在其中
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 61
  param1: 61
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
62:
  effect_description:
    en: Happy Footsteps
    ja: 幸福の足音
    ko: 행복의 발소리
    zh_hant: 幸福的腳步聲
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 62
  param1: 62
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
63:
  effect_description:
    en: Leap Oath
    ja: 飛躍の誓い
    ko: 비약의 맹세
    zh_hant: 飛躍之誓言
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 63
  param1: 63
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
64:
  effect_description:
    en: Calamity
    ja: 凶変
    ko: 흉변
    zh_hant: 變故
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 64
  param1: 64
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
65:
  effect_description:
    en: Self Trapping
    ja: 自縄自縛
    ko: 자승자박
    zh_hant: 自作自受
  effect_name: hit_stage_effect02
  extra_description:
    en: Applies at Lv. 2
    ja: Lv2で付与
    ko: Lv2로 부여
    zh_hant: 以Lv2的狀態賦予
  icon_id: 23
  param1: 23
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
66:
  effect_description:
    en: Thunder
    ja: 雷鳴
    ko: 천둥
    zh_hant: 雷鳴
  effect_name: hit_stage_effect02
  extra_description:
    en: Applies at Lv. 2
    ja: Lv2で付与
    ko: Lv2로 부여
    zh_hant: 以Lv2的狀態賦予
  icon_id: 13
  param1: 13
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
67:
  effect_description:
    en: Standing Ovation (Flower)
    ja: 拍手万雷（花）
    ko: 박수만뢰(꽃)
    zh_hant: 掌聲如雷（花）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 65
  param1: 65
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
68:
  effect_description:
    en: Standing Ovation (Wind)
    ja: 拍手万雷（風）
    ko: 박수만뢰(바람)
    zh_hant: 掌聲如雷（風）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 66
  param1: 66
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
71:
  effect_description:
    en: Standing Ovation (Space)
    ja: 拍手万雷（宙）
    ko: 박수만뢰(우주)
    zh_hant: 掌聲如雷（宙）
  effect_name: hit_stage_effect01
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 69
  param1: 69
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
72:
  effect_description:
    ja: 拍手万雷（雲）
  effect_name: hit_stage_effect01
  extra_description:
    ja: ''
  icon_id: 70
  param1: 70
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
73:
  effect_description:
    ja: 風雅なる誘い
  effect_name: hit_stage_effect01
  extra_description:
    ja: ''
  icon_id: 71
  param1: 71
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
74:
  effect_description:
    ja: 行雲流水
  effect_name: hit_stage_effect01
  extra_description:
    ja: ''
  icon_id: 72
  param1: 72
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
75:
  effect_description:
    ja: キラめきの潮流
  effect_name: hit_stage_effect01
  extra_description:
    ja: ''
  icon_id: 73
  param1: 73
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
76:
  effect_description:
    en: Battle Strategy
    ja: 戦場掌握
    ko: 전장 장악
    zh_hant: 掌握戰場
  effect_name: hit_stage_effect02
  extra_description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 74
  param1: 74
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
77:
  effect_description:
    en: Battle Strategy
    ja: 戦場掌握
    ko: 전장 장악
    zh_hant: 掌握戰場
  effect_name: hit_stage_effect02
  extra_description:
    en: Applies at Lv. 3
    ja: Lv3で付与
    ko: Lv3으로 부여
    zh_hant: 以Lv3的狀態賦予
  icon_id: 74
  param1: 74
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
78:
  effect_description:
    ja: 迷宮入りの予感
  effect_name: hit_stage_effect02
  extra_description:
    ja: ''
  icon_id: 75
  param1: 75
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
79:
  effect_description:
    ja: 魅惑の瞳
  effect_name: hit_stage_effect02
  extra_description:
    ja: Lv2で付与
  icon_id: 45
  param1: 45
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
80:
  effect_description:
    ja: 百発百中、一発必中
  effect_name: hit_stage_effect01
  extra_description:
    ja: Lv2で付与
  icon_id: 36
  param1: 36
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
85:
  effect_description:
    ja: 拍手喝采（宙）
  effect_name: hit_stage_effect01
  extra_description:
    ja: Lv2で付与
  icon_id: 41
  param1: 41
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
87:
  effect_description:
    ja: 灰色の世界
  effect_name: hit_stage_effect02
  extra_description:
    ja: ''
  icon_id: 76
  param1: 76
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
88:
  effect_description:
    ja: トキメキ発見
  effect_name: hit_stage_effect01
  extra_description:
    ja: ''
  icon_id: 77
  param1: 77
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
89:
  effect_description:
    ja: 百花繚乱
  effect_name: hit_stage_effect01
  extra_description:
    ja: Lv2で付与
  icon_id: 27
  param1: 27
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
90:
  effect_description:
    ja: 拍手喝采（月）
  effect_name: hit_stage_effect01
  extra_description:
    ja: Lv2で付与
  icon_id: 40
  param1: 40
  param1_unit: 0
  time_unit: 0
  type: 1
  value_unit: 0
2001:
  effect_description:
    en: Neg. Stage Effect Lv. Down (%value%)
    ja: マイナス舞台効果Lvダウン(%value%)
    ko: 마이너스 무대 효과 Lv 감소(%value%)
    zh_hant: 降低負面舞台效果Lv（%value%）
  effect_name: hit_stage_effect01
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 47
  param1: 1
  param1_unit: 3
  time_unit: 0
  type: 2
  value_unit: 0
2002:
  effect_description:
    en: Pos. Stage Effect Lv. Down (%value%)
    ja: プラス舞台効果Lvダウン(%value%)
    ko: 플러스 무대 효과 Lv 감소(%value%)
    zh_hant: 降低正面舞台效果Lv（%value%）
  effect_name: hit_stage_effect02
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 900
  param1: 1
  param1_unit: 3
  time_unit: 0
  type: 3
  value_unit: 0
2003:
  effect_description:
    en: Neg. Stage Effect Lv. Up (%value%)
    ja: マイナス舞台効果Lvアップ(%value%)
    ko: 마이너스 무대 효과 Lv 증가(%value%)
    zh_hant: 提升負面舞台效果Lv（%value%）
  effect_name: hit_stage_effect02
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 0
  param1: 1
  param1_unit: 3
  time_unit: 0
  type: 4
  value_unit: 0
2004:
  effect_description:
    en: Pos. Stage Effect Lv. Up (%value%)
    ja: プラス舞台効果Lvアップ(%value%)
    ko: 플러스 무대 효과 Lv 증가(%value%)
    zh_hant: 提升正面舞台效果Lv（%value%）
  effect_name: hit_stage_effect01
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 0
  param1: 1
  param1_unit: 3
  time_unit: 0
  type: 5
  value_unit: 0
2005:
  effect_description:
    en: Neg. Stage Effect Lv. Down (%value%)
    ja: マイナス舞台効果Lvダウン(%value%)
    ko: 마이너스 무대 효과 Lv 감소(%value%)
    zh_hant: 降低負面舞台效果Lv（%value%）
  effect_name: hit_stage_effect01
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 47
  param1: 2
  param1_unit: 3
  time_unit: 0
  type: 2
  value_unit: 0
2006:
  effect_description:
    en: Pos. Stage Effect Lv. Down (%value%)
    ja: プラス舞台効果Lvダウン(%value%)
    ko: 플러스 무대 효과 Lv 감소(%value%)
    zh_hant: 降低正面舞台效果Lv（%value%）
  effect_name: hit_stage_effect02
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 900
  param1: 2
  param1_unit: 3
  time_unit: 0
  type: 3
  value_unit: 0
2007:
  effect_description:
    en: Neg. Stage Effect Lv. Up (%value%)
    ja: マイナス舞台効果Lvアップ(%value%)
    ko: 마이너스 무대 효과 Lv 증가(%value%)
    zh_hant: 提升負面舞台效果Lv（%value%）
  effect_name: hit_stage_effect02
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 0
  param1: 2
  param1_unit: 3
  time_unit: 0
  type: 4
  value_unit: 0
2008:
  effect_description:
    en: Pos. Stage Effect Lv. Up (%value%)
    ja: プラス舞台効果Lvアップ(%value%)
    ko: 플러스 무대 효과 Lv 증가(%value%)
    zh_hant: 提升正面舞台效果Lv（%value%）
  effect_name: hit_stage_effect01
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 0
  param1: 2
  param1_unit: 3
  time_unit: 0
  type: 5
  value_unit: 0
2009:
  effect_description:
    en: Neg. Stage Effect Lv. Down (%value%)
    ja: マイナス舞台効果Lvダウン(%value%)
    ko: 마이너스 무대 효과 Lv 감소(%value%)
    zh_hant: 降低負面舞台效果Lv（%value%）
  effect_name: hit_stage_effect01
  extra_description:
    en: Most Recent Stage Effect %param1%
    ja: 直近付与された舞台効果%param1%
    ko: 최근에 부여된 무대 효과 %param1%
    zh_hant: 最新被賦予的舞台效果%param1%
  icon_id: 47
  param1: 3
  param1_unit: 3
  time_unit: 0
  type: 2
  value_unit: 0

*/

val valuesGenFieldEffectOption = loadMasterData<GenFieldEffectOption>("{\"1\":{\"effect_description\":{\"ja\":\"勇気の灯\",\"en\":\"Light of Courage\",\"ko\":\"용기의 등불\",\"zh_hant\":\"勇氣之燈\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":1,\"param1\":1,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"2\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（花）\",\"en\":\"We Are on the Stage (Flower)\",\"ko\":\"우리는 이미 무대 위(꽃)\",\"zh_hant\":\"我們已經站上舞台（花）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":2,\"param1\":2,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"3\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（風）\",\"en\":\"We Are on the Stage (Wind)\",\"ko\":\"우리는 이미 무대 위(바람)\",\"zh_hant\":\"我們已經站上舞台（風）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":3,\"param1\":3,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"4\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（雪）\",\"en\":\"We Are on the Stage (Snow)\",\"ko\":\"우리는 이미 무대 위(눈)\",\"zh_hant\":\"我們已經站上舞台（雪）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":4,\"param1\":4,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"5\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（月）\",\"en\":\"We Are on the Stage (Moon)\",\"ko\":\"우리는 이미 무대 위(달)\",\"zh_hant\":\"我們已經站上舞台（月）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":5,\"param1\":5,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"6\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（宙）\",\"en\":\"We Are on the Stage (Space)\",\"ko\":\"우리는 이미 무대 위(우주)\",\"zh_hant\":\"我們已經站上舞台（宙）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":6,\"param1\":6,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"7\":{\"effect_description\":{\"ja\":\"私たちはもう舞台の上（雲）\",\"en\":\"We Are on the Stage (Cloud)\",\"ko\":\"우리는 이미 무대 위(구름)\",\"zh_hant\":\"我們已經站上舞台（雲）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":7,\"param1\":7,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"8\":{\"effect_description\":{\"ja\":\"落日の音色\",\"en\":\"Sunset Tune\",\"ko\":\"낙조의 음색\",\"zh_hant\":\"落日音色\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":8,\"param1\":8,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"9\":{\"effect_description\":{\"ja\":\"昏迷の影\",\"en\":\"Shadow Stupor\",\"ko\":\"혼미의 그림자\",\"zh_hant\":\"昏迷之影\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":9,\"param1\":9,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"10\":{\"effect_description\":{\"ja\":\"電光影裏\",\"en\":\"Lightning Shade\",\"ko\":\"번갯불의 그림자\",\"zh_hant\":\"雷光影裏\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10,\"param1\":10,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"11\":{\"effect_description\":{\"ja\":\"鉄壁の守備\",\"en\":\"Ironclad Guard\",\"ko\":\"철벽 수비\",\"zh_hant\":\"鐵壁守備\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":11,\"param1\":11,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"12\":{\"effect_description\":{\"ja\":\"ガッツ\",\"en\":\"Boldness\",\"ko\":\"근성\",\"zh_hant\":\"毅力\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":12,\"param1\":12,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"13\":{\"effect_description\":{\"ja\":\"雷鳴\",\"en\":\"Thunder\",\"ko\":\"천둥\",\"zh_hant\":\"雷鳴\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":13,\"param1\":13,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"14\":{\"effect_description\":{\"ja\":\"勝負根性\",\"en\":\"Winning Determination\",\"ko\":\"승부 근성\",\"zh_hant\":\"勝負鬥志\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":14,\"param1\":14,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"15\":{\"effect_description\":{\"ja\":\"本日も集中あるのみ（宙）\",\"en\":\"Concentration (Space)\",\"ko\":\"오늘도 집중할 뿐(우주)\",\"zh_hant\":\"今天也要全神貫注（宙）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":15,\"param1\":15,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"16\":{\"effect_description\":{\"ja\":\"本日も集中あるのみ（風）\",\"en\":\"Concentration (Wind)\",\"ko\":\"오늘도 집중할 뿐(바람)\",\"zh_hant\":\"今天也要全神貫注（風）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":16,\"param1\":16,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"17\":{\"effect_description\":{\"ja\":\"本日も集中あるのみ（雪）\",\"en\":\"Concentration (Snow)\",\"ko\":\"오늘도 집중할 뿐(눈)\",\"zh_hant\":\"今天也要全神貫注（雪）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":17,\"param1\":17,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"18\":{\"effect_description\":{\"ja\":\"露か涙か\",\"en\":\"Tears or Mist\",\"ko\":\"이슬인가 눈물인가\",\"zh_hant\":\"如露又似淚\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":18,\"param1\":18,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"19\":{\"effect_description\":{\"ja\":\"戦神の護り\",\"en\":\"God of War's Protection\",\"ko\":\"전쟁신의 수호\",\"zh_hant\":\"戰神加護\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":19,\"param1\":19,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"20\":{\"effect_description\":{\"ja\":\"希望の荒野\",\"en\":\"Wild Hope\",\"ko\":\"희망의 황야\",\"zh_hant\":\"希望荒野\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":20,\"param1\":20,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"21\":{\"effect_description\":{\"ja\":\"火煙轟々\",\"en\":\"Roaring Fire\",\"ko\":\"타오르는 불꽃\",\"zh_hant\":\"熊熊烈火\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":21,\"param1\":21,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"22\":{\"effect_description\":{\"ja\":\"天使のほほえみ\",\"en\":\"Angelic Smile\",\"ko\":\"천사의 미소\",\"zh_hant\":\"天使的微笑\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":22,\"param1\":22,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"23\":{\"effect_description\":{\"ja\":\"自縄自縛\",\"en\":\"Self Trapping\",\"ko\":\"자승자박\",\"zh_hant\":\"自作自受\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":23,\"param1\":23,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"24\":{\"effect_description\":{\"ja\":\"災禍の呼び声\",\"en\":\"Disaster Hail\",\"ko\":\"재해가 부르는 소리\",\"zh_hant\":\"呼喚災禍之聲\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":24,\"param1\":24,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"25\":{\"effect_description\":{\"ja\":\"死の口づけ\",\"en\":\"Death's Kiss\",\"ko\":\"죽음의 입맞춤\",\"zh_hant\":\"死亡之吻\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":25,\"param1\":25,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"26\":{\"effect_description\":{\"ja\":\"悲壮の奏\",\"en\":\"Tragic Music\",\"ko\":\"비장의 멜로디\",\"zh_hant\":\"悲壯之奏\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"param1\":26,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"27\":{\"effect_description\":{\"ja\":\"百花繚乱\",\"en\":\"Blooming Flowers\",\"ko\":\"백화요란\",\"zh_hant\":\"百花繚亂\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":27,\"param1\":27,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"28\":{\"effect_description\":{\"ja\":\"幽世の試練\",\"en\":\"Afterlife Trials\",\"ko\":\"저승의 시련\",\"zh_hant\":\"幽世試煉\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":28,\"param1\":28,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"29\":{\"effect_description\":{\"ja\":\"星見純那が主役の舞台\",\"en\":\"Junna Hoshimi's Stage\",\"ko\":\"호시미 준나가 주역인 무대\",\"zh_hant\":\"星見純那所主演的舞台\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":29,\"param1\":29,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"30\":{\"effect_description\":{\"ja\":\"英雄には試練を、聖者には誘惑を\",\"en\":\"Trial to the Hero, Temptation to the Saint\",\"ko\":\"영웅에게는 시련을, 성자에게는 유혹을\",\"zh_hant\":\"將試煉賜予英雄，將誘惑賜予聖者\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":30,\"param1\":30,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"31\":{\"effect_description\":{\"ja\":\"甘美なひととき\",\"en\":\"Sweet Moment\",\"ko\":\"감미로운 시간\",\"zh_hant\":\"蜜糖時光\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":31,\"param1\":31,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"32\":{\"effect_description\":{\"ja\":\"共に堕ちていく焔\",\"en\":\"Falling Into Flames Together\",\"ko\":\"함께 추락하는 불꽃\",\"zh_hant\":\"共同墮落的火焰\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":32,\"param1\":32,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"33\":{\"effect_description\":{\"ja\":\"これにて縁切り\",\"en\":\"Severing of Bonds\",\"ko\":\"이로써 의절\",\"zh_hant\":\"我們就此斷絕關係\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":33,\"param1\":33,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"34\":{\"effect_description\":{\"ja\":\"しょうもないあたしたち\",\"en\":\"Our Pathetic Selves\",\"ko\":\"구제불능인 우리들\",\"zh_hant\":\"無可救藥的我們\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":34,\"param1\":34,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"35\":{\"effect_description\":{\"ja\":\"キラめく舞台\",\"en\":\"Brilliant Stage\",\"ko\":\"반짝이는 무대\",\"zh_hant\":\"萬丈光芒的舞台\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":35,\"param1\":35,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"36\":{\"effect_description\":{\"ja\":\"百発百中、一発必中\",\"en\":\"Bullseye\",\"ko\":\"백발백중, 일발필중\",\"zh_hant\":\"百發百中，一擊必中\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":36,\"param1\":36,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"37\":{\"effect_description\":{\"ja\":\"拍手喝采（花）\",\"en\":\"Applauses (Flower)\",\"ko\":\"박수갈채(꽃)\",\"zh_hant\":\"拍手喝采（花）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":37,\"param1\":37,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"38\":{\"effect_description\":{\"ja\":\"拍手喝采（風）\",\"en\":\"Applauses (Wind)\",\"ko\":\"박수갈채(바람)\",\"zh_hant\":\"拍手喝采（風）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":38,\"param1\":38,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"39\":{\"effect_description\":{\"ja\":\"拍手喝采（雪）\",\"en\":\"Applauses (Snow)\",\"ko\":\"박수갈채(눈)\",\"zh_hant\":\"拍手喝采（雪）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":39,\"param1\":39,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"40\":{\"effect_description\":{\"ja\":\"拍手喝采（月）\",\"en\":\"Applauses (Moon)\",\"ko\":\"박수갈채(달)\",\"zh_hant\":\"拍手喝采（月）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":40,\"param1\":40,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"41\":{\"effect_description\":{\"ja\":\"拍手喝采（宙）\",\"en\":\"Applauses (Space)\",\"ko\":\"박수갈채(우주)\",\"zh_hant\":\"拍手喝采（宙）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":41,\"param1\":41,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"42\":{\"effect_description\":{\"ja\":\"拍手喝采（雲）\",\"en\":\"Applauses (Cloud)\",\"ko\":\"박수갈채(구름)\",\"zh_hant\":\"拍手喝采（雲）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":42,\"param1\":42,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"43\":{\"effect_description\":{\"ja\":\"私たちはライバル！\",\"en\":\"We Are Rivals!\",\"ko\":\"우리는 라이벌!\",\"zh_hant\":\"我們是勁敵！\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":43,\"param1\":43,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"44\":{\"effect_description\":{\"ja\":\"燦然たる王威\",\"en\":\"Royal Authority\",\"ko\":\"찬란한 왕의 위엄\",\"zh_hant\":\"璀璨的王之威光\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":44,\"param1\":44,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"45\":{\"effect_description\":{\"ja\":\"魅惑の瞳\",\"en\":\"Captivating Pupils\",\"ko\":\"매혹의 눈동자\",\"zh_hant\":\"魅惑的眼眸\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":45,\"param1\":45,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"46\":{\"effect_description\":{\"ja\":\"神々の黄昏\",\"en\":\"Twilight of the Gods\",\"ko\":\"신들의 황혼\",\"zh_hant\":\"諸神黃昏\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":46,\"param1\":46,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"48\":{\"effect_description\":{\"ja\":\"ここが舞台だ\",\"en\":\"This Is the Stage\",\"ko\":\"여기가 무대다\",\"zh_hant\":\"這裡是舞台\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":48,\"param1\":48,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"49\":{\"effect_description\":{\"ja\":\"ジュ・テーム\",\"en\":\"Je T'Aime\",\"ko\":\"쥬뗌므\",\"zh_hant\":\"Je t'aime\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":49,\"param1\":49,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"50\":{\"effect_description\":{\"ja\":\"嘆きの傷痕\",\"en\":\"Scar of Grief\",\"ko\":\"비탄의 상흔\",\"zh_hant\":\"悲嘆的傷痕\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":50,\"param1\":50,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"51\":{\"effect_description\":{\"ja\":\"散華のさだめ\",\"en\":\"Tragic Fate\",\"ko\":\"산화의 숙명\",\"zh_hant\":\"光榮犧牲的宿命\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":51,\"param1\":51,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"52\":{\"effect_description\":{\"ja\":\"神授の力\",\"en\":\"Divine Power\",\"ko\":\"신이 내린 힘\",\"zh_hant\":\"神授之力\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":52,\"param1\":52,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"53\":{\"effect_description\":{\"ja\":\"威風凛々\",\"en\":\"Majestic\",\"ko\":\"위풍당당\",\"zh_hant\":\"威風凛凛\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":53,\"param1\":53,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"54\":{\"effect_description\":{\"ja\":\"遅疑逡巡\",\"en\":\"Hesitation\",\"ko\":\"의심과 망설임\",\"zh_hant\":\"遲疑不定\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":54,\"param1\":54,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"55\":{\"effect_description\":{\"ja\":\"心躍る芳醇\",\"en\":\"Mellow Flavor\",\"ko\":\"마음 들뜨는 향긋함\",\"zh_hant\":\"心悸的香醇\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":55,\"param1\":55,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"56\":{\"effect_description\":{\"ja\":\"甘き堕落\",\"en\":\"Sugary Corruption\",\"ko\":\"달콤한 타락\",\"zh_hant\":\"甘美墮落\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":56,\"param1\":56,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"57\":{\"effect_description\":{\"ja\":\"深淵なる謀\",\"en\":\"Plan of the Abyss\",\"ko\":\"심연의 계략\",\"zh_hant\":\"深謀遠慮\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":57,\"param1\":57,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"58\":{\"effect_description\":{\"ja\":\"黄金の活力\",\"en\":\"Golden Vitality\",\"ko\":\"황금의 활력\",\"zh_hant\":\"黃金活力\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":58,\"param1\":58,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"59\":{\"effect_description\":{\"ja\":\"賢者の契り\",\"en\":\"Pledge of the Sage\",\"ko\":\"현자의 약속\",\"zh_hant\":\"賢者的契約\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":59,\"param1\":59,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"60\":{\"effect_description\":{\"ja\":\"天体ハイライト\",\"en\":\"Heavenly Highlight\",\"ko\":\"천체 하이라이트\",\"zh_hant\":\"天體注目\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":60,\"param1\":60,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"61\":{\"effect_description\":{\"ja\":\"美しく、気高く、楽しく\",\"en\":\"Grace, Nobility, Fun\",\"ko\":\"아름답게, 품위있게, 즐겁게\",\"zh_hant\":\"美麗、高貴且樂在其中\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":61,\"param1\":61,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"62\":{\"effect_description\":{\"ja\":\"幸福の足音\",\"en\":\"Happy Footsteps\",\"ko\":\"행복의 발소리\",\"zh_hant\":\"幸福的腳步聲\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":62,\"param1\":62,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"63\":{\"effect_description\":{\"ja\":\"飛躍の誓い\",\"en\":\"Leap Oath\",\"ko\":\"비약의 맹세\",\"zh_hant\":\"飛躍之誓言\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":63,\"param1\":63,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"64\":{\"effect_description\":{\"ja\":\"凶変\",\"en\":\"Calamity\",\"ko\":\"흉변\",\"zh_hant\":\"變故\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":64,\"param1\":64,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"65\":{\"effect_description\":{\"ja\":\"自縄自縛\",\"en\":\"Self Trapping\",\"ko\":\"자승자박\",\"zh_hant\":\"自作自受\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"Lv2で付与\",\"en\":\"Applies at Lv. 2\",\"ko\":\"Lv2로 부여\",\"zh_hant\":\"以Lv2的狀態賦予\"},\"icon_id\":23,\"param1\":23,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"66\":{\"effect_description\":{\"ja\":\"雷鳴\",\"en\":\"Thunder\",\"ko\":\"천둥\",\"zh_hant\":\"雷鳴\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"Lv2で付与\",\"en\":\"Applies at Lv. 2\",\"ko\":\"Lv2로 부여\",\"zh_hant\":\"以Lv2的狀態賦予\"},\"icon_id\":13,\"param1\":13,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"67\":{\"effect_description\":{\"ja\":\"拍手万雷（花）\",\"en\":\"Standing Ovation (Flower)\",\"ko\":\"박수만뢰(꽃)\",\"zh_hant\":\"掌聲如雷（花）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":65,\"param1\":65,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"68\":{\"effect_description\":{\"ja\":\"拍手万雷（風）\",\"en\":\"Standing Ovation (Wind)\",\"ko\":\"박수만뢰(바람)\",\"zh_hant\":\"掌聲如雷（風）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":66,\"param1\":66,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"71\":{\"effect_description\":{\"ja\":\"拍手万雷（宙）\",\"en\":\"Standing Ovation (Space)\",\"ko\":\"박수만뢰(우주)\",\"zh_hant\":\"掌聲如雷（宙）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":69,\"param1\":69,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"72\":{\"effect_description\":{\"ja\":\"拍手万雷（雲）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":70,\"param1\":70,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"73\":{\"effect_description\":{\"ja\":\"風雅なる誘い\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":71,\"param1\":71,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"74\":{\"effect_description\":{\"ja\":\"行雲流水\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":72,\"param1\":72,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"75\":{\"effect_description\":{\"ja\":\"キラめきの潮流\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":73,\"param1\":73,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"76\":{\"effect_description\":{\"ja\":\"戦場掌握\",\"en\":\"Battle Strategy\",\"ko\":\"전장 장악\",\"zh_hant\":\"掌握戰場\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":74,\"param1\":74,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"77\":{\"effect_description\":{\"ja\":\"戦場掌握\",\"en\":\"Battle Strategy\",\"ko\":\"전장 장악\",\"zh_hant\":\"掌握戰場\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"Lv3で付与\",\"en\":\"Applies at Lv. 3\",\"ko\":\"Lv3으로 부여\",\"zh_hant\":\"以Lv3的狀態賦予\"},\"icon_id\":74,\"param1\":74,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"78\":{\"effect_description\":{\"ja\":\"迷宮入りの予感\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":75,\"param1\":75,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"79\":{\"effect_description\":{\"ja\":\"魅惑の瞳\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"Lv2で付与\"},\"icon_id\":45,\"param1\":45,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"80\":{\"effect_description\":{\"ja\":\"百発百中、一発必中\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"Lv2で付与\"},\"icon_id\":36,\"param1\":36,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"85\":{\"effect_description\":{\"ja\":\"拍手喝采（宙）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"Lv2で付与\"},\"icon_id\":41,\"param1\":41,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"87\":{\"effect_description\":{\"ja\":\"灰色の世界\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":76,\"param1\":76,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"88\":{\"effect_description\":{\"ja\":\"トキメキ発見\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"\"},\"icon_id\":77,\"param1\":77,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"89\":{\"effect_description\":{\"ja\":\"百花繚乱\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"Lv2で付与\"},\"icon_id\":27,\"param1\":27,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"90\":{\"effect_description\":{\"ja\":\"拍手喝采（月）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"Lv2で付与\"},\"icon_id\":40,\"param1\":40,\"param1_unit\":0,\"time_unit\":0,\"type\":1,\"value_unit\":0},\"2001\":{\"effect_description\":{\"ja\":\"マイナス舞台効果Lvダウン(%value%)\",\"en\":\"Neg. Stage Effect Lv. Down (%value%)\",\"ko\":\"마이너스 무대 효과 Lv 감소(%value%)\",\"zh_hant\":\"降低負面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":47,\"param1\":1,\"param1_unit\":3,\"time_unit\":0,\"type\":2,\"value_unit\":0},\"2002\":{\"effect_description\":{\"ja\":\"プラス舞台効果Lvダウン(%value%)\",\"en\":\"Pos. Stage Effect Lv. Down (%value%)\",\"ko\":\"플러스 무대 효과 Lv 감소(%value%)\",\"zh_hant\":\"降低正面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":900,\"param1\":1,\"param1_unit\":3,\"time_unit\":0,\"type\":3,\"value_unit\":0},\"2003\":{\"effect_description\":{\"ja\":\"マイナス舞台効果Lvアップ(%value%)\",\"en\":\"Neg. Stage Effect Lv. Up (%value%)\",\"ko\":\"마이너스 무대 효과 Lv 증가(%value%)\",\"zh_hant\":\"提升負面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":0,\"param1\":1,\"param1_unit\":3,\"time_unit\":0,\"type\":4,\"value_unit\":0},\"2004\":{\"effect_description\":{\"ja\":\"プラス舞台効果Lvアップ(%value%)\",\"en\":\"Pos. Stage Effect Lv. Up (%value%)\",\"ko\":\"플러스 무대 효과 Lv 증가(%value%)\",\"zh_hant\":\"提升正面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":0,\"param1\":1,\"param1_unit\":3,\"time_unit\":0,\"type\":5,\"value_unit\":0},\"2005\":{\"effect_description\":{\"ja\":\"マイナス舞台効果Lvダウン(%value%)\",\"en\":\"Neg. Stage Effect Lv. Down (%value%)\",\"ko\":\"마이너스 무대 효과 Lv 감소(%value%)\",\"zh_hant\":\"降低負面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":47,\"param1\":2,\"param1_unit\":3,\"time_unit\":0,\"type\":2,\"value_unit\":0},\"2006\":{\"effect_description\":{\"ja\":\"プラス舞台効果Lvダウン(%value%)\",\"en\":\"Pos. Stage Effect Lv. Down (%value%)\",\"ko\":\"플러스 무대 효과 Lv 감소(%value%)\",\"zh_hant\":\"降低正面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":900,\"param1\":2,\"param1_unit\":3,\"time_unit\":0,\"type\":3,\"value_unit\":0},\"2007\":{\"effect_description\":{\"ja\":\"マイナス舞台効果Lvアップ(%value%)\",\"en\":\"Neg. Stage Effect Lv. Up (%value%)\",\"ko\":\"마이너스 무대 효과 Lv 증가(%value%)\",\"zh_hant\":\"提升負面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect02\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":0,\"param1\":2,\"param1_unit\":3,\"time_unit\":0,\"type\":4,\"value_unit\":0},\"2008\":{\"effect_description\":{\"ja\":\"プラス舞台効果Lvアップ(%value%)\",\"en\":\"Pos. Stage Effect Lv. Up (%value%)\",\"ko\":\"플러스 무대 효과 Lv 증가(%value%)\",\"zh_hant\":\"提升正面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":0,\"param1\":2,\"param1_unit\":3,\"time_unit\":0,\"type\":5,\"value_unit\":0},\"2009\":{\"effect_description\":{\"ja\":\"マイナス舞台効果Lvダウン(%value%)\",\"en\":\"Neg. Stage Effect Lv. Down (%value%)\",\"ko\":\"마이너스 무대 효과 Lv 감소(%value%)\",\"zh_hant\":\"降低負面舞台效果Lv（%value%）\"},\"effect_name\":\"hit_stage_effect01\",\"extra_description\":{\"ja\":\"直近付与された舞台効果%param1%\",\"en\":\"Most Recent Stage Effect %param1%\",\"ko\":\"최근에 부여된 무대 효과 %param1%\",\"zh_hant\":\"最新被賦予的舞台效果%param1%\"},\"icon_id\":47,\"param1\":3,\"param1_unit\":3,\"time_unit\":0,\"type\":2,\"value_unit\":0}}")
