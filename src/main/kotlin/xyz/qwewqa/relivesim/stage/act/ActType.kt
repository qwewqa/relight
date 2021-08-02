package xyz.qwewqa.relivesim.stage.act

sealed class ActType {
    object Act1 : ActType()
    object Act2 : ActType()
    object Act3 : ActType()
    object ClimaxAct : ActType()
    data class OtherAct(val name: String) : ActType()
}