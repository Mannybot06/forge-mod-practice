package net.mannybot06.functionmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class DazedEffect extends MobEffect {

    private int effectDuration;

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        this.changeCamera(livingEntity);
    }

    private void changeCamera(LivingEntity livingEntity) {
            double t = livingEntity.level().getGameTime();

            double wobbleYaw = Math.sin(t * 0.1) * Math.PI * 0.5;
            double wobblePitch = Math.cos(t * 0.13) * Math.PI * 0.35;

            double randomYaw = livingEntity.level().getRandom().nextGaussian() * Math.PI * 0.3;
            double randomPitch = livingEntity.level().getRandom().nextGaussian() * Math.PI * 0.3;

            livingEntity.setYRot((float)(livingEntity.getYRot() + wobbleYaw + randomYaw));
            livingEntity.setXRot((float)(livingEntity.getXRot() + wobblePitch + randomPitch));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        this.effectDuration = duration;
        return true;
    }

    public DazedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

}