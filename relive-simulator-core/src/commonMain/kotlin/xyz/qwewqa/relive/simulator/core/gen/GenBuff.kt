@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenBuff(
    val base_point: Int,
    val card_abnormal_priority: Int,
    val card_abnormal_type: Int,
    val category: Int,
    val chara_add_color: List<Int>,
    val chara_color: List<Int>,
    val chara_gray_scale: Int,
    val icon_id: Int,
    val is_lock: Int,
    val is_motion_stop: Int,
    val loop: Int,
    val loop_filename: String,
    val name: Map<String,String>,
    val priority: Int
)

/*
1:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 1
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Act Power Up
    ja: ACTパワーアップ
    ko: ACT 파워 증가
    zh_hant: 提升ACT力量
  priority: 99
2:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 2
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Act Power Down
    ja: ACTパワーダウン
    ko: ACT 파워 감소
    zh_hant: 降低ACT力量
  priority: 99
3:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 3
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Normal Defense Up
    ja: 通常防御力アップ
    ko: 일반 방어력 증가
    zh_hant: 提升普通防禦力
  priority: 99
4:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 4
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Normal Defense Down
    ja: 通常防御力ダウン
    ko: 일반 방어력 감소
    zh_hant: 降低普通防禦力
  priority: 99
5:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 5
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Special Defense Up
    ja: 特殊防御力アップ
    ko: 특수 방어력 증가
    zh_hant: 提升特殊防禦力
  priority: 99
6:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 6
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Special Defense Down
    ja: 特殊防御力ダウン
    ko: 특수 방어력 감소
    zh_hant: 降低特殊防禦力
  priority: 99
7:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 7
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Agility Up
    ja: すばやさアップ
    ko: 민첩 증가
    zh_hant: 提升敏捷
  priority: 99
8:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 8
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Agility Down
    ja: すばやさダウン
    ko: 민첩 감소
    zh_hant: 降低敏捷
  priority: 99
9:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 9
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Accuracy Up
    ja: 命中アップ
    ko: 명중 증가
    zh_hant: 提升命中
  priority: 99
10:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 10
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Accuracy Down
    ja: 命中ダウン
    ko: 명중 감소
    zh_hant: 降低命中
  priority: 99
11:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 11
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Evasion Up
    ja: 回避アップ
    ko: 회피 증가
    zh_hant: 提升迴避
  priority: 99
12:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 12
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Evasion Down
    ja: 回避ダウン
    ko: 회피 감소
    zh_hant: 降低迴避
  priority: 99
13:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 13
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dexterity Up
    ja: クリティカル率アップ
    ko: 크리티컬 확률 증가
    zh_hant: 提升會心率
  priority: 99
14:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 14
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dexterity Down
    ja: クリティカル率ダウン
    ko: 크리티컬 확률 감소
    zh_hant: 降低會心率
  priority: 99
15:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 15
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Critical Up
    ja: クリティカル威力アップ
    ko: 크리티컬 위력 증가
    zh_hant: 提升會心威力
  priority: 99
16:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 16
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Critical Down
    ja: クリティカル威力ダウン
    ko: 크리티컬 위력 감소
    zh_hant: 降低會心威力
  priority: 99
17:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 17
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Max HP Up
    ja: 最大HPアップ
    ko: 최대 HP 증가
    zh_hant: 提升HP上限
  priority: 99
18:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 18
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Max HP Down
    ja: 最大HPダウン
    ko: 최대 HP 감소
    zh_hant: 降低HP上限
  priority: 99
19:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 19
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cont. Neg. Effects Resistance Up
    ja: 継続マイナス効果耐性アップ
    ko: 지속 마이너스 효과 저항 증가
    zh_hant: 提升持續性負面效果耐性
  priority: 99
20:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 20
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cont. Neg. Effects Resistance Down
    ja: 継続マイナス効果耐性ダウン
    ko: 지속 마이너스 효과 저항 감소
    zh_hant: 降低持續性負面效果耐性
  priority: 99
21:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 21
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_regeneration_loop
  name:
    en: 毎ターンHP回復
    ja: 毎ターンHP回復
    ko: 毎ターンHP回復
    zh_hant: 毎ターンHP回復
  priority: 3
22:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 22
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: 毎ターンキラめき回復
    ja: 毎ターンキラめき回復
    ko: 毎ターンキラめき回復
    zh_hant: 毎ターンキラめき回復
  priority: 4
23:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 23
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_def_barrier_loop
  name:
    en: Normal Barrier
    ja: 通常バリア
    ko: 일반 배리어
    zh_hant: 普通防護罩
  priority: 99
24:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 24
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_mdef_barrier_loop
  name:
    en: Special Barrier
    ja: 特殊バリア
    ko: 특수 배리어
    zh_hant: 特殊防護罩
  priority: 99
25:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 25
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_def_reflect_loop
  name:
    en: Reflect Normal Dmg
    ja: 通常ダメージ反射
    ko: 일반 대미지 반사
    zh_hant: 反射普通傷害
  priority: 99
26:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 26
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_mdef_reflect_loop
  name:
    en: Reflect Special Dmg
    ja: 特殊ダメージ反射
    ko: 특수 대미지 반사
    zh_hant: 反射特殊傷害
  priority: 99
27:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 27
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Evasion
    ja: 回避
    ko: 회피
    zh_hant: 迴避
  priority: 99
28:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 28
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Perfect Aim
    ja: 必中
    ko: 백발백중
    zh_hant: 必中
  priority: 99
29:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 29
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fortitude
    ja: 不屈
    ko: 불굴
    zh_hant: 不屈
  priority: 99
30:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 30
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fixed Normal Defense Boost
    ja: 通常防御力固定値アップ
    ko: 일반 방어력 고정값 증가
    zh_hant: 提升普通防禦力固定值
  priority: 99
31:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 31
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fixed Special Defense Boost
    ja: 特殊防御力固定値アップ
    ko: 특수 방어력 고정값 증가
    zh_hant: 提升特殊防禦力固定值
  priority: 99
32:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 32
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Effective Element Dmg Up
    ja: 属性有利ダメージUP
    ko: 속성 유리 대미지 증가
    zh_hant: 屬性有利傷害UP
  priority: 99
33:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 33
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Climax Act Power Up
    ja: クライマックスACT威力アップ
    ko: 클라이맥스 ACT 위력 증가
    zh_hant: CLIMAX ACT威力上升
  priority: 99
34:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 34
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Critical Dmg Received Down
    ja: 被クリティカルダメージダウン
    ko: 받는 크리티컬 대미지 감소
    zh_hant: 降低受到的會心傷害
  priority: 99
35:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 35
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fixed Act Power Boost
    ja: ACTパワー固定値アップ
    ko: ACT 파워 고정값 증가
    zh_hant: 提升ACT力量固定值
  priority: 99
37:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 37
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Absorb
    ja: 吸収
    ko: 흡수
    zh_hant: 吸收
  priority: 99
38:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 38
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Counter Heal
    ja: カウンターヒール
    ko: 카운터 힐
    zh_hant: 還擊治療
  priority: 99
39:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 39
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Flower Dmg vs. xxxx
    ja: 花属性特攻
    ko: 꽃의 xxxx 특수 공격
    zh_hant: 花的xxxx特攻
  priority: 99
40:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 40
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Wind Dmg vs. xxxx
    ja: 風属性特攻
    ko: 바람의 xxxx 특수 공격
    zh_hant: 風的xxxx特攻
  priority: 99
41:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 41
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Snow Dmg vs. xxxx
    ja: 雪属性特攻
    ko: 눈의 xxxx 특수 공격
    zh_hant: 雪的xxxx特攻
  priority: 99
42:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 42
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Moon Dmg vs. xxxx
    ja: 月属性特攻
    ko: 달의 xxxx 특수 공격
    zh_hant: 月的xxxx特攻
  priority: 99
43:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 43
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Space Dmg vs. xxxx
    ja: 宙属性特攻
    ko: 우주의 xxxx 특수 공격
    zh_hant: 宙的xxxx特攻
  priority: 99
44:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 44
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Cloud Dmg vs. xxxx
    ja: 雲属性特攻
    ko: 구름의 xxxx 특수 공격
    zh_hant: 雲的xxxx特攻
  priority: 99
45:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 45
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Dream Dmg vs. xxxx
    ja: 夢属性特攻
    ko: 꿈의 xxxx 특수 공격
    zh_hant: 夢的xxxx特攻
  priority: 99
46:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 46
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bonus Dmg vs. Boss
    ja: ボス特攻
    ko: 보스 특수 공격
    zh_hant: 頭目特攻
  priority: 99
47:
  base_point: 3
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 47
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_poison_loop
  name:
    en: Poison
    ja: 毒
    ko: 독
    zh_hant: 中毒
  priority: 3
48:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 48
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_fire_loop
  name:
    en: Burn
    ja: 火傷
    ko: 화상
    zh_hant: 燒傷
  priority: 3
49:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 49
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Provoke
    ja: 挑発
    ko: 도발
    zh_hant: 挑釁
  priority: 99
50:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 50
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_para_loop
  name:
    en: Stun
    ja: スタン
    ko: 스턴
    zh_hant: 暈眩
  priority: 1
51:
  base_point: 3
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 51
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_sleep_loop
  name:
    en: Sleep
    ja: 睡眠
    ko: 수면
    zh_hant: 睡眠
  priority: 1
52:
  base_point: 3
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 52
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_confusion_loop
  name:
    en: Confusion
    ja: 混乱
    ko: 혼란
    zh_hant: 混亂
  priority: 2
53:
  base_point: 2
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 5
  chara_add_color:
  - 0.227
  - 0.227
  - 0.227
  chara_color:
  - 0.384
  - 0.384
  - 0.384
  chara_gray_scale: 1
  icon_id: 53
  is_lock: 0
  is_motion_stop: 1
  loop: 0
  loop_filename: ''
  name:
    en: Stop
    ja: ストップ
    ko: 스톱
    zh_hant: 停止
  priority: 1
54:
  base_point: 2
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 5
  chara_add_color:
  - 0.288
  - 0.482
  - 0.522
  chara_color:
  - 0.529
  - 0.859
  - 0.852
  chara_gray_scale: 0
  icon_id: 54
  is_lock: 0
  is_motion_stop: 1
  loop: 0
  loop_filename: ''
  name:
    en: Freeze
    ja: 凍結
    ko: 동결
    zh_hant: 凍結
  priority: 2
55:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 55
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_dark_loop
  name:
    en: Blindness
    ja: 暗闇
    ko: 암흑
    zh_hant: 盲目
  priority: 2
58:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 58
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: HP Recovery Reduction
    ja: HP回復量低下
    ko: HP 회복량 감소
    zh_hant: 降低HP回復量
  priority: 99
59:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 59
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Flower Dmg Received Down
    ja: 花属性被ダメージダウン
    ko: 꽃 속성被대미지ダウン
    zh_hant: 花屬性被傷害降低
  priority: 99
60:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 60
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Wind Dmg Received Down
    ja: 風属性被ダメージダウン
    ko: 바람 속성被대미지ダウン
    zh_hant: 風屬性被傷害降低
  priority: 99
61:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 61
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Snow Dmg Received Down
    ja: 雪属性被ダメージダウン
    ko: 눈속성被대미지ダウン
    zh_hant: 雪屬性被傷害降低
  priority: 99
62:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 62
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Moon Dmg Received Down
    ja: 月属性被ダメージダウン
    ko: 달 속성被대미지ダウン
    zh_hant: 月屬性被傷害降低
  priority: 99
63:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 63
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Space Dmg Received Down
    ja: 宙属性被ダメージダウン
    ko: 우주 속성被대미지ダウン
    zh_hant: 宙屬性被傷害降低
  priority: 99
64:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 64
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cloud Dmg Received Down
    ja: 雲属性被ダメージダウン
    ko: 구름 속성被대미지ダウン
    zh_hant: 雲屬性被傷害降低
  priority: 99
65:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 65
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dream Dmg Received Down
    ja: 夢属性被ダメージダウン
    ko: 꿈 속성被대미지ダウン
    zh_hant: 夢屬性被傷害降低
  priority: 99
66:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 66
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Flower Dmg Up
    ja: 花属性与ダメージアップ
    ko: 꽃 속성与대미지アップ
    zh_hant: 花屬性与傷害提升
  priority: 99
67:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 67
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Wind Dmg Up
    ja: 風属性与ダメージアップ
    ko: 바람 속성与대미지アップ
    zh_hant: 風屬性与傷害提升
  priority: 99
68:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 68
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Snow Dmg Up
    ja: 雪属性与ダメージアップ
    ko: 눈속성与대미지アップ
    zh_hant: 雪屬性与傷害提升
  priority: 99
69:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 69
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Moon Dmg Up
    ja: 月属性与ダメージアップ
    ko: 달 속성与대미지アップ
    zh_hant: 月屬性与傷害提升
  priority: 99
70:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 70
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Space Dmg Up
    ja: 宙属性与ダメージアップ
    ko: 우주 속성与대미지アップ
    zh_hant: 宙屬性与傷害提升
  priority: 99
71:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 71
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cloud Dmg Up
    ja: 雲属性与ダメージアップ
    ko: 구름 속성与대미지アップ
    zh_hant: 雲屬性与傷害提升
  priority: 99
72:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 72
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dream Dmg Up
    ja: 夢属性与ダメージアップ
    ko: 꿈 속성与대미지アップ
    zh_hant: 夢屬性与傷害提升
  priority: 99
73:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 73
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Action Restriction Resistance (Auto)
    ja: 行動制限/行動不能耐性自動獲得
    ko: 행동 제한/행동 불능 저항 자동 획득
    zh_hant: 自動獲得限制行動/無法行動耐性
  priority: 99
74:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 74
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Action Restriction Resistance
    ja: 行動制限/行動不能耐性
    ko: 행동 제한/행동 불능 저항
    zh_hant: 限制行動/無法行動耐性
  priority: 99
75:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 75
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Poison Resistance
    ja: 毒耐性
    ko: 독 저항
    zh_hant: 中毒耐性
  priority: 99
76:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 76
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Burn Resistance
    ja: 火傷耐性
    ko: 화상 저항
    zh_hant: 燒傷耐性
  priority: 99
77:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 77
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Provoke Resistance
    ja: 挑発耐性
    ko: 도발 저항
    zh_hant: 挑釁耐性
  priority: 99
78:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 78
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Stun Resistance
    ja: スタン耐性
    ko: 스턴 저항
    zh_hant: 暈眩耐性
  priority: 99
79:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 79
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Sleep Resistance
    ja: 睡眠耐性
    ko: 수면 저항
    zh_hant: 睡眠耐性
  priority: 99
80:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 80
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Confusion Resistance
    ja: 混乱耐性
    ko: 혼란 저항
    zh_hant: 混亂耐性
  priority: 99
81:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 81
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Stop Resistance
    ja: ストップ耐性
    ko: 스톱 저항
    zh_hant: 停止耐性
  priority: 99
82:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 82
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Freeze Resistance
    ja: 凍結耐性
    ko: 동결 저항
    zh_hant: 凍結耐性
  priority: 99
83:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 83
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blindness Resistance
    ja: 暗闇耐性
    ko: 암흑 저항
    zh_hant: 盲目耐性
  priority: 99
84:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 84
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Recovery Reduction Resistance
    ja: 回復量低下耐性
    ko: 회복량 감소 저항
    zh_hant: 降低回復量耐性
  priority: 99
85:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 85
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Soldier
    ja: ソルジャーキラー
    ko: 솔저 킬러
    zh_hant: 士兵殺手
  priority: 99
86:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 86
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Lancer
    ja: ランサーキラー
    ko: 랜서 킬러
    zh_hant: 槍兵殺手
  priority: 99
87:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 87
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Fencer
    ja: フェンサーキラー
    ko: 펜서 킬러
    zh_hant: 劍兵殺手
  priority: 99
88:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 88
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Magician
    ja: マジシャンキラー
    ko: 매지션 킬러
    zh_hant: 魔法師殺手
  priority: 99
89:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 89
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Shielder
    ja: シールダーキラー
    ko: 실더 킬러
    zh_hant: 盾兵殺手
  priority: 99
90:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 90
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Gunner
    ja: ガンナーキラー
    ko: 거너 킬러
    zh_hant: 砲兵殺手
  priority: 99
91:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 91
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Joker
    ja: 奇術師キラー
    ko: 기술사 킬러
    zh_hant: 奇術師殺手
  priority: 99
92:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 92
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Beast
    ja: ビーストキラー
    ko: 비스트 킬러
    zh_hant: 野獸殺手
  priority: 99
93:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 93
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-???
    ja: ？？？キラー
    ko: ??? 킬러
    zh_hant: ？？？殺手
  priority: 99
94:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 94
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Material
    ja: マテリアルキラー
    ko: 머티리얼 킬러
    zh_hant: 材料殺手
  priority: 99
95:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 95
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Dealt Up
    ja: 与ダメージアップ
    ko: 가하는 대미지 증가
    zh_hant: 提升造成的傷害
  priority: 99
96:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 96
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Dealt Down
    ja: 与ダメージダウン
    ko: 가하는 대미지 감소
    zh_hant: 降低造成的傷害
  priority: 99
97:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 97
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received Up
    ja: 被ダメージアップ
    ko: 받는 대미지 증가
    zh_hant: 提升受到的傷害
  priority: 99
98:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 98
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received Down
    ja: 被ダメージダウン
    ko: 받는 대미지 감소
    zh_hant: 降低受到的傷害
  priority: 99
99:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 99
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Marked
    ja: 刻印
    ko: 각인
    zh_hant: 刻印
  priority: 99
100:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 100
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Marked (Flip)
    ja: 刻印(反転)
    ko: 각인(반전)
    zh_hant: 刻印（反轉）
  priority: 99
101:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 101
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Aggro
    ja: ターゲット固定
    ko: 타깃 고정
    zh_hant: 目標鎖定
  priority: 99
102:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 102
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Aggro Resistance
    ja: ターゲット固定耐性
    ko: 타깃 고정 저항
    zh_hant: 目標鎖定耐性
  priority: 99
103:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 103
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Exit Evasion
    ja: 退場回避
    ko: 퇴장 회피
    zh_hant: 退場迴避
  priority: 99
104:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 104
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_invincible_loop
  name:
    en: Invincible
    ja: 無敵
    ko: 무적
    zh_hant: 無敵
  priority: 99
105:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 105
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: AP Down
    ja: AP減少
    ko: AP 감소
    zh_hant: AP減少
  priority: 99
106:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 106
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: AP増加
    ko: ''
    zh_hant: ''
  priority: 99
107:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 244
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: AP Up Resistance
    ja: AP増加耐性
    ko: AP 증가 저항
    zh_hant: AP增加耐性
  priority: 99
110:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 106
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_invincible_loop
  name:
    en: (Unremovable) AP Up
    ja: (解除不可)AP増加
    ko: (해제 불가) AP 증가
    zh_hant: （無法解除）AP增加
  priority: 99
111:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 50
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_para_loop
  name:
    en: (Unremovable) Stun
    ja: (解除不可)スタン
    ko: (해제 불가) 스턴
    zh_hant: （無法解除）暈眩
  priority: 1
112:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 21
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_regeneration_loop
  name:
    en: (Unremovable) HP Regen
    ja: (解除不可)毎ターンHP回復
    ko: (해제 불가) 매 턴마다 HP 회복
    zh_hant: （無法解除）每回合HP回復
  priority: 3
113:
  base_point: 2
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 5
  chara_add_color:
  - 0.227
  - 0.227
  - 0.227
  chara_color:
  - 0.384
  - 0.384
  - 0.384
  chara_gray_scale: 1
  icon_id: 53
  is_lock: 1
  is_motion_stop: 1
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Stop
    ja: (解除不可)ストップ
    ko: (해제 불가) 스톱
    zh_hant: （無法解除）停止
  priority: 1
114:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 38
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Counter Heal
    ja: (解除不可)カウンターヒール
    ko: (해제 불가) 카운터 힐
    zh_hant: （無法解除）還擊治療
  priority: 99
117:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 117
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: 全バフ・デバフ耐性
    ko: ''
    zh_hant: ''
  priority: 99
118:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 118
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Marked Resistance
    ja: 刻印耐性
    ko: 각인 저항
    zh_hant: 刻印耐性
  priority: 99
119:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 119
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Event Boss Dmg Reduction
    ja: イベントボスダメージダウン
    ko: 이벤트 BOSS 대미지 감소
    zh_hant: 減輕活動BOSS傷害
  priority: 99
120:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT1封印
    ko: ''
    zh_hant: ''
  priority: 99
121:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT2封印
    ko: ''
    zh_hant: ''
  priority: 99
122:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT3封印
    ko: ''
    zh_hant: ''
  priority: 99
123:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 123
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT1封印耐性
    ko: ''
    zh_hant: ''
  priority: 99
124:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 124
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT2封印耐性
    ko: ''
    zh_hant: ''
  priority: 99
125:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 125
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: ''
    ja: ACT3封印耐性
    ko: ''
    zh_hant: ''
  priority: 99
126:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 126
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Brilliance Recovery Reduction
    ja: キラめき獲得ダウン
    ko: 반짝임 획득 감소
    zh_hant: 獲得光芒減少
  priority: 99
127:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 74
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Brilliance Recovery Reduction Resistance
    ja: キラめき獲得ダウン耐性
    ko: 반짝임 획득 감소 저항
    zh_hant: 獲得光芒減少耐性
  priority: 99
128:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 75
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Poison Resistance
    ja: (解除不可)毒耐性
    ko: (해제 불가) 독 저항
    zh_hant: （無法解除）中毒耐性
  priority: 99
129:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 76
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Burn Resistance
    ja: (解除不可)火傷耐性
    ko: (해제 불가) 화상 저항
    zh_hant: （無法解除）燒傷耐性
  priority: 99
130:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 78
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Stun Resistance
    ja: (解除不可)スタン耐性
    ko: (해제 불가) 스턴 저항
    zh_hant: （無法解除）暈眩耐性
  priority: 99
131:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 79
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Sleep Resistance
    ja: (解除不可)睡眠耐性
    ko: (해제 불가) 수면 저항
    zh_hant: （無法解除）睡眠耐性
  priority: 99
132:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 80
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Confusion Resistance
    ja: (解除不可)混乱耐性
    ko: (해제 불가) 혼란 저항
    zh_hant: （無法解除）混亂耐性
  priority: 99
133:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 81
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Stop Resistance
    ja: (解除不可)ストップ耐性
    ko: (해제 불가) 스톱 저항
    zh_hant: （無法解除）停止耐性
  priority: 99
134:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 82
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Freeze Resistance
    ja: (解除不可)凍結耐性
    ko: (해제 불가) 동결 저항
    zh_hant: （無法解除）凍結耐性
  priority: 99
135:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 83
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Blindness Resistance
    ja: (解除不可)暗闇耐性
    ko: (해제 불가) 암흑 저항
    zh_hant: （無法解除）盲目耐性
  priority: 99
136:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 127
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Act Change (Times)
    ja: ACTチェンジ（回数）
    ko: ACT 체인지(횟수)
    zh_hant: ACT轉換（次數）
  priority: 99
137:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 127
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Act Change (Turn)
    ja: ACTチェンジ（ターン）
    ko: ACT 체인지(턴)
    zh_hant: ACT轉換（回合）
  priority: 99
138:
  base_point: 3
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 52
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_confusion_loop
  name:
    en: (Unremovable) Confusion
    ja: (解除不可)混乱
    ko: (해제 불가) 혼란
    zh_hant: （無法解除）混亂
  priority: 2
139:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 128
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Resilience
    ja: 不倒
    ko: 불멸
    zh_hant: 不倒
  priority: 99
140:
  base_point: 3
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 47
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_poison_loop
  name:
    en: (Unremovable) Apply Poison
    ja: (解除不可)毒を付与
    ko: (해제 불가)독을 부여
    zh_hant: （無法解除）賦予中毒
  priority: 3
141:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 48
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_fire_loop
  name:
    en: (Unremovable) Apply Burn
    ja: (解除不可)火傷を付与
    ko: (해제 불가)화상을 부여
    zh_hant: （無法解除）賦予燒傷
  priority: 3
142:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 55
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_dark_loop
  name:
    en: (Unremovable) Apply Blindness
    ja: (解除不可)暗闇を付与
    ko: (해제 불가)암흑을 부여
    zh_hant: （無法解除）賦予盲目
  priority: 2
143:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 58
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) HP Recovery Reduction
    ja: (解除不可)HP回復量低下
    ko: (해제 불가)HP 회복량 감소
    zh_hant: （無法解除）降低HP回復量
  priority: 99
144:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 131
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cont. Dmg Resistance
    ja: 継続ダメージ耐性
    ko: 지속 대미지 저항
    zh_hant: 持續性傷害耐性
  priority: 99
145:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 75
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Strong Poison Resistance
    ja: 猛毒耐性
    ko: 맹독 저항
    zh_hant: 猛毒耐性
  priority: 99
146:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 76
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Heavy Burn Resistance
    ja: 大火傷耐性
    ko: 대화상 저항
    zh_hant: 嚴重燒傷耐性
  priority: 99
147:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 147
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Flower Dmg Received Up
    ja: 花属性被ダメージアップ
    ko: 꽃 속성被대미지アップ
    zh_hant: 花屬性被傷害提升
  priority: 99
148:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 148
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Wind Dmg Received Up
    ja: 風属性被ダメージアップ
    ko: 바람 속성被대미지アップ
    zh_hant: 風屬性被傷害提升
  priority: 99
149:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 149
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Snow Dmg Received Up
    ja: 雪属性被ダメージアップ
    ko: 눈속성被대미지アップ
    zh_hant: 雪屬性被傷害提升
  priority: 99
150:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 150
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Moon Dmg Received Up
    ja: 月属性被ダメージアップ
    ko: 달 속성被대미지アップ
    zh_hant: 月屬性被傷害提升
  priority: 99
151:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 151
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Space Dmg Received Up
    ja: 宙属性被ダメージアップ
    ko: 우주 속성被대미지アップ
    zh_hant: 宙屬性被傷害提升
  priority: 99
152:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 152
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cloud Dmg Received Up
    ja: 雲属性被ダメージアップ
    ko: 구름 속성被대미지アップ
    zh_hant: 雲屬性被傷害提升
  priority: 99
153:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 153
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dream Dmg Received Up
    ja: 夢属性被ダメージアップ
    ko: 꿈 속성被대미지アップ
    zh_hant: 夢屬性被傷害提升
  priority: 99
154:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 154
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Flower Dmg dealt Down
    ja: 花属性与ダメージダウン
    ko: 꽃 속성与대미지ダウン
    zh_hant: 花屬性与傷害降低
  priority: 99
155:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 155
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Wind Dmg dealt Down
    ja: 風属性与ダメージダウン
    ko: 바람 속성与대미지ダウン
    zh_hant: 風屬性与傷害降低
  priority: 99
156:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 156
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Snow Dmg dealt Down
    ja: 雪属性与ダメージダウン
    ko: 눈속성与대미지ダウン
    zh_hant: 雪屬性与傷害降低
  priority: 99
157:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 157
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Moon Dmg dealt Down
    ja: 月属性与ダメージダウン
    ko: 달 속성与대미지ダウン
    zh_hant: 月屬性与傷害降低
  priority: 99
158:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 158
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Space Dmg dealt Down
    ja: 宙属性与ダメージダウン
    ko: 우주 속성与대미지ダウン
    zh_hant: 宙屬性与傷害降低
  priority: 99
159:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 159
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cloud Dmg dealt Down
    ja: 雲属性与ダメージダウン
    ko: 구름 속성与대미지ダウン
    zh_hant: 雲屬性与傷害降低
  priority: 99
160:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 160
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dream Dmg dealt Down
    ja: 夢属性与ダメージダウン
    ko: 꿈 속성与대미지ダウン
    zh_hant: 夢屬性与傷害降低
  priority: 99
161:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 161
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Climax Act Power Down
    ja: クライマックスACT威力ダウン
    ko: 클라이맥스 ACT 위력 감소
    zh_hant: 降低CLIMAX ACT威力
  priority: 99
162:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 162
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_lovesickness_loop
  name:
    en: Lovesickness
    ja: 恋わずらい
    ko: 상사병
    zh_hant: 苦戀
  priority: 1
163:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 162
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_lovesickness_loop
  name:
    en: (Unremovable) Lovesickness
    ja: (解除不可)恋わずらい
    ko: (해제 불가) 상사병
    zh_hant: （無法解除）苦戀
  priority: 1
164:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 246
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Lovesickness Resistance
    ja: 恋わずらい耐性
    ko: 상사병 저항
    zh_hant: 苦戀耐性
  priority: 99
165:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 246
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Lovesickness Resistance
    ja: (解除不可)恋わずらい耐性
    ko: (해제 불가) 상사병 저항
    zh_hant: （無法解除）苦戀耐性
  priority: 99
166:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 19
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Cont. Neg. Effects Resistance
    ja: (解除不可)継続マイナス効果耐性アップ
    ko: (해제 불가) 지속 마이너스 효과 저항
    zh_hant: （無法解除）持續性負面效果耐性
  priority: 99
167:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Seal CA
    ja: クライマックスACT封印
    ko: CA 봉인
    zh_hant: CA封印
  priority: 99
168:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal CA
    ja: (解除不可)クライマックスACT封印
    ko: (해제 불가) CA 봉인
    zh_hant: （無法解除）CA封印
  priority: 99
169:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 163
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Electric Shock
    ja: 感電
    ko: 감전
    zh_hant: 感電
  priority: 99
170:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 163
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Electric Shock
    ja: (解除不可)感電
    ko: (해제 불가) 감전
    zh_hant: （無法解除）感電
  priority: 99
171:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 245
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Electric Shock Resistance
    ja: 感電耐性
    ko: 감전 저항
    zh_hant: 感電耐性
  priority: 99
172:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Electric Shock Resistance
    ja: (解除不可)感電耐性
    ko: (해제 불가) 감전 저항
    zh_hant: （無法解除）感電耐性
  priority: 99
173:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 164
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Revive
    ja: 起死回生
    ko: 기사회생
    zh_hant: 起死回生
  priority: 99
174:
  base_point: 2
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 165
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_lovesickness_loop
  name:
    en: Nightmare
    ja: 悪夢
    ko: 악몽
    zh_hant: 惡夢
  priority: 1
175:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Cont. Pos. Effects Immunity
    ja: 継続プラス効果耐性アップ
    ko: 지속 플러스 효과 무효
    zh_hant: 持續性正面效果無効
  priority: 99
176:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Cont. Pos. Effects Immunity
    ja: (解除不可)継続プラス効果無効
    ko: (해제 불가) 지속 플러스 효과 무효
    zh_hant: （無法解除）持續性正面效果無効
  priority: 99
177:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Pos. Effects Immunity
    ja: プラス効果無効
    ko: 플러스 효과 무효
    zh_hant: 正面效果無効
  priority: 99
178:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Pos. Effects Immunity
    ja: (解除不可)プラス効果無効
    ko: (해제 불가) 플러스 효과 무효
    zh_hant: （無法解除）正面效果無効
  priority: 99
179:
  base_point: 3
  card_abnormal_priority: 2
  card_abnormal_type: 2
  category: 3
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 167
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_confusion_loop
  name:
    en: Daze
    ja: 錯乱
    ko: 착란
    zh_hant: 錯亂
  priority: 2
180:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 2
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 168
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_lovesickness_loop
  name:
    en: Impudence
    ja: 慢心
    ko: 방심
    zh_hant: 傲慢
  priority: 99
181:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 169
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Hope
    ja: 希望
    ko: 희망
    zh_hant: 希望
  priority: 99
182:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 170
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Weak Spot
    ja: 急所
    ko: 급소
    zh_hant: 要害
  priority: 99
183:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 8
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fixed Agility Boost
    ja: すばやさ固定値アップ
    ko: 민첩 고정값 증가
    zh_hant: 提升敏捷固定値
  priority: 99
184:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 17
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Fixed Max HP Boost
    ja: 最大HP固定値アップ
    ko: 최대 HP 고정값 증가
    zh_hant: 提升最大HP固定值
  priority: 99
185:
  base_point: 2
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 5
  chara_add_color:
  - 0.288
  - 0.482
  - 0.522
  chara_color:
  - 0.529
  - 0.859
  - 0.852
  chara_gray_scale: 0
  icon_id: 171
  is_lock: 0
  is_motion_stop: 1
  loop: 0
  loop_filename: ''
  name:
    en: Frostbite
    ja: 凍傷
    ko: 동상
    zh_hant: 凍傷
  priority: 2
186:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg to Seisho Stage Girls Up
    ja: 聖翔音楽学園の舞台少女への与ダメージアップ
    ko: 세이쇼 음악학교의 무대소녀에게 가하는 대미지 증가
    zh_hant: 提升對聖翔音樂學院之舞台少女造成的傷害
  priority: 99
187:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg to Rinmeikan Stage Girls Up
    ja: 凛明館女学校の舞台少女への与ダメージアップ
    ko: 린메이칸 여학교의 무대소녀에게 가하는 대미지 증가
    zh_hant: 提升對凜明館女子學校之舞台少女造成的傷害
  priority: 99
188:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg to Frontier Stage Girls Up
    ja: フロンティア芸術学校の舞台少女への与ダメージアップ
    ko: 프론티어 예술학교의 무대소녀에게 가하는 대미지 증가
    zh_hant: 提升對芙羅提亞藝術學校之舞台少女造成的傷害
  priority: 99
189:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg to Siegfeld Stage Girls Up
    ja: シークフェルト音楽学院の舞台少女への与ダメージアップ
    ko: 시크펠트 음악학원의 무대소녀에게 가하는 대미지 증가
    zh_hant: 提升對席格菲特音樂學院之舞台少女造成的傷害
  priority: 99
190:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg to Seiran Stage Girls Up
    ja: 青嵐総合芸術院の舞台少女への与ダメージアップ
    ko: 세이란 종합 예술학원의 무대소녀에게 가하는 대미지 증가
    zh_hant: 提升對青嵐總合藝術學院之舞台少女造成的傷害
  priority: 99
191:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Karen Aijo Up
    ja: 愛城華恋からの被ダメージアップ
    ko: 아이조 카렌에게 받는 대미지 증가
    zh_hant: 提升被愛城華戀攻擊時受到的傷害
  priority: 99
192:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Hikari Kagura Up
    ja: 神楽ひかりからの被ダメージアップ
    ko: 카구라 히카리에게 받는 대미지 증가
    zh_hant: 提升被神樂光攻擊時受到的傷害
  priority: 99
193:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Mahiru Tsuyuzaki Up
    ja: 露崎まひるからの被ダメージアップ
    ko: 츠유자키 마히루에게 받는 대미지 증가
    zh_hant: 提升被露崎真晝攻擊時受到的傷害
  priority: 99
194:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Claudine Saijo Up
    ja: 西條クロディーヌからの被ダメージアップ
    ko: 사이조 클로딘에게 받는 대미지 증가
    zh_hant: 提升被西條克洛迪娜攻擊時受到的傷害
  priority: 99
195:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Maya Tendo Up
    ja: 天堂真矢からの被ダメージアップ
    ko: 텐도 마야에게 받는 대미지 증가
    zh_hant: 提升被天堂真矢攻擊時受到的傷害
  priority: 99
196:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Junna Hoshimi Up
    ja: 星見純那からの被ダメージアップ
    ko: 호시미 준나에게 받는 대미지 증가
    zh_hant: 提升被星見純那攻擊時受到的傷害
  priority: 99
197:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Nana Daiba Up
    ja: 大場ななからの被ダメージアップ
    ko: 다이바 나나에게 받는 대미지 증가
    zh_hant: 提升被大場奈奈攻擊時受到的傷害
  priority: 99
198:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Futaba Isurugi Up
    ja: 石動双葉からの被ダメージアップ
    ko: 이스루기 후타바에게 받는 대미지 증가
    zh_hant: 提升被石動雙葉攻擊時受到的傷害
  priority: 99
199:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Kaoruko Hanayagi Up
    ja: 花柳香子からの被ダメージアップ
    ko: 하나야기 카오루코에게 받는 대미지 증가
    zh_hant: 提升被花柳香子攻擊時受到的傷害
  priority: 99
200:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Tamao Tomoe Up
    ja: 巴珠緒からの被ダメージアップ
    ko: 토모에 타마오에게 받는 대미지 증가
    zh_hant: 提升被巴珠緒攻擊時受到的傷害
  priority: 99
201:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Ichie Otonashi Up
    ja: 音無いちえからの被ダメージアップ
    ko: 오토나시 이치에에게 받는 대미지 증가
    zh_hant: 提升被音無一愛攻擊時受到的傷害
  priority: 99
202:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Fumi Yumeoji Up
    ja: 夢大路文からの被ダメージアップ
    ko: 유메오지 후미에게 받는 대미지 증가
    zh_hant: 提升被夢大路文攻擊時受到的傷害
  priority: 99
203:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Rui Akikaze Up
    ja: 秋風塁からの被ダメージアップ
    ko: 아키카제 루이에게 받는 대미지 증가
    zh_hant: 提升被秋風壘攻擊時受到的傷害
  priority: 99
204:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Yuyuko Tanaka Up
    ja: 田中ゆゆ子からの被ダメージアップ
    ko: 타나카 유유코에게 받는 대미지 증가
    zh_hant: 提升被田中悠悠子攻擊時受到的傷害
  priority: 99
205:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Aruru Otsuki Up
    ja: 大月あるるからの被ダメージアップ
    ko: 오츠키 아루루에게 받는 대미지 증가
    zh_hant: 提升被大月艾露露攻擊時受到的傷害
  priority: 99
206:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Misora Kano Up
    ja: 叶美空からの被ダメージアップ
    ko: 카노 미소라에게 받는 대미지 증가
    zh_hant: 提升被葉美空攻擊時受到的傷害
  priority: 99
207:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Lalafin Nonomiya Up
    ja: 野々宮ララフィンからの被ダメージアップ
    ko: 노노미야 라라핀에게 받는 대미지 증가
    zh_hant: 提升被野野宮菈樂菲攻擊時受到的傷害
  priority: 99
208:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Tsukasa Ebisu Up
    ja: 恵比寿つかさからの被ダメージアップ
    ko: 에비스 츠카사에게 받는 대미지 증가
    zh_hant: 提升被惠比壽司攻擊時受到的傷害
  priority: 99
209:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Shizuha Kocho Up
    ja: 胡蝶静羽からの被ダメージアップ
    ko: 코쵸 시즈하에게 받는 대미지 증가
    zh_hant: 提升被胡蝶靜羽攻擊時受到的傷害
  priority: 99
210:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Akira Yukishiro Up
    ja: 雪代晶からの被ダメージアップ
    ko: 유키시로 아키라에게 받는 대미지 증가
    zh_hant: 提升被雪代晶攻擊時受到的傷害
  priority: 99
211:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Michiru Otori Up
    ja: 鳳ミチルからの被ダメージアップ
    ko: 오토리 미치루에게 받는 대미지 증가
    zh_hant: 提升被鳳未知留攻擊時受到的傷害
  priority: 99
212:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Liu Mei Fan Up
    ja: リュウ・メイファンからの被ダメージアップ
    ko: 류 메이팡에게 받는 대미지 증가
    zh_hant: 提升被柳美帆攻擊時受到的傷害
  priority: 99
213:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Shiori Yumeoji Up
    ja: 夢大路栞からの被ダメージアップ
    ko: 유메오지 시오리에게 받는 대미지 증가
    zh_hant: 提升被夢大路栞攻擊時受到的傷害
  priority: 99
214:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Yachiyo Tsuruhime Up
    ja: 鶴姫やちよからの被ダメージアップ
    ko: 츠루히메 야치요에게 받는 대미지 증가
    zh_hant: 提升被鶴姬八千代攻擊時受到的傷害
  priority: 99
215:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Koharu Yanagi Up
    ja: 柳小春からの被ダメージアップ
    ko: 야나기 코하루에게 받는 대미지 증가
    zh_hant: 提升被柳小春攻擊時受到的傷害
  priority: 99
216:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Suzu Minase Up
    ja: 南風涼からの被ダメージアップ
    ko: 미나세 스즈에게 받는 대미지 증가
    zh_hant: 提升被南風涼攻擊時受到的傷害
  priority: 99
217:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Dmg Received from Hisame Honami Up
    ja: 穂波氷雨からの被ダメージアップ
    ko: 호나미 히사메에게 받는 대미지 증가
    zh_hant: 提升被穗波冰雨攻擊時受到的傷害
  priority: 99
218:
  base_point: 2
  card_abnormal_priority: 1
  card_abnormal_type: 1
  category: 5
  chara_add_color:
  - 0.227
  - 0.227
  - 0.227
  chara_color:
  - 0.384
  - 0.384
  - 0.384
  chara_gray_scale: 1
  icon_id: 172
  is_lock: 0
  is_motion_stop: 1
  loop: 0
  loop_filename: ''
  name:
    en: Agony
    ja: 悶絶
    ko: 민절
    zh_hant: 窒息
  priority: 1
219:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 101
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Aggro
    ja: (解除不可)ターゲット固定
    ko: (해제 불가) 타깃 고정
    zh_hant: （無法解除）目標鎖定
  priority: 99
220:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal Act 1
    ja: (解除不可)ACT1封印
    ko: (해제 불가) ACT1 봉인
    zh_hant: （無法解除）ACT1封印
  priority: 99
221:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal Act 2
    ja: (解除不可)ACT2封印
    ko: (해제 불가) ACT2 봉인
    zh_hant: （無法解除）ACT2封印
  priority: 99
222:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 122
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal Act 3
    ja: (解除不可)ACT3封印
    ko: (해제 불가) ACT3 봉인
    zh_hant: （無法解除）ACT3封印
  priority: 99
223:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 23
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_def_barrier_loop
  name:
    en: (Unremovable) Normal Barrier
    ja: (解除不可)通常バリア
    ko: (해제 불가) 일반 배리어
    zh_hant: （無法解除）普通防護罩
  priority: 99
224:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 24
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_mdef_barrier_loop
  name:
    en: (Unremovable) Special Barrier
    ja: (解除不可)特殊バリア
    ko: (해제 불가) 특수 배리어
    zh_hant: （無法解除）特殊防護罩
  priority: 99
225:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 173
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Possession
    ja: 神がかり
    ko: 신내림
    zh_hant: 神靈附體
  priority: 99
226:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 173
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Possession
    ja: (解除不可)神がかり
    ko: (해제 불가) 신내림
    zh_hant: （無法解除）神靈附體
  priority: 99
227:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 105
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) AP Down
    ja: (解除不可AP減少
    ko: (해제 불가) AP 감소
    zh_hant: （無法解除）AP減少
  priority: 99
228:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 15
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Critical Up
    ja: (解除不可クリティカル威力アップ
    ko: (해제 불가) 크리티컬 위력 증가
    zh_hant: （無法解除）提升會心威力
  priority: 99
229:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 174
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Curtains Closed
    ja: 幕引き
    ko: 폐막
    zh_hant: 閉幕
  priority: 99
230:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 174
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Curtains Closed
    ja: (解除不可)幕引き
    ko: (해제 불가) 폐막
    zh_hant: （無法解除）閉幕
  priority: 99
231:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 250
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Count. Neg. Effects Resistance
    ja: 回数マイナス効果耐性アップ
    ko: 횟수 마이너스 효과 저항
    zh_hant: 次數性負面效果耐性
  priority: 99
232:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 250
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Count. Neg. Effects Resistance
    ja: (解除不可)回数マイナス効果耐性アップ
    ko: (해제 불가) 횟수 마이너스 효과 저항
    zh_hant: （無法解除）次數性負面效果耐性
  priority: 99
233:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 251
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Brilliance Recovery Increase
    ja: キラめき獲得増加
    ko: 반짝임 획득 증가
    zh_hant: 獲得光芒增加
  priority: 99
234:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 128
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Resilience
    ja: (解除不可)不倒
    ko: (해제 불가) 불멸
    zh_hant: （無法解除）不倒
  priority: 99
235:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 106
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: AP Up 2
    ja: AP増加2
    ko: AP 증가2
    zh_hant: AP增加2
  priority: 99
236:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 106
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) AP Up 2
    ja: (解除不可)AP増加2
    ko: (해제 불가) AP 증가2
    zh_hant: （無法解除）AP增加2
  priority: 99
237:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 105
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: AP Down 2
    ja: AP減少2
    ko: AP 감소2
    zh_hant: AP減少2
  priority: 99
238:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 105
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) AP Down 2
    ja: (解除不可)AP減少2
    ko: (해제 불가) AP 감소2
    zh_hant: （無法解除）AP減少2
  priority: 99
239:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Shorten Instant Skill Turn Activation
    ja: カットインスキル発動準備ターン短縮
    ko: 컷인 스킬 발동 준비 턴 단축
    zh_hant: 縮短切入技能的發動準備回合
  priority: 99
240:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 38
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Counter Heal
    ja: カウンターヒール
    ko: 카운터 힐
    zh_hant: 還擊治療
  priority: 99
241:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 252
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Hold Back
    ja: 手加減
    ko: 봐주기
    zh_hant: 心軟
  priority: 99
242:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 253
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Seal Stage Effect
    ja: 舞台効果付与封印
    ko: 무대 효과 부여 봉인
    zh_hant: 舞台效果封印
  priority: 99
243:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 253
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal Stage Effect
    ja: (解除不可)舞台効果付与封印
    ko: (해제 불가) 무대 효과 부여 봉인
    zh_hant: （無法解除）舞台效果封印
  priority: 99
244:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Adds Acts 1
    ja: ACT追加1
    ko: ACT 추가1
    zh_hant: ACT追加1
  priority: 99
245:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Adds Acts 2
    ja: ACT追加2
    ko: ACT 추가2
    zh_hant: ACT追加2
  priority: 99
246:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Bulkhead
    ja: 遮断壁
    ko: ''
    zh_hant: 隔絕屏障
  priority: 99
247:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Anti-Oath Revue
    ja: 誓いのレヴューキラー
    ko: 맹세의 레뷰 킬러
    zh_hant: 誓言的Revue殺手
  priority: 99
248:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 254
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Disaster [Brilliance Reduction]
    ja: 災難[キラめき減少]
    ko: 재난 [반짝임 감소]
    zh_hant: 災難[光芒減少]
  priority: 99
249:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 255
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [HP Recovery]
    ja: 祝福[HP回復]
    ko: 축복 [HP 회복]
    zh_hant: 祝福[回復HP]
  priority: 99
250:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 256
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [Count. Neg. Effects Reduction]
    ja: 祝福[回数マイナス効果減少]
    ko: 축복 [횟수 마이너스 효과 감소]
    zh_hant: 祝福[次數性負面效果減少]
  priority: 99
251:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 257
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Disaster [Daze]
    ja: 災難[錯乱]
    ko: 재난 [착란]
    zh_hant: 災難[錯亂]
  priority: 99
252:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 258
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [Dispel Cont. Neg. Effects]
    ja: 祝福[継続マイナス効果解除]
    ko: 축복 [지속 마이너스 효과 해제]
    zh_hant: 祝福[解除持續性負面效果]
  priority: 99
253:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 259
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Daze Resistance
    ja: 錯乱耐性
    ko: 착란 저항
    zh_hant: 錯亂耐性
  priority: 99
254:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 259
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Daze Resistance
    ja: (解除不可)錯乱耐性
    ko: (해제 불가) 착란 저항
    zh_hant: （無法解除）錯亂耐性
  priority: 99
255:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 260
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [Hope]
    ja: 祝福[希望]
    ko: 축복 [희망]
    zh_hant: 祝福[希望]
  priority: 99
256:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 261
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Impudence Resistance
    ja: 慢心耐性
    ko: 방심 저항
    zh_hant: 傲慢耐性
  priority: 99
257:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 261
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Impudence Resistance
    ja: (解除不可慢心耐性
    ko: (해제 불가) 방심 저항
    zh_hant: （無法解除）傲慢耐性
  priority: 99
258:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 262
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_def_reflect_loop
  name:
    en: Super Reflect Normal Dmg
    ja: 通常ダメージ超反射
    ko: 일반 대미지 슈퍼 반사
    zh_hant: 超反射普通傷害
  priority: 99
259:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 263
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_mdef_reflect_loop
  name:
    en: Super Reflect Special Dmg
    ja: 特殊ダメージ超反射
    ko: 특수 대미지 슈퍼 반사
    zh_hant: 超反射特殊傷害
  priority: 99
260:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 262
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_def_reflect_loop
  name:
    en: (Unremovable) Super Reflect Normal Dmg
    ja: (解除不可)通常ダメージ超反射
    ko: (해제 불가)일반 대미지 슈퍼 반사
    zh_hant: （無法解除）超反射普通傷害
  priority: 99
261:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 4
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 263
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_mdef_reflect_loop
  name:
    en: (Unremovable) Super Reflect Special Dmg
    ja: (解除不可)特殊ダメージ超反射
    ko: (해제 불가)특수 대미지 슈퍼 반사
    zh_hant: （無法解除）超反射特殊傷害
  priority: 99
262:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 264
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [Effective Element Dmg Up]
    ja: 祝福[有利属性ダメージアップ]
    ko: 축복 [유리한 속성 대미지 증가]
    zh_hant: 祝福[提升有利屬性傷害]
  priority: 99
263:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 265
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Invincible Rebirth
    ja: 無敵の再生者
    ko: 무적의 재생자
    zh_hant: 無敵重生者
  priority: 99
264:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 266
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Sacrifice
    ja: 殉葬
    ko: 순장
    zh_hant: 殉葬
  priority: 99
265:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 267
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Disaster [AP Up]
    ja: 災難[AP増加]
    ko: 재난[AP 증가]
    zh_hant: 災難[AP增加]
  priority: 99
266:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 268
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Blessing [AP Down 2]
    ja: 祝福[AP減少2]
    ko: 축복[AP 감소2]
    zh_hant: 祝福[AP減少2]
  priority: 99
267:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 269
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Contraction
    ja: 狭窄
    ko: 협착
    zh_hant: 視野收窄
  priority: 99
268:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 21
  is_lock: 0
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_regeneration_loop
  name:
    en: HP Regen
    ja: 毎ターンHP回復
    ko: 매 턴마다 HP 회복
    zh_hant: 每回合HP回復
  priority: 3
269:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 270
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Seal Instant Skill
    ja: カットインスキル封印
    ko: 컷인 스킬 봉인
    zh_hant: 切入技能封印
  priority: 99
270:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 270
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Seal Instant Skill
    ja: (解除不可)カットインスキル封印
    ko: (해제 불가) 컷인 스킬 봉인
    zh_hant: （無法解除）切入技能封印
  priority: 99
271:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Count. Pos. Effects Resistance Up
    ja: 回数プラス効果耐性アップ
    ko: 횟수 플러스 효과 저항 증가
    zh_hant: 提升次數性正面效果耐性
  priority: 99
272:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 166
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Count. Pos. Effects Resistance Up
    ja: (解除不可)回数プラス効果耐性アップ
    ko: (해제 불가) 횟수 플러스 효과 저항 증가
    zh_hant: （無法解除）提升次數性正面效果耐性
  priority: 99
273:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 28
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: (Unremovable) Perfect Aim
    ja: (解除不可)必中
    ko: (해제 불가) 백발백중
    zh_hant: （無法解除）必中
  priority: 99
274:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 0
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Act Power Up when Max HP
    ja: HP最大時ACTパワーアップ
    ko: HP가 최대일 때 ACT 파워 증가
    zh_hant: HP全滿時，提升ACT力量
  priority: 99
275:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 272
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Overwhelm
    ja: 圧倒
    ko: 압도
    zh_hant: 壓倒
  priority: 99
276:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 273
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Multiple CA-fication
    ja: 連続クライマックスACT化
    ko: 연속 클라이맥스 ACT화
    zh_hant: 連續CLIMAX ACT化
  priority: 99
277:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 274
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Brilliance Sap
    ja: 毎ターンキラめき減少
    ko: 매 턴마다 반짝임 감소
    zh_hant: 每回合減少光芒
  priority: 4
278:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 32
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Effective Element Dmg Up
    ja: 属性有利ダメージUP
    ko: 속성 유리 대미지 증가
    zh_hant: 屬性有利傷害UP
  priority: 99
279:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 22
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターンキラめき回復
  priority: 4
280:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 275
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン起死回生付与
  priority: 4
281:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 104
  is_lock: 1
  is_motion_stop: 0
  loop: 1
  loop_filename: hit_invincible_loop
  name:
    en: (Unremovable) Invincible
    ja: (解除不可)無敵
    ko: (해제 불가) 무적
    zh_hant: （無法解除）無敵
  priority: 99
282:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 276
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    en: Seal Stage Effect Resistance Up
    ja: 舞台効果付与封印耐性アップ
    ko: 무대 효과 부여 봉인 저항 증가
    zh_hant: 提升舞台效果封印耐性
  priority: 99
283:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 1
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 276
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)舞台効果付与封印耐性アップ
  priority: 99
284:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 277
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン継続マイナス効果解除
  priority: 4
285:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 277
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターン継続マイナス効果解除
  priority: 4
286:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 278
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン回数マイナス効果解除
  priority: 4
287:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 278
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターン回数マイナス効果解除
  priority: 4
288:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 279
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン継続プラス効果解除
  priority: 4
289:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 279
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターン継続プラス効果解除
  priority: 4
290:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 280
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 怪力
  priority: 99
292:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 281
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン怪力付与
  priority: 4
293:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 281
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターン怪力付与
  priority: 4
294:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 282
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: エール
  priority: 99
297:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 285
  is_lock: 0
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: 毎ターン回数マイナス効果減少
  priority: 4
298:
  base_point: 2
  card_abnormal_priority: 99
  card_abnormal_type: 0
  category: 2
  chara_add_color:
  - 0
  - 0
  - 0
  chara_color:
  - 1
  - 1
  - 1
  chara_gray_scale: 0
  icon_id: 285
  is_lock: 1
  is_motion_stop: 0
  loop: 0
  loop_filename: ''
  name:
    ja: (解除不可)毎ターン回数マイナス効果減少
  priority: 4

*/

val valuesGenBuff = loadMasterData<GenBuff>("{\"1\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":1,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACTパワーアップ\",\"en\":\"Act Power Up\",\"ko\":\"ACT 파워 증가\",\"zh_hant\":\"提升ACT力量\"},\"priority\":99},\"2\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":2,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACTパワーダウン\",\"en\":\"Act Power Down\",\"ko\":\"ACT 파워 감소\",\"zh_hant\":\"降低ACT力量\"},\"priority\":99},\"3\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":3,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"通常防御力アップ\",\"en\":\"Normal Defense Up\",\"ko\":\"일반 방어력 증가\",\"zh_hant\":\"提升普通防禦力\"},\"priority\":99},\"4\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":4,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"通常防御力ダウン\",\"en\":\"Normal Defense Down\",\"ko\":\"일반 방어력 감소\",\"zh_hant\":\"降低普通防禦力\"},\"priority\":99},\"5\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":5,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"特殊防御力アップ\",\"en\":\"Special Defense Up\",\"ko\":\"특수 방어력 증가\",\"zh_hant\":\"提升特殊防禦力\"},\"priority\":99},\"6\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":6,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"特殊防御力ダウン\",\"en\":\"Special Defense Down\",\"ko\":\"특수 방어력 감소\",\"zh_hant\":\"降低特殊防禦力\"},\"priority\":99},\"7\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":7,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"すばやさアップ\",\"en\":\"Agility Up\",\"ko\":\"민첩 증가\",\"zh_hant\":\"提升敏捷\"},\"priority\":99},\"8\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":8,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"すばやさダウン\",\"en\":\"Agility Down\",\"ko\":\"민첩 감소\",\"zh_hant\":\"降低敏捷\"},\"priority\":99},\"9\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":9,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"命中アップ\",\"en\":\"Accuracy Up\",\"ko\":\"명중 증가\",\"zh_hant\":\"提升命中\"},\"priority\":99},\"10\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":10,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"命中ダウン\",\"en\":\"Accuracy Down\",\"ko\":\"명중 감소\",\"zh_hant\":\"降低命中\"},\"priority\":99},\"11\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":11,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回避アップ\",\"en\":\"Evasion Up\",\"ko\":\"회피 증가\",\"zh_hant\":\"提升迴避\"},\"priority\":99},\"12\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":12,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回避ダウン\",\"en\":\"Evasion Down\",\"ko\":\"회피 감소\",\"zh_hant\":\"降低迴避\"},\"priority\":99},\"13\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":13,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クリティカル率アップ\",\"en\":\"Dexterity Up\",\"ko\":\"크리티컬 확률 증가\",\"zh_hant\":\"提升會心率\"},\"priority\":99},\"14\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":14,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クリティカル率ダウン\",\"en\":\"Dexterity Down\",\"ko\":\"크리티컬 확률 감소\",\"zh_hant\":\"降低會心率\"},\"priority\":99},\"15\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":15,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クリティカル威力アップ\",\"en\":\"Critical Up\",\"ko\":\"크리티컬 위력 증가\",\"zh_hant\":\"提升會心威力\"},\"priority\":99},\"16\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":16,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クリティカル威力ダウン\",\"en\":\"Critical Down\",\"ko\":\"크리티컬 위력 감소\",\"zh_hant\":\"降低會心威力\"},\"priority\":99},\"17\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":17,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"最大HPアップ\",\"en\":\"Max HP Up\",\"ko\":\"최대 HP 증가\",\"zh_hant\":\"提升HP上限\"},\"priority\":99},\"18\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":18,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"最大HPダウン\",\"en\":\"Max HP Down\",\"ko\":\"최대 HP 감소\",\"zh_hant\":\"降低HP上限\"},\"priority\":99},\"19\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":19,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"継続マイナス効果耐性アップ\",\"en\":\"Cont. Neg. Effects Resistance Up\",\"ko\":\"지속 마이너스 효과 저항 증가\",\"zh_hant\":\"提升持續性負面效果耐性\"},\"priority\":99},\"20\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":20,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"継続マイナス効果耐性ダウン\",\"en\":\"Cont. Neg. Effects Resistance Down\",\"ko\":\"지속 마이너스 효과 저항 감소\",\"zh_hant\":\"降低持續性負面效果耐性\"},\"priority\":99},\"21\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":21,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_regeneration_loop\",\"name\":{\"ja\":\"毎ターンHP回復\",\"en\":\"毎ターンHP回復\",\"ko\":\"毎ターンHP回復\",\"zh_hant\":\"毎ターンHP回復\"},\"priority\":3},\"22\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":22,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターンキラめき回復\",\"en\":\"毎ターンキラめき回復\",\"ko\":\"毎ターンキラめき回復\",\"zh_hant\":\"毎ターンキラめき回復\"},\"priority\":4},\"23\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":23,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_def_barrier_loop\",\"name\":{\"ja\":\"通常バリア\",\"en\":\"Normal Barrier\",\"ko\":\"일반 배리어\",\"zh_hant\":\"普通防護罩\"},\"priority\":99},\"24\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":24,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_mdef_barrier_loop\",\"name\":{\"ja\":\"特殊バリア\",\"en\":\"Special Barrier\",\"ko\":\"특수 배리어\",\"zh_hant\":\"特殊防護罩\"},\"priority\":99},\"25\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":25,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_def_reflect_loop\",\"name\":{\"ja\":\"通常ダメージ反射\",\"en\":\"Reflect Normal Dmg\",\"ko\":\"일반 대미지 반사\",\"zh_hant\":\"反射普通傷害\"},\"priority\":99},\"26\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":26,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_mdef_reflect_loop\",\"name\":{\"ja\":\"特殊ダメージ反射\",\"en\":\"Reflect Special Dmg\",\"ko\":\"특수 대미지 반사\",\"zh_hant\":\"反射特殊傷害\"},\"priority\":99},\"27\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":27,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回避\",\"en\":\"Evasion\",\"ko\":\"회피\",\"zh_hant\":\"迴避\"},\"priority\":99},\"28\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":28,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"必中\",\"en\":\"Perfect Aim\",\"ko\":\"백발백중\",\"zh_hant\":\"必中\"},\"priority\":99},\"29\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":29,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"不屈\",\"en\":\"Fortitude\",\"ko\":\"불굴\",\"zh_hant\":\"不屈\"},\"priority\":99},\"30\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":30,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"通常防御力固定値アップ\",\"en\":\"Fixed Normal Defense Boost\",\"ko\":\"일반 방어력 고정값 증가\",\"zh_hant\":\"提升普通防禦力固定值\"},\"priority\":99},\"31\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":31,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"特殊防御力固定値アップ\",\"en\":\"Fixed Special Defense Boost\",\"ko\":\"특수 방어력 고정값 증가\",\"zh_hant\":\"提升特殊防禦力固定值\"},\"priority\":99},\"32\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":32,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"属性有利ダメージUP\",\"en\":\"Effective Element Dmg Up\",\"ko\":\"속성 유리 대미지 증가\",\"zh_hant\":\"屬性有利傷害UP\"},\"priority\":99},\"33\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":33,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クライマックスACT威力アップ\",\"en\":\"Climax Act Power Up\",\"ko\":\"클라이맥스 ACT 위력 증가\",\"zh_hant\":\"CLIMAX ACT威力上升\"},\"priority\":99},\"34\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":34,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"被クリティカルダメージダウン\",\"en\":\"Critical Dmg Received Down\",\"ko\":\"받는 크리티컬 대미지 감소\",\"zh_hant\":\"降低受到的會心傷害\"},\"priority\":99},\"35\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":35,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACTパワー固定値アップ\",\"en\":\"Fixed Act Power Boost\",\"ko\":\"ACT 파워 고정값 증가\",\"zh_hant\":\"提升ACT力量固定值\"},\"priority\":99},\"37\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":37,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"吸収\",\"en\":\"Absorb\",\"ko\":\"흡수\",\"zh_hant\":\"吸收\"},\"priority\":99},\"38\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":38,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"カウンターヒール\",\"en\":\"Counter Heal\",\"ko\":\"카운터 힐\",\"zh_hant\":\"還擊治療\"},\"priority\":99},\"39\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":39,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花属性特攻\",\"en\":\"Bonus Flower Dmg vs. xxxx\",\"ko\":\"꽃의 xxxx 특수 공격\",\"zh_hant\":\"花的xxxx特攻\"},\"priority\":99},\"40\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":40,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"風属性特攻\",\"en\":\"Bonus Wind Dmg vs. xxxx\",\"ko\":\"바람의 xxxx 특수 공격\",\"zh_hant\":\"風的xxxx特攻\"},\"priority\":99},\"41\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":41,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪属性特攻\",\"en\":\"Bonus Snow Dmg vs. xxxx\",\"ko\":\"눈의 xxxx 특수 공격\",\"zh_hant\":\"雪的xxxx特攻\"},\"priority\":99},\"42\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":42,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"月属性特攻\",\"en\":\"Bonus Moon Dmg vs. xxxx\",\"ko\":\"달의 xxxx 특수 공격\",\"zh_hant\":\"月的xxxx特攻\"},\"priority\":99},\"43\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":43,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"宙属性特攻\",\"en\":\"Bonus Space Dmg vs. xxxx\",\"ko\":\"우주의 xxxx 특수 공격\",\"zh_hant\":\"宙的xxxx特攻\"},\"priority\":99},\"44\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":44,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雲属性特攻\",\"en\":\"Bonus Cloud Dmg vs. xxxx\",\"ko\":\"구름의 xxxx 특수 공격\",\"zh_hant\":\"雲的xxxx特攻\"},\"priority\":99},\"45\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":45,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢属性特攻\",\"en\":\"Bonus Dream Dmg vs. xxxx\",\"ko\":\"꿈의 xxxx 특수 공격\",\"zh_hant\":\"夢的xxxx特攻\"},\"priority\":99},\"46\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":46,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ボス特攻\",\"en\":\"Bonus Dmg vs. Boss\",\"ko\":\"보스 특수 공격\",\"zh_hant\":\"頭目特攻\"},\"priority\":99},\"47\":{\"base_point\":3,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":47,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_poison_loop\",\"name\":{\"ja\":\"毒\",\"en\":\"Poison\",\"ko\":\"독\",\"zh_hant\":\"中毒\"},\"priority\":3},\"48\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":48,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_fire_loop\",\"name\":{\"ja\":\"火傷\",\"en\":\"Burn\",\"ko\":\"화상\",\"zh_hant\":\"燒傷\"},\"priority\":3},\"49\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":49,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"挑発\",\"en\":\"Provoke\",\"ko\":\"도발\",\"zh_hant\":\"挑釁\"},\"priority\":99},\"50\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":50,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_para_loop\",\"name\":{\"ja\":\"スタン\",\"en\":\"Stun\",\"ko\":\"스턴\",\"zh_hant\":\"暈眩\"},\"priority\":1},\"51\":{\"base_point\":3,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":51,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_sleep_loop\",\"name\":{\"ja\":\"睡眠\",\"en\":\"Sleep\",\"ko\":\"수면\",\"zh_hant\":\"睡眠\"},\"priority\":1},\"52\":{\"base_point\":3,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":52,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_confusion_loop\",\"name\":{\"ja\":\"混乱\",\"en\":\"Confusion\",\"ko\":\"혼란\",\"zh_hant\":\"混亂\"},\"priority\":2},\"53\":{\"base_point\":2,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":5,\"chara_add_color\":[0.227,0.227,0.227],\"chara_color\":[0.384,0.384,0.384],\"chara_gray_scale\":1,\"icon_id\":53,\"is_lock\":0,\"is_motion_stop\":1,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ストップ\",\"en\":\"Stop\",\"ko\":\"스톱\",\"zh_hant\":\"停止\"},\"priority\":1},\"54\":{\"base_point\":2,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":5,\"chara_add_color\":[0.288,0.482,0.522],\"chara_color\":[0.529,0.859,0.852],\"chara_gray_scale\":0,\"icon_id\":54,\"is_lock\":0,\"is_motion_stop\":1,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"凍結\",\"en\":\"Freeze\",\"ko\":\"동결\",\"zh_hant\":\"凍結\"},\"priority\":2},\"55\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":55,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_dark_loop\",\"name\":{\"ja\":\"暗闇\",\"en\":\"Blindness\",\"ko\":\"암흑\",\"zh_hant\":\"盲目\"},\"priority\":2},\"58\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":58,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"HP回復量低下\",\"en\":\"HP Recovery Reduction\",\"ko\":\"HP 회복량 감소\",\"zh_hant\":\"降低HP回復量\"},\"priority\":99},\"59\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":59,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花属性被ダメージダウン\",\"en\":\"Flower Dmg Received Down\",\"ko\":\"꽃 속성被대미지ダウン\",\"zh_hant\":\"花屬性被傷害降低\"},\"priority\":99},\"60\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":60,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"風属性被ダメージダウン\",\"en\":\"Wind Dmg Received Down\",\"ko\":\"바람 속성被대미지ダウン\",\"zh_hant\":\"風屬性被傷害降低\"},\"priority\":99},\"61\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":61,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪属性被ダメージダウン\",\"en\":\"Snow Dmg Received Down\",\"ko\":\"눈속성被대미지ダウン\",\"zh_hant\":\"雪屬性被傷害降低\"},\"priority\":99},\"62\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":62,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"月属性被ダメージダウン\",\"en\":\"Moon Dmg Received Down\",\"ko\":\"달 속성被대미지ダウン\",\"zh_hant\":\"月屬性被傷害降低\"},\"priority\":99},\"63\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":63,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"宙属性被ダメージダウン\",\"en\":\"Space Dmg Received Down\",\"ko\":\"우주 속성被대미지ダウン\",\"zh_hant\":\"宙屬性被傷害降低\"},\"priority\":99},\"64\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":64,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雲属性被ダメージダウン\",\"en\":\"Cloud Dmg Received Down\",\"ko\":\"구름 속성被대미지ダウン\",\"zh_hant\":\"雲屬性被傷害降低\"},\"priority\":99},\"65\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":65,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢属性被ダメージダウン\",\"en\":\"Dream Dmg Received Down\",\"ko\":\"꿈 속성被대미지ダウン\",\"zh_hant\":\"夢屬性被傷害降低\"},\"priority\":99},\"66\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":66,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花属性与ダメージアップ\",\"en\":\"Flower Dmg Up\",\"ko\":\"꽃 속성与대미지アップ\",\"zh_hant\":\"花屬性与傷害提升\"},\"priority\":99},\"67\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":67,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"風属性与ダメージアップ\",\"en\":\"Wind Dmg Up\",\"ko\":\"바람 속성与대미지アップ\",\"zh_hant\":\"風屬性与傷害提升\"},\"priority\":99},\"68\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":68,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪属性与ダメージアップ\",\"en\":\"Snow Dmg Up\",\"ko\":\"눈속성与대미지アップ\",\"zh_hant\":\"雪屬性与傷害提升\"},\"priority\":99},\"69\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":69,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"月属性与ダメージアップ\",\"en\":\"Moon Dmg Up\",\"ko\":\"달 속성与대미지アップ\",\"zh_hant\":\"月屬性与傷害提升\"},\"priority\":99},\"70\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":70,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"宙属性与ダメージアップ\",\"en\":\"Space Dmg Up\",\"ko\":\"우주 속성与대미지アップ\",\"zh_hant\":\"宙屬性与傷害提升\"},\"priority\":99},\"71\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":71,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雲属性与ダメージアップ\",\"en\":\"Cloud Dmg Up\",\"ko\":\"구름 속성与대미지アップ\",\"zh_hant\":\"雲屬性与傷害提升\"},\"priority\":99},\"72\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":72,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢属性与ダメージアップ\",\"en\":\"Dream Dmg Up\",\"ko\":\"꿈 속성与대미지アップ\",\"zh_hant\":\"夢屬性与傷害提升\"},\"priority\":99},\"73\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":73,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"行動制限/行動不能耐性自動獲得\",\"en\":\"Action Restriction Resistance (Auto)\",\"ko\":\"행동 제한/행동 불능 저항 자동 획득\",\"zh_hant\":\"自動獲得限制行動/無法行動耐性\"},\"priority\":99},\"74\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":74,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"行動制限/行動不能耐性\",\"en\":\"Action Restriction Resistance\",\"ko\":\"행동 제한/행동 불능 저항\",\"zh_hant\":\"限制行動/無法行動耐性\"},\"priority\":99},\"75\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":75,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毒耐性\",\"en\":\"Poison Resistance\",\"ko\":\"독 저항\",\"zh_hant\":\"中毒耐性\"},\"priority\":99},\"76\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":76,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"火傷耐性\",\"en\":\"Burn Resistance\",\"ko\":\"화상 저항\",\"zh_hant\":\"燒傷耐性\"},\"priority\":99},\"77\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":77,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"挑発耐性\",\"en\":\"Provoke Resistance\",\"ko\":\"도발 저항\",\"zh_hant\":\"挑釁耐性\"},\"priority\":99},\"78\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":78,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"スタン耐性\",\"en\":\"Stun Resistance\",\"ko\":\"스턴 저항\",\"zh_hant\":\"暈眩耐性\"},\"priority\":99},\"79\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":79,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"睡眠耐性\",\"en\":\"Sleep Resistance\",\"ko\":\"수면 저항\",\"zh_hant\":\"睡眠耐性\"},\"priority\":99},\"80\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":80,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"混乱耐性\",\"en\":\"Confusion Resistance\",\"ko\":\"혼란 저항\",\"zh_hant\":\"混亂耐性\"},\"priority\":99},\"81\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":81,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ストップ耐性\",\"en\":\"Stop Resistance\",\"ko\":\"스톱 저항\",\"zh_hant\":\"停止耐性\"},\"priority\":99},\"82\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":82,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"凍結耐性\",\"en\":\"Freeze Resistance\",\"ko\":\"동결 저항\",\"zh_hant\":\"凍結耐性\"},\"priority\":99},\"83\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":83,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"暗闇耐性\",\"en\":\"Blindness Resistance\",\"ko\":\"암흑 저항\",\"zh_hant\":\"盲目耐性\"},\"priority\":99},\"84\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":84,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回復量低下耐性\",\"en\":\"Recovery Reduction Resistance\",\"ko\":\"회복량 감소 저항\",\"zh_hant\":\"降低回復量耐性\"},\"priority\":99},\"85\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":85,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ソルジャーキラー\",\"en\":\"Anti-Soldier\",\"ko\":\"솔저 킬러\",\"zh_hant\":\"士兵殺手\"},\"priority\":99},\"86\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":86,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ランサーキラー\",\"en\":\"Anti-Lancer\",\"ko\":\"랜서 킬러\",\"zh_hant\":\"槍兵殺手\"},\"priority\":99},\"87\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":87,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"フェンサーキラー\",\"en\":\"Anti-Fencer\",\"ko\":\"펜서 킬러\",\"zh_hant\":\"劍兵殺手\"},\"priority\":99},\"88\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":88,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"マジシャンキラー\",\"en\":\"Anti-Magician\",\"ko\":\"매지션 킬러\",\"zh_hant\":\"魔法師殺手\"},\"priority\":99},\"89\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":89,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"シールダーキラー\",\"en\":\"Anti-Shielder\",\"ko\":\"실더 킬러\",\"zh_hant\":\"盾兵殺手\"},\"priority\":99},\"90\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":90,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ガンナーキラー\",\"en\":\"Anti-Gunner\",\"ko\":\"거너 킬러\",\"zh_hant\":\"砲兵殺手\"},\"priority\":99},\"91\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":91,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"奇術師キラー\",\"en\":\"Anti-Joker\",\"ko\":\"기술사 킬러\",\"zh_hant\":\"奇術師殺手\"},\"priority\":99},\"92\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":92,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ビーストキラー\",\"en\":\"Anti-Beast\",\"ko\":\"비스트 킬러\",\"zh_hant\":\"野獸殺手\"},\"priority\":99},\"93\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":93,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"？？？キラー\",\"en\":\"Anti-???\",\"ko\":\"??? 킬러\",\"zh_hant\":\"？？？殺手\"},\"priority\":99},\"94\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":94,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"マテリアルキラー\",\"en\":\"Anti-Material\",\"ko\":\"머티리얼 킬러\",\"zh_hant\":\"材料殺手\"},\"priority\":99},\"95\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":95,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"与ダメージアップ\",\"en\":\"Dmg Dealt Up\",\"ko\":\"가하는 대미지 증가\",\"zh_hant\":\"提升造成的傷害\"},\"priority\":99},\"96\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":96,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"与ダメージダウン\",\"en\":\"Dmg Dealt Down\",\"ko\":\"가하는 대미지 감소\",\"zh_hant\":\"降低造成的傷害\"},\"priority\":99},\"97\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":97,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"被ダメージアップ\",\"en\":\"Dmg Received Up\",\"ko\":\"받는 대미지 증가\",\"zh_hant\":\"提升受到的傷害\"},\"priority\":99},\"98\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":98,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"被ダメージダウン\",\"en\":\"Dmg Received Down\",\"ko\":\"받는 대미지 감소\",\"zh_hant\":\"降低受到的傷害\"},\"priority\":99},\"99\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":99,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"刻印\",\"en\":\"Marked\",\"ko\":\"각인\",\"zh_hant\":\"刻印\"},\"priority\":99},\"100\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":100,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"刻印(反転)\",\"en\":\"Marked (Flip)\",\"ko\":\"각인(반전)\",\"zh_hant\":\"刻印（反轉）\"},\"priority\":99},\"101\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":101,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ターゲット固定\",\"en\":\"Aggro\",\"ko\":\"타깃 고정\",\"zh_hant\":\"目標鎖定\"},\"priority\":99},\"102\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":102,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ターゲット固定耐性\",\"en\":\"Aggro Resistance\",\"ko\":\"타깃 고정 저항\",\"zh_hant\":\"目標鎖定耐性\"},\"priority\":99},\"103\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":103,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"退場回避\",\"en\":\"Exit Evasion\",\"ko\":\"퇴장 회피\",\"zh_hant\":\"退場迴避\"},\"priority\":99},\"104\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":104,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_invincible_loop\",\"name\":{\"ja\":\"無敵\",\"en\":\"Invincible\",\"ko\":\"무적\",\"zh_hant\":\"無敵\"},\"priority\":99},\"105\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":105,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"AP減少\",\"en\":\"AP Down\",\"ko\":\"AP 감소\",\"zh_hant\":\"AP減少\"},\"priority\":99},\"106\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":106,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"AP増加\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"107\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":244,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"AP増加耐性\",\"en\":\"AP Up Resistance\",\"ko\":\"AP 증가 저항\",\"zh_hant\":\"AP增加耐性\"},\"priority\":99},\"110\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":106,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_invincible_loop\",\"name\":{\"ja\":\"(解除不可)AP増加\",\"en\":\"(Unremovable) AP Up\",\"ko\":\"(해제 불가) AP 증가\",\"zh_hant\":\"（無法解除）AP增加\"},\"priority\":99},\"111\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":50,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_para_loop\",\"name\":{\"ja\":\"(解除不可)スタン\",\"en\":\"(Unremovable) Stun\",\"ko\":\"(해제 불가) 스턴\",\"zh_hant\":\"（無法解除）暈眩\"},\"priority\":1},\"112\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":21,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_regeneration_loop\",\"name\":{\"ja\":\"(解除不可)毎ターンHP回復\",\"en\":\"(Unremovable) HP Regen\",\"ko\":\"(해제 불가) 매 턴마다 HP 회복\",\"zh_hant\":\"（無法解除）每回合HP回復\"},\"priority\":3},\"113\":{\"base_point\":2,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":5,\"chara_add_color\":[0.227,0.227,0.227],\"chara_color\":[0.384,0.384,0.384],\"chara_gray_scale\":1,\"icon_id\":53,\"is_lock\":1,\"is_motion_stop\":1,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ストップ\",\"en\":\"(Unremovable) Stop\",\"ko\":\"(해제 불가) 스톱\",\"zh_hant\":\"（無法解除）停止\"},\"priority\":1},\"114\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":38,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)カウンターヒール\",\"en\":\"(Unremovable) Counter Heal\",\"ko\":\"(해제 불가) 카운터 힐\",\"zh_hant\":\"（無法解除）還擊治療\"},\"priority\":99},\"117\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":117,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"全バフ・デバフ耐性\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"118\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":118,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"刻印耐性\",\"en\":\"Marked Resistance\",\"ko\":\"각인 저항\",\"zh_hant\":\"刻印耐性\"},\"priority\":99},\"119\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":119,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"イベントボスダメージダウン\",\"en\":\"Event Boss Dmg Reduction\",\"ko\":\"이벤트 BOSS 대미지 감소\",\"zh_hant\":\"減輕活動BOSS傷害\"},\"priority\":99},\"120\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT1封印\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"121\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT2封印\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"122\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT3封印\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"123\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":123,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT1封印耐性\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"124\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":124,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT2封印耐性\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"125\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":125,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT3封印耐性\",\"en\":\"\",\"ko\":\"\",\"zh_hant\":\"\"},\"priority\":99},\"126\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":126,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"キラめき獲得ダウン\",\"en\":\"Brilliance Recovery Reduction\",\"ko\":\"반짝임 획득 감소\",\"zh_hant\":\"獲得光芒減少\"},\"priority\":99},\"127\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":74,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"キラめき獲得ダウン耐性\",\"en\":\"Brilliance Recovery Reduction Resistance\",\"ko\":\"반짝임 획득 감소 저항\",\"zh_hant\":\"獲得光芒減少耐性\"},\"priority\":99},\"128\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":75,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毒耐性\",\"en\":\"(Unremovable) Poison Resistance\",\"ko\":\"(해제 불가) 독 저항\",\"zh_hant\":\"（無法解除）中毒耐性\"},\"priority\":99},\"129\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":76,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)火傷耐性\",\"en\":\"(Unremovable) Burn Resistance\",\"ko\":\"(해제 불가) 화상 저항\",\"zh_hant\":\"（無法解除）燒傷耐性\"},\"priority\":99},\"130\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":78,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)スタン耐性\",\"en\":\"(Unremovable) Stun Resistance\",\"ko\":\"(해제 불가) 스턴 저항\",\"zh_hant\":\"（無法解除）暈眩耐性\"},\"priority\":99},\"131\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":79,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)睡眠耐性\",\"en\":\"(Unremovable) Sleep Resistance\",\"ko\":\"(해제 불가) 수면 저항\",\"zh_hant\":\"（無法解除）睡眠耐性\"},\"priority\":99},\"132\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":80,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)混乱耐性\",\"en\":\"(Unremovable) Confusion Resistance\",\"ko\":\"(해제 불가) 혼란 저항\",\"zh_hant\":\"（無法解除）混亂耐性\"},\"priority\":99},\"133\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":81,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ストップ耐性\",\"en\":\"(Unremovable) Stop Resistance\",\"ko\":\"(해제 불가) 스톱 저항\",\"zh_hant\":\"（無法解除）停止耐性\"},\"priority\":99},\"134\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":82,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)凍結耐性\",\"en\":\"(Unremovable) Freeze Resistance\",\"ko\":\"(해제 불가) 동결 저항\",\"zh_hant\":\"（無法解除）凍結耐性\"},\"priority\":99},\"135\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":83,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)暗闇耐性\",\"en\":\"(Unremovable) Blindness Resistance\",\"ko\":\"(해제 불가) 암흑 저항\",\"zh_hant\":\"（無法解除）盲目耐性\"},\"priority\":99},\"136\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":127,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACTチェンジ（回数）\",\"en\":\"Act Change (Times)\",\"ko\":\"ACT 체인지(횟수)\",\"zh_hant\":\"ACT轉換（次數）\"},\"priority\":99},\"137\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":127,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACTチェンジ（ターン）\",\"en\":\"Act Change (Turn)\",\"ko\":\"ACT 체인지(턴)\",\"zh_hant\":\"ACT轉換（回合）\"},\"priority\":99},\"138\":{\"base_point\":3,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":52,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_confusion_loop\",\"name\":{\"ja\":\"(解除不可)混乱\",\"en\":\"(Unremovable) Confusion\",\"ko\":\"(해제 불가) 혼란\",\"zh_hant\":\"（無法解除）混亂\"},\"priority\":2},\"139\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":128,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"不倒\",\"en\":\"Resilience\",\"ko\":\"불멸\",\"zh_hant\":\"不倒\"},\"priority\":99},\"140\":{\"base_point\":3,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":47,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_poison_loop\",\"name\":{\"ja\":\"(解除不可)毒を付与\",\"en\":\"(Unremovable) Apply Poison\",\"ko\":\"(해제 불가)독을 부여\",\"zh_hant\":\"（無法解除）賦予中毒\"},\"priority\":3},\"141\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":48,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_fire_loop\",\"name\":{\"ja\":\"(解除不可)火傷を付与\",\"en\":\"(Unremovable) Apply Burn\",\"ko\":\"(해제 불가)화상을 부여\",\"zh_hant\":\"（無法解除）賦予燒傷\"},\"priority\":3},\"142\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":55,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_dark_loop\",\"name\":{\"ja\":\"(解除不可)暗闇を付与\",\"en\":\"(Unremovable) Apply Blindness\",\"ko\":\"(해제 불가)암흑을 부여\",\"zh_hant\":\"（無法解除）賦予盲目\"},\"priority\":2},\"143\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":58,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)HP回復量低下\",\"en\":\"(Unremovable) HP Recovery Reduction\",\"ko\":\"(해제 불가)HP 회복량 감소\",\"zh_hant\":\"（無法解除）降低HP回復量\"},\"priority\":99},\"144\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":131,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"継続ダメージ耐性\",\"en\":\"Cont. Dmg Resistance\",\"ko\":\"지속 대미지 저항\",\"zh_hant\":\"持續性傷害耐性\"},\"priority\":99},\"145\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":75,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"猛毒耐性\",\"en\":\"Strong Poison Resistance\",\"ko\":\"맹독 저항\",\"zh_hant\":\"猛毒耐性\"},\"priority\":99},\"146\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":76,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"大火傷耐性\",\"en\":\"Heavy Burn Resistance\",\"ko\":\"대화상 저항\",\"zh_hant\":\"嚴重燒傷耐性\"},\"priority\":99},\"147\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":147,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花属性被ダメージアップ\",\"en\":\"Flower Dmg Received Up\",\"ko\":\"꽃 속성被대미지アップ\",\"zh_hant\":\"花屬性被傷害提升\"},\"priority\":99},\"148\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":148,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"風属性被ダメージアップ\",\"en\":\"Wind Dmg Received Up\",\"ko\":\"바람 속성被대미지アップ\",\"zh_hant\":\"風屬性被傷害提升\"},\"priority\":99},\"149\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":149,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪属性被ダメージアップ\",\"en\":\"Snow Dmg Received Up\",\"ko\":\"눈속성被대미지アップ\",\"zh_hant\":\"雪屬性被傷害提升\"},\"priority\":99},\"150\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":150,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"月属性被ダメージアップ\",\"en\":\"Moon Dmg Received Up\",\"ko\":\"달 속성被대미지アップ\",\"zh_hant\":\"月屬性被傷害提升\"},\"priority\":99},\"151\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":151,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"宙属性被ダメージアップ\",\"en\":\"Space Dmg Received Up\",\"ko\":\"우주 속성被대미지アップ\",\"zh_hant\":\"宙屬性被傷害提升\"},\"priority\":99},\"152\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":152,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雲属性被ダメージアップ\",\"en\":\"Cloud Dmg Received Up\",\"ko\":\"구름 속성被대미지アップ\",\"zh_hant\":\"雲屬性被傷害提升\"},\"priority\":99},\"153\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":153,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢属性被ダメージアップ\",\"en\":\"Dream Dmg Received Up\",\"ko\":\"꿈 속성被대미지アップ\",\"zh_hant\":\"夢屬性被傷害提升\"},\"priority\":99},\"154\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":154,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花属性与ダメージダウン\",\"en\":\"Flower Dmg dealt Down\",\"ko\":\"꽃 속성与대미지ダウン\",\"zh_hant\":\"花屬性与傷害降低\"},\"priority\":99},\"155\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":155,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"風属性与ダメージダウン\",\"en\":\"Wind Dmg dealt Down\",\"ko\":\"바람 속성与대미지ダウン\",\"zh_hant\":\"風屬性与傷害降低\"},\"priority\":99},\"156\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":156,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪属性与ダメージダウン\",\"en\":\"Snow Dmg dealt Down\",\"ko\":\"눈속성与대미지ダウン\",\"zh_hant\":\"雪屬性与傷害降低\"},\"priority\":99},\"157\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":157,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"月属性与ダメージダウン\",\"en\":\"Moon Dmg dealt Down\",\"ko\":\"달 속성与대미지ダウン\",\"zh_hant\":\"月屬性与傷害降低\"},\"priority\":99},\"158\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":158,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"宙属性与ダメージダウン\",\"en\":\"Space Dmg dealt Down\",\"ko\":\"우주 속성与대미지ダウン\",\"zh_hant\":\"宙屬性与傷害降低\"},\"priority\":99},\"159\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":159,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雲属性与ダメージダウン\",\"en\":\"Cloud Dmg dealt Down\",\"ko\":\"구름 속성与대미지ダウン\",\"zh_hant\":\"雲屬性与傷害降低\"},\"priority\":99},\"160\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":160,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢属性与ダメージダウン\",\"en\":\"Dream Dmg dealt Down\",\"ko\":\"꿈 속성与대미지ダウン\",\"zh_hant\":\"夢屬性与傷害降低\"},\"priority\":99},\"161\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":161,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クライマックスACT威力ダウン\",\"en\":\"Climax Act Power Down\",\"ko\":\"클라이맥스 ACT 위력 감소\",\"zh_hant\":\"降低CLIMAX ACT威力\"},\"priority\":99},\"162\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":162,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_lovesickness_loop\",\"name\":{\"ja\":\"恋わずらい\",\"en\":\"Lovesickness\",\"ko\":\"상사병\",\"zh_hant\":\"苦戀\"},\"priority\":1},\"163\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":162,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_lovesickness_loop\",\"name\":{\"ja\":\"(解除不可)恋わずらい\",\"en\":\"(Unremovable) Lovesickness\",\"ko\":\"(해제 불가) 상사병\",\"zh_hant\":\"（無法解除）苦戀\"},\"priority\":1},\"164\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":246,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"恋わずらい耐性\",\"en\":\"Lovesickness Resistance\",\"ko\":\"상사병 저항\",\"zh_hant\":\"苦戀耐性\"},\"priority\":99},\"165\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":246,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)恋わずらい耐性\",\"en\":\"(Unremovable) Lovesickness Resistance\",\"ko\":\"(해제 불가) 상사병 저항\",\"zh_hant\":\"（無法解除）苦戀耐性\"},\"priority\":99},\"166\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":19,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)継続マイナス効果耐性アップ\",\"en\":\"(Unremovable) Cont. Neg. Effects Resistance\",\"ko\":\"(해제 불가) 지속 마이너스 효과 저항\",\"zh_hant\":\"（無法解除）持續性負面效果耐性\"},\"priority\":99},\"167\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"クライマックスACT封印\",\"en\":\"Seal CA\",\"ko\":\"CA 봉인\",\"zh_hant\":\"CA封印\"},\"priority\":99},\"168\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)クライマックスACT封印\",\"en\":\"(Unremovable) Seal CA\",\"ko\":\"(해제 불가) CA 봉인\",\"zh_hant\":\"（無法解除）CA封印\"},\"priority\":99},\"169\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":163,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"感電\",\"en\":\"Electric Shock\",\"ko\":\"감전\",\"zh_hant\":\"感電\"},\"priority\":99},\"170\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":163,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)感電\",\"en\":\"(Unremovable) Electric Shock\",\"ko\":\"(해제 불가) 감전\",\"zh_hant\":\"（無法解除）感電\"},\"priority\":99},\"171\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":245,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"感電耐性\",\"en\":\"Electric Shock Resistance\",\"ko\":\"감전 저항\",\"zh_hant\":\"感電耐性\"},\"priority\":99},\"172\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)感電耐性\",\"en\":\"(Unremovable) Electric Shock Resistance\",\"ko\":\"(해제 불가) 감전 저항\",\"zh_hant\":\"（無法解除）感電耐性\"},\"priority\":99},\"173\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":164,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"起死回生\",\"en\":\"Revive\",\"ko\":\"기사회생\",\"zh_hant\":\"起死回生\"},\"priority\":99},\"174\":{\"base_point\":2,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":165,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_lovesickness_loop\",\"name\":{\"ja\":\"悪夢\",\"en\":\"Nightmare\",\"ko\":\"악몽\",\"zh_hant\":\"惡夢\"},\"priority\":1},\"175\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"継続プラス効果耐性アップ\",\"en\":\"Cont. Pos. Effects Immunity\",\"ko\":\"지속 플러스 효과 무효\",\"zh_hant\":\"持續性正面效果無効\"},\"priority\":99},\"176\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)継続プラス効果無効\",\"en\":\"(Unremovable) Cont. Pos. Effects Immunity\",\"ko\":\"(해제 불가) 지속 플러스 효과 무효\",\"zh_hant\":\"（無法解除）持續性正面效果無効\"},\"priority\":99},\"177\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"プラス効果無効\",\"en\":\"Pos. Effects Immunity\",\"ko\":\"플러스 효과 무효\",\"zh_hant\":\"正面效果無効\"},\"priority\":99},\"178\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)プラス効果無効\",\"en\":\"(Unremovable) Pos. Effects Immunity\",\"ko\":\"(해제 불가) 플러스 효과 무효\",\"zh_hant\":\"（無法解除）正面效果無効\"},\"priority\":99},\"179\":{\"base_point\":3,\"card_abnormal_priority\":2,\"card_abnormal_type\":2,\"category\":3,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":167,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_confusion_loop\",\"name\":{\"ja\":\"錯乱\",\"en\":\"Daze\",\"ko\":\"착란\",\"zh_hant\":\"錯亂\"},\"priority\":2},\"180\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":2,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":168,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_lovesickness_loop\",\"name\":{\"ja\":\"慢心\",\"en\":\"Impudence\",\"ko\":\"방심\",\"zh_hant\":\"傲慢\"},\"priority\":99},\"181\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":169,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"希望\",\"en\":\"Hope\",\"ko\":\"희망\",\"zh_hant\":\"希望\"},\"priority\":99},\"182\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":170,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"急所\",\"en\":\"Weak Spot\",\"ko\":\"급소\",\"zh_hant\":\"要害\"},\"priority\":99},\"183\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":8,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"すばやさ固定値アップ\",\"en\":\"Fixed Agility Boost\",\"ko\":\"민첩 고정값 증가\",\"zh_hant\":\"提升敏捷固定値\"},\"priority\":99},\"184\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":17,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"最大HP固定値アップ\",\"en\":\"Fixed Max HP Boost\",\"ko\":\"최대 HP 고정값 증가\",\"zh_hant\":\"提升最大HP固定值\"},\"priority\":99},\"185\":{\"base_point\":2,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":5,\"chara_add_color\":[0.288,0.482,0.522],\"chara_color\":[0.529,0.859,0.852],\"chara_gray_scale\":0,\"icon_id\":171,\"is_lock\":0,\"is_motion_stop\":1,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"凍傷\",\"en\":\"Frostbite\",\"ko\":\"동상\",\"zh_hant\":\"凍傷\"},\"priority\":2},\"186\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"聖翔音楽学園の舞台少女への与ダメージアップ\",\"en\":\"Dmg to Seisho Stage Girls Up\",\"ko\":\"세이쇼 음악학교의 무대소녀에게 가하는 대미지 증가\",\"zh_hant\":\"提升對聖翔音樂學院之舞台少女造成的傷害\"},\"priority\":99},\"187\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"凛明館女学校の舞台少女への与ダメージアップ\",\"en\":\"Dmg to Rinmeikan Stage Girls Up\",\"ko\":\"린메이칸 여학교의 무대소녀에게 가하는 대미지 증가\",\"zh_hant\":\"提升對凜明館女子學校之舞台少女造成的傷害\"},\"priority\":99},\"188\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"フロンティア芸術学校の舞台少女への与ダメージアップ\",\"en\":\"Dmg to Frontier Stage Girls Up\",\"ko\":\"프론티어 예술학교의 무대소녀에게 가하는 대미지 증가\",\"zh_hant\":\"提升對芙羅提亞藝術學校之舞台少女造成的傷害\"},\"priority\":99},\"189\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"シークフェルト音楽学院の舞台少女への与ダメージアップ\",\"en\":\"Dmg to Siegfeld Stage Girls Up\",\"ko\":\"시크펠트 음악학원의 무대소녀에게 가하는 대미지 증가\",\"zh_hant\":\"提升對席格菲特音樂學院之舞台少女造成的傷害\"},\"priority\":99},\"190\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"青嵐総合芸術院の舞台少女への与ダメージアップ\",\"en\":\"Dmg to Seiran Stage Girls Up\",\"ko\":\"세이란 종합 예술학원의 무대소녀에게 가하는 대미지 증가\",\"zh_hant\":\"提升對青嵐總合藝術學院之舞台少女造成的傷害\"},\"priority\":99},\"191\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"愛城華恋からの被ダメージアップ\",\"en\":\"Dmg Received from Karen Aijo Up\",\"ko\":\"아이조 카렌에게 받는 대미지 증가\",\"zh_hant\":\"提升被愛城華戀攻擊時受到的傷害\"},\"priority\":99},\"192\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"神楽ひかりからの被ダメージアップ\",\"en\":\"Dmg Received from Hikari Kagura Up\",\"ko\":\"카구라 히카리에게 받는 대미지 증가\",\"zh_hant\":\"提升被神樂光攻擊時受到的傷害\"},\"priority\":99},\"193\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"露崎まひるからの被ダメージアップ\",\"en\":\"Dmg Received from Mahiru Tsuyuzaki Up\",\"ko\":\"츠유자키 마히루에게 받는 대미지 증가\",\"zh_hant\":\"提升被露崎真晝攻擊時受到的傷害\"},\"priority\":99},\"194\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"西條クロディーヌからの被ダメージアップ\",\"en\":\"Dmg Received from Claudine Saijo Up\",\"ko\":\"사이조 클로딘에게 받는 대미지 증가\",\"zh_hant\":\"提升被西條克洛迪娜攻擊時受到的傷害\"},\"priority\":99},\"195\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"天堂真矢からの被ダメージアップ\",\"en\":\"Dmg Received from Maya Tendo Up\",\"ko\":\"텐도 마야에게 받는 대미지 증가\",\"zh_hant\":\"提升被天堂真矢攻擊時受到的傷害\"},\"priority\":99},\"196\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"星見純那からの被ダメージアップ\",\"en\":\"Dmg Received from Junna Hoshimi Up\",\"ko\":\"호시미 준나에게 받는 대미지 증가\",\"zh_hant\":\"提升被星見純那攻擊時受到的傷害\"},\"priority\":99},\"197\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"大場ななからの被ダメージアップ\",\"en\":\"Dmg Received from Nana Daiba Up\",\"ko\":\"다이바 나나에게 받는 대미지 증가\",\"zh_hant\":\"提升被大場奈奈攻擊時受到的傷害\"},\"priority\":99},\"198\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"石動双葉からの被ダメージアップ\",\"en\":\"Dmg Received from Futaba Isurugi Up\",\"ko\":\"이스루기 후타바에게 받는 대미지 증가\",\"zh_hant\":\"提升被石動雙葉攻擊時受到的傷害\"},\"priority\":99},\"199\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"花柳香子からの被ダメージアップ\",\"en\":\"Dmg Received from Kaoruko Hanayagi Up\",\"ko\":\"하나야기 카오루코에게 받는 대미지 증가\",\"zh_hant\":\"提升被花柳香子攻擊時受到的傷害\"},\"priority\":99},\"200\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"巴珠緒からの被ダメージアップ\",\"en\":\"Dmg Received from Tamao Tomoe Up\",\"ko\":\"토모에 타마오에게 받는 대미지 증가\",\"zh_hant\":\"提升被巴珠緒攻擊時受到的傷害\"},\"priority\":99},\"201\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"音無いちえからの被ダメージアップ\",\"en\":\"Dmg Received from Ichie Otonashi Up\",\"ko\":\"오토나시 이치에에게 받는 대미지 증가\",\"zh_hant\":\"提升被音無一愛攻擊時受到的傷害\"},\"priority\":99},\"202\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢大路文からの被ダメージアップ\",\"en\":\"Dmg Received from Fumi Yumeoji Up\",\"ko\":\"유메오지 후미에게 받는 대미지 증가\",\"zh_hant\":\"提升被夢大路文攻擊時受到的傷害\"},\"priority\":99},\"203\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"秋風塁からの被ダメージアップ\",\"en\":\"Dmg Received from Rui Akikaze Up\",\"ko\":\"아키카제 루이에게 받는 대미지 증가\",\"zh_hant\":\"提升被秋風壘攻擊時受到的傷害\"},\"priority\":99},\"204\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"田中ゆゆ子からの被ダメージアップ\",\"en\":\"Dmg Received from Yuyuko Tanaka Up\",\"ko\":\"타나카 유유코에게 받는 대미지 증가\",\"zh_hant\":\"提升被田中悠悠子攻擊時受到的傷害\"},\"priority\":99},\"205\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"大月あるるからの被ダメージアップ\",\"en\":\"Dmg Received from Aruru Otsuki Up\",\"ko\":\"오츠키 아루루에게 받는 대미지 증가\",\"zh_hant\":\"提升被大月艾露露攻擊時受到的傷害\"},\"priority\":99},\"206\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"叶美空からの被ダメージアップ\",\"en\":\"Dmg Received from Misora Kano Up\",\"ko\":\"카노 미소라에게 받는 대미지 증가\",\"zh_hant\":\"提升被葉美空攻擊時受到的傷害\"},\"priority\":99},\"207\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"野々宮ララフィンからの被ダメージアップ\",\"en\":\"Dmg Received from Lalafin Nonomiya Up\",\"ko\":\"노노미야 라라핀에게 받는 대미지 증가\",\"zh_hant\":\"提升被野野宮菈樂菲攻擊時受到的傷害\"},\"priority\":99},\"208\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"恵比寿つかさからの被ダメージアップ\",\"en\":\"Dmg Received from Tsukasa Ebisu Up\",\"ko\":\"에비스 츠카사에게 받는 대미지 증가\",\"zh_hant\":\"提升被惠比壽司攻擊時受到的傷害\"},\"priority\":99},\"209\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"胡蝶静羽からの被ダメージアップ\",\"en\":\"Dmg Received from Shizuha Kocho Up\",\"ko\":\"코쵸 시즈하에게 받는 대미지 증가\",\"zh_hant\":\"提升被胡蝶靜羽攻擊時受到的傷害\"},\"priority\":99},\"210\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"雪代晶からの被ダメージアップ\",\"en\":\"Dmg Received from Akira Yukishiro Up\",\"ko\":\"유키시로 아키라에게 받는 대미지 증가\",\"zh_hant\":\"提升被雪代晶攻擊時受到的傷害\"},\"priority\":99},\"211\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"鳳ミチルからの被ダメージアップ\",\"en\":\"Dmg Received from Michiru Otori Up\",\"ko\":\"오토리 미치루에게 받는 대미지 증가\",\"zh_hant\":\"提升被鳳未知留攻擊時受到的傷害\"},\"priority\":99},\"212\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"リュウ・メイファンからの被ダメージアップ\",\"en\":\"Dmg Received from Liu Mei Fan Up\",\"ko\":\"류 메이팡에게 받는 대미지 증가\",\"zh_hant\":\"提升被柳美帆攻擊時受到的傷害\"},\"priority\":99},\"213\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"夢大路栞からの被ダメージアップ\",\"en\":\"Dmg Received from Shiori Yumeoji Up\",\"ko\":\"유메오지 시오리에게 받는 대미지 증가\",\"zh_hant\":\"提升被夢大路栞攻擊時受到的傷害\"},\"priority\":99},\"214\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"鶴姫やちよからの被ダメージアップ\",\"en\":\"Dmg Received from Yachiyo Tsuruhime Up\",\"ko\":\"츠루히메 야치요에게 받는 대미지 증가\",\"zh_hant\":\"提升被鶴姬八千代攻擊時受到的傷害\"},\"priority\":99},\"215\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"柳小春からの被ダメージアップ\",\"en\":\"Dmg Received from Koharu Yanagi Up\",\"ko\":\"야나기 코하루에게 받는 대미지 증가\",\"zh_hant\":\"提升被柳小春攻擊時受到的傷害\"},\"priority\":99},\"216\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"南風涼からの被ダメージアップ\",\"en\":\"Dmg Received from Suzu Minase Up\",\"ko\":\"미나세 스즈에게 받는 대미지 증가\",\"zh_hant\":\"提升被南風涼攻擊時受到的傷害\"},\"priority\":99},\"217\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"穂波氷雨からの被ダメージアップ\",\"en\":\"Dmg Received from Hisame Honami Up\",\"ko\":\"호나미 히사메에게 받는 대미지 증가\",\"zh_hant\":\"提升被穗波冰雨攻擊時受到的傷害\"},\"priority\":99},\"218\":{\"base_point\":2,\"card_abnormal_priority\":1,\"card_abnormal_type\":1,\"category\":5,\"chara_add_color\":[0.227,0.227,0.227],\"chara_color\":[0.384,0.384,0.384],\"chara_gray_scale\":1,\"icon_id\":172,\"is_lock\":0,\"is_motion_stop\":1,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"悶絶\",\"en\":\"Agony\",\"ko\":\"민절\",\"zh_hant\":\"窒息\"},\"priority\":1},\"219\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":101,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ターゲット固定\",\"en\":\"(Unremovable) Aggro\",\"ko\":\"(해제 불가) 타깃 고정\",\"zh_hant\":\"（無法解除）目標鎖定\"},\"priority\":99},\"220\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ACT1封印\",\"en\":\"(Unremovable) Seal Act 1\",\"ko\":\"(해제 불가) ACT1 봉인\",\"zh_hant\":\"（無法解除）ACT1封印\"},\"priority\":99},\"221\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ACT2封印\",\"en\":\"(Unremovable) Seal Act 2\",\"ko\":\"(해제 불가) ACT2 봉인\",\"zh_hant\":\"（無法解除）ACT2封印\"},\"priority\":99},\"222\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":122,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)ACT3封印\",\"en\":\"(Unremovable) Seal Act 3\",\"ko\":\"(해제 불가) ACT3 봉인\",\"zh_hant\":\"（無法解除）ACT3封印\"},\"priority\":99},\"223\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":23,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_def_barrier_loop\",\"name\":{\"ja\":\"(解除不可)通常バリア\",\"en\":\"(Unremovable) Normal Barrier\",\"ko\":\"(해제 불가) 일반 배리어\",\"zh_hant\":\"（無法解除）普通防護罩\"},\"priority\":99},\"224\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":24,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_mdef_barrier_loop\",\"name\":{\"ja\":\"(解除不可)特殊バリア\",\"en\":\"(Unremovable) Special Barrier\",\"ko\":\"(해제 불가) 특수 배리어\",\"zh_hant\":\"（無法解除）特殊防護罩\"},\"priority\":99},\"225\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":173,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"神がかり\",\"en\":\"Possession\",\"ko\":\"신내림\",\"zh_hant\":\"神靈附體\"},\"priority\":99},\"226\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":173,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)神がかり\",\"en\":\"(Unremovable) Possession\",\"ko\":\"(해제 불가) 신내림\",\"zh_hant\":\"（無法解除）神靈附體\"},\"priority\":99},\"227\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":105,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可AP減少\",\"en\":\"(Unremovable) AP Down\",\"ko\":\"(해제 불가) AP 감소\",\"zh_hant\":\"（無法解除）AP減少\"},\"priority\":99},\"228\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":15,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可クリティカル威力アップ\",\"en\":\"(Unremovable) Critical Up\",\"ko\":\"(해제 불가) 크리티컬 위력 증가\",\"zh_hant\":\"（無法解除）提升會心威力\"},\"priority\":99},\"229\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":174,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"幕引き\",\"en\":\"Curtains Closed\",\"ko\":\"폐막\",\"zh_hant\":\"閉幕\"},\"priority\":99},\"230\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":174,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)幕引き\",\"en\":\"(Unremovable) Curtains Closed\",\"ko\":\"(해제 불가) 폐막\",\"zh_hant\":\"（無法解除）閉幕\"},\"priority\":99},\"231\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":250,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回数マイナス効果耐性アップ\",\"en\":\"Count. Neg. Effects Resistance\",\"ko\":\"횟수 마이너스 효과 저항\",\"zh_hant\":\"次數性負面效果耐性\"},\"priority\":99},\"232\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":250,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)回数マイナス効果耐性アップ\",\"en\":\"(Unremovable) Count. Neg. Effects Resistance\",\"ko\":\"(해제 불가) 횟수 마이너스 효과 저항\",\"zh_hant\":\"（無法解除）次數性負面效果耐性\"},\"priority\":99},\"233\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":251,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"キラめき獲得増加\",\"en\":\"Brilliance Recovery Increase\",\"ko\":\"반짝임 획득 증가\",\"zh_hant\":\"獲得光芒增加\"},\"priority\":99},\"234\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":128,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)不倒\",\"en\":\"(Unremovable) Resilience\",\"ko\":\"(해제 불가) 불멸\",\"zh_hant\":\"（無法解除）不倒\"},\"priority\":99},\"235\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":106,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"AP増加2\",\"en\":\"AP Up 2\",\"ko\":\"AP 증가2\",\"zh_hant\":\"AP增加2\"},\"priority\":99},\"236\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":106,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)AP増加2\",\"en\":\"(Unremovable) AP Up 2\",\"ko\":\"(해제 불가) AP 증가2\",\"zh_hant\":\"（無法解除）AP增加2\"},\"priority\":99},\"237\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":105,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"AP減少2\",\"en\":\"AP Down 2\",\"ko\":\"AP 감소2\",\"zh_hant\":\"AP減少2\"},\"priority\":99},\"238\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":105,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)AP減少2\",\"en\":\"(Unremovable) AP Down 2\",\"ko\":\"(해제 불가) AP 감소2\",\"zh_hant\":\"（無法解除）AP減少2\"},\"priority\":99},\"239\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"カットインスキル発動準備ターン短縮\",\"en\":\"Shorten Instant Skill Turn Activation\",\"ko\":\"컷인 스킬 발동 준비 턴 단축\",\"zh_hant\":\"縮短切入技能的發動準備回合\"},\"priority\":99},\"240\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":38,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"カウンターヒール\",\"en\":\"Counter Heal\",\"ko\":\"카운터 힐\",\"zh_hant\":\"還擊治療\"},\"priority\":99},\"241\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":252,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"手加減\",\"en\":\"Hold Back\",\"ko\":\"봐주기\",\"zh_hant\":\"心軟\"},\"priority\":99},\"242\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":253,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"舞台効果付与封印\",\"en\":\"Seal Stage Effect\",\"ko\":\"무대 효과 부여 봉인\",\"zh_hant\":\"舞台效果封印\"},\"priority\":99},\"243\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":253,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)舞台効果付与封印\",\"en\":\"(Unremovable) Seal Stage Effect\",\"ko\":\"(해제 불가) 무대 효과 부여 봉인\",\"zh_hant\":\"（無法解除）舞台效果封印\"},\"priority\":99},\"244\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT追加1\",\"en\":\"Adds Acts 1\",\"ko\":\"ACT 추가1\",\"zh_hant\":\"ACT追加1\"},\"priority\":99},\"245\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"ACT追加2\",\"en\":\"Adds Acts 2\",\"ko\":\"ACT 추가2\",\"zh_hant\":\"ACT追加2\"},\"priority\":99},\"246\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"遮断壁\",\"en\":\"Bulkhead\",\"ko\":\"\",\"zh_hant\":\"隔絕屏障\"},\"priority\":99},\"247\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"誓いのレヴューキラー\",\"en\":\"Anti-Oath Revue\",\"ko\":\"맹세의 레뷰 킬러\",\"zh_hant\":\"誓言的Revue殺手\"},\"priority\":99},\"248\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":254,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"災難[キラめき減少]\",\"en\":\"Disaster [Brilliance Reduction]\",\"ko\":\"재난 [반짝임 감소]\",\"zh_hant\":\"災難[光芒減少]\"},\"priority\":99},\"249\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":255,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[HP回復]\",\"en\":\"Blessing [HP Recovery]\",\"ko\":\"축복 [HP 회복]\",\"zh_hant\":\"祝福[回復HP]\"},\"priority\":99},\"250\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":256,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[回数マイナス効果減少]\",\"en\":\"Blessing [Count. Neg. Effects Reduction]\",\"ko\":\"축복 [횟수 마이너스 효과 감소]\",\"zh_hant\":\"祝福[次數性負面效果減少]\"},\"priority\":99},\"251\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":257,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"災難[錯乱]\",\"en\":\"Disaster [Daze]\",\"ko\":\"재난 [착란]\",\"zh_hant\":\"災難[錯亂]\"},\"priority\":99},\"252\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":258,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[継続マイナス効果解除]\",\"en\":\"Blessing [Dispel Cont. Neg. Effects]\",\"ko\":\"축복 [지속 마이너스 효과 해제]\",\"zh_hant\":\"祝福[解除持續性負面效果]\"},\"priority\":99},\"253\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":259,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"錯乱耐性\",\"en\":\"Daze Resistance\",\"ko\":\"착란 저항\",\"zh_hant\":\"錯亂耐性\"},\"priority\":99},\"254\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":259,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)錯乱耐性\",\"en\":\"(Unremovable) Daze Resistance\",\"ko\":\"(해제 불가) 착란 저항\",\"zh_hant\":\"（無法解除）錯亂耐性\"},\"priority\":99},\"255\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":260,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[希望]\",\"en\":\"Blessing [Hope]\",\"ko\":\"축복 [희망]\",\"zh_hant\":\"祝福[希望]\"},\"priority\":99},\"256\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":261,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"慢心耐性\",\"en\":\"Impudence Resistance\",\"ko\":\"방심 저항\",\"zh_hant\":\"傲慢耐性\"},\"priority\":99},\"257\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":261,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可慢心耐性\",\"en\":\"(Unremovable) Impudence Resistance\",\"ko\":\"(해제 불가) 방심 저항\",\"zh_hant\":\"（無法解除）傲慢耐性\"},\"priority\":99},\"258\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":262,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_def_reflect_loop\",\"name\":{\"ja\":\"通常ダメージ超反射\",\"en\":\"Super Reflect Normal Dmg\",\"ko\":\"일반 대미지 슈퍼 반사\",\"zh_hant\":\"超反射普通傷害\"},\"priority\":99},\"259\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":263,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_mdef_reflect_loop\",\"name\":{\"ja\":\"特殊ダメージ超反射\",\"en\":\"Super Reflect Special Dmg\",\"ko\":\"특수 대미지 슈퍼 반사\",\"zh_hant\":\"超反射特殊傷害\"},\"priority\":99},\"260\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":262,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_def_reflect_loop\",\"name\":{\"ja\":\"(解除不可)通常ダメージ超反射\",\"en\":\"(Unremovable) Super Reflect Normal Dmg\",\"ko\":\"(해제 불가)일반 대미지 슈퍼 반사\",\"zh_hant\":\"（無法解除）超反射普通傷害\"},\"priority\":99},\"261\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":4,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":263,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_mdef_reflect_loop\",\"name\":{\"ja\":\"(解除不可)特殊ダメージ超反射\",\"en\":\"(Unremovable) Super Reflect Special Dmg\",\"ko\":\"(해제 불가)특수 대미지 슈퍼 반사\",\"zh_hant\":\"（無法解除）超反射特殊傷害\"},\"priority\":99},\"262\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":264,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[有利属性ダメージアップ]\",\"en\":\"Blessing [Effective Element Dmg Up]\",\"ko\":\"축복 [유리한 속성 대미지 증가]\",\"zh_hant\":\"祝福[提升有利屬性傷害]\"},\"priority\":99},\"263\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":265,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"無敵の再生者\",\"en\":\"Invincible Rebirth\",\"ko\":\"무적의 재생자\",\"zh_hant\":\"無敵重生者\"},\"priority\":99},\"264\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":266,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"殉葬\",\"en\":\"Sacrifice\",\"ko\":\"순장\",\"zh_hant\":\"殉葬\"},\"priority\":99},\"265\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":267,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"災難[AP増加]\",\"en\":\"Disaster [AP Up]\",\"ko\":\"재난[AP 증가]\",\"zh_hant\":\"災難[AP增加]\"},\"priority\":99},\"266\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":268,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"祝福[AP減少2]\",\"en\":\"Blessing [AP Down 2]\",\"ko\":\"축복[AP 감소2]\",\"zh_hant\":\"祝福[AP減少2]\"},\"priority\":99},\"267\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":269,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"狭窄\",\"en\":\"Contraction\",\"ko\":\"협착\",\"zh_hant\":\"視野收窄\"},\"priority\":99},\"268\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":21,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_regeneration_loop\",\"name\":{\"ja\":\"毎ターンHP回復\",\"en\":\"HP Regen\",\"ko\":\"매 턴마다 HP 회복\",\"zh_hant\":\"每回合HP回復\"},\"priority\":3},\"269\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":270,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"カットインスキル封印\",\"en\":\"Seal Instant Skill\",\"ko\":\"컷인 스킬 봉인\",\"zh_hant\":\"切入技能封印\"},\"priority\":99},\"270\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":270,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)カットインスキル封印\",\"en\":\"(Unremovable) Seal Instant Skill\",\"ko\":\"(해제 불가) 컷인 스킬 봉인\",\"zh_hant\":\"（無法解除）切入技能封印\"},\"priority\":99},\"271\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"回数プラス効果耐性アップ\",\"en\":\"Count. Pos. Effects Resistance Up\",\"ko\":\"횟수 플러스 효과 저항 증가\",\"zh_hant\":\"提升次數性正面效果耐性\"},\"priority\":99},\"272\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":166,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)回数プラス効果耐性アップ\",\"en\":\"(Unremovable) Count. Pos. Effects Resistance Up\",\"ko\":\"(해제 불가) 횟수 플러스 효과 저항 증가\",\"zh_hant\":\"（無法解除）提升次數性正面效果耐性\"},\"priority\":99},\"273\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":28,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)必中\",\"en\":\"(Unremovable) Perfect Aim\",\"ko\":\"(해제 불가) 백발백중\",\"zh_hant\":\"（無法解除）必中\"},\"priority\":99},\"274\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":0,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"HP最大時ACTパワーアップ\",\"en\":\"Act Power Up when Max HP\",\"ko\":\"HP가 최대일 때 ACT 파워 증가\",\"zh_hant\":\"HP全滿時，提升ACT力量\"},\"priority\":99},\"275\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":272,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"圧倒\",\"en\":\"Overwhelm\",\"ko\":\"압도\",\"zh_hant\":\"壓倒\"},\"priority\":99},\"276\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":273,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"連続クライマックスACT化\",\"en\":\"Multiple CA-fication\",\"ko\":\"연속 클라이맥스 ACT화\",\"zh_hant\":\"連續CLIMAX ACT化\"},\"priority\":99},\"277\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":274,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターンキラめき減少\",\"en\":\"Brilliance Sap\",\"ko\":\"매 턴마다 반짝임 감소\",\"zh_hant\":\"每回合減少光芒\"},\"priority\":4},\"278\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":32,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"属性有利ダメージUP\",\"en\":\"Effective Element Dmg Up\",\"ko\":\"속성 유리 대미지 증가\",\"zh_hant\":\"屬性有利傷害UP\"},\"priority\":99},\"279\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":22,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターンキラめき回復\"},\"priority\":4},\"280\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":275,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン起死回生付与\"},\"priority\":4},\"281\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":104,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":1,\"loop_filename\":\"hit_invincible_loop\",\"name\":{\"ja\":\"(解除不可)無敵\",\"en\":\"(Unremovable) Invincible\",\"ko\":\"(해제 불가) 무적\",\"zh_hant\":\"（無法解除）無敵\"},\"priority\":99},\"282\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":276,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"舞台効果付与封印耐性アップ\",\"en\":\"Seal Stage Effect Resistance Up\",\"ko\":\"무대 효과 부여 봉인 저항 증가\",\"zh_hant\":\"提升舞台效果封印耐性\"},\"priority\":99},\"283\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":1,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":276,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)舞台効果付与封印耐性アップ\"},\"priority\":99},\"284\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":277,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン継続マイナス効果解除\"},\"priority\":4},\"285\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":277,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターン継続マイナス効果解除\"},\"priority\":4},\"286\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":278,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン回数マイナス効果解除\"},\"priority\":4},\"287\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":278,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターン回数マイナス効果解除\"},\"priority\":4},\"288\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":279,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン継続プラス効果解除\"},\"priority\":4},\"289\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":279,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターン継続プラス効果解除\"},\"priority\":4},\"290\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":280,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"怪力\"},\"priority\":99},\"292\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":281,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン怪力付与\"},\"priority\":4},\"293\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":281,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターン怪力付与\"},\"priority\":4},\"294\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":282,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"エール\"},\"priority\":99},\"297\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":285,\"is_lock\":0,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"毎ターン回数マイナス効果減少\"},\"priority\":4},\"298\":{\"base_point\":2,\"card_abnormal_priority\":99,\"card_abnormal_type\":0,\"category\":2,\"chara_add_color\":[0,0,0],\"chara_color\":[1,1,1],\"chara_gray_scale\":0,\"icon_id\":285,\"is_lock\":1,\"is_motion_stop\":0,\"loop\":0,\"loop_filename\":\"\",\"name\":{\"ja\":\"(解除不可)毎ターン回数マイナス効果減少\"},\"priority\":4}}")
