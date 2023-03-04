@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenPassiveSkill(
    val description: Map<String, String>,
    val icon_id: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_values: List<Int>,
    val skill_option2_id: Int,
    val skill_option2_target_id: Int,
    val skill_option2_values: List<Int>,
    val skill_option3_id: Int,
    val skill_option3_target_id: Int,
    val skill_option3_values: List<Int>,
    val skill_option4_id: Int,
    val skill_option4_target_id: Int,
    val skill_option4_values: List<Int>,
    val skill_option5_id: Int,
    val skill_option5_target_id: Int,
    val skill_option5_values: List<Int>,
    val _id_: Int
)

/*
101:
  _id_: 101
  description:
    en: If your actions become restricted, you will get temporary immunity to status
      effects of the same type.
    ja: 行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。
    ko: 행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다
    zh_hant: 若是被限制行動或是陷入無法行動的狀態，會暫時無法讓敵人陷入同種的異常狀態。
  icon_id: 90
  skill_option1_id: 90
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
102:
  _id_: 102
  description:
    en: Recover 50 Brilliance each turn.
    ja: 毎ターンキラめきが50回復する
    ko: 매 턴마다 반짝임을 50 회복
    zh_hant: 每回合的光芒回復50
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
103:
  _id_: 103
  description:
    en: Recover 30 Brilliance each turn.
    ja: 毎ターンキラめきが30回復する
    ko: 매 턴마다 반짝임을 30 회복
    zh_hant: 每回合的光芒回復30
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
104:
  _id_: 104
  description:
    en: Recover 80 Brilliance each turn.
    ja: 毎ターンキラめきが80回復する
    ko: 매 턴마다 반짝임을 80 회복
    zh_hant: 每回合的光芒回復80
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 80
  - 80
  - 80
  - 80
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
105:
  _id_: 105
  description:
    en: Recover 100 Brilliance each turn.
    ja: 毎ターンキラめきが100回復する
    ko: 매 턴마다 반짝임을 100 회복
    zh_hant: 每回合的光芒回復100
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
106:
  _id_: 106
  description:
    en: If your actions become restricted, you will get temporary immunity to status
      effects of the same type.
    ja: 行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。
    ko: 행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다
    zh_hant: 若是被限制行動或是陷入無法行動的狀態時，暫時不會再中同種的異常狀態。
  icon_id: 90
  skill_option1_id: 90
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
107:
  _id_: 107
  description:
    en: If your actions become restricted, you will get temporary immunity to status
      effects of the same type.
    ja: 行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。
    ko: 행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다
    zh_hant: 若是被限制行動或是陷入無法行動的狀態時，暫時不會再中同種的異常狀態。
  icon_id: 90
  skill_option1_id: 90
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
801:
  _id_: 801
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
802:
  _id_: 802
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
803:
  _id_: 803
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
804:
  _id_: 804
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
805:
  _id_: 805
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 200
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
806:
  _id_: 806
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 300
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
901:
  _id_: 901
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 0
  - 0
  - 0
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
902:
  _id_: 902
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 0
  - 0
  - 0
  - 60
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
903:
  _id_: 903
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 0
  - 0
  - 0
  - 80
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
904:
  _id_: 904
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 40
  - 0
  - 0
  - 0
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
905:
  _id_: 905
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 0
  - 0
  - 0
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
906:
  _id_: 906
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1001:
  _id_: 1001
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 10
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1002:
  _id_: 1002
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1003:
  _id_: 1003
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1004:
  _id_: 1004
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1005:
  _id_: 1005
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 249
  skill_option2_target_id: 1002
  skill_option2_values:
  - 30
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1006:
  _id_: 1006
  description:
    en: ''
    ja: '-'
    ko: ''
    zh_hant: ''
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 500
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1007:
  _id_: 1007
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1008:
  _id_: 1008
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 200
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1009:
  _id_: 1009
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 40
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1010:
  _id_: 1010
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 123
  skill_option1_target_id: 1002
  skill_option1_values:
  - 200
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1011:
  _id_: 1011
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 123
  skill_option1_target_id: 1002
  skill_option1_values:
  - 250
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1012:
  _id_: 1012
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 123
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1101:
  _id_: 1101
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 53
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 300
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1201:
  _id_: 1201
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 466
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1202:
  _id_: 1202
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 467
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1203:
  _id_: 1203
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 200
  - 200
  - 200
  - 200
  - 200
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 20
  - 20
  - 20
  - 20
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 20
  - 20
  - 20
  - 20
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 20
  - 20
  - 20
  - 20
  - 0
1204:
  _id_: 1204
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 400
  - 400
  - 400
  - 400
  - 400
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 40
  - 40
  - 40
  - 40
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 40
  - 40
  - 40
  - 40
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 40
  - 40
  - 40
  - 40
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 40
  - 40
  - 40
  - 40
  - 0
1205:
  _id_: 1205
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 800
  - 800
  - 800
  - 800
  - 800
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 80
  - 80
  - 80
  - 80
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 80
  - 80
  - 80
  - 80
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 80
  - 80
  - 80
  - 80
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 80
  - 80
  - 80
  - 80
  - 0
1206:
  _id_: 1206
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2500
  - 2500
  - 2500
  - 2500
  - 2500
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 200
  - 200
  - 200
  - 200
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 200
  - 200
  - 200
  - 200
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 200
  - 200
  - 200
  - 200
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 200
  - 200
  - 200
  - 200
  - 0
1207:
  _id_: 1207
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5000
  - 5000
  - 5000
  - 5000
  - 5000
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
1208:
  _id_: 1208
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 468
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20000
  - 20000
  - 20000
  - 20000
  - 20000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1211:
  _id_: 1211
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 55
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20000
  - 20000
  - 20000
  - 20000
  - 20000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1212:
  _id_: 1212
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 259
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 80
  - 80
  - 80
  - 80
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1213:
  _id_: 1213
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 150
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1214:
  _id_: 1214
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 435
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1215:
  _id_: 1215
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 464
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1216:
  _id_: 1216
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 300
  - 300
  - 300
  - 300
  - 300
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 30
  - 30
  - 30
  - 30
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 30
  - 30
  - 30
  - 30
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 30
  - 30
  - 30
  - 30
  - 0
1217:
  _id_: 1217
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 750
  - 750
  - 750
  - 750
  - 750
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 60
  - 60
  - 60
  - 60
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 60
  - 60
  - 60
  - 60
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 60
  - 60
  - 60
  - 60
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 60
  - 60
  - 60
  - 60
  - 0
1218:
  _id_: 1218
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1200
  - 1200
  - 1200
  - 1200
  - 1200
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 120
  - 120
  - 120
  - 120
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 120
  - 120
  - 120
  - 120
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 120
  - 120
  - 120
  - 120
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 120
  - 120
  - 120
  - 120
  - 0
1219:
  _id_: 1219
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3750
  - 3750
  - 3750
  - 3750
  - 3750
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 300
  - 300
  - 300
  - 300
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 300
  - 300
  - 300
  - 300
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 300
  - 300
  - 300
  - 300
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 300
  - 300
  - 300
  - 300
  - 0
1220:
  _id_: 1220
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7500
  - 7500
  - 7500
  - 7500
  - 7500
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
1221:
  _id_: 1221
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 468
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50000
  - 50000
  - 50000
  - 50000
  - 50000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1222:
  _id_: 1222
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 468
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100000
  - 100000
  - 100000
  - 100000
  - 100000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1223:
  _id_: 1223
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 259
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1224:
  _id_: 1224
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 259
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
1225:
  _id_: 1225
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15000
  - 15000
  - 15000
  - 15000
  - 15000
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
1226:
  _id_: 1226
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30000
  - 30000
  - 30000
  - 30000
  - 30000
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
1227:
  _id_: 1227
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 45000
  - 45000
  - 45000
  - 45000
  - 45000
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
1228:
  _id_: 1228
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 0
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 75000
  - 75000
  - 75000
  - 75000
  - 75000
  skill_option2_id: 10
  skill_option2_target_id: 1001
  skill_option2_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option3_id: 12
  skill_option3_target_id: 1001
  skill_option3_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option4_id: 14
  skill_option4_target_id: 1001
  skill_option4_values:
  - 500
  - 500
  - 500
  - 500
  - 0
  skill_option5_id: 8
  skill_option5_target_id: 1001
  skill_option5_values:
  - 500
  - 500
  - 500
  - 500
  - 0
10001:
  _id_: 10001
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 3
  - 3
  - 3
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10002:
  _id_: 10002
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 3
  - 3
  - 3
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10003:
  _id_: 10003
  description:
    en: (Passive) Climax Act Power +%opt1_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10004:
  _id_: 10004
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 60
  - 90
  - 130
  - 160
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10005:
  _id_: 10005
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10006:
  _id_: 10006
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10007:
  _id_: 10007
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10008:
  _id_: 10008
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 4
  - 4
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10009:
  _id_: 10009
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10010:
  _id_: 10010
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10011:
  _id_: 10011
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10012:
  _id_: 10012
  description:
    en: (Passive) Climax Act Power +%opt1_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10013:
  _id_: 10013
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10014:
  _id_: 10014
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10015:
  _id_: 10015
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10016:
  _id_: 10016
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10017:
  _id_: 10017
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10018:
  _id_: 10018
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10019:
  _id_: 10019
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10020:
  _id_: 10020
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10021:
  _id_: 10021
  description:
    en: (Passive) Climax Act Power +%opt1_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10022:
  _id_: 10022
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10023:
  _id_: 10023
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10024:
  _id_: 10024
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10025:
  _id_: 10025
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10026:
  _id_: 10026
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10027:
  _id_: 10027
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10029:
  _id_: 10029
  description:
    en: (Passive) Damage dealt +%opt1_value%% & damage Received -%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & 被ダメージダウン %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 받는 대미지 %opt2_value%% 감소'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 降低受到的傷害 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 126
  skill_option2_target_id: 1001
  skill_option2_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10030:
  _id_: 10030
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Climax Act Power +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クライマックスACT威力アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 클라이맥스 ACT 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 40
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10031:
  _id_: 10031
  description:
    en: (Passive) Damage dealt +%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]与ダメージアップ %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10032:
  _id_: 10032
  description:
    en: (Passive) Damage dealt +%opt1_value%% & get %opt2_value% Brilliance each turn
    ja: '[永続]与ダメージアップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10033:
  _id_: 10033
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10034:
  _id_: 10034
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10035:
  _id_: 10035
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10036:
  _id_: 10036
  description:
    en: (Passive) Damage dealt +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10037:
  _id_: 10037
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Perfect Aim
    ja: '[永続]与ダメージアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10038:
  _id_: 10038
  description:
    en: (Passive) Damage Received -%opt1_value%% & Climax Act Power +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クライマックスACT威力アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 클라이맥스 ACT 위력 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 40
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10039:
  _id_: 10039
  description:
    en: (Passive) Damage Received -%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]被ダメージダウン %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10040:
  _id_: 10040
  description:
    en: (Passive) Damage Received -%opt1_value%% & get %opt2_value% Brilliance each
      turn
    ja: '[永続]被ダメージダウン %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10041:
  _id_: 10041
  description:
    en: (Passive) Damage Received -%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10042:
  _id_: 10042
  description:
    en: (Passive) Damage Received -%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10043:
  _id_: 10043
  description:
    en: (Passive) Damage Received -%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10044:
  _id_: 10044
  description:
    en: (Passive) Damage Received -%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10045:
  _id_: 10045
  description:
    en: (Passive) Damage Received -%opt1_value%% & Perfect Aim
    ja: '[永続]被ダメージダウン %opt1_value%% & 必中状態になる '
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 백발백중 상태가 된다'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 5
  - 5
  - 6
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10046:
  _id_: 10046
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10047:
  _id_: 10047
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & get %opt2_value% Brilliance each
      turn
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10048:
  _id_: 10048
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10049:
  _id_: 10049
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10050:
  _id_: 10050
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10051:
  _id_: 10051
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10052:
  _id_: 10052
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Perfect Aim
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 賦予必中狀態'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10053:
  _id_: 10053
  description:
    en: (Passive) Recover %opt1_value% HP each turn & get %opt2_value% Brilliance
      each turn
    ja: '[永続]毎ターンHP回復 %opt1_value% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 每回合獲得光芒 %opt2_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10054:
  _id_: 10054
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Critical +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升會心威力 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10055:
  _id_: 10055
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Dexterity +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升會心率 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10056:
  _id_: 10056
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Agility +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & すばやさアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升敏捷 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10057:
  _id_: 10057
  description:
    en: (Passive) Recover %opt1_value% HP each turn & effective element damage +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10058:
  _id_: 10058
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Perfect Aim
    ja: '[永続]毎ターンHP回復 %opt1_value% & 必中状態になる '
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 백발백중 상태가 된다'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 賦予必中狀態'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 110
  - 150
  - 200
  - 240
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10059:
  _id_: 10059
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Critical +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心威力 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10060:
  _id_: 10060
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Dexterity +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10061:
  _id_: 10061
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Agility +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & すばやさアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升敏捷 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10062:
  _id_: 10062
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & effective element damage
      +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10063:
  _id_: 10063
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Perfect Aim
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & 必中状態になる '
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 백발백중 상태가 된다'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 賦予必中狀態'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 3
  - 3
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10064:
  _id_: 10064
  description:
    en: (Passive) Critical +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10065:
  _id_: 10065
  description:
    en: (Passive) Critical +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10066:
  _id_: 10066
  description:
    en: (Passive) Critical +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10067:
  _id_: 10067
  description:
    en: (Passive) Critical +%opt1_value%% & Perfect Aim
    ja: '[永続]クリティカル威力アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 백발백중 상태가 된다'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 賦予必中狀態'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 20
  - 22
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10068:
  _id_: 10068
  description:
    en: (Passive) Dexterity +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10069:
  _id_: 10069
  description:
    en: (Passive) Dexterity up %opt1_value%% & Effective element damage up %opt2_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%%  증가 & 유리한 속성 대미지 %opt2_value%%  증가'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10070:
  _id_: 10070
  description:
    en: (Passive) Dexterity +%opt1_value%% & Perfect Aim
    ja: '[永続]クリティカル率アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 賦予必中狀態'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10071:
  _id_: 10071
  description:
    en: (Passive) Agility +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]すばやさアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10072:
  _id_: 10072
  description:
    en: (Passive) Agility +%opt1_value%% & Perfect Aim
    ja: '[永続]すばやさアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 민첩 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升敏捷 %opt1_value%% & 賦予必中狀態'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10073:
  _id_: 10073
  description:
    en: (Passive) Effective element damage +%opt1_value%% & Perfect Aim
    ja: '[永続]有利属性ダメージアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 7
  - 8
  - 9
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10074:
  _id_: 10074
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10075:
  _id_: 10075
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10076:
  _id_: 10076
  description:
    en: (Passive) Climax Act Power +%opt1_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10077:
  _id_: 10077
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 160
  - 220
  - 280
  - 340
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10078:
  _id_: 10078
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10079:
  _id_: 10079
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 26
  - 29
  - 31
  - 34
  - 37
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10080:
  _id_: 10080
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 15
  - 17
  - 18
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10081:
  _id_: 10081
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10082:
  _id_: 10082
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10083:
  _id_: 10083
  description:
    en: (Passive) Damage dealt +%opt1_value%% & damage Received -%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & 被ダメージダウン %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 받는 대미지 %opt2_value%% 감소'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 降低受到的傷害 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 126
  skill_option2_target_id: 1001
  skill_option2_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10084:
  _id_: 10084
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Climax Act Power +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クライマックスACT威力アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 클라이맥스 ACT 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 40
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10085:
  _id_: 10085
  description:
    en: (Passive) Damage dealt +%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]与ダメージアップ %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10086:
  _id_: 10086
  description:
    en: (Passive) Damage dealt +%opt1_value%% & get %opt2_value% Brilliance each turn
    ja: '[永続]与ダメージアップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10087:
  _id_: 10087
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10088:
  _id_: 10088
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10089:
  _id_: 10089
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10090:
  _id_: 10090
  description:
    en: (Passive) Damage dealt +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]与ダメージアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10091:
  _id_: 10091
  description:
    en: (Passive) Damage dealt +%opt1_value%% & Perfect Aim
    ja: '[永続]与ダメージアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10092:
  _id_: 10092
  description:
    en: (Passive) Damage Received -%opt1_value%% & Climax Act Power +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クライマックスACT威力アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 클라이맥스 ACT 위력 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 40
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10093:
  _id_: 10093
  description:
    en: (Passive) Damage Received -%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]被ダメージダウン %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10094:
  _id_: 10094
  description:
    en: (Passive) Damage Received -%opt1_value%% & get %opt2_value% Brilliance each
      turn
    ja: '[永続]被ダメージダウン %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10095:
  _id_: 10095
  description:
    en: (Passive) Damage Received -%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10096:
  _id_: 10096
  description:
    en: (Passive) Damage Received -%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10097:
  _id_: 10097
  description:
    en: (Passive) Damage Received -%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10098:
  _id_: 10098
  description:
    en: (Passive) Damage Received -%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]被ダメージダウン %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10099:
  _id_: 10099
  description:
    en: (Passive) Damage Received -%opt1_value%% & Perfect Aim
    ja: '[永続]被ダメージダウン %opt1_value%% & 必中状態になる '
    ko: '[영구] 받는 대미지 %opt1_value%% 감소 & 백발백중 상태가 된다'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 6
  - 6
  - 7
  - 8
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10100:
  _id_: 10100
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & recover %opt2_value% HP each turn
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンHP回復 %opt2_value%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合HP回復 %opt2_value%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10101:
  _id_: 10101
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & get %opt2_value% Brilliance each
      turn
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合獲得光芒 %opt2_value%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10102:
  _id_: 10102
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Critical +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心威力 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10103:
  _id_: 10103
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10104:
  _id_: 10104
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10105:
  _id_: 10105
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10106:
  _id_: 10106
  description:
    en: (Passive) Climax Act Power +%opt1_value%% & Perfect Aim
    ja: '[永続]クライマックスACT威力アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升CLIMAX ACT威力 %opt1_value%% & 賦予必中狀態'
  icon_id: 40
  skill_option1_id: 40
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10107:
  _id_: 10107
  description:
    en: (Passive) Recover %opt1_value% HP each turn & get %opt2_value% Brilliance
      each turn
    ja: '[永続]毎ターンHP回復 %opt1_value% & 毎ターンキラめき獲得 %opt2_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 매 턴마다 반짝임 %opt2_value% 획득'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 每回合獲得光芒 %opt2_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 29
  skill_option2_target_id: 1001
  skill_option2_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10108:
  _id_: 10108
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Critical +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升會心威力 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10109:
  _id_: 10109
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Dexterity +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升會心率 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10110:
  _id_: 10110
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Agility +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & すばやさアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升敏捷 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10111:
  _id_: 10111
  description:
    en: (Passive) Recover %opt1_value% HP each turn & effective element damage +%opt2_value%%
    ja: '[永続]毎ターンHP回復 %opt1_value% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10112:
  _id_: 10112
  description:
    en: (Passive) Recover %opt1_value% HP each turn & Perfect Aim
    ja: '[永続]毎ターンHP回復 %opt1_value% & 必中状態になる '
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복 & 백발백중 상태가 된다'
    zh_hant: '[永續]每回合HP回復 %opt1_value% & 賦予必中狀態'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 140
  - 190
  - 240
  - 290
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10113:
  _id_: 10113
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Critical +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心威力 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10114:
  _id_: 10114
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Dexterity +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10115:
  _id_: 10115
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Agility +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & すばやさアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升敏捷 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10116:
  _id_: 10116
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & effective element damage
      +%opt2_value%%
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10117:
  _id_: 10117
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn & Perfect Aim
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & 必中状態になる '
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 백발백중 상태가 된다'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 賦予必中狀態'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 4
  - 4
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10118:
  _id_: 10118
  description:
    en: (Passive) Critical +%opt1_value%% & Dexterity +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升會心率 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10119:
  _id_: 10119
  description:
    en: (Passive) Critical +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10120:
  _id_: 10120
  description:
    en: (Passive) Critical +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10121:
  _id_: 10121
  description:
    en: (Passive) Critical +%opt1_value%% & Perfect Aim
    ja: '[永続]クリティカル威力アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가& 백발백중 상태가 된다'
    zh_hant: '[永續]提升會心威力 %opt1_value%% & 賦予必中狀態'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 21
  - 23
  - 25
  - 27
  - 30
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10122:
  _id_: 10122
  description:
    en: (Passive) Dexterity +%opt1_value%% & Agility +%opt2_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%% & すばやさアップ %opt2_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 提升敏捷 %opt2_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10123:
  _id_: 10123
  description:
    en: (Passive) Dexterity up %opt1_value%% & Effective element damage up %opt2_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%%  증가 & 유리한 속성 대미지 %opt2_value%%  증가'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10124:
  _id_: 10124
  description:
    en: (Passive) Dexterity +%opt1_value%% & Perfect Aim
    ja: '[永続]クリティカル率アップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升會心率 %opt1_value%% & 賦予必中狀態'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 12
  - 13
  - 14
  - 16
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10125:
  _id_: 10125
  description:
    en: (Passive) Agility +%opt1_value%% & effective element damage +%opt2_value%%
    ja: '[永続]すばやさアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option2_id: 39
  skill_option2_target_id: 1001
  skill_option2_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10126:
  _id_: 10126
  description:
    en: (Passive) Agility +%opt1_value%% & Perfect Aim
    ja: '[永続]すばやさアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 민첩 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升敏捷 %opt1_value%% & 賦予必中狀態'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 9
  - 10
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10127:
  _id_: 10127
  description:
    en: (Passive) Effective element damage +%opt1_value%% & Perfect Aim
    ja: '[永続]有利属性ダメージアップ %opt1_value%% & 必中状態になる '
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%% & 賦予必中狀態'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 9
  - 10
  - 11
  - 12
  skill_option2_id: 35
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10128:
  _id_: 10128
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Soldiers
    ja: '[永続]ソルジャー特攻 %opt1_value%%'
    ko: '[영구] 솔저 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]士兵特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 113
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10129:
  _id_: 10129
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Lancers
    ja: '[永続]ランサー特攻 %opt1_value%%'
    ko: '[영구] 랜서 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]槍兵特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 114
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10130:
  _id_: 10130
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Fencers
    ja: '[永続]フェンサー特攻 %opt1_value%%'
    ko: '[영구] 펜서 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]劍兵特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 115
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10131:
  _id_: 10131
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Magicians
    ja: '[永続]マジシャン特攻 %opt1_value%%'
    ko: '[영구] 매지션 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]魔法師特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 116
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10132:
  _id_: 10132
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Shielders
    ja: '[永続]シールダー特攻 %opt1_value%%'
    ko: '[영구] 실더 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]盾兵特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 117
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10133:
  _id_: 10133
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Gunners
    ja: '[永続]ガンナー特攻 %opt1_value%%'
    ko: '[영구] 거너 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]砲兵特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 118
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10134:
  _id_: 10134
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Jokers
    ja: '[永続]奇術師特攻 %opt1_value%%'
    ko: '[영구] 기술사 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]奇術士特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 119
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10135:
  _id_: 10135
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Beasts
    ja: '[永続]ビースト特攻 %opt1_value%%'
    ko: '[영구] 비스트 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]野獸特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 120
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10136:
  _id_: 10136
  description:
    en: (Passive) %opt1_value%% bonus damage vs. ???
    ja: '[永続]？？？特攻 %opt1_value%%'
    ko: '[영구] ??? 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]？？？特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 121
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10137:
  _id_: 10137
  description:
    en: (Passive) %opt1_value%% bonus damage vs. Material
    ja: '[永続]マテリアル特攻 %opt1_value%%'
    ko: '[영구] 머티리얼 대상 특수 공격 %opt1_value%% 증가'
    zh_hant: '[永續]材料特攻 %opt1_value%%'
  icon_id: 10007
  skill_option1_id: 122
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 75
  - 75
  - 75
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10138:
  _id_: 10138
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10139:
  _id_: 10139
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10140:
  _id_: 10140
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10141:
  _id_: 10141
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10142:
  _id_: 10142
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10143:
  _id_: 10143
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10144:
  _id_: 10144
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10145:
  _id_: 10145
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10146:
  _id_: 10146
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10147:
  _id_: 10147
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10148:
  _id_: 10148
  description:
    en: (Passive) Flower damage Received -%opt1_value%%
    ja: '[永続]花属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 꽃 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少花屬性造成的傷害  %opt1_value%%'
  icon_id: 10
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10149:
  _id_: 10149
  description:
    en: (Passive) Absorb %opt1_value%% damage dealt as HP
    ja: '[永続]与ダメージ吸収  %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 흡수'
    zh_hant: '[永續]吸收傷害  %opt1_value%%'
  icon_id: 44
  skill_option1_id: 44
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10150:
  _id_: 10150
  description:
    en: (Passive) Wind damage Received -%opt1_value%%
    ja: '[永続]風属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 바람 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少風屬性造成的傷害  %opt1_value%%'
  icon_id: 10
  skill_option1_id: 67
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10151:
  _id_: 10151
  description:
    en: (Passive) Snow damage Received -%opt1_value%%
    ja: '[永続]雪属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 눈 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少雪屬性造成的傷害  %opt1_value%%'
  icon_id: 10
  skill_option1_id: 68
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10152:
  _id_: 10152
  description:
    en: (Passive) Moon damage Received -%opt1_value%%.
    ja: '[永続]月属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 달 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少月屬性造成的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 69
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10153:
  _id_: 10153
  description:
    en: (Passive) Space damage Received -%opt1_value%%.
    ja: '[永続]宙属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 우주 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少宙屬性造成的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 70
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10154:
  _id_: 10154
  description:
    en: (Passive) Cloud damage Received -%opt1_value%%.
    ja: '[永続]雲属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 구름 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少雲屬性造成的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 71
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10155:
  _id_: 10155
  description:
    en: (Passive) Dream damage Received -%opt1_value%%.
    ja: '[永続]夢属性からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 꿈 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少夢屬性造成的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 72
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10156:
  _id_: 10156
  description:
    en: Applies %opt1_value%% Action Restriction Resistance
    ja: 行動制限/行動不能体性を付与  %opt1_value%%
    ko: 행동 제한/행동 불능 저항을 부여 %opt1_value%%
    zh_hant: 賦予%opt1_value%%限制行動/無法行動耐性
  icon_id: 10
  skill_option1_id: 238
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
10157:
  _id_: 10157
  description:
    en: (Passive) Aggro Resistance %opt1_value%
    ja: '[永続]ターゲット固定耐性 %opt1_value%'
    ko: '[영구] 타깃 고정 저항 %opt1_value%'
    zh_hant: '[永續]目標鎖定耐性 %opt1_value%'
  icon_id: 153
  skill_option1_id: 153
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12001:
  _id_: 12001
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12002:
  _id_: 12002
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12003:
  _id_: 12003
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12004:
  _id_: 12004
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12005:
  _id_: 12005
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12006:
  _id_: 12006
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12007:
  _id_: 12007
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 7
  - 7
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12008:
  _id_: 12008
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12009:
  _id_: 12009
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 9
  - 9
  - 9
  - 9
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12010:
  _id_: 12010
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12011:
  _id_: 12011
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 11
  - 11
  - 11
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12012:
  _id_: 12012
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12013:
  _id_: 12013
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 13
  - 13
  - 13
  - 13
  - 13
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12014:
  _id_: 12014
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12015:
  _id_: 12015
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12016:
  _id_: 12016
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12017:
  _id_: 12017
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 17
  - 17
  - 17
  - 17
  - 17
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12018:
  _id_: 12018
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12019:
  _id_: 12019
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 19
  - 19
  - 19
  - 19
  - 19
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12020:
  _id_: 12020
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12021:
  _id_: 12021
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12022:
  _id_: 12022
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12023:
  _id_: 12023
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12024:
  _id_: 12024
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12025:
  _id_: 12025
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12026:
  _id_: 12026
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12027:
  _id_: 12027
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 7
  - 7
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12028:
  _id_: 12028
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12029:
  _id_: 12029
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 9
  - 9
  - 9
  - 9
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12030:
  _id_: 12030
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12031:
  _id_: 12031
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 11
  - 11
  - 11
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12032:
  _id_: 12032
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12033:
  _id_: 12033
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 13
  - 13
  - 13
  - 13
  - 13
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12034:
  _id_: 12034
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12035:
  _id_: 12035
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12036:
  _id_: 12036
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12037:
  _id_: 12037
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 17
  - 17
  - 17
  - 17
  - 17
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12038:
  _id_: 12038
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12039:
  _id_: 12039
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 19
  - 19
  - 19
  - 19
  - 19
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12040:
  _id_: 12040
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12041:
  _id_: 12041
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12042:
  _id_: 12042
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12043:
  _id_: 12043
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12044:
  _id_: 12044
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12045:
  _id_: 12045
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12046:
  _id_: 12046
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12047:
  _id_: 12047
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 7
  - 7
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12048:
  _id_: 12048
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12049:
  _id_: 12049
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 9
  - 9
  - 9
  - 9
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12050:
  _id_: 12050
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12051:
  _id_: 12051
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 11
  - 11
  - 11
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12052:
  _id_: 12052
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12053:
  _id_: 12053
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 13
  - 13
  - 13
  - 13
  - 13
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12054:
  _id_: 12054
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12055:
  _id_: 12055
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12056:
  _id_: 12056
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12057:
  _id_: 12057
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 17
  - 17
  - 17
  - 17
  - 17
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12058:
  _id_: 12058
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12059:
  _id_: 12059
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 19
  - 19
  - 19
  - 19
  - 19
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12060:
  _id_: 12060
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12061:
  _id_: 12061
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12062:
  _id_: 12062
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12063:
  _id_: 12063
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12064:
  _id_: 12064
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12065:
  _id_: 12065
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12066:
  _id_: 12066
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12067:
  _id_: 12067
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 7
  - 7
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12068:
  _id_: 12068
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12069:
  _id_: 12069
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 9
  - 9
  - 9
  - 9
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12070:
  _id_: 12070
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12071:
  _id_: 12071
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 11
  - 11
  - 11
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12072:
  _id_: 12072
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12073:
  _id_: 12073
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 13
  - 13
  - 13
  - 13
  - 13
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12074:
  _id_: 12074
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12075:
  _id_: 12075
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12076:
  _id_: 12076
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12077:
  _id_: 12077
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 17
  - 17
  - 17
  - 17
  - 17
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12078:
  _id_: 12078
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12079:
  _id_: 12079
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 19
  - 19
  - 19
  - 19
  - 19
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12080:
  _id_: 12080
  description:
    en: (Passive) Critical +%opt1_value%%
    ja: '[永続]クリティカル威力アップ %opt1_value%%'
    ko: '[영구] 크리티컬 위력 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心威力 %opt1_value%%'
  icon_id: 22
  skill_option1_id: 22
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12081:
  _id_: 12081
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12082:
  _id_: 12082
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12083:
  _id_: 12083
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12084:
  _id_: 12084
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12085:
  _id_: 12085
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12086:
  _id_: 12086
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12087:
  _id_: 12087
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 7
  - 7
  - 7
  - 7
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12088:
  _id_: 12088
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12089:
  _id_: 12089
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 9
  - 9
  - 9
  - 9
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12090:
  _id_: 12090
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12091:
  _id_: 12091
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 11
  - 11
  - 11
  - 11
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12092:
  _id_: 12092
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12093:
  _id_: 12093
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 13
  - 13
  - 13
  - 13
  - 13
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12094:
  _id_: 12094
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12095:
  _id_: 12095
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12096:
  _id_: 12096
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12097:
  _id_: 12097
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 17
  - 17
  - 17
  - 17
  - 17
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12098:
  _id_: 12098
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12099:
  _id_: 12099
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 19
  - 19
  - 19
  - 19
  - 19
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12100:
  _id_: 12100
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12101:
  _id_: 12101
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12102:
  _id_: 12102
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 200
  - 200
  - 200
  - 200
  - 200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12103:
  _id_: 12103
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 300
  - 300
  - 300
  - 300
  - 300
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12104:
  _id_: 12104
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 400
  - 400
  - 400
  - 400
  - 400
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12105:
  _id_: 12105
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 500
  - 500
  - 500
  - 500
  - 500
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12106:
  _id_: 12106
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 600
  - 600
  - 600
  - 600
  - 600
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12107:
  _id_: 12107
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 700
  - 700
  - 700
  - 700
  - 700
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12108:
  _id_: 12108
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 800
  - 800
  - 800
  - 800
  - 800
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12109:
  _id_: 12109
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 900
  - 900
  - 900
  - 900
  - 900
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12110:
  _id_: 12110
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1000
  - 1000
  - 1000
  - 1000
  - 1000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12111:
  _id_: 12111
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1100
  - 1100
  - 1100
  - 1100
  - 1100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12112:
  _id_: 12112
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1200
  - 1200
  - 1200
  - 1200
  - 1200
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12113:
  _id_: 12113
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1300
  - 1300
  - 1300
  - 1300
  - 1300
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12114:
  _id_: 12114
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1400
  - 1400
  - 1400
  - 1400
  - 1400
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12115:
  _id_: 12115
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1500
  - 1500
  - 1500
  - 1500
  - 1500
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12116:
  _id_: 12116
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1600
  - 1600
  - 1600
  - 1600
  - 1600
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12117:
  _id_: 12117
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1700
  - 1700
  - 1700
  - 1700
  - 1700
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12118:
  _id_: 12118
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1800
  - 1800
  - 1800
  - 1800
  - 1800
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12119:
  _id_: 12119
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1900
  - 1900
  - 1900
  - 1900
  - 1900
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12120:
  _id_: 12120
  description:
    en: (Passive) Recover %opt1_value% HP each turn
    ja: '[永続]毎ターンHP回復 %opt1_value%'
    ko: '[영구] 매 턴마다 HP %opt1_value% 회복'
    zh_hant: '[永續]每回合HP回復 %opt1_value%'
  icon_id: 28
  skill_option1_id: 28
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2000
  - 2000
  - 2000
  - 2000
  - 2000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12121:
  _id_: 12121
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12122:
  _id_: 12122
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12123:
  _id_: 12123
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 6
  - 6
  - 6
  - 6
  - 6
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12124:
  _id_: 12124
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 8
  - 8
  - 8
  - 8
  - 8
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12125:
  _id_: 12125
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12126:
  _id_: 12126
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 12
  - 12
  - 12
  - 12
  - 12
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12127:
  _id_: 12127
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 14
  - 14
  - 14
  - 14
  - 14
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12128:
  _id_: 12128
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 16
  - 16
  - 16
  - 16
  - 16
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12129:
  _id_: 12129
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 18
  - 18
  - 18
  - 18
  - 18
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12130:
  _id_: 12130
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12131:
  _id_: 12131
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 22
  - 22
  - 22
  - 22
  - 22
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12132:
  _id_: 12132
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 24
  - 24
  - 24
  - 24
  - 24
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12133:
  _id_: 12133
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 26
  - 26
  - 26
  - 26
  - 26
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12134:
  _id_: 12134
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 28
  - 28
  - 28
  - 28
  - 28
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12135:
  _id_: 12135
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12136:
  _id_: 12136
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 32
  - 32
  - 32
  - 32
  - 32
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12137:
  _id_: 12137
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 34
  - 34
  - 34
  - 34
  - 34
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12138:
  _id_: 12138
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 36
  - 36
  - 36
  - 36
  - 36
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12139:
  _id_: 12139
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 38
  - 38
  - 38
  - 38
  - 38
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12140:
  _id_: 12140
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12141:
  _id_: 12141
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12142:
  _id_: 12142
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12143:
  _id_: 12143
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12144:
  _id_: 12144
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12145:
  _id_: 12145
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12146:
  _id_: 12146
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 60
  - 60
  - 60
  - 60
  - 60
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12147:
  _id_: 12147
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 70
  - 70
  - 70
  - 70
  - 70
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12148:
  _id_: 12148
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 80
  - 80
  - 80
  - 80
  - 80
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12149:
  _id_: 12149
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 90
  - 90
  - 90
  - 90
  - 90
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12150:
  _id_: 12150
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12151:
  _id_: 12151
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12152:
  _id_: 12152
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12153:
  _id_: 12153
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12154:
  _id_: 12154
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12155:
  _id_: 12155
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12156:
  _id_: 12156
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 60
  - 60
  - 60
  - 60
  - 60
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12157:
  _id_: 12157
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 70
  - 70
  - 70
  - 70
  - 70
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12158:
  _id_: 12158
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 80
  - 80
  - 80
  - 80
  - 80
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12159:
  _id_: 12159
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 90
  - 90
  - 90
  - 90
  - 90
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12160:
  _id_: 12160
  description:
    en: (Passive) %opt1_value%% more HP to all allies
    ja: '[永続]味方全体のHPアップ %opt1_value%%'
    ko: '[영구] 아군 전체의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12161:
  _id_: 12161
  description:
    en: (Passive) Effective element damage +%opt1_value%%
    ja: '[永続]有利属性ダメージアップ %opt1_value%%'
    ko: '[영구] 유리한 속성 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升有利屬性傷害 %opt1_value%%'
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12162:
  _id_: 12162
  description:
    en: (Passive) %opt1_value%% more HP to all Seisho allies
    ja: '[永続]味方の聖翔音楽学園のHPアップ %opt1_value%%'
    ko: '[영구] 아군 세이쇼 음악학교의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方聖翔音樂學院的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12163:
  _id_: 12163
  description:
    en: (Passive) %opt1_value%% more HP to all Rinmeikan allies
    ja: '[永続]味方の凛明館女学校のHPアップ %opt1_value%%'
    ko: '[영구] 아군 린메이칸 여학교의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方凜明館女子學校的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4002
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12164:
  _id_: 12164
  description:
    en: (Passive) %opt1_value%% more HP to all Frontier allies
    ja: '[永続]味方のフロンティア芸術学校のHPアップ %opt1_value%%'
    ko: '[영구] 아군 프론티어 예술학교의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方芙羅提亞藝術學校的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4003
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12165:
  _id_: 12165
  description:
    en: (Passive) %opt1_value%% more HP to all Siegfeld allies
    ja: '[永続]味方のシークフェルト音楽学院のHPアップ %opt1_value%%'
    ko: '[영구] 아군 시크펠트 음악학원의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方席格菲特音樂學院的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4004
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12166:
  _id_: 12166
  description:
    en: (Passive) %opt1_value%% more HP to all Seiran allies
    ja: '[永続]味方の青嵐総合芸術院のHPアップ %opt1_value%%'
    ko: '[영구] 아군 세이란 종합 예술학원의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方青嵐總合藝術學院的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4059
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12167:
  _id_: 12167
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Agility %opt2_value%%
    ja: '[永続]毎ターンキラめき獲得%opt1_value% すばやさアップ %opt2_value%%'
    ko: '[영구] 매 턴마다 반짝임 획득 %opt1_value%  & 민첩 증가 %opt2_value%%'
    zh_hant: '[永續]每回合獲得光芒%opt1_value% 提升敏捷 %opt2_value%%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 20
  skill_option2_id: 14
  skill_option2_target_id: 1001
  skill_option2_values:
  - 10
  - 10
  - 10
  - 10
  - 12
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12168:
  _id_: 12168
  description:
    en: (Passive) Damage Received -%opt1_value%%
    ja: '[永続]被ダメージダウン %opt1_value%%'
    ko: '[영구] 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]降低受到的傷害 %opt1_value%%'
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12169:
  _id_: 12169
  description:
    en: (Passive) Damage dealt +%opt1_value%%
    ja: '[永続]与ダメージアップ %opt1_value%%'
    ko: '[영구] 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 123
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12170:
  _id_: 12170
  description:
    en: (Passive) %opt1_value%% more HP to ally Kaoruko Hanayagi
    ja: '[永続]味方の花柳香子のHPアップ %opt1_value%%'
    ko: '[영구] 아군 하나야기 카오루코의 HP 증가 %opt1_value%%'
    zh_hant: '[永續]提升我方花柳香子的HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 2509
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12171:
  _id_: 12171
  description:
    en: (Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to
      all Rinmeikan allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 24
  skill_option2_target_id: 4002
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12172:
  _id_: 12172
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seisho allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 24
  skill_option2_target_id: 4001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12173:
  _id_: 12173
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Frontier allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 24
  skill_option2_target_id: 4003
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12174:
  _id_: 12174
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Siegfeld allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 24
  skill_option2_target_id: 4004
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12175:
  _id_: 12175
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seiran allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 24
  skill_option2_target_id: 4059
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12176:
  _id_: 12176
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seisho allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 24
  skill_option2_target_id: 4001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12177:
  _id_: 12177
  description:
    en: (Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to
      all Rinmeikan allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 24
  skill_option2_target_id: 4002
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12178:
  _id_: 12178
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Frontier allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 24
  skill_option2_target_id: 4003
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12179:
  _id_: 12179
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Siegfeld allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 24
  skill_option2_target_id: 4004
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12180:
  _id_: 12180
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seiran allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 24
  skill_option2_target_id: 4059
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12181:
  _id_: 12181
  description:
    en: (Passive) Act Power up %opt1_value%%  & Critical up %opt1_value%%  & HP up
      %opt1_value%%  & Normal Defense up %opt1_value%%  & Special Defense up %opt1_value%%
      to all allies
    ja: '[永続]味方全体のACTパワーアップ %opt1_value%% & クリティカル威力アップ %opt1_value%% & HPアップ %opt1_value%%
      & 通常防御力アップ %opt1_value%% & 特殊防御力アップ %opt1_value%%'
    ko: '[영구] 아군 전체의 ACT 파워 %opt1_value%% 증가 & 크리티컬 위력 %opt1_value%% 증가 & HP %opt1_value%%
      증가 & 일반 방어력 %opt1_value%% 증가 & 특수 방어력 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方的ACT力量%opt1_value%% &會心威力%opt1_value%% &HP提升%opt1_value%%
      &普通防禦力%opt1_value%% & 特殊防禦力%opt1_value%%'
  icon_id: 8
  skill_option1_id: 8
  skill_option1_target_id: 1002
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 22
  skill_option2_target_id: 1002
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 24
  skill_option3_target_id: 1002
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 10
  skill_option4_target_id: 1002
  skill_option4_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option5_id: 12
  skill_option5_target_id: 1002
  skill_option5_values:
  - 30
  - 30
  - 30
  - 30
  - 30
12182:
  _id_: 12182
  description:
    en: (Passive) Act Power up %opt1_value%%  & Critical up %opt1_value%%  & HP up
      %opt1_value%%  & Normal Defense up %opt1_value%%  & Special Defense up %opt1_value%%
      to self
    ja: '[永続]自身のACTパワーアップ %opt1_value%% & クリティカル威力アップ %opt1_value%% & HPアップ %opt1_value%%
      & 通常防御力アップ %opt1_value%% & 特殊防御力アップ %opt1_value%%'
    ko: '[영구] 자신의 ACT 파워 %opt1_value%% 증가 & 크리티컬 위력 %opt1_value%% 증가 & HP %opt1_value%%
      증가 & 일반 방어력 %opt1_value%% 증가 & 특수 방어력 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方的ACT力量%opt1_value%% &會心威力%opt1_value%% &HP提升%opt1_value%%
      &普通防禦力%opt1_value%% & 特殊防禦力%opt1_value%%'
  icon_id: 8
  skill_option1_id: 8
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 24
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 10
  skill_option4_target_id: 1001
  skill_option4_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option5_id: 12
  skill_option5_target_id: 1001
  skill_option5_values:
  - 30
  - 30
  - 30
  - 30
  - 30
12184:
  _id_: 12184
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 17
  - 19
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12185:
  _id_: 12185
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 22
  - 24
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12186:
  _id_: 12186
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 27
  - 29
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12187:
  _id_: 12187
  description:
    en: (Passive) Agility +%opt1_value%%
    ja: '[永続]すばやさアップ %opt1_value%%'
    ko: '[영구] 민첩 %opt1_value%% 증가'
    zh_hant: '[永續]提升敏捷 %opt1_value%%'
  icon_id: 14
  skill_option1_id: 14
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 32
  - 34
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12188:
  _id_: 12188
  description:
    en: (Passive) Get %opt1_value% Brilliance each turn
    ja: '[永続]毎ターンキラめき獲得 %opt1_value%'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value% 획득'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value%'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 12
  - 14
  - 16
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12189:
  _id_: 12189
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%
      *When equipped by Karen Aijo
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%　※愛城華恋セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※아이조 카렌에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%% ※只在與愛城華戀搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7101
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7101
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12190:
  _id_: 12190
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Hikari Kagura
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※神楽ひかりセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※카구라 히카리에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與神樂光搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7102
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7102
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12191:
  _id_: 12191
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Mahiru Tsuyuzaki
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※露崎まひるセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※츠유자키 마히루에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與露崎真晝搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7103
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7103
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12192:
  _id_: 12192
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Claudine Saijo
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※西條クロディーヌセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※사이조 클로딘에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與西條克洛迪娜搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7104
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7104
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12193:
  _id_: 12193
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Maya Tendo
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※天堂真矢セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※텐도 마야에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與天堂真矢搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7105
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7105
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12194:
  _id_: 12194
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Junna Hoshimi
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※星見純那セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※호시미 준나에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與星見純那搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7106
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7106
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12195:
  _id_: 12195
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Nana Daiba
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※大場ななセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※다이바 나나에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與大場奈奈搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7107
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7107
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12196:
  _id_: 12196
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Futaba Isurugi
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※石動双葉セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※이스루기 후타바에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與石動雙葉搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7108
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7108
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12197:
  _id_: 12197
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Kaoruko Hanayagi
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※花柳香子セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※하나야기 카오루코에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與花柳香子搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7109
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7109
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12198:
  _id_: 12198
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Tamao Tomoe
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※巴珠緒セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※토모에 타마오에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與巴珠緒搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7201
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7201
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12199:
  _id_: 12199
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Ichie Otonashi
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※音無いちえセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오토나시 이치에에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與音無一愛搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7202
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7202
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12200:
  _id_: 12200
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Fumi Yumeoji
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※夢大路文セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유메오지 후미에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與夢大路文搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7203
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7203
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12201:
  _id_: 12201
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Rui Akikaze
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※秋風塁セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※아키카제 루이에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與秋風壘搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7204
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7204
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12202:
  _id_: 12202
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Yuyuko Tanaka
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※田中ゆゆ子セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※타나카 유유코에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與田中悠悠子搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7205
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7205
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12203:
  _id_: 12203
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Aruru Otsuki
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※大月あるるセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오츠키 아루루에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與大月艾露露搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7301
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7301
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12204:
  _id_: 12204
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Misora Kano
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※叶美空セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※카노 미소라에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與葉美空搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7302
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7302
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12205:
  _id_: 12205
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Lalafin Nonomiya
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※野々宮ララフィンセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※노노미야 라라핀에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與野野宮菈樂菲搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7303
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7303
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12206:
  _id_: 12206
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Tsukasa Ebisu
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※恵比寿つかさセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※에비스 츠카사에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與惠比壽司搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7304
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7304
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12207:
  _id_: 12207
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Shizuha Kocho
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※胡蝶静羽セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※코쵸 시즈하에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與胡蝶靜羽搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7305
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7305
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12208:
  _id_: 12208
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Akira Yukishiro
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※雪代晶セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유키시로 아키라에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與雪代晶搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7401
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7401
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12209:
  _id_: 12209
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Michiru Otori
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※鳳ミチルセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오토리 미치루에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與鳳未知留搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7402
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7402
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12210:
  _id_: 12210
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Liu Mei Fan
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※リュウ・メイファンセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※류 메이팡에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與柳美帆搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7403
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7403
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12211:
  _id_: 12211
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Shiori Yumeoji
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※夢大路栞セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유메오지 시오리에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與夢大路栞搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7404
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7404
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12212:
  _id_: 12212
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Yachiyo Tsuruhime
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※鶴姫やちよセット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※츠루히메 야치요에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與鶴姬八千代搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7405
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7405
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12213:
  _id_: 12213
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Koharu Yanagi
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※柳小春セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※야나기 코하루에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與柳小春搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7501
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7501
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12214:
  _id_: 12214
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Suzu Minase
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※南風涼セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※미나세 스즈에게 장착 시에만
      발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與南風涼搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7502
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7502
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12215:
  _id_: 12215
  description:
    en: (Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When
      equipped by Hisame Honami
    ja: '[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※穂波氷雨セット時のみ発動'
    ko: '[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※호나미 히사메에게 장착
      시에만 발동'
    zh_hant: '[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與穗波冰雨搭配出場時發動'
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 7503
  skill_option1_values:
  - 20
  - 21
  - 22
  - 23
  - 25
  skill_option2_id: 20
  skill_option2_target_id: 7503
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12216:
  _id_: 12216
  description:
    en: (Passive) Damage dealt to Seisho Up %opt1_value%%
    ja: '[永続]聖翔音楽学園への与ダメージアップ %opt1_value%%'
    ko: '[영구] 세이쇼 음악학교에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對聖翔音樂學院造成的傷害%opt1_value%%'
  icon_id: 8
  skill_option1_id: 399
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12217:
  _id_: 12217
  description:
    en: (Passive) Dmg to Rinmeikan Up %opt1_value%%
    ja: '[永続]凛明館女学校への与ダメージアップ %opt1_value%%'
    ko: '[영구] 린메이칸 여학교에 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對凜明館女子學校造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 400
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12218:
  _id_: 12218
  description:
    en: (Passive) Dmg to Frontier Up %opt1_value%%
    ja: '[永続]フロンティア芸術学校への与ダメージアップ %opt1_value%%'
    ko: '[영구] 프론티어 예술학교에 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對芙羅提亞藝術學校造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 401
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12219:
  _id_: 12219
  description:
    en: (Passive) Dmg to Siegfeld Up %opt1_value%%
    ja: '[永続]シークフェルト音楽学院への与ダメージアップ %opt1_value%%'
    ko: '[영구] 시크펠트 음악학원에 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對席格菲特音樂學院造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 402
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12220:
  _id_: 12220
  description:
    en: (Passive) Dmg to Seiran Up %opt1_value%%
    ja: '[永続]青嵐総合芸術院への与ダメージアップ %opt1_value%%'
    ko: '[영구] 세이란 종합 예술학원에 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對青嵐總合藝術學院造成的傷害 %opt1_value%%'
  icon_id: 8
  skill_option1_id: 403
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12221:
  _id_: 12221
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seisho allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 24
  skill_option2_target_id: 4001
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12222:
  _id_: 12222
  description:
    en: (Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to
      all Rinmeikan allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 24
  skill_option2_target_id: 4002
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12223:
  _id_: 12223
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Frontier allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 24
  skill_option2_target_id: 4003
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12224:
  _id_: 12224
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Siegfeld allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 24
  skill_option2_target_id: 4004
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12225:
  _id_: 12225
  description:
    en: (Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all
      Seiran allies
    ja: '[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%'
    ko: '[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가'
    zh_hant: '[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1002
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 24
  skill_option2_target_id: 4059
  skill_option2_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12226:
  _id_: 12226
  description:
    en: (Passive) Countable Negative Effects Resistance %opt1_value%
    ja: '[永続]回数マイナス効果耐性 %opt1_value%'
    ko: '[영구] 횟수 마이너스 효과 저항 %opt1_value%'
    zh_hant: '[永續]次數性負面效果耐性%opt1_value%'
  icon_id: 250
  skill_option1_id: 445
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12227:
  _id_: 12227
  description:
    en: (Passive) Dexterity +%opt1_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12228:
  _id_: 12228
  description:
    en: (Passive) HP +%opt1_value%%
    ja: '[永続]HPアップ %opt1_value%%'
    ko: '[영구] HP %opt1_value%% 증가'
    zh_hant: '[永續]提升HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12229:
  _id_: 12229
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%  & Count. Negative
      Effects Resistance %opt2_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value% & 回数マイナス効果耐性 %opt2_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%  & 횟수 마이너스 효과 저항 %opt2_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%  & 次數性負面效果耐性 %opt2_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 445
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12230:
  _id_: 12230
  description:
    en: (Passive) Dexterity Up %opt1_value%%  & Critical Up %opt2_value%%
    ja: '[永続]クリティカル率アップ %opt1_value%% &クリティカル威力アップ %opt2_value%%'
    ko: '[영구] 크리티컬 확률 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가'
    zh_hant: '[永續]提升會心率 %opt1_value%%  & 提升會心威力 %opt2_value%%'
  icon_id: 20
  skill_option1_id: 20
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 22
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12231:
  _id_: 12231
  description:
    en: (Passive) HP +%opt1_value%%
    ja: '[永続]HPアップ %opt1_value%%'
    ko: '[영구] HP %opt1_value%% 증가'
    zh_hant: '[永續]提升HP %opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1000
  - 1000
  - 1000
  - 1000
  - 1000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12232:
  _id_: 12232
  description:
    en: (Passive) HP Up %opt1_value%% & Dexterity Up %opt2_value%% to Space allies
    ja: '[永続]味方の宙属性のHPアップ %opt1_value%% & クリティカル率アップ %opt2_value%%'
    ko: '[영구] 우주 속성 아군의 HP %opt1_value%%  증가 & 크리티컬 확률 %opt2_value%% 증가'
    zh_hant: '[永續]提升宙屬性我方的HP %opt1_value%%  & 會心率 %opt2_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4012
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 20
  skill_option2_target_id: 4012
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12233:
  _id_: 12233
  description:
    en: (Passive) HP Up %opt1_value%% to Seisho allies
    ja: '[永続]味方の聖翔音楽学園のHPアップ %opt1_value%%'
    ko: '[영구] 아군 세이쇼 음악학교의 HP %opt1_value%% 증가'
    zh_hant: '[永續]提升我方聖翔音樂學院的HP%opt1_value%%'
  icon_id: 223
  skill_option1_id: 24
  skill_option1_target_id: 4001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12234:
  _id_: 12234
  description:
    en: (Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self
      (%value%)
    ja: '[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)'
    ko: '[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)'
    zh_hant: '[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）'
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12235:
  _id_: 12235
  description:
    en: (Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self
      (%value%)
    ja: '[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)'
    ko: '[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)'
    zh_hant: '[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）'
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 2
  - 2
  - 2
  - 2
  - 2
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12236:
  _id_: 12236
  description:
    en: (Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self
      (%value%)
    ja: '[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)'
    ko: '[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)'
    zh_hant: '[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）'
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 3
  - 3
  - 3
  - 3
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12237:
  _id_: 12237
  description:
    en: (Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self
      (%value%)
    ja: '[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)'
    ko: '[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)'
    zh_hant: '[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）'
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 4
  - 4
  - 4
  - 4
  - 4
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12238:
  _id_: 12238
  description:
    en: (Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self
      (%value%)
    ja: '[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)'
    ko: '[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)'
    zh_hant: '[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）'
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12239:
  _id_: 12239
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 518
  skill_option1_target_id: 4013
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12240:
  _id_: 12240
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 530
  skill_option1_target_id: 4011
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12241:
  _id_: 12241
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 275
  skill_option1_id: 520
  skill_option1_target_id: 4008
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12242:
  _id_: 12242
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 275
  skill_option1_id: 535
  skill_option1_target_id: 4009
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12243:
  _id_: 12243
  description:
    en: (Passive) Cont. Negative Effects Resistance %opt1_value%  & Count. Negative
      Effects Resistance %opt2_value%
    ja: '[永続]継続マイナス効果耐性 %opt1_value% & 回数マイナス効果耐性 %opt2_value%'
    ko: '[영구] 지속 마이너스 효과 저항 %opt1_value%  & 횟수 마이너스 효과 저항 %opt2_value%'
    zh_hant: '[永續]持續性負面效果耐性 %opt1_value%  & 次數性負面效果耐性 %opt2_value%'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 445
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12244:
  _id_: 12244
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 527
  skill_option1_target_id: 4008
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12245:
  _id_: 12245
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 275
  skill_option1_id: 539
  skill_option1_target_id: 4013
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12246:
  _id_: 12246
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10007
  skill_option1_id: 469
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12247:
  _id_: 12247
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 529
  skill_option1_target_id: 4010
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12248:
  _id_: 12248
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10007
  skill_option1_id: 469
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 26
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12250:
  _id_: 12250
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 482
  skill_option1_target_id: 4087
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 482
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12251:
  _id_: 12251
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 528
  skill_option1_target_id: 4009
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12252:
  _id_: 12252
  description:
    en: '-'
    ja: '-'
    ko: '-'
    zh_hant: '-'
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12253:
  _id_: 12253
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 481
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 481
  skill_option2_target_id: 4086
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12254:
  _id_: 12254
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 279
  skill_option1_id: 476
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 94
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12255:
  _id_: 12255
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 532
  skill_option1_target_id: 4013
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12256:
  _id_: 12256
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 298
  skill_option1_id: 506
  skill_option1_target_id: 4004
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12257:
  _id_: 12257
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12258:
  _id_: 12258
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 532
  skill_option1_target_id: 4013
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12259:
  _id_: 12259
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 445
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12260:
  _id_: 12260
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 39
  skill_option1_id: 39
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 25
  - 25
  - 25
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12261:
  _id_: 12261
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 482
  skill_option1_target_id: 4087
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 482
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12262:
  _id_: 12262
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10007
  skill_option1_id: 469
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 26
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12263:
  _id_: 12263
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 296
  skill_option1_id: 510
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 20000
  - 20000
  - 20000
  - 20000
  - 20000
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12264:
  _id_: 12264
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 481
  skill_option1_target_id: 1001
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 481
  skill_option2_target_id: 4086
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 455
  skill_option3_target_id: 1001
  skill_option3_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12265:
  _id_: 12265
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 529
  skill_option1_target_id: 4010
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12266:
  _id_: 12266
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 445
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12267:
  _id_: 12267
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12268:
  _id_: 12268
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12269:
  _id_: 12269
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12270:
  _id_: 12270
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 12
  - 14
  - 16
  - 20
  skill_option2_id: 20
  skill_option2_target_id: 1001
  skill_option2_values:
  - 10
  - 11
  - 12
  - 13
  - 15
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12271:
  _id_: 12271
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10007
  skill_option1_id: 469
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 26
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12272:
  _id_: 12272
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 510
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 20000
  - 20000
  - 20000
  - 20000
  - 20000
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12273:
  _id_: 12273
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12274:
  _id_: 12274
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12275:
  _id_: 12275
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12276:
  _id_: 12276
  description:
    ja: ''
  icon_id: 296
  skill_option1_id: 510
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 28
  skill_option2_target_id: 1001
  skill_option2_values:
  - 20000
  - 20000
  - 20000
  - 20000
  - 20000
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12277:
  _id_: 12277
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10
  skill_option1_id: 126
  skill_option1_target_id: 1001
  skill_option1_values:
  - 40
  - 40
  - 40
  - 40
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12278:
  _id_: 12278
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 482
  skill_option1_target_id: 4087
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 482
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 559
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 24
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12279:
  _id_: 12279
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12280:
  _id_: 12280
  description:
    ja: ''
  icon_id: 303
  skill_option1_id: 561
  skill_option1_target_id: 1001
  skill_option1_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option2_id: 563
  skill_option2_target_id: 1001
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 455
  skill_option3_target_id: 1001
  skill_option3_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12281:
  _id_: 12281
  description:
    ja: ''
  icon_id: 267
  skill_option1_id: 531
  skill_option1_target_id: 4012
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12282:
  _id_: 12282
  description:
    ja: ''
  icon_id: 26
  skill_option1_id: 26
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 445
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12283:
  _id_: 12283
  description:
    ja: ''
  icon_id: 29
  skill_option1_id: 29
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 26
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 568
  skill_option3_target_id: 1001
  skill_option3_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option4_id: 455
  skill_option4_target_id: 1001
  skill_option4_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12284:
  _id_: 12284
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 10007
  skill_option1_id: 469
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 26
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 455
  skill_option3_target_id: 1001
  skill_option3_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12285:
  _id_: 12285
  description:
    ja: ''
  icon_id: 266
  skill_option1_id: 455
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 573
  skill_option2_target_id: 1001
  skill_option2_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option3_id: 126
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
12286:
  _id_: 12286
  description:
    en: ''
    ja: ''
    ko: ''
    zh_hant: ''
  icon_id: 267
  skill_option1_id: 481
  skill_option1_target_id: 4086
  skill_option1_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option2_id: 481
  skill_option2_target_id: 1001
  skill_option2_values:
  - 30
  - 30
  - 30
  - 30
  - 30
  skill_option3_id: 445
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 455
  skill_option4_target_id: 1001
  skill_option4_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15000:
  _id_: 15000
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15001:
  _id_: 15001
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15002:
  _id_: 15002
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15003:
  _id_: 15003
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15004:
  _id_: 15004
  description:
    en: '(Passive) Poison Resistance: %opt1_value%'
    ja: '[永続]毒耐性 %opt1_value%'
    ko: '[영구] 독 저항 %opt1_value% 증가'
    zh_hant: '[永續]中毒耐性 %opt1_value%'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15005:
  _id_: 15005
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15006:
  _id_: 15006
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15007:
  _id_: 15007
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15008:
  _id_: 15008
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15009:
  _id_: 15009
  description:
    en: '(Passive) Burn Resistance: %opt1_value%'
    ja: '[永続]火傷耐性 %opt1_value%'
    ko: '[영구] 화상 저항 %opt1_value% 증가'
    zh_hant: '[永續]燒傷耐性 %opt1_value%'
  icon_id: 92
  skill_option1_id: 92
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15010:
  _id_: 15010
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15011:
  _id_: 15011
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15012:
  _id_: 15012
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15013:
  _id_: 15013
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15014:
  _id_: 15014
  description:
    en: '(Passive) Provoke Resistance: %opt1_value%'
    ja: '[永続]挑発耐性 %opt1_value%'
    ko: '[영구] 도발 저항 %opt1_value% 증가'
    zh_hant: '[永續]挑釁耐性 %opt1_value%'
  icon_id: 93
  skill_option1_id: 93
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15015:
  _id_: 15015
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15016:
  _id_: 15016
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15017:
  _id_: 15017
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15018:
  _id_: 15018
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15019:
  _id_: 15019
  description:
    en: '(Passive) Stun Resistance: %opt1_value%'
    ja: '[永続]スタン耐性 %opt1_value%'
    ko: '[영구] 스턴 저항 %opt1_value% 증가'
    zh_hant: '[永續]暈眩耐性 %opt1_value%'
  icon_id: 94
  skill_option1_id: 94
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15020:
  _id_: 15020
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15021:
  _id_: 15021
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15022:
  _id_: 15022
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15023:
  _id_: 15023
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15024:
  _id_: 15024
  description:
    en: '(Passive) Sleep Resistance: %opt1_value%'
    ja: '[永続]睡眠耐性 %opt1_value%'
    ko: '[영구] 수면 저항 %opt1_value% 증가'
    zh_hant: '[永續]睡眠耐性 %opt1_value%'
  icon_id: 95
  skill_option1_id: 95
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15025:
  _id_: 15025
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15026:
  _id_: 15026
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15027:
  _id_: 15027
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15028:
  _id_: 15028
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15029:
  _id_: 15029
  description:
    en: '(Passive) Confusion Resistance: %opt1_value%'
    ja: '[永続]混乱耐性 %opt1_value%'
    ko: '[영구] 혼란 저항 %opt1_value% 증가'
    zh_hant: '[永續]混亂耐性 %opt1_value%'
  icon_id: 96
  skill_option1_id: 96
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15030:
  _id_: 15030
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15031:
  _id_: 15031
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15032:
  _id_: 15032
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15033:
  _id_: 15033
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15034:
  _id_: 15034
  description:
    en: '(Passive) Stop Resistance: %opt1_value%'
    ja: '[永続]ストップ耐性 %opt1_value%'
    ko: '[영구] 스톱 저항 %opt1_value% 증가'
    zh_hant: '[永續]停止耐性 %opt1_value%'
  icon_id: 97
  skill_option1_id: 97
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15035:
  _id_: 15035
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15036:
  _id_: 15036
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15037:
  _id_: 15037
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15038:
  _id_: 15038
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15039:
  _id_: 15039
  description:
    en: '(Passive) Freeze Resistance: %opt1_value%'
    ja: '[永続]凍結耐性 %opt1_value%'
    ko: '[영구] 동결 저항 %opt1_value% 증가'
    zh_hant: '[永續]凍結耐性 %opt1_value%'
  icon_id: 98
  skill_option1_id: 98
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15040:
  _id_: 15040
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15041:
  _id_: 15041
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15042:
  _id_: 15042
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15043:
  _id_: 15043
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15044:
  _id_: 15044
  description:
    en: '(Passive) Blindness Resistance: %opt1_value%'
    ja: '[永続]暗闇耐性 %opt1_value%'
    ko: '[영구] 암흑 저항 %opt1_value% 증가'
    zh_hant: '[永續]盲目耐性 %opt1_value%'
  icon_id: 99
  skill_option1_id: 99
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15045:
  _id_: 15045
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15046:
  _id_: 15046
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15047:
  _id_: 15047
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15048:
  _id_: 15048
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15049:
  _id_: 15049
  description:
    en: '(Passive) Recovery Reduction Resistance: %opt1_value%'
    ja: '[永続]回復量低下耐性 %opt1_value%'
    ko: '[영구] 회복량 감소 저항 %opt1_value% 증가'
    zh_hant: '[永續]降低回復量耐性 %opt1_value%'
  icon_id: 100
  skill_option1_id: 100
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15050:
  _id_: 15050
  description:
    en: '(Passive) Mark Resistance: %opt1_value%'
    ja: '[永続]刻印耐性 %opt1_value%'
    ko: '[영구] 각인 저항 %opt1_value% 증가'
    zh_hant: '[永續]刻印耐性 %opt1_value%'
  icon_id: 175
  skill_option1_id: 248
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 8
  - 11
  - 14
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15051:
  _id_: 15051
  description:
    en: '(Passive) Mark Resistance: %opt1_value%'
    ja: '[永続]刻印耐性 %opt1_value%'
    ko: '[영구] 각인 저항 %opt1_value% 증가'
    zh_hant: '[永續]刻印耐性 %opt1_value%'
  icon_id: 175
  skill_option1_id: 248
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 13
  - 17
  - 21
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15052:
  _id_: 15052
  description:
    en: '(Passive) Mark Resistance: %opt1_value%'
    ja: '[永続]刻印耐性 %opt1_value%'
    ko: '[영구] 각인 저항 %opt1_value% 증가'
    zh_hant: '[永續]刻印耐性 %opt1_value%'
  icon_id: 175
  skill_option1_id: 248
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 18
  - 22
  - 26
  - 30
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15053:
  _id_: 15053
  description:
    en: '(Passive) Mark Resistance: %opt1_value%'
    ja: '[永続]刻印耐性 %opt1_value%'
    ko: '[영구] 각인 저항 %opt1_value% 증가'
    zh_hant: '[永續]刻印耐性 %opt1_value%'
  icon_id: 175
  skill_option1_id: 248
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 23
  - 27
  - 31
  - 35
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
15054:
  _id_: 15054
  description:
    en: '(Passive) Mark Resistance: %opt1_value%'
    ja: '[永続]刻印耐性 %opt1_value%'
    ko: '[영구] 각인 저항 %opt1_value% 증가'
    zh_hant: '[永續]刻印耐性 %opt1_value%'
  icon_id: 175
  skill_option1_id: 248
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 28
  - 32
  - 36
  - 40
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16000:
  _id_: 16000
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Seisho Music Academy
    ja: '[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 159
  skill_option1_id: 8
  skill_option1_target_id: 4001
  skill_option1_values:
  - 1
  - 1
  - 2
  - 2
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16001:
  _id_: 16001
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Seisho Music Academy
    ja: '[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 159
  skill_option1_id: 8
  skill_option1_target_id: 4001
  skill_option1_values:
  - 3
  - 3
  - 4
  - 4
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16002:
  _id_: 16002
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Seisho Music Academy
    ja: '[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 159
  skill_option1_id: 8
  skill_option1_target_id: 4001
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16003:
  _id_: 16003
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Seisho Music Academy
    ja: '[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 159
  skill_option1_id: 8
  skill_option1_target_id: 4001
  skill_option1_values:
  - 7
  - 7
  - 8
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16004:
  _id_: 16004
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Seisho Music Academy
    ja: '[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 159
  skill_option1_id: 8
  skill_option1_target_id: 4001
  skill_option1_values:
  - 9
  - 9
  - 10
  - 10
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16005:
  _id_: 16005
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School
    ja: '[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 160
  skill_option1_id: 8
  skill_option1_target_id: 4002
  skill_option1_values:
  - 1
  - 1
  - 2
  - 2
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16006:
  _id_: 16006
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School
    ja: '[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 160
  skill_option1_id: 8
  skill_option1_target_id: 4002
  skill_option1_values:
  - 3
  - 3
  - 4
  - 4
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16007:
  _id_: 16007
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School
    ja: '[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 160
  skill_option1_id: 8
  skill_option1_target_id: 4002
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16008:
  _id_: 16008
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School
    ja: '[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 160
  skill_option1_id: 8
  skill_option1_target_id: 4002
  skill_option1_values:
  - 7
  - 7
  - 8
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16009:
  _id_: 16009
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School
    ja: '[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 160
  skill_option1_id: 8
  skill_option1_target_id: 4002
  skill_option1_values:
  - 9
  - 9
  - 10
  - 10
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16010:
  _id_: 16010
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Frontier School of Arts
    ja: '[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%'
    ko: '[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 161
  skill_option1_id: 8
  skill_option1_target_id: 4003
  skill_option1_values:
  - 1
  - 1
  - 2
  - 2
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16011:
  _id_: 16011
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Frontier School of Arts
    ja: '[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%'
    ko: '[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 161
  skill_option1_id: 8
  skill_option1_target_id: 4003
  skill_option1_values:
  - 3
  - 3
  - 4
  - 4
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16012:
  _id_: 16012
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Frontier School of Arts
    ja: '[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%'
    ko: '[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 161
  skill_option1_id: 8
  skill_option1_target_id: 4003
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16013:
  _id_: 16013
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Frontier School of Arts
    ja: '[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%'
    ko: '[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 161
  skill_option1_id: 8
  skill_option1_target_id: 4003
  skill_option1_values:
  - 7
  - 7
  - 8
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16014:
  _id_: 16014
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Frontier School of Arts
    ja: '[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%'
    ko: '[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%'
  icon_id: 161
  skill_option1_id: 8
  skill_option1_target_id: 4003
  skill_option1_values:
  - 9
  - 9
  - 10
  - 10
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16015:
  _id_: 16015
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music
    ja: '[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 162
  skill_option1_id: 8
  skill_option1_target_id: 4004
  skill_option1_values:
  - 1
  - 1
  - 2
  - 2
  - 3
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16016:
  _id_: 16016
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music
    ja: '[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 162
  skill_option1_id: 8
  skill_option1_target_id: 4004
  skill_option1_values:
  - 3
  - 3
  - 4
  - 4
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16017:
  _id_: 16017
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music
    ja: '[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 162
  skill_option1_id: 8
  skill_option1_target_id: 4004
  skill_option1_values:
  - 5
  - 5
  - 6
  - 6
  - 7
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16018:
  _id_: 16018
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music
    ja: '[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 162
  skill_option1_id: 8
  skill_option1_target_id: 4004
  skill_option1_values:
  - 7
  - 7
  - 8
  - 8
  - 9
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
16019:
  _id_: 16019
  description:
    en: (Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music
    ja: '[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%'
    ko: '[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가'
    zh_hant: '[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%'
  icon_id: 162
  skill_option1_id: 8
  skill_option1_target_id: 4004
  skill_option1_values:
  - 9
  - 9
  - 10
  - 10
  - 11
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17001:
  _id_: 17001
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 5
  - 5
  - 5
  - 5
  - 5
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17002:
  _id_: 17002
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17003:
  _id_: 17003
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 15
  - 15
  - 15
  - 15
  - 15
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17004:
  _id_: 17004
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 20
  - 20
  - 20
  - 20
  - 20
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17005:
  _id_: 17005
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 25
  - 25
  - 25
  - 25
  - 25
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17006:
  _id_: 17006
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17007:
  _id_: 17007
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17008:
  _id_: 17008
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17009:
  _id_: 17009
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1002
  skill_option1_values:
  - 1000
  - 1000
  - 1000
  - 1000
  - 1000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17010:
  _id_: 17010
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1
  - 1
  - 1
  - 1
  - 1
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17011:
  _id_: 17011
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 10
  - 10
  - 10
  - 10
  - 10
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17012:
  _id_: 17012
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
17013:
  _id_: 17013
  description:
    en: (Passive) +%opt1_value%% more damage for all allies to Event Boss
    ja: '[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%'
    ko: '[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%'
  icon_id: 10008
  skill_option1_id: 53
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1000
  - 1000
  - 1000
  - 1000
  - 1000
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18001:
  _id_: 18001
  description:
    en: (Passive) Dmg against Elements other than Flower +%opt1_value%%
    ja: '[永続]花属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 꽃 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對花屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 253
  skill_option1_id: 47
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 48
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 49
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 50
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 51
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18002:
  _id_: 18002
  description:
    en: (Passive) Dmg against Elements other than Wind +%opt1_value%%
    ja: '[永続]風属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 바람 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對風屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 254
  skill_option1_id: 46
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 48
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 49
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 50
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 51
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18003:
  _id_: 18003
  description:
    en: (Passive) Dmg against Elements other than Snow +%opt1_value%%
    ja: '[永続]雪属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 눈 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對雪屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 255
  skill_option1_id: 46
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 47
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 49
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 50
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 51
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18004:
  _id_: 18004
  description:
    en: (Passive) Dmg against Elements other than Moon +%opt1_value%%
    ja: '[永続]月属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 달 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對月屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 256
  skill_option1_id: 46
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 47
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 48
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 50
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 51
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18005:
  _id_: 18005
  description:
    en: (Passive) Dmg against Elements other than Space +%opt1_value%%
    ja: '[永続]宙属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 우주 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對宙屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 257
  skill_option1_id: 46
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 47
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 48
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 49
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 51
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18006:
  _id_: 18006
  description:
    en: (Passive) Dmg against Elements other than Cloud +%opt1_value%%
    ja: '[永続]雲属性以外への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 구름 속성 이외에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]提升對雲屬性以外的屬性所造成的傷害  %opt1_value%%'
  icon_id: 258
  skill_option1_id: 46
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 47
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 48
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 49
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 50
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18011:
  _id_: 18011
  description:
    en: (Passive) Dmg Received from Elements other than Flower -%opt1_value%%
    ja: '[永続]花属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 꽃 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少花屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 259
  skill_option1_id: 67
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 68
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 69
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 70
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 71
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18012:
  _id_: 18012
  description:
    en: (Passive) Dmg Received from Elements other than Wind -%opt1_value%%
    ja: '[永続]風属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 바람 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少風屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 260
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 68
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 69
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 70
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 71
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18013:
  _id_: 18013
  description:
    en: (Passive) Dmg Received from Elements other than Snow -%opt1_value%%
    ja: '[永続]雪属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 눈 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少雪屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 261
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 67
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 69
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 70
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 71
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18014:
  _id_: 18014
  description:
    en: (Passive) Dmg Received from Elements other than Moon -%opt1_value%%
    ja: '[永続]月属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 달 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少月屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 262
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 67
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 68
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 70
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 71
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18015:
  _id_: 18015
  description:
    en: (Passive) Dmg Received from Elements other than Space -%opt1_value%%
    ja: '[永続]宙属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 우주 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少宙屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 263
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 67
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 68
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 69
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 71
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18016:
  _id_: 18016
  description:
    en: (Passive) Dmg Received from Elements other than Cloud -%opt1_value%%
    ja: '[永続]雲属性以外からの被ダメージを減少  %opt1_value%%'
    ko: '[영구] 구름 속성에게 받는 대미지 %opt1_value%% 감소'
    zh_hant: '[永續]減少雲屬性以外的屬性造成的傷害  %opt1_value%%'
  icon_id: 264
  skill_option1_id: 66
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 67
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 68
  skill_option3_target_id: 1001
  skill_option3_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option4_id: 69
  skill_option4_target_id: 1001
  skill_option4_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option5_id: 70
  skill_option5_target_id: 1001
  skill_option5_values:
  - 50
  - 50
  - 50
  - 50
  - 50
18017:
  _id_: 18017
  description:
    en: (Passive) Dmg Received from Elements other than Dream -%opt1_value%%, Dmg
      against Dream +%opt1_value%%
    ja: '[永続]夢属性からの被ダメージを減少  %opt1_value%%、夢属性への与ダメージを上昇  %opt1_value%%'
    ko: '[영구] 꿈 속성에게 받는 대미지 %opt1_value%% 감소, 꿈 속성에게 가하는 대미지 %opt1_value%% 증가'
    zh_hant: '[永續]減少夢屬性造成的傷害 %opt1_value%%，並提高對夢屬性所造成的傷害%opt1_value%%'
  icon_id: 52
  skill_option1_id: 52
  skill_option1_target_id: 1001
  skill_option1_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option2_id: 72
  skill_option2_target_id: 1001
  skill_option2_values:
  - 50
  - 50
  - 50
  - 50
  - 50
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18021:
  _id_: 18021
  description:
    en: (Special) Poison & Burn Resistance
    ja: '[特殊]毒&火傷耐性'
    ko: '[특수]독&화상 저항'
    zh_hant: '[特殊]中毒&燒傷耐性'
  icon_id: 91
  skill_option1_id: 91
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 92
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18022:
  _id_: 18022
  description:
    en: '[Special] Poison & Burn & Confusion & Stun & Blindness Resistance & Sleep
      & Freeze & Stop'
    ja: '[特殊]毒&火傷＆混乱＆スタン＆暗闇耐性＆睡眠＆凍結＆ストップ'
    ko: '[특수] 독 & 화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱'
    zh_hant: '[特殊]中毒耐性&燒傷耐性&混亂耐性&暈眩耐性&盲目耐性&睡眠耐性&凍結耐性&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 255
  - 255
  - 255
  - 255
  - 255
  skill_option2_id: 0
  skill_option2_target_id: 0
  skill_option2_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18023:
  _id_: 18023
  description:
    en: '[Special] AP Up & Act Seal Resistance'
    ja: '[特殊]AP増加耐性&ACT封印耐性'
    ko: '[특수] AP 증가 저항 & ACT 봉인 저항'
    zh_hant: '[特殊]AP增加耐性&ACT封印耐性'
  icon_id: 225
  skill_option1_id: 225
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 253
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 254
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 255
  skill_option4_target_id: 1001
  skill_option4_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18024:
  _id_: 18024
  description:
    en: '[Special] Strong Poison & Heavy Burn & Confusion & Sleep & Freeze & Stop
      Resistance'
    ja: '[特殊]猛毒&大火傷&混乱&睡眠&凍結&ストップ'
    ko: '[특수] 맹독 & 대화상 & 혼란 & 수면 & 동결 & 스톱'
    zh_hant: '[特殊]猛毒&嚴重燒傷&混亂&睡眠&凍結&停止'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 120
  - 120
  - 120
  - 120
  - 120
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18025:
  _id_: 18025
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Sleep
      & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&混乱&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 123
  - 123
  - 123
  - 123
  - 123
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18026:
  _id_: 18026
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun &
      Blindness & Sleep & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&暗闇&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&盲目&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 255
  - 255
  - 255
  - 255
  - 255
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18027:
  _id_: 18027
  description:
    en: (Special) Strong Poison & Heavy Burn Resistance
    ja: '[特殊]猛毒&大火傷耐性'
    ko: '[특수] 맹독 & 대화상 저항'
    zh_hant: '[特殊]猛毒&嚴重燒傷耐性'
  icon_id: 91
  skill_option1_id: 318
  skill_option1_target_id: 1001
  skill_option1_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option2_id: 319
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 0
  skill_option3_target_id: 0
  skill_option3_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18028:
  _id_: 18028
  description:
    en: '[Special] Strong Poison & Heavy Burn & Confusion & Stun & Blindness & Sleep
      & Stop Resistance'
    ja: '[特殊]猛毒&大火傷&混乱&スタン&暗闇&睡眠&ストップ耐性'
    ko: '[특수] 맹독 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 스톱 저항'
    zh_hant: '[特殊]猛毒&嚴重燒傷&混亂&暈眩&盲目&睡眠&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 188
  - 188
  - 188
  - 188
  - 188
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18029:
  _id_: 18029
  description:
    en: '[Special] Strong Poison & Heavy Burn & Stun & Sleep & Confusion & Stop &
      Freeze & Blindness Resistance'
    ja: '[特殊]猛毒&大火傷&スタン＆睡眠＆混乱＆ストップ＆凍結＆暗闇耐性'
    ko: '[특수] 맹독 & 대화상 & 스턴 & 수면 & 혼란 & 스톱 & 동결 & 암흑 저항'
    zh_hant: '[特殊]猛毒&嚴重燒傷&暈眩&睡眠&混亂&停止&凍結&盲目耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 252
  - 252
  - 252
  - 252
  - 252
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18030:
  _id_: 18030
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun &
      Sleep & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 127
  - 127
  - 127
  - 127
  - 127
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18031:
  _id_: 18031
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Blindness & Sleep
      & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&暗闇&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 암흑 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&盲目&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 235
  - 235
  - 235
  - 235
  - 235
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18032:
  _id_: 18032
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Stun & Blindness &
      Sleep & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&スタン&暗闇&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&暈眩&盲目&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 239
  - 239
  - 239
  - 239
  - 239
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18033:
  _id_: 18033
  description:
    en: '[Special] Poison & Strong Poison & Heavy Burn & Confusion & Stun & Blindness
      & Sleep & Freeze & Stop Resistance'
    ja: '[特殊]毒&猛毒&大火傷&混乱&スタン&暗闇&睡眠&凍結&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&嚴重燒傷&混亂&暈眩&盲目&睡眠&凍結&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 253
  - 253
  - 253
  - 253
  - 253
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18034:
  _id_: 18034
  description:
    en: '[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun &
      Blindness & Sleep & Stop Resistance'
    ja: '[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&暗闇&睡眠&ストップ耐性'
    ko: '[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 스톱 저항'
    zh_hant: '[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&盲目&睡眠&停止耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 191
  - 191
  - 191
  - 191
  - 191
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0
18035:
  _id_: 18035
  description:
    en: '[Special] Strong Poison & Heavy Burn & Stun & Sleep & Confusion & Stop &
      Freeze & Blindness & Lovesickness & Electric Shock Resistance'
    ja: '[特殊]猛毒&大火傷&スタン＆睡眠＆混乱＆ストップ＆凍結＆暗闇＆恋わずらい＆感電耐性'
    ko: '[특수] 맹독 & 대화상 & 스턴 & 수면 & 혼란 & 스톱 & 동결 & 암흑 & 상사병 & 감전 저항'
    zh_hant: '[特殊]猛毒&嚴重燒傷&暈眩＆睡眠＆混亂＆停止＆凍結＆盲目＆苦戀＆感電耐性'
  icon_id: 91
  skill_option1_id: 267
  skill_option1_target_id: 1001
  skill_option1_values:
  - 1020
  - 1020
  - 1020
  - 1020
  - 1020
  skill_option2_id: 318
  skill_option2_target_id: 1001
  skill_option2_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option3_id: 319
  skill_option3_target_id: 1001
  skill_option3_values:
  - 100
  - 100
  - 100
  - 100
  - 100
  skill_option4_id: 0
  skill_option4_target_id: 0
  skill_option4_values:
  - 0
  - 0
  - 0
  - 0
  - 0
  skill_option5_id: 0
  skill_option5_target_id: 0
  skill_option5_values:
  - 0
  - 0
  - 0
  - 0
  - 0

*/

val valuesGenPassiveSkill =
    loadMasterData<GenPassiveSkill>(
        "{\"101\":{\"description\":{\"ja\":\"行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。\",\"en\":\"If your actions become restricted, you will get temporary immunity to status effects of the same type.\",\"ko\":\"행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다\",\"zh_hant\":\"若是被限制行動或是陷入無法行動的狀態，會暫時無法讓敵人陷入同種的異常狀態。\"},\"icon_id\":90,\"skill_option1_id\":90,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":101},\"102\":{\"description\":{\"ja\":\"毎ターンキラめきが50回復する\",\"en\":\"Recover 50 Brilliance each turn.\",\"ko\":\"매 턴마다 반짝임을 50 회복\",\"zh_hant\":\"每回合的光芒回復50\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":102},\"103\":{\"description\":{\"ja\":\"毎ターンキラめきが30回復する\",\"en\":\"Recover 30 Brilliance each turn.\",\"ko\":\"매 턴마다 반짝임을 30 회복\",\"zh_hant\":\"每回合的光芒回復30\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":103},\"104\":{\"description\":{\"ja\":\"毎ターンキラめきが80回復する\",\"en\":\"Recover 80 Brilliance each turn.\",\"ko\":\"매 턴마다 반짝임을 80 회복\",\"zh_hant\":\"每回合的光芒回復80\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,80,80,80,80],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":104},\"105\":{\"description\":{\"ja\":\"毎ターンキラめきが100回復する\",\"en\":\"Recover 100 Brilliance each turn.\",\"ko\":\"매 턴마다 반짝임을 100 회복\",\"zh_hant\":\"每回合的光芒回復100\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":105},\"106\":{\"description\":{\"ja\":\"行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。\",\"en\":\"If your actions become restricted, you will get temporary immunity to status effects of the same type.\",\"ko\":\"행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다\",\"zh_hant\":\"若是被限制行動或是陷入無法行動的狀態時，暫時不會再中同種的異常狀態。\"},\"icon_id\":90,\"skill_option1_id\":90,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":106},\"107\":{\"description\":{\"ja\":\"行動制限もしくは行動不能にかかると、しばらく同種の状態異常にかからなくなる。\",\"en\":\"If your actions become restricted, you will get temporary immunity to status effects of the same type.\",\"ko\":\"행동 제한 또는 행동 불능에 걸리면 한동안 같은 종류의 상태 이상에 걸리지 않는다\",\"zh_hant\":\"若是被限制行動或是陷入無法行動的狀態時，暫時不會再中同種的異常狀態。\"},\"icon_id\":90,\"skill_option1_id\":90,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":107},\"801\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":801},\"802\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":802},\"803\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":803},\"804\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":804},\"805\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[200,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":805},\"806\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[300,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":806},\"901\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,0,0,0,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":901},\"902\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,0,0,0,60],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":902},\"903\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,0,0,0,80],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":903},\"904\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[40,0,0,0,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":904},\"905\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,0,0,0,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":905},\"906\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,0,0,0,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":906},\"1001\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[10,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1001},\"1002\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1002},\"1003\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1003},\"1004\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1004},\"1005\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,0,0,0,0],\"skill_option2_id\":249,\"skill_option2_target_id\":1002,\"skill_option2_values\":[30,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1005},\"1006\":{\"description\":{\"ja\":\"-\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[500,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1006},\"1007\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1007},\"1008\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[200,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1008},\"1009\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[40,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1009},\"1010\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":123,\"skill_option1_target_id\":1002,\"skill_option1_values\":[200,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1010},\"1011\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":123,\"skill_option1_target_id\":1002,\"skill_option1_values\":[250,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1011},\"1012\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":123,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1012},\"1101\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":53,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[300,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1101},\"1201\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":466,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1201},\"1202\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":467,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1202},\"1203\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[200,200,200,200,200],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[20,20,20,20,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[20,20,20,20,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[20,20,20,20,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[20,20,20,20,0],\"_id_\":1203},\"1204\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[400,400,400,400,400],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[40,40,40,40,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[40,40,40,40,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[40,40,40,40,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[40,40,40,40,0],\"_id_\":1204},\"1205\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[800,800,800,800,800],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[80,80,80,80,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[80,80,80,80,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[80,80,80,80,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[80,80,80,80,0],\"_id_\":1205},\"1206\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2500,2500,2500,2500,2500],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[200,200,200,200,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[200,200,200,200,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[200,200,200,200,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[200,200,200,200,0],\"_id_\":1206},\"1207\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5000,5000,5000,5000,5000],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1207},\"1208\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":468,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20000,20000,20000,20000,20000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1208},\"1211\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":55,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20000,20000,20000,20000,20000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1211},\"1212\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":259,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,80,80,80,80],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1212},\"1213\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":150,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1213},\"1214\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":435,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1214},\"1215\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":464,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1215},\"1216\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[300,300,300,300,300],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[30,30,30,30,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[30,30,30,30,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[30,30,30,30,0],\"_id_\":1216},\"1217\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[750,750,750,750,750],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[60,60,60,60,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[60,60,60,60,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[60,60,60,60,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[60,60,60,60,0],\"_id_\":1217},\"1218\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1200,1200,1200,1200,1200],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[120,120,120,120,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[120,120,120,120,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[120,120,120,120,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[120,120,120,120,0],\"_id_\":1218},\"1219\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3750,3750,3750,3750,3750],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[300,300,300,300,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[300,300,300,300,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[300,300,300,300,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[300,300,300,300,0],\"_id_\":1219},\"1220\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7500,7500,7500,7500,7500],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1220},\"1221\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":468,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50000,50000,50000,50000,50000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1221},\"1222\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":468,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100000,100000,100000,100000,100000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1222},\"1223\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":259,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1223},\"1224\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":259,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":1224},\"1225\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15000,15000,15000,15000,15000],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1225},\"1226\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30000,30000,30000,30000,30000],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1226},\"1227\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[45000,45000,45000,45000,45000],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1227},\"1228\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":0,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[75000,75000,75000,75000,75000],\"skill_option2_id\":10,\"skill_option2_target_id\":1001,\"skill_option2_values\":[500,500,500,500,0],\"skill_option3_id\":12,\"skill_option3_target_id\":1001,\"skill_option3_values\":[500,500,500,500,0],\"skill_option4_id\":14,\"skill_option4_target_id\":1001,\"skill_option4_values\":[500,500,500,500,0],\"skill_option5_id\":8,\"skill_option5_target_id\":1001,\"skill_option5_values\":[500,500,500,500,0],\"_id_\":1228},\"10001\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,3,3,3,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10001},\"10002\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,3,3,3,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10002},\"10003\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10003},\"10004\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[60,90,130,160,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10004},\"10005\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10005},\"10006\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,11,12,13,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10006},\"10007\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10007},\"10008\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,4,4,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10008},\"10009\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10009},\"10010\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10010},\"10011\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10011},\"10012\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10012},\"10013\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10013},\"10014\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10014},\"10015\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,20,22],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10015},\"10016\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10016},\"10017\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10017},\"10018\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10018},\"10019\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10019},\"10020\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10020},\"10021\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10021},\"10022\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10022},\"10023\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10023},\"10024\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[21,23,25,27,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10024},\"10025\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,12,13,14,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10025},\"10026\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,8,9,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10026},\"10027\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10027},\"10029\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 被ダメージダウン %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & damage Received -%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 받는 대미지 %opt2_value%% 감소\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 降低受到的傷害 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":126,\"skill_option2_target_id\":1001,\"skill_option2_values\":[4,4,5,5,6],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10029},\"10030\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クライマックスACT威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Climax Act Power +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 클라이맥스 ACT 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":40,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10030},\"10031\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[70,110,150,200,240],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10031},\"10032\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[2,2,2,3,3],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10032},\"10033\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[15,17,19,20,22],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10033},\"10034\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10034},\"10035\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10035},\"10036\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10036},\"10037\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10037},\"10038\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クライマックスACT威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Climax Act Power +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 클라이맥스 ACT 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":40,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10038},\"10039\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[70,110,150,200,240],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10039},\"10040\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[2,2,2,3,3],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10040},\"10041\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[15,17,19,20,22],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10041},\"10042\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10042},\"10043\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10043},\"10044\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10044},\"10045\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Damage Received -%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,5,5,6],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10045},\"10046\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[70,110,150,200,240],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10046},\"10047\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[2,2,2,3,3],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10047},\"10048\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[15,17,19,20,22],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10048},\"10049\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10049},\"10050\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10050},\"10051\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10051},\"10052\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10052},\"10053\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[2,2,2,3,3],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10053},\"10054\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Critical +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升會心威力 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[15,17,19,20,22],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10054},\"10055\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升會心率 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10055},\"10056\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Agility +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升敏捷 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10056},\"10057\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10057},\"10058\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 必中状態になる \",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Perfect Aim\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 賦予必中狀態\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,110,150,200,240],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10058},\"10059\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Critical +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心威力 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[15,17,19,20,22],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10059},\"10060\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10060},\"10061\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Agility +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升敏捷 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10061},\"10062\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10062},\"10063\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & 必中状態になる \",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Perfect Aim\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 賦予必中狀態\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,3,3],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10063},\"10064\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,20,22],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10064},\"10065\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,20,22],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10065},\"10066\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,20,22],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10066},\"10067\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Critical +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,20,22],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10067},\"10068\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,5,6,6,7],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10068},\"10069\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Dexterity up %opt1_value%% & Effective element damage up %opt2_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%%  증가 & 유리한 속성 대미지 %opt2_value%%  증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10069},\"10070\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Dexterity +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10070},\"10071\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Agility +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[6,6,7,8,9],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10071},\"10072\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Agility +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10072},\"10073\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Effective element damage +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,7,8,9],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10073},\"10074\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,8,9,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10074},\"10075\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,8,9,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10075},\"10076\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,11,12,13,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10076},\"10077\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,160,220,280,340],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10077},\"10078\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10078},\"10079\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[26,29,31,34,37],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10079},\"10080\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,15,17,18,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10080},\"10081\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10081},\"10082\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,11,12,13,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10082},\"10083\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 被ダメージダウン %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & damage Received -%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 받는 대미지 %opt2_value%% 감소\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 降低受到的傷害 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":126,\"skill_option2_target_id\":1001,\"skill_option2_values\":[5,6,6,7,8],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10083},\"10084\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クライマックスACT威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Climax Act Power +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 클라이맥스 ACT 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":40,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10084},\"10085\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[80,140,190,240,290],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10085},\"10086\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[3,3,3,4,4],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10086},\"10087\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[21,23,25,27,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10087},\"10088\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10088},\"10089\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10089},\"10090\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10090},\"10091\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Damage dealt +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10091},\"10092\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クライマックスACT威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Climax Act Power +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 클라이맥스 ACT 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升CLIMAX ACT威力 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":40,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10092},\"10093\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[80,140,190,240,290],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10093},\"10094\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[3,3,3,4,4],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10094},\"10095\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[21,23,25,27,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10095},\"10096\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10096},\"10097\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10097},\"10098\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10098},\"10099\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Damage Received -%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,6,6,7,8],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10099},\"10100\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンHP回復 %opt2_value%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & recover %opt2_value% HP each turn\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 HP %opt2_value% 회복\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合HP回復 %opt2_value%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[80,140,190,240,290],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10100},\"10101\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[3,3,3,4,4],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10101},\"10102\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Critical +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心威力 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[21,23,25,27,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10102},\"10103\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10103},\"10104\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10104},\"10105\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10105},\"10106\":{\"description\":{\"ja\":\"[永続]クライマックスACT威力アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Climax Act Power +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 클라이맥스 ACT 위력 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升CLIMAX ACT威力 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":40,\"skill_option1_id\":40,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10106},\"10107\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 毎ターンキラめき獲得 %opt2_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & get %opt2_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 매 턴마다 반짝임 %opt2_value% 획득\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 每回合獲得光芒 %opt2_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":29,\"skill_option2_target_id\":1001,\"skill_option2_values\":[3,3,3,4,4],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10107},\"10108\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Critical +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升會心威力 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[21,23,25,27,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10108},\"10109\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升會心率 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10109},\"10110\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Agility +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升敏捷 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10110},\"10111\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10111},\"10112\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value% & 必中状態になる \",\"en\":\"(Passive) Recover %opt1_value% HP each turn & Perfect Aim\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value% & 賦予必中狀態\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,140,190,240,290],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10112},\"10113\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Critical +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心威力 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[21,23,25,27,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10113},\"10114\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10114},\"10115\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Agility +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升敏捷 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10115},\"10116\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10116},\"10117\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & 必中状態になる \",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn & Perfect Aim\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 賦予必中狀態\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,4,4],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10117},\"10118\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & Dexterity +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升會心率 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[21,23,25,27,30],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[11,12,13,14,16],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10118},\"10119\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[21,23,25,27,30],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10119},\"10120\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Critical +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[21,23,25,27,30],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10120},\"10121\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Critical +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가& 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[21,23,25,27,30],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10121},\"10122\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%% & Agility +%opt2_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가 & 민첩 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 提升敏捷 %opt2_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,12,13,14,16],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[7,7,8,9,10],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10122},\"10123\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Dexterity up %opt1_value%% & Effective element damage up %opt2_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%%  증가 & 유리한 속성 대미지 %opt2_value%%  증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,12,13,14,16],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10123},\"10124\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Dexterity +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,12,13,14,16],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10124},\"10125\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%% & 有利属性ダメージアップ %opt2_value%%\",\"en\":\"(Passive) Agility +%opt1_value%% & effective element damage +%opt2_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가 & 유리한 속성 대미지 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%% & 提升有利屬性傷害 %opt2_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,8,9,10],\"skill_option2_id\":39,\"skill_option2_target_id\":1001,\"skill_option2_values\":[8,9,10,11,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10125},\"10126\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Agility +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,8,9,10],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10126},\"10127\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%% & 必中状態になる \",\"en\":\"(Passive) Effective element damage +%opt1_value%% & Perfect Aim\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가 & 백발백중 상태가 된다\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%% & 賦予必中狀態\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,9,10,11,12],\"skill_option2_id\":35,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10127},\"10128\":{\"description\":{\"ja\":\"[永続]ソルジャー特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Soldiers\",\"ko\":\"[영구] 솔저 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]士兵特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":113,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10128},\"10129\":{\"description\":{\"ja\":\"[永続]ランサー特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Lancers\",\"ko\":\"[영구] 랜서 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]槍兵特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":114,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10129},\"10130\":{\"description\":{\"ja\":\"[永続]フェンサー特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Fencers\",\"ko\":\"[영구] 펜서 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]劍兵特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":115,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10130},\"10131\":{\"description\":{\"ja\":\"[永続]マジシャン特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Magicians\",\"ko\":\"[영구] 매지션 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]魔法師特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":116,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10131},\"10132\":{\"description\":{\"ja\":\"[永続]シールダー特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Shielders\",\"ko\":\"[영구] 실더 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]盾兵特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":117,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10132},\"10133\":{\"description\":{\"ja\":\"[永続]ガンナー特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Gunners\",\"ko\":\"[영구] 거너 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]砲兵特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":118,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10133},\"10134\":{\"description\":{\"ja\":\"[永続]奇術師特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Jokers\",\"ko\":\"[영구] 기술사 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]奇術士特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":119,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10134},\"10135\":{\"description\":{\"ja\":\"[永続]ビースト特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Beasts\",\"ko\":\"[영구] 비스트 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]野獸特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":120,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10135},\"10136\":{\"description\":{\"ja\":\"[永続]？？？特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. ???\",\"ko\":\"[영구] ??? 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]？？？特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":121,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10136},\"10137\":{\"description\":{\"ja\":\"[永続]マテリアル特攻 %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% bonus damage vs. Material\",\"ko\":\"[영구] 머티리얼 대상 특수 공격 %opt1_value%% 증가\",\"zh_hant\":\"[永續]材料特攻 %opt1_value%%\"},\"icon_id\":10007,\"skill_option1_id\":122,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,75,75,75,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10137},\"10138\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10138},\"10139\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10139},\"10140\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10140},\"10141\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10141},\"10142\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10142},\"10143\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10143},\"10144\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10144},\"10145\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10145},\"10146\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10146},\"10147\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10147},\"10148\":{\"description\":{\"ja\":\"[永続]花属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Flower damage Received -%opt1_value%%\",\"ko\":\"[영구] 꽃 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少花屬性造成的傷害  %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10148},\"10149\":{\"description\":{\"ja\":\"[永続]与ダメージ吸収  %opt1_value%%\",\"en\":\"(Passive) Absorb %opt1_value%% damage dealt as HP\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 흡수\",\"zh_hant\":\"[永續]吸收傷害  %opt1_value%%\"},\"icon_id\":44,\"skill_option1_id\":44,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10149},\"10150\":{\"description\":{\"ja\":\"[永続]風属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Wind damage Received -%opt1_value%%\",\"ko\":\"[영구] 바람 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少風屬性造成的傷害  %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":67,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10150},\"10151\":{\"description\":{\"ja\":\"[永続]雪属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Snow damage Received -%opt1_value%%\",\"ko\":\"[영구] 눈 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少雪屬性造成的傷害  %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":68,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10151},\"10152\":{\"description\":{\"ja\":\"[永続]月属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Moon damage Received -%opt1_value%%.\",\"ko\":\"[영구] 달 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少月屬性造成的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":69,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10152},\"10153\":{\"description\":{\"ja\":\"[永続]宙属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Space damage Received -%opt1_value%%.\",\"ko\":\"[영구] 우주 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少宙屬性造成的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":70,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10153},\"10154\":{\"description\":{\"ja\":\"[永続]雲属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Cloud damage Received -%opt1_value%%.\",\"ko\":\"[영구] 구름 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少雲屬性造成的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":71,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10154},\"10155\":{\"description\":{\"ja\":\"[永続]夢属性からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dream damage Received -%opt1_value%%.\",\"ko\":\"[영구] 꿈 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少夢屬性造成的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":72,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10155},\"10156\":{\"description\":{\"ja\":\"行動制限/行動不能体性を付与  %opt1_value%%\",\"en\":\"Applies %opt1_value%% Action Restriction Resistance\",\"ko\":\"행동 제한/행동 불능 저항을 부여 %opt1_value%%\",\"zh_hant\":\"賦予%opt1_value%%限制行動/無法行動耐性\"},\"icon_id\":10,\"skill_option1_id\":238,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10156},\"10157\":{\"description\":{\"ja\":\"[永続]ターゲット固定耐性 %opt1_value%\",\"en\":\"(Passive) Aggro Resistance %opt1_value%\",\"ko\":\"[영구] 타깃 고정 저항 %opt1_value%\",\"zh_hant\":\"[永續]目標鎖定耐性 %opt1_value%\"},\"icon_id\":153,\"skill_option1_id\":153,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":10157},\"12001\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12001},\"12002\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12002},\"12003\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12003},\"12004\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12004},\"12005\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12005},\"12006\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12006},\"12007\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,7,7,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12007},\"12008\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12008},\"12009\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[9,9,9,9,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12009},\"12010\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12010},\"12011\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,11,11,11,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12011},\"12012\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12012},\"12013\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[13,13,13,13,13],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12013},\"12014\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12014},\"12015\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12015},\"12016\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12016},\"12017\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[17,17,17,17,17],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12017},\"12018\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12018},\"12019\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[19,19,19,19,19],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12019},\"12020\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12020},\"12021\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12021},\"12022\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12022},\"12023\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12023},\"12024\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12024},\"12025\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12025},\"12026\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12026},\"12027\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,7,7,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12027},\"12028\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12028},\"12029\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[9,9,9,9,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12029},\"12030\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12030},\"12031\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,11,11,11,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12031},\"12032\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12032},\"12033\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[13,13,13,13,13],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12033},\"12034\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12034},\"12035\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12035},\"12036\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12036},\"12037\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[17,17,17,17,17],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12037},\"12038\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12038},\"12039\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[19,19,19,19,19],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12039},\"12040\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12040},\"12041\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12041},\"12042\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12042},\"12043\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12043},\"12044\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12044},\"12045\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12045},\"12046\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12046},\"12047\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,7,7,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12047},\"12048\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12048},\"12049\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[9,9,9,9,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12049},\"12050\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12050},\"12051\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,11,11,11,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12051},\"12052\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12052},\"12053\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[13,13,13,13,13],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12053},\"12054\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12054},\"12055\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12055},\"12056\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12056},\"12057\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[17,17,17,17,17],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12057},\"12058\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12058},\"12059\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[19,19,19,19,19],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12059},\"12060\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12060},\"12061\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12061},\"12062\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12062},\"12063\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12063},\"12064\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12064},\"12065\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12065},\"12066\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12066},\"12067\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,7,7,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12067},\"12068\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12068},\"12069\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[9,9,9,9,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12069},\"12070\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12070},\"12071\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,11,11,11,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12071},\"12072\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12072},\"12073\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[13,13,13,13,13],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12073},\"12074\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12074},\"12075\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12075},\"12076\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12076},\"12077\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[17,17,17,17,17],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12077},\"12078\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12078},\"12079\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[19,19,19,19,19],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12079},\"12080\":{\"description\":{\"ja\":\"[永続]クリティカル威力アップ %opt1_value%%\",\"en\":\"(Passive) Critical +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 위력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心威力 %opt1_value%%\"},\"icon_id\":22,\"skill_option1_id\":22,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12080},\"12081\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12081},\"12082\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12082},\"12083\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12083},\"12084\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12084},\"12085\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12085},\"12086\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12086},\"12087\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[7,7,7,7,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12087},\"12088\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12088},\"12089\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[9,9,9,9,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12089},\"12090\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12090},\"12091\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[11,11,11,11,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12091},\"12092\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12092},\"12093\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[13,13,13,13,13],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12093},\"12094\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12094},\"12095\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12095},\"12096\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12096},\"12097\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[17,17,17,17,17],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12097},\"12098\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12098},\"12099\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[19,19,19,19,19],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12099},\"12100\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12100},\"12101\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12101},\"12102\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[200,200,200,200,200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12102},\"12103\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[300,300,300,300,300],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12103},\"12104\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[400,400,400,400,400],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12104},\"12105\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[500,500,500,500,500],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12105},\"12106\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[600,600,600,600,600],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12106},\"12107\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[700,700,700,700,700],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12107},\"12108\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[800,800,800,800,800],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12108},\"12109\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[900,900,900,900,900],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12109},\"12110\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1000,1000,1000,1000,1000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12110},\"12111\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1100,1100,1100,1100,1100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12111},\"12112\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1200,1200,1200,1200,1200],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12112},\"12113\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1300,1300,1300,1300,1300],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12113},\"12114\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1400,1400,1400,1400,1400],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12114},\"12115\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1500,1500,1500,1500,1500],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12115},\"12116\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1600,1600,1600,1600,1600],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12116},\"12117\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1700,1700,1700,1700,1700],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12117},\"12118\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1800,1800,1800,1800,1800],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12118},\"12119\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1900,1900,1900,1900,1900],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12119},\"12120\":{\"description\":{\"ja\":\"[永続]毎ターンHP回復 %opt1_value%\",\"en\":\"(Passive) Recover %opt1_value% HP each turn\",\"ko\":\"[영구] 매 턴마다 HP %opt1_value% 회복\",\"zh_hant\":\"[永續]每回合HP回復 %opt1_value%\"},\"icon_id\":28,\"skill_option1_id\":28,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2000,2000,2000,2000,2000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12120},\"12121\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12121},\"12122\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12122},\"12123\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[6,6,6,6,6],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12123},\"12124\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[8,8,8,8,8],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12124},\"12125\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12125},\"12126\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[12,12,12,12,12],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12126},\"12127\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[14,14,14,14,14],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12127},\"12128\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[16,16,16,16,16],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12128},\"12129\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[18,18,18,18,18],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12129},\"12130\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12130},\"12131\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[22,22,22,22,22],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12131},\"12132\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[24,24,24,24,24],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12132},\"12133\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[26,26,26,26,26],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12133},\"12134\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[28,28,28,28,28],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12134},\"12135\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12135},\"12136\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[32,32,32,32,32],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12136},\"12137\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[34,34,34,34,34],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12137},\"12138\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[36,36,36,36,36],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12138},\"12139\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[38,38,38,38,38],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12139},\"12140\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12140},\"12141\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12141},\"12142\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12142},\"12143\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12143},\"12144\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12144},\"12145\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12145},\"12146\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[60,60,60,60,60],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12146},\"12147\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[70,70,70,70,70],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12147},\"12148\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[80,80,80,80,80],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12148},\"12149\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[90,90,90,90,90],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12149},\"12150\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12150},\"12151\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12151},\"12152\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12152},\"12153\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12153},\"12154\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12154},\"12155\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12155},\"12156\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[60,60,60,60,60],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12156},\"12157\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[70,70,70,70,70],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12157},\"12158\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[80,80,80,80,80],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12158},\"12159\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[90,90,90,90,90],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12159},\"12160\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies\",\"ko\":\"[영구] 아군 전체의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12160},\"12161\":{\"description\":{\"ja\":\"[永続]有利属性ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Effective element damage +%opt1_value%%\",\"ko\":\"[영구] 유리한 속성 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升有利屬性傷害 %opt1_value%%\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12161},\"12162\":{\"description\":{\"ja\":\"[永続]味方の聖翔音楽学園のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all Seisho allies\",\"ko\":\"[영구] 아군 세이쇼 음악학교의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方聖翔音樂學院的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12162},\"12163\":{\"description\":{\"ja\":\"[永続]味方の凛明館女学校のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all Rinmeikan allies\",\"ko\":\"[영구] 아군 린메이칸 여학교의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方凜明館女子學校的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4002,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12163},\"12164\":{\"description\":{\"ja\":\"[永続]味方のフロンティア芸術学校のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all Frontier allies\",\"ko\":\"[영구] 아군 프론티어 예술학교의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方芙羅提亞藝術學校的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4003,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12164},\"12165\":{\"description\":{\"ja\":\"[永続]味方のシークフェルト音楽学院のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all Siegfeld allies\",\"ko\":\"[영구] 아군 시크펠트 음악학원의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方席格菲特音樂學院的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4004,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12165},\"12166\":{\"description\":{\"ja\":\"[永続]味方の青嵐総合芸術院のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all Seiran allies\",\"ko\":\"[영구] 아군 세이란 종합 예술학원의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方青嵐總合藝術學院的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4059,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12166},\"12167\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得%opt1_value% すばやさアップ %opt2_value%%\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Agility %opt2_value%%\",\"ko\":\"[영구] 매 턴마다 반짝임 획득 %opt1_value%  & 민첩 증가 %opt2_value%%\",\"zh_hant\":\"[永續]每回合獲得光芒%opt1_value% 提升敏捷 %opt2_value%%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,20],\"skill_option2_id\":14,\"skill_option2_target_id\":1001,\"skill_option2_values\":[10,10,10,10,12],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12167},\"12168\":{\"description\":{\"ja\":\"[永続]被ダメージダウン %opt1_value%%\",\"en\":\"(Passive) Damage Received -%opt1_value%%\",\"ko\":\"[영구] 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]降低受到的傷害 %opt1_value%%\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12168},\"12169\":{\"description\":{\"ja\":\"[永続]与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt +%opt1_value%%\",\"ko\":\"[영구] 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":123,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12169},\"12170\":{\"description\":{\"ja\":\"[永続]味方の花柳香子のHPアップ %opt1_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to ally Kaoruko Hanayagi\",\"ko\":\"[영구] 아군 하나야기 카오루코의 HP 증가 %opt1_value%%\",\"zh_hant\":\"[永續]提升我方花柳香子的HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":2509,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12170},\"12171\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to all Rinmeikan allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":24,\"skill_option2_target_id\":4002,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12171},\"12172\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seisho allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":24,\"skill_option2_target_id\":4001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12172},\"12173\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Frontier allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":24,\"skill_option2_target_id\":4003,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12173},\"12174\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Siegfeld allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":24,\"skill_option2_target_id\":4004,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12174},\"12175\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seiran allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":24,\"skill_option2_target_id\":4059,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12175},\"12176\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seisho allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":24,\"skill_option2_target_id\":4001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12176},\"12177\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to all Rinmeikan allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":24,\"skill_option2_target_id\":4002,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12177},\"12178\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Frontier allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":24,\"skill_option2_target_id\":4003,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12178},\"12179\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Siegfeld allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":24,\"skill_option2_target_id\":4004,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12179},\"12180\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seiran allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":24,\"skill_option2_target_id\":4059,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12180},\"12181\":{\"description\":{\"ja\":\"[永続]味方全体のACTパワーアップ %opt1_value%% & クリティカル威力アップ %opt1_value%% & HPアップ %opt1_value%% & 通常防御力アップ %opt1_value%% & 特殊防御力アップ %opt1_value%%\",\"en\":\"(Passive) Act Power up %opt1_value%%  & Critical up %opt1_value%%  & HP up %opt1_value%%  & Normal Defense up %opt1_value%%  & Special Defense up %opt1_value%% to all allies\",\"ko\":\"[영구] 아군 전체의 ACT 파워 %opt1_value%% 증가 & 크리티컬 위력 %opt1_value%% 증가 & HP %opt1_value%% 증가 & 일반 방어력 %opt1_value%% 증가 & 특수 방어력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的ACT力量%opt1_value%% &會心威力%opt1_value%% &HP提升%opt1_value%% &普通防禦力%opt1_value%% & 特殊防禦力%opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":8,\"skill_option1_target_id\":1002,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":22,\"skill_option2_target_id\":1002,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":24,\"skill_option3_target_id\":1002,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":10,\"skill_option4_target_id\":1002,\"skill_option4_values\":[30,30,30,30,30],\"skill_option5_id\":12,\"skill_option5_target_id\":1002,\"skill_option5_values\":[30,30,30,30,30],\"_id_\":12181},\"12182\":{\"description\":{\"ja\":\"[永続]自身のACTパワーアップ %opt1_value%% & クリティカル威力アップ %opt1_value%% & HPアップ %opt1_value%% & 通常防御力アップ %opt1_value%% & 特殊防御力アップ %opt1_value%%\",\"en\":\"(Passive) Act Power up %opt1_value%%  & Critical up %opt1_value%%  & HP up %opt1_value%%  & Normal Defense up %opt1_value%%  & Special Defense up %opt1_value%% to self\",\"ko\":\"[영구] 자신의 ACT 파워 %opt1_value%% 증가 & 크리티컬 위력 %opt1_value%% 증가 & HP %opt1_value%% 증가 & 일반 방어력 %opt1_value%% 증가 & 특수 방어력 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的ACT力量%opt1_value%% &會心威力%opt1_value%% &HP提升%opt1_value%% &普通防禦力%opt1_value%% & 特殊防禦力%opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":8,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":24,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":10,\"skill_option4_target_id\":1001,\"skill_option4_values\":[30,30,30,30,30],\"skill_option5_id\":12,\"skill_option5_target_id\":1001,\"skill_option5_values\":[30,30,30,30,30],\"_id_\":12182},\"12184\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,17,19,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12184},\"12185\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,22,24,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12185},\"12186\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,27,29,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12186},\"12187\":{\"description\":{\"ja\":\"[永続]すばやさアップ %opt1_value%%\",\"en\":\"(Passive) Agility +%opt1_value%%\",\"ko\":\"[영구] 민첩 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升敏捷 %opt1_value%%\"},\"icon_id\":14,\"skill_option1_id\":14,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,32,34,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12187},\"12188\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value%\",\"en\":\"(Passive) Get %opt1_value% Brilliance each turn\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value% 획득\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value%\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,12,14,16,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12188},\"12189\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%　※愛城華恋セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%% *When equipped by Karen Aijo\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※아이조 카렌에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%% ※只在與愛城華戀搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7101,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7101,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12189},\"12190\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※神楽ひかりセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Hikari Kagura\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※카구라 히카리에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與神樂光搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7102,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7102,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12190},\"12191\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※露崎まひるセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Mahiru Tsuyuzaki\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※츠유자키 마히루에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與露崎真晝搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7103,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7103,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12191},\"12192\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※西條クロディーヌセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Claudine Saijo\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※사이조 클로딘에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與西條克洛迪娜搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7104,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7104,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12192},\"12193\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※天堂真矢セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Maya Tendo\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※텐도 마야에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與天堂真矢搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7105,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7105,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12193},\"12194\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※星見純那セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Junna Hoshimi\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※호시미 준나에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與星見純那搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7106,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7106,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12194},\"12195\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※大場ななセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Nana Daiba\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※다이바 나나에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與大場奈奈搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7107,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7107,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12195},\"12196\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※石動双葉セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Futaba Isurugi\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※이스루기 후타바에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與石動雙葉搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7108,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7108,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12196},\"12197\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※花柳香子セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Kaoruko Hanayagi\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※하나야기 카오루코에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與花柳香子搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7109,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7109,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12197},\"12198\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※巴珠緒セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Tamao Tomoe\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※토모에 타마오에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與巴珠緒搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7201,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7201,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12198},\"12199\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※音無いちえセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Ichie Otonashi\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오토나시 이치에에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與音無一愛搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7202,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7202,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12199},\"12200\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※夢大路文セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Fumi Yumeoji\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유메오지 후미에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與夢大路文搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7203,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7203,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12200},\"12201\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※秋風塁セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Rui Akikaze\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※아키카제 루이에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與秋風壘搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7204,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7204,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12201},\"12202\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※田中ゆゆ子セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Yuyuko Tanaka\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※타나카 유유코에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與田中悠悠子搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7205,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7205,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12202},\"12203\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※大月あるるセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Aruru Otsuki\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오츠키 아루루에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與大月艾露露搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7301,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7301,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12203},\"12204\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※叶美空セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Misora Kano\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※카노 미소라에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與葉美空搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7302,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7302,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12204},\"12205\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※野々宮ララフィンセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Lalafin Nonomiya\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※노노미야 라라핀에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與野野宮菈樂菲搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7303,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7303,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12205},\"12206\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※恵比寿つかさセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Tsukasa Ebisu\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※에비스 츠카사에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與惠比壽司搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7304,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7304,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12206},\"12207\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※胡蝶静羽セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Shizuha Kocho\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※코쵸 시즈하에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與胡蝶靜羽搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7305,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7305,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12207},\"12208\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※雪代晶セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Akira Yukishiro\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유키시로 아키라에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與雪代晶搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7401,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7401,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12208},\"12209\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※鳳ミチルセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Michiru Otori\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※오토리 미치루에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與鳳未知留搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7402,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7402,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12209},\"12210\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※リュウ・メイファンセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Liu Mei Fan\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※류 메이팡에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與柳美帆搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7403,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7403,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12210},\"12211\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※夢大路栞セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Shiori Yumeoji\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※유메오지 시오리에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與夢大路栞搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7404,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7404,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12211},\"12212\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※鶴姫やちよセット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Yachiyo Tsuruhime\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※츠루히메 야치요에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與鶴姬八千代搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7405,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7405,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12212},\"12213\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※柳小春セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Koharu Yanagi\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※야나기 코하루에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與柳小春搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7501,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7501,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12213},\"12214\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※南風涼セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Suzu Minase\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※미나세 스즈에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與南風涼搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7502,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7502,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12214},\"12215\":{\"description\":{\"ja\":\"[永続]毎ターンキラめき獲得 %opt1_value% & クリティカル率アップ %opt2_value%%  ※穂波氷雨セット時のみ発動\",\"en\":\"(Passive) Get %opt1_value%  Brilliance each turn & Dexterity +%opt2_value%%  *When equipped by Hisame Honami\",\"ko\":\"[영구] 매 턴마다 반짝임 %opt1_value%  획득 & 크리티컬 확률 %opt2_value%% 증가 ※호나미 히사메에게 장착 시에만 발동\",\"zh_hant\":\"[永續]每回合獲得光芒 %opt1_value% & 提升會心率 %opt2_value%%  ※只在與穗波冰雨搭配出場時發動\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":7503,\"skill_option1_values\":[20,21,22,23,25],\"skill_option2_id\":20,\"skill_option2_target_id\":7503,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12215},\"12216\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園への与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Damage dealt to Seisho Up %opt1_value%%\",\"ko\":\"[영구] 세이쇼 음악학교에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對聖翔音樂學院造成的傷害%opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":399,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12216},\"12217\":{\"description\":{\"ja\":\"[永続]凛明館女学校への与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Dmg to Rinmeikan Up %opt1_value%%\",\"ko\":\"[영구] 린메이칸 여학교에 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對凜明館女子學校造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":400,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12217},\"12218\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校への与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Dmg to Frontier Up %opt1_value%%\",\"ko\":\"[영구] 프론티어 예술학교에 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對芙羅提亞藝術學校造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":401,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12218},\"12219\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院への与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Dmg to Siegfeld Up %opt1_value%%\",\"ko\":\"[영구] 시크펠트 음악학원에 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對席格菲特音樂學院造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":402,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12219},\"12220\":{\"description\":{\"ja\":\"[永続]青嵐総合芸術院への与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) Dmg to Seiran Up %opt1_value%%\",\"ko\":\"[영구] 세이란 종합 예술학원에 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對青嵐總合藝術學院造成的傷害 %opt1_value%%\"},\"icon_id\":8,\"skill_option1_id\":403,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12220},\"12221\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の聖翔音楽学園のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seisho allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이쇼 음악학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方聖翔音樂學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":24,\"skill_option2_target_id\":4001,\"skill_option2_values\":[20,20,20,20,20],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12221},\"12222\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の凛明館女学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%%  more HP to all allies & %opt2_value%% more HP to all Rinmeikan allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 린메이칸 여학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方凜明館女子學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":24,\"skill_option2_target_id\":4002,\"skill_option2_values\":[20,20,20,20,20],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12222},\"12223\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のフロンティア芸術学校のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Frontier allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 프론티어 예술학교의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方芙羅提亞藝術學校的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":24,\"skill_option2_target_id\":4003,\"skill_option2_values\":[20,20,20,20,20],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12223},\"12224\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方のシークフェルト音楽学院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Siegfeld allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 시크펠트 음악학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% &提升我方席格菲特音樂學院的HP%opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":24,\"skill_option2_target_id\":4004,\"skill_option2_values\":[20,20,20,20,20],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12224},\"12225\":{\"description\":{\"ja\":\"[永続]味方全体のHPアップ %opt1_value%% & 味方の青嵐総合芸術院のHPアップ %opt2_value%%\",\"en\":\"(Passive) %opt1_value%% more HP to all allies & %opt2_value%% more HP to all Seiran allies\",\"ko\":\"[영구] 아군 전체의 HP %opt1_value%%  증가 & 아군 세이란 종합 예술학원의 HP %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方的HP %opt1_value%% & 提升我方青嵐總合藝術學院的HP %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1002,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":24,\"skill_option2_target_id\":4059,\"skill_option2_values\":[20,20,20,20,20],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12225},\"12226\":{\"description\":{\"ja\":\"[永続]回数マイナス効果耐性 %opt1_value%\",\"en\":\"(Passive) Countable Negative Effects Resistance %opt1_value%\",\"ko\":\"[영구] 횟수 마이너스 효과 저항 %opt1_value%\",\"zh_hant\":\"[永續]次數性負面效果耐性%opt1_value%\"},\"icon_id\":250,\"skill_option1_id\":445,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12226},\"12227\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%%\",\"en\":\"(Passive) Dexterity +%opt1_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12227},\"12228\":{\"description\":{\"ja\":\"[永続]HPアップ %opt1_value%%\",\"en\":\"(Passive) HP +%opt1_value%%\",\"ko\":\"[영구] HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12228},\"12229\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value% & 回数マイナス効果耐性 %opt2_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%  & Count. Negative Effects Resistance %opt2_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%  & 횟수 마이너스 효과 저항 %opt2_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%  & 次數性負面效果耐性 %opt2_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":445,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12229},\"12230\":{\"description\":{\"ja\":\"[永続]クリティカル率アップ %opt1_value%% &クリティカル威力アップ %opt2_value%%\",\"en\":\"(Passive) Dexterity Up %opt1_value%%  & Critical Up %opt2_value%%\",\"ko\":\"[영구] 크리티컬 확률 %opt1_value%% 증가 & 크리티컬 위력 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升會心率 %opt1_value%%  & 提升會心威力 %opt2_value%%\"},\"icon_id\":20,\"skill_option1_id\":20,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":22,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12230},\"12231\":{\"description\":{\"ja\":\"[永続]HPアップ %opt1_value%%\",\"en\":\"(Passive) HP +%opt1_value%%\",\"ko\":\"[영구] HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升HP %opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1000,1000,1000,1000,1000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12231},\"12232\":{\"description\":{\"ja\":\"[永続]味方の宙属性のHPアップ %opt1_value%% & クリティカル率アップ %opt2_value%%\",\"en\":\"(Passive) HP Up %opt1_value%% & Dexterity Up %opt2_value%% to Space allies\",\"ko\":\"[영구] 우주 속성 아군의 HP %opt1_value%%  증가 & 크리티컬 확률 %opt2_value%% 증가\",\"zh_hant\":\"[永續]提升宙屬性我方的HP %opt1_value%%  & 會心率 %opt2_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4012,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":20,\"skill_option2_target_id\":4012,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12232},\"12233\":{\"description\":{\"ja\":\"[永続]味方の聖翔音楽学園のHPアップ %opt1_value%%\",\"en\":\"(Passive) HP Up %opt1_value%% to Seisho allies\",\"ko\":\"[영구] 아군 세이쇼 음악학교의 HP %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升我方聖翔音樂學院的HP%opt1_value%%\"},\"icon_id\":223,\"skill_option1_id\":24,\"skill_option1_target_id\":4001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12233},\"12234\":{\"description\":{\"ja\":\"[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)\",\"en\":\"(Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self (%value%)\",\"ko\":\"[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)\",\"zh_hant\":\"[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12234},\"12235\":{\"description\":{\"ja\":\"[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)\",\"en\":\"(Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self (%value%)\",\"ko\":\"[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)\",\"zh_hant\":\"[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[2,2,2,2,2],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12235},\"12236\":{\"description\":{\"ja\":\"[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)\",\"en\":\"(Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self (%value%)\",\"ko\":\"[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)\",\"zh_hant\":\"[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[3,3,3,3,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12236},\"12237\":{\"description\":{\"ja\":\"[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)\",\"en\":\"(Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self (%value%)\",\"ko\":\"[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)\",\"zh_hant\":\"[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[4,4,4,4,4],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12237},\"12238\":{\"description\":{\"ja\":\"[永続]自身にセットしているカットインスキル発動準備ターン短縮(%value%)\",\"en\":\"(Passive) Shorten Instant Skill Turn Activation of Instant Skill set to self (%value%)\",\"ko\":\"[영구] 자신에게 세팅되어 있는 컷인 스킬의 발동 준비 턴 단축(%value%)\",\"zh_hant\":\"[永續]縮短與自己搭配出場之切入技能的發動準備回合（%value%）\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12238},\"12239\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":518,\"skill_option1_target_id\":4013,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12239},\"12240\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":530,\"skill_option1_target_id\":4011,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12240},\"12241\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":275,\"skill_option1_id\":520,\"skill_option1_target_id\":4008,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12241},\"12242\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":275,\"skill_option1_id\":535,\"skill_option1_target_id\":4009,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12242},\"12243\":{\"description\":{\"ja\":\"[永続]継続マイナス効果耐性 %opt1_value% & 回数マイナス効果耐性 %opt2_value%\",\"en\":\"(Passive) Cont. Negative Effects Resistance %opt1_value%  & Count. Negative Effects Resistance %opt2_value%\",\"ko\":\"[영구] 지속 마이너스 효과 저항 %opt1_value%  & 횟수 마이너스 효과 저항 %opt2_value%\",\"zh_hant\":\"[永續]持續性負面效果耐性 %opt1_value%  & 次數性負面效果耐性 %opt2_value%\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":445,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12243},\"12244\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":527,\"skill_option1_target_id\":4008,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12244},\"12245\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":275,\"skill_option1_id\":539,\"skill_option1_target_id\":4013,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12245},\"12246\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10007,\"skill_option1_id\":469,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12246},\"12247\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":529,\"skill_option1_target_id\":4010,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12247},\"12248\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10007,\"skill_option1_id\":469,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":26,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12248},\"12250\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":482,\"skill_option1_target_id\":4087,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":482,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12250},\"12251\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":528,\"skill_option1_target_id\":4009,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12251},\"12252\":{\"description\":{\"ja\":\"-\",\"en\":\"-\",\"ko\":\"-\",\"zh_hant\":\"-\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12252},\"12253\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":481,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":481,\"skill_option2_target_id\":4086,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12253},\"12254\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":279,\"skill_option1_id\":476,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":94,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12254},\"12255\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":532,\"skill_option1_target_id\":4013,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12255},\"12256\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":298,\"skill_option1_id\":506,\"skill_option1_target_id\":4004,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12256},\"12257\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12257},\"12258\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":532,\"skill_option1_target_id\":4013,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12258},\"12259\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":445,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12259},\"12260\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":39,\"skill_option1_id\":39,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,25,25,25,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12260},\"12261\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":482,\"skill_option1_target_id\":4087,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":482,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12261},\"12262\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10007,\"skill_option1_id\":469,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":26,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12262},\"12263\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":296,\"skill_option1_id\":510,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[20000,20000,20000,20000,20000],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12263},\"12264\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":481,\"skill_option1_target_id\":1001,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":481,\"skill_option2_target_id\":4086,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":455,\"skill_option3_target_id\":1001,\"skill_option3_values\":[1,1,1,1,1],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12264},\"12265\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":529,\"skill_option1_target_id\":4010,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12265},\"12266\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":445,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12266},\"12267\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12267},\"12268\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12268},\"12269\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12269},\"12270\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,12,14,16,20],\"skill_option2_id\":20,\"skill_option2_target_id\":1001,\"skill_option2_values\":[10,11,12,13,15],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12270},\"12271\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10007,\"skill_option1_id\":469,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":26,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12271},\"12272\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":510,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[20000,20000,20000,20000,20000],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12272},\"12273\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12273},\"12274\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12274},\"12275\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12275},\"12276\":{\"description\":{\"ja\":\"\"},\"icon_id\":296,\"skill_option1_id\":510,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":28,\"skill_option2_target_id\":1001,\"skill_option2_values\":[20000,20000,20000,20000,20000],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12276},\"12277\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10,\"skill_option1_id\":126,\"skill_option1_target_id\":1001,\"skill_option1_values\":[40,40,40,40,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12277},\"12278\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":482,\"skill_option1_target_id\":4087,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":482,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":559,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":24,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12278},\"12279\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12279},\"12280\":{\"description\":{\"ja\":\"\"},\"icon_id\":303,\"skill_option1_id\":561,\"skill_option1_target_id\":1001,\"skill_option1_values\":[0,0,0,0,0],\"skill_option2_id\":563,\"skill_option2_target_id\":1001,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":455,\"skill_option3_target_id\":1001,\"skill_option3_values\":[1,1,1,1,1],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12280},\"12281\":{\"description\":{\"ja\":\"\"},\"icon_id\":267,\"skill_option1_id\":531,\"skill_option1_target_id\":4012,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12281},\"12282\":{\"description\":{\"ja\":\"\"},\"icon_id\":26,\"skill_option1_id\":26,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":445,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12282},\"12283\":{\"description\":{\"ja\":\"\"},\"icon_id\":29,\"skill_option1_id\":29,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":26,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":568,\"skill_option3_target_id\":1001,\"skill_option3_values\":[1,1,1,1,1],\"skill_option4_id\":455,\"skill_option4_target_id\":1001,\"skill_option4_values\":[1,1,1,1,1],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12283},\"12284\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":10007,\"skill_option1_id\":469,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":26,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":455,\"skill_option3_target_id\":1001,\"skill_option3_values\":[1,1,1,1,1],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12284},\"12285\":{\"description\":{\"ja\":\"\"},\"icon_id\":266,\"skill_option1_id\":455,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":573,\"skill_option2_target_id\":1001,\"skill_option2_values\":[1,1,1,1,1],\"skill_option3_id\":126,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12285},\"12286\":{\"description\":{\"ja\":\"\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"icon_id\":267,\"skill_option1_id\":481,\"skill_option1_target_id\":4086,\"skill_option1_values\":[30,30,30,30,30],\"skill_option2_id\":481,\"skill_option2_target_id\":1001,\"skill_option2_values\":[30,30,30,30,30],\"skill_option3_id\":445,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":455,\"skill_option4_target_id\":1001,\"skill_option4_values\":[1,1,1,1,1],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":12286},\"15000\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15000},\"15001\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15001},\"15002\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15002},\"15003\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15003},\"15004\":{\"description\":{\"ja\":\"[永続]毒耐性 %opt1_value%\",\"en\":\"(Passive) Poison Resistance: %opt1_value%\",\"ko\":\"[영구] 독 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]中毒耐性 %opt1_value%\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15004},\"15005\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15005},\"15006\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15006},\"15007\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15007},\"15008\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15008},\"15009\":{\"description\":{\"ja\":\"[永続]火傷耐性 %opt1_value%\",\"en\":\"(Passive) Burn Resistance: %opt1_value%\",\"ko\":\"[영구] 화상 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]燒傷耐性 %opt1_value%\"},\"icon_id\":92,\"skill_option1_id\":92,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15009},\"15010\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15010},\"15011\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15011},\"15012\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15012},\"15013\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15013},\"15014\":{\"description\":{\"ja\":\"[永続]挑発耐性 %opt1_value%\",\"en\":\"(Passive) Provoke Resistance: %opt1_value%\",\"ko\":\"[영구] 도발 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]挑釁耐性 %opt1_value%\"},\"icon_id\":93,\"skill_option1_id\":93,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15014},\"15015\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15015},\"15016\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15016},\"15017\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15017},\"15018\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15018},\"15019\":{\"description\":{\"ja\":\"[永続]スタン耐性 %opt1_value%\",\"en\":\"(Passive) Stun Resistance: %opt1_value%\",\"ko\":\"[영구] 스턴 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]暈眩耐性 %opt1_value%\"},\"icon_id\":94,\"skill_option1_id\":94,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15019},\"15020\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15020},\"15021\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15021},\"15022\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15022},\"15023\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15023},\"15024\":{\"description\":{\"ja\":\"[永続]睡眠耐性 %opt1_value%\",\"en\":\"(Passive) Sleep Resistance: %opt1_value%\",\"ko\":\"[영구] 수면 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]睡眠耐性 %opt1_value%\"},\"icon_id\":95,\"skill_option1_id\":95,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15024},\"15025\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15025},\"15026\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15026},\"15027\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15027},\"15028\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15028},\"15029\":{\"description\":{\"ja\":\"[永続]混乱耐性 %opt1_value%\",\"en\":\"(Passive) Confusion Resistance: %opt1_value%\",\"ko\":\"[영구] 혼란 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]混亂耐性 %opt1_value%\"},\"icon_id\":96,\"skill_option1_id\":96,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15029},\"15030\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15030},\"15031\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15031},\"15032\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15032},\"15033\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15033},\"15034\":{\"description\":{\"ja\":\"[永続]ストップ耐性 %opt1_value%\",\"en\":\"(Passive) Stop Resistance: %opt1_value%\",\"ko\":\"[영구] 스톱 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]停止耐性 %opt1_value%\"},\"icon_id\":97,\"skill_option1_id\":97,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15034},\"15035\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15035},\"15036\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15036},\"15037\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15037},\"15038\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15038},\"15039\":{\"description\":{\"ja\":\"[永続]凍結耐性 %opt1_value%\",\"en\":\"(Passive) Freeze Resistance: %opt1_value%\",\"ko\":\"[영구] 동결 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]凍結耐性 %opt1_value%\"},\"icon_id\":98,\"skill_option1_id\":98,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15039},\"15040\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15040},\"15041\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15041},\"15042\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15042},\"15043\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15043},\"15044\":{\"description\":{\"ja\":\"[永続]暗闇耐性 %opt1_value%\",\"en\":\"(Passive) Blindness Resistance: %opt1_value%\",\"ko\":\"[영구] 암흑 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]盲目耐性 %opt1_value%\"},\"icon_id\":99,\"skill_option1_id\":99,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15044},\"15045\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15045},\"15046\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15046},\"15047\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15047},\"15048\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15048},\"15049\":{\"description\":{\"ja\":\"[永続]回復量低下耐性 %opt1_value%\",\"en\":\"(Passive) Recovery Reduction Resistance: %opt1_value%\",\"ko\":\"[영구] 회복량 감소 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]降低回復量耐性 %opt1_value%\"},\"icon_id\":100,\"skill_option1_id\":100,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15049},\"15050\":{\"description\":{\"ja\":\"[永続]刻印耐性 %opt1_value%\",\"en\":\"(Passive) Mark Resistance: %opt1_value%\",\"ko\":\"[영구] 각인 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]刻印耐性 %opt1_value%\"},\"icon_id\":175,\"skill_option1_id\":248,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,8,11,14,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15050},\"15051\":{\"description\":{\"ja\":\"[永続]刻印耐性 %opt1_value%\",\"en\":\"(Passive) Mark Resistance: %opt1_value%\",\"ko\":\"[영구] 각인 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]刻印耐性 %opt1_value%\"},\"icon_id\":175,\"skill_option1_id\":248,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,13,17,21,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15051},\"15052\":{\"description\":{\"ja\":\"[永続]刻印耐性 %opt1_value%\",\"en\":\"(Passive) Mark Resistance: %opt1_value%\",\"ko\":\"[영구] 각인 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]刻印耐性 %opt1_value%\"},\"icon_id\":175,\"skill_option1_id\":248,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,18,22,26,30],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15052},\"15053\":{\"description\":{\"ja\":\"[永続]刻印耐性 %opt1_value%\",\"en\":\"(Passive) Mark Resistance: %opt1_value%\",\"ko\":\"[영구] 각인 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]刻印耐性 %opt1_value%\"},\"icon_id\":175,\"skill_option1_id\":248,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,23,27,31,35],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15053},\"15054\":{\"description\":{\"ja\":\"[永続]刻印耐性 %opt1_value%\",\"en\":\"(Passive) Mark Resistance: %opt1_value%\",\"ko\":\"[영구] 각인 저항 %opt1_value% 증가\",\"zh_hant\":\"[永續]刻印耐性 %opt1_value%\"},\"icon_id\":175,\"skill_option1_id\":248,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,28,32,36,40],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":15054},\"16000\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Seisho Music Academy\",\"ko\":\"[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":159,\"skill_option1_id\":8,\"skill_option1_target_id\":4001,\"skill_option1_values\":[1,1,2,2,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16000},\"16001\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Seisho Music Academy\",\"ko\":\"[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":159,\"skill_option1_id\":8,\"skill_option1_target_id\":4001,\"skill_option1_values\":[3,3,4,4,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16001},\"16002\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Seisho Music Academy\",\"ko\":\"[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":159,\"skill_option1_id\":8,\"skill_option1_target_id\":4001,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16002},\"16003\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Seisho Music Academy\",\"ko\":\"[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":159,\"skill_option1_id\":8,\"skill_option1_target_id\":4001,\"skill_option1_values\":[7,7,8,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16003},\"16004\":{\"description\":{\"ja\":\"[永続]聖翔音楽学園の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Seisho Music Academy\",\"ko\":\"[영구]세이쇼 음악학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升聖翔音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":159,\"skill_option1_id\":8,\"skill_option1_target_id\":4001,\"skill_option1_values\":[9,9,10,10,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16004},\"16005\":{\"description\":{\"ja\":\"[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School\",\"ko\":\"[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":160,\"skill_option1_id\":8,\"skill_option1_target_id\":4002,\"skill_option1_values\":[1,1,2,2,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16005},\"16006\":{\"description\":{\"ja\":\"[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School\",\"ko\":\"[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":160,\"skill_option1_id\":8,\"skill_option1_target_id\":4002,\"skill_option1_values\":[3,3,4,4,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16006},\"16007\":{\"description\":{\"ja\":\"[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School\",\"ko\":\"[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":160,\"skill_option1_id\":8,\"skill_option1_target_id\":4002,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16007},\"16008\":{\"description\":{\"ja\":\"[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School\",\"ko\":\"[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":160,\"skill_option1_id\":8,\"skill_option1_target_id\":4002,\"skill_option1_values\":[7,7,8,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16008},\"16009\":{\"description\":{\"ja\":\"[永続]凛明館女学校の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Rinmeikan Girls School\",\"ko\":\"[영구]린메이칸 여학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升凜明館女子學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":160,\"skill_option1_id\":8,\"skill_option1_target_id\":4002,\"skill_option1_values\":[9,9,10,10,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16009},\"16010\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Frontier School of Arts\",\"ko\":\"[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":161,\"skill_option1_id\":8,\"skill_option1_target_id\":4003,\"skill_option1_values\":[1,1,2,2,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16010},\"16011\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Frontier School of Arts\",\"ko\":\"[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":161,\"skill_option1_id\":8,\"skill_option1_target_id\":4003,\"skill_option1_values\":[3,3,4,4,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16011},\"16012\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Frontier School of Arts\",\"ko\":\"[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":161,\"skill_option1_id\":8,\"skill_option1_target_id\":4003,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16012},\"16013\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Frontier School of Arts\",\"ko\":\"[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":161,\"skill_option1_id\":8,\"skill_option1_target_id\":4003,\"skill_option1_values\":[7,7,8,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16013},\"16014\":{\"description\":{\"ja\":\"[永続]フロンティア芸術学校の舞台少女ACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Frontier School of Arts\",\"ko\":\"[영구]프론티어 예술학교 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升芙羅提亞藝術學校之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":161,\"skill_option1_id\":8,\"skill_option1_target_id\":4003,\"skill_option1_values\":[9,9,10,10,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16014},\"16015\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music\",\"ko\":\"[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":162,\"skill_option1_id\":8,\"skill_option1_target_id\":4004,\"skill_option1_values\":[1,1,2,2,3],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16015},\"16016\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music\",\"ko\":\"[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":162,\"skill_option1_id\":8,\"skill_option1_target_id\":4004,\"skill_option1_values\":[3,3,4,4,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16016},\"16017\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music\",\"ko\":\"[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":162,\"skill_option1_id\":8,\"skill_option1_target_id\":4004,\"skill_option1_values\":[5,5,6,6,7],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16017},\"16018\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music\",\"ko\":\"[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":162,\"skill_option1_id\":8,\"skill_option1_target_id\":4004,\"skill_option1_values\":[7,7,8,8,9],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16018},\"16019\":{\"description\":{\"ja\":\"[永続]シークフェルト音楽学院の舞台少女のACTパワーアップ %opt1_value%%\",\"en\":\"(Passive) Act Power +%opt1_value%% to members from Siegfeld Institute of Music\",\"ko\":\"[영구]시크펠트 음악학원 무대소녀의 ACT 파워 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升席格菲特音樂學院之舞台少女的ACT力量%opt1_value%%\"},\"icon_id\":162,\"skill_option1_id\":8,\"skill_option1_target_id\":4004,\"skill_option1_values\":[9,9,10,10,11],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":16019},\"17001\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[5,5,5,5,5],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17001},\"17002\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17002},\"17003\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[15,15,15,15,15],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17003},\"17004\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[20,20,20,20,20],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17004},\"17005\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[25,25,25,25,25],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17005},\"17006\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17006},\"17007\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17007},\"17008\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17008},\"17009\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1002,\"skill_option1_values\":[1000,1000,1000,1000,1000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17009},\"17010\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1,1,1,1,1],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17010},\"17011\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[10,10,10,10,10],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17011},\"17012\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17012},\"17013\":{\"description\":{\"ja\":\"[永続]イベントBOSSに対する味方全体の与ダメージアップ %opt1_value%%\",\"en\":\"(Passive) +%opt1_value%% more damage for all allies to Event Boss\",\"ko\":\"[영구] 이벤트 BOSS에게 아군 전체의 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升所有我方對活動BOSS造成的傷害+%opt1_value%%\"},\"icon_id\":10008,\"skill_option1_id\":53,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1000,1000,1000,1000,1000],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":17013},\"18001\":{\"description\":{\"ja\":\"[永続]花属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Flower +%opt1_value%%\",\"ko\":\"[영구] 꽃 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對花屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":253,\"skill_option1_id\":47,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":48,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":49,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":50,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":51,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18001},\"18002\":{\"description\":{\"ja\":\"[永続]風属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Wind +%opt1_value%%\",\"ko\":\"[영구] 바람 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對風屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":254,\"skill_option1_id\":46,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":48,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":49,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":50,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":51,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18002},\"18003\":{\"description\":{\"ja\":\"[永続]雪属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Snow +%opt1_value%%\",\"ko\":\"[영구] 눈 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對雪屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":255,\"skill_option1_id\":46,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":47,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":49,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":50,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":51,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18003},\"18004\":{\"description\":{\"ja\":\"[永続]月属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Moon +%opt1_value%%\",\"ko\":\"[영구] 달 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對月屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":256,\"skill_option1_id\":46,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":47,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":48,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":50,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":51,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18004},\"18005\":{\"description\":{\"ja\":\"[永続]宙属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Space +%opt1_value%%\",\"ko\":\"[영구] 우주 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對宙屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":257,\"skill_option1_id\":46,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":47,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":48,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":49,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":51,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18005},\"18006\":{\"description\":{\"ja\":\"[永続]雲属性以外への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg against Elements other than Cloud +%opt1_value%%\",\"ko\":\"[영구] 구름 속성 이외에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]提升對雲屬性以外的屬性所造成的傷害  %opt1_value%%\"},\"icon_id\":258,\"skill_option1_id\":46,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":47,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":48,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":49,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":50,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18006},\"18011\":{\"description\":{\"ja\":\"[永続]花属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Flower -%opt1_value%%\",\"ko\":\"[영구] 꽃 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少花屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":259,\"skill_option1_id\":67,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":68,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":69,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":70,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":71,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18011},\"18012\":{\"description\":{\"ja\":\"[永続]風属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Wind -%opt1_value%%\",\"ko\":\"[영구] 바람 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少風屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":260,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":68,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":69,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":70,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":71,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18012},\"18013\":{\"description\":{\"ja\":\"[永続]雪属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Snow -%opt1_value%%\",\"ko\":\"[영구] 눈 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少雪屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":261,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":67,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":69,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":70,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":71,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18013},\"18014\":{\"description\":{\"ja\":\"[永続]月属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Moon -%opt1_value%%\",\"ko\":\"[영구] 달 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少月屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":262,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":67,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":68,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":70,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":71,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18014},\"18015\":{\"description\":{\"ja\":\"[永続]宙属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Space -%opt1_value%%\",\"ko\":\"[영구] 우주 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少宙屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":263,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":67,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":68,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":69,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":71,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18015},\"18016\":{\"description\":{\"ja\":\"[永続]雲属性以外からの被ダメージを減少  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Cloud -%opt1_value%%\",\"ko\":\"[영구] 구름 속성에게 받는 대미지 %opt1_value%% 감소\",\"zh_hant\":\"[永續]減少雲屬性以外的屬性造成的傷害  %opt1_value%%\"},\"icon_id\":264,\"skill_option1_id\":66,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":67,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":68,\"skill_option3_target_id\":1001,\"skill_option3_values\":[50,50,50,50,50],\"skill_option4_id\":69,\"skill_option4_target_id\":1001,\"skill_option4_values\":[50,50,50,50,50],\"skill_option5_id\":70,\"skill_option5_target_id\":1001,\"skill_option5_values\":[50,50,50,50,50],\"_id_\":18016},\"18017\":{\"description\":{\"ja\":\"[永続]夢属性からの被ダメージを減少  %opt1_value%%、夢属性への与ダメージを上昇  %opt1_value%%\",\"en\":\"(Passive) Dmg Received from Elements other than Dream -%opt1_value%%, Dmg against Dream +%opt1_value%%\",\"ko\":\"[영구] 꿈 속성에게 받는 대미지 %opt1_value%% 감소, 꿈 속성에게 가하는 대미지 %opt1_value%% 증가\",\"zh_hant\":\"[永續]減少夢屬性造成的傷害 %opt1_value%%，並提高對夢屬性所造成的傷害%opt1_value%%\"},\"icon_id\":52,\"skill_option1_id\":52,\"skill_option1_target_id\":1001,\"skill_option1_values\":[50,50,50,50,50],\"skill_option2_id\":72,\"skill_option2_target_id\":1001,\"skill_option2_values\":[50,50,50,50,50],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18017},\"18021\":{\"description\":{\"ja\":\"[特殊]毒&火傷耐性\",\"en\":\"(Special) Poison & Burn Resistance\",\"ko\":\"[특수]독&화상 저항\",\"zh_hant\":\"[特殊]中毒&燒傷耐性\"},\"icon_id\":91,\"skill_option1_id\":91,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":92,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18021},\"18022\":{\"description\":{\"ja\":\"[特殊]毒&火傷＆混乱＆スタン＆暗闇耐性＆睡眠＆凍結＆ストップ\",\"en\":\"[Special] Poison & Burn & Confusion & Stun & Blindness Resistance & Sleep & Freeze & Stop\",\"ko\":\"[특수] 독 & 화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱\",\"zh_hant\":\"[特殊]中毒耐性&燒傷耐性&混亂耐性&暈眩耐性&盲目耐性&睡眠耐性&凍結耐性&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[255,255,255,255,255],\"skill_option2_id\":0,\"skill_option2_target_id\":0,\"skill_option2_values\":[0,0,0,0,0],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18022},\"18023\":{\"description\":{\"ja\":\"[特殊]AP増加耐性&ACT封印耐性\",\"en\":\"[Special] AP Up & Act Seal Resistance\",\"ko\":\"[특수] AP 증가 저항 & ACT 봉인 저항\",\"zh_hant\":\"[特殊]AP增加耐性&ACT封印耐性\"},\"icon_id\":225,\"skill_option1_id\":225,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":253,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":254,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":255,\"skill_option4_target_id\":1001,\"skill_option4_values\":[100,100,100,100,100],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18023},\"18024\":{\"description\":{\"ja\":\"[特殊]猛毒&大火傷&混乱&睡眠&凍結&ストップ\",\"en\":\"[Special] Strong Poison & Heavy Burn & Confusion & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 맹독 & 대화상 & 혼란 & 수면 & 동결 & 스톱\",\"zh_hant\":\"[特殊]猛毒&嚴重燒傷&混亂&睡眠&凍結&停止\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[120,120,120,120,120],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18024},\"18025\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&混乱&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[123,123,123,123,123],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18025},\"18026\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&暗闇&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun & Blindness & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&盲目&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[255,255,255,255,255],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18026},\"18027\":{\"description\":{\"ja\":\"[特殊]猛毒&大火傷耐性\",\"en\":\"(Special) Strong Poison & Heavy Burn Resistance\",\"ko\":\"[특수] 맹독 & 대화상 저항\",\"zh_hant\":\"[特殊]猛毒&嚴重燒傷耐性\"},\"icon_id\":91,\"skill_option1_id\":318,\"skill_option1_target_id\":1001,\"skill_option1_values\":[100,100,100,100,100],\"skill_option2_id\":319,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":0,\"skill_option3_target_id\":0,\"skill_option3_values\":[0,0,0,0,0],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18027},\"18028\":{\"description\":{\"ja\":\"[特殊]猛毒&大火傷&混乱&スタン&暗闇&睡眠&ストップ耐性\",\"en\":\"[Special] Strong Poison & Heavy Burn & Confusion & Stun & Blindness & Sleep & Stop Resistance\",\"ko\":\"[특수] 맹독 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 스톱 저항\",\"zh_hant\":\"[特殊]猛毒&嚴重燒傷&混亂&暈眩&盲目&睡眠&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[188,188,188,188,188],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18028},\"18029\":{\"description\":{\"ja\":\"[特殊]猛毒&大火傷&スタン＆睡眠＆混乱＆ストップ＆凍結＆暗闇耐性\",\"en\":\"[Special] Strong Poison & Heavy Burn & Stun & Sleep & Confusion & Stop & Freeze & Blindness Resistance\",\"ko\":\"[특수] 맹독 & 대화상 & 스턴 & 수면 & 혼란 & 스톱 & 동결 & 암흑 저항\",\"zh_hant\":\"[特殊]猛毒&嚴重燒傷&暈眩&睡眠&混亂&停止&凍結&盲目耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[252,252,252,252,252],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18029},\"18030\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[127,127,127,127,127],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18030},\"18031\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&暗闇&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Blindness & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 암흑 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&盲目&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[235,235,235,235,235],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18031},\"18032\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&スタン&暗闇&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Stun & Blindness & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&暈眩&盲目&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[239,239,239,239,239],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18032},\"18033\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&大火傷&混乱&スタン&暗闇&睡眠&凍結&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Heavy Burn & Confusion & Stun & Blindness & Sleep & Freeze & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 동결 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&嚴重燒傷&混亂&暈眩&盲目&睡眠&凍結&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[253,253,253,253,253],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18033},\"18034\":{\"description\":{\"ja\":\"[特殊]毒&猛毒&火傷&大火傷&混乱&スタン&暗闇&睡眠&ストップ耐性\",\"en\":\"[Special] Poison & Strong Poison & Burn & Heavy Burn & Confusion & Stun & Blindness & Sleep & Stop Resistance\",\"ko\":\"[특수] 독 & 맹독 & 화상 & 대화상 & 혼란 & 스턴 & 암흑 & 수면 & 스톱 저항\",\"zh_hant\":\"[特殊]中毒&猛毒&燒傷&嚴重燒傷&混亂&暈眩&盲目&睡眠&停止耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[191,191,191,191,191],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18034},\"18035\":{\"description\":{\"ja\":\"[特殊]猛毒&大火傷&スタン＆睡眠＆混乱＆ストップ＆凍結＆暗闇＆恋わずらい＆感電耐性\",\"en\":\"[Special] Strong Poison & Heavy Burn & Stun & Sleep & Confusion & Stop & Freeze & Blindness & Lovesickness & Electric Shock Resistance\",\"ko\":\"[특수] 맹독 & 대화상 & 스턴 & 수면 & 혼란 & 스톱 & 동결 & 암흑 & 상사병 & 감전 저항\",\"zh_hant\":\"[特殊]猛毒&嚴重燒傷&暈眩＆睡眠＆混亂＆停止＆凍結＆盲目＆苦戀＆感電耐性\"},\"icon_id\":91,\"skill_option1_id\":267,\"skill_option1_target_id\":1001,\"skill_option1_values\":[1020,1020,1020,1020,1020],\"skill_option2_id\":318,\"skill_option2_target_id\":1001,\"skill_option2_values\":[100,100,100,100,100],\"skill_option3_id\":319,\"skill_option3_target_id\":1001,\"skill_option3_values\":[100,100,100,100,100],\"skill_option4_id\":0,\"skill_option4_target_id\":0,\"skill_option4_values\":[0,0,0,0,0],\"skill_option5_id\":0,\"skill_option5_target_id\":0,\"skill_option5_values\":[0,0,0,0,0],\"_id_\":18035}}")
