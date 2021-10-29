package xyz.qwewqa.relive.simulator.browser

import kotlinx.browser.window
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.Worker
import xyz.qwewqa.relive.simulator.client.*
import kotlin.random.Random

class JsSimulator : Simulator {
    override suspend fun simulate(parameters: SimulationParameters): Simulation {
        return JsSimulation(parameters)
    }

    override suspend fun version(): SimulatorVersion {
        return SimulatorClient.version
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun options(): SimulationOptions {
        // TODO: Not do this
        return Json.decodeFromString("""{"locales":{"en":"English","zh_hant":"繁体中文","ko":"한국어"},"commonText":[{"id":"none","name":{"en":"None","zh_hant":"無"},"description":null,"tags":null},{"id":".text-shutdown","name":{"en":"Shutdown","zh_hant":"關閉"},"description":null,"tags":null},{"id":".text-import","name":{"en":"Import","zh_hant":"輸入"},"description":null,"tags":null},{"id":".text-export","name":{"en":"Export","zh_hant":"輸出"},"description":null,"tags":null},{"id":".text-close-dialog","name":{"en":"Close","zh_hant":"關閉"},"description":null,"tags":null},{"id":".text-use-yaml","name":{"en":"YAML","zh_hant":"YAML"},"description":null,"tags":null},{"id":".text-stage-configuration","name":{"en":"Stage Configuration","zh_hant":"配置"},"description":null,"tags":null},{"id":".text-iterations","name":{"en":"Iterations","zh_hant":"測試回數"},"description":null,"tags":null},{"id":".text-max-turns","name":{"en":"Max Turns","zh_hant":"最多回合"},"description":null,"tags":null},{"id":".text-seed","name":{"en":"Seed","zh_hant":"隨機種子"},"description":null,"tags":null},{"id":".text-boss","name":{"en":"Boss","zh_hant":"王"},"description":null,"tags":null},{"id":".text-event-bonus","name":{"en":"Extra Event Bonus (Chest)","zh_hant":"額外活動傷害加乘 [爬塔箱子]"},"description":null,"tags":null},{"id":".text-actors","name":{"en":"Actors (front to back)","zh_hant":"角色 (從前到後)"},"description":null,"tags":null},{"id":".text-actor-name","name":{"en":"Name","zh_hant":"(自訂)名稱"},"description":null,"tags":null},{"id":".text-dress","name":{"en":"Dress","zh_hant":"角色"},"description":null,"tags":null},{"id":".text-unit-skill-level","name":{"en":"Unit Skill Level","zh_hant":"US等級"},"description":null,"tags":null},{"id":".text-memoir","name":{"en":"Memoir","zh_hant":"回憶"},"description":null,"tags":null},{"id":".text-memoir-level","name":{"en":"Memoir Level","zh_hant":"回憶等級"},"description":null,"tags":null},{"id":".text-memoir-unbind","name":{"en":"Memoir Unbind","zh_hant":"回憶突破次數"},"description":null,"tags":null},{"id":".text-add-actor","name":{"en":"Add Actor","zh_hant":"添加角色"},"description":null,"tags":null},{"id":".text-remove-actor","name":{"en":"Remove Actor","zh_hant":"移除角色"},"description":null,"tags":null},{"id":".text-song","name":{"en":"Song","zh_hant":"歌曲"},"description":null,"tags":null},{"id":".text-song-effect-1","name":{"en":"Effect 1","zh_hant":"效果一"},"description":null,"tags":null},{"id":".text-song-effect-2","name":{"en":"Effect 2","zh_hant":"效果二"},"description":null,"tags":null},{"id":".text-song-effect-3","name":{"en":"Effect 3 (Passive)","zh_hant":"效果三 (永續)"},"description":null,"tags":null},{"id":".text-song-effect-type","name":{"en":"Type","zh_hant":"類型"},"description":null,"tags":null},{"id":".text-song-effect-value","name":{"en":"Value","zh_hant":"數值"},"description":null,"tags":null},{"id":".text-song-condition-1","name":{"en":"Condition 1","zh_hant":"條件一"},"description":null,"tags":null},{"id":".text-song-condition-2","name":{"en":"Condition 2","zh_hant":"條件二"},"description":null,"tags":null},{"id":".text-strategy","name":{"en":"Strategy","zh_hant":"策略"},"description":null,"tags":null},{"id":".text-strategy-type","name":{"en":"Type","zh_hant":"類型"},"description":null,"tags":null},{"id":".text-strategy-value","name":{"en":"Value","zh_hant":"脚本"},"description":null,"tags":null},{"id":".text-cancel-simulation","name":{"en":"Cancel","zh_hant":"取消"},"description":null,"tags":null},{"id":".text-simulate","name":{"en":"Simulate","zh_hant":"模擬"},"description":null,"tags":null},{"id":".text-boss-hp","name":{"en":"Boss HP Override","zh_hant":"自訂敵人血量"},"description":null,"tags":null},{"id":".text-event-multiplier","name":{"en":"Event Multiplier (RP)","zh_hant":"活動乘数 [爬塔RP]"},"description":null,"tags":null},{"id":".text-first-is-guest","name":{"en":"First is guest","zh_hant":"最前方角色為來賓角色"},"description":null,"tags":null},{"id":".text-boss-strategy","name":{"en":"Boss Strategy Override","zh_hant":"自訂敵人策略"},"description":null,"tags":null},{"id":".text-actor-level","name":{"en":"Actor Level"},"description":null,"tags":null},{"id":".text-actor-rarity","name":{"en":"Stars"},"description":null,"tags":null},{"id":".text-actor-remake","name":{"en":"Remake Level"},"description":null,"tags":null},{"id":".text-actor-friendship","name":{"en":"Bond Level"},"description":null,"tags":null},{"id":".text-actor-rank","name":{"en":"Rank"},"description":null,"tags":null},{"id":".text-actor-rank-panel-pattern","name":{"en":"Rank Panel Pattern"},"description":null,"tags":null}],"dresses":[{"id":"Stormy Ace Misora","name":{"en":"Stormy Ace Misora","ko":"폭풍 에이스 미소라","zh_hant":"暴風艾斯美空"},"description":null,"tags":null},{"id":"Rebellious General Catalina Kaoruko","name":{"en":"Rebellious General Catalina Kaoruko","ko":"반역의 장군 카타리나 카오루코","zh_hant":"叛逆的將領 加達莉那香子"},"description":null,"tags":null},{"id":"Death Tamao","name":{"en":"Death Tamao","ko":"사신 타마오","zh_hant":"死神珠緒"},"description":null,"tags":null},{"id":"Devil Kaoruko","name":{"en":"Devil Kaoruko","ko":"악마 카오루코","zh_hant":"惡魔香子"},"description":null,"tags":null},{"id":"Fool Yachiyo","name":{"en":"Fool Yachiyo","ko":"바보 야치요","zh_hant":"愚者八千代"},"description":null,"tags":null},{"id":"Second Lieutenant Fu Mei Fan","name":{"en":"Second Lieutenant Fu Mei Fan","ko":"악마 소위 후우 메이팡","zh_hant":"鬼少尉傅美帆"},"description":null,"tags":null},{"id":"Honda Tadakatsu Futaba","name":{"en":"Honda Tadakatsu Futaba","ko":"혼다 타다카츠 후타바","zh_hant":"本多忠勝雙葉"},"description":null,"tags":null},{"id":"Izanagi Nana","name":{"en":"Izanagi Nana","ko":"이자나기 나나","zh_hant":"伊邪那岐奈奈"},"description":null,"tags":null},{"id":"Judgement Shizuha","name":{"en":"Judgement Shizuha","zh_hant":"審判 靜羽"},"description":null,"tags":null},{"id":"Justice Nana","name":{"en":"Justice Nana","ko":"정의 나나","zh_hant":"正義奈奈"},"description":null,"tags":null},{"id":"Akechi Mitsuhide Karen","name":{"en":"Akechi Mitsuhide Karen","ko":"아케치 미츠히데 카렌","zh_hant":"明智光秀華戀"},"description":null,"tags":null},{"id":"Sanada Yukimura Mahiru","name":{"en":"Sanada Yukimura Mahiru","ko":"사나다 유키무라 마히루","zh_hant":"真田幸村真晝"},"description":null,"tags":null},{"id":"Stage Girl Claudine","name":{"en":"Stage Girl Claudine","ko":"무대소녀 클로딘","zh_hant":"舞台少女克洛迪娜"},"description":null,"tags":null},{"id":"Stage Girl Hikari","name":{"en":"Stage Girl Hikari","ko":"무대소녀 히카리","zh_hant":"舞台少女光"},"description":null,"tags":null},{"id":"Stage Girl Junna","name":{"en":"Stage Girl Junna","ko":"무대소녀 준나","zh_hant":"舞台少女純那"},"description":null,"tags":null},{"id":"Stage Girl Mei Fan","name":{"en":"Stage Girl Mei Fan","ko":"무대소녀 메이팡","zh_hant":"舞台少女美帆"},"description":null,"tags":null},{"id":"Stage Girl Misora","name":{"en":"Stage Girl Misora","ko":"무대소녀 미소라","zh_hant":"舞台少女 美空"},"description":null,"tags":null},{"id":"Stage Girl Nana","name":{"en":"Stage Girl Nana","ko":"무대소녀 나나","zh_hant":"舞台少女奈奈"},"description":null,"tags":null},{"id":"Stage Girl Rui","name":{"en":"Stage Girl Rui","ko":"무대소녀 루이","zh_hant":"舞台少女壘"},"description":null,"tags":null},{"id":"Stage Girl Yachiyo","name":{"en":"Stage Girl Yachiyo","ko":"무대소녀 야치요","zh_hant":"舞台少女八千代"},"description":null,"tags":null},{"id":"Tower Hikari","name":{"en":"Tower Hikari","ko":"탑 히카리","zh_hant":"塔光"},"description":null,"tags":null},{"id":"Wheel of Fortune Karen","name":{"en":"Wheel of Fortune Karen","ko":"운명의 수레바퀴 카렌","zh_hant":"命運之輪華戀"},"description":null,"tags":null},{"id":"World Maya","name":{"en":"World Maya","zh_hant":"世界 真矢"},"description":null,"tags":null}],"memoirs":[{"id":"None","name":{"en":"None","ko":"없음","zh_hant":"無"},"description":{"en":"","ko":"","zh_hant":""},"tags":{"en":[],"ko":[],"zh_hant":[]}},{"id":"(1st Anniv.) Frontier School of Arts","name":{"en":"(1st Anniv.) Frontier School of Arts","ko":"[1주년] 프론티어 예술학교","zh_hant":"[1週年] 芙羅提亞藝術學校"},"description":{"en":"Act","ko":"Act","zh_hant":"攻"},"tags":{"en":["Act","Act Power"],"ko":["Act"],"zh_hant":["攻","攻擊力","act"]}},{"id":"(1st Anniv.) Rinmeikan Girls School","name":{"en":"(1st Anniv.) Rinmeikan Girls School","ko":"[1주년] 린메이칸 여학교","zh_hant":"[1週年] 凜明館女子學校"},"description":{"en":"Act","ko":"Act","zh_hant":"攻"},"tags":{"en":["Act","Act Power"],"ko":["Act"],"zh_hant":["攻","攻擊力","act"]}},{"id":"(1st Anniv.) Seisho Music Academy","name":{"en":"(1st Anniv.) Seisho Music Academy","ko":"[1주년] 세이쇼 음악학교","zh_hant":"[1週年] 聖翔音樂學院"},"description":{"en":"Act","ko":"Act","zh_hant":"攻"},"tags":{"en":["Act","Act Power"],"ko":["Act"],"zh_hant":["攻","攻擊力","act"]}},{"id":"(1st Anniv.) Siegfeld Institute of Music","name":{"en":"(1st Anniv.) Siegfeld Institute of Music","ko":"[1주년] 시크펠트 음악학원","zh_hant":"[1週年] 席格菲特音樂學院"},"description":{"en":"Act","ko":"Act","zh_hant":"攻"},"tags":{"en":["Act","Act Power"],"ko":["Act"],"zh_hant":["攻","攻擊力","act"]}},{"id":"A Day in the Goddesses' Life","name":{"en":"A Day in the Goddesses' Life","ko":"신들의 일상","zh_hant":"眾神的日常"},"description":{"en":"Eff Dmg","ko":"EffectiveDamage","zh_hant":"有利"},"tags":{"en":["Eff Dmg","Effective Damage"],"ko":["EffectiveDamage"],"zh_hant":["有利","有","利","有利傷害","eff"]}},{"id":"Bandsman's Greeting","name":{"en":"Bandsman's Greeting","ko":"밴드맨의 인사","zh_hant":"來自樂團少女的問候"},"description":{"en":"Act","ko":"Act","zh_hant":"攻"},"tags":{"en":["Act","Act Power"],"ko":["Act"],"zh_hant":["攻","攻擊力","act"]}},{"id":"Chinatown Delicacies","name":{"en":"Chinatown Delicacies","ko":"차이나타운의 인연","zh_hant":"中華街的緣分"},"description":{"en":"Brill","ko":"Brilliance","zh_hant":"光芒"},"tags":{"en":["Brill","Kira","Brilliance"],"ko":["Brilliance"],"zh_hant":["光芒","光","kira"]}},{"id":"Co-starring with Hatsune Miku!","name":{"en":"Co-starring with Hatsune Miku!","ko":"하츠네 미쿠와 꿈의 합동 공연!","zh_hant":"與初音未來夢幻的共演！"},"description":{"en":"Brill","ko":"Brilliance","zh_hant":"光芒"},"tags":{"en":["Brill","Kira","Brilliance"],"ko":["Brilliance"],"zh_hant":["光芒","光","kira"]}},{"id":"Confidants on a Date","name":{"en":"Confidants on a Date","ko":"비밀을 나눈 두 사람의 데이트","zh_hant":"共享秘密的兩人約會"},"description":{"en":"Evade","ko":"Evasion","zh_hant":"迴避"},"tags":{"en":["Evade","Evasion"],"ko":["Evasion"],"zh_hant":["迴避","迴","回避","回","evade"]}},{"id":"Crazy Mad Scientist","name":{"en":"Crazy Mad Scientist","ko":"광기의 매드 사이언티스트","zh_hant":"狂氣的瘋狂科學家"},"description":{"en":"Dex, Crit","ko":"Dexterity, Critical","zh_hant":"暴率, 爆傷"},"tags":{"en":["Dex","Dexterity","Crit","Critical"],"ko":["Dexterity","Critical"],"zh_hant":["暴率","暴","會心率","會","dex","爆傷","爆","爆擊傷害","會心威力","威","crit"]}},{"id":"Deux JUNO!? -June Bride-","name":{"en":"Deux JUNO!? -June Bride-","ko":"Deux JUNO?! ~6월의 신부들~","zh_hant":"Deux JUNO!?～6月的新娘們～"},"description":{"en":"Dex, Crit","ko":"Dexterity, Critical","zh_hant":"暴率, 爆傷"},"tags":{"en":["Dex","Dexterity","Crit","Critical"],"ko":["Dexterity","Critical"],"zh_hant":["暴率","暴","會心率","會","dex","爆傷","爆","爆擊傷害","會心威力","威","crit"]}},{"id":"Enjoying Winter","name":{"en":"Enjoying Winter","ko":"겨울의 매력","zh_hant":"冬天的醍醐味"},"description":{"en":"Crit, Perfect Aim","ko":"Critical, PerfectAim","zh_hant":"爆傷, 必中"},"tags":{"en":["Crit","Critical","Perfect Aim"],"ko":["Critical","PerfectAim"],"zh_hant":["爆傷","爆","爆擊傷害","會心威力","威","crit","必中","必","paim"]}},{"id":"Friends at the Aquarium","name":{"en":"Friends at the Aquarium","ko":"정답게 수족관 데이트","zh_hant":"感情融洽的水族館約會"},"description":{"en":"Brill","ko":"Brilliance","zh_hant":"光芒"},"tags":{"en":["Brill","Kira","Brilliance"],"ko":["Brilliance"],"zh_hant":["光芒","光","kira"]}},{"id":"Kappo Tomoye's Poster Girl","name":{"en":"Kappo Tomoye's Poster Girl","ko":"[전통요리 토모에]의 마스코트","zh_hant":"『巴和食』的招牌女店員"},"description":{"en":"Dex, Eff Dmg, Brill","ko":"Dexterity, EffectiveDamage, Brilliance","zh_hant":"暴率, 有利, 光芒"},"tags":{"en":["Dex","Dexterity","Eff Dmg","Effective Damage","Brill","Kira","Brilliance"],"ko":["Dexterity","EffectiveDamage","Brilliance"],"zh_hant":["暴率","暴","會心率","會","dex","有利","有","利","有利傷害","eff","光芒","光","kira"]}},{"id":"Merry Christmas 2019","name":{"en":"Merry Christmas 2019","ko":"메리 크리스마스 2019","zh_hant":"聖誕快樂 2019"},"description":{"en":"Dex, Brill","ko":"Dexterity, Brilliance","zh_hant":"暴率, 光芒"},"tags":{"en":["Dex","Dexterity","Brill","Kira","Brilliance"],"ko":["Dexterity","Brilliance"],"zh_hant":["暴率","暴","會心率","會","dex","光芒","光","kira"]}},{"id":"Poolside Incident","name":{"en":"Poolside Incident","ko":"풀 사이드 해프닝","zh_hant":"泳池邊小劇場"},"description":{"en":"Brill, Perfect Aim","ko":"Brilliance, PerfectAim","zh_hant":"光芒, 必中"},"tags":{"en":["Brill","Kira","Brilliance","Perfect Aim"],"ko":["Brilliance","PerfectAim"],"zh_hant":["光芒","光","kira","必中","必","paim"]}},{"id":"Prince and Princess Etude","name":{"en":"Prince and Princess Etude","ko":"왕자와 공주의 에튀드","zh_hant":"王子與公主的練習曲"},"description":{"en":"Dex, Eff Dmg","ko":"Dexterity, EffectiveDamage","zh_hant":"暴率, 有利"},"tags":{"en":["Dex","Dexterity","Eff Dmg","Effective Damage"],"ko":["Dexterity","EffectiveDamage"],"zh_hant":["暴率","暴","會心率","會","dex","有利","有","利","有利傷害","eff"]}},{"id":"Reminiscence Melody","name":{"en":"Reminiscence Melody","ko":"추억의 멜로디","zh_hant":"追憶的旋律"},"description":{"en":"Crit, Eff Dmg, Brill","ko":"Critical, EffectiveDamage, Brilliance","zh_hant":"爆傷, 有利, 光芒"},"tags":{"en":["Crit","Critical","Eff Dmg","Effective Damage","Brill","Kira","Brilliance"],"ko":["Critical","EffectiveDamage","Brilliance"],"zh_hant":["爆傷","爆","爆擊傷害","會心威力","威","crit","有利","有","利","有利傷害","eff","光芒","光","kira"]}},{"id":"Reverberating Voice Tsubasa & Maya","name":{"en":"Reverberating Voice Tsubasa & Maya","ko":"무대에 울려퍼지는 노랫소리 츠바사 & 마야","zh_hant":"響震舞台的歌聲 翼＆真矢"},"description":{"en":"Dex, Perfect Aim","ko":"Dexterity, PerfectAim","zh_hant":"暴率, 必中"},"tags":{"en":["Dex","Dexterity","Perfect Aim"],"ko":["Dexterity","PerfectAim"],"zh_hant":["暴率","暴","會心率","會","dex","必中","必","paim"]}},{"id":"Sparkling Stage Chika","name":{"en":"Sparkling Stage Chika","ko":"반짝이는 스테이지 치카","zh_hant":"光芒耀眼的舞台 千歌"},"description":{"en":"Norm Barrier, Spec Barrier","ko":"NormalBarrier, SpecialBarrier","zh_hant":"普通盾, 特殊盾"},"tags":{"en":["Norm Barrier","Normal Barrier","Spec Barrier","Special Barrier"],"ko":["NormalBarrier","SpecialBarrier"],"zh_hant":["普通盾","普盾","nb","特殊盾","特盾","sb"]}},{"id":"Stretching Help...?","name":{"en":"Stretching Help...?","ko":"스트레칭 도우미... 아니면?","zh_hant":"伸展運動的助手……還是？"},"description":{"en":"Eff Dmg, Perfect Aim","ko":"EffectiveDamage, PerfectAim","zh_hant":"有利, 必中"},"tags":{"en":["Eff Dmg","Effective Damage","Perfect Aim"],"ko":["EffectiveDamage","PerfectAim"],"zh_hant":["有利","有","利","有利傷害","eff","必中","必","paim"]}},{"id":"Sunset Lab Mem Badge","name":{"en":"Sunset Lab Mem Badge","ko":"석양빛에 물든 라보멤 배지","zh_hant":"染上夕陽的Labo-Men徽章"},"description":{"en":"Brill","ko":"Brilliance","zh_hant":"光芒"},"tags":{"en":["Brill","Kira","Brilliance"],"ko":["Brilliance"],"zh_hant":["光芒","光","kira"]}},{"id":"The Great Year-End Cleanup","name":{"en":"The Great Year-End Cleanup","ko":"폭주!? 경쟁!? 대청소","zh_hant":"失控！？競爭！？大掃除"},"description":{"en":"Norm Barrier, Evade","ko":"NormalBarrier, Evasion","zh_hant":"普通盾, 迴避"},"tags":{"en":["Norm Barrier","Normal Barrier","Evade","Evasion"],"ko":["NormalBarrier","Evasion"],"zh_hant":["普通盾","普盾","nb","迴避","迴","回避","回","evade"]}},{"id":"The Phantom and Christine","name":{"en":"The Phantom and Christine","ko":"팬텀과 크리스틴","zh_hant":"魅影和克莉絲汀"},"description":{"en":"Dmg, Crit","ko":"Damage, Critical","zh_hant":"傷害提升, 爆傷"},"tags":{"en":["Dmg","Damage","Damage Dealt","Crit","Critical"],"ko":["Damage","Critical"],"zh_hant":["傷害提升","傷","傷害","增傷","dmg","爆傷","爆","爆擊傷害","會心威力","威","crit"]}},{"id":"To the Wonderful World of Rakugo","name":{"en":"To the Wonderful World of Rakugo","ko":"근사한 라쿠고의 세계로","zh_hant":"邁向美好的落語世界"},"description":{"en":"Dex, Crit","ko":"Dexterity, Critical","zh_hant":"暴率, 爆傷"},"tags":{"en":["Dex","Dexterity","Crit","Critical"],"ko":["Dexterity","Critical"],"zh_hant":["暴率","暴","會心率","會","dex","爆傷","爆","爆擊傷害","會心威力","威","crit"]}},{"id":"Turbulent Ninja","name":{"en":"Turbulent Ninja","ko":"난세의 닌자","zh_hant":"亂世之忍"},"description":{"en":"Eff Dmg, CX Dmg","ko":"EffectiveDamage, ClimaxDamage","zh_hant":"有利, CA傷害提升"},"tags":{"en":["Eff Dmg","Effective Damage","CX Dmg","Climax Damage","Climax Act Damage"],"ko":["EffectiveDamage","ClimaxDamage"],"zh_hant":["有利","有","利","有利傷害","eff","CA傷害提升","CA","CA傷","CA傷害","CA增傷","cadmg"]}},{"id":"Unburned Flower, Unwithered Flame","name":{"en":"Unburned Flower, Unwithered Flame","ko":"불타지 않는 꽃, 사그라들지 않는 불꽃","zh_hant":"不會燃去的花與不會枯萎的火"},"description":{"en":"Brill, Cutin","ko":"Brilliance, Cutin","zh_hant":"光芒, 切入回憶"},"tags":{"en":["Brill","Kira","Brilliance","Cutin","Cutin Skill"],"ko":["Brilliance","Cutin"],"zh_hant":["光芒","光","kira","切入回憶","切","切入","cutin"]}},{"id":"Unshakable Feelings","name":{"en":"Unshakable Feelings","ko":"양보할 수 없는 마음","zh_hant":"絕不退讓的想法"},"description":{"en":"Brill, Cutin","ko":"Brilliance, Cutin","zh_hant":"光芒, 切入回憶"},"tags":{"en":["Brill","Kira","Brilliance","Cutin","Cutin Skill"],"ko":["Brilliance","Cutin"],"zh_hant":["光芒","光","kira","切入回憶","切","切入","cutin"]}},{"id":"Urashima Taro Performance Flyer","name":{"en":"Urashima Taro Performance Flyer","ko":"[우라시마 타로] 공연 안내","zh_hant":"「浦島太郎」公演通告"},"description":{"en":"Dmg, Dex","ko":"Damage, Dexterity","zh_hant":"傷害提升, 暴率"},"tags":{"en":["Dmg","Damage","Damage Dealt","Dex","Dexterity"],"ko":["Damage","Dexterity"],"zh_hant":["傷害提升","傷","傷害","增傷","dmg","暴率","暴","會心率","會","dex"]}},{"id":"VI Lovers [Reverse]","name":{"en":"VI Lovers [Reverse]","ko":"VI 연인[역위치]","zh_hant":"VI 戀人【逆位】"},"description":{"en":"Dex, Cutin","ko":"Dexterity, Cutin","zh_hant":"暴率, 切入回憶"},"tags":{"en":["Dex","Dexterity","Cutin","Cutin Skill"],"ko":["Dexterity","Cutin"],"zh_hant":["暴率","暴","會心率","會","dex","切入回憶","切","切入","cutin"]}},{"id":"XII Hanged Man [Reverse]","name":{"en":"XII Hanged Man [Reverse]","ko":"XII 매달린 사람[역위치]","zh_hant":"XII 倒吊人【逆位】"},"description":{"en":"Eff Dmg, Cutin","ko":"EffectiveDamage, Cutin","zh_hant":"有利, 切入回憶"},"tags":{"en":["Eff Dmg","Effective Damage","Cutin","Cutin Skill"],"ko":["EffectiveDamage","Cutin"],"zh_hant":["有利","有","利","有利傷害","eff","切入回憶","切","切入","cutin"]}},{"id":"XVI Tower [Upright]","name":{"en":"XVI Tower [Upright]","ko":"XVI 탑[정위치]","zh_hant":"XVI 塔【正位】"},"description":{"en":"Brill, Cutin","ko":"Brilliance, Cutin","zh_hant":"光芒, 切入回憶"},"tags":{"en":["Brill","Kira","Brilliance","Cutin","Cutin Skill"],"ko":["Brilliance","Cutin"],"zh_hant":["光芒","光","kira","切入回憶","切","切入","cutin"]}}],"songEffects":[{"id":"Act Power Up","name":{"en":"Act Power Up","zh_hant":"提升ACT力量"},"description":null,"tags":null},{"id":"Dexterity Up","name":{"en":"Dexterity Up","zh_hant":"提升爆擊率"},"description":null,"tags":null},{"id":"Critical Up","name":{"en":"Critical Up","zh_hant":"提升爆擊傷害"},"description":null,"tags":null},{"id":"Flower Damage Dealt Up","name":{"en":"Flower Damage Dealt Up","zh_hant":"提升花屬性傷害"},"description":null,"tags":null},{"id":"Wind Damage Dealt Up","name":{"en":"Wind Damage Dealt Up","zh_hant":"提升風屬性傷害"},"description":null,"tags":null},{"id":"Snow Damage Dealt Up","name":{"en":"Snow Damage Dealt Up","zh_hant":"提升雪屬性傷害"},"description":null,"tags":null},{"id":"Moon Damage Dealt Up","name":{"en":"Moon Damage Dealt Up","zh_hant":"提升月屬性傷害"},"description":null,"tags":null},{"id":"Space Damage Dealt Up","name":{"en":"Space Damage Dealt Up","zh_hant":"提升宙屬性傷害"},"description":null,"tags":null},{"id":"Cloud Damage Dealt Up","name":{"en":"Cloud Damage Dealt Up","zh_hant":"提升雲屬性傷害"},"description":null,"tags":null},{"id":"Dream Damage Dealt Up","name":{"en":"Dream Damage Dealt Up","zh_hant":"提升夢屬性傷害"},"description":null,"tags":null},{"id":"Against Flower Damage Dealt Up","name":{"en":"Against Flower Damage Dealt Up","zh_hant":"提升對花屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Wind Damage Dealt Up","name":{"en":"Against Wind Damage Dealt Up","zh_hant":"提升對風屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Snow Damage Dealt Up","name":{"en":"Against Snow Damage Dealt Up","zh_hant":"提升對雪屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Moon Damage Dealt Up","name":{"en":"Against Moon Damage Dealt Up","zh_hant":"提升對月屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Space Damage Dealt Up","name":{"en":"Against Space Damage Dealt Up","zh_hant":"提升對宙屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Cloud Damage Dealt Up","name":{"en":"Against Cloud Damage Dealt Up","zh_hant":"提升對雲屬性造成的傷害"},"description":null,"tags":null},{"id":"Against Dream Damage Dealt Up","name":{"en":"Against Dream Damage Dealt Up","zh_hant":"提升對夢屬性造成的傷害"},"description":null,"tags":null}],"conditions":[{"id":"Flower","name":{"en":"Flower","zh_hant":"花屬"},"description":null,"tags":null},{"id":"Wind","name":{"en":"Wind","zh_hant":"風屬"},"description":null,"tags":null},{"id":"Snow","name":{"en":"Snow","zh_hant":"雪屬"},"description":null,"tags":null},{"id":"Moon","name":{"en":"Moon","zh_hant":"月屬"},"description":null,"tags":null},{"id":"Space","name":{"en":"Space","zh_hant":"宙屬"},"description":null,"tags":null},{"id":"Cloud","name":{"en":"Cloud","zh_hant":"雲屬"},"description":null,"tags":null},{"id":"Dream","name":{"en":"Dream","zh_hant":"夢屬"},"description":null,"tags":null},{"id":"Normal Damage","name":{"en":"Normal Damage","zh_hant":"ACT類型[普通]"},"description":null,"tags":null},{"id":"Special Damage","name":{"en":"Special Damage","zh_hant":"ACT類型[特殊]"},"description":null,"tags":null},{"id":"Front","name":{"en":"Front","zh_hant":"前排"},"description":null,"tags":null},{"id":"Middle","name":{"en":"Middle","zh_hant":"中排"},"description":null,"tags":null},{"id":"Back","name":{"en":"Back","zh_hant":"後排"},"description":null,"tags":null},{"id":"Seisho","name":{"en":"Seisho","zh_hant":"聖翔音樂學院"},"description":null,"tags":null},{"id":"Rinmeikan","name":{"en":"Rinmeikan","zh_hant":"凜明館女子學校"},"description":null,"tags":null},{"id":"Frontier","name":{"en":"Frontier","zh_hant":"芙羅提亞藝術學校"},"description":null,"tags":null},{"id":"Siegfeld","name":{"en":"Siegfeld","zh_hant":"席格菲特音樂學院"},"description":null,"tags":null},{"id":"Seiran","name":{"en":"Seiran","zh_hant":"青嵐總合藝術學院"},"description":null,"tags":null},{"id":"Karen","name":{"en":"Karen","ko":"카렌","zh_hant":"華戀"},"description":null,"tags":null},{"id":"Hikari","name":{"en":"Hikari","ko":"히카리","zh_hant":"光"},"description":null,"tags":null},{"id":"Mahiru","name":{"en":"Mahiru","ko":"마히루","zh_hant":"真晝"},"description":null,"tags":null},{"id":"Claudine","name":{"en":"Claudine","ko":"클로딘","zh_hant":"克洛迪娜"},"description":null,"tags":null},{"id":"Maya","name":{"en":"Maya","ko":"마야","zh_hant":"真矢"},"description":null,"tags":null},{"id":"Junna","name":{"en":"Junna","ko":"준나","zh_hant":"純那"},"description":null,"tags":null},{"id":"Nana","name":{"en":"Nana","ko":"나나","zh_hant":"奈奈"},"description":null,"tags":null},{"id":"Futaba","name":{"en":"Futaba","ko":"후타바","zh_hant":"雙葉"},"description":null,"tags":null},{"id":"Kaoruko","name":{"en":"Kaoruko","ko":"카오루코","zh_hant":"香子"},"description":null,"tags":null},{"id":"Tamao","name":{"en":"Tamao","ko":"타마오","zh_hant":"珠緒"},"description":null,"tags":null},{"id":"Ichie","name":{"en":"Ichie","ko":"이치에","zh_hant":"一愛"},"description":null,"tags":null},{"id":"Fumi","name":{"en":"Fumi","ko":"후미","zh_hant":"文"},"description":null,"tags":null},{"id":"Rui","name":{"en":"Rui","ko":"루이","zh_hant":"壘"},"description":null,"tags":null},{"id":"Yuyuko","name":{"en":"Yuyuko","ko":"유유코","zh_hant":"悠悠子"},"description":null,"tags":null},{"id":"Aruru","name":{"en":"Aruru","ko":"아루루","zh_hant":"艾露露"},"description":null,"tags":null},{"id":"Misora","name":{"en":"Misora","ko":"미소라","zh_hant":"美空"},"description":null,"tags":null},{"id":"Lalafin","name":{"en":"Lalafin","ko":"라라핀","zh_hant":"菈樂菲"},"description":null,"tags":null},{"id":"Tsukasa","name":{"en":"Tsukasa","ko":"츠카사","zh_hant":"司"},"description":null,"tags":null},{"id":"Shizuha","name":{"en":"Shizuha","ko":"시즈하","zh_hant":"靜羽"},"description":null,"tags":null},{"id":"Akira","name":{"en":"Akira","ko":"아키라","zh_hant":"晶"},"description":null,"tags":null},{"id":"Michiru","name":{"en":"Michiru","ko":"미치루","zh_hant":"未知留"},"description":null,"tags":null},{"id":"Mei Fan","name":{"en":"Mei Fan","ko":"메이팡","zh_hant":"美帆"},"description":null,"tags":null},{"id":"Shiori","name":{"en":"Shiori","ko":"시오리","zh_hant":"栞"},"description":null,"tags":null},{"id":"Yachiyo","name":{"en":"Yachiyo","ko":"야치요","zh_hant":"八千代"},"description":null,"tags":null},{"id":"Koharu","name":{"en":"Koharu","ko":"코하루","zh_hant":"小春"},"description":null,"tags":null},{"id":"Suzu","name":{"en":"Suzu","ko":"스즈","zh_hant":"涼"},"description":null,"tags":null},{"id":"Hisame","name":{"en":"Hisame","ko":"히사메","zh_hant":"冰雨"},"description":null,"tags":null}],"bosses":[{"id":"TR9 Faith Misora","name":{"en":"TR9 Faith Misora","zh_hant":"TR9 信仰 美空"},"description":null,"tags":null},{"id":"TR10 Dracula Claudine","name":{"en":"TR10 Dracula Claudine","zh_hant":"TR10 德古拉 克洛迪娜"},"description":null,"tags":null},{"id":"TR10 Vampire Shiori","name":{"en":"TR10 Vampire Shiori","zh_hant":"TR10 吸血鬼 栞"},"description":null,"tags":null},{"id":"TR10 Hellsing Michiru","name":{"en":"TR10 Hellsing Michiru","zh_hant":"TR10 赫辛 未知留"},"description":null,"tags":null},{"id":"TR10 Faith Misora","name":{"en":"TR10 Faith Misora","zh_hant":"TR10 信仰 美空"},"description":null,"tags":null},{"id":"TR11 Cheer Akira","name":{"en":"TR11 Cheer Akira","zh_hant":"TR11 啦啦隊 晶"},"description":null,"tags":null},{"id":"TR11 Cheer Tsukasa","name":{"en":"TR11 Cheer Tsukasa","zh_hant":"TR11 啦啦隊 司"},"description":null,"tags":null},{"id":"TR11 Cheer Yachiyo","name":{"en":"TR11 Cheer Yachiyo","zh_hant":"TR11 啦啦隊 八千代"},"description":null,"tags":null},{"id":"TR11 Faith Misora","name":{"en":"TR11 Faith Misora","zh_hant":"TR11 信仰 美空"},"description":null,"tags":null},{"id":"TR12 Boss 2","name":{},"description":null,"tags":null},{"id":"TR12 Boss 2 Seisho","name":{},"description":null,"tags":null},{"id":"TR12 Tower Hikari","name":{},"description":null,"tags":null}],"strategyTypes":[{"id":"Simple","name":{"en":"Simple"},"description":null,"tags":null},{"id":"Complete","name":{"en":"Complete"},"description":null,"tags":null}],"bossStrategyTypes":[{"id":"Simple","name":{"en":"Simple"},"description":null,"tags":null}]}""")
    }

    override suspend fun shutdown() {
        error("Not supported")
    }

    override suspend fun features(): SimulatorFeatures {
        return SimulatorFeatures(false)
    }
}

const val BATCH_SIZE = 1000

class JsSimulation(val parameters: SimulationParameters) : Simulation {
    var resultCount = 0
    val resultCounts = mutableMapOf<Pair<List<String>, SimulationResultType>, Int>()
    val marginResults = mutableMapOf<SimulationMarginResultType, MutableMap<Int, Int>>()
    val seedProducer = Random(parameters.seed)
    var requestCount = 0
    val startTime = window.performance.now()
    var firstApplicableIteration: IterationResult? = null

    var overallResult = SimulationResult(
        maxIterations = parameters.maxIterations,
        currentIterations = 0,
        results = emptyList(),
        marginResults = emptyMap(),
        log = null,
    )

    @OptIn(ExperimentalSerializationApi::class)
    val workers = List(
        window.navigator.hardwareConcurrency.toInt().coerceAtMost(parameters.maxIterations / BATCH_SIZE).coerceAtLeast(1)
    ) {
        Worker("relive-simulator-worker.js").also { worker ->
            worker.onmessage = { ev ->
                val results = Json.decodeFromString<List<IterationResult>>(ev.data as String)
                if (resultCount == parameters.maxIterations) {
                    // This means that this is the final run, for use with logging.
                    // This block should only be run once per simulation.
                    val result = results.single()
                    overallResult = overallResult.copy(
                        error = result.error,
                        log = result.log,
                        runtime = (window.performance.now() - startTime) / 1_000.0,
                        complete = true,
                    )
                } else {
                    results.forEach { result ->
                        if (firstApplicableIteration == null ||
                            firstApplicableIteration!!.resultPriority < result.resultPriority ||
                            (firstApplicableIteration!!.resultPriority == result.resultPriority &&
                                    result.request.index < firstApplicableIteration!!.request.index)
                        ) {
                            firstApplicableIteration = result
                        }
                        when (result.result) {
                            SimulationResultType.End -> SimulationMarginResultType.End
                            is SimulationResultType.Wipe -> SimulationMarginResultType.Wipe
                            else -> null
                        }?.let { marginType ->
                            val roundedMargin = (result.margin!! + 10000 - 1) / 10000 * 10000
                            val typeResults = marginResults.getOrPut(marginType) { mutableMapOf() }
                            typeResults[roundedMargin] = (typeResults[roundedMargin] ?: 0) + 1
                        }
                        resultCount++
                        resultCounts[result.tags to result.result] =
                            (resultCounts[result.tags to result.result] ?: 0) + 1
                    }
                    overallResult = SimulationResult(
                        maxIterations = parameters.maxIterations,
                        currentIterations = resultCount,
                        results = resultCounts.map { (k, v) -> SimulationResultValue(k.first, k.second, v) },
                        marginResults = marginResults.mapValues { (_, v) -> v.toMap() },
                        log = null,
                        runtime = (window.performance.now() - startTime) / 1_000.0,
                    )
                    val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(BATCH_SIZE)
                    if (batchSize > 0) {
                        worker.postMessage(Json.encodeToString(List(batchSize) {
                            IterationRequest(
                                requestCount++,
                                seedProducer.nextInt(),
                            )
                        }))
                    }
                    if (resultCount == parameters.maxIterations) {
                        worker.postMessage(Json.encodeToString(listOf(
                            firstApplicableIteration!!.request.copy(log = true)
                        )))
                    }
                }
            }
            worker.postMessage(Json.encodeToString(parameters))
            val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(BATCH_SIZE)
            if (batchSize > 0) {
                worker.postMessage(Json.encodeToString(List(batchSize) {
                    IterationRequest(
                        requestCount++,
                        seedProducer.nextInt(),
                    )
                }))
            }
        }
    }

    override suspend fun pollResult() = overallResult
    override suspend fun cancel() {
        workers.forEach { it.terminate() }
        overallResult = overallResult.copy(cancelled = true)
    }
}

@Serializable
data class IterationRequest(
    val index: Int,
    val seed: Int,
    val log: Boolean = false,
)

@Serializable
data class IterationResult(
    val request: IterationRequest,
    val result: SimulationResultType,
    val tags: List<String> = emptyList(),
    val margin: Int? = 0,
    val log: String? = null,
    val error: String? = null,
)

private val IterationResult.resultPriority
    get() = when (this.result) {
        is SimulationResultType.Excluded -> 0
        is SimulationResultType.Victory -> 1
        is SimulationResultType.End -> 2
        is SimulationResultType.Wipe -> 3
        is SimulationResultType.Error -> 4
    }
