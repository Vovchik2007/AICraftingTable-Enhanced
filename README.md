# AI Crafting Table Enhanced

Enhanced development fork of [AI Crafting Table](https://github.com/AlexLee1235/AICraftingTable).

- Minecraft: **1.20.1**
- Loader: **Forge 47**
- Java: **17**

## Implemented behavior extensions

AI-generated item metadata is translated into a small allow-listed behavior descriptor. The mod does not execute AI-generated Java or scripts.

### Throwable generated items

The item generator can request `behavior: "throw_projectile"` with one of these effects:

- `cloud` — creates a temporary in-world cloud entity at impact.
- `flame` — flame particles at impact.
- `sparkle` — end-rod particles at impact.
- `none` — ordinary snowball-like projectile.

Generated throwable items launch a real projectile and consume one item outside Creative mode.

### Creature-spawning items

The item generator can request `behavior: "spawn_entity"`. The supported entity allow-list is:

`pig`, `cow`, `sheep`, `chicken`, `wolf`, `cat`, `horse`, `rabbit`, `fox`, `bee`, `allay`, `iron_golem`, `snow_golem`, `villager`.

These items create the corresponding real vanilla entity and consume one item outside Creative mode. Unsupported entity names safely fall back to a normal generated item.

## Build

The GitHub Actions workflow builds with Java 17 and Gradle 8.8. Open the **Actions** tab to inspect the latest build and download the `aicraftingtable-forge-1.20.1` artifact after a successful run.

## Current limitations

This is an incremental enhancement, not an unrestricted natural-language-to-anything engine. Generated items currently support the behaviors listed above. Custom mobs, arbitrary aircraft/rockets, multiblock machines, power networks, fuel systems, heat simulation, and production chains still require dedicated registered game systems and are not yet implemented.

A successful Gradle build verifies compilation and artifact creation; it does not replace in-game testing on a Forge 1.20.1 client/server.
