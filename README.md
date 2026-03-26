# Armor Liner

Armor Liner is a small standalone NeoForge mod for Minecraft `1.21.1`.
It extracts the armor lining feature from `Days go by` into its own project so players can use this mechanic without the rest of that mod.

## Features

- Adds `Liner Snips`
- Lets you apply warming liners with Tough As Nails wool armor pieces
- Lets you apply cooling liners with Tough As Nails leaf armor pieces
- Lets you remove liners and recover the liner item
- Shows the current liner type in armor tooltips
- Applies temperature changes with Tough As Nails-style armor scaling instead of a flat per-piece bonus

## Requirements

- Minecraft `1.21.1`
- NeoForge `21.1.x`
- Java `21`
- Tough As Nails for NeoForge `1.21.1`
- GlitchCore for NeoForge `1.21.1`

## Recipes

- `Liner Snips`: `Shears` + `Iron Ingot` in a shapeless recipe
- Apply a liner: combine one unlined armor piece with the matching Tough As Nails wool or leaf armor piece
- Remove a liner: combine lined armor with `Liner Snips`

## Development

Local Gradle runs use runtime dependencies so `runClient` and `runServer` will download the required jars automatically.

- `GlitchCore-neoforge:1.21.1-2.1.0.0`
- `ToughAsNails-neoforge:1.21.1-10.1.0.13`

Public releases on Modrinth or CurseForge should list `Tough As Nails` and `GlitchCore` as dependencies as well.

## Build

```powershell
.\gradlew.bat build
```

## Run Client

```powershell
.\gradlew.bat runClient
```

## Notes

- This repository is the standalone release target for the armor lining feature.
- The implementation started as a direct extraction from `Days go by`, then was trimmed for standalone use.
