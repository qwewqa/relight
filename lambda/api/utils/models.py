from typing import Optional

from pydantic import BaseModel, constr, conlist, Field


class PlayerLoadoutParameters(BaseModel):
    name: constr(max_length=100)
    dress: constr(max_length=100)
    memoir: constr(max_length=100)
    memoirLevel: int = 1
    memoirLimitBreak: int = 4
    unitSkillLevel: int
    level: int = 80
    rarity: int = 6
    friendship: int = 30
    rank: int = 9
    rankPanelPattern: conlist(bool, min_items=8, max_items=8) = Field(default_factory=lambda: [True] * 8)
    remake: int = 0
    remakeSkill: constr(max_length=100)


class CreatePresetsRequest(BaseModel):
    name: Optional[constr(max_length=100)] = None
    presets: conlist(PlayerLoadoutParameters, min_items=1, max_items=1000)
