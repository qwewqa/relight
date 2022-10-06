from typing import Optional

from pydantic import BaseModel, constr, conlist, Field, BaseSettings, conint


class Settings(BaseSettings):
    token_issuer_url: str
    jwks_url: str
    audience: str

    class Config:
        env_file = ".env"


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
    remakeSkill: Optional[constr(max_length=100)] = None
    accessory: Optional[constr(max_length=100)] = None
    accessoryLevel: int = 100
    accessoryLimitBreak: int = 10


class CreatePresetsRequest(BaseModel):
    name: Optional[constr(max_length=100)] = None
    presets: conlist(PlayerLoadoutParameters, min_items=1, max_items=1000)


class SongEffectParameter(BaseModel):
    name: constr(max_length=100)
    value: int
    conditions: conlist(conlist(constr(max_length=50), max_items=20), max_items=2)


class SongParameters(BaseModel):
    activeEffects: conlist(SongEffectParameter) = Field(default_factory=lambda: [])
    passiveEffect: Optional[SongEffectParameter] = None


class StrategyParameter(BaseModel):
    type: constr(max_length=100)
    value: constr(max_length=50000)


class SimulationParameters(BaseModel):
    maxTurns: int = 3
    maxIterations: int = 100000
    team: conlist(PlayerLoadoutParameters, max_items=25)
    guest: Optional[PlayerLoadoutParameters] = None
    song: SongParameters = None
    strategy: StrategyParameter = Field(default_factor=lambda: StrategyParameter(type="Simple", value=""))
    bossStrategy: Optional[StrategyParameter] = None
    boss: constr(max_length=100)
    bossHp: Optional[int] = None
    additionalEventBonus: int = 0
    eventMultiplier: int = 100
    seed: int = 0


class SetupData(BaseModel):
    name: constr(max_length=100)
    parameters: SimulationParameters


class CreateSetupsRequest(BaseModel):
    name: Optional[constr(max_length=100)] = None
    setups: conlist(SetupData, min_items=1, max_items=100)


class CreateSetupRequest(BaseModel):
    parameters: SimulationParameters
    preview_image: constr(max_length=8_000_000)
    preview_width: conint(ge=16, le=5000)
    preview_height: conint(ge=16, le=5000)
