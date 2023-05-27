package xyz.qwewqa.relive.simulator.core.gen

inline fun <T> loadJsMasterData(data: String, converter: (Int, dynamic) -> T): Map<Int, T> {
  val json = JSON.parse<dynamic>(data)
  val map = mutableMapOf<Int, T>()
  for (key in js("Object").keys(json)) {
    val intKey = key.unsafeCast<String>().toInt()
    map[intKey] = converter(intKey, json[key])
  }
  return map
}

fun <T> arrayFromDynamic(array: dynamic): Array<T> = array.unsafeCast<Array<T>>()

fun <T> stringMapFromDynamic(map: dynamic): Map<String, T> {
  val result = stringMapOf<T>()
  if (map == null) {
    return result
  }
  for (key in js("Object").keys(map)) {
    result[key.unsafeCast<String>()] = map[key].unsafeCast<T>()
  }
  return result
}
