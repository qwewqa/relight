package xyz.qwewqa.relive.simulator.core

val commonText =
    mapOf(
        "none" to
            mapOf(
                "en" to "None",
                "zh_hant" to "無",
            ),
        "n/a" to
            mapOf(
                "en" to "N/A",
                "zh_hant" to "N/A",
            ),
        ".text-shutdown" to
            mapOf(
                "en" to "Shutdown",
                "zh_hant" to "關閉",
            ),
        ".text-import" to
            mapOf(
                "en" to "Import",
                "zh_hant" to "輸入",
            ),
        ".text-export" to
            mapOf(
                "en" to "Export",
                "zh_hant" to "輸出",
            ),
        ".text-close-dialog" to
            mapOf(
                "en" to "Close",
                "zh_hant" to "關閉",
            ),
        ".text-clear" to
            mapOf(
                "en" to "Clear",
                "zh_hant" to "清除",
            ),
        ".text-use-yaml" to
            mapOf(
                "en" to "YAML",
                "zh_hant" to "YAML",
            ),
        ".text-stage-configuration" to
            mapOf(
                "en" to "Stage Configuration",
                "zh_hant" to "配置",
            ),
        ".text-iterations" to
            mapOf(
                "en" to "Iterations",
                "zh_hant" to "測試回數",
            ),
        ".text-max-turns" to
            mapOf(
                "en" to "Max Turns",
                "zh_hant" to "最多回合",
            ),
        ".text-seed" to
            mapOf(
                "en" to "Seed",
                "zh_hant" to "隨機種子",
            ),
        ".text-boss" to
            mapOf(
                "en" to "Boss",
                "zh_hant" to "王",
            ),
        ".text-event-bonus" to
            mapOf(
                "en" to "Extra Event Bonus",
                "zh_hant" to "額外活動傷害加乘 [爬塔箱子]",
            ),
        ".text-actors" to
            mapOf(
                "en" to "Actors",
                "zh_hant" to "角色",
            ),
        ".text-actor-name" to
            mapOf(
                "en" to "Name",
                "zh_hant" to "(自訂)名稱",
            ),
        ".text-dress" to
            mapOf(
                "en" to "Dress",
                "zh_hant" to "角色",
            ),
        ".text-unit-skill-level" to
            mapOf(
                "en" to "US",
                "zh_hant" to "US等級",
            ),
        ".text-memoir" to
            mapOf(
                "en" to "Memoir",
                "zh_hant" to "回憶",
            ),
        ".text-memoir-level" to
            mapOf(
                "en" to "Level",
                "zh_hant" to "回憶等級",
            ),
        ".text-memoir-unbind" to
            mapOf(
                "en" to "Unbind",
                "zh_hant" to "回憶突破次數",
            ),
        ".text-add-actor" to
            mapOf(
                "en" to "Add",
                "zh_hant" to "添加角色",
            ),
        ".text-remove-actor" to
            mapOf(
                "en" to "Remove Actor",
                "zh_hant" to "移除角色",
            ),
        ".text-song" to
            mapOf(
                "en" to "Song",
                "zh_hant" to "歌曲",
            ),
        ".text-songs" to
            mapOf(
                "en" to "Songs",
                "zh_hant" to "歌曲",
            ),
        ".text-effect" to
            mapOf(
                "en" to "Effect",
                "zh_hant" to "效果",
            ),
        ".text-passive-effect" to
            mapOf(
                "en" to "Passive Effect",
                "zh_hant" to "永續效果",
            ),
        ".text-awakening-effect" to
            mapOf(
                "en" to "Awakening Effect",
                "zh_hant" to "覺醒效果",
            ),
        ".text-awakened-songs" to
            mapOf(
                "en" to "Awakened Songs",
                "zh_hant" to "覺醒歌曲",
            ),
        ".text-song-effect-1" to
            mapOf(
                "en" to "Effect 1",
                "zh_hant" to "效果一",
            ),
        ".text-song-effect-2" to
            mapOf(
                "en" to "Effect 2",
                "zh_hant" to "效果二",
            ),
        ".text-song-effect-3" to
            mapOf(
                "en" to "Effect 3 (Passive)",
                "zh_hant" to "效果三 (永續)",
            ),
        ".text-song-effect-type" to
            mapOf(
                "en" to "Type",
                "zh_hant" to "類型",
            ),
        ".text-song-effect-value" to
            mapOf(
                "en" to "Value",
                "zh_hant" to "數值",
            ),
        ".text-song-condition-1" to
            mapOf(
                "en" to "Condition 1",
                "zh_hant" to "條件一",
            ),
        ".text-song-condition-2" to
            mapOf(
                "en" to "Condition 2",
                "zh_hant" to "條件二",
            ),
        ".text-strategy" to
            mapOf(
                "en" to "Strategy",
                "zh_hant" to "策略",
            ),
        ".text-strategy-type" to
            mapOf(
                "en" to "Type",
                "zh_hant" to "類型",
            ),
        ".text-strategy-value" to
            mapOf(
                "en" to "Value",
                "zh_hant" to "脚本",
            ),
        ".text-cancel-simulation" to
            mapOf(
                "en" to "Cancel",
                "zh_hant" to "取消",
            ),
        ".text-simulate" to
            mapOf(
                "en" to "Simulate",
                "zh_hant" to "模擬",
            ),
        ".text-boss-hp" to
            mapOf(
                "en" to "HP Override",
                "zh_hant" to "自訂敵人血量",
            ),
        ".text-boss-attribute" to
            mapOf(
                "en" to "Attribute Override",
                "zh_hant" to "自訂敵人屬性",
            ),
        ".text-event-multiplier" to
            mapOf(
                "en" to "Damage Multiplier",
                "zh_hant" to "傷害倍率",
            ),
        ".text-first-is-guest" to
            mapOf(
                "en" to "First is guest",
                "zh_hant" to "最前方角色為來賓角色",
            ),
        ".text-boss-strategy" to
            mapOf(
                "en" to "Boss Strategy Override",
                "zh_hant" to "自訂敵人策略",
            ),
        ".text-actor-level" to
            mapOf(
                "en" to "Level",
                "zh_hant" to "角色等級",
            ),
        ".text-actor-rarity" to
            mapOf(
                "en" to "Stars",
                "zh_hant" to "星數",
            ),
        ".text-actor-remake" to
            mapOf(
                "en" to "Rebirth",
                "zh_hant" to "再生產等級",
            ),
        ".text-actor-friendship" to
            mapOf(
                "en" to "Bond",
                "zh_hant" to "羈絆等級",
            ),
        ".text-actor-rank" to
            mapOf(
                "en" to "Rank",
                "zh_hant" to "技能拼圖",
            ),
        ".text-actor-rank-panel-pattern" to
            mapOf(
                "en" to "Panel Pattern",
                "zh_hant" to "技能拼圖點法",
            ),
        "all-rank-panels" to
            mapOf(
                "en" to "All",
                "zh_hant" to "全滿",
            ),
        "left-7-rank-panels" to
            mapOf(
                "en" to "Left 7",
                "zh_hant" to "左路7格",
            ),
        "upper-5-rank-panels" to
            mapOf(
                "en" to "Upper 5",
                "zh_hant" to "上路5格",
            ),
        "lower-5-rank-panels" to
            mapOf(
                "en" to "Lower 5",
                "zh_hant" to "下路5格",
            ),
        "upper-3-rank-panels" to
            mapOf(
                "en" to "Upper 3",
                "zh_hant" to "上路3格",
            ),
        "lower-3-rank-panels" to
            mapOf(
                "en" to "Lower 3",
                "zh_hant" to "下路3格",
            ),
        "none-rank-panels" to
            mapOf(
                "en" to "None",
                "zh_hant" to "空盤",
            ),
        ".text-actor-details" to
            mapOf(
                "en" to "Details",
                "zh_hant" to "設置",
            ),
        ".text-donate" to
            mapOf(
                "en" to "Donate",
                "zh_hant" to "贊助",
            ),
        ".text-preset" to
            mapOf(
                "en" to "Preset",
                "zh_hant" to "預設",
            ),
        ".text-load-preset" to
            mapOf(
                "en" to "Load Preset",
                "zh_hant" to "載入預設",
            ),
        ".text-save-preset" to
            mapOf(
                "en" to "Save Preset",
                "zh_hant" to "儲存預設",
            ),
        ".text-load-preset-short" to
            mapOf(
                "en" to "Load",
                "zh_hant" to "載入",
            ),
        ".text-save" to
            mapOf(
                "en" to "Save",
                "zh_hant" to "儲存",
            ),
        ".text-load" to
            mapOf(
                "en" to "Load",
                "zh_hant" to "載入",
            ),
        ".text-manage" to
            mapOf(
                "en" to "Manage",
                "zh_hant" to "管理",
            ),
        ".text-share" to
            mapOf(
                "en" to "Share",
                "zh_hant" to "分享",
            ),
        ".text-save-preset-short" to
            mapOf(
                "en" to "Save",
                "zh_hant" to "儲存",
            ),
        ".text-delete-preset" to
            mapOf(
                "en" to "Delete Preset",
                "zh_hant" to "刪除預設",
            ),
        ".text-confirm" to
            mapOf(
                "en" to "Confirm",
                "zh_hant" to "確認",
            ),
        ".text-cancel" to
            mapOf(
                "en" to "Cancel",
                "zh_hant" to "取消",
            ),
        ".text-delete" to
            mapOf(
                "en" to "Delete",
                "zh_hant" to "刪除",
            ),
        ".text-sort-by-position" to
            mapOf(
                "en" to "Sort",
                "zh_hant" to "按位置排序",
            ),
        ".text-remake-skill" to
            mapOf(
                "en" to "Rebirth Skill",
            ),
        ".text-presets" to
            mapOf(
                "en" to "Presets",
                "zh_hant" to "預設",
            ),
        ".text-setups" to
            mapOf(
                "en" to "Setups",
                "zh_hant" to "設置",
            ),
        ".text-select-presets" to
            mapOf(
                "en" to "Select Presets",
                "zh_hant" to "選擇預設",
            ),
        ".text-select-setups" to
            mapOf(
                "en" to "Select Setups",
                "zh_hant" to "選擇設定",
            ),
        ".text-new-preset" to
            mapOf(
                "en" to "New Preset",
                "zh_hant" to "新預設",
            ),
        ".text-save-new" to
            mapOf(
                "en" to "Save New",
                "zh_hant" to "儲存新預設",
            ),
        ".text-search" to
            mapOf(
                "en" to "Search",
                "zh_hant" to "搜尋",
            ),
        ".text-new" to
            mapOf(
                "en" to "New",
                "zh_hant" to "新增",
            ),
        ".text-add-actor-from-preset" to
            mapOf(
                "en" to "Presets",
                "zh_hant" to "從預設添加",
            ),
        ".text-share-presets" to
            mapOf(
                "en" to "Share Presets",
                "zh_hant" to "分享預設",
            ),
        ".text-options" to
            mapOf(
                "en" to "Options",
                "zh_hant" to "選項",
            ),
        ".text-all" to
            mapOf(
                "en" to "All",
                "zh_hant" to "全部",
            ),
        ".text-import-presets" to
            mapOf(
                "en" to "Import Presets",
                "zh_hant" to "匯入預設",
            ),
        ".text-auto-name" to
            mapOf(
                "en" to "Auto Name",
                "zh_hant" to "自動命名",
            ),
        ".text-log-in" to
            mapOf(
                "en" to "Log In",
                "zh_hant" to "登入",
            ),
        ".text-log-out" to
            mapOf(
                "en" to "Log Out",
                "zh_hant" to "登出",
            ),
        ".text-cloud-sync" to
            mapOf(
                "en" to "Cloud Sync",
                "zh_hant" to "雲端同步",
            ),
        ".text-account" to
            mapOf(
                "en" to "Account",
            ),
        "attribute-neutral" to
            mapOf(
                "en" to "Neutral",
            ),
        "attribute-flower" to
            mapOf(
                "en" to "Flower",
            ),
        "attribute-wind" to
            mapOf(
                "en" to "Wind",
            ),
        "attribute-snow" to
            mapOf(
                "en" to "Snow",
            ),
        "attribute-moon" to
            mapOf(
                "en" to "Moon",
            ),
        "attribute-space" to
            mapOf(
                "en" to "Space",
            ),
        "attribute-cloud" to
            mapOf(
                "en" to "Cloud",
            ),
        "attribute-dream" to
            mapOf(
                "en" to "Dream",
            ),
        "damage-type-normal" to
            mapOf(
                "en" to "Normal",
            ),
        "damage-type-special" to
            mapOf(
                "en" to "Special",
            ),
        "position-back" to
            mapOf(
                "en" to "Back",
            ),
        "position-middle" to
            mapOf(
                "en" to "Middle",
            ),
        "position-front" to
            mapOf(
                "en" to "Front",
            ),
        "character-karen" to
            mapOf(
                "en" to "Karen",
            ),
        "character-hikari" to
            mapOf(
                "en" to "Hikari",
            ),
        "character-mahiru" to
            mapOf(
                "en" to "Mahiru",
            ),
        "character-claudine" to
            mapOf(
                "en" to "Claudine",
            ),
        "character-maya" to
            mapOf(
                "en" to "Maya",
            ),
        "character-junna" to
            mapOf(
                "en" to "Junna",
            ),
        "character-nana" to
            mapOf(
                "en" to "Nana",
            ),
        "character-futaba" to
            mapOf(
                "en" to "Futaba",
            ),
        "character-kaoruko" to
            mapOf(
                "en" to "Kaoruko",
            ),
        "character-tamao" to
            mapOf(
                "en" to "Tamao",
            ),
        "character-ichie" to
            mapOf(
                "en" to "Ichie",
            ),
        "character-fumi" to
            mapOf(
                "en" to "Fumi",
            ),
        "character-rui" to
            mapOf(
                "en" to "Rui",
            ),
        "character-yuyuko" to
            mapOf(
                "en" to "Yuyuko",
            ),
        "character-aruru" to
            mapOf(
                "en" to "Aruru",
            ),
        "character-misora" to
            mapOf(
                "en" to "Misora",
            ),
        "character-lalafin" to
            mapOf(
                "en" to "Lalafin",
            ),
        "character-tsukasa" to
            mapOf(
                "en" to "Tsukasa",
            ),
        "character-shizuha" to
            mapOf(
                "en" to "Shizuha",
            ),
        "character-akira" to
            mapOf(
                "en" to "Akira",
            ),
        "character-michiru" to
            mapOf(
                "en" to "Michiru",
            ),
        "character-meifan" to
            mapOf(
                "en" to "Mei Fan",
            ),
        "character-shiori" to
            mapOf(
                "en" to "Shiori",
            ),
        "character-yachiyo" to
            mapOf(
                "en" to "Yachiyo",
            ),
        "character-stella" to
            mapOf(
                "en" to "Stella",
            ),
        "character-shiro" to
            mapOf(
                "en" to "Shiro",
            ),
        "character-ryoko" to
            mapOf(
                "en" to "Ryoko",
            ),
        "character-minku" to
            mapOf(
                "en" to "Minku",
            ),
        "character-kuina" to
            mapOf(
                "en" to "Kuina",
            ),
        "character-koharu" to
            mapOf(
                "en" to "Koharu",
            ),
        "character-suzu" to
            mapOf(
                "en" to "Suzu",
            ),
        "character-hisame" to
            mapOf(
                "en" to "Hisame",
            ),
        "character-sakura" to
            mapOf(
                "en" to "Sakura",
            ),
        "character-erika" to
            mapOf(
                "en" to "Erika",
            ),
        "character-gemie" to
            mapOf(
                "en" to "Gemini",
            ),
        "school-seisho" to
            mapOf(
                "en" to "Seisho",
            ),
        "school-rinmeikan" to
            mapOf(
                "en" to "Rinmeikan",
            ),
        "school-frontier" to
            mapOf(
                "en" to "Frontier",
            ),
        "school-siegfeld" to
            mapOf(
                "en" to "Siegfeld",
            ),
        "school-seiran" to
            mapOf(
                "en" to "Seiran",
            ),
        "school-none" to
            mapOf(
                "en" to "",
            ),
    )
