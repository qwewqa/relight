package xyz.qwewqa.relive.simulator.core.gen

/*
1:
  _id_: 1
  description:
    en: Start of Turn
    ja: ターン開始時
    ko: 턴 시작 시
    zh_hant: 回合開始時
2:
  _id_: 2
  description:
    en: End of Turn
    ja: ターン終了時
    ko: 턴 종료 시
    zh_hant: 回合結束時
1001:
  _id_: 1001
  description:
    en: Before 1st Ally Act
    ja: 味方の1番目のACT実行前
    ko: 아군의 첫 번째 ACT 실행 전
    zh_hant: 在我方發動第1個ACT前
1002:
  _id_: 1002
  description:
    en: Before 2nd Ally Act
    ja: 味方の2番目のACT実行前
    ko: 아군의 두 번째 ACT 실행 전
    zh_hant: 在我方發動第2個ACT前
1003:
  _id_: 1003
  description:
    en: Before 3rd Ally Act
    ja: 味方の3番目のACT実行前
    ko: 아군의 세 번째 ACT 실행 전
    zh_hant: 在我方發動第3個ACT前
1004:
  _id_: 1004
  description:
    en: Before 4th Ally Act
    ja: 味方の4番目のACT実行前
    ko: 아군의 네 번째 ACT 실행 전
    zh_hant: 在我方發動第4個ACT前
1005:
  _id_: 1005
  description:
    en: Before 5th Ally Act
    ja: 味方の5番目のACT実行前
    ko: 아군의 다섯 번째 ACT 실행 전
    zh_hant: 在我方發動第5個ACT前
1101:
  _id_: 1101
  description:
    en: After 1st Ally Act
    ja: 味方の1番目のACT実行後
    ko: 아군의 첫 번째 ACT 실행 후
    zh_hant: 在我方發動第1個ACT後
1102:
  _id_: 1102
  description:
    en: After 2nd Ally Act
    ja: 味方の2番目のACT実行後
    ko: 아군의 두 번째 ACT 실행 후
    zh_hant: 在我方發動第2個ACT後
1103:
  _id_: 1103
  description:
    en: After 3rd Ally Act
    ja: 味方の3番目のACT実行後
    ko: 아군의 세 번째 ACT 실행 후
    zh_hant: 在我方發動第3個ACT後
1104:
  _id_: 1104
  description:
    en: After 4th Ally Act
    ja: 味方の4番目のACT実行後
    ko: 아군의 네 번째 ACT 실행 후
    zh_hant: 在我方發動第4個ACT後
1105:
  _id_: 1105
  description:
    en: After 5th Ally Act
    ja: 味方の5番目のACT実行後
    ko: 아군의 다섯 번째 ACT 실행 후
    zh_hant: 在我方發動第5個ACT後
2001:
  _id_: 2001
  description:
    en: Before 1st Enemy Act
    ja: 敵の1番目のACT実行前
    ko: 적의 첫 번째 ACT 실행 전
    zh_hant: 在敵方發動第1個ACT前
2002:
  _id_: 2002
  description:
    en: Before 2nd Enemy Act
    ja: 敵の2番目のACT実行前
    ko: 적의 두 번째 ACT 실행 전
    zh_hant: 在敵方發動第2個ACT前
2003:
  _id_: 2003
  description:
    en: Before 3rd Enemy Act
    ja: 敵の3番目のACT実行前
    ko: 적의 세 번째 ACT 실행 전
    zh_hant: 在敵方發動第3個ACT前
2004:
  _id_: 2004
  description:
    en: Before 4th Enemy Act
    ja: 敵の4番目のACT実行前
    ko: 적의 네 번째 ACT 실행 전
    zh_hant: 在敵方發動第4個ACT前
2005:
  _id_: 2005
  description:
    en: Before 5th Enemy Act
    ja: 敵の5番目のACT実行前
    ko: 적의 다섯 번째 ACT 실행 전
    zh_hant: 在敵方發動第5個ACT前
2101:
  _id_: 2101
  description:
    en: After 1st Enemy Act
    ja: 敵の1番目のACT実行後
    ko: 적의 첫 번째 ACT 실행 후
    zh_hant: 在敵方發動第1個ACT後
2102:
  _id_: 2102
  description:
    en: After 2nd Enemy Act
    ja: 敵の2番目のACT実行後
    ko: 적의 두 번째 ACT 실행 후
    zh_hant: 在敵方發動第2個ACT後
2103:
  _id_: 2103
  description:
    en: After 3rd Enemy Act
    ja: 敵の3番目のACT実行後
    ko: 적의 세 번째 ACT 실행 후
    zh_hant: 在敵方發動第3個ACT後
2104:
  _id_: 2104
  description:
    en: After 4th Enemy Act
    ja: 敵の4番目のACT実行後
    ko: 적의 네 번째 ACT 실행 후
    zh_hant: 在敵方發動第4個ACT後
2105:
  _id_: 2105
  description:
    en: After 5th Enemy Act
    ja: 敵の5番目のACT実行後
    ko: 적의 다섯 번째 ACT 실행 후
    zh_hant: 在敵方發動第5個ACT後

*/

inline val dataGenSkillExecuteTiming get() = "{\"1\":{\"description\":{\"ja\":\"ターン開始時\",\"en\":\"Start of Turn\",\"ko\":\"턴 시작 시\",\"zh_hant\":\"回合開始時\"},\"_id_\":1},\"2\":{\"description\":{\"ja\":\"ターン終了時\",\"en\":\"End of Turn\",\"ko\":\"턴 종료 시\",\"zh_hant\":\"回合結束時\"},\"_id_\":2},\"1001\":{\"description\":{\"ja\":\"味方の1番目のACT実行前\",\"en\":\"Before 1st Ally Act\",\"ko\":\"아군의 첫 번째 ACT 실행 전\",\"zh_hant\":\"在我方發動第1個ACT前\"},\"_id_\":1001},\"1002\":{\"description\":{\"ja\":\"味方の2番目のACT実行前\",\"en\":\"Before 2nd Ally Act\",\"ko\":\"아군의 두 번째 ACT 실행 전\",\"zh_hant\":\"在我方發動第2個ACT前\"},\"_id_\":1002},\"1003\":{\"description\":{\"ja\":\"味方の3番目のACT実行前\",\"en\":\"Before 3rd Ally Act\",\"ko\":\"아군의 세 번째 ACT 실행 전\",\"zh_hant\":\"在我方發動第3個ACT前\"},\"_id_\":1003},\"1004\":{\"description\":{\"ja\":\"味方の4番目のACT実行前\",\"en\":\"Before 4th Ally Act\",\"ko\":\"아군의 네 번째 ACT 실행 전\",\"zh_hant\":\"在我方發動第4個ACT前\"},\"_id_\":1004},\"1005\":{\"description\":{\"ja\":\"味方の5番目のACT実行前\",\"en\":\"Before 5th Ally Act\",\"ko\":\"아군의 다섯 번째 ACT 실행 전\",\"zh_hant\":\"在我方發動第5個ACT前\"},\"_id_\":1005},\"1101\":{\"description\":{\"ja\":\"味方の1番目のACT実行後\",\"en\":\"After 1st Ally Act\",\"ko\":\"아군의 첫 번째 ACT 실행 후\",\"zh_hant\":\"在我方發動第1個ACT後\"},\"_id_\":1101},\"1102\":{\"description\":{\"ja\":\"味方の2番目のACT実行後\",\"en\":\"After 2nd Ally Act\",\"ko\":\"아군의 두 번째 ACT 실행 후\",\"zh_hant\":\"在我方發動第2個ACT後\"},\"_id_\":1102},\"1103\":{\"description\":{\"ja\":\"味方の3番目のACT実行後\",\"en\":\"After 3rd Ally Act\",\"ko\":\"아군의 세 번째 ACT 실행 후\",\"zh_hant\":\"在我方發動第3個ACT後\"},\"_id_\":1103},\"1104\":{\"description\":{\"ja\":\"味方の4番目のACT実行後\",\"en\":\"After 4th Ally Act\",\"ko\":\"아군의 네 번째 ACT 실행 후\",\"zh_hant\":\"在我方發動第4個ACT後\"},\"_id_\":1104},\"1105\":{\"description\":{\"ja\":\"味方の5番目のACT実行後\",\"en\":\"After 5th Ally Act\",\"ko\":\"아군의 다섯 번째 ACT 실행 후\",\"zh_hant\":\"在我方發動第5個ACT後\"},\"_id_\":1105},\"2001\":{\"description\":{\"ja\":\"敵の1番目のACT実行前\",\"en\":\"Before 1st Enemy Act\",\"ko\":\"적의 첫 번째 ACT 실행 전\",\"zh_hant\":\"在敵方發動第1個ACT前\"},\"_id_\":2001},\"2002\":{\"description\":{\"ja\":\"敵の2番目のACT実行前\",\"en\":\"Before 2nd Enemy Act\",\"ko\":\"적의 두 번째 ACT 실행 전\",\"zh_hant\":\"在敵方發動第2個ACT前\"},\"_id_\":2002},\"2003\":{\"description\":{\"ja\":\"敵の3番目のACT実行前\",\"en\":\"Before 3rd Enemy Act\",\"ko\":\"적의 세 번째 ACT 실행 전\",\"zh_hant\":\"在敵方發動第3個ACT前\"},\"_id_\":2003},\"2004\":{\"description\":{\"ja\":\"敵の4番目のACT実行前\",\"en\":\"Before 4th Enemy Act\",\"ko\":\"적의 네 번째 ACT 실행 전\",\"zh_hant\":\"在敵方發動第4個ACT前\"},\"_id_\":2004},\"2005\":{\"description\":{\"ja\":\"敵の5番目のACT実行前\",\"en\":\"Before 5th Enemy Act\",\"ko\":\"적의 다섯 번째 ACT 실행 전\",\"zh_hant\":\"在敵方發動第5個ACT前\"},\"_id_\":2005},\"2101\":{\"description\":{\"ja\":\"敵の1番目のACT実行後\",\"en\":\"After 1st Enemy Act\",\"ko\":\"적의 첫 번째 ACT 실행 후\",\"zh_hant\":\"在敵方發動第1個ACT後\"},\"_id_\":2101},\"2102\":{\"description\":{\"ja\":\"敵の2番目のACT実行後\",\"en\":\"After 2nd Enemy Act\",\"ko\":\"적의 두 번째 ACT 실행 후\",\"zh_hant\":\"在敵方發動第2個ACT後\"},\"_id_\":2102},\"2103\":{\"description\":{\"ja\":\"敵の3番目のACT実行後\",\"en\":\"After 3rd Enemy Act\",\"ko\":\"적의 세 번째 ACT 실행 후\",\"zh_hant\":\"在敵方發動第3個ACT後\"},\"_id_\":2103},\"2104\":{\"description\":{\"ja\":\"敵の4番目のACT実行後\",\"en\":\"After 4th Enemy Act\",\"ko\":\"적의 네 번째 ACT 실행 후\",\"zh_hant\":\"在敵方發動第4個ACT後\"},\"_id_\":2104},\"2105\":{\"description\":{\"ja\":\"敵の5番目のACT実行後\",\"en\":\"After 5th Enemy Act\",\"ko\":\"적의 다섯 번째 ACT 실행 후\",\"zh_hant\":\"在敵方發動第5個ACT後\"},\"_id_\":2105}}"
