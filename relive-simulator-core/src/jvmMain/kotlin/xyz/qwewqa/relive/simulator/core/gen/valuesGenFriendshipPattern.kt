package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenFriendshipPattern: Map<Int, List<FriendshipPanel>> by lazy {
  loadMasterData<ListGenFriendshipPattern>(dataGenFriendshipPattern)
}
