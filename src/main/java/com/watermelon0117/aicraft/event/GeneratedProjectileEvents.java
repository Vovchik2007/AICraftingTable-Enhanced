package com.watermelon0117.aicraft.event;

import com.watermelon0117.aicraft.AICraftingTable;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Visual impact effects for generated projectiles; effect identifiers are allow-listed. */
@Mod.EventBusSubscriber(modid = AICraftingTable.MODID)
public final class GeneratedProjectileEvents {
    private GeneratedProjectileEvents() {}

    @SubscribeEvent
    public static void onImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof Snowball snowball)) return;
        if (snowball.getOwner() == null) return;
        var data = snowball.getItem().getTagElement("aicraft");
        if (data == null || !"throw_projectile".equals(data.getString("behavior"))) return;
        if (!(snowball.level() instanceof ServerLevel level)) return;
        var pos = snowball.position();
        switch (data.getString("projectileEffect")) {
            case "cloud" -> level.sendParticles(ParticleTypes.CLOUD, pos.x, pos.y, pos.z, 28, 0.45, 0.35, 0.45, 0.03);
            case "flame" -> level.sendParticles(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 20, 0.35, 0.25, 0.35, 0.02);
            case "sparkle" -> level.sendParticles(ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 18, 0.35, 0.35, 0.35, 0.03);
            default -> { }
        }
    }
}
