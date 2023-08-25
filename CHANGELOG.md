# v0.0.1

- Initial full release

# v0.1.0

- Stage effects implemented
- Strategy editor now automatically resizes
- Visual adjustments
- Addded a bar graph to results
- Simple strategy now properly gives an error when a climax act is used without it being ready
- Exports now support multiline strings
- Fortitude and revive now implemented
- Added a spread `...` operator. List addition using the `+` operator now supported
- The `list` function has been renamed to `listOf`
- Results now show simulation runtime. Simulation parameters and results are now shown in the server log
- Devil CX now exists
- Fixed an error logging results in native images
- Fixed a bug where dexterity debuffs increased dexterity
- Minor changes to logging
- Results now show tile numbers for victories and wipes
- Bar graph height now scales with the number of bars
- Fix error when a daze hit leads to exit
- Minor improvement to client performance and binary size
- Fixed incorrect hands when a stage girl exited in complete strategy
- Added missing boss resists and abnormal guard
- Shutdown button now shows a toast message indicating success
- The boss can now be directly referenced as `boss` in complete strategy
- Victory and wipe totals are now displayed in results
- Fixed issues with climax act cards during the 2nd climax turn
- Fixed TR12 Tower
- Fixed turn counts for some applied debuffs, including Judgement's mark
- Honda 9.5 added
- Version is now displayed in the client
- Added an empty memoir
- Added the `tag(args...)` function to complete strategy. Results now have an hierarchical tag structure. Results graph
  colors are now less bright
- Added a `finally {}` block to complete strategy which runs after a play has ended
- Fixed an issue where bosses received the 10% damage boost during climax turns
- Added a proper stop resistance passive for Stage Girl Nana and fixed her fortitude. Baby Stage Girl Hikari added
- Added boss hp override and event multiplier
- Added support for a guest
- Fix abnormal guard being dispellable
- Bosses now automatically include event bonus
- Removed the event bonus field
- Actor options now have drag & drop handles as well as individual delete buttons
- Fixed bug where imports would not remove the first existing actor
- Default max iterations when importing is now 100000
- Added an extra event bonus box for use with seesaw chest event bonus
- Added end and wipe margin graphs
- Added searchable tags displayed next to memoir names
- Fixed devil's act3 being 2 ap instead of 3 ap
- Added access to queued acts in the previous turn via `lastTeamActs` and `lastEnemyActs` in complete strategy
- Added access to actor buffs with an `Actor.buffs(name)` function
- Boss strategies may now be overridden
- Added the ability to select custom dress levels, rarity, remake level, bond level, rank, and rank panel pattern
- Fixed a bug with buff durations
- Fixed TR11 Yachiyo moveset
- Removed the shutdown button
- Added Toast Messages

# v0.2.0

- Added an online link [https://relive-sim.qwewqa.xyz/](https://relive-sim.qwewqa.xyz/).
- Downloads can now be found in the GitHub releases page

# v0.3.0

- Added basic regression tests
- Added zh_hant support for new actor options

# v0.4.0

- Added generated memoir data
- Added Sakura Taisen Dresses and Bosses
- Added a donate button

# v0.5.0

- Added cutins & Sun by Savivo
- Fixed held card not being cleared on actor exit

# v0.5.1

- Now guest passives auto effects are applied on start
- Fixed brilliance not being set to 0 after climax

# v0.6.1

- Added reverse tower
- Fixed stage effect activation for cutins
- Added count method to lists in complete strategies by Pointy
- Added TR12 And TR14 bosses by Savivo

# v0.7.0

- Skipped release

# v0.8.0

- Updated TR14 bosses and added TR15 bosses by Savivo
- Fixed Ana Junna to use Pride instead of Daze by Savivo
- Added tanks by Savivo
- Added the Interactive sim mode
- Added icons to log
- Added icons to selects

# v0.9.0

- Versioning changes

# v0.10.0

- Log output is now color coded

# v0.11.0

- Toasts are now less obtrusive
- Added command shortcut links to interactive logs

# v0.11.1

- New dresses and memoirs by Savivo

# v0.11.2

- Fixed Seisho Condition on Hunting Nana Autos by Savivo

# v0.11.3

- Fixed Seisho condition on autoskills by Savivo
- Fixed Stage Girl Michiru's team HP autoskill by Savivo
- Fixed hand sorting in complete strategy by Pointy

# v0.12.0

- Skipped release

# v0.13.0

- TR16 additions by Savivo

# v0.13.1

- Added Stage Girl Fumi and For Our Special Place

# v0.14.0

- Bug fix by Pointy
- Added invincibility by Pointy

# v0.15.1

- Added Officer RUI and Cerberus Ichie by Savivo

# v0.16.0

- Made Stage Girl Futaba selectable by Savivo
- Added TR17 bosses by Savivo
- Fixes by Pointy

# v0.16.1

- Fixed TR17 boss movesets by Pointy
- Added Stage Girl Akira and Soul Revue Maya by Pointy

# v0.16.2

- Fixes to Stage Girl Akira by Savivo
- Fixed 50% HP/Defense US by Savivo

# v0.16.3

- Fixed Stage Girl Fumi and Stage Girl Junna by chihiro

# v0.17.0

- TR18 Bosses added
- Fixed stage effect AP down
- Fixed brilliance passives going before Maya's brilliance buff depending on agility

# v0.18.0

- Fixed act cards
- Added hp bars to interactive via the `bars` command

# v0.18.1

- Added more wind dresses

# v0.18.2

- Fixed unresponsive JS interactive sim
- Bars now animate

# v0.19.0

- Added the `shares` command to interactive

# v0.19.1

- Minor additions
- Interactive images are now larger

# v0.19.2

- TR20 additions by Savivo

# v0.19.3

- Bug fixes by Savivo

# v0.19.4

- Skipped release

# v0.19.5

- Ace now applies pride
- Fixed some damage overflow issues

# v0.19.6

- Bars is now enabled by default

# v0.19.7

- Stage Girl Aruru Added

# v0.20.0

- Actor presets added

# v0.20.1

- Preset improvements

# v0.20.2

- Preset improvements

# v0.20.3

- Sim urls can now be imported

# v0.20.4

- Changing remake and memoir unbind will update level and bond automatically

# v0.20.5

- Added a sort button in the lower right of the actor section that sorts by position

# v0.20.6

- Added assert statements to simple strategies. Supported statements are currently assert actor alive, assert actor
  dead, assert actor charged, and assert actor uncharged. More asserts, including ones with operators, may be added in
  the future.
- The export interactive command now has an export strict option which adds additional assert statements.
- Whitespace in actor names is now automatically replaced by underscores when starting a simulation.

# v0.21.0

- Remake skills added
- Damage formula for damage dealt up updated

# v0.21.1

- The remake skill select is now disabled when remake level is less than 4

# v0.21.2

- A copy of the active remake skill description is now displayed on small screens below the select
- Selects are now easier to use on small screens

# v0.21.3

- Fixed HP regen remake skill

# v0.21.4

- New stage girls added by Savivo

# v0.21.5

- Added TR21 bosses
- Changed boss order

# v0.21.6

- Birthday Claudine added by Mikayla

# v0.22.0

- New tabbed layout for actor settings

# v0.22.1

- Improved actor tab layout
- Other UI improvements

# v0.22.2

- Remake and memoir unbind are now radio buttons
- Various actor setup improvements
- Romeo Karen and Eurydice Yuyuko added by Wave

# v0.22.3

- Actor setup improvements

# v0.22.4

- New preset dialogs
- Load preset button added for adding actors

# v0.23.0

- Added preset sharing/import

# v0.23.1

- When loading a preset with no memoir, the current memoir, memoir level, and memoir unbind is now retained.

# v0.23.2

- Added selection menu when sharing and importing presets

# v0.23.3

- Added preset share urls

# v0.23.4

- Adjusted the size of select icons
- Added shortcut buttons to interactive

# v0.23.5

- Visual fixes
- Improve responsiveness when adding an actor

# v0.23.6

- Improved sort actor performance
- Responsiveness adjustments when adding an actor

# v0.23.7

- Indicate whether presets are new, overriding an existing one, or redundant with an existing one when importing

# v0.23.8

- Added auto name button

# v0.23.9

- The interactive input is now smaller
- Reduced the gap between bars
- Migrated to Kotlin 1.7.10

# v0.23.10

- Fixed JS strategy parsing

# v0.23.11

- Disabled tab filter when no tabs are selected
- Fixed PWA support

# v0.23.12

- Improved UI performance in some browsers

# v0.23.13

- Fixed issues with remake skill select

# v0.23.14

- Improved select picker update performance

# v0.23.15

- Fixed seed command being replayed incorrectly

# v0.23.16

- Minor fixes

# v0.23.17

- Added back pwa-update

# v0.23.18

- New stage girls and memoirs added by Mikayla

# v0.23.19

- Removed local simulator support from browser
- Song effects are now displayed in the accordion button
- Added clear button to song effect conditions

# v0.23.20

- Fixed pwa-update prompt z-index

# v0.24.0

- Added a login system

# v0.24.1

- Fixed log out url
- Current setup is persisted when logging in/out

# v0.24.2

- Added cloud sync

# v0.24.3

- Added toast when sync begins
- Sync button no longer responds when syncing is already in progress

# v0.24.4

- Fixed accordion button dropdown arrow display
- Fixed current setup not being persisted when logging in

# v0.25.0

- Added setup saves and sharing
- Pressing enter in the name input for a new preset/setup now saves
- Several modals now automatically set relevant input focus when opened

# v0.25.1

- Deleted actor settings elements are now cached

# v0.25.2

- Selectpicker fixes

# v0.25.3

- Adjustment to tab sizes
- More compact selection modals

# v0.25.4

- TR22 bosses added by Mikayla

# v0.25.5

- Added missing multiple CA to Collection Yachiyo

# v0.25.6

- Changed undo shortcut button icon
- Added tooltip text to shortcut buttons on desktop
- Fixed loading of some select menus from url

# v0.25.7

- Added new dresses and memoirs - Savivo
- Draw and discard piles are now exposed in complete strategies - Pointy

# v0.25.8

- Added snow slap memoir
- Added missing images

# v0.25.9

- Fixed Birthday Suzu auto AP down duration - Savivo
- Added a plain damage dealt up song effect

# v0.26.0

- Added new dresses - Savivo
- Added support for accessories

# v0.26.1

- Added zero option to accessory unbind

# v0.26.2

- Fixed support for new Seigfeld characters

# v0.26.3

- Fixed issue with accessory limit break

# v0.26.4

- Fixed selects not updating after language change
- Updated attribute damage taken down remake skill icons
- Bday Mei Fan added by Wave

# v0.26.5

- Fixed ap down and ap2 down stacking behavior
- All failed assertions on the same turn are now reported
- Added comments beginning with # to simple strategies

# v0.26.6

- Searchable selects now support multiple search teams separated by commas
- Dresses now have searchable tags and subtexts
- Subtexts are now shown on all display sizes

# v0.26.7

- Fixed tr13 Emperor Akira diff4 using the diff3 moveset

# v0.26.8

- Princess Karen and new memoirs added by Savivo
- Export strict now includes comments on holds an discards

# v0.27.0

- TR23 Bosses added by Mikayla
- Added damage result graphs
- Result graphs are now smoothed line graphs using kernel density estimation
- Multiple movesets can now be included in simple strategy using Moveset "name" <weight>: lines

# v0.27.1

- Added box plot result graphs
- Fixed issues with result graphs having zero height
- Simple strategies with all movesets with the default weight now select movesets deterministically based on iteration
  number

# v0.27.2

- Improved stage effect performance

# v0.28.0

- Substantial performance improvements

# v0.28.1

- Multiple acts can now be queued in one interactive argument
- Fixed tr23 Mafia Maya's attribute

# v0.28.2

- Substantial performance improvements
- Reduced delay before initial simulation results appear
- Updated images

# v0.28.3

- Fixed error in info command

# v0.28.4

- Improved interactive performance
- Multiple commands can now be pasted into the interactive command prompt

# v0.28.5

- Added CHANGELOG.md to repo
- Fixed accessory label not being hidden in actor setup

# v0.28.6

- Minor performance improvements

# v0.29.0

- Added a team image export button
- Added share buttons and short share links with image previews

# v0.29.1

- Adjusted the styling of team images

# v0.29.2

- Added a team cost display
- Dresses and memoirs can now be searched by cost
- Fixed Agony not preventing action
- Fixed buffs with irrelevant values displaying their value

# v0.29.3

- Adjusted the size of remake skill text and icons in team images
- Adjusted the content of remake skill text in team images

# v0.30.0

- Added result save/load functionality
- Moved result details into a collapsible section

# v0.30.1

- New dresses added by Pointy

# v0.31.0

- Added syntax highlighting for simple strategies
- Added code folding for simple strategies
- Added keyboard shortcuts for simple strategy code folding (Ctrl-Q) and commenting (Ctrl-/)

# v0.31.1

- Added support toggle and indicators

# v0.31.2

- Fixed support sorting
- Added status command button

# v0.32.0

- Added new interactive interface
- Interactive console is now hidden by default

# v0.32.1

- Adjusted the appearance of queued interactive acts and memoirs
- Other visual adjustments
- Added an error message display to the interactive UI

# v0.32.2

- The current tile is now indicated in the interactive UI

# v0.32.3

- Adjusted when the service worker is loaded

# v0.32.4

- Auto name now sets supports
- Removed the restart button from interactive
- Added seek back and forward buttons, and a redo button to interactive

# v0.33.0

- Fixed names not appearing in logs
- Added dress icons to interactive bars
- Added buffs display to interactive
- Simplified displayed version numbers

# v0.33.1

- Fixed negative countable buff display in interactive
- Increased the maximum displayed buffs in interactive

# v0.33.2

- Reduced the maximum interactive UI size
- Added stage effect display to interactive

# v0.33.3

- Interactive UI sizing adjustments

# v0.33.4

- Fix interactive UI empty climax button appearance on some display sizes

# v0.33.5

- Added indicators for actors in climax to interactive UI
- Added navigation buttons to the interactive log

# v0.33.6

- Fixed damage dealt up buff icon
- Added spacing below the interactive ui for mobile devices

# v0.33.7

- Moved interactive navigation buttons in line with turns
- Interactive ui size adjustments

# v0.33.8

- Migrated strategy editors to CodeMirror 6
- Fixed issues with mobile editing

# v0.33.9

- Supports are now inferred when none are set for interactive

# v0.33.10

- Team images are now uploaded upon share

# v0.34.0

- Added the ability to filter for logs of different results

# v0.34.1

- Fixed icons for "we are on the stage" stage effects
- Added a new interface for navigating between result logs

# v0.34.2

- Added an alternate team image format

# v0.34.3

- Updated support indicator in tabs and team images

# v0.34.4

- Add seed button to interactive UI

# v0.34.5

- Added Discord server link

# v0.34.6

- New TR bosses added by Mikayla

# v0.34.7

- New dresses added by Savivo
- Stage Girl Collection accessory added

# v0.34.8

- New TR bosses added by Mikayla

# v0.34.9

- Fixed effective damage up blessing turn count by Mikayla

# v0.34.10

- Made blessings only activate one at a time per type to align with game behavior

# v0.35.0

- Added dexterity counters to interactive
- Added damage dealt to the interactive boss hp bar

# v0.35.1

- Added an auto queue button and command to interactive
- Fix an occasional issue with interactive logs
- Add support for importing share urls
- Fixed TR25 Komachi HP by Mikayla

# v0.35.2

- Added copy, paste, and duplicate buttons for actors

# v0.35.3

- Added keyboard+mouse shortcuts for actor setup

# v0.35.4

- Hades Rui and new memoirs added by Savivo

# v0.35.5

- Future Stage Girl Shiro added by Ini

# v0.35.6

- Sage Junna added by Ini
- Updated stats for 2022 Birthday Cards

# v0.35.7

- Fixed Sage Junna not being available

# v0.35.8

- Added new memoirs
- Added collapse/expand all buttons to the strategy editor

# v0.35.9

- Added act images button

# v0.35.10

- Added new dresses and memoirs
- Added TR26 bosses

# v0.35.11

- Fixed missing TR26 Hanged Man boss

# v0.35.12

- Fixed wrong TR26 boss
- Fixed Persephone's pride autoskill

# v0.35.13

- Fixed Sagittarius Junna's climax act

# v0.35.14

- Fixed Sagittarius Junna's boost in TR26 Emperor

# v0.35.15

- Tentatively added elemental accessories

# v0.35.16

- Added 2023 TR26 bosses

# v0.35.17

- Reduced image file sizes

# v0.35.18

- Fixed outdated image urls

# v0.35.19

- Fixed Seiran character targeting RB skills
- Fixed Seigfried CA not being continuous

# v0.35.20

- Fixed Celestial Highlights SE icon
- Attempted to address iOS sizing issues

# v0.35.21

- New dresses and memoirs added by Mikayla
- Added karth links to actor options

# v0.35.22

- New dresses and memoirs added by Mikayla

# v0.35.23

- Fixed hope applied before hit not being consumed when there is no initial hope

# v0.35.24

- New dresses added by chihiro

# v0.35.25

- Fixed error in some circumstances when bosses die
- Performance adjustments

# v0.35.26

- Fixed Benzaiten not applying two blessings by Mikayla

# v0.35.27

- New bosses added by Mikayla

# v0.35.28

- New dresses, memoirs, and accessories added by Savivo

# v0.35.29

- Placeholder encore cards added by Savivo

# v0.36.0

- Performance improvements
- New dresses, memoirs, and bosses added by Mikayla

# v0.36.1

- Fix to brilliance regen stage effects by Mikayla

# v0.36.2

- Updates to buffs
- Fixed normal super reflect persisting after it expires
- Fixed Red Duke Richelieu's boost
- Added missing act card images

# v0.36.3

- Performance improvements

# v0.36.4

- Fixed cutin initial cooldown reduction

# v0.36.5

- Made climax act up not stack
- Fixed some issues with dexterity display
- Fixed some bosses taking reduced damage from sun or star
- Buff display is now animated when a high number of buffs are present
- Fixed song act power up

# v0.36.6
- Fixed Cordelia Aruru's climax act damage by Mikayla

# v1.0.0
- Rewrite of all playable dresses, memoirs, accessories, and associated mechanics
- Minor interface changes

# v1.0.1
- Improved loading and sim initialization time

# v1.0.2
- Implemented more features

# v1.0.3
- Fixed errors on some dresses with stage effect dispel

# v1.0.4
- Implemented more features
- Minor fixes
- Added icons to boss select
- Increased maximum stats
- Adjusted some log strings

# v1.0.5
- Implemented more features
- Added new dresses and memoirs

# v1.0.6
- Added Cheshire Ichie's missing boost

# v1.0.7
- Fixed birthday memoir targets

# v1.0.8
- Fixed rear targeting
- Performance and stability adjustments

# v1.0.9
- TR29 bosses added by Mikayla
- TR29 bosses have 50% damage taken reduction
- Accessories now default to lv50 ub0
- Added new dresses and memoirs
- Fixed cheer damage calculation (negligible impact)

# v1.0.10
- Added Encore Klaus Akira
- Fixed overwhelm not being consumed

# v1.1.0
- Improved performance of subsequent simulations
- Added boss element override

# v1.1.1
- Added missing bonus to Thumbelina Lalafin
- Added Baumkuchen Maya
- Added event bonus display
- Visual adjustments
- Hid options by default

# v1.1.2
- Added new dresses and memoirs

# v1.1.3
- Fixed cutin cost going to zero after reduction when it should not
- Added icons to the boss select
- Removed dresses with cost below 15 and rarity 2 memoirs
- Performance improvements

# v1.1.4
- Made blessings consumed in order of application
- Minor performance improvements
- Improved appearance of support radio buttons

# v1.1.5
- TR30 bosses added by chihiro

# v1.1.6
- Fixed TR30 Shizuha difficulty 4 HP
- Improve dropdown load performance

# v1.2.0
- Added live updating damage estimate to interactive
- Fixed missing 10% damage received up effect for weaken

# v1.2.1
- Fix live damage estimates for weaken

# v1.2.2
- Added new dresses and memoirs
- Limited live damage estimate update frequency

# v1.3.0
- New tabbed layout
- Overscroll in selects is now contained
- Improved select performance

# v1.3.1
- Moved strategy options into simulate tab
- Changed default iteration count to 10000

# v1.3.2
- Added favicon
- Added Encore Fu MeiFan
- Moved actor save and load buttons to bottom right
- Interactive now automatically reloads if it failed to start previously

# v1.4.0
- New song ui
- Added support for song awakening
- Added new dresses and memoirs

# v1.4.1
- Added placeholder icons for songs and song effects
- Fixed some localization issues with the song ui

# v1.4.2
- Updated empty remake skill icon
- Made fixed value passive song effects distinguishable from percentage based ones

# v1.4.3
- Updated some label text
- Changed song descriptions to show awakening skills
- Song passives are no longer filtered by the selected song
- Selecting a song passive now updates the song

# v1.4.4
- Changed song descriptions to use icons for awakening skills
- Updated the appearance of song awakening skills
- Updated the appearance of dropdown toggles

# v1.4.5
- Added song name to share images
- Made song awakening effect values dropdowns

# v1.4.6
- Removed presets button from actor top bar
- Minor visual adjustments
- Fixed awakening effect values not being cleared when song changes
- Made bosses searchable by school, attribute, and damage type

# v1.4.7
- Added tr31 bosses

# v1.4.8
- Adjusted passive song skill names
- Added units to awakening song effect descriptions
- Added clear button to awakened song select

# v1.4.9
- Improved load performance
- Improved api performance

# v1.4.10
- Share modal now opens immediately and displays a loading indicator
- Made result plots non-interactive by default

# v1.4.11
- Made tooltips show in non-interactive plots

# v1.4.12
- Added new dresses and memoirs
- Set a maximum height for dropdown menus

# v1.4.13
- Load time improvements
- Adjusted interactive buff display order
- Clicking on an actor in the status section in interactive now opens the respective Karth page
- Fixed some missing text

# v1.4.14
- Fixed issue with opening Karth pages via interactive
- Updated data for WW
- Improved scrolling over plots on mobile

# v1.4.15
- Added CA images to act icons
- Added a damage share bar toggle to interactive
- Removed the second share button
- Minor tweaks

# v1.5.0
- Added per-act damage previews to interactive
- Improved loading performance

# v1.5.1
- Tweaked styling of timeline damage overlays
- Added percentages to damage shares

# v1.5.2
- Performance adjustments
- Visual adjustments

# v1.5.3
- Load time improvements

# v1.5.4
- Added indicator icon to climax acts in interactive
- Visual adjustments

# v1.5.5
- Removed accounts, setups, and presets

# v1.5.6
- Fixed version not displaying on load
- Adjusted automatic names
- Blank names are now automatically filled when starting interactive

# v1.5.7
- Fixed issue with resetting actor options
- Load time improvements

# v1.5.8
- Share images are now jpgs
- Load time improvements

# v1.5.9
- Switched to using webp for image assets

# v1.5.10
- Improved service worker precache speed

# v1.5.11
- Fixed damage being limited to around 2.1 billion per hit
- Adjusted formatting of some numbers
- Minor cleanup

# v1.5.12
- Adjusted formatting of some small numbers
- Updated sharing domain to relight.to

# v1.5.13
- Updated data
- Share urls are now shorter

# v1.5.14
- Adjusted select styling
- Vertical scrollbar is now always active

# v1.5.15
- Adjusted select styling

# v1.5.16
- Adjusted select behavior

# v1.5.17
- Song effect inputs are now blank by default

# v1.5.18
- Added pride month themes
- Preferences are now persisted

# v1.5.19
- Fixed themed checkmark appearance on Chrome

# v1.6.0
- Added an info tab
- Added chibis to share preview images, more to come soon
- Added some more pride month themes
- Fixed Siegfeld rear position critical up song passive

# v1.6.1
- Added new girls and memoirs
- TR bosses added by chihiro
- Added tab name input
- Added new flags

# v1.6.2
- Added new girls and memoirs
- Added new flags
- Temporarily disabled debuff passives

# v1.6.3
- Fixed error when actors exited

# v1.6.4
- Added new girls and memoirs
- Added new flags
- Fixed boss element override not being imported
- TR33 bosses added by chihiro

# v1.6.5
- Increased TR32 boss agility
- Added birthday Maya's TR boost

# v1.6.6
- Updated WW data

# v1.6.7
- Added build info and stage use to bottom of page
- Added new flags

# v1.6.8
- Added additional background update check
- Version now links to clear cache page
- Reduced spacing to right of Discord link button

# v1.6.9
- Version check now runs continuously in the background

# v1.6.10
- Added new girls and memoirs

# v1.6.11
- Added new flags
- Added damage factors to log
- Added new girls and memoirs

# v1.6.12
- Updated Witch Shizuha's amp
- Added missing bonus for Witch Shizuha

# v1.6.13
- Fixed boss attribute override not working on bulk sims

# v1.6.14
- Added new girls and memoirs
