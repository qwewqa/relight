package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenBuff: Map<Int, GenBuff> by lazy { loadMasterData<GenBuff>(dataGenBuff) }
