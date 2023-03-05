package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry

class SkillExecuteTiming(
    override val id: Int,
    val target: CutinTarget
) : FeatureImplementation

object CutinTargets : ImplementationRegistry<SkillExecuteTiming>() {
  val turnStart = +SkillExecuteTiming(1, CutinTarget.TurnStart)
  val turnEnd = +SkillExecuteTiming(2, CutinTarget.TurnEnd)

  val beforeAlly1stAct = +SkillExecuteTiming(1001, CutinTarget.BeforeAllyAct(1))
  val beforeAlly2ndAct = +SkillExecuteTiming(1002, CutinTarget.BeforeAllyAct(2))
  val beforeAlly3rdAct = +SkillExecuteTiming(1003, CutinTarget.BeforeAllyAct(3))
  val beforeAlly4thAct = +SkillExecuteTiming(1004, CutinTarget.BeforeAllyAct(4))
  val beforeAlly5thAct = +SkillExecuteTiming(1005, CutinTarget.BeforeAllyAct(5))

  // TODO: Add after acts

//  val afterAlly1stAct = +SkillExecuteTiming(1101, CutinTarget.AfterAllyAct(1))
//  val afterAlly2ndAct = +SkillExecuteTiming(1102, CutinTarget.AfterAllyAct(2))
//  val afterAlly3rdAct = +SkillExecuteTiming(1103, CutinTarget.AfterAllyAct(3))
//  val afterAlly4thAct = +SkillExecuteTiming(1104, CutinTarget.AfterAllyAct(4))
//  val afterAlly5thAct = +SkillExecuteTiming(1105, CutinTarget.AfterAllyAct(5))

  val beforeEnemy1stAct = +SkillExecuteTiming(2001, CutinTarget.BeforeEnemyAct(1))
  val beforeEnemy2ndAct = +SkillExecuteTiming(2002, CutinTarget.BeforeEnemyAct(2))
  val beforeEnemy3rdAct = +SkillExecuteTiming(2003, CutinTarget.BeforeEnemyAct(3))
  val beforeEnemy4thAct = +SkillExecuteTiming(2004, CutinTarget.BeforeEnemyAct(4))
  val beforeEnemy5thAct = +SkillExecuteTiming(2005, CutinTarget.BeforeEnemyAct(5))

//  val afterEnemy1stAct = +SkillExecuteTiming(2101, CutinTarget.AfterEnemyAct(1))
//  val afterEnemy2ndAct = +SkillExecuteTiming(2102, CutinTarget.AfterEnemyAct(2))
//  val afterEnemy3rdAct = +SkillExecuteTiming(2103, CutinTarget.AfterEnemyAct(3))
//  val afterEnemy4thAct = +SkillExecuteTiming(2104, CutinTarget.AfterEnemyAct(4))
//  val afterEnemy5thAct = +SkillExecuteTiming(2105, CutinTarget.AfterEnemyAct(5))
}
