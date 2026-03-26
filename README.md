# Armor Liner

`Armor Liner` is a standalone NeoForge 1.21.1 mod extracted from `Days-go-by-1.21.1-Neoforge`.
It keeps only the armor lining feature so players can use this mechanic without the rest of that project.

## What it adds

- `Liner Snips`
- Applying warming liners to armor with Tough As Nails wool armor pieces
- Applying cooling liners to armor with Tough As Nails leaf armor pieces
- Removing liners and returning the corresponding liner item
- Tooltip text showing the current liner on an armor piece
- Tough As Nails temperature modifier integration based on equipped liners

## Requirements

- Minecraft `1.21.1`
- NeoForge `21.1.x`
- Java `21`
- Tough As Nails for NeoForge `1.21.1`

This standalone mod is intended to run together with Tough As Nails. The mod metadata marks Tough As Nails as a required dependency.

## Runtime dependency download

For development runs started through Gradle, this project is configured with `localRuntime` dependencies:

- `GlitchCore-neoforge:1.21.1-2.1.0.0`
- `ToughAsNails-neoforge:1.21.1-10.1.0.13`

That means `runClient` / `runServer` will download the required jars automatically into the Gradle cache.

If you plan to publish the built jar to CurseForge or Modrinth, launcher-side auto-download of dependencies is controlled by the platform's project metadata, not only by Gradle or `neoforge.mods.toml`.

## Recipes

- Craft `Liner Snips` with two iron ingots in a diagonal pattern
- Combine an unlined armor piece with a matching Tough As Nails liner armor item to apply a liner
- Combine lined armor with `Liner Snips` to remove the liner and recover it

## Development

Build:

```powershell
.\gradlew.bat build
```

Run client:

```powershell
.\gradlew.bat runClient
```

## Notes

- The implementation intentionally stays close to the original `Days go by` subset, but is renamed and trimmed for standalone use.
- Tough As Nails integration is loaded through reflection to keep compile-time coupling low while still enabling runtime behavior.
