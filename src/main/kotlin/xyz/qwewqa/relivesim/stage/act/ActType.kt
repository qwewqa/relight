package xyz.qwewqa.relivesim.stage.act

sealed class ActType {
    object Act1 : ActType()
    object Act2 : ActType()
    object Act3 : ActType()
    object Act4 : ActType()
    object Act5 : ActType()
    object Act6 : ActType()
    object Act7 : ActType()
    object Act8 : ActType()
    object Act9 : ActType()
    object ClimaxAct : ActType()
    object ConfusionAct: ActType()
    data class OtherAct(val name: String) : ActType()
}