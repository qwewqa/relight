package xyz.qwewqa.relive.simulator.core.stage.target

import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.School
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.modifier.agility
import xyz.qwewqa.relive.simulator.core.stage.modifier.normalDefense
import xyz.qwewqa.relive.simulator.core.stage.modifier.specialDefense

object SkillTargets : ImplementationRegistry<SkillTarget>() {
  private val Actor.teamIndex
    get() = context.team.active.indexOf(this)

  val allyPlayer = +getSkillTargetData(1000).makeAllyTarget { emptyList() }
  val self = +getSkillTargetData(1001).makeAllyTarget { listOfNotNull(self) }
  val allAllies = +getSkillTargetData(1002).makeAllyTarget { team.active.toList() }
  val allyFrontGroup =
      +getSkillTargetData(1003).makeAllyTarget {
        val active = team.active
        val group = active.first().dress.position
        active.filter { it.dress.position == group }
      }
  val allyRearGroup =
      +getSkillTargetData(1004).makeAllyTarget {
        val active = team.active
        val group = active.first().dress.position
        active.filter { it.dress.position != group }
      }

  val front1stAlly = +getSkillTargetData(1011).makeAllyTargetSingleNthLowest(1) { it.teamIndex }
  val front2ndAlly = +getSkillTargetData(1012).makeAllyTargetSingleNthLowest(2) { it.teamIndex }
  val front3rdAlly = +getSkillTargetData(1013).makeAllyTargetSingleNthLowest(3) { it.teamIndex }
  val front4thAlly = +getSkillTargetData(1014).makeAllyTargetSingleNthLowest(4) { it.teamIndex }
  val front5thAlly = +getSkillTargetData(1015).makeAllyTargetSingleNthLowest(5) { it.teamIndex }

  val rear1stAlly = +getSkillTargetData(1021).makeAllyTargetSingleNthHighest(1) { it.teamIndex }
  val rear2ndAlly = +getSkillTargetData(1022).makeAllyTargetSingleNthHighest(2) { it.teamIndex }
  val rear3rdAlly = +getSkillTargetData(1023).makeAllyTargetSingleNthHighest(3) { it.teamIndex }
  val rear4thAlly = +getSkillTargetData(1024).makeAllyTargetSingleNthHighest(4) { it.teamIndex }
  val rear5thAlly = +getSkillTargetData(1025).makeAllyTargetSingleNthHighest(5) { it.teamIndex }

  val allyHighestHp = +getSkillTargetData(1031).makeAllyTargetSingleNthHighest(1) { it.hp }
  val ally2ndHighestHp = +getSkillTargetData(1032).makeAllyTargetSingleNthHighest(2) { it.hp }
  val ally3rdHighestHp = +getSkillTargetData(1033).makeAllyTargetSingleNthHighest(3) { it.hp }
  val ally4thHighestHp = +getSkillTargetData(1034).makeAllyTargetSingleNthHighest(4) { it.hp }
  val ally5thHighestHp = +getSkillTargetData(1035).makeAllyTargetSingleNthHighest(5) { it.hp }

  val allyLowestHp = +getSkillTargetData(1041).makeAllyTargetSingleNthLowest(1) { it.hp }
  val ally2ndLowestHp = +getSkillTargetData(1042).makeAllyTargetSingleNthLowest(2) { it.hp }
  val ally3rdLowestHp = +getSkillTargetData(1043).makeAllyTargetSingleNthLowest(3) { it.hp }
  val ally4thLowestHp = +getSkillTargetData(1044).makeAllyTargetSingleNthLowest(4) { it.hp }
  val ally5thLowestHp = +getSkillTargetData(1045).makeAllyTargetSingleNthLowest(5) { it.hp }

  val allyHighestActPower =
      +getSkillTargetData(1051).makeAllyTargetSingleNthHighest(1) { it.mod { +actPower } }
  val ally2ndHighestActPower =
      +getSkillTargetData(1052).makeAllyTargetSingleNthHighest(2) { it.mod { +actPower } }
  val ally3rdHighestActPower =
      +getSkillTargetData(1053).makeAllyTargetSingleNthHighest(3) { it.mod { +actPower } }
  val ally4thHighestActPower =
      +getSkillTargetData(1054).makeAllyTargetSingleNthHighest(4) { it.mod { +actPower } }
  val ally5thHighestActPower =
      +getSkillTargetData(1055).makeAllyTargetSingleNthHighest(5) { it.mod { +actPower } }

  val allyLowestActPower =
      +getSkillTargetData(1061).makeAllyTargetSingleNthLowest(1) { it.mod { +actPower } }
  val ally2ndLowestActPower =
      +getSkillTargetData(1062).makeAllyTargetSingleNthLowest(2) { it.mod { +actPower } }
  val ally3rdLowestActPower =
      +getSkillTargetData(1063).makeAllyTargetSingleNthLowest(3) { it.mod { +actPower } }
  val ally4thLowestActPower =
      +getSkillTargetData(1064).makeAllyTargetSingleNthLowest(4) { it.mod { +actPower } }
  val ally5thLowestActPower =
      +getSkillTargetData(1065).makeAllyTargetSingleNthLowest(5) { it.mod { +actPower } }

  val allyHighestNormalDefense =
      +getSkillTargetData(1071).makeAllyTargetSingleNthHighest(1) { it.mod { +normalDefense } }
  val ally2ndHighestNormalDefense =
      +getSkillTargetData(1072).makeAllyTargetSingleNthHighest(2) { it.mod { +normalDefense } }
  val ally3rdHighestNormalDefense =
      +getSkillTargetData(1073).makeAllyTargetSingleNthHighest(3) { it.mod { +normalDefense } }
  val ally4thHighestNormalDefense =
      +getSkillTargetData(1074).makeAllyTargetSingleNthHighest(4) { it.mod { +normalDefense } }
  val ally5thHighestNormalDefense =
      +getSkillTargetData(1075).makeAllyTargetSingleNthHighest(5) { it.mod { +normalDefense } }

  val allyLowestNormalDefense =
      +getSkillTargetData(1081).makeAllyTargetSingleNthLowest(1) { it.mod { +normalDefense } }
  val ally2ndLowestNormalDefense =
      +getSkillTargetData(1082).makeAllyTargetSingleNthLowest(2) { it.mod { +normalDefense } }
  val ally3rdLowestNormalDefense =
      +getSkillTargetData(1083).makeAllyTargetSingleNthLowest(3) { it.mod { +normalDefense } }
  val ally4thLowestNormalDefense =
      +getSkillTargetData(1084).makeAllyTargetSingleNthLowest(4) { it.mod { +normalDefense } }
  val ally5thLowestNormalDefense =
      +getSkillTargetData(1085).makeAllyTargetSingleNthLowest(5) { it.mod { +normalDefense } }

  val allyHighestSpecialDefense =
      +getSkillTargetData(1091).makeAllyTargetSingleNthHighest(1) { it.mod { +specialDefense } }
  val ally2ndHighestSpecialDefense =
      +getSkillTargetData(1092).makeAllyTargetSingleNthHighest(2) { it.mod { +specialDefense } }
  val ally3rdHighestSpecialDefense =
      +getSkillTargetData(1093).makeAllyTargetSingleNthHighest(3) { it.mod { +specialDefense } }
  val ally4thHighestSpecialDefense =
      +getSkillTargetData(1094).makeAllyTargetSingleNthHighest(4) { it.mod { +specialDefense } }
  val ally5thHighestSpecialDefense =
      +getSkillTargetData(1095).makeAllyTargetSingleNthHighest(5) { it.mod { +specialDefense } }

  val allyLowestSpecialDefense =
      +getSkillTargetData(1101).makeAllyTargetSingleNthLowest(1) { it.mod { +specialDefense } }
  val ally2ndLowestSpecialDefense =
      +getSkillTargetData(1102).makeAllyTargetSingleNthLowest(2) { it.mod { +specialDefense } }
  val ally3rdLowestSpecialDefense =
      +getSkillTargetData(1103).makeAllyTargetSingleNthLowest(3) { it.mod { +specialDefense } }
  val ally4thLowestSpecialDefense =
      +getSkillTargetData(1104).makeAllyTargetSingleNthLowest(4) { it.mod { +specialDefense } }
  val ally5thLowestSpecialDefense =
      +getSkillTargetData(1105).makeAllyTargetSingleNthLowest(5) { it.mod { +specialDefense } }

  val alliesHighestHp = +getSkillTargetData(1111).makeAllyTargetAllNHighest(1) { it.hp }
  val allies2HighestHp = +getSkillTargetData(1112).makeAllyTargetAllNHighest(2) { it.hp }
  val allies3HighestHp = +getSkillTargetData(1113).makeAllyTargetAllNHighest(3) { it.hp }
  val allies4HighestHp = +getSkillTargetData(1114).makeAllyTargetAllNHighest(4) { it.hp }
  val allies5HighestHp = +getSkillTargetData(1115).makeAllyTargetAllNHighest(5) { it.hp }

  val alliesLowestHp = +getSkillTargetData(1121).makeAllyTargetAllNLowest(1) { it.hp }
  val allies2LowestHp = +getSkillTargetData(1122).makeAllyTargetAllNLowest(2) { it.hp }
  val allies3LowestHp = +getSkillTargetData(1123).makeAllyTargetAllNLowest(3) { it.hp }
  val allies4LowestHp = +getSkillTargetData(1124).makeAllyTargetAllNLowest(4) { it.hp }
  val allies5LowestHp = +getSkillTargetData(1125).makeAllyTargetAllNLowest(5) { it.hp }

  // Why is there no id skip here?
  val alliesHighestActPower =
      +getSkillTargetData(1126).makeAllyTargetAllNHighest(1) { it.mod { +actPower } }
  val allies2HighestActPower =
      +getSkillTargetData(1127).makeAllyTargetAllNHighest(2) { it.mod { +actPower } }
  val allies3HighestActPower =
      +getSkillTargetData(1128).makeAllyTargetAllNHighest(3) { it.mod { +actPower } }
  val allies4HighestActPower =
      +getSkillTargetData(1129).makeAllyTargetAllNHighest(4) { it.mod { +actPower } }
  val allies5HighestActPower =
      +getSkillTargetData(1130).makeAllyTargetAllNHighest(5) { it.mod { +actPower } }

  val alliesFront = +getSkillTargetData(1131).makeAllyTargetAllNLowest(1) { it.teamIndex }
  val allies2Front = +getSkillTargetData(1132).makeAllyTargetAllNLowest(2) { it.teamIndex }
  val allies3Front = +getSkillTargetData(1133).makeAllyTargetAllNLowest(3) { it.teamIndex }
  val allies4Front = +getSkillTargetData(1134).makeAllyTargetAllNLowest(4) { it.teamIndex }
  val allies5Front = +getSkillTargetData(1135).makeAllyTargetAllNLowest(5) { it.teamIndex }

  val alliesRear = +getSkillTargetData(1141).makeAllyTargetAllNHighest(1) { it.teamIndex }
  val allies2Rear = +getSkillTargetData(1142).makeAllyTargetAllNHighest(2) { it.teamIndex }
  val allies3Rear = +getSkillTargetData(1143).makeAllyTargetAllNHighest(3) { it.teamIndex }
  val allies4Rear = +getSkillTargetData(1144).makeAllyTargetAllNHighest(4) { it.teamIndex }
  val allies5Rear = +getSkillTargetData(1145).makeAllyTargetAllNHighest(5) { it.teamIndex }

  val allies10PercentHpOrMore = +getSkillTargetData(1181).makeAllyTargetAoe { it.hpFraction >= 0.1 }
  val allies20PercentHpOrMore = +getSkillTargetData(1182).makeAllyTargetAoe { it.hpFraction >= 0.2 }
  val allies30PercentHpOrMore = +getSkillTargetData(1183).makeAllyTargetAoe { it.hpFraction >= 0.3 }
  val allies40PercentHpOrMore = +getSkillTargetData(1184).makeAllyTargetAoe { it.hpFraction >= 0.4 }
  val allies50PercentHpOrMore = +getSkillTargetData(1185).makeAllyTargetAoe { it.hpFraction >= 0.5 }
  val allies60PercentHpOrMore = +getSkillTargetData(1186).makeAllyTargetAoe { it.hpFraction >= 0.6 }
  val allies70PercentHpOrMore = +getSkillTargetData(1187).makeAllyTargetAoe { it.hpFraction >= 0.7 }
  val allies80PercentHpOrMore = +getSkillTargetData(1188).makeAllyTargetAoe { it.hpFraction >= 0.8 }
  val allies90PercentHpOrMore = +getSkillTargetData(1189).makeAllyTargetAoe { it.hpFraction >= 0.9 }
  val allies100PercentHpOrMore =
      +getSkillTargetData(1190).makeAllyTargetAoe { it.hpFraction >= 1.0 }

  val allies10PercentHpOrLess = +getSkillTargetData(1191).makeAllyTargetAoe { it.hpFraction <= 0.1 }
  val allies20PercentHpOrLess = +getSkillTargetData(1192).makeAllyTargetAoe { it.hpFraction <= 0.2 }
  val allies30PercentHpOrLess = +getSkillTargetData(1193).makeAllyTargetAoe { it.hpFraction <= 0.3 }
  val allies40PercentHpOrLess = +getSkillTargetData(1194).makeAllyTargetAoe { it.hpFraction <= 0.4 }
  val allies50PercentHpOrLess = +getSkillTargetData(1195).makeAllyTargetAoe { it.hpFraction <= 0.5 }
  val allies60PercentHpOrLess = +getSkillTargetData(1196).makeAllyTargetAoe { it.hpFraction <= 0.6 }
  val allies70PercentHpOrLess = +getSkillTargetData(1197).makeAllyTargetAoe { it.hpFraction <= 0.7 }
  val allies80PercentHpOrLess = +getSkillTargetData(1198).makeAllyTargetAoe { it.hpFraction <= 0.8 }
  val allies90PercentHpOrLess = +getSkillTargetData(1199).makeAllyTargetAoe { it.hpFraction <= 0.9 }
  val allies100PercentHpOrLess =
      +getSkillTargetData(1200).makeAllyTargetAoe { it.hpFraction <= 1.0 }

  val allies10BrillianceOrMore = +getSkillTargetData(1201).makeAllyTargetAoe { it.brilliance >= 10 }
  val allies20BrillianceOrMore = +getSkillTargetData(1202).makeAllyTargetAoe { it.brilliance >= 20 }
  val allies30BrillianceOrMore = +getSkillTargetData(1203).makeAllyTargetAoe { it.brilliance >= 30 }
  val allies40BrillianceOrMore = +getSkillTargetData(1204).makeAllyTargetAoe { it.brilliance >= 40 }
  val allies50BrillianceOrMore = +getSkillTargetData(1205).makeAllyTargetAoe { it.brilliance >= 50 }
  val allies60BrillianceOrMore = +getSkillTargetData(1206).makeAllyTargetAoe { it.brilliance >= 60 }
  val allies70BrillianceOrMore = +getSkillTargetData(1207).makeAllyTargetAoe { it.brilliance >= 70 }
  val allies80BrillianceOrMore = +getSkillTargetData(1208).makeAllyTargetAoe { it.brilliance >= 80 }
  val allies90BrillianceOrMore = +getSkillTargetData(1209).makeAllyTargetAoe { it.brilliance >= 90 }
  val allies100BrillianceOrMore =
      +getSkillTargetData(1210).makeAllyTargetAoe { it.brilliance >= 100 }

  val allies10BrillianceOrLess = +getSkillTargetData(1211).makeAllyTargetAoe { it.brilliance <= 10 }
  val allies20BrillianceOrLess = +getSkillTargetData(1212).makeAllyTargetAoe { it.brilliance <= 20 }
  val allies30BrillianceOrLess = +getSkillTargetData(1213).makeAllyTargetAoe { it.brilliance <= 30 }
  val allies40BrillianceOrLess = +getSkillTargetData(1214).makeAllyTargetAoe { it.brilliance <= 40 }
  val allies50BrillianceOrLess = +getSkillTargetData(1215).makeAllyTargetAoe { it.brilliance <= 50 }
  val allies60BrillianceOrLess = +getSkillTargetData(1216).makeAllyTargetAoe { it.brilliance <= 60 }
  val allies70BrillianceOrLess = +getSkillTargetData(1217).makeAllyTargetAoe { it.brilliance <= 70 }
  val allies80BrillianceOrLess = +getSkillTargetData(1218).makeAllyTargetAoe { it.brilliance <= 80 }
  val allies90BrillianceOrLess = +getSkillTargetData(1219).makeAllyTargetAoe { it.brilliance <= 90 }
  val allies100BrillianceOrLess =
      +getSkillTargetData(1220).makeAllyTargetAoe { it.brilliance <= 100 }

  val ally1stActing =
      +getSkillTargetData(1301).makeAllyTarget { listOfNotNull(team.queue.getOrNull(0)?.actor) }
  val ally2ndActing =
      +getSkillTargetData(1302).makeAllyTarget { listOfNotNull(team.queue.getOrNull(1)?.actor) }
  val ally3rdActing =
      +getSkillTargetData(1303).makeAllyTarget { listOfNotNull(team.queue.getOrNull(2)?.actor) }
  val ally4thActing =
      +getSkillTargetData(1304).makeAllyTarget { listOfNotNull(team.queue.getOrNull(3)?.actor) }
  val ally5thActing =
      +getSkillTargetData(1305).makeAllyTarget { listOfNotNull(team.queue.getOrNull(4)?.actor) }

  val allyNextActing =
      +getSkillTargetData(1701).makeAllyTarget { listOfNotNull(team.nextAct?.actor) }

  val allEnemies = +getSkillTargetData(2002).makeEnemyTargetAoe()
  val enemyFrontGroup =
      +getSkillTargetData(2003).makeEnemyTarget { provokeTarget ->
        val active = enemy.active
        val group = provokeTarget?.dress?.position ?: active.first().dress.position
        active.filter { it.dress.position == group }
      }
  val enemyRearGroup =
      +getSkillTargetData(2004).makeAllyTarget {
        val active = enemy.active
        val group = it?.dress?.position ?: active.first().dress.position
        active.filter { it.dress.position != group }
      }

  val front1stEnemy = +getSkillTargetData(2011).makeEnemyTargetSingleNthLowest(1) { it.teamIndex }
  val front2ndEnemy = +getSkillTargetData(2012).makeEnemyTargetSingleNthLowest(2) { it.teamIndex }
  val front3rdEnemy = +getSkillTargetData(2013).makeEnemyTargetSingleNthLowest(3) { it.teamIndex }
  val front4thEnemy = +getSkillTargetData(2014).makeEnemyTargetSingleNthLowest(4) { it.teamIndex }
  val front5thEnemy = +getSkillTargetData(2015).makeEnemyTargetSingleNthLowest(5) { it.teamIndex }

  val rear1stEnemy = +getSkillTargetData(2021).makeEnemyTargetSingleNthHighest(1) { it.teamIndex }
  val rear2ndEnemy = +getSkillTargetData(2022).makeEnemyTargetSingleNthHighest(2) { it.teamIndex }
  val rear3rdEnemy = +getSkillTargetData(2023).makeEnemyTargetSingleNthHighest(3) { it.teamIndex }
  val rear4thEnemy = +getSkillTargetData(2024).makeEnemyTargetSingleNthHighest(4) { it.teamIndex }
  val rear5thEnemy = +getSkillTargetData(2025).makeEnemyTargetSingleNthHighest(5) { it.teamIndex }

  val enemyHighestHp = +getSkillTargetData(2031).makeEnemyTargetSingleNthHighest(1) { it.hp }
  val enemy2ndHighestHp = +getSkillTargetData(2032).makeEnemyTargetSingleNthHighest(2) { it.hp }
  val enemy3rdHighestHp = +getSkillTargetData(2033).makeEnemyTargetSingleNthHighest(3) { it.hp }
  val enemy4thHighestHp = +getSkillTargetData(2034).makeEnemyTargetSingleNthHighest(4) { it.hp }
  val enemy5thHighestHp = +getSkillTargetData(2035).makeEnemyTargetSingleNthHighest(5) { it.hp }

  val enemyLowestHp = +getSkillTargetData(2041).makeEnemyTargetSingleNthLowest(1) { it.hp }
  val enemy2ndLowestHp = +getSkillTargetData(2042).makeEnemyTargetSingleNthLowest(2) { it.hp }
  val enemy3rdLowestHp = +getSkillTargetData(2043).makeEnemyTargetSingleNthLowest(3) { it.hp }
  val enemy4thLowestHp = +getSkillTargetData(2044).makeEnemyTargetSingleNthLowest(4) { it.hp }
  val enemy5thLowestHp = +getSkillTargetData(2045).makeEnemyTargetSingleNthLowest(5) { it.hp }

  val enemyHighestActPower =
      +getSkillTargetData(2051).makeEnemyTargetSingleNthHighest(1) { it.mod { +actPower } }
  val enemy2ndHighestActPower =
      +getSkillTargetData(2052).makeEnemyTargetSingleNthHighest(2) { it.mod { +actPower } }
  val enemy3rdHighestActPower =
      +getSkillTargetData(2053).makeEnemyTargetSingleNthHighest(3) { it.mod { +actPower } }
  val enemy4thHighestActPower =
      +getSkillTargetData(2054).makeEnemyTargetSingleNthHighest(4) { it.mod { +actPower } }
  val enemy5thHighestActPower =
      +getSkillTargetData(2055).makeEnemyTargetSingleNthHighest(5) { it.mod { +actPower } }

  val enemyLowestActPower =
      +getSkillTargetData(2061).makeEnemyTargetSingleNthLowest(1) { it.mod { +actPower } }
  val enemy2ndLowestActPower =
      +getSkillTargetData(2062).makeEnemyTargetSingleNthLowest(2) { it.mod { +actPower } }
  val enemy3rdLowestActPower =
      +getSkillTargetData(2063).makeEnemyTargetSingleNthLowest(3) { it.mod { +actPower } }
  val enemy4thLowestActPower =
      +getSkillTargetData(2064).makeEnemyTargetSingleNthLowest(4) { it.mod { +actPower } }
  val enemy5thLowestActPower =
      +getSkillTargetData(2065).makeEnemyTargetSingleNthLowest(5) { it.mod { +actPower } }

  val enemyHighestNormalDefense =
      +getSkillTargetData(2071).makeEnemyTargetSingleNthHighest(1) { it.mod { +normalDefense } }
  val enemy2ndHighestNormalDefense =
      +getSkillTargetData(2072).makeEnemyTargetSingleNthHighest(2) { it.mod { +normalDefense } }
  val enemy3rdHighestNormalDefense =
      +getSkillTargetData(2073).makeEnemyTargetSingleNthHighest(3) { it.mod { +normalDefense } }
  val enemy4thHighestNormalDefense =
      +getSkillTargetData(2074).makeEnemyTargetSingleNthHighest(4) { it.mod { +normalDefense } }
  val enemy5thHighestNormalDefense =
      +getSkillTargetData(2075).makeEnemyTargetSingleNthHighest(5) { it.mod { +normalDefense } }

  val enemyLowestNormalDefense =
      +getSkillTargetData(2081).makeEnemyTargetSingleNthLowest(1) { it.mod { +normalDefense } }
  val enemy2ndLowestNormalDefense =
      +getSkillTargetData(2082).makeEnemyTargetSingleNthLowest(2) { it.mod { +normalDefense } }
  val enemy3rdLowestNormalDefense =
      +getSkillTargetData(2083).makeEnemyTargetSingleNthLowest(3) { it.mod { +normalDefense } }
  val enemy4thLowestNormalDefense =
      +getSkillTargetData(2084).makeEnemyTargetSingleNthLowest(4) { it.mod { +normalDefense } }
  val enemy5thLowestNormalDefense =
      +getSkillTargetData(2085).makeEnemyTargetSingleNthLowest(5) { it.mod { +normalDefense } }

  val enemyHighestSpecialDefense =
      +getSkillTargetData(2091).makeEnemyTargetSingleNthHighest(1) { it.mod { +specialDefense } }
  val enemy2ndHighestSpecialDefense =
      +getSkillTargetData(2092).makeEnemyTargetSingleNthHighest(2) { it.mod { +specialDefense } }
  val enemy3rdHighestSpecialDefense =
      +getSkillTargetData(2093).makeEnemyTargetSingleNthHighest(3) { it.mod { +specialDefense } }
  val enemy4thHighestSpecialDefense =
      +getSkillTargetData(2094).makeEnemyTargetSingleNthHighest(4) { it.mod { +specialDefense } }
  val enemy5thHighestSpecialDefense =
      +getSkillTargetData(2095).makeEnemyTargetSingleNthHighest(5) { it.mod { +specialDefense } }

  val enemyLowestSpecialDefense =
      +getSkillTargetData(2101).makeEnemyTargetSingleNthLowest(1) { it.mod { +specialDefense } }
  val enemy2ndLowestSpecialDefense =
      +getSkillTargetData(2102).makeEnemyTargetSingleNthLowest(2) { it.mod { +specialDefense } }
  val enemy3rdLowestSpecialDefense =
      +getSkillTargetData(2103).makeEnemyTargetSingleNthLowest(3) { it.mod { +specialDefense } }
  val enemy4thLowestSpecialDefense =
      +getSkillTargetData(2104).makeEnemyTargetSingleNthLowest(4) { it.mod { +specialDefense } }
  val enemy5thLowestSpecialDefense =
      +getSkillTargetData(2105).makeEnemyTargetSingleNthLowest(5) { it.mod { +specialDefense } }

  val enemiesFront = +getSkillTargetData(2111).makeEnemyTargetAllNLowest(1) { it.teamIndex }
  val enemies2Front = +getSkillTargetData(2112).makeEnemyTargetAllNLowest(2) { it.teamIndex }
  val enemies3Front = +getSkillTargetData(2113).makeEnemyTargetAllNLowest(3) { it.teamIndex }
  val enemies4Front = +getSkillTargetData(2114).makeEnemyTargetAllNLowest(4) { it.teamIndex }
  val enemies5Front = +getSkillTargetData(2115).makeEnemyTargetAllNLowest(5) { it.teamIndex }

  val enemiesRear = +getSkillTargetData(2121).makeEnemyTargetAllNHighest(1) { it.teamIndex }
  val enemies2Rear = +getSkillTargetData(2122).makeEnemyTargetAllNHighest(2) { it.teamIndex }
  val enemies3Rear = +getSkillTargetData(2123).makeEnemyTargetAllNHighest(3) { it.teamIndex }
  val enemies4Rear = +getSkillTargetData(2124).makeEnemyTargetAllNHighest(4) { it.teamIndex }
  val enemies5Rear = +getSkillTargetData(2125).makeEnemyTargetAllNHighest(5) { it.teamIndex }

  val enemiesHighestHp = +getSkillTargetData(2131).makeEnemyTargetAllNHighest(1) { it.hp }
  val enemies2HighestHp = +getSkillTargetData(2132).makeEnemyTargetAllNHighest(2) { it.hp }
  val enemies3HighestHp = +getSkillTargetData(2133).makeEnemyTargetAllNHighest(3) { it.hp }
  val enemies4HighestHp = +getSkillTargetData(2134).makeEnemyTargetAllNHighest(4) { it.hp }
  val enemies5HighestHp = +getSkillTargetData(2135).makeEnemyTargetAllNHighest(5) { it.hp }

  val enemiesLowestHp = +getSkillTargetData(2141).makeEnemyTargetAllNLowest(1) { it.hp }
  val enemies2LowestHp = +getSkillTargetData(2142).makeEnemyTargetAllNLowest(2) { it.hp }
  val enemies3LowestHp = +getSkillTargetData(2143).makeEnemyTargetAllNLowest(3) { it.hp }
  val enemies4LowestHp = +getSkillTargetData(2144).makeEnemyTargetAllNLowest(4) { it.hp }
  val enemies5LowestHp = +getSkillTargetData(2145).makeEnemyTargetAllNLowest(5) { it.hp }

  val enemiesHighestActPower =
      +getSkillTargetData(2146).makeEnemyTargetAllNHighest(1) { it.mod { +actPower } }
  val enemies2HighestActPower =
      +getSkillTargetData(2147).makeEnemyTargetAllNHighest(2) { it.mod { +actPower } }
  val enemies3HighestActPower =
      +getSkillTargetData(2148).makeEnemyTargetAllNHighest(3) { it.mod { +actPower } }
  val enemies4HighestActPower =
      +getSkillTargetData(2149).makeEnemyTargetAllNHighest(4) { it.mod { +actPower } }
  val enemies5HighestActPower =
      +getSkillTargetData(2150).makeEnemyTargetAllNHighest(5) { it.mod { +actPower } }

  val enemiesLowestActPower =
      +getSkillTargetData(2151).makeEnemyTargetAllNLowest(1) { it.mod { +actPower } }
  val enemies2LowestActPower =
      +getSkillTargetData(2152).makeEnemyTargetAllNLowest(2) { it.mod { +actPower } }
  val enemies3LowestActPower =
      +getSkillTargetData(2153).makeEnemyTargetAllNLowest(3) { it.mod { +actPower } }
  val enemies4LowestActPower =
      +getSkillTargetData(2154).makeEnemyTargetAllNLowest(4) { it.mod { +actPower } }
  val enemies5LowestActPower =
      +getSkillTargetData(2155).makeEnemyTargetAllNLowest(5) { it.mod { +actPower } }

  val enemiesHighestNormalDefense =
      +getSkillTargetData(2156).makeEnemyTargetAllNHighest(1) { it.mod { +normalDefense } }
  val enemies2HighestNormalDefense =
      +getSkillTargetData(2157).makeEnemyTargetAllNHighest(2) { it.mod { +normalDefense } }
  val enemies3HighestNormalDefense =
      +getSkillTargetData(2158).makeEnemyTargetAllNHighest(3) { it.mod { +normalDefense } }
  val enemies4HighestNormalDefense =
      +getSkillTargetData(2159).makeEnemyTargetAllNHighest(4) { it.mod { +normalDefense } }
  val enemies5HighestNormalDefense =
      +getSkillTargetData(2160).makeEnemyTargetAllNHighest(5) { it.mod { +normalDefense } }

  val enemiesLowestNormalDefense =
      +getSkillTargetData(2161).makeEnemyTargetAllNLowest(1) { it.mod { +normalDefense } }
  val enemies2LowestNormalDefense =
      +getSkillTargetData(2162).makeEnemyTargetAllNLowest(2) { it.mod { +normalDefense } }
  val enemies3LowestNormalDefense =
      +getSkillTargetData(2163).makeEnemyTargetAllNLowest(3) { it.mod { +normalDefense } }
  val enemies4LowestNormalDefense =
      +getSkillTargetData(2164).makeEnemyTargetAllNLowest(4) { it.mod { +normalDefense } }
  val enemies5LowestNormalDefense =
      +getSkillTargetData(2165).makeEnemyTargetAllNLowest(5) { it.mod { +normalDefense } }

  val enemiesHighestSpecialDefense =
      +getSkillTargetData(2166).makeEnemyTargetAllNHighest(1) { it.mod { +specialDefense } }
  val enemies2HighestSpecialDefense =
      +getSkillTargetData(2167).makeEnemyTargetAllNHighest(2) { it.mod { +specialDefense } }
  val enemies3HighestSpecialDefense =
      +getSkillTargetData(2168).makeEnemyTargetAllNHighest(3) { it.mod { +specialDefense } }
  val enemies4HighestSpecialDefense =
      +getSkillTargetData(2169).makeEnemyTargetAllNHighest(4) { it.mod { +specialDefense } }
  val enemies5HighestSpecialDefense =
      +getSkillTargetData(2170).makeEnemyTargetAllNHighest(5) { it.mod { +specialDefense } }

  val enemiesLowestSpecialDefense =
      +getSkillTargetData(2171).makeEnemyTargetAllNLowest(1) { it.mod { +specialDefense } }
  val enemies2LowestSpecialDefense =
      +getSkillTargetData(2172).makeEnemyTargetAllNLowest(2) { it.mod { +specialDefense } }
  val enemies3LowestSpecialDefense =
      +getSkillTargetData(2173).makeEnemyTargetAllNLowest(3) { it.mod { +specialDefense } }
  val enemies4LowestSpecialDefense =
      +getSkillTargetData(2174).makeEnemyTargetAllNLowest(4) { it.mod { +specialDefense } }
  val enemies5LowestSpecialDefense =
      +getSkillTargetData(2175).makeEnemyTargetAllNLowest(5) { it.mod { +specialDefense } }

  val focusEnemyHighestActPower =
      +getSkillTargetData(2176).makeEnemyTargetSingleNthHighest(1, focus = true) {
        it.mod { +actPower }
      }

  val focusEnemies3Front =
      +getSkillTargetData(2177).makeEnemyTargetAllNHighest(3, focus = true) { 0 }

  val enemies10PercentHpOrMore =
      +getSkillTargetData(2181).makeEnemyTargetAoe { it.hpFraction >= 0.1 }
  val enemies20PercentHpOrMore =
      +getSkillTargetData(2182).makeEnemyTargetAoe { it.hpFraction >= 0.2 }
  val enemies30PercentHpOrMore =
      +getSkillTargetData(2183).makeEnemyTargetAoe { it.hpFraction >= 0.3 }
  val enemies40PercentHpOrMore =
      +getSkillTargetData(2184).makeEnemyTargetAoe { it.hpFraction >= 0.4 }
  val enemies50PercentHpOrMore =
      +getSkillTargetData(2185).makeEnemyTargetAoe { it.hpFraction >= 0.5 }
  val enemies60PercentHpOrMore =
      +getSkillTargetData(2186).makeEnemyTargetAoe { it.hpFraction >= 0.6 }
  val enemies70PercentHpOrMore =
      +getSkillTargetData(2187).makeEnemyTargetAoe { it.hpFraction >= 0.7 }
  val enemies80PercentHpOrMore =
      +getSkillTargetData(2188).makeEnemyTargetAoe { it.hpFraction >= 0.8 }
  val enemies90PercentHpOrMore =
      +getSkillTargetData(2189).makeEnemyTargetAoe { it.hpFraction >= 0.9 }
  val enemies100PercentHpOrMore =
      +getSkillTargetData(2190).makeEnemyTargetAoe { it.hpFraction >= 1.0 }

  val enemies10PercentHpOrLess =
      +getSkillTargetData(2191).makeEnemyTargetAoe { it.hpFraction <= 0.1 }
  val enemies20PercentHpOrLess =
      +getSkillTargetData(2192).makeEnemyTargetAoe { it.hpFraction <= 0.2 }
  val enemies30PercentHpOrLess =
      +getSkillTargetData(2193).makeEnemyTargetAoe { it.hpFraction <= 0.3 }
  val enemies40PercentHpOrLess =
      +getSkillTargetData(2194).makeEnemyTargetAoe { it.hpFraction <= 0.4 }
  val enemies50PercentHpOrLess =
      +getSkillTargetData(2195).makeEnemyTargetAoe { it.hpFraction <= 0.5 }
  val enemies60PercentHpOrLess =
      +getSkillTargetData(2196).makeEnemyTargetAoe { it.hpFraction <= 0.6 }
  val enemies70PercentHpOrLess =
      +getSkillTargetData(2197).makeEnemyTargetAoe { it.hpFraction <= 0.7 }
  val enemies80PercentHpOrLess =
      +getSkillTargetData(2198).makeEnemyTargetAoe { it.hpFraction <= 0.8 }
  val enemies90PercentHpOrLess =
      +getSkillTargetData(2199).makeEnemyTargetAoe { it.hpFraction <= 0.9 }
  val enemies100PercentHpOrLess =
      +getSkillTargetData(2200).makeEnemyTargetAoe { it.hpFraction <= 1.0 }

  val enemies10BrillianceOrMore =
      +getSkillTargetData(2201).makeEnemyTargetAoe { it.brilliance >= 10 }
  val enemies20BrillianceOrMore =
      +getSkillTargetData(2202).makeEnemyTargetAoe { it.brilliance >= 20 }
  val enemies30BrillianceOrMore =
      +getSkillTargetData(2203).makeEnemyTargetAoe { it.brilliance >= 30 }
  val enemies40BrillianceOrMore =
      +getSkillTargetData(2204).makeEnemyTargetAoe { it.brilliance >= 40 }
  val enemies50BrillianceOrMore =
      +getSkillTargetData(2205).makeEnemyTargetAoe { it.brilliance >= 50 }
  val enemies60BrillianceOrMore =
      +getSkillTargetData(2206).makeEnemyTargetAoe { it.brilliance >= 60 }
  val enemies70BrillianceOrMore =
      +getSkillTargetData(2207).makeEnemyTargetAoe { it.brilliance >= 70 }
  val enemies80BrillianceOrMore =
      +getSkillTargetData(2208).makeEnemyTargetAoe { it.brilliance >= 80 }
  val enemies90BrillianceOrMore =
      +getSkillTargetData(2209).makeEnemyTargetAoe { it.brilliance >= 90 }
  val enemies100BrillianceOrMore =
      +getSkillTargetData(2210).makeEnemyTargetAoe { it.brilliance >= 100 }

  val enemies10BrillianceOrLess =
      +getSkillTargetData(2211).makeEnemyTargetAoe { it.brilliance <= 10 }
  val enemies20BrillianceOrLess =
      +getSkillTargetData(2212).makeEnemyTargetAoe { it.brilliance <= 20 }
  val enemies30BrillianceOrLess =
      +getSkillTargetData(2213).makeEnemyTargetAoe { it.brilliance <= 30 }
  val enemies40BrillianceOrLess =
      +getSkillTargetData(2214).makeEnemyTargetAoe { it.brilliance <= 40 }
  val enemies50BrillianceOrLess =
      +getSkillTargetData(2215).makeEnemyTargetAoe { it.brilliance <= 50 }
  val enemies60BrillianceOrLess =
      +getSkillTargetData(2216).makeEnemyTargetAoe { it.brilliance <= 60 }
  val enemies70BrillianceOrLess =
      +getSkillTargetData(2217).makeEnemyTargetAoe { it.brilliance <= 70 }
  val enemies80BrillianceOrLess =
      +getSkillTargetData(2218).makeEnemyTargetAoe { it.brilliance <= 80 }
  val enemies90BrillianceOrLess =
      +getSkillTargetData(2219).makeEnemyTargetAoe { it.brilliance <= 90 }
  val enemies100BrillianceOrLess =
      +getSkillTargetData(2220).makeEnemyTargetAoe { it.brilliance <= 100 }

  val enemy1stActing =
      +getSkillTargetData(2301).makeEnemyTarget { listOfNotNull(enemy.queue.getOrNull(0)?.actor) }
  val enemy2ndActing =
      +getSkillTargetData(2302).makeEnemyTarget { listOfNotNull(enemy.queue.getOrNull(1)?.actor) }
  val enemy3rdActing =
      +getSkillTargetData(2303).makeEnemyTarget { listOfNotNull(enemy.queue.getOrNull(2)?.actor) }
  val enemy4thActing =
      +getSkillTargetData(2304).makeEnemyTarget { listOfNotNull(enemy.queue.getOrNull(3)?.actor) }
  val enemy5thActing =
      +getSkillTargetData(2305).makeEnemyTarget { listOfNotNull(enemy.queue.getOrNull(4)?.actor) }

  val seishoEnemies =
      +getSkillTargetData(2401).makeEnemyTargetAoe { it.dress.character.school == School.Seisho }
  val rinmeikanEnemies =
      +getSkillTargetData(2402).makeEnemyTargetAoe { it.dress.character.school == School.Rinmeikan }
  val frontierEnemies =
      +getSkillTargetData(2403).makeEnemyTargetAoe { it.dress.character.school == School.Frontier }
  val siegfeldEnemies =
      +getSkillTargetData(2404).makeEnemyTargetAoe { it.dress.character.school == School.Siegfeld }
  val seiranEnemies =
      +getSkillTargetData(2405).makeEnemyTargetAoe { it.dress.character.school == School.Seiran }

  val allyKarenAijo =
      +getSkillTargetData(2501).makeAllyTargetAoe { it.dress.character == Character.Karen }
  val allyHikariKagura =
      +getSkillTargetData(2502).makeAllyTargetAoe { it.dress.character == Character.Hikari }
  val allyMahiruTsuyuzaki =
      +getSkillTargetData(2503).makeAllyTargetAoe { it.dress.character == Character.Mahiru }
  val allyClaudineSaijo =
      +getSkillTargetData(2504).makeAllyTargetAoe { it.dress.character == Character.Claudine }
  val allyMayaTendo =
      +getSkillTargetData(2505).makeAllyTargetAoe { it.dress.character == Character.Maya }
  val allyJunnaHoshimi =
      +getSkillTargetData(2506).makeAllyTargetAoe { it.dress.character == Character.Junna }
  val allyNanaDaiba =
      +getSkillTargetData(2507).makeAllyTargetAoe { it.dress.character == Character.Nana }
  val allyFutabaIsurugi =
      +getSkillTargetData(2508).makeAllyTargetAoe { it.dress.character == Character.Futaba }
  val allyKaorukoHanayagi =
      +getSkillTargetData(2509).makeAllyTargetAoe { it.dress.character == Character.Kaoruko }
  val allyTamaoTomoe =
      +getSkillTargetData(2510).makeAllyTargetAoe { it.dress.character == Character.Tamao }
  val allyIchieOtonashi =
      +getSkillTargetData(2511).makeAllyTargetAoe { it.dress.character == Character.Ichie }
  val allyFumiYumeoji =
      +getSkillTargetData(2512).makeAllyTargetAoe { it.dress.character == Character.Fumi }
  val allyRuiAkikaze =
      +getSkillTargetData(2513).makeAllyTargetAoe { it.dress.character == Character.Rui }
  val allyYuyukoTanaka =
      +getSkillTargetData(2514).makeAllyTargetAoe { it.dress.character == Character.Yuyuko }
  val allyAruruOtsuki =
      +getSkillTargetData(2515).makeAllyTargetAoe { it.dress.character == Character.Aruru }
  val allyMisoraKano =
      +getSkillTargetData(2516).makeAllyTargetAoe { it.dress.character == Character.Misora }
  val allyLalafinNonomiya =
      +getSkillTargetData(2517).makeAllyTargetAoe { it.dress.character == Character.Lalafin }
  val allyTsukasaEbisu =
      +getSkillTargetData(2518).makeAllyTargetAoe { it.dress.character == Character.Tsukasa }
  val allyShizuhaKocho =
      +getSkillTargetData(2519).makeAllyTargetAoe { it.dress.character == Character.Shizuha }
  val allyAkiraYukishiro =
      +getSkillTargetData(2520).makeAllyTargetAoe { it.dress.character == Character.Akira }
  val allyMichiruOtori =
      +getSkillTargetData(2521).makeAllyTargetAoe { it.dress.character == Character.Michiru }
  val allyLiuMeiFan =
      +getSkillTargetData(2522).makeAllyTargetAoe { it.dress.character == Character.MeiFan }
  val allyShioriYumeoji =
      +getSkillTargetData(2523).makeAllyTargetAoe { it.dress.character == Character.Shiori }
  val allyYachiyoTsuruhime =
      +getSkillTargetData(2524).makeAllyTargetAoe { it.dress.character == Character.Yachiyo }
  val allyKoharuYanagi =
      +getSkillTargetData(2525).makeAllyTargetAoe { it.dress.character == Character.Koharu }
  val allySuzuMinase =
      +getSkillTargetData(2526).makeAllyTargetAoe { it.dress.character == Character.Suzu }
  val allyHisameHonami =
      +getSkillTargetData(2527).makeAllyTargetAoe { it.dress.character == Character.Hisame }

  val enemyKarenAijo =
      +getSkillTargetData(2601).makeEnemyTargetAoe { it.dress.character == Character.Karen }
  val enemyHikariKagura =
      +getSkillTargetData(2602).makeEnemyTargetAoe { it.dress.character == Character.Hikari }
  val enemyMahiruTsuyuzaki =
      +getSkillTargetData(2603).makeEnemyTargetAoe { it.dress.character == Character.Mahiru }
  val enemyClaudineSaijo =
      +getSkillTargetData(2604).makeEnemyTargetAoe { it.dress.character == Character.Claudine }
  val enemyMayaTendo =
      +getSkillTargetData(2605).makeEnemyTargetAoe { it.dress.character == Character.Maya }
  val enemyJunnaHoshimi =
      +getSkillTargetData(2606).makeEnemyTargetAoe { it.dress.character == Character.Junna }
  val enemyNanaDaiba =
      +getSkillTargetData(2607).makeEnemyTargetAoe { it.dress.character == Character.Nana }
  val enemyFutabaIsurugi =
      +getSkillTargetData(2608).makeEnemyTargetAoe { it.dress.character == Character.Futaba }
  val enemyKaorukoHanayagi =
      +getSkillTargetData(2609).makeEnemyTargetAoe { it.dress.character == Character.Kaoruko }
  val enemyTamaoTomoe =
      +getSkillTargetData(2610).makeEnemyTargetAoe { it.dress.character == Character.Tamao }
  val enemyIchieOtonashi =
      +getSkillTargetData(2611).makeEnemyTargetAoe { it.dress.character == Character.Ichie }
  val enemyFumiYumeoji =
      +getSkillTargetData(2612).makeEnemyTargetAoe { it.dress.character == Character.Fumi }
  val enemyRuiAkikaze =
      +getSkillTargetData(2613).makeEnemyTargetAoe { it.dress.character == Character.Rui }
  val enemyYuyukoTanaka =
      +getSkillTargetData(2614).makeEnemyTargetAoe { it.dress.character == Character.Yuyuko }
  val enemyAruruOtsuki =
      +getSkillTargetData(2615).makeEnemyTargetAoe { it.dress.character == Character.Aruru }
  val enemyMisoraKano =
      +getSkillTargetData(2616).makeEnemyTargetAoe { it.dress.character == Character.Misora }
  val enemyLalafinNonomiya =
      +getSkillTargetData(2617).makeEnemyTargetAoe { it.dress.character == Character.Lalafin }
  val enemyTsukasaEbisu =
      +getSkillTargetData(2618).makeEnemyTargetAoe { it.dress.character == Character.Tsukasa }
  val enemyShizuhaKocho =
      +getSkillTargetData(2619).makeEnemyTargetAoe { it.dress.character == Character.Shizuha }
  val enemyAkiraYukishiro =
      +getSkillTargetData(2620).makeEnemyTargetAoe { it.dress.character == Character.Akira }
  val enemyMichiruOtori =
      +getSkillTargetData(2621).makeEnemyTargetAoe { it.dress.character == Character.Michiru }
  val enemyLiuMeiFan =
      +getSkillTargetData(2622).makeEnemyTargetAoe { it.dress.character == Character.MeiFan }
  val enemyShioriYumeoji =
      +getSkillTargetData(2623).makeEnemyTargetAoe { it.dress.character == Character.Shiori }
  val enemyYachiyoTsuruhime =
      +getSkillTargetData(2624).makeEnemyTargetAoe { it.dress.character == Character.Yachiyo }
  val enemyKoharuYanagi =
      +getSkillTargetData(2625).makeEnemyTargetAoe { it.dress.character == Character.Koharu }
  val enemySuzuMinase =
      +getSkillTargetData(2626).makeEnemyTargetAoe { it.dress.character == Character.Suzu }
  val enemyHisameHonami =
      +getSkillTargetData(2627).makeEnemyTargetAoe { it.dress.character == Character.Hisame }

  val enemyNextActing =
      +getSkillTargetData(2701).makeEnemyTarget { listOfNotNull(enemy.nextAct?.actor) }

  val sieshoFrontPosition =
      +getSkillTargetData(3001).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && character.school == School.Seisho }
      }
  val sieshoCenterPosition =
      +getSkillTargetData(3002).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && character.school == School.Seisho }
      }
  val sieshoRearPosition =
      +getSkillTargetData(3003).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && character.school == School.Seisho }
      }
  val rinmeikanFrontPosition =
      +getSkillTargetData(3011).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && character.school == School.Rinmeikan }
      }
  val rinmeikanCenterPosition =
      +getSkillTargetData(3012).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && character.school == School.Rinmeikan }
      }
  val rinmeikanRearPosition =
      +getSkillTargetData(3013).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && character.school == School.Rinmeikan }
      }
  val frontierFrontPosition =
      +getSkillTargetData(3021).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && character.school == School.Frontier }
      }
  val frontierCenterPosition =
      +getSkillTargetData(3022).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && character.school == School.Frontier }
      }
  val frontierRearPosition =
      +getSkillTargetData(3023).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && character.school == School.Frontier }
      }
  val siegfeldFrontPosition =
      +getSkillTargetData(3031).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && character.school == School.Siegfeld }
      }
  val siegfeldCenterPosition =
      +getSkillTargetData(3032).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && character.school == School.Siegfeld }
      }
  val siegfeldRearPosition =
      +getSkillTargetData(3033).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && character.school == School.Siegfeld }
      }

  val moonFrontPosition =
      +getSkillTargetData(3041).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Moon }
      }
  val moonCenterPosition =
      +getSkillTargetData(3042).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Moon }
      }
  val moonRearPosition =
      +getSkillTargetData(3043).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Moon }
      }
  val flowerFrontPosition =
      +getSkillTargetData(3051).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Flower }
      }
  val flowerCenterPosition =
      +getSkillTargetData(3052).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Flower }
      }
  val flowerRearPosition =
      +getSkillTargetData(3053).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Flower }
      }
  val snowFrontPosition =
      +getSkillTargetData(3061).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Snow }
      }
  val snowCenterPosition =
      +getSkillTargetData(3062).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Snow }
      }
  val snowRearPosition =
      +getSkillTargetData(3063).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Snow }
      }
  val windFrontPosition =
      +getSkillTargetData(3071).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Wind }
      }
  val windCenterPosition =
      +getSkillTargetData(3072).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Wind }
      }
  val windRearPosition =
      +getSkillTargetData(3073).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Wind }
      }
  val spaceFrontPosition =
      +getSkillTargetData(3081).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Space }
      }
  val spaceCenterPosition =
      +getSkillTargetData(3082).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Space }
      }
  val spaceRearPosition =
      +getSkillTargetData(3083).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Space }
      }
  val cloudFrontPosition =
      +getSkillTargetData(3091).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Cloud }
      }
  val cloudCenterPosition =
      +getSkillTargetData(3092).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Cloud }
      }
  val cloudRearPosition =
      +getSkillTargetData(3093).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Cloud }
      }
  val dreamFrontPosition =
      +getSkillTargetData(3101).makeAllyTargetAoe {
        it.dress.run { position == Position.Front && attribute == Attribute.Dream }
      }
  val dreamCenterPosition =
      +getSkillTargetData(3102).makeAllyTargetAoe {
        it.dress.run { position == Position.Middle && attribute == Attribute.Dream }
      }
  val dreamRearPosition =
      +getSkillTargetData(3103).makeAllyTargetAoe {
        it.dress.run { position == Position.Back && attribute == Attribute.Dream }
      }

  val allyHikariKaguraJunnaHoshimi =
      +getSkillTargetData(3111).makeAllyTargetAoe {
        it.dress.character == Character.Hikari || it.dress.character == Character.Junna
      }
  val allyKarenAijoJunnaHoshimi =
      +getSkillTargetData(3112).makeAllyTargetAoe {
        it.dress.character == Character.Karen || it.dress.character == Character.Junna
      }
  val allyKarenAijoMayaTendo =
      +getSkillTargetData(3113).makeAllyTargetAoe {
        it.dress.character == Character.Karen || it.dress.character == Character.Maya
      }
  val allyKarenAijoMahiruTsuyuzaki =
      +getSkillTargetData(3114).makeAllyTargetAoe {
        it.dress.character == Character.Karen || it.dress.character == Character.Mahiru
      }
  val allyKaorukoHanayagiFutabaIsurugi =
      +getSkillTargetData(3115).makeAllyTargetAoe {
        it.dress.character == Character.Kaoruko || it.dress.character == Character.Futaba
      }
  val allyHikariKaguraNanaDaiba =
      +getSkillTargetData(3116).makeAllyTargetAoe {
        it.dress.character == Character.Hikari || it.dress.character == Character.Nana
      }
  val allyKarenAijoNanaDaiba =
      +getSkillTargetData(3117).makeAllyTargetAoe {
        it.dress.character == Character.Karen || it.dress.character == Character.Nana
      }
  val allyKarenAijoHikariKagura =
      +getSkillTargetData(3118).makeAllyTargetAoe {
        it.dress.character == Character.Karen || it.dress.character == Character.Hikari
      }
  val allyAkiraYukishiroShioriYumeoji =
      +getSkillTargetData(3119).makeAllyTargetAoe {
        it.dress.character == Character.Akira || it.dress.character == Character.Shiori
      }
  val allyFumiYumeojiRuiAkikaze =
      +getSkillTargetData(3120).makeAllyTargetAoe {
        it.dress.character == Character.Fumi || it.dress.character == Character.Rui
      }
  val allyAruruOtsukiMisoraKano =
      +getSkillTargetData(3130).makeAllyTargetAoe {
        it.dress.character == Character.Aruru || it.dress.character == Character.Misora
      }
  val allyKarenAijoHikariKaguraAkiraYukishiro =
      +getSkillTargetData(3140).makeAllyTargetAoe {
        it.dress.character == Character.Karen ||
            it.dress.character == Character.Hikari ||
            it.dress.character == Character.Akira
      }
  val allyFutabaIsurugiKaorukoHanayagiTamaoTomoeRuiAkikaze =
      +getSkillTargetData(3150).makeAllyTargetAoe {
        it.dress.character == Character.Futaba ||
            it.dress.character == Character.Kaoruko ||
            it.dress.character == Character.Tamao ||
            it.dress.character == Character.Rui
      }
  val allyJunnaYuyukoLalafinMeiFan =
      +getSkillTargetData(3160).makeAllyTargetAoe {
        it.dress.character == Character.Junna ||
            it.dress.character == Character.Yuyuko ||
            it.dress.character == Character.Lalafin ||
            it.dress.character == Character.MeiFan
      }
  val allyClaudineFumiShiori =
      +getSkillTargetData(3170).makeAllyTargetAoe {
        it.dress.character == Character.Claudine ||
            it.dress.character == Character.Fumi ||
            it.dress.character == Character.Shiori
      }
  val allyMayaNanaTsukasaShizuhaMichiruYachiyo =
      +getSkillTargetData(3180).makeAllyTargetAoe {
        it.dress.character == Character.Maya ||
            it.dress.character == Character.Nana ||
            it.dress.character == Character.Tsukasa ||
            it.dress.character == Character.Shizuha ||
            it.dress.character == Character.Michiru ||
            it.dress.character == Character.Yachiyo
      }
  val allyMahiruIchieAruruMisora =
      +getSkillTargetData(3190).makeAllyTargetAoe {
        it.dress.character == Character.Mahiru ||
            it.dress.character == Character.Ichie ||
            it.dress.character == Character.Aruru ||
            it.dress.character == Character.Misora
      }
  val allyKarenHikariTamaoAruruAkira =
      +getSkillTargetData(3200).makeAllyTargetAoe {
        it.dress.character == Character.Karen ||
            it.dress.character == Character.Hikari ||
            it.dress.character == Character.Tamao ||
            it.dress.character == Character.Aruru ||
            it.dress.character == Character.Akira
      }
  val allySeiran =
      +getSkillTargetData(3210).makeAllyTargetAoe { it.dress.character.school == School.Seiran }
  val allyJunnaKaorukoRuiYuyuko =
      +getSkillTargetData(3220).makeAllyTargetAoe {
        it.dress.character == Character.Junna ||
            it.dress.character == Character.Kaoruko ||
            it.dress.character == Character.Rui ||
            it.dress.character == Character.Yuyuko
      }
  val allyMayaClaudine =
      +getSkillTargetData(3230).makeAllyTargetAoe {
        it.dress.character == Character.Maya || it.dress.character == Character.Claudine
      }
  val allyKarenFutabaMichiruShiori =
      +getSkillTargetData(3240).makeAllyTargetAoe {
        it.dress.character == Character.Karen ||
            it.dress.character == Character.Futaba ||
            it.dress.character == Character.Michiru ||
            it.dress.character == Character.Shiori
      }
  val allyMahiruNanaIchieFumi =
      +getSkillTargetData(3250).makeAllyTargetAoe {
        it.dress.character == Character.Mahiru ||
            it.dress.character == Character.Nana ||
            it.dress.character == Character.Ichie ||
            it.dress.character == Character.Fumi
      }
  val allyFrontier =
      +getSkillTargetData(3260).makeAllyTargetAoe { it.dress.character.school == School.Frontier }
  val allyHikariClaudineTamaoAkiraMeiFan =
      +getSkillTargetData(3261).makeAllyTargetAoe {
        it.dress.character == Character.Hikari ||
            it.dress.character == Character.Claudine ||
            it.dress.character == Character.Tamao ||
            it.dress.character == Character.Akira ||
            it.dress.character == Character.MeiFan
      }
  val allyClaudineSaijoMayaTendo =
      +getSkillTargetData(3262).makeAllyTargetAoe {
        it.dress.character == Character.Claudine || it.dress.character == Character.Maya
      }
  val allySiegfeld =
      +getSkillTargetData(3263).makeAllyTargetAoe { it.dress.character.school == School.Siegfeld }
  val allyFutabaIsurugiKaorukoHanayagi =
      +getSkillTargetData(3264).makeAllyTargetAoe {
        it.dress.character == Character.Futaba || it.dress.character == Character.Kaoruko
      }

  val allySeisho =
      +getSkillTargetData(4001).makeAllyTargetAoe { it.dress.character.school == School.Seisho }
  val allyRinmeikan =
      +getSkillTargetData(4002).makeAllyTargetAoe { it.dress.character.school == School.Rinmeikan }
  val allyFrontier2 =
      +getSkillTargetData(4003).makeAllyTargetAoe { it.dress.character.school == School.Frontier }
  val allySiegfeld2 =
      +getSkillTargetData(4004).makeAllyTargetAoe { it.dress.character.school == School.Siegfeld }
  val allyFront =
      +getSkillTargetData(4005).makeAllyTargetAoe { it.dress.position == Position.Front }
  val allyCenter =
      +getSkillTargetData(4006).makeAllyTargetAoe { it.dress.position == Position.Middle }
  val allyRear = +getSkillTargetData(4007).makeAllyTargetAoe { it.dress.position == Position.Back }
  val allyFlower =
      +getSkillTargetData(4008).makeAllyTargetAoe { it.dress.attribute == Attribute.Flower }
  val allyWind =
      +getSkillTargetData(4009).makeAllyTargetAoe { it.dress.attribute == Attribute.Wind }
  val allySnow =
      +getSkillTargetData(4010).makeAllyTargetAoe { it.dress.attribute == Attribute.Snow }
  val allyMoon =
      +getSkillTargetData(4011).makeAllyTargetAoe { it.dress.attribute == Attribute.Moon }
  val allySpace =
      +getSkillTargetData(4012).makeAllyTargetAoe { it.dress.attribute == Attribute.Space }
  val allyCloud =
      +getSkillTargetData(4013).makeAllyTargetAoe { it.dress.attribute == Attribute.Cloud }
  val allyDream =
      +getSkillTargetData(4014).makeAllyTargetAoe { it.dress.attribute == Attribute.Dream }
  val allyActNormal =
      +getSkillTargetData(4015).makeAllyTargetAoe { it.dress.damageType == DamageType.Normal }
  val allyActSpecial =
      +getSkillTargetData(4016).makeAllyTargetAoe { it.dress.damageType == DamageType.Special }

  val allySeishoFlower =
      +getSkillTargetData(4017).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Flower
      }
  val allySeishoWind =
      +getSkillTargetData(4018).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Wind
      }
  val allySeishoSnow =
      +getSkillTargetData(4019).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Snow
      }
  val allySeishoMoon =
      +getSkillTargetData(4020).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Moon
      }
  val allySeishoSpace =
      +getSkillTargetData(4021).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Space
      }
  val allySeishoCloud =
      +getSkillTargetData(4022).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Cloud
      }
  val allySeishoDream =
      +getSkillTargetData(4023).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Dream
      }
  val allyRinmeikanFlower =
      +getSkillTargetData(4024).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Flower
      }
  val allyRinmeikanWind =
      +getSkillTargetData(4025).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Wind
      }
  val allyRinmeikanSnow =
      +getSkillTargetData(4026).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Snow
      }
  val allyRinmeikanMoon =
      +getSkillTargetData(4027).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Moon
      }
  val allyRinmeikanSpace =
      +getSkillTargetData(4028).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Space
      }
  val allyRinmeikanCloud =
      +getSkillTargetData(4029).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Cloud
      }
  val allyRinmeikanDream =
      +getSkillTargetData(4030).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Dream
      }
  val allyFrontierFlower =
      +getSkillTargetData(4031).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Flower
      }
  val allyFrontierWind =
      +getSkillTargetData(4032).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Wind
      }
  val allyFrontierSnow =
      +getSkillTargetData(4033).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Snow
      }
  val allyFrontierMoon =
      +getSkillTargetData(4034).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Moon
      }
  val allyFrontierSpace =
      +getSkillTargetData(4035).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Space
      }
  val allyFrontierCloud =
      +getSkillTargetData(4036).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Cloud
      }
  val allyFrontierDream =
      +getSkillTargetData(4037).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Dream
      }
  val allySiegfeldFlower =
      +getSkillTargetData(4038).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Flower
      }
  val allySiegfeldWind =
      +getSkillTargetData(4039).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Wind
      }
  val allySiegfeldSnow =
      +getSkillTargetData(4040).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Snow
      }
  val allySiegfeldMoon =
      +getSkillTargetData(4041).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Moon
      }
  val allySiegfeldSpace =
      +getSkillTargetData(4042).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Space
      }
  val allySiegfeldCloud =
      +getSkillTargetData(4043).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Cloud
      }
  val allySiegfeldDream =
      +getSkillTargetData(4044).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Dream
      }

  val allyFlowerActTypeNormal =
      +getSkillTargetData(4045).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower && it.dress.damageType == DamageType.Normal
      }
  val allyWindActTypeNormal =
      +getSkillTargetData(4046).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Wind && it.dress.damageType == DamageType.Normal
      }
  val allySnowActTypeNormal =
      +getSkillTargetData(4047).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Snow && it.dress.damageType == DamageType.Normal
      }
  val allyMoonActTypeNormal =
      +getSkillTargetData(4048).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon && it.dress.damageType == DamageType.Normal
      }
  val allySpaceActTypeNormal =
      +getSkillTargetData(4049).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Space && it.dress.damageType == DamageType.Normal
      }
  val allyCloudActTypeNormal =
      +getSkillTargetData(4050).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Cloud && it.dress.damageType == DamageType.Normal
      }
  val allyDreamActTypeNormal =
      +getSkillTargetData(4051).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Dream && it.dress.damageType == DamageType.Normal
      }
  val allyFlowerActTypeSpecial =
      +getSkillTargetData(4052).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower && it.dress.damageType == DamageType.Special
      }
  val allyWindActTypeSpecial =
      +getSkillTargetData(4053).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Wind && it.dress.damageType == DamageType.Special
      }
  val allySnowActTypeSpecial =
      +getSkillTargetData(4054).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Snow && it.dress.damageType == DamageType.Special
      }
  val allyMoonActTypeSpecial =
      +getSkillTargetData(4055).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon && it.dress.damageType == DamageType.Special
      }
  val allySpaceActTypeSpecial =
      +getSkillTargetData(4056).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Space && it.dress.damageType == DamageType.Special
      }
  val allyCloudActTypeSpecial =
      +getSkillTargetData(4057).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Cloud && it.dress.damageType == DamageType.Special
      }
  val allyDreamActTypeSpecial =
      +getSkillTargetData(4058).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Dream && it.dress.damageType == DamageType.Special
      }

  val allySeiran2 =
      +getSkillTargetData(4059).makeAllyTargetAoe { it.dress.character.school == School.Seiran }
  val allySeiranFlower =
      +getSkillTargetData(4060).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Flower
      }
  val allySeiranWind =
      +getSkillTargetData(4061).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Wind
      }
  val allySeiranSnow =
      +getSkillTargetData(4062).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Snow
      }
  val allySeiranMoon =
      +getSkillTargetData(4063).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Moon
      }
  val allySeiranSpace =
      +getSkillTargetData(4064).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Space
      }
  val allySeiranCloud =
      +getSkillTargetData(4065).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Cloud
      }
  val allySeiranDream =
      +getSkillTargetData(4066).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran && it.dress.attribute == Attribute.Dream
      }

  val enemyFrontPosition =
      +getSkillTargetData(4067).makeEnemyTargetAoe { it.dress.position == Position.Front }
  val enemyCenterPosition =
      +getSkillTargetData(4068).makeEnemyTargetAoe { it.dress.position == Position.Middle }
  val enemyRearPosition =
      +getSkillTargetData(4069).makeEnemyTargetAoe { it.dress.position == Position.Back }

  val allyArcanaArcadia =
      +getSkillTargetData(4070).makeAllyTargetAoe { it.dress.id in DressCategory.Arcana }
  val enemyArcanaArcadia =
      +getSkillTargetData(4071).makeEnemyTargetAoe { it.dress.id in DressCategory.Arcana }

  val allySeiran3 =
      +getSkillTargetData(4072).makeAllyTargetAoe { it.dress.character.school == School.Seiran }

  val enemy1stRearSeisho =
      +getSkillTargetData(4073).makeEnemyTargetSingleNthLowest(
          1,
          filter = { it.dress.character.school == School.Seisho },
      ) {
        0
      }
  val enemy1stRearRinmeikan =
      +getSkillTargetData(4074).makeEnemyTargetSingleNthLowest(
          1,
          filter = { it.dress.character.school == School.Rinmeikan },
      ) {
        0
      }
  val enemy1stRearFrontier =
      +getSkillTargetData(4075).makeEnemyTargetSingleNthLowest(
          1,
          filter = { it.dress.character.school == School.Frontier },
      ) {
        0
      }
  val enemy1stRearSiegfeld =
      +getSkillTargetData(4076).makeEnemyTargetSingleNthLowest(
          1,
          filter = { it.dress.character.school == School.Siegfeld },
      ) {
        0
      }
  val enemy1stRearSeiran =
      +getSkillTargetData(4077).makeEnemyTargetSingleNthLowest(
          1,
          filter = { it.dress.character.school == School.Seiran },
      ) {
        0
      }

  val enemy1stFrontSeisho =
      +getSkillTargetData(4078).makeEnemyTargetSingleNthHighest(
          1,
          filter = { it.dress.character.school == School.Seisho },
      ) {
        0
      }
  val enemy1stFrontRinmeikan =
      +getSkillTargetData(4079).makeEnemyTargetSingleNthHighest(
          1,
          filter = { it.dress.character.school == School.Rinmeikan },
      ) {
        0
      }
  val enemy1stFrontFrontier =
      +getSkillTargetData(4080).makeEnemyTargetSingleNthHighest(
          1,
          filter = { it.dress.character.school == School.Frontier },
      ) {
        0
      }
  val enemy1stFrontSiegfeld =
      +getSkillTargetData(4081).makeEnemyTargetSingleNthHighest(
          1,
          filter = { it.dress.character.school == School.Siegfeld },
      ) {
        0
      }
  val enemy1stFrontSeiran =
      +getSkillTargetData(4082).makeEnemyTargetSingleNthHighest(
          1,
          filter = { it.dress.character.school == School.Seiran },
      ) {
        0
      }

  val enemyActTypeNormal =
      +getSkillTargetData(4083).makeEnemyTargetAoe { it.dress.damageType == DamageType.Normal }
  val enemyActTypeSpecial =
      +getSkillTargetData(4084).makeEnemyTargetAoe { it.dress.damageType == DamageType.Special }

  val allyStageGirlsCollection =
      +getSkillTargetData(4085).makeAllyTargetAoe {
        it.dress.id in DressCategory.StageGirlsCollection
      }

  val allyFlowerWindSnow =
      +getSkillTargetData(4086).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower ||
            it.dress.attribute == Attribute.Wind ||
            it.dress.attribute == Attribute.Snow
      }
  val allyMoonSpaceCloud =
      +getSkillTargetData(4087).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon ||
            it.dress.attribute == Attribute.Space ||
            it.dress.attribute == Attribute.Cloud
      }
  val allyFlowerSun =
      +getSkillTargetData(4088).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun
      }
  val allyWindSun =
      +getSkillTargetData(4089).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun
      }
  val allySnowSun =
      +getSkillTargetData(4090).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun
      }
  val allyMoonStar =
      +getSkillTargetData(4091).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star
      }
  val allySpaceStar =
      +getSkillTargetData(4092).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star
      }
  val allyCloudStar =
      +getSkillTargetData(4093).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star
      }

  val allySeishoFlowerSun =
      +getSkillTargetData(4094).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun)
      }
  val allySeishoWindSun =
      +getSkillTargetData(4095).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun)
      }
  val allySeishoSnowSun =
      +getSkillTargetData(4096).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun)
      }
  val allySeishoMoonStar =
      +getSkillTargetData(4097).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star)
      }
  val allySeishoSpaceStar =
      +getSkillTargetData(4098).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star)
      }
  val allySeishoCloudStar =
      +getSkillTargetData(4099).makeAllyTargetAoe {
        it.dress.character.school == School.Seisho &&
            (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star)
      }

  val allyRinmeikanFlowerSun =
      +getSkillTargetData(4100).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun)
      }
  val allyRinmeikanWindSun =
      +getSkillTargetData(4101).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun)
      }
  val allyRinmeikanSnowSun =
      +getSkillTargetData(4102).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun)
      }
  val allyRinmeikanMoonStar =
      +getSkillTargetData(4103).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star)
      }
  val allyRinmeikanSpaceStar =
      +getSkillTargetData(4104).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star)
      }
  val allyRinmeikanCloudStar =
      +getSkillTargetData(4105).makeAllyTargetAoe {
        it.dress.character.school == School.Rinmeikan &&
            (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star)
      }

  val allyFrontierFlowerSun =
      +getSkillTargetData(4106).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun)
      }
  val allyFrontierWindSun =
      +getSkillTargetData(4107).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun)
      }
  val allyFrontierSnowSun =
      +getSkillTargetData(4108).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun)
      }
  val allyFrontierMoonStar =
      +getSkillTargetData(4109).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star)
      }
  val allyFrontierSpaceStar =
      +getSkillTargetData(4110).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star)
      }
  val allyFrontierCloudStar =
      +getSkillTargetData(4111).makeAllyTargetAoe {
        it.dress.character.school == School.Frontier &&
            (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star)
      }

  val allySiegfeldFlowerSun =
      +getSkillTargetData(4112).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun)
      }
  val allySiegfeldWindSun =
      +getSkillTargetData(4113).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun)
      }
  val allySiegfeldSnowSun =
      +getSkillTargetData(4114).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun)
      }
  val allySiegfeldMoonStar =
      +getSkillTargetData(4115).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star)
      }
  val allySiegfeldSpaceStar =
      +getSkillTargetData(4116).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star)
      }
  val allySiegfeldCloudStar =
      +getSkillTargetData(4117).makeAllyTargetAoe {
        it.dress.character.school == School.Siegfeld &&
            (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star)
      }

  val allyFlowerSunActTypeNormal =
      +getSkillTargetData(4118).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Normal
      }
  val allyWindSunActTypeNormal =
      +getSkillTargetData(4119).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Normal
      }
  val allySnowSunActTypeNormal =
      +getSkillTargetData(4120).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Normal
      }
  val allyMoonStarActTypeNormal =
      +getSkillTargetData(4121).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Normal
      }
  val allySpaceStarActTypeNormal =
      +getSkillTargetData(4122).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Normal
      }
  val allyCloudStarActTypeNormal =
      +getSkillTargetData(4123).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Normal
      }

  val allyFlowerSunActTypeSpecial =
      +getSkillTargetData(4124).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Special
      }
  val allyWindSunActTypeSpecial =
      +getSkillTargetData(4125).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Special
      }
  val allySnowSunActTypeSpecial =
      +getSkillTargetData(4126).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun) &&
            it.dress.damageType == DamageType.Special
      }
  val allyMoonStarActTypeSpecial =
      +getSkillTargetData(4127).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Special
      }
  val allySpaceStarActTypeSpecial =
      +getSkillTargetData(4128).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Special
      }
  val allyCloudStarActTypeSpecial =
      +getSkillTargetData(4129).makeAllyTargetAoe {
        (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star) &&
            it.dress.damageType == DamageType.Special
      }

  val allySeiranFlowerSun =
      +getSkillTargetData(4130).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Flower || it.dress.attribute == Attribute.Sun)
      }
  val allySeiranWindSun =
      +getSkillTargetData(4131).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Wind || it.dress.attribute == Attribute.Sun)
      }
  val allySeiranSnowSun =
      +getSkillTargetData(4132).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Snow || it.dress.attribute == Attribute.Sun)
      }
  val allySeiranMoonStar =
      +getSkillTargetData(4133).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Moon || it.dress.attribute == Attribute.Star)
      }
  val allySeiranSpaceStar =
      +getSkillTargetData(4134).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Space || it.dress.attribute == Attribute.Star)
      }
  val allySeiranCloudStar =
      +getSkillTargetData(4135).makeAllyTargetAoe {
        it.dress.character.school == School.Seiran &&
            (it.dress.attribute == Attribute.Cloud || it.dress.attribute == Attribute.Star)
      }

  val allyMovieSeries =
      +getSkillTargetData(4136).makeAllyTargetAoe { it.dress.id in DressCategory.Movie }
  val enemyMovieSeries =
      +getSkillTargetData(4137).makeEnemyTargetAoe { it.dress.id in DressCategory.Movie }

  val allyRoseOfVersaillesSeries =
      +getSkillTargetData(4138).makeAllyTargetAoe { it.dress.id in DressCategory.RoV }
  val enemyRoseOfVersaillesSeries =
      +getSkillTargetData(4139).makeEnemyTargetAoe { it.dress.id in DressCategory.RoV }

  val allyJunnaHoshimiNanaDaiba =
      +getSkillTargetData(4140).makeAllyTargetAoe {
        it.dress.character == Character.Junna || it.dress.character == Character.Nana
      }
  val allyKuinaTamaoAkira =
      +getSkillTargetData(4141).makeAllyTargetAoe {
        it.dress.character == Character.Kuina ||
            it.dress.character == Character.Tamao ||
            it.dress.character == Character.Akira
      }
  val allyHisameHikariTsukasa =
      +getSkillTargetData(4142).makeAllyTargetAoe {
        it.dress.character == Character.Hisame ||
            it.dress.character == Character.Hikari ||
            it.dress.character == Character.Tsukasa
      }
  val allyFumiMichiru =
      +getSkillTargetData(4143).makeAllyTargetAoe {
        it.dress.character == Character.Fumi || it.dress.character == Character.Michiru
      }
  val allyKaorukoKoharuIchie =
      +getSkillTargetData(4144).makeAllyTargetAoe {
        it.dress.character == Character.Kaoruko ||
            it.dress.character == Character.Koharu ||
            it.dress.character == Character.Ichie
      }
  val allyLalafinFutaba =
      +getSkillTargetData(4145).makeAllyTargetAoe {
        it.dress.character == Character.Lalafin || it.dress.character == Character.Futaba
      }
  val allyMahiruShiro =
      +getSkillTargetData(4146).makeAllyTargetAoe {
        it.dress.character == Character.Mahiru || it.dress.character == Character.Shiro
      }
  val allyAruruYuyukoShiori =
      +getSkillTargetData(4147).makeAllyTargetAoe {
        it.dress.character == Character.Aruru ||
            it.dress.character == Character.Yuyuko ||
            it.dress.character == Character.Shiori
      }
  val allyMinkuRyokoNana =
      +getSkillTargetData(4148).makeAllyTargetAoe {
        it.dress.character == Character.Minku ||
            it.dress.character == Character.Ryoko ||
            it.dress.character == Character.Nana
      }
  val allyMayaClaudineShizuha =
      +getSkillTargetData(4149).makeAllyTargetAoe {
        it.dress.character == Character.Maya ||
            it.dress.character == Character.Claudine ||
            it.dress.character == Character.Shizuha
      }
  val allySuzuStellaMeiFan =
      +getSkillTargetData(4150).makeAllyTargetAoe {
        it.dress.character == Character.Suzu ||
            it.dress.character == Character.Stella ||
            it.dress.character == Character.MeiFan
      }
  val allyKarenJunnaMisora =
      +getSkillTargetData(4151).makeAllyTargetAoe {
        it.dress.character == Character.Karen ||
            it.dress.character == Character.Junna ||
            it.dress.character == Character.Misora
      }
  val allyYachiyoRui =
      +getSkillTargetData(4152).makeAllyTargetAoe {
        it.dress.character == Character.Yachiyo || it.dress.character == Character.Rui
      }

  val milkyHolmesSeries =
      +getSkillTargetData(4153).makeAllyTargetAoe { it.dress.id in DressCategory.MilkyHolmes }

  val allySun = +getSkillTargetData(4154).makeAllyTargetAoe { it.dress.attribute == Attribute.Sun }

  val allyStar =
      +getSkillTargetData(4155).makeAllyTargetAoe { it.dress.attribute == Attribute.Star }

  val allyFlowerWindSnowSun =
      +getSkillTargetData(4156).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower ||
            it.dress.attribute == Attribute.Wind ||
            it.dress.attribute == Attribute.Snow ||
            it.dress.attribute == Attribute.Sun
      }

  val allyMoonSpaceCloudStar =
      +getSkillTargetData(4157).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon ||
            it.dress.attribute == Attribute.Space ||
            it.dress.attribute == Attribute.Cloud ||
            it.dress.attribute == Attribute.Star
      }

  val allyStellaShiroRyokoMinkuKuina =
      +getSkillTargetData(4158).makeAllyTargetAoe {
        it.dress.character == Character.Stella ||
            it.dress.character == Character.Shiro ||
            it.dress.character == Character.Ryoko ||
            it.dress.character == Character.Minku ||
            it.dress.character == Character.Kuina
      }

  val allyJunnaKaorukoRuiYuyuko2 =
      +getSkillTargetData(4159).makeAllyTargetAoe {
        it.dress.character == Character.Junna ||
            it.dress.character == Character.Kaoruko ||
            it.dress.character == Character.Rui ||
            it.dress.character == Character.Yuyuko
      }

  val allyFutabaMichiruShiori =
      +getSkillTargetData(4160).makeAllyTargetAoe {
        it.dress.character == Character.Futaba ||
            it.dress.character == Character.Michiru ||
            it.dress.character == Character.Shiori
      }

  val allyIchieFumiMahiruNana =
      +getSkillTargetData(4161).makeAllyTargetAoe {
        it.dress.character == Character.Ichie ||
            it.dress.character == Character.Fumi ||
            it.dress.character == Character.Mahiru ||
            it.dress.character == Character.Nana
      }

  val allyMisoraLalafinTsukasaShizuha =
      +getSkillTargetData(4162).makeAllyTargetAoe {
        it.dress.character == Character.Misora ||
            it.dress.character == Character.Lalafin ||
            it.dress.character == Character.Tsukasa ||
            it.dress.character == Character.Shizuha
      }

  val allyHikariClaudineTamaoAkiraMeiFan2 =
      +getSkillTargetData(4163).makeAllyTargetAoe {
        it.dress.character == Character.Hikari ||
            it.dress.character == Character.Claudine ||
            it.dress.character == Character.Tamao ||
            it.dress.character == Character.Akira ||
            it.dress.character == Character.MeiFan
      }

  val allyKarenMayaYachiyo =
      +getSkillTargetData(4164).makeAllyTargetAoe {
        it.dress.character == Character.Karen ||
            it.dress.character == Character.Maya ||
            it.dress.character == Character.Yachiyo
      }

  val allyFlowerDreamSun =
      +getSkillTargetData(4165).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Flower ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Sun
      }

  val allyWindDreamSun =
      +getSkillTargetData(4166).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Wind ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Sun
      }

  val allySnowDreamSun =
      +getSkillTargetData(4167).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Snow ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Sun
      }

  val allyMoonDreamStar =
      +getSkillTargetData(4168).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Moon ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Star
      }

  val allySpaceDreamStar =
      +getSkillTargetData(4169).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Space ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Star
      }

  val allyCloudDreamStar =
      +getSkillTargetData(4170).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Cloud ||
            it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Star
      }

  val allyHighestAgility =
      +getSkillTargetData(4171).makeAllyTargetSingleNthHighest(1) { it.mod { +agility } }
  val ally2ndHighestAgility =
      +getSkillTargetData(4172).makeAllyTargetSingleNthHighest(2) { it.mod { +agility } }
  val ally3rdHighestAgility =
      +getSkillTargetData(4173).makeAllyTargetSingleNthHighest(3) { it.mod { +agility } }
  val ally4thHighestAgility =
      +getSkillTargetData(4174).makeAllyTargetSingleNthHighest(4) { it.mod { +agility } }
  val ally5thHighestAgility =
      +getSkillTargetData(4175).makeAllyTargetSingleNthHighest(5) { it.mod { +agility } }
  val enemyHighestAgility =
      +getSkillTargetData(4176).makeEnemyTargetSingleNthHighest(1) { it.mod { +agility } }
  val enemy2ndHighestAgility =
      +getSkillTargetData(4177).makeEnemyTargetSingleNthHighest(2) { it.mod { +agility } }
  val enemy3rdHighestAgility =
      +getSkillTargetData(4178).makeEnemyTargetSingleNthHighest(3) { it.mod { +agility } }
  val enemy4thHighestAgility =
      +getSkillTargetData(4179).makeEnemyTargetSingleNthHighest(4) { it.mod { +agility } }
  val enemy5thHighestAgility =
      +getSkillTargetData(4180).makeEnemyTargetSingleNthHighest(5) { it.mod { +agility } }
  val allyLowestAgility =
      +getSkillTargetData(4181).makeAllyTargetSingleNthLowest(1) { it.mod { +agility } }
  val ally2ndLowestAgility =
      +getSkillTargetData(4182).makeAllyTargetSingleNthLowest(2) { it.mod { +agility } }
  val ally3rdLowestAgility =
      +getSkillTargetData(4183).makeAllyTargetSingleNthLowest(3) { it.mod { +agility } }
  val ally4thLowestAgility =
      +getSkillTargetData(4184).makeAllyTargetSingleNthLowest(4) { it.mod { +agility } }
  val ally5thLowestAgility =
      +getSkillTargetData(4185).makeAllyTargetSingleNthLowest(5) { it.mod { +agility } }
  val enemyLowestAgility =
      +getSkillTargetData(4186).makeEnemyTargetSingleNthLowest(1) { it.mod { +agility } }
  val enemy2ndLowestAgility =
      +getSkillTargetData(4187).makeEnemyTargetSingleNthLowest(2) { it.mod { +agility } }
  val enemy3rdLowestAgility =
      +getSkillTargetData(4188).makeEnemyTargetSingleNthLowest(3) { it.mod { +agility } }
  val enemy4thLowestAgility =
      +getSkillTargetData(4189).makeEnemyTargetSingleNthLowest(4) { it.mod { +agility } }
  val enemy5thLowestAgility =
      +getSkillTargetData(4190).makeEnemyTargetSingleNthLowest(5) { it.mod { +agility } }

  val allyAkiraMichiruMeiFanShioriYachiyo =
      +getSkillTargetData(4191).makeAllyTargetAoe {
        it.dress.character == Character.Akira ||
            it.dress.character == Character.Michiru ||
            it.dress.character == Character.MeiFan ||
            it.dress.character == Character.Shiori ||
            it.dress.character == Character.Yachiyo
      }

  val allyDreamSunStar =
      +getSkillTargetData(4192).makeAllyTargetAoe {
        it.dress.attribute == Attribute.Dream ||
            it.dress.attribute == Attribute.Sun ||
            it.dress.attribute == Attribute.Star
      }

  val enemySeishoSiegfeld =
      +getSkillTargetData(4193).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho || it.dress.character.school == School.Siegfeld
      }

  val enemySeishoFlower =
      +getSkillTargetData(4194).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Flower
      }
  val enemySeishoWind =
      +getSkillTargetData(4195).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Wind
      }
  val enemySeishoSnow =
      +getSkillTargetData(4196).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Snow
      }
  val enemySeishoMoon =
      +getSkillTargetData(4197).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Moon
      }
  val enemySeishoSpace =
      +getSkillTargetData(4198).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Space
      }
  val enemySeishoCloud =
      +getSkillTargetData(4199).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Cloud
      }
  val enemySieshoDream =
      +getSkillTargetData(4200).makeEnemyTargetAoe {
        it.dress.character.school == School.Seisho && it.dress.attribute == Attribute.Dream
      }
  val enemyFrontierFlower =
      +getSkillTargetData(4201).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Flower
      }
  val enemyFrontierWind =
      +getSkillTargetData(4202).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Wind
      }
  val enemyFrontierSnow =
      +getSkillTargetData(4203).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Snow
      }
  val enemyFrontierMoon =
      +getSkillTargetData(4204).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Moon
      }
  val enemyFrontierSpace =
      +getSkillTargetData(4205).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Space
      }
  val enemyFrontierCloud =
      +getSkillTargetData(4206).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Cloud
      }
  val enemyFrontierDream =
      +getSkillTargetData(4207).makeEnemyTargetAoe {
        it.dress.character.school == School.Frontier && it.dress.attribute == Attribute.Dream
      }

  val EnemyRinmeikanFlower =
      +getSkillTargetData(4208).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Flower
      }
  val EnemyRinmeikanWind =
      +getSkillTargetData(4209).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Wind
      }
  val EnemyRinmeikanSnow =
      +getSkillTargetData(4210).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Snow
      }
  val EnemyRinmeikanMoon =
      +getSkillTargetData(4211).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Moon
      }
  val EnemyRinmeikanSpace =
      +getSkillTargetData(4212).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Space
      }
  val EnemyRinmeikanCloud =
      +getSkillTargetData(4213).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Cloud
      }
  val EnemyRinmeikanDream =
      +getSkillTargetData(4214).makeEnemyTargetAoe {
        it.dress.character.school == School.Rinmeikan && it.dress.attribute == Attribute.Dream
      }

  val EnemySiegefeldFlower =
      +getSkillTargetData(4215).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Flower
      }
  val EnemySiegefeldWind =
      +getSkillTargetData(4216).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Wind
      }
  val EnemySiegefeldSnow =
      +getSkillTargetData(4217).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Snow
      }
  val EnemySiegefeldMoon =
      +getSkillTargetData(4218).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Moon
      }
  val EnemySiegefeldSpace =
      +getSkillTargetData(4219).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Space
      }
  val EnemySiegefeldCloud =
      +getSkillTargetData(4220).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Cloud
      }
  val EnemySiegefeldDream =
      +getSkillTargetData(4221).makeEnemyTargetAoe {
        it.dress.character.school == School.Siegfeld && it.dress.attribute == Attribute.Dream
      }

  val EnemyFlower =
      +getSkillTargetData(4222).makeEnemyTargetAoe { it.dress.attribute == Attribute.Flower }
  val EnemyWind =
      +getSkillTargetData(4223).makeEnemyTargetAoe { it.dress.attribute == Attribute.Wind }
  val EnemySnow =
      +getSkillTargetData(4224).makeEnemyTargetAoe { it.dress.attribute == Attribute.Snow }
  val EnemyMoon =
      +getSkillTargetData(4225).makeEnemyTargetAoe { it.dress.attribute == Attribute.Moon }
  val EnemySpace =
      +getSkillTargetData(4226).makeEnemyTargetAoe { it.dress.attribute == Attribute.Space }
  val EnemyCloud =
      +getSkillTargetData(4227).makeEnemyTargetAoe { it.dress.attribute == Attribute.Cloud }
  val EnemyDream =
      +getSkillTargetData(4228).makeEnemyTargetAoe { it.dress.attribute == Attribute.Dream }

  // Handled specially
  val randomAllyPerHit = +getSkillTargetData(5001).makeAllyTargetAoe()
  val randomEnemyPerHit = +getSkillTargetData(6001).makeEnemyTargetAoe()
  val randomEnemyPerHit2 = +getSkillTargetData(6010).makeEnemyTargetAoe()
  val randomEnemyPerHit3 = +getSkillTargetData(6020).makeEnemyTargetAoe()

  val selfAndKaren =
      +getSkillTargetData(7101).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Karen })
      }
  val selfAndHikari =
      +getSkillTargetData(7102).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Hikari })
      }
  val selfAndMahiru =
      +getSkillTargetData(7103).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Mahiru })
      }
  val selfAndClaudine =
      +getSkillTargetData(7104).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Claudine })
      }
  val selfAndMaya =
      +getSkillTargetData(7105).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Maya })
      }
  val selfAndJunna =
      +getSkillTargetData(7106).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Junna })
      }
  val selfAndNana =
      +getSkillTargetData(7107).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Nana })
      }
  val selfAndFutaba =
      +getSkillTargetData(7108).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Futaba })
      }
  val selfAndKaoruko =
      +getSkillTargetData(7109).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Kaoruko })
      }
  val selfAndTamao =
      +getSkillTargetData(7201).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Tamao })
      }
  val selfAndIchie =
      +getSkillTargetData(7202).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Ichie })
      }
  val selfAndFumi =
      +getSkillTargetData(7203).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Fumi })
      }
  val selfAndRui =
      +getSkillTargetData(7204).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Rui })
      }
  val selfAndYuyuko =
      +getSkillTargetData(7205).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Yuyuko })
      }
  val selfAndAruru =
      +getSkillTargetData(7301).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Aruru })
      }
  val selfAndMisora =
      +getSkillTargetData(7302).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Misora })
      }
  val selfAndLalafin =
      +getSkillTargetData(7303).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Lalafin })
      }
  val selfAndTsukasa =
      +getSkillTargetData(7304).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Tsukasa })
      }
  val selfAndShizuha =
      +getSkillTargetData(7305).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Shizuha })
      }
  val selfAndAkira =
      +getSkillTargetData(7401).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Akira })
      }
  val selfAndMichiru =
      +getSkillTargetData(7402).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Michiru })
      }
  val selfAndLiuMeiFan =
      +getSkillTargetData(7403).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.MeiFan })
      }
  val selfAndShiori =
      +getSkillTargetData(7404).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Shiori })
      }
  val selfAndYachiyo =
      +getSkillTargetData(7405).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Yachiyo })
      }
  val selfAndKoharu =
      +getSkillTargetData(7501).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Koharu })
      }
  val selfAndSuzu =
      +getSkillTargetData(7502).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Suzu })
      }
  val selfAndHisame =
      +getSkillTargetData(7503).makeAllyTarget {
        listOfNotNull(self?.takeIf { it.dress.character == Character.Hisame })
      }

  // TODO: revives
  val firstDefeatedFrontAlly = +getSkillTargetData(11011).makeAllyTarget { listOf() }
  val firstDefeatedRearAlly = +getSkillTargetData(11012).makeAllyTarget { listOf() }
  val back3DefeatedAlly = +getSkillTargetData(11013).makeAllyTarget { listOf() }

  val focusAllEnemies = +getSkillTargetData(22002).makeEnemyTarget { enemy.active.toList() }
}
